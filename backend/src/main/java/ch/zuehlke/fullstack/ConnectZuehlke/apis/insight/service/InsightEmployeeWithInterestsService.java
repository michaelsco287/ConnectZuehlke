package ch.zuehlke.fullstack.ConnectZuehlke.apis.insight.service;

import ch.zuehlke.fullstack.ConnectZuehlke.domain.Employee;
import ch.zuehlke.fullstack.ConnectZuehlke.domain.Interests;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
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
        List<Employee> employees = getEmployeesFromJson();
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
        String file ="/backend/src/main/java/ch/zuehlke/fullstack/ConnectZuehlke/apis/insight/service/employeeCache.json";
        String jsonAsString = "";
        String path = new File("").getAbsolutePath();
        file = path + file;
        BufferedReader reader = new BufferedReader(new FileReader(file));
        while(reader.read()!=-1)
        {
            jsonAsString += reader.readLine();
        }
        reader.close();
        return "["+jsonAsString+"]";
    }

    public List<Employee> getEmployeesFromJson(){
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Employee>>(){}.getType();
        List<Employee> employees = new ArrayList<>();
        try{
            String json = getJsonCache();
            employees = gson.fromJson(json, listType);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }

}
