package com.pfbm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pfbm.beans.Pathologie;
import com.pfbm.manager.PathologieDao;

/**
 * Servlet implementation class registrationPathologie
 */
@WebServlet("/registrationPathologie")
public class registrationPathologie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registrationPathologie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/view/registrationView/registrationPathologie.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom_pathologie =  request.getParameter("nom_pathologie");
		String code_pathologie = request.getParameter("code_pathologie");
		
		Pathologie pathologie = new Pathologie();
		pathologie.setNom_pathologie(nom_pathologie);
		pathologie.setCode_pathologie(code_pathologie);
		
		PathologieDao pathologieDao = new PathologieDao();
		pathologieDao.addPathologie(pathologie);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/view/registrationView/registrationPathologie.jsp").forward(request, response);
	}

}
