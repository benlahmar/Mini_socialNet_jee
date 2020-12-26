package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Invitation;
import com.model.Post;
import com.model.User;
import com.model.Visibilite;
import com.util.DBInteraction;

public class UserDao implements IDao{

	@Override
	public int adduser(String log, String pass, String role) {
		DBInteraction.connect();
		String sql="insert into user values(null,'"+log+"','"+pass+"','"+role+"')";
		int n=DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		
		return n;
	}

	@Override
	public User auth(String log, String pass) {
		User u=null;
		DBInteraction.connect();
		String sql="select * from user where " +
				"log='"+log+"' and pass='"+pass+"'";
		ResultSet rs = DBInteraction.Select(sql);
		try {
			if(rs.next())
			{
				u=new User(rs.getString(2), rs.getString(3), rs.getString(4));
				u.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public List<User> allusers() {
		List<User> us=new ArrayList<User>();
		DBInteraction.connect();
		String sql="select * from user";
		ResultSet rs = DBInteraction.Select(sql);
		try {
			while(rs.next())
			{
				User u=new User(rs.getString(2), rs.getString(3), rs.getString(4));
				u.setId(rs.getInt(1));
				us.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return us;
	}

	@Override
	public int inviter(int idus, int idur) {
		DBInteraction.connect();
		String sql="insert into invitation(idus,idur) values("+idus+","+idur+")";
		int n=DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		
		return n;
	}

	@Override
	public int accepter(int idus, int idur) {
		DBInteraction.connect();
		String sql="update invitation set etat=1 where idus="+idus+" and idur="+idur;
		int n=DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		
		return n;
	}

	@Override
	public List<Invitation> allinvitation(int idu, boolean e) {
		List<Invitation> uss=new ArrayList<Invitation>();
		DBInteraction.connect();
		String sql="select * from invitation where etat="+e+" and idur="+idu;
		System.out.println(sql);
		ResultSet rsx = DBInteraction.Select(sql);
		try {
			while(rsx.next())
			{
				
				Invitation v=new Invitation();
				v.setId(rsx.getInt(1));
				v.setDate(rsx.getDate(2));
				v.setEtat(rsx.getBoolean(3));
				int idus=rsx.getInt(4);
				int idur=rsx.getInt(5);
				//recuperer les  users
				
				
				User us=new User();
				us.setId(idus);
				User ur=new User();
				ur.setId(idur);
				v.setUr(ur);
				v.setUs(us);
				uss.add(v);
			}
		} catch (SQLException ee) {
			// TODO Auto-generated catch block
			ee.printStackTrace();
		}
		System.out.println("***********"+uss.size());
		DBInteraction.disconnect();
		return uss;
	}

	@Override
	public int isinvited(int idus, int idur, boolean e) {
		int n=0;
		DBInteraction.connect();
		String sql="select * from invitation where idus="+idus+" and idur="+idur+" and etat="+e;
		ResultSet rs = DBInteraction.Select(sql);
		
		try {
			if(rs.next())
			{
				n=1;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DBInteraction.disconnect();
		return n;
	}

	
	public User finduser(int id) {
		User u=null;
		DBInteraction.connect();
		String sql="select * from user where id="+id ;
				
		ResultSet rs = DBInteraction.Select(sql);
		try {
			if(rs.next())
			{
				u=new User(rs.getString(2), rs.getString(3), rs.getString(4));
				u.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public int addPost(String contenu, Visibilite visib,int idu) {
		DBInteraction.connect();
		String sql="insert into post(contenu, visib, idu) value('"+contenu+"','"+visib+"',"+idu+")";
		int n=DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		
		return n;
	}

	@Override
	public List<Post> myposts(int idu) {
		List<Post> ps=new ArrayList<>();
		DBInteraction.connect();
		String sql="select * from post where idu="+idu+" order by date desc";
		ResultSet rs = DBInteraction.Select(sql);
		try {
			while(rs.next())
			{
				Post p=new Post();
				p.setId(rs.getInt(1));
				p.setContenu(rs.getString(2));
				p.setDate(rs.getDate(4));
				p.setVisibilite(rs.getString(3));
				int iduu=rs.getInt(5);
				User u=new User();
				u.setId(iduu);
				p.setUser(u);
				ps.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ps;
	}

	@Override
	public List<Post> allposts(int idu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addlike(int type, int idu, int idp) {
		DBInteraction.connect();
		String sql="insert into 4isis.like(type, idu, idp) values("+type+","+idu+","+idp+")";
		int n=DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		
		return n;
	}

	@Override
	public int likecount(int idp, int type) {
		DBInteraction.connect();
		String sql="select count(*) from 4isis.like where idp="+idp+" and type="+type;
		int nb=0;
		ResultSet rs = DBInteraction.Select(sql);
		try {
			rs.next();
			 nb=rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		DBInteraction.disconnect();
		return nb;
	}

}
