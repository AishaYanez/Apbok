DROP DATABASE IF EXISTS db_apbok;
CREATE DATABASE db_apbok;
USE db_apbok;

CREATE TABLE apps (
	id INT AUTO_INCREMENT,
    img VARCHAR(100) default 'app_default.png',
    name VARCHAR(50) NOT NULL,
    description VARCHAR(150) default 'Sin descripción',
    price DECIMAL(10,2) default 0.0,
    CONSTRAINT apps_pk PRIMARY KEY(id)
);

CREATE TABLE users (
	id INT AUTO_INCREMENT,
    img VARCHAR(100) default "img_logOut.png",
    user_code VARCHAR(50) NOT NULL,
    nick_name VARCHAR(50) NOT NULL,
    email VARCHAR(150) NOT NULL,
    rol BOOLEAN default 0,
    password VARCHAR(50) NOT NULL,
    CONSTRAINT users_pk PRIMARY KEY(id),
    CONSTRAINT users_uk1 UNIQUE(user_code),
    CONSTRAINT users_uk2 UNIQUE(nick_name),
    CONSTRAINT users_uk3 UNIQUE(email)
);

CREATE TABLE users_apps (
	user_id INT NOT NULL,
    app_id INT NOT NULL,
	favorite BOOLEAN default false,
    CONSTRAINT users_apps_pk PRIMARY KEY(user_id,app_id),
    CONSTRAINT users_apps_fk1 FOREIGN KEY(user_id)
    REFERENCES users(id),
    CONSTRAINT users_apps_fk2 FOREIGN KEY(app_id)
    REFERENCES apps(id)
);

CREATE TABLE books (
	id INT AUTO_INCREMENT,
    img VARCHAR(100) default 'book_default.png',
    title VARCHAR(50) NOT NULL,
    synopsis VARCHAR(150) default 'Sin descripción',
    author VARCHAR(100) default 'Autor desconocido',
    price DECIMAL(10,2) default 0.0,
    CONSTRAINT books_pk PRIMARY KEY(id)
);

CREATE TABLE users_books (
	user_id INT NOT NULL,
    book_id INT NOT NULL,
	favorite BOOLEAN default false,
    CONSTRAINT users_books_pk PRIMARY KEY(user_id,book_id),
    CONSTRAINT users_books_fk1 FOREIGN KEY(user_id)
    REFERENCES users(id),
    CONSTRAINT users_books_fk2 FOREIGN KEY(book_id)
    REFERENCES books(id)
);