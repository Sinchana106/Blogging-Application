import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private authService:AuthService) { }

  ngOnInit(): void {
    this.checklogin();
    
  }

  public checklogin()
{
  console.log(this.authService.isloggedin());
  return this.authService.isloggedin();
}
}
