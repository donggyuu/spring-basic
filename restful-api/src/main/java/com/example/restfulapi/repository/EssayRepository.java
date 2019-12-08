package com.example.restfulapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.restfulapi.entity.Essay;

@Repository
public interface EssayRepository extends CrudRepository<Essay, Long> {

}