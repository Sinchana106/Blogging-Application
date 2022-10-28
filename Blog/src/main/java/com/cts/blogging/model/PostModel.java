package com.cts.blogging.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="post")
public class PostModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotBlank(message = "Title cannot be empty")
	private String title;
	@Column(name = "content")
	@Lob
	@NotEmpty
	private String content;	
	@Column(name="created_on")
	private Instant createdOn;
	@Column(name="updated_on")
	private Instant updatedOn;
	@Column(name = "user_name")
	private String userName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Instant getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Instant createdOn) {
		this.createdOn = createdOn;
	}
	public Instant getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Instant updatedOn) {
		this.updatedOn = updatedOn;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public PostModel(int id, @NotBlank(message = "Title cannot be empty") String title, @NotEmpty String content,
			Instant createdOn, Instant updatedOn, String userName) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.userName = userName;
	}
	public PostModel() {
		super();
	}
	
}
