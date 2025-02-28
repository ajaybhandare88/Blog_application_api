package com.project.api.blog.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int commentId;
	
	private String content;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Post post;

	public Comment(int commentId, String content, User user, Post post) {
		super();
		this.commentId = commentId;
		this.content = content;
		this.user = user;
		this.post = post;
	}

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "comment [commentId=" + commentId + ", content=" + content + ", user=" + user + ", post=" + post + "]";
	}

	
}
