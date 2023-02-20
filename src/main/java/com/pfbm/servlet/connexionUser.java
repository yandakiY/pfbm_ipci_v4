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
 * Servlet implementation class connexionUser
 */
@WebServlet("/connexionUser")
public class connexionUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public connexionUser() {
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
		this.getServletContext().getRequestDispatcher("/WEB-INF/view/registrationView/connexionUser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login_user = request.getParameter("login_user");
		String mdp_user = request.getParameter("mdp_user");
		String id_type_user = request.getParameter("id_type_user");
		
		User user = new User();
		user.setLogin_user(login_user);
		user.setId_type_user(id_type_user);
		user.setMdp_user(mdp_user);
		
		UserDao userDao = new UserDao();
		//User userDao1 = new User();
		TypeUserDao typeUserDao = new TypeUserDao();
		int checkUser = userDao.checkUser(user);
		//userDao1 = userDao.getUser(login_user, mdp_user);
		
		if(checkUser == 1) {
			User user1 = new User();
			user1 = userDao.getUser(login_user, mdp_user);
			System.out.println("Variable : "+checkUser+" Autorise");
			HttpSession session=request.getSession();
			session.setAttribute("login_user", user1.getLogin_user());
			session.setAttribute("nom_user", user1.getNom_user());
			session.setAttribute("prenom_user", user1.getPrenom_user());
			session.setAttribute("type_user", user1.getId_type_user());
			
			if(user.getId_type_user() == "TU-2022-1") {
				response.sendRedirect("statistiquespathologies");
			}
			else {
				response.sendRedirect("tablereception");
			}
			//this.getServletContext().getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
		}else {
			System.out.println("Variable : "+checkUser+"Pas autorise");
			request.setAttribute("login_user", login_user);
			request.setAttribute("listTypeUser", typeUserDao.getListTypeUser());
			request.setAttribute("checkUser", false);
			this.getServletContext().getRequestDispatcher("/WEB-INF/view/registrationView/connexionUser.jsp").forward(request, response);
		}
	}

}
