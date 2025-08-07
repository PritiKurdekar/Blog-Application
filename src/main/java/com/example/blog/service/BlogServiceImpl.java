package com.example.blog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blog.entity.Blog;
import com.example.blog.entity.Hashtags;
import com.example.blog.exception.BlogNotFoundException;
import com.example.blog.repository.BlogRepository;
import com.example.blog.repository.HashtagRepository;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private HashtagRepository hashtagRepository;

	@Override
	public List<Blog> getAllBlogs() {
		List<Blog> listBlogs = blogRepository.findAll();
		return listBlogs;
	}

	@Override
	public Blog createBlog(Blog blog) {
		List<Hashtags> list=blog.getTags();
		for(Hashtags tag:list) {
			tag.setBlog(blog);
		}
		blogRepository.save(blog);	
		return blog;
	}

	@Override
	public Blog getByBlogId(int id) {
		Optional<Blog> optionalBlog = blogRepository.findById(id);
		if (optionalBlog.isPresent()) {

			return optionalBlog.get();
		} else {
			throw new BlogNotFoundException("Blog Id does not exists");
		}

	}

	@Override
	public Blog updateBlogById(int id, Blog updatedblog) {
		Optional<Blog> blog = blogRepository.findById(id);
		if (blog.isPresent()) {
			blog.get().setAuthorName(updatedblog.getAuthorName());
			blog.get().setTitle(updatedblog.getTitle());
			blog.get().setDescription(updatedblog.getDescription());
			blog.get().setContent(updatedblog.getContent());
			blog.get().setTags(updatedblog.getTags());

			return blogRepository.save(blog.get());
		}
		else {
			throw new BlogNotFoundException("ID does not exists"+id);
		}

	}

	@Override
	public String deleteBlogById(int id) {
		Optional<Blog> blog=blogRepository.findById(id);
		if(blog.isPresent()) {
			blogRepository.deleteById(blog.get().getId());
			return "Blog deleted successfully :"+id;
		}
		else {
			throw new BlogNotFoundException("ID does not exists"+id);
		}
		
	}

}