package alex.user;

import alex.role.Role;
import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import java.time.ZonedDateTime;
import java.util.List;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="users")
public class User extends PanacheEntity {
    @Column(nullable = false, unique = true, length = 20)
    public String name;

    @Column(nullable = false)
    String password;

    @Column(nullable = false, length = 10)
    String salt;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    public ZonedDateTime created;

    @Version
    public int version;

    @ManyToOne
    @JoinColumn(name="role_id", nullable=false)
    public Role role;

    public void setPassword(String password) {
        this.password = password;
    }

}
