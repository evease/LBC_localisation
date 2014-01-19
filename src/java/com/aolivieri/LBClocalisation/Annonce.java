package com.aolivieri.LBClocalisation;

import java.util.Date;

public class Annonce {
	private String titre;
	private String date;
	private String lien;
	private int prix;
	private String lieu;
	private String photo;
	private String categorie;
	
	public Annonce() {
		super();
	}
	
	public Annonce(String titre, String date, String lien, String lieu, String photo) {
		super();
		this.titre = titre;
		this.date = date;
		this.lien = lien;
		this.lieu = lieu;
		this.photo = photo;
		this.prix = 0;
		this.categorie = null;
	}

	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getLien() {
		return lien;
	}
	public void setLien(String lien) {
		this.lien = lien;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	@Override
	
	public String toString() {
		return "Annonce [titre=" + titre + ", date=" + date + ", lien=" + lien
				+ ", prix=" + prix + ", lieu=" + lieu + ", photo=" + photo
				+ "]";
	}
}
