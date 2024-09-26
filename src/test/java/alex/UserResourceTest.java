package alex;

import alex.user.User;
import alex.user.UserService;
import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class UserResourceTest {

    @Test
    void testGetAllUserEndpoint() {
        given()
          .when().get("/api/user")
          .then()
             .statusCode(200);
    }

    void testGetUserByIdEndpoint() {
        given()
            .when().get("/api/user/10")
            .then()
            .statusCode(200);
    }

}