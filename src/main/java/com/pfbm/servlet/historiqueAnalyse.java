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
import com.pfbm.manager.ResultatDao;
import com.pfbm.manager.TypeAnalyseDao;

/**
 * Servlet implementation class historiqueAnalyse
 */
@WebServlet("/historiqueanalyse")
public class historiqueAnalyse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public historiqueAnalyse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id_echantillon = request.getParameter("id_echantillon");
		request.setAttribute("id_echantillon", id_echantillon);
		
		TypeAnalyseDao typeAnalyseDao = new TypeAnalyseDao();
		request.setAttribute("typeAnalyse", typeAnalyseDao);
		
		EchantillonDao echantillonDao = new EchantillonDao();
		request.setAttribute("echantillon", echantillonDao.getEchantillonByIdEchantillon(id_echantillon));
		
		AnalyseDao analyseDao = new AnalyseDao();
		request.setAttribute("analyses", analyseDao.getAnalysesWhereIdEchantillon(id_echantillon));
		
		ResultatDao resultatDao = new ResultatDao();
		request.setAttribute("resultat", resultatDao);
		
		HttpSession session = request.getSession();
		String login_user = (String) session.getAttribute("login_user");
		String nom_user = (String) session.getAttribute("nom_user");
		String prenom_user = (String) session.getAttribute("prenom_user");
		
		if(login_user == null && nom_user == null && prenom_user == null) {
			response.sendRedirect("sessionExpiree");
		}else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/view/profilView/historicAnalyse.jsp").forward(request, response);
		}
		
		//this.getServletContext().getRequestDispatcher("/WEB-INF/view/profilView/historicAnalyse.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
