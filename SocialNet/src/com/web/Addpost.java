package com.web;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.model.User;
import com.model.Visibilite;

/**
 * Servlet implementation class Addpost
 */
@WebServlet("/Addpost")
public class Addpost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       UserDao dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addpost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		dao=new UserDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses = request.getSession();
		User u=(User) ses.getAttribute("user");
		String contenu= request.getParameter("contenu");
		String visib= request.getParameter("visib");
		Visibilite vis=Visibilite.Public;
		if(visib.equals("public"))
		vis=Visibilite.Public;
		else
			if(visib.equals("private"))
				vis=Visibilite.Private;
			else
				vis=Visibilite.Amis;
		dao.addPost(contenu, vis, u.getId());
		response.sendRedirect("starter.jsp");
	
	}

}
