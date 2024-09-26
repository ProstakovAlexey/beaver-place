package alex.animal;

import alex.user.User;
import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.ObjectNotFoundException;

@ApplicationScoped
public class AnimalService {

    public Uni<Animal> findById(long id) {
        return Animal.<Animal>findById(id).onItem().ifNull().failWith(() -> new ObjectNotFoundException(id, "Animal"));
    }

    public Uni<List<Animal>> list() {
        return Animal.listAll();
    }


}
