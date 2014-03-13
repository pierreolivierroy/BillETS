package ets.gti525.tp2;

import java.util.HashMap;

public class Facture {
	private int id;
	private HashMap<Integer, LignePanier> lignesPanier;
	
	public Facture(HashMap<Integer, LignePanier> lignesPanier) {
		super();
		this.lignesPanier = lignesPanier;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public HashMap<Integer, LignePanier> getLignesPanier() {
		return lignesPanier;
	}

	public void setLignesPanier(HashMap<Integer, LignePanier> lignesPanier) {
		this.lignesPanier = lignesPanier;
	}
	
	
	
}
