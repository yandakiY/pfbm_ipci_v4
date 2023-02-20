package com.pfbm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pfbm.manager.AnalyseDao;
import com.pfbm.manager.ResultatDao;
import com.pfbm.manager.TypeAnalyseDao;

/**
 * Servlet implementation class listeAnalyse
 */
@WebServlet("/listeanalyse")
public class listeAnalyse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listeAnalyse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		AnalyseDao analyseDao = new AnalyseDao();
		TypeAnalyseDao typeAnalyseDao = new TypeAnalyseDao();
		
		int resultatsConnus = analyseDao.getCountResultatConnus();
		int resultatsNonConnus = analyseDao.getCountResultatNonConnus();
		
		ResultatDao resultatDao = new ResultatDao();
		request.setAttribute("resultat", resultatDao);
		
		request.setAttribute("listesanalyses", analyseDao.getListAnalyses());
		request.setAttribute("type_analyse", typeAnalyseDao);
		request.setAttribute("resultatsConnus", resultatsConnus);
		request.setAttribute("resultatsNonConnus", resultatsNonConnus);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/view/tableView/listeAnalyse.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
