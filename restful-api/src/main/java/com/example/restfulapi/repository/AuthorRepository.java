package com.example.restfulapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.restfulapi.entity.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}