package ch.zuehlke.fullstack.ConnectZuehlke.apis.insight.service;

import ch.zuehlke.fullstack.ConnectZuehlke.domain.Employee;
import ch.zuehlke.fullstack.ConnectZuehlke.domain.Interests;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

@Service
public class InsightEmployeeWithInterestsService implements InsightEmployeeService {

    private InsightEmployeeFetchService employeeServiceRemote;
    private InsightInterestsService interestsServiceRemote;
    private String json = "[\n"+
            "    {\n"+
            "        \"firstName\": \"Benedikt\",\n"+
            "        \"lastName\": \"Reuter\",\n"+
            "        \"id\": 186659,\n"+
            "        \"code\": \"bere\",\n"+
            "        \"interests\": []\n"+
            "    },\n"+
            "    {\n"+
            "        \"firstName\": \"Manuel\",\n"+
            "        \"lastName\": \"Sachmann\",\n"+
            "        \"id\": 186673,\n"+
            "        \"code\": \"mans\",\n"+
            "        \"interests\": [\n"+
            "            {\n"+
            "            \"name\": \"C++\",\n"+
            "            \"id\": \"91\"\n"+
            "            },\n"+
            "            {\n"+
            "            \"name\": \"C++17\",\n"+
            "            \"id\": \"43653\"\n"+
            "            },\n"+
            "            {\n"+
            "            \"name\": \"Embedded Systems\",\n"+
            "            \"id\": \"486\"\n"+
            "            }\n"+
            "        ]\n"+
            "    },\n"+
            "    {\n"+
            "        \"firstName\": \"David\",\n"+
            "        \"lastName\": \"Sukiennik\",\n"+
            "        \"id\": 186819,\n"+
            "        \"code\": \"dasu\",\n"+
            "        \"interests\": [\n"+
            "          {\n"+
            "            \"name\": \"C++\",\n"+
            "            \"id\": \"91\"\n"+
            "          },\n"+
            "          {\n"+
            "            \"name\": \"Modern C++\",\n"+
            "            \"id\": \"22739\"\n"+
            "          },\n"+
            "          {\n"+
            "            \"name\": \"Software Engineering\",\n"+
            "            \"id\": \"337\"\n"+
            "          },\n"+
            "          {\n"+
            "            \"name\": \"Software Craftsmanship\",\n"+
            "            \"id\": \"705\"\n"+
            "          }\n"+
            "        ]\n"+
            "      }\n"+
            "]";

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

    public List<Employee> getEmployeesFromJson(){
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Employee>>(){}.getType();
        List<Employee> employees = gson.fromJson(this.json, listType);
        return employees;
    }

}
