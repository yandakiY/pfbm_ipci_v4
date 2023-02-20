package com.pfbm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pfbm.manager.AnalyseDao;
import com.pfbm.manager.EchantillonDao;
import com.pfbm.manager.PathologieDao;
import com.pfbm.manager.ResultatDao;

/**
 * Servlet implementation class statistiquesPathologies
 */
@WebServlet("/statistiquespathologies")
public class statistiquesPathologies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public statistiquesPathologies() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		PathologieDao pathologieDao = new PathologieDao();
		request.setAttribute("pathologie", pathologieDao);
		
		EchantillonDao echantillonDao = new EchantillonDao();
		request.setAttribute("echantillons", echantillonDao.getCountEchantillon());
		request.setAttribute("echantillonsUlcere", echantillonDao.getCountEchantillonUlcere());
		request.setAttribute("echantillonsMeningite", echantillonDao.getCountEchantillonMeningite());
		request.setAttribute("echantillonsLegionnella", echantillonDao.getCountEchantillonLegionnella());
		request.setAttribute("echantillonsChla", echantillonDao.getCountEchantillonCHLA());
		
		// Concernant les resultats
		
		ResultatDao resultatDao = new ResultatDao();
		request.setAttribute("resultats", resultatDao.getCountResultat());
		request.setAttribute("resultatsPositifs", resultatDao.getCountResultatPositif());
		request.setAttribute("resultatsNegatif", resultatDao.getCountResultatNegatif());
		
		// Concernant les echantillons a conserver ou pas
		
		request.setAttribute("echantillonsConserver", echantillonDao.getCountEchantillonAConserver());
		request.setAttribute("echantillonPasconserver", echantillonDao.getCountEchantillonPasConserver());
		request.setAttribute("conservationNotDeterminate", echantillonDao.getCountEchantillonPasDeterminé());
		
		// Concernant les echantillons a conserver ou pas
		
		AnalyseDao analyseDao = new AnalyseDao();
		request.setAttribute("analyse", analyseDao.getCountAnalyse());
		request.setAttribute("analyseUlcere", analyseDao.getCountAnalysePourUlcere());
		request.setAttribute("analyseMeningite", analyseDao.getCountAnalysePourMeningite());
		request.setAttribute("analyseLegionella", analyseDao.getCountAnalysePourLegionella());
		request.setAttribute("analyseChla", analyseDao.getCountAnalysePourChla());
		
		// Analyse positif et negatif de chaque pathologies
		request.setAttribute("essaiPi", Math.PI);
		request.setAttribute("analyseUlcerePositif", (int) analyseDao.getCountAnalysePositifUlcere());
		request.setAttribute("analyseLegionellaPositif", (int) analyseDao.getCountAnalysePositifLegionella());
		request.setAttribute("analyseMeningitePositif", (int) analyseDao.getCountAnalysePositifMeningite());
		request.setAttribute("analyseChlaPositif", (int) analyseDao.getCountAnalysePositifChla());
		
		request.setAttribute("analyseUlcereNegatif", (int) analyseDao.getCountAnalyseNegatifUlcere());
		request.setAttribute("analyseLegionellaNegatif", (int) analyseDao.getCountAnalyseNegatifLegionella());
		request.setAttribute("analyseMeningiteNegatif", (int) analyseDao.getCountAnalyseNegatifMeningite());
		request.setAttribute("analyseChlaNegatif", (int) analyseDao.getCountAnalyseNegatifChla());
		
		HttpSession session = request.getSession();
		String login_user = (String) session.getAttribute("login_user");
		String nom_user = (String) session.getAttribute("nom_user");
		String prenom_user = (String) session.getAttribute("prenom_user");
		
		if(login_user == null && nom_user == null && prenom_user == null) {
			response.sendRedirect("sessionExpiree");
		}else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/view/profilView/statistiquespathologies.jsp").forward(request, response);
		}
		
		//this.getServletContext().getRequestDispatcher("/WEB-INF/view/profilView/statistiquespathologies.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
