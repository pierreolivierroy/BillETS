package ets.gti525.tp2;

import java.util.ArrayList;
import java.util.Date;

public class Representation {
	private int id;
	private Salle salle;
	private Date date;
	private ArrayList<Billets> billets;
	
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public ArrayList<Billets> getBillets() {
		return billets;
	}
	public void setBillets(ArrayList<Billets> billets) {
		this.billets = billets;
	}
	
	
	
}
