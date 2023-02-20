package com.pfbm.beans;

public class Patient {
	private int id;
	private String id_patient;
	private String nom_patient;
	private String prenom_patient;
	private String sexe_patient;
	private int age_patient;
	private String contact_patient;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getId_patient() {
		return id_patient;
	}
	public void setId_patient(String id_patient) {
		this.id_patient = id_patient;
	}
	
	public String getNom_patient() {
		return nom_patient;
	}
	public void setNom_patient(String nom_patient) {
		this.nom_patient = nom_patient;
	}
	public String getPrenom_patient() {
		return prenom_patient;
	}
	public void setPrenom_patient(String prenom_patient) {
		this.prenom_patient = prenom_patient;
	}
	public String getSexe_patient() {
		return sexe_patient;
	}
	public void setSexe_patient(String sexe_patient) {
		this.sexe_patient = sexe_patient;
	}
	public int getAge_patient() {
		return age_patient;
	}
	public void setAge_patient(int age_patient) {
		this.age_patient = age_patient;
	}
	public String getContact_patient() {
		return contact_patient;
	}
	public void setContact_patient(String contact_patient) {
		this.contact_patient = contact_patient;
	}
}
