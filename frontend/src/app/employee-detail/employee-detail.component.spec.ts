import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {EmployeeDetailComponent} from './employee-detail.component';
import {RouterTestingModule} from '@angular/router/testing';
import {EmployeeService} from '../employee.service';
import {EmployeeServiceMock} from '../employee-list/employee.service-mock';
import {LazyLoadImageModule} from "ng-lazyload-image";
import {MatCardModule, MatExpansionModule, MatListModule} from "@angular/material";
import {FullnamePipe} from "../fullname.pipe";
import {InterestnamePipe} from "../interestname.pipe";

describe('EmployeeDetailComponent', () => {
  let component: EmployeeDetailComponent;
  let fixture: ComponentFixture<EmployeeDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        RouterTestingModule,
        LazyLoadImageModule,
        MatExpansionModule,
        MatListModule,
        MatCardModule
      ],
      declarations: [EmployeeDetailComponent, FullnamePipe, InterestnamePipe],
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
