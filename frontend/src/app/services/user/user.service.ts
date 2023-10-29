import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { User } from 'src/app/model/user/user';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

const httpOptionsUsingUrlEncoded = {
  headers: new HttpHeaders({ 'Content-Type': 'application/x-www-form-urlencoded' })
};

@Injectable({
  providedIn: 'root'
})
export class UserService {
  endPoint: string = 'http://localhost:8080/users';

  constructor(private httpClient: HttpClient) { }
  public userLogin!: User;

  getUser(email: String): Observable<User> {
    let url = `${this.endPoint}?email=${email}`;
    return  this.httpClient.get<User>(url);
  }

  postUser(user: User): Observable<User> {
    let bodyEncode = new URLSearchParams();
    bodyEncode.append("nickName", user.nickName);
    bodyEncode.append("userCode", user.userCode);
    bodyEncode.append("email", user.email);
    bodyEncode.append("password", user.password);

    const body = bodyEncode.toString();
    return this.httpClient.post<User>(this.endPoint, body, httpOptionsUsingUrlEncoded);
  }

  deleteUser(): Observable<User> {
    let url = `${this.endPoint}?email=${this.userLogin.email}`;
    return this.httpClient.delete<User>(url);
  }

  setUserLogin(user: User): void {
    this.userLogin = user;
  }

  updateUser(password: string, user:User): Observable<User> {
    let bodyEncoded = new URLSearchParams();
    bodyEncoded.append("password", password);
    let body = bodyEncoded.toString();
    let url = `${this.endPoint}?email=${user.email}`;
    
    return this.httpClient.put<User>(url, body, httpOptionsUsingUrlEncoded);
  }
}