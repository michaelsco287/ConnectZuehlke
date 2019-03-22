package ch.zuehlke.fullstack.ConnectZuehlke.apis.insight.dto;

import ch.zuehlke.fullstack.ConnectZuehlke.domain.Employee;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class EmployeeDto {
    @JsonProperty("FirstName")
    private String firstName;
    @JsonProperty("LastName")
    private String lastName;
    @JsonProperty("Id")
    private int id;
    @JsonProperty("Code")
    private String code;
    @JsonProperty("Title")
    private String title;
    @JsonProperty("Location")
    private String location;

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getId() {
        return id;
    }

    public Employee toEmployee() {
        return new Employee(getFirstName(), getLastName(), getId(), getCode(), getTitle(), getLocation());
    }

    private String getCode() {
        return code;
    }

}
