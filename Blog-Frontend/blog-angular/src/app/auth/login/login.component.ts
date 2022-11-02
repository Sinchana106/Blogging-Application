import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { LoginPayload } from 'src/app/login-payload';
import { AuthService } from '../auth.service';
import {Router} from "@angular/router";
import { catchError, Observable } from 'rxjs';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm!:FormGroup;
  loginPayload:LoginPayload;
  token!:string;
  
  
  constructor(private formBuilder:FormBuilder, private authService:AuthService,private router:Router) { 
    this.loginForm=this.formBuilder.group({
      username: '',
      password:''
     } );
     this.loginPayload={
      username:'',
      password:''
     };
  }

  ngOnInit(): void {
  }
  onSubmit(){
    this.loginPayload.username=this.loginForm.get('username')?.value;
    this.loginPayload.password=this.loginForm.get('password')?.value;
    console.log(this.loginPayload.username);
    console.log(this.loginPayload.password);
    
    this.login();
    console.log(this.getUsername());
  }

  login(){
    this.authService.login(this.loginPayload).subscribe((data)=>{
      try {
        console.log(data+123);
      console.log("Login successful");
      localStorage.setItem('token',data);
   
      this.router.navigateByUrl("/home"); 
      
      } catch (error) {
        console.log(error);
        this.router.navigateByUrl("/login"); 
      }
     

  });

 
    
  }
  getUsername(){
    this.authService.getUsername().subscribe(data=>{
      console.log(data);
      localStorage.setItem('username',data);
    });
    
  }

  }


