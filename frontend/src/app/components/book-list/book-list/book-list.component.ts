import { Component, OnInit } from '@angular/core';
import { Book } from 'src/app/model/book/book';
import { BookService } from 'src/app/services/book/book.service';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.scss'],
})
export class BookListComponent implements OnInit {
  public id: number = 0;
  public books: Array<Book> = [];
  public title!: string;
  public sypnosis!: string;
  public author!: string;
  public price!: number;
  public edit: boolean = false;

  constructor(private bookService: BookService) { }

  ngOnInit(): void {
    this.getAllBooks();
  }

  getAllBooks() {
    this.bookService.getBooks().subscribe((books: Array<Book>) => {
      this.books = books;
    });
  }

  addBook() {
    let book: Book = {
      id: 0,
      img: '',
      title: this.title,
      sypnosis: this.sypnosis || 'Sin descripción',
      author: this.author,
      price: this.price
    };

    this.bookService.postBook(book).subscribe((r) => {
      console.log('Se ha añadido correctamente');
      this.getAllBooks();
    },
      (error) => {
        console.log('Error al realizar la solicitud: ', error);
        this.getAllBooks();
      }
    )
  }

  updateBook(book: Book) {
    this.id = book.id;
    this.title = book.title;
    this.sypnosis = book.sypnosis;
    this.author = book.author;
    this.price = book.price;
    this.edit = true;
  }

  putBook() {
    let book: Book = {
      id: 0,
      img: '',
      title: this.title,
      sypnosis: this.sypnosis || 'Sin descripción',
      author: this.author,
      price: this.price
    };

    this.bookService.updateBook(this.id, book).subscribe((r) => {
      console.log('Se ha actualizado correctamente');
      this.getAllBooks();
      this.edit = false;
    },
      (error) => {
        console.log('Error al realizar la solicitud: ', error);
        this.getAllBooks();
        this.edit = false;
      }
    )
  }

  deleteBook(id: number) {
    this.bookService.deleteBook(id).subscribe((r) => {
      console.log('Se ha eliminiado correctamente');
      this.getAllBooks();
      this.edit = false;
    },
      (error) => {
        console.log('Error al realizar la solicitud: ', error);
        this.getAllBooks();
        this.edit = false;
      }
    )
  }
}
