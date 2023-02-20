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

import com.pfbm.beans.Analyse;
import com.pfbm.manager.AnalyseDao;
import com.pfbm.manager.EchantillonDao;
import com.pfbm.manager.PathologieDao;
import com.pfbm.manager.TypeAnalyseDao;

/**
 * Servlet implementation class registrationAnalyse
 */
@WebServlet("/registrationAnalyse")
public class registrationAnalyse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registrationAnalyse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id_echantillon = request.getParameter("id_echantillon");
		request.setAttribute("id_echantillon", id_echantillon);
		
		String id_reception = request.getParameter("id_reception");
		request.setAttribute("id_reception1", id_reception);
		
		EchantillonDao echantillonDao = new EchantillonDao();
		request.setAttribute("echantillon", echantillonDao.getEchantillonByIdEchantillon(id_echantillon));
		
		PathologieDao pathologieDao = new PathologieDao();
		request.setAttribute("pathologie", pathologieDao);
		
		TypeAnalyseDao typeAnalyseDao = new TypeAnalyseDao();
		request.setAttribute("listTypeAnalyse", typeAnalyseDao.getListTypeAnalyses());
		
		
		HttpSession session = request.getSession();
		String login_user = (String) session.getAttribute("login_user");
		String nom_user = (String) session.getAttribute("nom_user");
		String prenom_user = (String) session.getAttribute("prenom_user");
		
		if(login_user == null && nom_user == null && prenom_user == null) {
			response.sendRedirect("sessionExpiree");
		}else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/view/registrationView/registrationAnalyse.jsp").forward(request, response);
		}
		
//		this.getServletContext().getRequestDispatcher("/WEB-INF/view/registrationView/registrationAnalyse.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	String date_analyse = request.getParameter("date_analyse");
	String num_labo = request.getParameter("num_labo");
	String grade_prescripteur = request.getParameter("grade_prescripteur");
	String prescripteur = request.getParameter("prescripteur");
	String site = request.getParameter("site");
	String adresse = request.getParameter("adresse");
	String id_echantillon = request.getParameter("id_echantillon");
	String id_type_analyse = request.getParameter("id_type_analyse");
	String type_examen = request.getParameter("type_examen");
	
	
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	java.util.Date trueDate = null;
	try {
		trueDate = simpleDateFormat.parse(date_analyse);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	java.sql.Date sqlDate = new java.sql.Date(trueDate.getTime());
	
	
	Analyse analyse = new Analyse();
	
	analyse.setDate_analyse(sqlDate);
	analyse.setNum_labo(num_labo);
	analyse.setGrade_prescripteur(grade_prescripteur);
	analyse.setPrescripteur(prescripteur);
	analyse.setSite(site);
	analyse.setAdresse(adresse);
	analyse.setId_echantillon(id_echantillon);
	analyse.setId_type_analyse(id_type_analyse);
	analyse.setType_examen(type_examen);
	
	
	EchantillonDao echantillonDao = new EchantillonDao();
	echantillonDao.changeStatusAnalyse(id_echantillon);
	
	AnalyseDao analyseDao = new AnalyseDao();
	analyseDao.addAnalyse(analyse);
	response.sendRedirect("registrationAnalyse?id_echantillon="+id_echantillon);
	}
}



