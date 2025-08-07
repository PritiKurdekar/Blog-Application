package com.example.blog.service;

import java.util.List;

import com.example.blog.entity.Blog;


public interface BlogService {

	List<Blog> getAllBlogs();

	Blog createBlog(Blog blog);

	Blog getByBlogId(int id);

	Blog updateBlogById(int id,Blog updatedblog);

	String deleteBlogById(int id);

}
