package com.pfbm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pfbm.beans.Transporteur;
import com.pfbm.manager.TransporteurDao;

/**
 * Servlet implementation class registrationTransporteur
 */
@WebServlet("/registrationTransporteur")
public class registrationTransporteur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registrationTransporteur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom_transporteur = request.getParameter("nom_transporteur");
		String prenom_transporteur = request.getParameter("prenom_transporteur");
		String contact_transporteur = request.getParameter("contact_transporteur");
		String sexe_transporteur = request.getParameter("sexe_transporteur");
		
		Transporteur transporteur = new Transporteur();
		transporteur.setNom_transporteur(nom_transporteur);
		transporteur.setPrenom_transporteur(prenom_transporteur);
		transporteur.setContact_transporteur(contact_transporteur);
		transporteur.setSexe_transporteur(sexe_transporteur);
		
		TransporteurDao transporteurDao = new TransporteurDao();
		transporteurDao.addTransporteur(transporteur);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/view/registrationView/registrationReception.jsp").forward(request, response);
	}

}
