package com.example.restfulapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.restfulapi.entity.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long>{

}