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

import com.pfbm.beans.Interpretation;

public class InterpretationDao {
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
			resultSet = statement.executeQuery("SELECT * FROM interpretations");
			
			while(resultSet.next()) {
				count++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
	
	public void addInterpretation(Interpretation interpretation) {
		loadDatabase();
		
		int count = getCountAnalyse();
		LocalDate date = LocalDate.now();
		int year = date.getYear();
		
		try {
			interpretation.setId(count+1);
			interpretation.setId_inter("INTER-"+year+"-"+(count+1));
			PreparedStatement preparedStatement = connexion.prepareStatement
					("INSERT INTO `interpretations`(`id`, `id_inter`, `libelle_inter`, `id_pathologie`) VALUES (?,?,?,?)");
			
			preparedStatement.setInt(1, interpretation.getId());
			preparedStatement.setString(2, interpretation.getId_inter());
			preparedStatement.setString(3, interpretation.getLibelle_inter());
			preparedStatement.setString(4, interpretation.getId_pathologie());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Interpretation> getInterpretations(){
		loadDatabase();
		List<Interpretation> listInterpretations = new ArrayList<Interpretation>();
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT `id`, `id_inter`, `libelle_inter`, `id_pathologie` FROM `interpretations`");
			
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String id_inter = resultSet.getString("id_inter");
				String libelle_inter = resultSet.getString("libelle_inter");
				String id_pathologie = resultSet.getString("id_pathologie");
				
				Interpretation interpretation = new Interpretation();
				interpretation.setId(id);
				interpretation.setId_inter(id_inter);
				interpretation.setLibelle_inter(libelle_inter);
				interpretation.setId_pathologie(id_pathologie);
				
				listInterpretations.add(interpretation);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return listInterpretations; 
	}
	
	
	public Interpretation getInterpretationByIdInterpretation(String idInter){
		loadDatabase();
		Interpretation interpretation = new Interpretation();
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT `id`, `id_inter`, `libelle_inter`, `id_pathologie` FROM `interpretations` where id_inter='"+idInter+"'");
			
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String id_inter = resultSet.getString("id_inter");
				String libelle_inter = resultSet.getString("libelle_inter");
				String id_pathologie = resultSet.getString("id_pathologie");
				
				
				interpretation.setId(id);
				interpretation.setId_inter(id_inter);
				interpretation.setLibelle_inter(libelle_inter);
				interpretation.setId_pathologie(id_pathologie);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return interpretation; 
	}
	
	public List<Interpretation> getInterpretationsByPathologie(String idPathologie){
		loadDatabase();
		List<Interpretation> listInterpretations = new ArrayList<Interpretation>();
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT `id`, `id_inter`, `libelle_inter`, `id_pathologie` FROM interpretations where id_pathologie='"+idPathologie+"'");
			
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String id_inter = resultSet.getString("id_inter");
				String libelle_inter = resultSet.getString("libelle_inter");
				String id_pathologie = resultSet.getString("id_pathologie");
				
				Interpretation interpretation = new Interpretation();
				interpretation.setId(id);
				interpretation.setId_inter(id_inter);
				interpretation.setLibelle_inter(libelle_inter);
				interpretation.setId_pathologie(id_pathologie);
				
				listInterpretations.add(interpretation);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return listInterpretations; 
	}
}
