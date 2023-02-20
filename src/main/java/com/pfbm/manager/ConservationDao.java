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

import com.pfbm.beans.Conservation;

public class ConservationDao {
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
	
	public int getCountConservation() {
		loadDatabase();
		int count = 0;
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM conservation");
			
			while(resultSet.next()) {
				count++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
	public void addConservation(Conservation conservation) {
		loadDatabase();
		int count = getCountConservation();
		LocalDate date = LocalDate.now();
		int year = date.getYear();
		
		
		try {
			conservation.setId(count+1);
			conservation.setId_conservation("CONSER-"+year+"-"+(count+1));
			PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO `conservation`(`id`, `id_conservation`, `position_biobanque`, `date_debut_conservation`, `description_biobanque`, `id_echantillon`) VALUES (?,?,?,?,?,?)");
			preparedStatement.setInt(1, conservation.getId());
			preparedStatement.setString(2, conservation.getId_conservation());
			preparedStatement.setString(3, conservation.getPosition_biobanque());
			preparedStatement.setDate(4, conservation.getDate_debut_conservation());
			preparedStatement.setString(5, conservation.getDescription_biobanque());
			preparedStatement.setString(6, conservation.getId_echantillon());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void updateConservation(Conservation conservation ,String idEchantillon) {
		loadDatabase();
		
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement("UPDATE `conservation` SET `position_biobanque`=?,`date_debut_conservation`=?,`description_biobanque`=? WHERE id_echantillon='"+idEchantillon+"'");
			preparedStatement.setString(1, conservation.getPosition_biobanque());
			preparedStatement.setDate(2, conservation.getDate_debut_conservation());
			preparedStatement.setString(3, conservation.getDescription_biobanque());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Conservation> getConservations(){
		
		loadDatabase();
		List<Conservation> conservation = new ArrayList<Conservation>();
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT `id`, `id_conservation`, `position_biobanque`, `date_debut_conservation`, `description_biobanque`, `id_echantillon` FROM `conservation`");
			
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String id_conservation = resultSet.getString("id_conservation");
				String position_biobanque = resultSet.getString("position_biobanque");
				Date date_debut_conservation = resultSet.getDate("date_debut_conservation");
				String description_biobanque = resultSet.getString("description_biobanque");
				String id_echantillon = resultSet.getString("id_echantillon");
				
				Conservation conservation2 = new Conservation();
				conservation2.setId(id);
				conservation2.setId_conservation(id_conservation);
				conservation2.setPosition_biobanque(position_biobanque);
				conservation2.setDate_debut_conservation(date_debut_conservation);
				conservation2.setDescription_biobanque(description_biobanque);
				conservation2.setId_echantillon(id_echantillon);
				
				conservation.add(conservation2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return conservation;
	}
	
public Conservation getConservationByIdEchantillon(String idEchantillon){
		
		loadDatabase();
		Conservation conservation2 = new Conservation();
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT `id`, `id_conservation`, `position_biobanque`, `date_debut_conservation`, `description_biobanque`, `id_echantillon` FROM `conservation` where id_echantillon='"+idEchantillon+"'");
			
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String id_conservation = resultSet.getString("id_conservation");
				String position_biobanque = resultSet.getString("position_biobanque");
				Date date_debut_conservation = resultSet.getDate("date_debut_conservation");
				String description_biobanque = resultSet.getString("description_biobanque");
				String id_echantillon = resultSet.getString("id_echantillon");
				
				
				conservation2.setId(id);
				conservation2.setId_conservation(id_conservation);
				conservation2.setPosition_biobanque(position_biobanque);
				conservation2.setDate_debut_conservation(date_debut_conservation);
				conservation2.setDescription_biobanque(description_biobanque);
				conservation2.setId_echantillon(id_echantillon);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return conservation2;
	}
}
