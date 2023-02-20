package com.pfbm.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pfbm.beans.Conservation;
import com.pfbm.manager.ConservationDao;
import com.pfbm.manager.EchantillonDao;

/**
 * Servlet implementation class registrationConservation
 */
@WebServlet("/registrationconservation")
public class registrationConservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registrationConservation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id_echantillon = request.getParameter("id_echantillon");
		request.setAttribute("id_echantillon", id_echantillon);
		
		EchantillonDao echantillonDao = new EchantillonDao();
		request.setAttribute("echantillon", echantillonDao.getEchantillonByIdEchantillon(id_echantillon));
		
		
		HttpSession session = request.getSession();
		String login_user = (String) session.getAttribute("login_user");
		String nom_user = (String) session.getAttribute("nom_user");
		String prenom_user = (String) session.getAttribute("prenom_user");
		
		if(login_user == null && nom_user == null && prenom_user == null) {
			response.sendRedirect("sessionExpiree");
		}else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/view/registrationView/registrationConservation.jsp").forward(request, response);
		}
		
//		this.getServletContext().getRequestDispatcher("/WEB-INF/view/registrationView/registrationConservation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id_echantillon = request.getParameter("id_echantillon");
		String position_biobanque = request.getParameter("position_biobanque");
		String description_biobanque = request.getParameter("description_biobanque");
		String date_debut_conservation = request.getParameter("date_debut_conservation");	
		String id_reception = request.getParameter("id_reception");
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		java.util.Date trueDate = null;
		try {
			trueDate = simpleDateFormat.parse(date_debut_conservation);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date sqlDate = new java.sql.Date(trueDate.getTime());
		
		Conservation conservation = new Conservation();
		conservation.setId_echantillon(id_echantillon);
		conservation.setPosition_biobanque(position_biobanque);
		conservation.setDescription_biobanque(description_biobanque);
		conservation.setDate_debut_conservation(sqlDate);
		
		EchantillonDao echantillonDao = new EchantillonDao();
		echantillonDao.changeStatusResultatForConservation(id_echantillon);
		
		ConservationDao conservationDao = new ConservationDao();
		conservationDao.addConservation(conservation);
		
		response.sendRedirect("tableechantillonparreceptionpourconservation?id_reception="+id_reception);
	}

}
