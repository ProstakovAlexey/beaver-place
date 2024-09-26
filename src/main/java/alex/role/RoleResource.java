package alex.role;

import alex.role.Role;
import alex.role.RoleService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/role")
public class RoleResource {
    private final RoleService roleService;

    @Inject
    public RoleResource(RoleService roleService) {
        this.roleService = roleService;
    }

    @GET()
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<List<Role>> getAll() {
        return roleService.list();
    }

    @GET()
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Role> get(@PathParam("id") long id) {
        return roleService.findById(id);
    }

}
