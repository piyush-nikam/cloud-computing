import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  userName: String = ''
  password: String = ''
  InValid: boolean = false
  getAllUrl = 'http://localhost:8080/all';
  loginUrl = 'http://localhost:8080/login'

  constructor(public router: Router, private http: HttpClient) { }


   httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
    })
  };

  ngOnInit() {
  }

  public login(){
    this.auth();
  }

getConfig() {
  this.http.get(this.getAllUrl).subscribe((res => {console.log(res)}))
}

auth(){
  let body = JSON.stringify({
    'userName': this.userName,
    'password': this.password
  });
  
  this.http.post(this.loginUrl, body, this.httpOptions).subscribe((res => {
    
    var authStatus = JSON.parse(JSON.stringify(res))
    if(authStatus.auth === 'success'){
      this.router.navigate(['/add'])
    }else{
      this.InValid = true
    }

  }))
}
}
