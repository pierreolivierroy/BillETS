package ets.gti525.tp2;

import java.util.ArrayList;

public class Facture {
	private int id;
	private ArrayList<LignePanier> lignesPanier;
	
	public Facture(ArrayList<LignePanier> lignesPanier) {
		super();
		this.lignesPanier = lignesPanier;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<LignePanier> getLignesPanier() {
		return lignesPanier;
	}

	public void setLignesPanier(ArrayList<LignePanier> lignesPanier) {
		this.lignesPanier = lignesPanier;
	}
	
	
	
}
