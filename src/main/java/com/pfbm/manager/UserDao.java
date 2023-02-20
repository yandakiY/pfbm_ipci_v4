package com.pfbm.manager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import com.pfbm.beans.Analyse;
import com.pfbm.beans.User;

public class UserDao {
	
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
	
	public int getCountUser() {
		loadDatabase();
		int count = 0;
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM user");
			
			while(resultSet.next()) {
				count++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
	public void addUser(User user) {
		loadDatabase();
		int countUser = getCountUser();
		LocalDate date = LocalDate.now();
		int year = date.getYear();
		//ResultSet resultSet = null;
		//Statement statement = null;
		
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement
					("INSERT INTO user(id_user,nom_user,prenom_user,login_user,mdp_user,id_type_user) values(?,?,?,?,?,?)");
			
			user.setId_user("US-"+year+"-"+(countUser+1)); //Nouvel identifiant
			
			preparedStatement.setString(1, user.getId_user());
			preparedStatement.setString(2, user.getNom_user());
			preparedStatement.setString(3, user.getPrenom_user());
			preparedStatement.setString(4, user.getLogin_user());
			preparedStatement.setString(5, user.getMdp_user());
			preparedStatement.setString(6, user.getId_type_user());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public int checkUser(User user) {
		loadDatabase();
		//Statement statement;
		ResultSet resultSet;
		int i = 0;
		
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement("SELECT * FROM user WHERE login_user = ? and id_type_user = ? and mdp_user = ?");
			preparedStatement.setString(1, user.getLogin_user());
			preparedStatement.setString(2, user.getId_type_user());
			preparedStatement.setString(3, user.getMdp_user());
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				i++;
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return i;
		
	}
	
	public User getUser(String loginUser,String mdpUser){
		loadDatabase();

		User user = new User();
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT `id_user`, `nom_user`, `prenom_user`, `login_user`, `mdp_user`, `id_type_user` FROM `user` where login_user='"+loginUser+"' and mdp_user='"+mdpUser+"'");
			
			while(resultSet.next()) {
				String id_user = resultSet.getString("id_user");
				String nom_user = resultSet.getString("nom_user");
				String prenom_user = resultSet.getString("prenom_user");
				String login_user = resultSet.getString("login_user");
				String mdp_user = resultSet.getString("mdp_user");
				String id_type_user = resultSet.getString("id_type_user");
				
				
				user.setId_user(id_user);
				user.setNom_user(nom_user);
				user.setPrenom_user(prenom_user);
				user.setLogin_user(login_user);
				user.setMdp_user(mdp_user);
				user.setId_type_user(id_type_user);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}
	
	public int checkUserBD(User user) {
		loadDatabase();
		ResultSet resultSet;
		int i = 0;
		
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement("SELECT * from user where login_user = ?");
			preparedStatement.setString(1, user.getLogin_user());
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
}
