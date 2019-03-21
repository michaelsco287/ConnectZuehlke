import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {EmployeeListComponent} from './employee-list/employee-list.component';
import {PageNotFoundComponent} from './page-not-found/page-not-found.component';
import {HackathonHeadlineComponent} from './hackathon-headline/hackathon-headline.component';
import {EmployeeDetailComponent} from './employee-detail/employee-detail.component';
import {MapComponent} from './map/map.component';
import {CustomerListComponent} from './customer-list/customer-list.component';
import {EmployeeInterestsComponent} from "./employee-interests/employee-interests.component";

const routes: Routes = [
  {path: 'employees', component: EmployeeListComponent},
  {path: 'customers', component: CustomerListComponent},
  {path: 'employee/:code', component: EmployeeDetailComponent},
  {path: 'employee-interests/:code', component: EmployeeInterestsComponent},
  {path: 'welcome', component: HackathonHeadlineComponent},
  {path: 'map', component: MapComponent},

  {path: '', redirectTo: '/welcome', pathMatch: 'full'},
  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
