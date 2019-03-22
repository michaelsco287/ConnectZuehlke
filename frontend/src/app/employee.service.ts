import {Injectable} from '@angular/core';
import {Observable, of} from 'rxjs';
import {catchError, switchMap} from 'rxjs/operators';
import {HttpClient} from '@angular/common/http';
import {Employee} from './domain/Employee';
import {Interest} from "./domain/Interest";

const interests1: Interest[] = [{id: "0", name: "Hacking"}, {id: "1", name: "iOS"}, {id: "2", name: "TDD"}];
const interests2: Interest[] = [{id: "2", name: "TDD"}, {id: "3", name: "Full stack"}, {id: "4", name: "Badminton"}];
const EMPLOYEES: Employee[] = [
  {firstName: "Tommy", lastName: "Tester", id: 0, code: "msco", interests: interests1},
  {firstName: "Big", lastName: "Sam", id: 1, code: "sawh", interests: interests2}
];

@Injectable({providedIn: 'root'})
export class EmployeeService {

  constructor(private http: HttpClient) {
  }

  public getAllEmployees(): Observable<Employee[]> {
    return this.http
      .get<Employee[]>('/api/employees')
      .pipe(catchError(this.handleError('getAllEmployees', [])));

  }

  public getAllEmployeesWithInterest(employeeCode: string, interestId: string): Observable<Employee[]> {
    return this.http
      .get<Employee[]>('/api/employees')
      .pipe(
        switchMap((employees: Employee[]) => of(employees.filter(employee => employee.code != employeeCode && employee.interests.map(interest => interest.id).includes(interestId)))),
        catchError(this.handleError('getAllEmployeesWithInterest', []))
      );
  }

  // employees => employees.filter(employee => employee.interests.map(interest => interest.id).includes(interestId))
  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  private log(s: string) {
    console.log(`${this}: ${s}`);
  }

  getEmployee(id: string): Observable<Employee> {
    return this.http
      .get<Employee>(`/api/employee/${id}`)
      .pipe(catchError(this.handleError('getEmployee', null)));
  }
}
