package alex.user;

import alex.role.Role;
import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.quarkus.hibernate.reactive.panache.common.runtime.ReactiveTransactional;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.ObjectNotFoundException;

@ApplicationScoped
public class UserService {

    public Uni<User> findById(long id) {
        return User.<User>findById(id).onItem().ifNull().failWith(() -> new ObjectNotFoundException(id, "User"));
    }

    public Uni<List<User>> list() {
        return User.listAll();
    }

    public Uni<List<User>> listByRole(Role role) {
        return User.list("role.id", role.id);
    }

    @WithTransaction
    public Uni<User> create(User user) {
        String salt = RandomStringUtils.insecure().nextGraph(10);
        user.salt = salt;
        user.password = BcryptUtil.bcryptHash(user.password + salt);
        return user.persistAndFlush();
    }

    @WithTransaction
    public Uni<User> update(User user) {
        return findById(user.id)
            .chain( u -> User.getSession())
            .chain(s -> s.merge(user));
    }
}
