package me.escoffier.quarkus.coffeeshop;

import com.systemcraftsman.demo.coffeeshop.model.Barista;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Path("/barista")
@Produces(MediaType.APPLICATION_JSON)
public class BaristaResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaristaResource.class);

    private ExecutorService queue = Executors.newSingleThreadExecutor();

    @Inject
    private Barista barista;

    @POST
    public CompletionStage<Beverage> process(Order order) {
        return CompletableFuture.supplyAsync(() -> {
            Beverage coffee = prepare(order);
            LOGGER.info("Order {} for {} is ready", order.getProduct(), order.getName());
            return coffee;
        }, queue);
    }

    Beverage prepare(Order order) {
        int delay = getPreparationTime();
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return new Beverage(order, barista.getName());
    }

    private Random random = new Random();
    int getPreparationTime() {
        return random.nextInt(5) * 1000;
    }

}
