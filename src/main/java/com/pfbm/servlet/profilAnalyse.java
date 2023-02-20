package com.pfbm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pfbm.beans.TypeAnalyse;
import com.pfbm.manager.AnalyseDao;
import com.pfbm.manager.EchantillonDao;
import com.pfbm.manager.InterpretationDao;
import com.pfbm.manager.PathologieDao;
import com.pfbm.manager.PatientDao;
import com.pfbm.manager.ReceptionDao;
import com.pfbm.manager.ResultatDao;
import com.pfbm.manager.TypeAnalyseDao;

/**
 * Servlet implementation class profilAnalyse
 */
@WebServlet("/profilanalyse")
public class profilAnalyse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public profilAnalyse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id_analyse = request.getParameter("id_analyse");
		request.setAttribute("id_analyse", id_analyse);
		
		ReceptionDao receptionDao = new ReceptionDao();
		request.setAttribute("reception", receptionDao);
		
		AnalyseDao analyseDao = new AnalyseDao();
		request.setAttribute("analyse", analyseDao.getAnalyseByIdAnalyse(id_analyse));
		
		EchantillonDao echantillonDao = new EchantillonDao();
		request.setAttribute("echantillon", echantillonDao);
		
		TypeAnalyseDao typeAnalyseDao = new TypeAnalyseDao();
		request.setAttribute("typeAnalyse", typeAnalyseDao);
		
		ResultatDao resultatDao = new ResultatDao();
		request.setAttribute("resultat", resultatDao.getResultatForIdAnalyse(id_analyse));
		
		PatientDao patientDao = new PatientDao();
		request.setAttribute("patient", patientDao);
		
		PathologieDao pathologieDao = new PathologieDao();
		request.setAttribute("pathologie", pathologieDao);
		
		InterpretationDao interpretationDao = new InterpretationDao();
		request.setAttribute("interpretations", interpretationDao);
		
		HttpSession session = request.getSession();
		String login_user = (String) session.getAttribute("login_user");
		String nom_user = (String) session.getAttribute("nom_user");
		String prenom_user = (String) session.getAttribute("prenom_user");
		
		if(login_user == null && nom_user == null && prenom_user == null) {
			response.sendRedirect("sessionExpiree");
		}else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/view/profilView/profilAnalyse.jsp").forward(request, response);
		}
		
		//this.getServletContext().getRequestDispatcher("/WEB-INF/view/profilView/profilAnalyse.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
