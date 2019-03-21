package ch.zuehlke.fullstack.ConnectZuehlke.rest;
import ch.zuehlke.fullstack.ConnectZuehlke.ConnectZuehlkeApplication;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import static uk.co.datumedge.hamcrest.json.SameJSONAs.sameJSONAs;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ConnectZuehlkeApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeWithInterestsRestControllerTest {

    @LocalServerPort
    private int port;

    @Before
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    @Ignore("Yet to be implemented")
    public void getInterestsWithValidCodeShouldReturnValidResponse(){
        given().
                when()
                .get("/employee/alha")
                .then()
                .body(sameJSONAs("{}"))
                .log()
                .all()
                .statusCode(200);
    }



}
