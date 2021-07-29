package me.escoffier.quarkus.coffeeshop;

import com.systemcraftsman.demo.coffeeshop.model.Beverage;
import com.redhat.training.demo.coffeeshop.util.GenericUtil;
import io.smallrye.mutiny.Multi;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.reactivestreams.Publisher;

import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.Duration;

@Path("/queue")
public class BoardResource {

    @Inject
    @Channel("beverages")
    Multi<Beverage> beverageQueue;

    private final Jsonb json = JsonbBuilder.create();

    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public Publisher<String> getQueue() {
        return Multi.createBy().merging()
                .streams(
                        beverageQueue.map(GenericUtil::createDTOFromBeverage).map(json::toJson),
                        getPingStream()
                );
    }

    Multi<String> getPingStream() {
        return Multi.createFrom().ticks().every(Duration.ofSeconds(10))
                .onItem().transform(x -> "{}");
    }

}
