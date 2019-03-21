import {Component, Input, OnInit} from '@angular/core';
import {Employee} from "../domain/Employee";

@Component({
  selector: 'app-employee-interests',
  templateUrl: './employee-interests.component.html',
  styleUrls: ['./employee-interests.component.scss']
})
export class EmployeeInterestsComponent implements OnInit {
  @Input() employee: Employee;

  constructor() { }

  ngOnInit() {
  }

}
