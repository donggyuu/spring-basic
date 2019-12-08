package com.example.restfulapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restfulapi.entity.Author;
import com.example.restfulapi.repository.AuthorRepository;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/")
    public Iterable<Author> list() {
        return authorRepository.findAll();
    }

}