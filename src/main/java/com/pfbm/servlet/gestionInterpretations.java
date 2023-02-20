package com.pfbm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pfbm.beans.Interpretation;
import com.pfbm.manager.InterpretationDao;
import com.pfbm.manager.PathologieDao;

/**
 * Servlet implementation class gestionInterpretations
 */
@WebServlet("/gestionInterpretations")
public class gestionInterpretations extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gestionInterpretations() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PathologieDao pathologie = new PathologieDao();
		request.setAttribute("pathologies", pathologie.getListPathologie());
		request.setAttribute("pathologie", pathologie);
		
		InterpretationDao interpretationDao = new InterpretationDao();
		request.setAttribute("interpretations", interpretationDao.getInterpretations());
		
		HttpSession session = request.getSession();
		String login_user = (String) session.getAttribute("login_user");
		String nom_user = (String) session.getAttribute("nom_user");
		String prenom_user = (String) session.getAttribute("prenom_user");
		
		if(login_user == null && nom_user == null && prenom_user == null) {
			response.sendRedirect("sessionExpiree");
		}else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/view/profilView/gestioninterpretations.jsp").forward(request, response);
		}
		
		
		//this.getServletContext().getRequestDispatcher("/WEB-INF/view/profilView/gestioninterpretations.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id_pathologie = request.getParameter("id_pathologie");
		String libelle_inter = request.getParameter("libelle_inter");
		
		Interpretation interpretation = new Interpretation();
		
		interpretation.setId_pathologie(id_pathologie);
		interpretation.setLibelle_inter(libelle_inter);
		
		InterpretationDao interpretationDao = new InterpretationDao();
		interpretationDao.addInterpretation(interpretation);
		
		response.sendRedirect("gestionInterpretations");
	}

}
