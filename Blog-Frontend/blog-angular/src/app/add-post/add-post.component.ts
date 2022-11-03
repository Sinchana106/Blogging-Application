import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Route, Router } from '@angular/router';
import { AddpostService } from '../addpost.service';
import { Postpayload } from '../postpayload';

@Component({
  selector: 'app-add-post',
  templateUrl: './add-post.component.html',
  styleUrls: ['./add-post.component.css']
})
export class AddPostComponent implements OnInit {
  addPostForm:FormGroup;
  title=new FormControl('');
  body=new FormControl('');
  postpayload:Postpayload;
  userName=localStorage.getItem('userName');
  constructor(private adpost:AddpostService,private router:Router) {
    this.addPostForm=new FormGroup({
      title:this.title,
      body:this.body

    });
    this.postpayload={
      id:'',
      title:'',
      content:'',
      userName:'',
      updatedOn:''
    }

   }

  ngOnInit(): void {
  }
addPost(){
this.postpayload.title=this.addPostForm.get('title')?.value;
this.postpayload.content=this.addPostForm.get('body')?.value;
this.postpayload.updatedOn=new Date();

console.log(localStorage.getItem('userName'));
this.postpayload.userName=this.userName!;

this.adpost.addpost(this.postpayload).subscribe(data=>{
  
  this.router.navigateByUrl('/home');
});
}
}
