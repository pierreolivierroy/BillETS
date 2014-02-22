package ets.gti525.tp2;

public class Representation {
	private int id;
	private Salle salle;
	private String date;
	private int billets;
	private float prix;
	
	public Representation(int id, Salle salle, String date, int billets, float prix) {
		super();
		this.id = id;
		this.salle = salle;
		this.date = date;
		this.billets = billets;
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
	public int getBillets() {
		return billets;
	}
	public void setBillets(int billets) {
		this.billets = billets;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	
	
}
