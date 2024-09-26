package alex.role;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_role")
public class Role extends PanacheEntity {
    @Column(unique = true, length = 20)
    public String name;
}
