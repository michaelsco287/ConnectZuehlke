package ch.zuehlke.fullstack.ConnectZuehlke.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Employee {

    private String firstName;
    private String lastName;
    private int id;
    private String code;
    private List<Interests> interests;

    public Employee(String firstName, String lastName, int id) {
        this(firstName, lastName, id, firstName.substring(0, 1) + lastName.substring(0, 2));
    }

    public Employee(String firstName, String lastName, int id, String code) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.code = code.toLowerCase();
        this.interests = new ArrayList<>();
    }

    public Employee(String firstName, String lastName, int id, String code, List<Interests> interests) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.code = code;
        this.interests = interests;
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

    public String getCode() {
        return code;
    }

    public List<Interests> getInterests() {
        return interests;
    }

    public void setInterests(List<Interests> interests) {
        this.interests = interests;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                firstName.equals(employee.firstName) &&
                lastName.equals(employee.lastName) &&
                code.equals(employee.code) &&
//                interests.equals(employee.interests);
                Objects.equals(interests, employee.interests);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, id, code, interests);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                ", code='" + code + '\'' +
                ", interests=" + interests +
                '}';
    }
}
