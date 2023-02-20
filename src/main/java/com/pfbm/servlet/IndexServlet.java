package com.pfbm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pfbm.manager.EchantillonDao;
import com.pfbm.manager.ReceptionDao;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ReceptionDao receptionDao = new ReceptionDao();
		request.setAttribute("receptionsEffectuees", receptionDao.getCountReception());
		
		EchantillonDao echantillonDao = new EchantillonDao();
		
		request.setAttribute("echantillons", echantillonDao.getCountEchantillon());
		request.setAttribute("echantillonReceptionnes", echantillonDao.getCountStatusRecus());
		request.setAttribute("echantillonTraite", echantillonDao.getCountStatusTraite());
		request.setAttribute("echantillonConserve", echantillonDao.getCountStatusConserve());
		request.setAttribute("echantillonResultatsTransmis", echantillonDao.getCountResultatTransmis());
		
		String nom = "Boa Yandaki";
		request.setAttribute("nom", nom);
		
		HttpSession session = request.getSession();
		String login_user = (String) session.getAttribute("login_user");
		String nom_user = (String) session.getAttribute("nom_user");
		String prenom_user = (String) session.getAttribute("prenom_user");
		
		if(login_user == null && nom_user == null && prenom_user == null) {
			response.sendRedirect("sessionExpiree");
		}else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
		}
		
		
		
		
		
		// System.out.println("Login : "+login_user+ "\nNom user : "+nom_user + "Prenom user : "+prenom_user);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
