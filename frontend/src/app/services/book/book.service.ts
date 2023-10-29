import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from 'src/app/model/book/book';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

const httpOptionsUsingUrlEncoded = {
  headers: new HttpHeaders({ 'Content-Type': 'application/x-www-form-urlencoded' })
};

@Injectable({
  providedIn: 'root'
})

export class BookService {
  endPoint: string = "http://localhost:8080/books";

  constructor(private httpClient: HttpClient) { }

  getApps(): Observable<Book[]> {
    return this.httpClient.get<Book[]>(this.endPoint);
  }

  postApp(book: Book): Observable<Book> {    
    let bodyEncode = new URLSearchParams();
    bodyEncode.append("name", book.title);
    bodyEncode.append("name", book.author);
    bodyEncode.append("description", book.sypnosis);
    bodyEncode.append("price", book.price.toString());

    const body = bodyEncode.toString();
    return this.httpClient.post<Book>(this.endPoint, body, httpOptionsUsingUrlEncoded);
  }

  deleteApp(id: number): Observable<Book> {
    let url = `${this.endPoint}/${id}`;
    return this.httpClient.delete<Book>(url);
  }

  updateApp(id: number, book:Book): Observable<Book> {
    let url = `${this.endPoint}/${id}`;
    let bodyEncode = new URLSearchParams();
    bodyEncode.append("name", book.title);
    bodyEncode.append("name", book.author);
    bodyEncode.append("description", book.sypnosis);
    bodyEncode.append("price", book.price.toString());

    const body = bodyEncode.toString();
    return this.httpClient.put<Book>(url, body, httpOptionsUsingUrlEncoded);
  }
}