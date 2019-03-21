import {async, ComponentFixture, TestBed, tick} from '@angular/core/testing';

import {EmployeeInterestsComponent} from './employee-interests.component';
import {Interest} from "../domain/Interest";
import {EmployeeService} from "../employee.service";
import {RouterTestingModule} from "@angular/router/testing";
import {Employee} from "../domain/Employee";
import {Observable, of} from "rxjs";

describe('EmployeeInterestsComponent', () => {
  let component: EmployeeInterestsComponent;
  let fixture: ComponentFixture<EmployeeInterestsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        RouterTestingModule,
      ],
      declarations: [EmployeeInterestsComponent],
      providers: [
        {provide: EmployeeService, useClass: EmployeeServiceStub}
      ]
    }).compileComponents()

  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeInterestsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it("displays employee's name in a h1",  () => {
    async(() => {
      component.ngOnInit();
      fixture.detectChanges();
      tick(400);
      fixture.detectChanges();
      const compiled = fixture.debugElement.nativeElement;

      expect(compiled.querySelector('h1').textContent).toBe('Tommy Tester');
    })

  });

  it("displays a list populated with the employee's interests", () => {
    async(() => {
      component.ngOnInit();
      fixture.detectChanges();
      tick(400);
      fixture.detectChanges();
      const compiled = fixture.debugElement.nativeElement;
      let listResult = compiled.querySelectorAll('#interests-list li');
      expect(listResult.length).toEqual(INTERESTS.length)
    })
  })
});

const INTERESTS: Interest[] = [{name: "Testing", id: 0}, {name: "iOS", id: 1}];
const EMPLOYEES: Employee[] = [
  {firstName: 'Tommy', lastName: 'Tester', id: 1, code: 'tote', interests: INTERESTS}
];

class EmployeeServiceStub {
  getEmployee(code: string): Observable<Employee> {
    return of(EMPLOYEES.find(e => e.code === code));
  }
}
