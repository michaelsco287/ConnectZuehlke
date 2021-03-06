import {Observable, of} from 'rxjs';
import {Employee} from '../domain/Employee';

export const EMPLOYEES: Employee[] = [
  {firstName: 'John', lastName: 'Doe', id: 1, code: 'jdo', interests: [{id: "123", name: "Full-Stack"}], title: "Angel", location: "Brixton"},
  {firstName: 'Max', lastName: 'Mustermann', id: 2, code: 'mmu', interests: [{id: "456", name: "Angular"}], title: "Mr Strong", location: "Hull"},
];

export class EmployeeServiceMock {
  getAllEmployees(): Observable<Employee[]> {
    return of(EMPLOYEES);
  }

  getEmployee(code: string): Observable<Employee> {
    return of(EMPLOYEES.find(e => e.code === code));
  }
}
