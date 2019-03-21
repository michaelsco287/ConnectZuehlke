import {Component, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {Employee} from "../../domain/Employee";
import {ActivatedRoute, ParamMap} from "@angular/router";
import {EmployeeService} from "../../employee.service";
import {Interest} from "../../domain/Interest";
import {switchMap} from "rxjs/operators";

@Component({
  selector: 'app-interest-detail',
  templateUrl: './interest-detail.component.html',
  styleUrls: ['./interest-detail.component.scss']
})
export class InterestDetailComponent implements OnInit {
  public employees$: Observable<Employee[]>;
  private interest$: Observable<Interest>;

  constructor(
    private route: ActivatedRoute,
    private service: EmployeeService
  ) {
  }

  ngOnInit() {
    this.employees$ = this.route.paramMap.pipe(
      switchMap((params: ParamMap) => this.service.getAllEmployeesWithInterest(params.get("code"), params.get("interestId")))
    )
  }

}