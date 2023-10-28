package com.apbok.backend.entity.dao;

import org.springframework.data.repository.CrudRepository;

import com.apbok.backend.entity.models.App;

public interface IAppDao extends CrudRepository<App,Long> {

}
