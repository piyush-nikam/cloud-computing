import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {
  type: String = ''
  food: String = ''
  orders: String = 'Orders are here'

  getAllUrl = 'http://localhost:8080/all';
  addUrl = 'http://localhost:8080/add'

  constructor(private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
    })
  };

  ngOnInit() {
    this.fetchOrders()
  }

  addData(){
    console.log(this.type)
    console.log(this.food)
    let body = JSON.stringify({
      'userName': 'admin',
      'foodType': this.type,
      'foodName': this.food
    });
    
    this.http.post(this.addUrl, body, this.httpOptions).subscribe((res => {
    
      var addStatus = JSON.parse(JSON.stringify(res))
      console.log(addStatus.add)    
  
    }))

  }

  fetchOrders() {
    this.http.get(this.getAllUrl).subscribe((res => {
      console.log(res)
      this.orders = JSON.stringify(res)
    }))
  }


}
