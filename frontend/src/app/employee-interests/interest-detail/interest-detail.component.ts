import {Component, OnInit} from '@angular/core';
import {Observable, of} from "rxjs";
import {Employee} from "../../domain/Employee";
import {ActivatedRoute, ParamMap} from "@angular/router";
import {EmployeeService} from "../../employee.service";
import {switchMap} from "rxjs/operators";

@Component({
  selector: 'app-interest-detail',
  templateUrl: './interest-detail.component.html',
  styleUrls: ['./interest-detail.component.scss']
})
export class InterestDetailComponent implements OnInit {
  public employees$: Observable<Employee[]>;
  public interestName$: Observable<string>;

  constructor(
    private route: ActivatedRoute,
    private service: EmployeeService
  ) {
  }

  ngOnInit() {
    this.employees$ = this.route.paramMap.pipe(
      switchMap((params: ParamMap) => {
        const interestId = params.get("interestId");
        const employees = this.service.getAllEmployeesWithInterest(params.get("code"), interestId);
        this.interestName$ = of(employees[0].interests.find(interest => interest.id == interestId).name);
        return employees;
      })
    )
  }

}
