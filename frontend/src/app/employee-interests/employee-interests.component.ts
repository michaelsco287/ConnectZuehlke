import {Component, OnInit} from '@angular/core';
import {Employee} from "../domain/Employee";
import {EmployeeService} from "../employee.service";
import {Observable} from "rxjs";
import {ActivatedRoute, ParamMap} from "@angular/router";
import {switchMap} from "rxjs/operators";
import {Interest} from "../domain/Interest";

@Component({
  selector: 'employee-interests',
  templateUrl: './employee-interests.component.html',
  styleUrls: ['./employee-interests.component.scss']
})
export class EmployeeInterestsComponent implements OnInit {
  employee$: Observable<Employee>;
  INTERESTS: Interest[] = [{name: "Testing", id: "0"}, {name: "iOS", id: "1"}];

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
