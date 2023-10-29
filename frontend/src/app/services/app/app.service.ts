import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { App } from 'src/app/model/app/app';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

const httpOptionsUsingUrlEncoded = {
  headers: new HttpHeaders({ 'Content-Type': 'application/x-www-form-urlencoded' })
};

@Injectable({
  providedIn: 'root'
})

export class AppService {
  endPoint: string = "http://localhost:8080/apps";

  constructor(private httpClient: HttpClient) { }

  getApps(): Observable<App[]> {
    return this.httpClient.get<App[]>(this.endPoint);
  }

  postApp(app: App): Observable<App> {
    let bodyEncode = new URLSearchParams();
    bodyEncode.append("name", app.name);
    bodyEncode.append("description", app.description);
    bodyEncode.append("price", app.price.toString());

    const body = bodyEncode.toString();
    return this.httpClient.post<App>(this.endPoint, body, httpOptionsUsingUrlEncoded);
  }

  deleteApp(id: number): Observable<App> {
    let url = `${this.endPoint}/${id}`;
    return this.httpClient.delete<App>(url);
  }

  updateApp(id: number, app:App): Observable<App> {
    let url = `${this.endPoint}/${id}`;
    let bodyEncode = new URLSearchParams();
    bodyEncode.append("name", app.name);
    bodyEncode.append("description", app.description);
    bodyEncode.append("price", app.price.toString());

    const body = bodyEncode.toString();
    return this.httpClient.put<App>(url, body, httpOptionsUsingUrlEncoded);
  }
}
