package com.example.blog.exception;

public class BlogNotFoundException extends RuntimeException{
	public BlogNotFoundException(String msg) {
		super(msg);
	}
}
