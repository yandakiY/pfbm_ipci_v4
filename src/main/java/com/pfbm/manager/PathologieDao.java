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

import com.pfbm.beans.Pathologie;

public class PathologieDao {
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
	
	public int getCountPathologie() {
		loadDatabase();
		int count = 0;
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM pathologie");
			
			while(resultSet.next()) {
				count++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
	public void addPathologie(Pathologie pathologie) {
		loadDatabase();
		
		int count = getCountPathologie();
		LocalDate date = LocalDate.now();
		int year = date.getYear();
		
		try {
			pathologie.setId_pathologie("PATHO-"+year+"-"+(count+1));
			PreparedStatement preparedStatement = connexion.prepareStatement
					("INSERT INTO pathologie(id_pathologie, nom_pathologie, code_pathologie) VALUES (?,?,?)");
			
			preparedStatement.setString(1, pathologie.getId_pathologie());
			preparedStatement.setString(2, pathologie.getNom_pathologie());
			preparedStatement.setString(3, pathologie.getCode_pathologie());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Pathologie> getListPathologie(){
		loadDatabase();
		List<Pathologie> listPathologie = new ArrayList<Pathologie>();
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT id_pathologie,nom_pathologie,code_pathologie FROM pathologie");
			
			while(resultSet.next()) {
				String id_pathologie = resultSet.getString("id_pathologie");
				String nom_pathologie = resultSet.getString("nom_pathologie");
				String code_pathologie = resultSet.getString("code_pathologie");
				
				Pathologie pathologie = new Pathologie();
				
				pathologie.setId_pathologie(id_pathologie);
				pathologie.setNom_pathologie(nom_pathologie);
				pathologie.setCode_pathologie(code_pathologie);
				
				listPathologie.add(pathologie);
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
		
		return listPathologie;
	}
	/*
	public String getPathologieByIdPathologie(String id_pathologie) {
		String valuePathologie = null;
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT id_pathologie,nom_pathologie,code_pathologie FROM `pathologie` WHERE id_pathologie="+id_pathologie);
			
			while(resultSet.next()) {
				valuePathologie = resultSet.getString("nom_pathologie");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return valuePathologie;
	} */
	
	public Pathologie getPathologieByIdPathologie(String id_pathologie) {
		loadDatabase();
		Pathologie pathologie = new Pathologie();
		ResultSet resultSet;
		Statement statement;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT id_pathologie,nom_pathologie,code_pathologie FROM `pathologie` WHERE id_pathologie='"+id_pathologie+"'");
			
			while(resultSet.next()) {
				String id_pathologie1 = resultSet.getString("id_pathologie");
				String nom_pathologie = resultSet.getString("nom_pathologie");
				String code_pathologie = resultSet.getString("code_pathologie");
					
				pathologie.setId_pathologie(id_pathologie1);
				pathologie.setNom_pathologie(nom_pathologie);
				pathologie.setCode_pathologie(code_pathologie);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pathologie;
	}
}
