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

import com.pfbm.beans.Patient;

public class PatientDao {
	private Connection connexion;
	
	private void loadDatabase(){
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
	
	public int getCountPatient() {
		loadDatabase();
		int count = 0;
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM patient");
			
			while(resultSet.next()) {
				count++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
	public int getCountEchantillonOfPatient(String IdPatient) {
		loadDatabase();
		int count = 0;
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery
					("SELECT * FROM `patient`, echantillon where echantillon.id_patient = patient.id_patient and patient.id_patient ='"+IdPatient+"'");
			
			while(resultSet.next()) {
				count++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
	public void addPatient(Patient patient) {
		loadDatabase();
		LocalDate date = LocalDate.now();
		int year = date.getYear();
		int count = getCountPatient();
		
		try {
			patient.setId_patient("PAT-"+year+"-"+(count+1));
			PreparedStatement preparedStatement = connexion.prepareStatement
			("INSERT INTO `patient`(id, `id_patient`, `nom_patient`, `prenom_patient`, `sexe_patient`, `age_patient`, `contact_patient`) VALUES (?,?,?,?,?,?,?)");
			preparedStatement.setInt(1, (count+1));
			preparedStatement.setString(2, patient.getId_patient());
			preparedStatement.setString(3, patient.getNom_patient());
			preparedStatement.setString(4, patient.getPrenom_patient());
			preparedStatement.setString(5, patient.getSexe_patient());
			preparedStatement.setInt(6, patient.getAge_patient());
			preparedStatement.setString(7, patient.getContact_patient());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int checkPatientInBd(String numeroPatient) {
		loadDatabase();
		ResultSet resultSet;
		Statement statement;
		int count = 0;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT * from patient where contact_patient='"+numeroPatient+"'");
			
			while(resultSet.next()) {
				count++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public Patient getPatientByNumero(String numeroPatient) {
		loadDatabase();
		ResultSet resultSet;
		Statement statement;
		Patient patient = new Patient();
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery
			("SELECT id, `id_patient`, `nom_patient`, `prenom_patient`, `sexe_patient`, `age_patient`, `contact_patient` from patient where contact_patient='"+numeroPatient+"'");
			
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String id_patient = resultSet.getString("id_patient");
				String nom_patient = resultSet.getString("nom_patient");
				String prenom_patient = resultSet.getString("prenom_patient");
				String sexe_patient = resultSet.getString("sexe_patient");
				int age_patient = resultSet.getInt("age_patient");
				String contact_patient = resultSet.getString("contact_patient");
				
				patient.setId(id);
				patient.setId_patient(id_patient);
				patient.setNom_patient(nom_patient);
				patient.setPrenom_patient(prenom_patient);
				patient.setSexe_patient(sexe_patient);
				patient.setAge_patient(age_patient);
				patient.setContact_patient(contact_patient);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return patient;
	}
	
	public Patient getPatientByIdPatient(String Id_patient) {
		loadDatabase();
		ResultSet resultSet;
		Statement statement;
		Patient patient = new Patient();
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery
			("SELECT id,`id_patient`, `nom_patient`, `prenom_patient`, `sexe_patient`, `age_patient`, `contact_patient` from patient where id_patient='"+Id_patient+"'");
			
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String id_patient = resultSet.getString("id_patient");
				String nom_patient = resultSet.getString("nom_patient");
				String prenom_patient = resultSet.getString("prenom_patient");
				String sexe_patient = resultSet.getString("sexe_patient");
				int age_patient = resultSet.getInt("age_patient");
				String contact_patient = resultSet.getString("contact_patient");
				
				patient.setId(id);
				patient.setId_patient(id_patient);
				patient.setNom_patient(nom_patient);
				patient.setPrenom_patient(prenom_patient);
				patient.setSexe_patient(sexe_patient);
				patient.setAge_patient(age_patient);
				patient.setContact_patient(contact_patient);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return patient;
	}
	
	public List<Patient> getAllPatients(){
		loadDatabase();
		List<Patient> patients = new ArrayList<Patient>();
		
		ResultSet resultSet;
		Statement statement;
		
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery
			("SELECT id, `id_patient`, `nom_patient`, `prenom_patient`, `sexe_patient`, `age_patient`, `contact_patient` from patient order by id desc");
			
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String id_patient = resultSet.getString("id_patient");
				String nom_patient = resultSet.getString("nom_patient");
				String prenom_patient = resultSet.getString("prenom_patient");
				String sexe_patient = resultSet.getString("sexe_patient");
				int age_patient = resultSet.getInt("age_patient");
				String contact_patient = resultSet.getString("contact_patient");
				
				
				Patient patient = new Patient();
				patient.setId(id);
				patient.setId_patient(id_patient);
				patient.setNom_patient(nom_patient);
				patient.setPrenom_patient(prenom_patient);
				patient.setSexe_patient(sexe_patient);
				patient.setAge_patient(age_patient);
				patient.setContact_patient(contact_patient);
				
				patients.add(patient);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return patients;
	}
}
