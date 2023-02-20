package com.pfbm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pfbm.beans.TypeAnalyse;
import com.pfbm.manager.TypeAnalyseDao;

/**
 * Servlet implementation class registrationTypeAnalyse
 */
@WebServlet("/registrationTypeAnalyse")
public class registrationTypeAnalyse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registrationTypeAnalyse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/view/registrationView/registrationTypeAnalyse.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom_type_analyse = request.getParameter("nom_type_analyse");
		String code_type_analyse = request.getParameter("code_type_analyse");
		
		TypeAnalyse typeAnalyse = new TypeAnalyse();
		
		typeAnalyse.setNom_type_analyse(nom_type_analyse);
		typeAnalyse.setCode_type_analyse(code_type_analyse);
		
		TypeAnalyseDao typeAnalyseDao = new TypeAnalyseDao();
		typeAnalyseDao.addTypeAnalyse(typeAnalyse);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/view/registrationView/registrationTypeAnalyse.jsp").forward(request, response);
	}

}
