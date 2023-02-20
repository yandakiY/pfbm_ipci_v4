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

import com.pfbm.beans.Echantillon;

public class EchantillonDao {
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
	
	public int getCountEchantillon() {
		loadDatabase();
		int count = 0;
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM echantillon");
			
			while(resultSet.next()) {
				count++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public int getCountEchantillonUlcere() {
		loadDatabase();
		int count = 0;
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM echantillon where id_pathologie='PATHO-2022-1'");
			
			while(resultSet.next()) {
				count++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	
	
	public int getCountEchantillonMeningite() {
		loadDatabase();
		int count = 0;
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM echantillon where id_pathologie='PATHO-2022-2'");
			
			while(resultSet.next()) {
				count++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public int getCountEchantillonLegionnella() {
		loadDatabase();
		int count = 0;
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM echantillon where id_pathologie='PATHO-2022-3'");
			
			while(resultSet.next()) {
				count++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public int getCountEchantillonCHLA() {
		loadDatabase();
		int count = 0;
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM echantillon where id_pathologie='PATHO-2022-4'");
			
			while(resultSet.next()) {
				count++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public int getCountEchantillonAConserver() {
		loadDatabase();
		int count = 0;
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM echantillon where status_conservation='Receptionné-Analysé-Conservé'");
			
			while(resultSet.next()) {
				count++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public int getCountEchantillonPasConserver() {
		loadDatabase();
		int count = 0;
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM echantillon where status_conservation='Receptionné-Analysé-PasConservé'");
			
			while(resultSet.next()) {
				count++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public int getCountEchantillonPasDeterminé() {
		loadDatabase();
		int count = 0;
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM echantillon where status_conservation is NULL");
			
			while(resultSet.next()) {
				count++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public void addEchantillon(Echantillon echantillon) {
		loadDatabase();
		int count = getCountEchantillon();
		LocalDate date = LocalDate.now();
		int year = date.getYear();
		
		try {
			echantillon.setId(count+1);
			echantillon.setId_echantillon("ECH-"+year+"-"+(count+1));
			echantillon.setStatus_reception("Receptionné");
			PreparedStatement preparedStatement = connexion.prepareStatement
			("INSERT INTO `echantillon`(id,`id_echantillon`, `volume_echantillon`, `status_reception`, `date_prelevement`, `id_pathologie`, `id_patient`, `id_reception`, `id_type_echantillon`) VALUES (?,?,?,?,?,?,?,?,?)");
			
			preparedStatement.setInt(1, echantillon.getId());
			preparedStatement.setString(2, echantillon.getId_echantillon());
			preparedStatement.setInt(3, echantillon.getVolume_echantillon());
			preparedStatement.setString(4, echantillon.getStatus_reception());
			preparedStatement.setDate(5, echantillon.getDate_prelevement());
			preparedStatement.setString(6, echantillon.getId_pathologie());
			preparedStatement.setString(7, echantillon.getId_patient());
			preparedStatement.setString(8, echantillon.getId_reception());
			preparedStatement.setString(9, echantillon.getId_type_echantillon());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Echantillon> getEchantillons(){
		loadDatabase();
		List<Echantillon> echantillons = new ArrayList<Echantillon>();
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery
			("SELECT `id`, `id_echantillon`, `volume_echantillon`, `status_echantillon`, `status_reception`, `status_conservation`, `status_analyse`, `status_resultat`, `date_prelevement`, `id_pathologie`, `id_patient`, `id_reception`, `id_type_echantillon`,status_resultat_for_conservation FROM `echantillon` order by id desc");
			
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String id_echantillon = resultSet.getString("id_echantillon");
				int volume_echantillon = resultSet.getInt("volume_echantillon");
				String status_echantillon = resultSet.getString("status_echantillon");
				String status_reception = resultSet.getString("status_reception");
				String status_analyse = resultSet.getString("status_analyse");
				String status_conservation = resultSet.getString("status_conservation");
				String status_resultat = resultSet.getString("status_resultat");
				Date date_prelevement = resultSet.getDate("date_prelevement");
				String id_pathologie = resultSet.getString("id_pathologie");
				String id_patient = resultSet.getString("id_patient");
				String id_reception = resultSet.getString("id_reception");
				String id_type_echantillon = resultSet.getString("id_type_echantillon");
				String status_resultat_for_conservation = resultSet.getString("status_resultat_for_conservation");
				
				Echantillon echantillon = new Echantillon();
				echantillon.setId(id);
				echantillon.setId_echantillon(id_echantillon);
				echantillon.setVolume_echantillon(volume_echantillon);
				echantillon.setStatus_echantillon(status_echantillon);
				echantillon.setStatus_reception(status_reception);
				echantillon.setStatus_analyse(status_analyse);
				echantillon.setStatus_conservation(status_conservation);
				echantillon.setStatus_resultat(status_resultat);
				echantillon.setDate_prelevement(date_prelevement);
				echantillon.setId_pathologie(id_pathologie);
				echantillon.setId_patient(id_patient);
				echantillon.setId_reception(id_reception);
				echantillon.setId_type_echantillon(id_type_echantillon);
				echantillon.setStatus_resultat_for_conservation(status_resultat_for_conservation);
				
				echantillons.add(echantillon);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return echantillons;
	}
	
	
	
	public List<Echantillon> getEchantillonsByIdReception(String Id_reception){
		loadDatabase();
		List<Echantillon> echantillons = new ArrayList<Echantillon>();
		ResultSet resultSet;
		Statement statement;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery
			("SELECT  `id`, `id_echantillon`, `volume_echantillon`, `status_echantillon`, `status_reception`, `status_conservation`, `status_analyse`, `status_resultat`, `date_prelevement`, `id_pathologie`, `id_patient`, `id_reception`, `id_type_echantillon`,status_resultat_for_conservation FROM `echantillon` where id_reception='"+Id_reception+"' order by id desc");
			
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String id_echantillon = resultSet.getString("id_echantillon");
				int volume_echantillon = resultSet.getInt("volume_echantillon");
				String status_echantillon = resultSet.getString("status_echantillon");
				String status_reception = resultSet.getString("status_reception");
				String status_analyse = resultSet.getString("status_analyse");
				String status_conservation = resultSet.getString("status_conservation");
				String status_resultat = resultSet.getString("status_resultat");
				Date date_prelevement = resultSet.getDate("date_prelevement");
				String id_pathologie = resultSet.getString("id_pathologie");
				String id_patient = resultSet.getString("id_patient");
				String id_reception = resultSet.getString("id_reception");
				String id_type_echantillon = resultSet.getString("id_type_echantillon");
				String status_resultat_for_conservation = resultSet.getString("status_resultat_for_conservation");
				
				Echantillon echantillon = new Echantillon();
				echantillon.setId(id);
				echantillon.setId_echantillon(id_echantillon);
				echantillon.setVolume_echantillon(volume_echantillon);
				echantillon.setStatus_echantillon(status_echantillon);
				echantillon.setStatus_reception(status_reception);
				echantillon.setStatus_analyse(status_analyse);
				echantillon.setStatus_conservation(status_conservation);
				echantillon.setStatus_resultat(status_resultat);
				echantillon.setDate_prelevement(date_prelevement);
				echantillon.setId_pathologie(id_pathologie);
				echantillon.setId_patient(id_patient);
				echantillon.setId_reception(id_reception);
				echantillon.setId_type_echantillon(id_type_echantillon);
				echantillon.setStatus_resultat_for_conservation(status_resultat_for_conservation);
				
				echantillons.add(echantillon);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return echantillons;
	}
	
	public Echantillon getEchantillonByIdEchantillon(String Id_echantillon){
		loadDatabase();
		Echantillon echantillon = new Echantillon();
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery
			("SELECT  `id`, `id_echantillon`, `volume_echantillon`, `status_echantillon`, `status_reception`, `status_conservation`, `status_analyse`, `status_resultat`, `date_prelevement`, `id_pathologie`, `id_patient`, `id_reception`, `id_type_echantillon`,status_resultat_for_conservation FROM `echantillon` where id_echantillon='"+Id_echantillon+"'");
			
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String id_echantillon = resultSet.getString("id_echantillon");
				int volume_echantillon = resultSet.getInt("volume_echantillon");
				String status_echantillon = resultSet.getString("status_echantillon");
				String status_reception = resultSet.getString("status_reception");
				String status_analyse = resultSet.getString("status_analyse");
				String status_conservation = resultSet.getString("status_conservation");
				String status_resultat = resultSet.getString("status_resultat");
				Date date_prelevement = resultSet.getDate("date_prelevement");
				String id_pathologie = resultSet.getString("id_pathologie");
				String id_patient = resultSet.getString("id_patient");
				String id_reception = resultSet.getString("id_reception");
				String id_type_echantillon = resultSet.getString("id_type_echantillon");
				String status_resultat_for_conservation = resultSet.getString("status_resultat_for_conservation");
				
				//Echantillon echantillon = new Echantillon();
				echantillon.setId(id);
				echantillon.setId_echantillon(id_echantillon);
				echantillon.setVolume_echantillon(volume_echantillon);
				echantillon.setStatus_echantillon(status_echantillon);
				echantillon.setStatus_reception(status_reception);
				echantillon.setStatus_analyse(status_analyse);
				echantillon.setStatus_conservation(status_conservation);
				echantillon.setStatus_resultat(status_resultat);
				echantillon.setDate_prelevement(date_prelevement);
				echantillon.setId_pathologie(id_pathologie);
				echantillon.setId_patient(id_patient);
				echantillon.setId_reception(id_reception);
				echantillon.setId_type_echantillon(id_type_echantillon);
				echantillon.setStatus_resultat_for_conservation(status_resultat_for_conservation);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return echantillon;
	}
	
	public List<Echantillon> getEchantillonsWhereConservation(String Idreception){
		loadDatabase();
		List<Echantillon> echantillons = new ArrayList<Echantillon>();
		ResultSet resultSet;
		Statement statement;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery
			("SELECT  `id`, `id_echantillon`, `volume_echantillon`, `status_echantillon`, `status_reception`, `status_conservation`, `status_analyse`, `status_resultat`, `date_prelevement`, `id_pathologie`, `id_patient`, `id_reception`, `id_type_echantillon`,status_resultat_for_conservation FROM `echantillon` where status_conservation='Receptionné-Analysé-Conservé' and id_reception='"+Idreception+"'");
			
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String id_echantillon = resultSet.getString("id_echantillon");
				int volume_echantillon = resultSet.getInt("volume_echantillon");
				String status_echantillon = resultSet.getString("status_echantillon");
				String status_reception = resultSet.getString("status_reception");
				String status_analyse = resultSet.getString("status_analyse");
				String status_conservation = resultSet.getString("status_conservation");
				String status_resultat = resultSet.getString("status_resultat");
				Date date_prelevement = resultSet.getDate("date_prelevement");
				String id_pathologie = resultSet.getString("id_pathologie");
				String id_patient = resultSet.getString("id_patient");
				String id_reception = resultSet.getString("id_reception");
				String id_type_echantillon = resultSet.getString("id_type_echantillon");
				String status_resultat_for_conservation = resultSet.getString("status_resultat_for_conservation");
				
				Echantillon echantillon = new Echantillon();
				echantillon.setId(id);
				echantillon.setId_echantillon(id_echantillon);
				echantillon.setVolume_echantillon(volume_echantillon);
				echantillon.setStatus_echantillon(status_echantillon);
				echantillon.setStatus_reception(status_reception);
				echantillon.setStatus_analyse(status_analyse);
				echantillon.setStatus_conservation(status_conservation);
				echantillon.setStatus_resultat(status_resultat);
				echantillon.setDate_prelevement(date_prelevement);
				echantillon.setId_pathologie(id_pathologie);
				echantillon.setId_patient(id_patient);
				echantillon.setId_reception(id_reception);
				echantillon.setId_type_echantillon(id_type_echantillon);
				echantillon.setStatus_resultat_for_conservation(status_resultat_for_conservation);
				
				echantillons.add(echantillon);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return echantillons;
	}
	
	
	public List<Echantillon> getAllEchantillonsWhereConservation(){
		loadDatabase();
		List<Echantillon> echantillons = new ArrayList<Echantillon>();
		ResultSet resultSet;
		Statement statement;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery
			("SELECT  `id`, `id_echantillon`, `volume_echantillon`, `status_echantillon`, `status_reception`, `status_conservation`, `status_analyse`, `status_resultat`, `date_prelevement`, `id_pathologie`, `id_patient`, `id_reception`, `id_type_echantillon`,status_resultat_for_conservation FROM `echantillon` where status_conservation='Receptionné-Analysé-Conservé' ");
			
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String id_echantillon = resultSet.getString("id_echantillon");
				int volume_echantillon = resultSet.getInt("volume_echantillon");
				String status_echantillon = resultSet.getString("status_echantillon");
				String status_reception = resultSet.getString("status_reception");
				String status_analyse = resultSet.getString("status_analyse");
				String status_conservation = resultSet.getString("status_conservation");
				String status_resultat = resultSet.getString("status_resultat");
				Date date_prelevement = resultSet.getDate("date_prelevement");
				String id_pathologie = resultSet.getString("id_pathologie");
				String id_patient = resultSet.getString("id_patient");
				String id_reception = resultSet.getString("id_reception");
				String id_type_echantillon = resultSet.getString("id_type_echantillon");
				String status_resultat_for_conservation = resultSet.getString("status_resultat_for_conservation");
				
				Echantillon echantillon = new Echantillon();
				echantillon.setId(id);
				echantillon.setId_echantillon(id_echantillon);
				echantillon.setVolume_echantillon(volume_echantillon);
				echantillon.setStatus_echantillon(status_echantillon);
				echantillon.setStatus_reception(status_reception);
				echantillon.setStatus_analyse(status_analyse);
				echantillon.setStatus_conservation(status_conservation);
				echantillon.setStatus_resultat(status_resultat);
				echantillon.setDate_prelevement(date_prelevement);
				echantillon.setId_pathologie(id_pathologie);
				echantillon.setId_patient(id_patient);
				echantillon.setId_reception(id_reception);
				echantillon.setId_type_echantillon(id_type_echantillon);
				echantillon.setStatus_resultat_for_conservation(status_resultat_for_conservation);
				
				echantillons.add(echantillon);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return echantillons;
	}
	
	public List<Echantillon> getAllEchantillonsWhereNotConservation(){
		loadDatabase();
		List<Echantillon> echantillons = new ArrayList<Echantillon>();
		ResultSet resultSet;
		Statement statement;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery
			("SELECT  `id`, `id_echantillon`, `volume_echantillon`, `status_echantillon`, `status_reception`, `status_conservation`, `status_analyse`, `status_resultat`, `date_prelevement`, `id_pathologie`, `id_patient`, `id_reception`, `id_type_echantillon`,status_resultat_for_conservation FROM `echantillon` where status_conservation='Receptionné-Analysé-PasConservé' ");
			
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String id_echantillon = resultSet.getString("id_echantillon");
				int volume_echantillon = resultSet.getInt("volume_echantillon");
				String status_echantillon = resultSet.getString("status_echantillon");
				String status_reception = resultSet.getString("status_reception");
				String status_analyse = resultSet.getString("status_analyse");
				String status_conservation = resultSet.getString("status_conservation");
				String status_resultat = resultSet.getString("status_resultat");
				Date date_prelevement = resultSet.getDate("date_prelevement");
				String id_pathologie = resultSet.getString("id_pathologie");
				String id_patient = resultSet.getString("id_patient");
				String id_reception = resultSet.getString("id_reception");
				String id_type_echantillon = resultSet.getString("id_type_echantillon");
				String status_resultat_for_conservation = resultSet.getString("status_resultat_for_conservation");
				
				Echantillon echantillon = new Echantillon();
				echantillon.setId(id);
				echantillon.setId_echantillon(id_echantillon);
				echantillon.setVolume_echantillon(volume_echantillon);
				echantillon.setStatus_echantillon(status_echantillon);
				echantillon.setStatus_reception(status_reception);
				echantillon.setStatus_analyse(status_analyse);
				echantillon.setStatus_conservation(status_conservation);
				echantillon.setStatus_resultat(status_resultat);
				echantillon.setDate_prelevement(date_prelevement);
				echantillon.setId_pathologie(id_pathologie);
				echantillon.setId_patient(id_patient);
				echantillon.setId_reception(id_reception);
				echantillon.setId_type_echantillon(id_type_echantillon);
				echantillon.setStatus_resultat_for_conservation(status_resultat_for_conservation);
				
				echantillons.add(echantillon);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return echantillons;
	}
	
	
	public void changeStatusAnalyse(String id_echantillon) {
		loadDatabase();
		
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement("UPDATE `echantillon` SET `status_analyse`='Receptionné-Analysé' WHERE id_echantillon=?");
			preparedStatement.setString(1, id_echantillon);
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void changeStatusAConservé(String id_echantillon) {
		loadDatabase();
		
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement("UPDATE `echantillon` SET `status_conservation`='Receptionné-Analysé-AConservé' WHERE id_echantillon=?");
			preparedStatement.setString(1, id_echantillon);
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void changeStatusPasConservé(String id_echantillon) {
		loadDatabase();
		
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement("UPDATE `echantillon` SET `status_conservation`='Receptionné-Analysé-PasConservé' WHERE id_echantillon=?");
			preparedStatement.setString(1, id_echantillon);
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void changeStatusResultat(String id_echantillon) {
		loadDatabase();
		
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement("UPDATE `echantillon` SET `status_resultat`='Receptionné-Analysé-ResultatRendu' WHERE id_echantillon=?");
			preparedStatement.setString(1, id_echantillon);
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void changeStatusResultatForConservation(String id_echantillon) {
		loadDatabase();
		
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement("UPDATE `echantillon` SET `status_resultat_for_conservation`='Oui' WHERE id_echantillon=?");
			preparedStatement.setString(1, id_echantillon);
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	public void changeStatusToResultat(String id_echantillon) {
		loadDatabase();
		
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement("UPDATE `echantillon` SET `status_echantillon`='Resultat transmis' WHERE id_echantillon=?");
			preparedStatement.setString(1, id_echantillon);
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	
	/*
	public void changeStatusToConservation(String id_echantillon) {
		loadDatabase();
		
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement("UPDATE `echantillon` SET `status_echantillon`='Conservé' WHERE id_echantillon=?");
			preparedStatement.setString(1, id_echantillon);
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	
	public int getCountStatusRecus() {
		loadDatabase();
		Statement statement = null;
		ResultSet resultSet = null;
		int countReceptionne = 0;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT * from echantillon where status_reception ='Receptionné'");
			
			while(resultSet.next()) {
				countReceptionne++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return countReceptionne;
	}
	
	public int getCountStatusTraite() {
		loadDatabase();
		Statement statement = null;
		ResultSet resultSet = null;
		int countTraite = 0;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT * from echantillon where status_analyse ='Receptionné-Analysé'");
			
			while(resultSet.next()) {
				countTraite++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return countTraite;
	}
	
	public int getCountStatusConserve() {
		loadDatabase();
		Statement statement = null;
		ResultSet resultSet = null;
		int countConserve = 0;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT * from echantillon where status_echantillon ='Conservé'");
			
			while(resultSet.next()) {
				countConserve++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return countConserve;
	}
	
	public int getCountResultatTransmis() {
		loadDatabase();
		Statement statement = null;
		ResultSet resultSet = null;
		int countResultatTransmis = 0;
		
		try {
			statement = connexion.createStatement();
			resultSet = statement.executeQuery("SELECT * from echantillon where status_echantillon ='Resultats transmis'");
			
			while(resultSet.next()) {
				countResultatTransmis++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return countResultatTransmis;
	}
}
