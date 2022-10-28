import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { RegisterSuccessComponent } from './auth/register-success/register-success.component';
import { RegisterComponent } from './auth/register/register.component';

const routes: Routes = [
  {path:'register',component:RegisterComponent},
  {path:'register-success',component:RegisterSuccessComponent},
  {path:'login',component:LoginComponent},
  {path:'*',redirectTo:'register',pathMatch:'full'}
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
