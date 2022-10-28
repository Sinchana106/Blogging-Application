import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { RegisterPayload } from '../register-payload';
import {Observable} from 'rxjs'
import { LoginPayload } from '../login-payload';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private url:string="http://localhost:8080/api/auth";
  constructor(private httpClient:HttpClient){

   }

  register(registerPayload:RegisterPayload):Observable<any>{
    return this.httpClient.post<any>(this.url+"/signup",registerPayload);
  }

  login(loginPayload:LoginPayload):Observable<any>{
    return this.httpClient.post<any>(this.url+"/login", loginPayload);
  }
}
