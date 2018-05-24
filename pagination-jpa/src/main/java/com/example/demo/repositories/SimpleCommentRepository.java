package com.example.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.SimpleComment;
 
public interface SimpleCommentRepository extends JpaRepository<SimpleComment, Long>
{
 
}
