package com.pfbm.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;

import com.pfbm.beans.TypeUser;

public class TypeUserDao {
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
	
	public int getCountTypeUser() {
		loadDatabase();
		int count = 0;
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM type_user");
			
			while(resultSet.next()) {
				count++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
	public void addTypeUser(TypeUser typeUser) {
		//ResultSet resultSet = null;
		//Statement statement = null;
		loadDatabase();
		int countTypeUser = getCountTypeUser();
		LocalDate date = LocalDate.now();
		int year = date.getYear();
		
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement
					("INSERT INTO type_user(id_type_user, nom_type_user, description_type_user) VALUES (?,?,?)");
			typeUser.setId_type_user("TU-"+year+"-"+(countTypeUser+1));
			
			preparedStatement.setString(1, typeUser.getId_type_user());
			preparedStatement.setString(2, typeUser.getNom_type_user());
			preparedStatement.setString(3, typeUser.getDescription_type_user());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<TypeUser> getListTypeUser(){
		loadDatabase();
		List<TypeUser> listTypeUser = new ArrayList<TypeUser>();
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT id_type_user, nom_type_user , description_type_user FROM `type_user`");
			
			while(resultSet.next()){
				String id_type_user = resultSet.getString("id_type_user");
				String nom_type_user = resultSet.getString("nom_type_user");
				String description_type_user = resultSet.getString("description_type_user");
				
				
				TypeUser typeUser = new TypeUser();
				typeUser.setId_type_user(id_type_user);
				typeUser.setNom_type_user(nom_type_user);
				typeUser.setDescription_type_user(description_type_user);
				
				listTypeUser.add(typeUser);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return listTypeUser;
	}
}
