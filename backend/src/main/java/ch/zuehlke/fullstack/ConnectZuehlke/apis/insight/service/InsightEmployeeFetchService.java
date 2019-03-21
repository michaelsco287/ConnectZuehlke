package ch.zuehlke.fullstack.ConnectZuehlke.apis.insight.service;

import ch.zuehlke.fullstack.ConnectZuehlke.domain.Employee;

import java.io.IOException;
import java.util.List;

public interface InsightEmployeeFetchService {

    List<Employee> getEmployees();

    byte[] getEmployeePicture(int id) throws IOException;

    Employee getEmployee(String code);
}
