import {Component, OnInit} from '@angular/core';
import {Employee} from "../domain/Employee";
import {EmployeeService} from "../employee.service";
import {Observable} from "rxjs";
import {ActivatedRoute, ParamMap} from "@angular/router";
import {switchMap} from "rxjs/operators";

@Component({
  selector: 'employee-interests',
  templateUrl: './employee-interests.component.html',
  styleUrls: ['./employee-interests.component.scss']
})
export class EmployeeInterestsComponent implements OnInit {
  employee$: Observable<Employee>;

  constructor(
    private route: ActivatedRoute,
    private service: EmployeeService
  ) {

  }

  ngOnInit() {
    this.employee$ = this.route.paramMap.pipe(
      switchMap((params: ParamMap) => this.service.getEmployee(params.get('code')))
    )
  }

}
