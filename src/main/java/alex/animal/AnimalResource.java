package alex.animal;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/animal")
public class AnimalResource {
    private final AnimalService animalService;

    @Inject
    public AnimalResource(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GET()
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<List<Animal>> getAll() {
        return animalService.list();
    }

    @GET()
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Animal> get(@PathParam("id") long id) {
        return animalService.findById(id);
    }

}
