package ch.zuehlke.fullstack.ConnectZuehlke.rest;
import ch.zuehlke.fullstack.ConnectZuehlke.ConnectZuehlkeApplication;
import ch.zuehlke.fullstack.ConnectZuehlke.apis.insight.service.InsightEmployeeService;
import ch.zuehlke.fullstack.ConnectZuehlke.domain.Employee;
import ch.zuehlke.fullstack.ConnectZuehlke.domain.Interests;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static uk.co.datumedge.hamcrest.json.SameJSONAs.sameJSONAs;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ConnectZuehlkeApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeWithInterestsRestControllerTest {

    @LocalServerPort
    private int port;

    @MockBean
    private InsightEmployeeService mockedService;

    @Before
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    @Ignore
    public void getInterestsWithValidCodeShouldReturnValidResponse(){
        List<Interests> interestsList = new ArrayList<>();
        interestsList.add(new Interests("Prancing", "4"));
        Employee employee = new Employee("John", "Doe", 1, "JoDo");
        employee.setInterests(interestsList);

        when(mockedService.getEmployee(any())).thenThrow(new RuntimeException("runnning runninng"));
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
