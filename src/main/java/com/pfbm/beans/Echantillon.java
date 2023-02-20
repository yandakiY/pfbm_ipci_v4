package com.pfbm.beans;

import java.sql.Date;

public class Echantillon {
	private int id;
	private String id_echantillon;
	private int volume_echantillon;
	private String status_echantillon;
	private String status_reception;
	private String status_analyse;
	private Date date_prelevement;
	private String id_pathologie;
	private String id_patient;
	private String id_reception;
	private String id_type_echantillon;
	private String status_conservation;
	private String status_resultat_for_conservation;
	private String status_resultat;
	
	
	
	public String getStatus_resultat_for_conservation() {
		return status_resultat_for_conservation;
	}
	public void setStatus_resultat_for_conservation(String status_resultat_for_conservation) {
		this.status_resultat_for_conservation = status_resultat_for_conservation;
	}
	public String getStatus_conservation() {
		return status_conservation;
	}
	public void setStatus_conservation(String status_conservation) {
		this.status_conservation = status_conservation;
	}
	public String getStatus_resultat() {
		return status_resultat;
	}
	public void setStatus_resultat(String status_resultat) {
		this.status_resultat = status_resultat;
	}
	public String getStatus_reception() {
		return status_reception;
	}
	public void setStatus_reception(String status_reception) {
		this.status_reception = status_reception;
	}
	public String getStatus_analyse() {
		return status_analyse;
	}
	public void setStatus_analyse(String status_analyse) {
		this.status_analyse = status_analyse;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getId_echantillon() {
		return id_echantillon;
	}
	public void setId_echantillon(String id_echantillon) {
		this.id_echantillon = id_echantillon;
	}
	public int getVolume_echantillon() {
		return volume_echantillon;
	}
	public void setVolume_echantillon(int volume_echantillon) {
		this.volume_echantillon = volume_echantillon;
	}
	public String getStatus_echantillon() {
		return status_echantillon;
	}
	public void setStatus_echantillon(String status_echantillon) {
		this.status_echantillon = status_echantillon;
	}
	public Date getDate_prelevement() {
		return date_prelevement;
	}
	public void setDate_prelevement(Date date_prelevement) {
		this.date_prelevement = date_prelevement;
	}
	public String getId_pathologie() {
		return id_pathologie;
	}
	public void setId_pathologie(String id_pathologie) {
		this.id_pathologie = id_pathologie;
	}
	public String getId_patient() {
		return id_patient;
	}
	public void setId_patient(String id_patient) {
		this.id_patient = id_patient;
	}
	public String getId_reception() {
		return id_reception;
	}
	public void setId_reception(String id_reception) {
		this.id_reception = id_reception;
	}
	public String getId_type_echantillon() {
		return id_type_echantillon;
	}
	public void setId_type_echantillon(String id_type_echantillon) {
		this.id_type_echantillon = id_type_echantillon;
	}
}
