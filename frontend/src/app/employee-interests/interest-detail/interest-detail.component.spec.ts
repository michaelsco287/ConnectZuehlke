import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {InterestDetailComponent} from './interest-detail.component';
import {RouterTestingModule} from "@angular/router/testing";
import {EmployeeService} from "../../employee.service";
import {Interest} from "../../domain/Interest";
import {Employee} from "../../domain/Employee";
import {Observable, of} from "rxjs";
import {MatCardModule, MatDividerModule, MatGridListModule} from "@angular/material";
import {LazyLoadImageModule} from "ng-lazyload-image";
import {FullnamePipe} from "../../fullname.pipe";

describe('InterestDetailComponent', () => {
  let component: InterestDetailComponent;
  let fixture: ComponentFixture<InterestDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        RouterTestingModule,
        MatDividerModule,
        LazyLoadImageModule,
        MatCardModule,
        MatGridListModule
      ],
      declarations: [InterestDetailComponent, FullnamePipe],
      providers: [
        {provide: EmployeeService, useClass: EmployeeServiceStub}
      ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InterestDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  xit('should create', () => {
    expect(component).toBeTruthy();
  });
});

const INTERESTS: Interest[] = [{name: "Testing", id: "0"}, {name: "iOS", id: "1"}];
const EMPLOYEES: Employee[] = [
  {firstName: 'Tommy', lastName: 'Tester', id: 1, code: 'tote', interests: INTERESTS, location: "hull", title: "drug mule"}
];

class EmployeeServiceStub {
  getEmployee(code: string): Observable<Employee> {
    return of(EMPLOYEES.find(e => e.code === code));
  }
}
