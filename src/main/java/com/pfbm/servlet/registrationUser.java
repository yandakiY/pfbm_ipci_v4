package com.pfbm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pfbm.beans.User;
import com.pfbm.manager.TypeUserDao;
import com.pfbm.manager.UserDao;

/**
 * Servlet implementation class registrationUser
 */
@WebServlet("/adduser")
public class registrationUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registrationUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TypeUserDao typeUserDao = new TypeUserDao();
		
		request.setAttribute("listTypeUser", typeUserDao.getListTypeUser());
		
		HttpSession session = request.getSession();
		String login_user = (String) session.getAttribute("login_user");
		String nom_user = (String) session.getAttribute("nom_user");
		String prenom_user = (String) session.getAttribute("prenom_user");
		
		if(login_user == null && nom_user == null && prenom_user == null) {
			response.sendRedirect("sessionExpiree");
		}else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/view/registrationView/registrationUser.jsp").forward(request, response);
		}
//		this.getServletContext().getRequestDispatcher("/WEB-INF/view/registrationView/registrationUser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom_user = request.getParameter("nom_user");
		String prenom_user = request.getParameter("prenom_user");
		String login_user = request.getParameter("login_user");
		String mdp_user = request.getParameter("mdp_user");
		String id_type_user = request.getParameter("id_type_user");
		
		User user = new User();
		user.setNom_user(nom_user);
		user.setPrenom_user(prenom_user);
		user.setLogin_user(login_user);
		user.setMdp_user(mdp_user);
		user.setId_type_user(id_type_user);
		
		UserDao userDao = new UserDao();
		TypeUserDao typeUserDao = new TypeUserDao();
		
		int checkUserBD = userDao.checkUserBD(user);
		
		if(checkUserBD == 0) {
			userDao.addUser(user);
			request.setAttribute("listTypeUser", typeUserDao.getListTypeUser());
			this.getServletContext().getRequestDispatcher("/WEB-INF/view/registrationView/registrationUser.jsp").forward(request, response);
		}else {
			request.setAttribute("checkUserBD", false);
			request.setAttribute("nom_user", nom_user);
			request.setAttribute("prenom_user", prenom_user);
			request.setAttribute("login_user", login_user);
			
			TypeUserDao typeUserDao1 = new TypeUserDao();
			
			request.setAttribute("listTypeUser", typeUserDao1.getListTypeUser());
			this.getServletContext().getRequestDispatcher("/WEB-INF/view/registrationView/registrationUser.jsp").forward(request, response);
		}
		
		/*
		TypeUserDao typeUserDao = new TypeUserDao();
		request.setAttribute("listTypeUser", typeUserDao.getListTypeUser());
		this.getServletContext().getRequestDispatcher("/WEB-INF/view/registrationView/registrationUser.jsp").forward(request, response);
		*/
		
	}

}
