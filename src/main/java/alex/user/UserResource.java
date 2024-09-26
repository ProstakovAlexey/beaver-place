package alex.user;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/user")
public class UserResource {
    private final UserService userService;

    @Inject
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GET()
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<List<User>> getAll() {
        return userService.list();
    }

    @GET()
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<User> get(@PathParam("id") long id) {
        return userService.findById(id);
    }

}
