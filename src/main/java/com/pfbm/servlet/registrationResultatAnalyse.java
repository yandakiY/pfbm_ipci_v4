package com.pfbm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pfbm.beans.Echantillon;
import com.pfbm.beans.Resultat;
import com.pfbm.manager.AnalyseDao;
import com.pfbm.manager.EchantillonDao;
import com.pfbm.manager.ResultatDao;

/**
 * Servlet implementation class registrationResultatAnalyse
 */
@WebServlet("/registrationresultatanalyse")
public class registrationResultatAnalyse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registrationResultatAnalyse() {
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
		
		AnalyseDao analyseDao = new AnalyseDao();
		request.setAttribute("analyse", analyseDao.getAnalyseByIdAnalyse(id_analyse));
		
		HttpSession session = request.getSession();
		String login_user = (String) session.getAttribute("login_user");
		String nom_user = (String) session.getAttribute("nom_user");
		String prenom_user = (String) session.getAttribute("prenom_user");
		
		if(login_user == null && nom_user == null && prenom_user == null) {
			response.sendRedirect("sessionExpiree");
		}else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/view/registrationView/registrationResultatAnalyse.jsp").forward(request, response);
		}
		
		//this.getServletContext().getRequestDispatcher("/WEB-INF/view/registrationView/registrationResultatAnalyse.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int valeur_ct = Integer.parseInt(request.getParameter("valeur_ct"));
		String status_resultat = request.getParameter("status_resultat");
		String observation_resultat = request.getParameter("observation_resultat");
		String id_analyse = request.getParameter("id_analyse");
		String id_echantillon = request.getParameter("id_echantillon");
		
		Resultat resultat = new Resultat();
		resultat.setValeur_ct(valeur_ct);
		resultat.setStatus_resultat(status_resultat);
		resultat.setObservation_resultat(observation_resultat);
		resultat.setId_analyse(id_analyse);
		
		
		EchantillonDao echantillonDao = new EchantillonDao();
		Echantillon echantillon = new Echantillon();
		
		echantillon = echantillonDao.getEchantillonByIdEchantillon(id_echantillon);
		
		// Reflexion au niveau de la mise en place de la conservation status_conservation
		
		if( ( echantillon.getVolume_echantillon() > 200 ) && (valeur_ct >= 18 && valeur_ct <= 30) && status_resultat.equals("positif")) {
			// Si l'echantillon concern�e a un volume superieur a 200 , une valeur CT pour le resultat compris entre 18 et 30 et status de positif
			echantillonDao.changeStatusAConservé(id_echantillon);
		}else { // Sinon
			echantillonDao.changeStatusPasConservé(id_echantillon);
		}
		
		echantillonDao.changeStatusResultat(id_echantillon);
		
		AnalyseDao analyseDao = new AnalyseDao();
		analyseDao.changeStatusResultatInAnalyse(resultat.getId_analyse());
		
		ResultatDao resultatDao = new ResultatDao();
		resultatDao.addResultat(resultat);
		
		response.sendRedirect("tableanalyseparechantillon?id_echantillon="+id_echantillon);
	}

}
