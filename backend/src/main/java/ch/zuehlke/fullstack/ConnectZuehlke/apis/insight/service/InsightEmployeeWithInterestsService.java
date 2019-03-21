package ch.zuehlke.fullstack.ConnectZuehlke.apis.insight.service;

import ch.zuehlke.fullstack.ConnectZuehlke.domain.Employee;
import ch.zuehlke.fullstack.ConnectZuehlke.domain.Interests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class InsightEmployeeWithInterestsService implements InsightEmployeeService {

    private InsightEmployeeFetchService employeeServiceRemote;
    private InsightInterestsService interestsServiceRemote;

    @Autowired
    public InsightEmployeeWithInterestsService(InsightEmployeeFetchService employeeServiceRemote, InsightInterestsService interestsServiceRemote){
        this.employeeServiceRemote = employeeServiceRemote;
        this.interestsServiceRemote = interestsServiceRemote;
    }

    @Override
    public List<Employee> getEmployees() {
        return null;
    }

    @Override
    public byte[] getEmployeePicture(int id) throws IOException {
        return new byte[0];
    }

    @Override
    public Employee getEmployee(String code) {
        Employee employee = employeeServiceRemote.getEmployee(code);
        List<Interests> interests = interestsServiceRemote.getInterests(code);
        employee.setInterests(interests);
        return employee;
    }
}
