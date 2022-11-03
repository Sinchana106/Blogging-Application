import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddPostComponent } from './add-post/add-post.component';
import { AuthGuard } from './auth.guard';
import { LoginComponent } from './auth/login/login.component';
import { RegisterSuccessComponent } from './auth/register-success/register-success.component';
import { RegisterComponent } from './auth/register/register.component';
import { HomeComponent } from './home/home.component';
import { PostDetailComponent } from './post-detail/post-detail.component';

const routes: Routes = [
  {path:'register',component:RegisterComponent},
  {path:'register-success',component:RegisterSuccessComponent},
  {path:'login',component:LoginComponent},
  {path:'home',component:HomeComponent},
  {path:'add-post',component:AddPostComponent,canActivate:[AuthGuard]},
  {path:'post-detail/:id',component:PostDetailComponent,canActivate:[AuthGuard]},
  {path:'*',redirectTo:'register',pathMatch:'full'}
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
