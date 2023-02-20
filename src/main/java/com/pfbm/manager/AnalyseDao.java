package com.pfbm.manager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.pfbm.beans.Analyse;

public class AnalyseDao {
	private Connection connexion;
	private void loadDatabase() {
		//Chargement du driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
		}
		
		//Connexion a la base de donnée
		try {
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/plateforme_biologie_v3","root", "");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public int getCountAnalyse() {
		loadDatabase();
		int count = 0;
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM analyse");
			
			while(resultSet.next()) {
				count++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
	public int getCountAnalysePourUlcere() {
		loadDatabase();
		int count = 0;
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery
			(" SELECT * FROM `echantillon`, analyse , pathologie WHERE analyse.id_echantillon = echantillon.id_echantillon and echantillon.id_pathologie = pathologie.id_pathologie and pathologie.id_pathologie='PATHO-2022-1'; ");
			
			while(resultSet.next()) {
				count++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
	public int getCountAnalysePourMeningite() {
		loadDatabase();
		int count = 0;
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery
			("SELECT * FROM `echantillon`, analyse , pathologie WHERE analyse.id_echantillon = echantillon.id_echantillon and echantillon.id_pathologie = pathologie.id_pathologie and pathologie.id_pathologie='PATHO-2022-2'; ");
			
			while(resultSet.next()) {
				count++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
	public int getCountAnalysePourLegionella() {
		loadDatabase();
		int count = 0;
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery
			(" SELECT * FROM `echantillon`, analyse , pathologie WHERE analyse.id_echantillon = echantillon.id_echantillon and echantillon.id_pathologie = pathologie.id_pathologie and pathologie.id_pathologie='PATHO-2022-3'; ");
			
			while(resultSet.next()) {
				count++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
	public int getCountAnalysePourChla() {
		loadDatabase();
		int count = 0;
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery
					(" SELECT * FROM `echantillon`, analyse , pathologie WHERE analyse.id_echantillon = echantillon.id_echantillon and echantillon.id_pathologie = pathologie.id_pathologie and pathologie.id_pathologie='PATHO-2022-4'; ");
			
			while(resultSet.next()) {
				count++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
	public int getCountAnalysePositifUlcere() {
		loadDatabase();
		int count = 0;
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery
			(" SELECT DISTINCT resultat.id_resultat , resultat.id_analyse , resultat.status_resultat , echantillon.id_pathologie FROM `analyse`, resultat , echantillon , pathologie WHERE analyse.id_analyse = resultat.id_analyse and resultat.status_resultat = 'positif' and echantillon.id_echantillon = analyse.id_echantillon and echantillon.id_pathologie = 'PATHO-2022-1'; ");
			
			while(resultSet.next()) {
				count++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
	public int getCountAnalyseNegatifUlcere() {
		loadDatabase();
		int count = 0;
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery
			(" SELECT DISTINCT resultat.id_resultat , resultat.id_analyse , resultat.status_resultat , echantillon.id_pathologie FROM `analyse`, resultat , echantillon , pathologie WHERE analyse.id_analyse = resultat.id_analyse and resultat.status_resultat = 'negatif' and echantillon.id_echantillon = analyse.id_echantillon and echantillon.id_pathologie = 'PATHO-2022-1'; ");
			
			while(resultSet.next()) {
				count++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
	public int getCountAnalysePositifMeningite() {
		loadDatabase();
		int count = 0;
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery
			(" SELECT DISTINCT resultat.id_resultat , resultat.id_analyse , resultat.status_resultat , echantillon.id_pathologie FROM `analyse`, resultat , echantillon , pathologie WHERE analyse.id_analyse = resultat.id_analyse and resultat.status_resultat = 'positif' and echantillon.id_echantillon = analyse.id_echantillon and echantillon.id_pathologie = 'PATHO-2022-2'; ");
			
			while(resultSet.next()) {
				count++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
	public int getCountAnalyseNegatifMeningite() {
		loadDatabase();
		int count = 0;
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery
			(" SELECT DISTINCT resultat.id_resultat , resultat.id_analyse , resultat.status_resultat , echantillon.id_pathologie FROM `analyse`, resultat , echantillon , pathologie WHERE analyse.id_analyse = resultat.id_analyse and resultat.status_resultat = 'negatif' and echantillon.id_echantillon = analyse.id_echantillon and echantillon.id_pathologie = 'PATHO-2022-2'; ");
			
			while(resultSet.next()) {
				count++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
	public int getCountAnalysePositifLegionella() {
		loadDatabase();
		int count = 0;
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery
			(" SELECT DISTINCT resultat.id_resultat , resultat.id_analyse , resultat.status_resultat , echantillon.id_pathologie FROM `analyse`, resultat , echantillon , pathologie WHERE analyse.id_analyse = resultat.id_analyse and resultat.status_resultat = 'positif' and echantillon.id_echantillon = analyse.id_echantillon and echantillon.id_pathologie = 'PATHO-2022-3'; ");
			
			while(resultSet.next()) {
				count++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
	public int getCountAnalyseNegatifLegionella() {
		loadDatabase();
		int count = 0;
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery
			(" SELECT DISTINCT resultat.id_resultat , resultat.id_analyse , resultat.status_resultat , echantillon.id_pathologie FROM `analyse`, resultat , echantillon , pathologie WHERE analyse.id_analyse = resultat.id_analyse and resultat.status_resultat = 'negatif' and echantillon.id_echantillon = analyse.id_echantillon and echantillon.id_pathologie = 'PATHO-2022-3'; ");
			
			while(resultSet.next()) {
				count++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
	public int getCountAnalysePositifChla() {
		loadDatabase();
		int count = 0;
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery
			(" SELECT DISTINCT resultat.id_resultat , resultat.id_analyse , resultat.status_resultat , echantillon.id_pathologie FROM `analyse`, resultat , echantillon , pathologie WHERE analyse.id_analyse = resultat.id_analyse and resultat.status_resultat = 'positif' and echantillon.id_echantillon = analyse.id_echantillon and echantillon.id_pathologie = 'PATHO-2022-4'; ");
			
			while(resultSet.next()) {
				count++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
	public int getCountAnalyseNegatifChla() {
		loadDatabase();
		int count = 0;
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery
			(" SELECT DISTINCT resultat.id_resultat , resultat.id_analyse , resultat.status_resultat , echantillon.id_pathologie FROM `analyse`, resultat , echantillon , pathologie WHERE analyse.id_analyse = resultat.id_analyse and resultat.status_resultat = 'negatif' and echantillon.id_echantillon = analyse.id_echantillon and echantillon.id_pathologie = 'PATHO-2022-4'; ");
			
			while(resultSet.next()) {
				count++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
	public int getCountResultatConnus() {
		loadDatabase();
		int count = 0;
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery
			("SELECT * from analyse WHERE status_resultat = \"oui\"");
			
			while(resultSet.next()) {
				count++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
	public int getCountResultatNonConnus() {
		loadDatabase();
		int count = 0;
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery
			("SELECT * from analyse WHERE status_resultat is null");
			
			while(resultSet.next()) {
				count++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
	public void addAnalyse(Analyse analyse) {
		loadDatabase();
		
		int count = getCountAnalyse();
		LocalDate date = LocalDate.now();
		int year = date.getYear();
		
		try {
			analyse.setId(count+1);
			analyse.setId_analyse("ANALYSE-"+year+"-"+(count+1));
			// analyse.setStatus_resultat("Non");
			PreparedStatement preparedStatement = connexion.prepareStatement
					("INSERT INTO `analyse`(id,`id_analyse`,`num_labo`, `date_analyse`, `grade_prescripteur`, `prescripteur`, `site`, `adresse`, `type_examen`, `id_echantillon`, `id_type_analyse`) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
			
			preparedStatement.setInt(1, analyse.getId());
			preparedStatement.setString(2, analyse.getId_analyse());
			preparedStatement.setString(3, analyse.getNum_labo());
			preparedStatement.setDate(4, analyse.getDate_analyse());
			preparedStatement.setString(5, analyse.getGrade_prescripteur());
			preparedStatement.setString(6, analyse.getPrescripteur());
			preparedStatement.setString(7, analyse.getSite());
			preparedStatement.setString(8, analyse.getAdresse());
			preparedStatement.setString(9, analyse.getType_examen());
			preparedStatement.setString(10, analyse.getId_echantillon());
			preparedStatement.setString(11, analyse.getId_type_analyse());
			
			
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Analyse> getListAnalyses(){
		loadDatabase();
		List<Analyse> listAnalyses = new ArrayList<Analyse>();
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT `id`, `id_analyse`, `date_analyse`, `num_labo`, `grade_prescripteur`, `prescripteur`, `site`, `adresse`, `type_examen`, `id_echantillon`, `id_type_analyse`,status_resultat FROM `analyse` order by id asc");
			
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String id_analyse = resultSet.getString("id_analyse");
				Date date_analyse = resultSet.getDate("date_analyse");
				String num_labo = resultSet.getString("num_labo");
				String grade_prescripteur = resultSet.getString("grade_prescripteur");
				String prescripteur = resultSet.getString("prescripteur");
				String site = resultSet.getString("site");
				String adresse = resultSet.getString("adresse");
				String type_examen = resultSet.getString("type_examen");
				String id_echantillon = resultSet.getString("id_echantillon");
				String id_type_analyse = resultSet.getString("id_type_analyse");
				String status_resultat = resultSet.getString("status_resultat");
				
				//
				Analyse analyse = new Analyse();
				analyse.setId(id);
				analyse.setId_analyse(id_analyse);
				analyse.setDate_analyse(date_analyse);
				analyse.setNum_labo(num_labo);
				analyse.setGrade_prescripteur(grade_prescripteur);
				analyse.setPrescripteur(prescripteur);
				analyse.setSite(site);
				analyse.setAdresse(adresse);
				analyse.setType_examen(type_examen);
				analyse.setId_echantillon(id_echantillon);
				analyse.setId_type_analyse(id_type_analyse);
				analyse.setStatus_resultat(status_resultat);
				
				
				listAnalyses.add(analyse);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null)
					resultSet.close();
				if(statement != null)
					statement.close();
				if(connexion != null)
					connexion.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}
		
		return listAnalyses;
	}
	
	public List<Analyse> getListAnalysesByIdEchantillon(String IdEchantillon){
		loadDatabase();
		List<Analyse> listAnalyses = new ArrayList<Analyse>();
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT `id`, `id_analyse`, `date_analyse`, `num_labo`, `grade_prescripteur`, `prescripteur`, `site`, `adresse`, `type_examen`, `id_echantillon`, `id_type_analyse`,status_resultat FROM `analyse` where id_echantillon='"+IdEchantillon+"'");
			
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String id_analyse = resultSet.getString("id_analyse");
				Date date_analyse = resultSet.getDate("date_analyse");
				String num_labo = resultSet.getString("num_labo");
				String grade_prescripteur = resultSet.getString("grade_prescripteur");
				String prescripteur = resultSet.getString("prescripteur");
				String site = resultSet.getString("site");
				String adresse = resultSet.getString("adresse");
				String type_examen = resultSet.getString("type_examen");
				String id_echantillon = resultSet.getString("id_echantillon");
				String id_type_analyse = resultSet.getString("id_type_analyse");
				String status_resultat = resultSet.getString("status_resultat");
				
				//
				Analyse analyse = new Analyse();
				analyse.setId(id);
				analyse.setId_analyse(id_analyse);
				analyse.setDate_analyse(date_analyse);
				analyse.setNum_labo(num_labo);
				analyse.setGrade_prescripteur(grade_prescripteur);
				analyse.setPrescripteur(prescripteur);
				analyse.setSite(site);
				analyse.setAdresse(adresse);
				analyse.setType_examen(type_examen);
				analyse.setId_echantillon(id_echantillon);
				analyse.setId_type_analyse(id_type_analyse);
				analyse.setStatus_resultat(status_resultat);
				
				listAnalyses.add(analyse);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null)
					resultSet.close();
				if(statement != null)
					statement.close();
				if(connexion != null)
					connexion.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}
		
		return listAnalyses;
	}
	
	public Analyse getAnalyseByIdAnalyse(String IdAnalyse){
		loadDatabase();

		Analyse analyse = new Analyse();
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT `id`, `id_analyse`, `date_analyse`, `num_labo`, `grade_prescripteur`, `prescripteur`, `site`, `adresse`, `type_examen`, `id_echantillon`, `id_type_analyse`,status_resultat FROM `analyse` where id_analyse='"+IdAnalyse+"'");
			
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String id_analyse = resultSet.getString("id_analyse");
				Date date_analyse = resultSet.getDate("date_analyse");
				String num_labo = resultSet.getString("num_labo");
				String grade_prescripteur = resultSet.getString("grade_prescripteur");
				String prescripteur = resultSet.getString("prescripteur");
				String site = resultSet.getString("site");
				String adresse = resultSet.getString("adresse");
				String type_examen = resultSet.getString("type_examen");
				String id_echantillon = resultSet.getString("id_echantillon");
				String id_type_analyse = resultSet.getString("id_type_analyse");
				String status_resultat = resultSet.getString("status_resultat");
				
				
				//Analyse analyse = new Analyse();
				analyse.setId(id);
				analyse.setId_analyse(id_analyse);
				analyse.setDate_analyse(date_analyse);
				analyse.setNum_labo(num_labo);
				analyse.setGrade_prescripteur(grade_prescripteur);
				analyse.setPrescripteur(prescripteur);
				analyse.setSite(site);
				analyse.setAdresse(adresse);
				analyse.setType_examen(type_examen);
				analyse.setId_echantillon(id_echantillon);
				analyse.setId_type_analyse(id_type_analyse);
				analyse.setStatus_resultat(status_resultat);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return analyse;
	}
	
	public List<Analyse> getAnalysesWhereIdEchantillon(String IdEchantillon){
		loadDatabase();
		Statement statement = null;
		ResultSet resultSet = null;
		List<Analyse> analyses = new ArrayList<Analyse>();
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT `id`, `id_analyse`, `date_analyse`, `num_labo`, `grade_prescripteur`, `prescripteur`, `site`, `adresse`, `type_examen`, `id_echantillon`, `id_type_analyse`,status_resultat FROM `analyse` WHERE id_echantillon = '"+IdEchantillon+"'");
		
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String id_analyse = resultSet.getString("id_analyse");
				Date date_analyse = resultSet.getDate("date_analyse");
				String num_labo = resultSet.getString("num_labo");
				String grade_prescripteur = resultSet.getString("grade_prescripteur");
				String prescripteur = resultSet.getString("prescripteur");
				String site = resultSet.getString("site");
				String adresse = resultSet.getString("adresse");
				String type_examen = resultSet.getString("type_examen");
				String id_echantillon = resultSet.getString("id_echantillon");
				String id_type_analyse = resultSet.getString("id_type_analyse");
				String status_resultat = resultSet.getString("status_resultat");
				
				//
				Analyse analyse = new Analyse();
				analyse.setId(id);
				analyse.setId_analyse(id_analyse);
				analyse.setDate_analyse(date_analyse);
				analyse.setNum_labo(num_labo);
				analyse.setGrade_prescripteur(grade_prescripteur);
				analyse.setPrescripteur(prescripteur);
				analyse.setSite(site);
				analyse.setAdresse(adresse);
				analyse.setType_examen(type_examen);
				analyse.setId_echantillon(id_echantillon);
				analyse.setId_type_analyse(id_type_analyse);
				analyse.setStatus_resultat(status_resultat);
				
				analyses.add(analyse);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return analyses;
	}
	
	public void changeStatusResultatInAnalyse(String IdAnalyse) {
		loadDatabase();
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement("UPDATE `analyse` SET `status_resultat`='oui' WHERE id_analyse=?");
			preparedStatement.setString(1, IdAnalyse);
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
