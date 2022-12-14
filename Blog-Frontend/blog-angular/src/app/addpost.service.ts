import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Postpayload } from './postpayload';

@Injectable({
  providedIn: 'root'
})
export class AddpostService {
  url:string='http://localhost:8081/blog/';

  
  constructor(private httpClient:HttpClient) { }
  
  public addpost(postPayload:Postpayload){
  return this.httpClient.post(this.url+'post',postPayload,{headers:{'Authorization':'Bearer '+localStorage.getItem('token')!}})
  }

  public getAllPost():Observable<Array<Postpayload>>{
    return this.httpClient.get<Array<Postpayload>>(this.url+'post',{headers:{'Authorization':'Bearer '+localStorage.getItem('token')!}});
  }

  public getPostById(id:number):Observable<Postpayload>{
    return this.httpClient.get<Postpayload>(this.url+"post/"+id,{headers:{'Authorization':'Bearer '+localStorage.getItem('token')!}});
  }
}
