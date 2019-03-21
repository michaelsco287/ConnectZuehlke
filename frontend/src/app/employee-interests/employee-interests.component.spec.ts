import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {EmployeeInterestsComponent} from './employee-interests.component';
import {Interest} from "../domain/Interest";

describe('EmployeeInterestsComponent', () => {
  let component: EmployeeInterestsComponent;
  let fixture: ComponentFixture<EmployeeInterestsComponent>;
  let interests: Interest[] = [{name: "Testing", id: 0}, {name: "iOS", id: 1}];

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [EmployeeInterestsComponent]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeInterestsComponent);
    component = fixture.componentInstance;
    component.employee = {firstName: 'Tommy', lastName: 'Tester', id: 1, code: 'tote', interests: interests};
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it("displays employee's name in a h1", () => {
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('h1').textContent).toContain('Tommy Tester');
  })

  it("displays a list populated with the employee's interests", () => {
    const compiled = fixture.debugElement.nativeElement;
    let listResult = compiled.querySelectorAll('#interests-list li')
    expect(listResult.length).toEqual(interests.length)
    //expect(compiled.querySelector('li').
  })
});
