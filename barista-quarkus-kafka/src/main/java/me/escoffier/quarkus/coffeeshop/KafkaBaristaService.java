package me.escoffier.quarkus.coffeeshop;

import com.systemcraftsman.demo.coffeeshop.model.Barista;
import com.systemcraftsman.demo.coffeeshop.model.Beverage;
import com.systemcraftsman.demo.coffeeshop.model.BeverageState;
import com.systemcraftsman.demo.coffeeshop.model.Order;
import io.smallrye.reactive.messaging.annotations.Blocking;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Random;

@ApplicationScoped
public class KafkaBaristaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaBaristaService.class);

    @Inject
    private Barista barista;

    @Incoming("orders")
    @Outgoing("queue")
    @Blocking
    public Beverage process(Order order) {
        return prepare(order);
    }

    Beverage prepare(Order order) {
        int delay = getPreparationTime();
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        LOGGER.info("Order {} for {} is ready", order.getProduct(), order.getName());
        return new Beverage(order.getProduct(), order.getName(), barista.getName(), order.getOrderId(), order.getHasMarshmallows(), BeverageState.READY);
    }

    private Random random = new Random();

    int getPreparationTime() {
        return random.nextInt(5) * 1000;
    }

}
