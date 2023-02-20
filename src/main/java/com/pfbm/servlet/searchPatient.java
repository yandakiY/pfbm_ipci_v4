package com.pfbm.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pfbm.beans.Echantillon;
import com.pfbm.manager.EchantillonDao;
import com.pfbm.manager.PathologieDao;
import com.pfbm.manager.PatientDao;
import com.pfbm.manager.TypeEchantillonDao;

/**
 * Servlet implementation class searchPatient
 */
@WebServlet("/searchPatient")
public class searchPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchPatient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id_reception = request.getParameter("id_reception");
		String numeroSearch = request.getParameter("numeroSearch");
		
		PatientDao patientDao = new PatientDao();
		int checkPatient = patientDao.checkPatientInBd(numeroSearch);
		
		if(checkPatient == 1) {
			System.out.println("Access accordé,Valeur : "+checkPatient);
			PathologieDao pathologieDao = new PathologieDao();
			request.setAttribute("listPathologie", pathologieDao.getListPathologie());
			
			TypeEchantillonDao typeEchantillonDao = new TypeEchantillonDao();
			request.setAttribute("listTypeEchantillonUlcereBuruli", typeEchantillonDao.getListTypeEchantillonByIdPathologie("PATHO-2022-1"));
			request.setAttribute("listTypeEchantillonMenin", typeEchantillonDao.getListTypeEchantillonByIdPathologie("PATHO-2022-2"));
			request.setAttribute("listTypeEchantillonLegio", typeEchantillonDao.getListTypeEchantillonByIdPathologie("PATHO-2022-3"));
			request.setAttribute("listTypeEchantillonChla", typeEchantillonDao.getListTypeEchantillonByIdPathologie("PATHO-2022-4"));
			
			
			request.setAttribute("id_reception", id_reception);
			request.setAttribute("checkPatient", true);
			request.setAttribute("patient", patientDao.getPatientByNumero(numeroSearch));
			
			HttpSession session = request.getSession();
			String login_user = (String) session.getAttribute("login_user");
			String nom_user = (String) session.getAttribute("nom_user");
			String prenom_user = (String) session.getAttribute("prenom_user");
			
			if(login_user == null && nom_user == null && prenom_user == null) {
				response.sendRedirect("sessionExpiree");
			}else {
				this.getServletContext().getRequestDispatcher("/WEB-INF/view/registrationView/registrationEchantillon.jsp").forward(request, response);
			}
			
			//this.getServletContext().getRequestDispatcher("/WEB-INF/view/registrationView/registrationEchantillon.jsp").forward(request, response);
		}else {
			System.out.println("Acces pas-accordé,Valeur : "+checkPatient);
			request.setAttribute("id_reception", id_reception);;
			request.setAttribute("checkPatient", false);
			
			/////
			PathologieDao pathologieDao = new PathologieDao();
			request.setAttribute("listPathologie", pathologieDao.getListPathologie());
			
			TypeEchantillonDao typeEchantillonDao = new TypeEchantillonDao();
			request.setAttribute("listTypeEchantillonUlcereBuruli", typeEchantillonDao.getListTypeEchantillonByIdPathologie("PATHO-2022-1"));
			request.setAttribute("listTypeEchantillonMenin", typeEchantillonDao.getListTypeEchantillonByIdPathologie("PATHO-2022-2"));
			request.setAttribute("listTypeEchantillonLegio", typeEchantillonDao.getListTypeEchantillonByIdPathologie("PATHO-2022-3"));
			request.setAttribute("listTypeEchantillonChla", typeEchantillonDao.getListTypeEchantillonByIdPathologie("PATHO-2022-4"));
			
			
			request.setAttribute("patient", patientDao.getPatientByNumero(numeroSearch));
			
			HttpSession session = request.getSession();
			String login_user = (String) session.getAttribute("login_user");
			String nom_user = (String) session.getAttribute("nom_user");
			String prenom_user = (String) session.getAttribute("prenom_user");
			
			if(login_user == null && nom_user == null && prenom_user == null) {
				response.sendRedirect("sessionExpiree");
			}else {
				this.getServletContext().getRequestDispatcher("/WEB-INF/view/registrationView/registrationEchantillon.jsp").forward(request, response);
			}
			
			//this.getServletContext().getRequestDispatcher("/WEB-INF/view/registrationView/registrationEchantillon.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int volume_echantillon = Integer.parseInt(request.getParameter("volume_echantillon"));
		String id_pathologie = request.getParameter("id_pathologie");
		String id_patient = request.getParameter("id_patient");
		String id_reception = request.getParameter("id_reception");
		String id_type_echantillon = request.getParameter("id_type_echantillon");
		
		//Conversion date String en date - Date.java.sql
		String date_prelevement	= request.getParameter("date_prelevement");
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date trueDate = null;
		try {
			trueDate = simpleDateFormat.parse(date_prelevement);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date sqlDate = new java.sql.Date(trueDate.getTime());
		
		Echantillon echantillon = new Echantillon();
		echantillon.setVolume_echantillon(volume_echantillon);
		echantillon.setId_pathologie(id_pathologie);
		echantillon.setId_patient(id_patient);
		echantillon.setId_reception(id_reception);
		echantillon.setId_type_echantillon(id_type_echantillon);
		echantillon.setDate_prelevement(sqlDate);
		
		EchantillonDao echantillonDao = new EchantillonDao();
		echantillonDao.addEchantillon(echantillon);
		
		response.sendRedirect("registrationechantillon?id_reception="+id_reception);
	}
}
