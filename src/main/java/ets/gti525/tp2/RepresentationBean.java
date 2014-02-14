package ets.gti525.tp2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class RepresentationBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String salle;
	private Date date;
	private ArrayList<Integer> billets;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSalle() {
		return salle;
	}
	public void setSalle(String salle) {
		this.salle = salle;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public ArrayList<Integer> getBillets() {
		return billets;
	}
	public void setBillets(ArrayList<Integer> billets) {
		this.billets = billets;
	}
}
