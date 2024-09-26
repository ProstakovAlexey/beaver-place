package alex.place;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/place")
public class PlaceResource {
    private final PlaceService placeService;

    @Inject
    public PlaceResource(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GET()
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<List<Place>> getAll() {
        return placeService.list();
    }

    @GET()
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Place> get(@PathParam("id") long id) {
        return placeService.findById(id);
    }

}
