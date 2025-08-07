package com.example.blog.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "HashTags")
public class Hashtags {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hashId;
	private String hashtag;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "blog_id")
	@JsonBackReference
	private Blog blog;

	public Hashtags() {
		super();
	}

	public Hashtags(int hashId, String hashtag, Blog blog) {
		super();
		this.hashId = hashId;
		this.hashtag = hashtag;
		this.blog = blog;
	}

	public int getHashId() {
		return hashId;
	}

	public void setHashId(int hashId) {
		this.hashId = hashId;
	}

	public String getHashtag() {
		return hashtag;
	}

	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	@Override
	public String toString() {
		return "Hashtags [hashId=" + hashId + ", hashtag=" + hashtag + ", blog=" + blog + "]";
	}

}
