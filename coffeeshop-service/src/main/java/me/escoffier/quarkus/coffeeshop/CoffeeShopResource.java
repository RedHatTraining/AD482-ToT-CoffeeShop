package me.escoffier.quarkus.coffeeshop;

import com.redhat.training.demo.coffeeshop.dto.BeverageDTO;
import com.redhat.training.demo.coffeeshop.dto.OrderDTO;
import com.redhat.training.demo.coffeeshop.model.Beverage;
import com.redhat.training.demo.coffeeshop.model.BeverageState;
import com.redhat.training.demo.coffeeshop.model.Order;
import com.redhat.training.demo.coffeeshop.util.GenericUtil;
import io.smallrye.mutiny.Uni;
import me.escoffier.quarkus.coffeeshop.http.BaristaService;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class CoffeeShopResource {

    @Autowired
    @RestClient
    BaristaService barista;

    @PostMapping("/http")
    public Uni<BeverageDTO> http(OrderDTO orderDTO) {
        orderDTO.setOrderId(getId());
        return barista.order(orderDTO)
                .onItem().invoke(beverage -> beverage.setPreparationState(BeverageState.READY))
                .ifNoItem().after(Duration.ofMillis(1500)).fail()
                .onFailure().recoverWithItem(createFallbackBeverage(orderDTO));
    }

    // Orders emitter (orders)
    @Autowired
    @Channel("orders")
    Emitter<Order> orders;
    // Queue emitter (beverages)
    @Autowired
    @Channel("queue")
    Emitter<Beverage> beverages;

    @PostMapping("/messaging")
    public OrderDTO messaging(OrderDTO orderDTO) {
        orderDTO.setOrderId(getId());
        orderDTO.setHasMarshmallows(Boolean.TRUE);
        Order order = GenericUtil.createOrderFromDTO(orderDTO);
        beverages.send(createBeverageInQueue(order));
        orders.send(order);
        return orderDTO;
    }

    private String getId() {
        return UUID.randomUUID().toString();
    }

    private BeverageDTO createFallbackBeverage(OrderDTO orderDTO) {
        return new BeverageDTO(orderDTO.getProduct(), orderDTO.getName(), "", orderDTO.getOrderId(), orderDTO.getHasMarshmallows(), BeverageState.FAILED);
    }

    private Beverage createBeverageInQueue(Order order) {
        return new Beverage(order.getProduct(), order.getName(), "", order.getOrderId(), order.getHasMarshmallows(), BeverageState.IN_QUEUE);
    }

}
