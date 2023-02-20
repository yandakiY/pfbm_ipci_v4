package com.pfbm.beans;

import java.sql.Date;

public class Analyse {
	private int id;
	private String id_analyse;
	private Date date_analyse;
	private String id_echantillon;
	private String id_type_analyse;
	private String num_labo;
	private String grade_prescripteur;
	private String prescripteur;
	private String site;
	private String adresse;
	private String type_examen;
	private String status_resultat;
	
	
	public String getStatus_resultat() {
		return status_resultat;
	}
	public void setStatus_resultat(String status_resultat) {
		this.status_resultat = status_resultat;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getId_analyse() {
		return id_analyse;
	}
	public void setId_analyse(String id_analyse) {
		this.id_analyse = id_analyse;
	}
	public Date getDate_analyse() {
		return date_analyse;
	}
	public void setDate_analyse(Date date_analyse) {
		this.date_analyse = date_analyse;
	}
	public String getId_echantillon() {
		return id_echantillon;
	}
	public void setId_echantillon(String id_echantillon) {
		this.id_echantillon = id_echantillon;
	}
	public String getId_type_analyse() {
		return id_type_analyse;
	}
	public void setId_type_analyse(String id_type_analyse) {
		this.id_type_analyse = id_type_analyse;
	}
	public String getNum_labo() {
		return num_labo;
	}
	public void setNum_labo(String num_labo) {
		this.num_labo = num_labo;
	}
	public String getGrade_prescripteur() {
		return grade_prescripteur;
	}
	public void setGrade_prescripteur(String grade_prescripteur) {
		this.grade_prescripteur = grade_prescripteur;
	}
	public String getPrescripteur() {
		return prescripteur;
	}
	public void setPrescripteur(String prescripteur) {
		this.prescripteur = prescripteur;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse_analyse) {
		this.adresse = adresse_analyse;
	}
	public String getType_examen() {
		return type_examen;
	}
	public void setType_examen(String type_examen) {
		this.type_examen = type_examen;
	}
	
	
	
}
