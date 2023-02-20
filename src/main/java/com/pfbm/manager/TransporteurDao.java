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

import com.pfbm.beans.Transporteur;

public class TransporteurDao {
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
	
	public int getCountTransporteur() {
		loadDatabase();
		int count = 0;
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM transporteur");
			
			while(resultSet.next()) {
				count++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
	public int getCountReceptionOfTransporteur(String idTransporteur) {
		loadDatabase();
		int count = 0;
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery
					("SELECT * FROM `reception`,transporteur where transporteur.id_transporteur = reception.id_transporteur and transporteur.id_transporteur = '"+idTransporteur+"'");
			
			while(resultSet.next()) {
				count++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
	public void addTransporteur(Transporteur transporteur) {
		loadDatabase();
		LocalDate date = LocalDate.now();
		int year = date.getYear();
		int count = getCountTransporteur();
		//ResultSet resultSet = null;
		//Statement statement = null;
		
		try {
			transporteur.setId_transporteur("Trans-"+year+"-"+(count+1));
			PreparedStatement preparedStatement = connexion.prepareStatement
			("INSERT INTO `transporteur`(`id_transporteur`, `nom_transporteur`, `prenom_transporteur`, `sexe_transporteur`, `contact_transporteur`) VALUES (?,?,?,?,?)");
			preparedStatement.setString(1, transporteur.getId_transporteur());
			preparedStatement.setString(2, transporteur.getNom_transporteur());
			preparedStatement.setString(3, transporteur.getPrenom_transporteur());
			preparedStatement.setString(4, transporteur.getSexe_transporteur());
			preparedStatement.setString(5, transporteur.getContact_transporteur());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Transporteur> getAllTransporteurs(){
		loadDatabase();
		List<Transporteur> transporteurs = new ArrayList<Transporteur>();
		
		ResultSet resultSet;
		Statement statement;
		
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT id_transporteur, `nom_transporteur`, `prenom_transporteur`,`contact_transporteur`,sexe_transporteur FROM `transporteur`");
			
			while(resultSet.next()) {
				String id_transport = resultSet.getString("id_transporteur");
				String nom_transporteur = resultSet.getString("nom_transporteur");
				String prenom_transporteur = resultSet.getString("prenom_transporteur");
				String contact_transporteur = resultSet.getString("contact_transporteur");
				String sexe_transporteur = resultSet.getString("sexe_transporteur");
				
				Transporteur transporteur = new Transporteur();
				transporteur.setId_transporteur(id_transport);
				transporteur.setNom_transporteur(nom_transporteur);
				transporteur.setPrenom_transporteur(prenom_transporteur);
				transporteur.setContact_transporteur(contact_transporteur);
				transporteur.setSexe_transporteur(sexe_transporteur);
				transporteurs.add(transporteur);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return transporteurs;
	}
	
	public Transporteur getTransportByNumero(String numero) {
		loadDatabase();
		ResultSet resultSet;
		Statement statement;
		Transporteur transporteur = new Transporteur();
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT id_transporteur, `nom_transporteur`, `prenom_transporteur`,`contact_transporteur` FROM `transporteur` WHERE contact_transporteur=\""+numero+"\";");
			
			while(resultSet.next()) {
				String id_transport = resultSet.getString("id_transporteur");
				String nom_transporteur = resultSet.getString("nom_transporteur");
				String prenom_transporteur = resultSet.getString("prenom_transporteur");
				String contact_transporteur = resultSet.getString("contact_transporteur");
				
				transporteur.setId_transporteur(id_transport);
				transporteur.setNom_transporteur(nom_transporteur);
				transporteur.setPrenom_transporteur(prenom_transporteur);
				transporteur.setContact_transporteur(contact_transporteur);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return transporteur;
	}
	
	public int checkTransporteurInBd(String numero) {
		loadDatabase();
		ResultSet resultSet;
		Statement statement;
		int i = 0;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM `transporteur` WHERE contact_transporteur='"+numero+"'");
			
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
