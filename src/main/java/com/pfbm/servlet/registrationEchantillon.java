package com.pfbm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pfbm.manager.PathologieDao;
import com.pfbm.manager.TypeEchantillonDao;
import com.pfbm.manager.TypeUserDao;

/**
 * Servlet implementation class registrationEchantillon
 */
@WebServlet("/registrationechantillon")
public class registrationEchantillon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registrationEchantillon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PathologieDao pathologieDao = new PathologieDao();
		request.setAttribute("listPathologie", pathologieDao.getListPathologie());
		
		TypeEchantillonDao typeEchantillonDao = new TypeEchantillonDao();
		request.setAttribute("listTypeEchantillonUlcereBuruli", typeEchantillonDao.getListTypeEchantillonByIdPathologie("PATHO-2022-1"));
		request.setAttribute("listTypeEchantillonMenin", typeEchantillonDao.getListTypeEchantillonByIdPathologie("PATHO-2022-2"));
		request.setAttribute("listTypeEchantillonLegio", typeEchantillonDao.getListTypeEchantillonByIdPathologie("PATHO-2022-3"));
		request.setAttribute("listTypeEchantillonChla", typeEchantillonDao.getListTypeEchantillonByIdPathologie("PATHO-2022-4"));
		
		String id_reception = request.getParameter("id_reception");
		
		//Envoi de id_reception par HttpSession
		HttpSession session = request.getSession();
		session.setAttribute("id_reception", id_reception);
		
		//HttpSession session = request.getSession();
		String login_user = (String) session.getAttribute("login_user");
		String nom_user = (String) session.getAttribute("nom_user");
		String prenom_user = (String) session.getAttribute("prenom_user");
		
		if(login_user == null && nom_user == null && prenom_user == null) {
			response.sendRedirect("sessionExpiree");
		}else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/view/registrationView/registrationEchantillon.jsp").forward(request, response);
		}
//		this.getServletContext().getRequestDispatcher("/WEB-INF/view/registrationView/registrationEchantillon.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
