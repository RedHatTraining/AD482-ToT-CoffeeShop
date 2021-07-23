package me.escoffier.quarkus.coffeeshop;

import io.smallrye.mutiny.Uni;
import me.escoffier.quarkus.coffeeshop.http.BaristaService;
import me.escoffier.quarkus.coffeeshop.model.Beverage;
import me.escoffier.quarkus.coffeeshop.model.BeverageState;
import me.escoffier.quarkus.coffeeshop.model.Order;
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
    public Uni<Beverage> http(Order order) {
        order.setOrderId(getId());
        return barista.order(order)
                .onItem().invoke(beverage -> beverage.setPreparationState(BeverageState.READY))
                .ifNoItem().after(Duration.ofMillis(1500)).fail()
                .onFailure().recoverWithItem(createFallbackBeverage(order));
    }

    private String getId() {
        return UUID.randomUUID().toString();
    }

    private Beverage createFallbackBeverage(Order order) {
        return new Beverage(order,"", BeverageState.FAILED);
    }
}
