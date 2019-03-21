import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeInterestsComponent } from './employee-interests.component';

describe('EmployeeInterestsComponent', () => {
  let component: EmployeeInterestsComponent;
  let fixture: ComponentFixture<EmployeeInterestsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeInterestsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeInterestsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
