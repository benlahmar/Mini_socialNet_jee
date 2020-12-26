package com.model;

import java.util.Date;

public class Invitation {

	int id;
	Date date;
	boolean etat;
	User us,ur;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public User getUs() {
		return us;
	}
	public void setUs(User us) {
		this.us = us;
	}
	public User getUr() {
		return ur;
	}
	public void setUr(User ur) {
		this.ur = ur;
	}
	public Invitation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
