package com.model;

import java.util.Date;

public class Post {

	int id;
	String contenu;
	Date date;
	String visibilite;
	
	User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getVisibilite() {
		return visibilite;
	}
	public void setVisibilite(String visibilite) {
		this.visibilite = visibilite;
	}
	
	
}
