package com.apbok.backend.entity.dao;

import org.springframework.data.repository.CrudRepository;

import com.apbok.backend.entity.models.Book;

public interface IBookDao extends CrudRepository<Book,Long> {

}