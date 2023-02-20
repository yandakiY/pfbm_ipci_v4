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

import com.pfbm.beans.TypeAnalyse;
import com.pfbm.beans.TypeEchantillon;

public class TypeAnalyseDao {
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
	
	public int getCountTypeAnalyse() {
		loadDatabase();
		int count = 0;
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM type_analyse");
			
			while(resultSet.next()) {
				count++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
	public void addTypeAnalyse(TypeAnalyse typeAnalyse) {
		loadDatabase();
		
		int count = getCountTypeAnalyse();
		LocalDate date = LocalDate.now();
		int year = date.getYear();
		
		try {
			typeAnalyse.setId_type_analyse("TAn-"+year+"-"+(count+1));
			PreparedStatement preparedStatement = connexion.prepareStatement
					("INSERT INTO `type_analyse`(`id_type_analyse`, `nom_type_analyse`, `code_type_analyse`) VALUES (?,?,?)");
			
			preparedStatement.setString(1, typeAnalyse.getId_type_analyse());
			preparedStatement.setString(2, typeAnalyse.getNom_type_analyse());
			preparedStatement.setString(3, typeAnalyse.getCode_type_analyse());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<TypeAnalyse> getListTypeAnalyses(){
		loadDatabase();
		List<TypeAnalyse> listTypeAnalyses = new ArrayList<TypeAnalyse>();
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT `id_type_analyse`, `nom_type_analyse`, `code_type_analyse` FROM `type_analyse`");
			
			while(resultSet.next()) {
				String id_type_analyse = resultSet.getString("id_type_analyse");
				String nom_type_analyse = resultSet.getString("nom_type_analyse");
				String code_type_analyse = resultSet.getString("code_type_analyse");
				
				TypeAnalyse typeAnalyse = new TypeAnalyse();
				
				typeAnalyse.setId_type_analyse(id_type_analyse);
				typeAnalyse.setNom_type_analyse(nom_type_analyse);
				typeAnalyse.setCode_type_analyse(code_type_analyse);
				
				listTypeAnalyses.add(typeAnalyse);
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
		
		return listTypeAnalyses;
	}
	
	public TypeAnalyse getTypeAnalyse(String Id_type_analyse){
		loadDatabase();
		TypeAnalyse typeAnalyse = new TypeAnalyse();
		ResultSet resultSet;
		Statement statement;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT `id_type_analyse`, `nom_type_analyse`, `code_type_analyse` FROM `type_analyse` where id_type_analyse='"+Id_type_analyse+"'");
			
			while(resultSet.next()) {
				String id_type_analyse = resultSet.getString("id_type_analyse");
				String nom_type_analyse = resultSet.getString("nom_type_analyse");
				String code_type_analyse = resultSet.getString("code_type_analyse");
				
				
				typeAnalyse.setId_type_analyse(id_type_analyse);
				typeAnalyse.setNom_type_analyse(nom_type_analyse);
				typeAnalyse.setCode_type_analyse(code_type_analyse);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return typeAnalyse;
	}
}
