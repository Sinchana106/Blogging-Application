import { Component, OnInit } from '@angular/core';
import { AddpostService } from '../addpost.service';
import { Postpayload } from '../postpayload';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  postArray:Array<Postpayload>=[];
  constructor(private postService:AddpostService) { }

  ngOnInit(): void {
    this.postService.getAllPost().subscribe((data)=>
    {
      this.postArray=data;
      console.log(data);
    },error=>{
      console.log("error");
    })
  }

}
