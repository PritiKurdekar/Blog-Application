package com.example.blog.entity;

import jakarta.persistence.ManyToMany;

public class Student {
      int id;
      String name;
      
      @ManyToMany(mappedBy = "student")      
      Courses courseName;
}
