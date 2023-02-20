package com.pfbm.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.pfbm.beans.Resultat;

public class ResultatDao {
	private Connection connexion;
	
	private void loadDatabase() {
		//Chargement du driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
		}
		
		//Connexion a la base de donnée
		try {
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/plateforme_biologie_v3", "root", "");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public int getCountResultat() {
		loadDatabase();
		int count = 0;
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM resultat");
			
			while(resultSet.next()) {
				count++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
	public int getCountResultatPositif() {
		loadDatabase();
		int count = 0;
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM resultat where status_resultat='positif'");
			
			while(resultSet.next()) {
				count++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
	public int getCountResultatNegatif() {
		loadDatabase();
		int count = 0;
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM resultat where status_resultat='negatif'");
			
			while(resultSet.next()) {
				count++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
	public void addResultat(Resultat resultat) {
		loadDatabase();
		int count = getCountResultat();
		LocalDate date = LocalDate.now();
		int year = date.getYear();
		
		try {
			resultat.setId(count+1);
			resultat.setId_resultat("RES-"+year+"-"+(count+1));
			PreparedStatement preparedStatement = connexion.prepareStatement
			("INSERT INTO `resultat`(id,`id_resultat`, `valeur_ct`, `status_resultat`, `observation_resultat`, `id_analyse`) VALUES (?,?,?,?,?,?)");
			
			preparedStatement.setInt(1, resultat.getId());
			preparedStatement.setString(2, resultat.getId_resultat());
			preparedStatement.setInt(3, resultat.getValeur_ct());
			preparedStatement.setString(4, resultat.getStatus_resultat());
			preparedStatement.setString(5, resultat.getObservation_resultat());
			preparedStatement.setString(6, resultat.getId_analyse());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Resultat> getResultats(){
		loadDatabase();
		ResultSet resultSet = null;
		Statement statement = null;
		List<Resultat> listResultats = new ArrayList<Resultat>();
		
		try {
			statement = connexion.createStatement();
			resultSet =  statement.executeQuery("SELECT id,`id_resultat`, `valeur_ct`, `status_resultat`, `observation_resultat`, `id_analyse` FROM `resultat` order by id asc");
			
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String id_resultat = resultSet.getString("id_resultat");
				int valeur_ct = resultSet.getInt("valeur_ct");
				String status_resultat = resultSet.getString("status_resultat");
				String observation_resultat = resultSet.getString("observation_resultat");
				String id_analyse = resultSet.getString("id_analyse");
				
				Resultat resultat = new Resultat();
				resultat.setId(id);
				resultat.setId_resultat(id_resultat);
				resultat.setValeur_ct(valeur_ct);
				resultat.setStatus_resultat(status_resultat);
				resultat.setObservation_resultat(observation_resultat);
				resultat.setId_analyse(id_analyse);
				
				listResultats.add(resultat);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return listResultats;
	}
	
	public Resultat getResultatByIdResultat(String IdResultat){
		loadDatabase();
		ResultSet resultSet = null;
		Statement statement = null;
		Resultat resultat = new Resultat();
		
		try {
			statement = connexion.createStatement();
			resultSet =  statement.executeQuery("SELECT `id_resultat`, `valeur_ct`, `status_resultat`, `observation_resultat`, `id_analyse` FROM `resultat` WHERE id_resultat='"+IdResultat+"'");
			
			while(resultSet.next()) {
				String id_resultat = resultSet.getString("id_resultat");
				int valeur_ct = resultSet.getInt("valeur_ct");
				String status_resultat = resultSet.getString("status_resultat");
				String observation_resultat = resultSet.getString("observation_resultat");
				String id_analyse = resultSet.getString("id_analyse");
				
				resultat.setId_resultat(id_resultat);
				resultat.setValeur_ct(valeur_ct);
				resultat.setStatus_resultat(status_resultat);
				resultat.setObservation_resultat(observation_resultat);
				resultat.setId_analyse(id_analyse);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultat;
	}
	
	public List<Resultat> getResultatsByForIdAnalyse(String IdAnalyse){
		loadDatabase();
		ResultSet resultSet = null;
		Statement statement = null;
		List<Resultat> resultats =  new ArrayList<Resultat>();
		
		
		try {
			statement = connexion.createStatement();
			resultSet =  statement.executeQuery("SELECT `id_resultat`, `valeur_ct`, `status_resultat`, `observation_resultat`, `id_analyse` FROM `resultat` WHERE id_analyse='"+IdAnalyse+"'");
			
			while(resultSet.next()) {
				String id_resultat = resultSet.getString("id_resultat");
				int valeur_ct = resultSet.getInt("valeur_ct");
				String status_resultat = resultSet.getString("status_resultat");
				String observation_resultat = resultSet.getString("observation_resultat");
				String id_analyse = resultSet.getString("id_analyse");
				
				Resultat resultat = new Resultat();
				resultat.setId_resultat(id_resultat);
				resultat.setValeur_ct(valeur_ct);
				resultat.setStatus_resultat(status_resultat);
				resultat.setObservation_resultat(observation_resultat);
				resultat.setId_analyse(id_analyse);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultats;
	}
	
	public Resultat getResultatForIdAnalyse(String IdAnalyse) {
		loadDatabase();
		Statement statement = null;
		ResultSet resultSet = null;
		Resultat resultat = new Resultat();
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT id_resultat, valeur_ct, status_resultat ,observation_resultat,id_analyse FROM `resultat` WHERE id_analyse='"+IdAnalyse+"'");
			
			while(resultSet.next()) {
				String id_resultat = resultSet.getString("id_resultat");
				int valeur_ct = resultSet.getInt("valeur_ct");
				String status_resultat = resultSet.getString("status_resultat");
				String observation_resultat = resultSet.getString("observation_resultat");
				String id_analyse = resultSet.getString("id_analyse");
				
				resultat.setId_resultat(id_resultat);
				resultat.setValeur_ct(valeur_ct);
				resultat.setStatus_resultat(status_resultat);
				resultat.setObservation_resultat(observation_resultat);
				resultat.setId_analyse(id_analyse);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultat;
	}
	
}
