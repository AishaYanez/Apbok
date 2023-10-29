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

  getBooks(): Observable<Book[]> {
    return this.httpClient.get<Book[]>(this.endPoint);
  }

  postBook(book: Book): Observable<Book> {    
    let bodyEncode = new URLSearchParams();
    bodyEncode.append("title", book.title);
    bodyEncode.append("author", book.author);
    bodyEncode.append("sypnosis", book.sypnosis);
    bodyEncode.append("price", book.price.toString());

    const body = bodyEncode.toString();
    return this.httpClient.post<Book>(this.endPoint, body, httpOptionsUsingUrlEncoded);
  }

  deleteBook(id: number): Observable<Book> {
    let url = `${this.endPoint}/${id}`;
    return this.httpClient.delete<Book>(url);
  }

  updateBook(id: number, book:Book): Observable<Book> {
    let url = `${this.endPoint}/${id}`;
    let bodyEncode = new URLSearchParams();
    bodyEncode.append("title", book.title);
    bodyEncode.append("author", book.author);
    bodyEncode.append("sypnosis", book.sypnosis);
    bodyEncode.append("price", book.price.toString());

    const body = bodyEncode.toString();
    return this.httpClient.put<Book>(url, body, httpOptionsUsingUrlEncoded);
  }
}