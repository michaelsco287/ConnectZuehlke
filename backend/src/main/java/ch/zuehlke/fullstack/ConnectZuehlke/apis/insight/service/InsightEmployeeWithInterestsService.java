package ch.zuehlke.fullstack.ConnectZuehlke.apis.insight.service;

import ch.zuehlke.fullstack.ConnectZuehlke.domain.Employee;
import ch.zuehlke.fullstack.ConnectZuehlke.domain.Interests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
        List<Employee> employees = employeeServiceRemote.getEmployees();
        employees.forEach(employee ->  employee.setInterests(interestsServiceRemote.getInterests(employee.getCode())));
        return employees;
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

    private String getJsonCache() throws IOException {
        String file ="./employeeCache.json";
        String jsonAsString = "";

        BufferedReader reader = new BufferedReader(new FileReader(file));

        while(reader.read()!=-1)
        {
            jsonAsString=reader.readLine();
        }
        reader.close();
        System.out.println(jsonAsString);

        return jsonAsString;
    }
}
