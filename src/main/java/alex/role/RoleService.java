package alex.role;

import alex.animal.Animal;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import org.hibernate.ObjectNotFoundException;

@ApplicationScoped
public class RoleService {

    public Uni<Role> findById(long id) {
        return Role.<Role>findById(id).onItem().ifNull().failWith(() -> new ObjectNotFoundException(id, "Role"));
    }

    public Uni<List<Role>> list() {
        return Role.listAll();
    }
}
