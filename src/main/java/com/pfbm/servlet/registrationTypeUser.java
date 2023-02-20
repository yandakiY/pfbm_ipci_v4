package com.pfbm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pfbm.beans.TypeUser;
import com.pfbm.manager.TypeUserDao;

@WebServlet("/registrationTypeUser")
public class registrationTypeUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registrationTypeUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/view/registrationView/registrationTypeUser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nom_type_user = request.getParameter("nom_type_user");
		String description_type_user = request.getParameter("description_type_user");
		
		TypeUser typeUser = new TypeUser();
		typeUser.setNom_type_user(nom_type_user);
		typeUser.setDescription_type_user(description_type_user);
		
		TypeUserDao typeUserDao = new TypeUserDao();
		typeUserDao.addTypeUser(typeUser);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/view/registrationView/registrationTypeUser.jsp").forward(request, response);
		/*
		TypeUserDao typeUserDao = new TypeUserDao();
		System.out.println(typeUserDao.getCountTypeUser());
		this.getServletContext().getRequestDispatcher("/WEB-INF/view/registrationView/registrationTypeUser.jsp").forward(request, response);
		*/
	}

}
