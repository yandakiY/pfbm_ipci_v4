package com.pfbm.servlet;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pfbm.beans.Patient;
import com.pfbm.manager.PatientDao;

/**
 * Servlet implementation class registrationPatient
 */
@WebServlet("/registrationPatient")
public class registrationPatient extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registrationPatient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		String nom_patient = request.getParameter("nom_patient");
		String prenom_patient = request.getParameter("prenom_patient");
		String sexe_patient = request.getParameter("sexe_patient");
		int age_patient = Integer.parseInt(request.getParameter("age_patient"));
		String numero_patient = request.getParameter("contact_patient");
		
		Patient patient = new Patient();
		patient.setNom_patient(nom_patient);
		patient.setPrenom_patient(prenom_patient);
		patient.setSexe_patient(sexe_patient);
		patient.setAge_patient(age_patient);
		patient.setNumero_patient(numero_patient);
		
		PatientDao patientDao = new PatientDao();
		patientDao.addPatient(patient);
		*/
		response.getWriter().append("Nom : ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom_patient = request.getParameter("nom_patient");
		String prenom_patient = request.getParameter("prenom_patient");
		String sexe_patient = request.getParameter("sexe_patient");
		int age_patient = Integer.parseInt(request.getParameter("age_patient"));
		String contact_patient = request.getParameter("contact_patient");
		
		Patient patient = new Patient();
		patient.setNom_patient(nom_patient);
		patient.setPrenom_patient(prenom_patient);
		patient.setSexe_patient(sexe_patient);
		patient.setAge_patient(age_patient);
		patient.setContact_patient(contact_patient);
		
		PatientDao patientDao = new PatientDao();
		patientDao.addPatient(patient);
		
		//String id_reception = request.getParameter("id_reception");
		String id_reception = request.getParameter("id_reception");
		response.sendRedirect("registrationechantillon?id_reception="+id_reception);
	}

}
