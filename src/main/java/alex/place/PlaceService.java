package alex.place;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import org.hibernate.ObjectNotFoundException;

@ApplicationScoped
public class PlaceService {

    public Uni<Place> findById(long id) {
        return Place.<Place>findById(id).onItem().ifNull().failWith(() -> new ObjectNotFoundException(id, "Place"));
    }

    public Uni<List<Place>> list() {
        return Place.listAll();
    }
}
