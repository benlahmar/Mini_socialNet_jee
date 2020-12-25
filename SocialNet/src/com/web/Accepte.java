package com.web;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;

/**
 * Servlet implementation class Accepte
 */
@WebServlet("/Accepte")
public class Accepte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       UserDao dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Accepte() {
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
		int idus=Integer.parseInt(request.getParameter("idus"));
		int idur=Integer.parseInt(request.getParameter("idur"));
		
		dao.accepter(idus, idur);
		response.sendRedirect("index2.jsp");
	}

}
