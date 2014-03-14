package ets.gti525.tp2;

import java.math.BigDecimal;
import java.util.Stack;

public class Representation {
	private int id;
	private int idSpectacle;
	private Salle salle;
	private String date;
	private int billets;
	private BigDecimal prix;
	private Stack<Billet> billetsReserves;
	private Stack<Billet> billetsDisponibles;
	
	public Representation(int id, int idSpectacle, Salle salle, String date, int billets, BigDecimal prix) {
		super();
		this.id = id;
		this.idSpectacle = idSpectacle;
		this.salle = salle;
		this.date = date;
		this.billets = billets;
		this.prix = prix;
		this.billetsReserves = new Stack<Billet>();
		this.billetsDisponibles = new Stack<Billet>();
	}
	
	public Stack<Billet> getBilletsDisponibles() {
		return billetsDisponibles;
	}

	public void setBilletsDisponibles(Stack<Billet> billetsDisponibles) {
		this.billetsDisponibles = billetsDisponibles;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdSpectacle() {
		return idSpectacle;
	}
	public void setIdSpectacle(int idSpectacle) {
		this.idSpectacle = idSpectacle;
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
		return this.billetsDisponibles.size();
	}
	public void setBillets(int billets) {
		this.billets = billets;
	}
	public BigDecimal getPrix() {
		return prix;
	}
	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}
	
	
}
