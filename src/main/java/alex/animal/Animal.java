package alex.animal;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "animal")
public class Animal extends PanacheEntity {
    @Column(unique = true, length = 20)
    public String name;
}
