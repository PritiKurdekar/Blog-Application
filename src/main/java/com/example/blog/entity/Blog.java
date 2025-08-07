package com.example.blog.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "blog")
public class Blog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String authorName;
	private String title;
	private String description;
	private String content;
	
	@OneToMany(mappedBy="blog",cascade = CascadeType.ALL)	
	private List<Hashtags> tags;

	public Blog() {
		super();
	}

	public Blog(int id, String authorName, String title, String description, String content, List<Hashtags> tags) {
		super();
		this.id = id;
		this.authorName = authorName;
		this.title = title;
		this.description = description;
		this.content = content;
		this.tags = tags;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Hashtags> getTags() {
		return tags;
	}

	public void setTags(List<Hashtags> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", authorName=" + authorName + ", title=" + title + ", description=" + description
				+ ", content=" + content + ", tags=" + tags + "]";
	}

}
