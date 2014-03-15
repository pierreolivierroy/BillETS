package ets.gti525.tp2;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Panier {
	private ArrayList<LignePanier> lignesPanier = new ArrayList<LignePanier>();
	private BigDecimal sous_total = new BigDecimal(0);
	private final BigDecimal TPS = new BigDecimal(0.05);
	private final BigDecimal TVQ = new BigDecimal(0.09975);


	
	public ArrayList<LignePanier> getLignesPanier() {
		return lignesPanier;
	}



	public BigDecimal getSous_total() {
		for(int i=0; i <  this.lignesPanier.size(); i++) {
			this.sous_total.add(this.lignesPanier.get(i).getPrix());
		}
		return sous_total;
	}



	public BigDecimal getTps() {
		return this.sous_total.multiply(TPS).setScale(2);
	}



	public BigDecimal getTvq() {
		return this.sous_total.multiply(TVQ).setScale(2);
	}



	public BigDecimal getTotal() {
		return this.sous_total.add(this.getTps()).add(this.getTvq());
	}



	public void setLignesPanier(ArrayList<LignePanier> lignesPanier) {
		this.lignesPanier = lignesPanier;
	}
	
	
	
	public void enleverLigne(int id_ligne) {
		for (int i = 0; i < lignesPanier.size(); i++) {
			if(lignesPanier.get(i).getId() == id_ligne) {
				lignesPanier.remove(i);
			}
	    }
	}
	
	public void ajouterLigne(LignePanier ligne) {
		this.lignesPanier.add(ligne);
	}

}
