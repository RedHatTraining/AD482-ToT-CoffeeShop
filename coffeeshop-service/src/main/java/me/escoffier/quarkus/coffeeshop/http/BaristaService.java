package me.escoffier.quarkus.coffeeshop.http;

import com.systemcraftsman.demo.coffeeshop.dto.BeverageDTO;
import com.systemcraftsman.demo.coffeeshop.dto.OrderDTO;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/barista")
@RegisterRestClient
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface BaristaService {

    @POST
    Uni<BeverageDTO> order(OrderDTO order);

}
