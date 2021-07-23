package me.escoffier.quarkus.coffeeshop;

import com.systemcraftsman.demo.coffeeshop.model.Barista;
import me.escoffier.quarkus.coffeeshop.model.Beverage;
import me.escoffier.quarkus.coffeeshop.model.BeverageState;
import me.escoffier.quarkus.coffeeshop.model.Order;
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

    // TODO: Prepare the order and publish it into the queue

    Beverage prepare(Order order) {
        int delay = getPreparationTime();
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        LOGGER.info("Order {} for {} is ready", order.getProduct(), order.getName());
        return new Beverage(order, barista.getName(), BeverageState.READY);
    }

    private Random random = new Random();

    int getPreparationTime() {
        return random.nextInt(5) * 1000;
    }

}
