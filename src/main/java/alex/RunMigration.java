package alex;

import alex.role.Role;
import alex.user.User;
import alex.user.UserService;
import io.quarkus.hibernate.reactive.panache.common.runtime.ReactiveTransactional;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;

import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.flywaydb.core.Flyway;

/**
 * Run migration
 * https://stackoverflow.com/questions/66268122/reactive-hibernate-on-quarkus-with-flyway
 */
@ApplicationScoped
public class RunMigration {
    private static final Logger LOG = Logger.getLogger(RunMigration.class);

    @ConfigProperty(name = "quarkus.datasource.reactive.url")
    String datasourceUrl;
    @ConfigProperty(name = "quarkus.datasource.username")
    String datasourceUsername;
    @ConfigProperty(name = "quarkus.datasource.password")
    String datasourcePassword;

    @Inject
    UserService userService;

    public void runMigration(@Observes StartupEvent event) {
        LOG.info("Migration start");
        Flyway flyway =
            Flyway.configure()
                .dataSource("jdbc:" + datasourceUrl, datasourceUsername, datasourcePassword)
                .baselineOnMigrate(true)
                .load();
        flyway.migrate();
        LOG.info("Flyway migration complete");
        // createAdminUser();
    }

    private void createAdminUser() {

            User admin = new User();
            admin.setPassword("");
            admin.name = "";
            userService.create(admin);
            LOG.info("Admin user was created");

    }
}
