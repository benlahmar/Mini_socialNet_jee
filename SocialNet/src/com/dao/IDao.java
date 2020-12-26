package com.dao;

import java.util.List;

import com.model.Invitation;
import com.model.Post;
import com.model.User;
import com.model.Visibilite;

public interface IDao {

	public int adduser(String log,String pass,String role);
	public User auth(String log,String pass);
	public List<User> allusers();
	
	public int inviter(int idus, int idur);
	public int accepter(int idus, int idur);
	public List<Invitation> allinvitation(int idu, boolean e);
	
	public int isinvited(int idus, int idur, boolean e);
	
	public int addPost(String contenu, Visibilite visib, int idu);
	public List<Post> myposts(int idu);
	public List<Post> allposts(int idu);
	
}
