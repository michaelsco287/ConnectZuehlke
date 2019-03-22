import {Component, OnInit} from '@angular/core';
import {Observable} from "rxjs";
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
  public interestId: string = "";

  constructor(
    private route: ActivatedRoute,
    private service: EmployeeService
  ) {
  }

  ngOnInit() {
    this.employees$ = this.route.paramMap.pipe(
      switchMap((params: ParamMap) => {
        this.interestId = params.get("interestId");
        return this.service.getAllEmployeesWithInterest(params.get("code"), this.interestId);
      })
    )
  }

}
