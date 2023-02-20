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

import com.pfbm.beans.Reception;

public class ReceptionDao {
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
	
	public int getCountReception() {
		loadDatabase();
		int count = 0;
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM reception");
			
			while(resultSet.next()) {
				count++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
	public void addReception(Reception reception) {
		loadDatabase();
		LocalDate date = LocalDate.now();
		int year = date.getYear();
		int count = getCountReception();
		
		try {
			reception.setId(count+1);
			reception.setId_reception("REC-"+year+"-"+(count+1));
			PreparedStatement preparedStatement = connexion.prepareStatement
			("INSERT INTO `reception`(`id_reception`, `provenance`, `code_glaciere`, `nom_glaciere`, `nb_prelevement`, `date_reception`, `temperature_debut`, `temperature_arrivee`, `id_transporteur`) VALUES (?,?,?,?,?,?,?,?,?)");
			preparedStatement.setInt(1, reception.getId());
			preparedStatement.setString(1, reception.getId_reception());
			preparedStatement.setString(2, reception.getProvenance());
			preparedStatement.setString(3, reception.getCode_glaciere());
			preparedStatement.setString(4, reception.getNom_glaciere());
			preparedStatement.setInt(5, reception.getNb_prelevement());
			preparedStatement.setDate(6, reception.getDate_reception());
			preparedStatement.setInt(7, reception.getTemperature_debut());
			preparedStatement.setInt(8, reception.getTemperature_arrivee());
			preparedStatement.setString(9, reception.getId_transporteur());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Reception> getReceptions(){
		loadDatabase();
		ResultSet resultSet;
		Statement statement;
		List<Reception> receptions = new ArrayList<Reception>();
		
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery
			("SELECT id,`id_reception`, `provenance`, `code_glaciere`, `nom_glaciere`, `nb_prelevement`, `date_reception`, `temperature_debut`, `temperature_arrivee`, `id_transporteur` FROM `reception` order by id desc");
			
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String id_reception = resultSet.getString("id_reception");
				String provenance = resultSet.getString("provenance");
				String code_glaciere = resultSet.getString("code_glaciere");
				String nom_glaciere = resultSet.getString("nom_glaciere");
				int nb_prelevement = resultSet.getInt("nb_prelevement");
				Date date_reception = resultSet.getDate("date_reception");
				int temperature_debut = resultSet.getInt("temperature_debut");
				int temperature_arrivee = resultSet.getInt("temperature_arrivee");
				String id_transporteur = resultSet.getString("id_transporteur");
				
				Reception reception = new Reception();
				reception.setId(id);
				reception.setId_reception(id_reception);
				reception.setProvenance(provenance);
				reception.setCode_glaciere(code_glaciere);
				reception.setNom_glaciere(nom_glaciere);
				reception.setNb_prelevement(nb_prelevement);
				reception.setDate_reception(date_reception);
				reception.setTemperature_debut(temperature_debut);
				reception.setTemperature_arrivee(temperature_arrivee);
				reception.setId_transporteur(id_transporteur);
				
				receptions.add(reception);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return receptions;
	}
	
	
	public Reception getReceptionByIdReception(String Id_reception){
		loadDatabase();
		ResultSet resultSet;
		Statement statement;

		Reception reception = new Reception();
		
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery
			("SELECT `id_reception`, `provenance`, `code_glaciere`, `nom_glaciere`, `nb_prelevement`, `date_reception`, `temperature_debut`, `temperature_arrivee`, `id_transporteur` FROM `reception` where id_reception='"+Id_reception+"'");
			
			while(resultSet.next()) {
				String id_reception = resultSet.getString("id_reception");
				String provenance = resultSet.getString("provenance");
				String code_glaciere = resultSet.getString("code_glaciere");
				String nom_glaciere = resultSet.getString("nom_glaciere");
				int nb_prelevement = resultSet.getInt("nb_prelevement");
				Date date_reception = resultSet.getDate("date_reception");
				int temperature_debut = resultSet.getInt("temperature_debut");
				int temperature_arrivee = resultSet.getInt("temperature_arrivee");
				String id_transporteur = resultSet.getString("id_transporteur");
				
				reception.setId_reception(id_reception);
				reception.setProvenance(provenance);
				reception.setCode_glaciere(code_glaciere);
				reception.setNom_glaciere(nom_glaciere);
				reception.setNb_prelevement(nb_prelevement);
				reception.setDate_reception(date_reception);
				reception.setTemperature_debut(temperature_debut);
				reception.setTemperature_arrivee(temperature_arrivee);
				reception.setId_transporteur(id_transporteur);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reception;
	}
	
}
