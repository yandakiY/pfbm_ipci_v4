package com.pfbm.beans;

import java.sql.Date;

public class Conservation {
	private int id;
	private String id_conservation;
	private String position_biobanque;
	private Date date_debut_conservation;
	private String description_biobanque;
	private String id_echantillon;
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getId_conservation() {
		return id_conservation;
	}
	public void setId_conservation(String id_conservation) {
		this.id_conservation = id_conservation;
	}
	public String getPosition_biobanque() {
		return position_biobanque;
	}
	public void setPosition_biobanque(String position_biobanque) {
		this.position_biobanque = position_biobanque;
	}
	public Date getDate_debut_conservation() {
		return date_debut_conservation;
	}
	public void setDate_debut_conservation(Date date_debut_conservation) {
		this.date_debut_conservation = date_debut_conservation;
	}
	public String getDescription_biobanque() {
		return description_biobanque;
	}
	public void setDescription_biobanque(String description_biobanque) {
		this.description_biobanque = description_biobanque;
	}
	public String getId_echantillon() {
		return id_echantillon;
	}
	public void setId_echantillon(String id_echantillon) {
		this.id_echantillon = id_echantillon;
	}
	
	
}
