import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AddpostService } from '../addpost.service';
import { Postpayload } from '../postpayload';

@Component({
  selector: 'app-post-detail',
  templateUrl: './post-detail.component.html',
  styleUrls: ['./post-detail.component.css']
})
export class PostDetailComponent implements OnInit {

  postPayload!:Postpayload;
  id:number=0;
  @Input() incoming_data:string="";
  constructor(private postService:AddpostService,private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.route.params.subscribe(params=>{
      this.id=params['id'];
    });
   this.postService.getPostById(this.id).subscribe(data=>{
      this.postPayload=data;
     // this.postPayload.username=this.incoming_data;
      this.postPayload.userName!=localStorage.getItem('username');
      
  });}

}
