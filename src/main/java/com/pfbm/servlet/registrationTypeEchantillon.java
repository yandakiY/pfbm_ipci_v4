package com.pfbm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pfbm.beans.Pathologie;
import com.pfbm.beans.TypeEchantillon;
import com.pfbm.manager.PathologieDao;
import com.pfbm.manager.TypeEchantillonDao;

/**
 * Servlet implementation class registrationTypeEchantillon
 */
@WebServlet("/registrationTypeEchantillon")
public class registrationTypeEchantillon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registrationTypeEchantillon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PathologieDao pathologieDao = new PathologieDao();
		request.setAttribute("listPathologie", pathologieDao.getListPathologie());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/view/registrationView/registrationTypeEchantillon.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom_type_echantillon = request.getParameter("nom_type_echantillon");
		String id_pathologie = request.getParameter("id_pathologie");
		
		TypeEchantillon typeEchantillon = new TypeEchantillon();
		typeEchantillon.setNom_type_echantillon(nom_type_echantillon);
		typeEchantillon.setId_pathologie(id_pathologie);
		
		TypeEchantillonDao typeEchantillonDao = new TypeEchantillonDao();
		typeEchantillonDao.addTypeEchantillon(typeEchantillon);
		
		response.sendRedirect("registrationTypeEchantillon");
	}

}
