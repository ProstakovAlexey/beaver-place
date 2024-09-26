package alex.place;

import alex.animal.Animal;
import alex.user.User;
import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import java.time.ZonedDateTime;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "place")
public class Place extends PanacheEntity {
    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    public ZonedDateTime created;

    @Version
    public int version;

    @Column(name = "photo_file_name", columnDefinition = "TEXT")
    private String photoFileName;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String text;

    @Column(nullable = false)
    private double latitude;

    @Column(nullable = false)
    private double longitude;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    public User user;

    @ManyToOne
    @JoinColumn(name="animal_id", nullable=false)
    public Animal animal;
}
