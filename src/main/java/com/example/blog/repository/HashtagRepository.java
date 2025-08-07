package com.example.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.blog.entity.Hashtags;
@Repository
public interface HashtagRepository extends JpaRepository<Hashtags, Integer>{

}
