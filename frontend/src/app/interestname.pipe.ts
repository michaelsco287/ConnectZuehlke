import {Pipe, PipeTransform} from '@angular/core';
import {Employee} from "./domain/Employee";

@Pipe({
  name: 'interestname'
})
export class InterestnamePipe implements PipeTransform {

  transform(employees: Employee[], interestId: string): string {
    return employees[0].interests.find(interest => interest.id === interestId).name;
  }

}
