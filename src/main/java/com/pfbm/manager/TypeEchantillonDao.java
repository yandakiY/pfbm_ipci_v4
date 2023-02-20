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

import com.pfbm.beans.TypeEchantillon;

public class TypeEchantillonDao {
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
			resultSet = statement.executeQuery("SELECT * FROM type_echantillon");
			
			while(resultSet.next()) {
				count++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
	public void addTypeEchantillon(TypeEchantillon typeEchantillon) {
		loadDatabase();
		
		int count = getCountTypeUser();
		LocalDate date = LocalDate.now();
		int year = date.getYear();
		
		try {
			typeEchantillon.setId_type_echantillon("TEch-"+year+"-"+(count+1));
			PreparedStatement preparedStatement = connexion.prepareStatement
					("INSERT INTO type_echantillon(id_type_echantillon,nom_type_echantillon,id_pathologie) VALUES (?,?,?)");
			
			preparedStatement.setString(1, typeEchantillon.getId_type_echantillon());
			preparedStatement.setString(2, typeEchantillon.getNom_type_echantillon());
			preparedStatement.setString(3, typeEchantillon.getId_pathologie());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<TypeEchantillon> getListTypeEchantillonByIdPathologie(String id_pathologie){
		loadDatabase();
		List<TypeEchantillon> listTypeEchantillonByIdPathologie = new ArrayList<TypeEchantillon>();
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM `type_echantillon` WHERE id_pathologie='"+id_pathologie+"'");
			
			while(resultSet.next()) {
				String id_type_echantillon = resultSet.getString("id_type_echantillon");
				String nom_type_echantillon = resultSet.getString("nom_type_echantillon");
				String id_pathologie1 = resultSet.getString("id_pathologie");
				
				TypeEchantillon typeEchantillon = new TypeEchantillon();
				
				typeEchantillon.setId_type_echantillon(id_type_echantillon);
				typeEchantillon.setNom_type_echantillon(nom_type_echantillon);
				typeEchantillon.setId_pathologie(id_pathologie1);
				
				listTypeEchantillonByIdPathologie.add(typeEchantillon);
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
		
		return listTypeEchantillonByIdPathologie;
	}
	
	public List<TypeEchantillon> getListTypeEchantillonByUlcere(){
		loadDatabase();
		List<TypeEchantillon> listTypeEchantillonByIdPathologie = new ArrayList<TypeEchantillon>();
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT `id_type_echantillon`, `nom_type_echantillon`, `id_pathologie` FROM `type_echantillon` where id_pathologie='PATHO-2022-1'");
			
			while(resultSet.next()) {
				String id_type_echantillon = resultSet.getString("id_type_echantillon");
				String nom_type_echantillon = resultSet.getString("nom_type_echantillon");
				String id_pathologie1 = resultSet.getString("id_pathologie");
				
				TypeEchantillon typeEchantillon = new TypeEchantillon();
				
				typeEchantillon.setId_type_echantillon(id_type_echantillon);
				typeEchantillon.setNom_type_echantillon(nom_type_echantillon);
				typeEchantillon.setId_pathologie(id_pathologie1);
				
				listTypeEchantillonByIdPathologie.add(typeEchantillon);
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
		
		return listTypeEchantillonByIdPathologie;
	}
	
	public List<TypeEchantillon> getListTypeEchantillonByMenin(){
		loadDatabase();
		List<TypeEchantillon> listTypeEchantillonByIdPathologie = new ArrayList<TypeEchantillon>();
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT `id_type_echantillon`, `nom_type_echantillon`, `id_pathologie` FROM `type_echantillon` where id_pathologie='PATHO-2022-2'");
			
			while(resultSet.next()) {
				String id_type_echantillon = resultSet.getString("id_type_echantillon");
				String nom_type_echantillon = resultSet.getString("nom_type_echantillon");
				String id_pathologie1 = resultSet.getString("id_pathologie");
				
				TypeEchantillon typeEchantillon = new TypeEchantillon();
				
				typeEchantillon.setId_type_echantillon(id_type_echantillon);
				typeEchantillon.setNom_type_echantillon(nom_type_echantillon);
				typeEchantillon.setId_pathologie(id_pathologie1);
				
				listTypeEchantillonByIdPathologie.add(typeEchantillon);
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
		
		return listTypeEchantillonByIdPathologie;
	}
	
	public List<TypeEchantillon> getListTypeEchantillonByLegio(){
		loadDatabase();
		List<TypeEchantillon> listTypeEchantillonByIdPathologie = new ArrayList<TypeEchantillon>();
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT `id_type_echantillon`, `nom_type_echantillon`, `id_pathologie` FROM `type_echantillon` where id_pathologie='PATHO-2022-3'");
			
			while(resultSet.next()) {
				String id_type_echantillon = resultSet.getString("id_type_echantillon");
				String nom_type_echantillon = resultSet.getString("nom_type_echantillon");
				String id_pathologie1 = resultSet.getString("id_pathologie");
				
				TypeEchantillon typeEchantillon = new TypeEchantillon();
				
				typeEchantillon.setId_type_echantillon(id_type_echantillon);
				typeEchantillon.setNom_type_echantillon(nom_type_echantillon);
				typeEchantillon.setId_pathologie(id_pathologie1);
				
				listTypeEchantillonByIdPathologie.add(typeEchantillon);
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
		
		return listTypeEchantillonByIdPathologie;
	}
	
	public List<TypeEchantillon> getListTypeEchantillonByChla(){
		loadDatabase();
		List<TypeEchantillon> listTypeEchantillonByIdPathologie = new ArrayList<TypeEchantillon>();
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT `id_type_echantillon`, `nom_type_echantillon`, `id_pathologie` FROM `type_echantillon` where id_pathologie='PATHO-2022-4'");
			
			while(resultSet.next()) {
				String id_type_echantillon = resultSet.getString("id_type_echantillon");
				String nom_type_echantillon = resultSet.getString("nom_type_echantillon");
				String id_pathologie1 = resultSet.getString("id_pathologie");
				
				TypeEchantillon typeEchantillon = new TypeEchantillon();
				
				typeEchantillon.setId_type_echantillon(id_type_echantillon);
				typeEchantillon.setNom_type_echantillon(nom_type_echantillon);
				typeEchantillon.setId_pathologie(id_pathologie1);
				
				listTypeEchantillonByIdPathologie.add(typeEchantillon);
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
		
		return listTypeEchantillonByIdPathologie;
	}
	
	
	public List<TypeEchantillon> getListTypeEchantillon(){
		loadDatabase();
		List<TypeEchantillon> listTypeEchantillonByIdPathologie = new ArrayList<TypeEchantillon>();
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT `id_type_echantillon`, `nom_type_echantillon`, `id_pathologie` FROM `type_echantillon`");
			
			while(resultSet.next()) {
				String id_type_echantillon = resultSet.getString("id_type_echantillon");
				String nom_type_echantillon = resultSet.getString("nom_type_echantillon");
				String id_pathologie1 = resultSet.getString("id_pathologie");
				
				TypeEchantillon typeEchantillon = new TypeEchantillon();
				
				typeEchantillon.setId_type_echantillon(id_type_echantillon);
				typeEchantillon.setNom_type_echantillon(nom_type_echantillon);
				typeEchantillon.setId_pathologie(id_pathologie1);
				
				listTypeEchantillonByIdPathologie.add(typeEchantillon);
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
		
		return listTypeEchantillonByIdPathologie;
	}
}
