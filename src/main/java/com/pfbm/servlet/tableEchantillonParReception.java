package com.pfbm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pfbm.manager.EchantillonDao;
import com.pfbm.manager.PathologieDao;
import com.pfbm.manager.PatientDao;
import com.pfbm.manager.ReceptionDao;

/**
 * Servlet implementation class tableEchantillonParReception
 */
@WebServlet("/tableechantillonparreception")
public class tableEchantillonParReception extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tableEchantillonParReception() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id_reception = request.getParameter("id_reception");
		request.setAttribute("id_reception", id_reception);
		
		HttpSession session = request.getSession();
		session.setAttribute("id_reception1", id_reception);
		
		ReceptionDao receptionDao = new ReceptionDao();
		request.setAttribute("reception", receptionDao);
		
		PatientDao patientDao = new PatientDao();
		PathologieDao pathologieDao = new PathologieDao();
		request.setAttribute("patient", patientDao); // Affichage des infos sur le patient 
		request.setAttribute("pathologie", pathologieDao); //Affichage des infos sur la pathologie
		
		
		EchantillonDao echantillonDao = new EchantillonDao();
		request.setAttribute("listEchantillon", echantillonDao.getEchantillonsByIdReception(id_reception));
		
		/* String statusEchantillon1 = "Receptionné";
		request.setAttribute("statusEchantillon1", statusEchantillon1);
		String statusEchantillon2 = "Analysé";
		request.setAttribute("statusEchantillon2", statusEchantillon2);
		String statusEchantillon3 = "Conservé";
		request.setAttribute("statusEchantillon3", statusEchantillon3);
		String statusEchantillon4 = "Rendu";
		request.setAttribute("statusEchantillon4", statusEchantillon4); 
		*/
		//
		
		//HttpSession session = request.getSession();
		String login_user = (String) session.getAttribute("login_user");
		String nom_user = (String) session.getAttribute("nom_user");
		String prenom_user = (String) session.getAttribute("prenom_user");
		
		if(login_user == null && nom_user == null && prenom_user == null) {
			response.sendRedirect("sessionExpiree");
		}else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/view/tableView/tableEchantillonParReception.jsp").forward(request, response);
		}
		//this.getServletContext().getRequestDispatcher("/WEB-INF/view/tableView/tableEchantillonParReception.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
