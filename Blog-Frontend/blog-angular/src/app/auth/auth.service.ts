import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core'
import { RegisterPayload } from '../register-payload';
import {catchError, Observable} from 'rxjs'
import { LoginPayload } from '../login-payload';

@Injectable({
  providedIn:'root'
})
export class AuthService {

  private url:string="http://localhost:8082/api/auth";
  constructor(private httpClient:HttpClient){

   }

  register(registerPayload:RegisterPayload):Observable<any>{
    return this.httpClient.post<any>(this.url+"/signup",registerPayload);
  }

  login(loginPayload:LoginPayload):Observable<any>{
    return this.httpClient.post<any>(this.url+"/login", loginPayload,{responseType:'text' as 'json'});
    
  }

  public isloggedin():boolean{
    return localStorage.getItem("token")!=null;
  }

  public getUsername():Observable<string>{
    console.log("inside getusername");
    //console.log(this.httpClient.get<string>(this.url+"/username",{headers:{'Authorization':'Bearer '+localStorage.getItem('token')}}));
    return this.httpClient.get<string>(this.url+"/username",{headers:{'Authorization':'Bearer '+localStorage.getItem('token')},responseType:'text' as 'json'});
  }
}
