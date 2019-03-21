package ch.zuehlke.fullstack.ConnectZuehlke.apis.insight.service;

import ch.zuehlke.fullstack.ConnectZuehlke.domain.Employee;
import ch.zuehlke.fullstack.ConnectZuehlke.domain.Interests;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProdInsightEmployeeWithInterestsServiceTest {

    @Test
    public void combinesEmployeeAndInterestForValidCodeSuccessfully(){
        List<Interests> interestsList = new ArrayList<>();
        interestsList.add(new Interests("Zorbing", "26"));
        Employee employeeNoInterests = new Employee("John", "Doe", 1, "JoDo");
        Employee expectedEmployee = new Employee("John", "Doe", 1, "JoDo");
        expectedEmployee.setInterests(interestsList);

        InsightEmployeeServiceRemote mockEmployeeService = mock(InsightEmployeeServiceRemote.class);
        InsightInterestsServiceRemote mockInterestsService = mock(InsightInterestsServiceRemote.class);
        when(mockEmployeeService.getEmployee(eq("JoDo"))).thenReturn(employeeNoInterests);
        when(mockInterestsService.getInterests(eq("JoDo"))).thenReturn(interestsList);

        InsightEmployeeService service = new InsightEmployeeWithInterestsService(mockEmployeeService, mockInterestsService);


        Employee actualEmployee = service.getEmployee("JoDo");
        assertEquals(actualEmployee, expectedEmployee);
    }

}
