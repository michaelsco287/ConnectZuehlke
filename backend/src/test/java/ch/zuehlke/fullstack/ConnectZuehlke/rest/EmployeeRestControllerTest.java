package ch.zuehlke.fullstack.ConnectZuehlke.rest;

import ch.zuehlke.fullstack.ConnectZuehlke.apis.insight.service.InsightEmployeeFetchService;
import ch.zuehlke.fullstack.ConnectZuehlke.apis.insight.service.InsightEmployeeService;
import ch.zuehlke.fullstack.ConnectZuehlke.domain.Employee;
import ch.zuehlke.fullstack.ConnectZuehlke.domain.Interests;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@ActiveProfiles("default")
@WebMvcTest(value = EmployeeRestController.class)
public class EmployeeRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InsightEmployeeService employeeService;

    @Test
    public void testGetEmptyUsers() throws Exception {
        when(employeeService.getEmployees()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/employees"))
                .andExpect(content().json("[]"));

    }

    @Test
    public void testGetUsers() throws Exception {
        List<Interests> interestsList = new ArrayList<>();
        interestsList.add(new Interests("trance music", "14"));
        Employee employee = new Employee("Max", "Mustermann", 1, "mmu", interestsList);
        employee.setInterests(interestsList);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        when(employeeService.getEmployees()).thenReturn(employeeList);
        mockMvc.perform(get("/api/employees"))
                .andExpect(content().json("[\n" +
                        "  {\n" +
                        "    \"firstName\": \"Max\",\n" +
                        "    \"lastName\": \"Mustermann\",\n" +
                        "    \"id\": 1,\n" +
                        "    \"code\": \"mmu\",\n" +
                        "    \"interests\": [{\"name\": \"trance music\", \"id\": \"14\"}]\n" +
                        "  }\n" +
                        "]"));

    }
}

