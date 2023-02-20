package com.pfbm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class registrationReceptionEchantillon
 */
@WebServlet("/registrationreception")
public class registrationReception extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registrationReception() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		String login_user = (String) session.getAttribute("login_user");
		String nom_user = (String) session.getAttribute("nom_user");
		String prenom_user = (String) session.getAttribute("prenom_user");
		
		if(login_user == null && nom_user == null && prenom_user == null) {
			response.sendRedirect("sessionExpiree");
		}else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/view/registrationView/registrationReception.jsp").forward(request, response);
		}
//		this.getServletContext().getRequestDispatcher("/WEB-INF/view/registrationView/registrationReception.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
