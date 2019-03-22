import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {EmployeeDetailComponent} from './employee-detail.component';
import {RouterTestingModule} from '@angular/router/testing';
import {EmployeeService} from '../employee.service';
import {EmployeeServiceMock} from '../employee-list/employee.service-mock';
import {LazyLoadImageModule} from "ng-lazyload-image";
import {MatCardModule} from "@angular/material";
import {FullnamePipe} from "../fullname.pipe";

describe('EmployeeDetailComponent', () => {
  let component: EmployeeDetailComponent;
  let fixture: ComponentFixture<EmployeeDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        RouterTestingModule,
        LazyLoadImageModule,
        MatCardModule
      ],
      declarations: [EmployeeDetailComponent, FullnamePipe],
      providers: [
        {provide: EmployeeService, useClass: EmployeeServiceMock}
      ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
