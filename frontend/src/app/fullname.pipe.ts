import {Pipe, PipeTransform} from '@angular/core';
import {Employee} from "./domain/Employee";

@Pipe({
  name: 'fullname'
})
export class FullnamePipe implements PipeTransform {

  transform(employee: Employee, args?: any): string {
    return `${employee.firstName} ${employee.lastName}`;
  }

}
