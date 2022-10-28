import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {FormBuilder, FormGroup} from '@angular/forms';
import { RegisterPayload } from 'src/app/register-payload';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerForm!:FormGroup;
  registerPayload:RegisterPayload;
  constructor(private formBuilder:FormBuilder,private router:Router,private authService:AuthService) {
    
      this.registerForm = this.formBuilder.group({
        username: '',
        email: '',
        phoneno:'',
        password: '',
        confirmPassword: ''
      });
      this.registerPayload = {
        username: '',
        email: '',
        phoneno:'',
        password: '',
        confirmpassword: ''
      };
    }
  
     
  

  ngOnInit(): void {
  }
onSubmit(){
  this.registerPayload.username=this.registerForm.get('username')?.value;
  this.registerPayload.email=this.registerForm.get('email')?.value;
  this.registerPayload.password=this.registerForm.get('password')?.value;
  this.registerPayload.phoneno=this.registerForm.get('phoneno')?.value;
  this.registerPayload.confirmpassword=this.registerForm.get('confirmpassword')?.value;
  this.register();
}
public register(){
  this.authService.register(this.registerPayload).subscribe((data)=>{
    console.log('Register Successfull');
    this.router.navigateByUrl('/register-success');
  },
  error=>{
    console.log('Register unsuccesful');
  });
}
}
