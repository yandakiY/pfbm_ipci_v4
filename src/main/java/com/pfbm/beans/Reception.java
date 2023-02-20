package com.pfbm.beans;

import java.sql.Date;

public class Reception {
	private int id;
	private String id_reception;
	private String provenance;
	private String code_glaciere;
	private String nom_glaciere;
	private int nb_prelevement;
	private Date date_reception;
	private int temperature_debut;
	private int temperature_arrivee;
	private String id_transporteur;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getId_reception() {
		return id_reception;
	}
	public void setId_reception(String id_reception) {
		this.id_reception = id_reception;
	}
	public String getProvenance() {
		return provenance;
	}
	public void setProvenance(String provenance) {
		this.provenance = provenance;
	}
	public String getCode_glaciere() {
		return code_glaciere;
	}
	public void setCode_glaciere(String code_glaciere) {
		this.code_glaciere = code_glaciere;
	}
	public String getNom_glaciere() {
		return nom_glaciere;
	}
	public void setNom_glaciere(String nom_glaciere) {
		this.nom_glaciere = nom_glaciere;
	}
	public int getNb_prelevement() {
		return nb_prelevement;
	}
	public void setNb_prelevement(int nb_prelevement) {
		this.nb_prelevement = nb_prelevement;
	}
	public Date getDate_reception() {
		return date_reception;
	}
	public void setDate_reception(Date date_reception) {
		this.date_reception = date_reception;
	}
	public int getTemperature_debut() {
		return temperature_debut;
	}
	public void setTemperature_debut(int temperature_debut) {
		this.temperature_debut = temperature_debut;
	}
	public int getTemperature_arrivee() {
		return temperature_arrivee;
	}
	public void setTemperature_arrivee(int temperature_arrivee) {
		this.temperature_arrivee = temperature_arrivee;
	}
	public String getId_transporteur() {
		return id_transporteur;
	}
	public void setId_transporteur(String id_transporteur) {
		this.id_transporteur = id_transporteur;
	}
	
}
