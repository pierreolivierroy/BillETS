package ets.gti525.tp2;

import java.io.Serializable;
import java.util.ArrayList;

public class RepresentationBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private Salle salle;
	private String date;
	private int[] billets;
	private float prix;
	
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Salle getSalle() {
		return salle;
	}
	public void setSalle(Salle salle) {
		this.salle = salle;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int[] getBillets() {
		return billets;
	}
	public void setBillets(int[] billets) {
		this.billets = billets;
	}
}
