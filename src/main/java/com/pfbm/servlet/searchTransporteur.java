package com.pfbm.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pfbm.beans.Reception;
import com.pfbm.beans.Transporteur;
import com.pfbm.manager.ReceptionDao;
import com.pfbm.manager.TransporteurDao;

/**
 * Servlet implementation class searchTransporteur
 */
@WebServlet("/searchTransporteur")
public class searchTransporteur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchTransporteur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String numeroSearch = request.getParameter("numeroSearch");
		
		
		TransporteurDao transporteurDao = new TransporteurDao();
		int checkTransporteur = transporteurDao.checkTransporteurInBd(numeroSearch);
		
		if(checkTransporteur == 1) {
			System.out.println("Valeur"+ checkTransporteur+"Access");
			request.setAttribute("checkTransporteur", true);
			request.setAttribute("transporteur", transporteurDao.getTransportByNumero(numeroSearch));
			
			
			HttpSession session = request.getSession();
			String login_user = (String) session.getAttribute("login_user");
			String nom_user = (String) session.getAttribute("nom_user");
			String prenom_user = (String) session.getAttribute("prenom_user");
			
			if(login_user == null && nom_user == null && prenom_user == null) {
				response.sendRedirect("sessionExpiree");
			}else {
				this.getServletContext().getRequestDispatcher("/WEB-INF/view/registrationView/registrationReception.jsp").forward(request, response);
			}
			
//			this.getServletContext().getRequestDispatcher("/WEB-INF/view/registrationView/registrationReception.jsp").forward(request, response);
		}else {
			System.out.println("Valeur"+ checkTransporteur+" Pas Access");
			request.setAttribute("checkTransporteur", false);
			
			HttpSession session = request.getSession();
			String login_user = (String) session.getAttribute("login_user");
			String nom_user = (String) session.getAttribute("nom_user");
			String prenom_user = (String) session.getAttribute("prenom_user");
			
			if(login_user == null && nom_user == null && prenom_user == null) {
				response.sendRedirect("sessionExpiree");
			}else {
				this.getServletContext().getRequestDispatcher("/WEB-INF/view/registrationView/registrationReception.jsp").forward(request, response);
			}
			//this.getServletContext().getRequestDispatcher("/WEB-INF/view/registrationView/registrationReception.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id_reception = request.getParameter("id_reception");
		String provenance = request.getParameter("provenance");
		String code_glaciere = request.getParameter("code_glaciere");
		String nom_glaciere = request.getParameter("nom_glaciere");
		String id_transporteur = request.getParameter("id_transporteur");
		int temperature_debut = Integer.parseInt(request.getParameter("temperature_debut"));
		int temperature_arrivee = Integer.parseInt(request.getParameter("temperature_arrivee"));
		int nb_prelevement = Integer.parseInt(request.getParameter("nb_prelevement"));
		
		/* Convertion Date */
		String date_reception = request.getParameter("date_prelevement");	
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		java.util.Date trueDate = null;
		try {
			trueDate = simpleDateFormat.parse(date_reception);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date sqlDate = new java.sql.Date(trueDate.getTime());
		
		Reception reception = new Reception();
		reception.setId_reception(id_reception);
		reception.setProvenance(provenance);
		reception.setCode_glaciere(code_glaciere);
		reception.setNom_glaciere(nom_glaciere);
		reception.setNb_prelevement(nb_prelevement);
		reception.setDate_reception(sqlDate);
		reception.setTemperature_debut(temperature_debut);
		reception.setTemperature_arrivee(temperature_arrivee);
		reception.setId_transporteur(id_transporteur);
		
		ReceptionDao receptionDao = new ReceptionDao();
		receptionDao.addReception(reception);
		
		response.sendRedirect("registrationreception");
	}

}
