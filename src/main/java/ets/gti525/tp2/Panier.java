package ets.gti525.tp2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Panier {
	private ArrayList<LignePanier> lignesPanier = new ArrayList<LignePanier>();
	
	private final BigDecimal TPS = new BigDecimal(0.05);
	
	private final BigDecimal TVQ = new BigDecimal(0.09975);
	
	public ArrayList<LignePanier> getLignesPanier() {
		return lignesPanier;
	}

	public BigDecimal getSous_total() {
		
		BigDecimal sous_total = new BigDecimal(0);
		
		for(int i=0; i <  this.lignesPanier.size(); i++) {
			sous_total = sous_total.add(this.lignesPanier.get(i).getPrix());
		}
		return sous_total.setScale(2, RoundingMode.HALF_UP);
	}

	public BigDecimal getTps() {
		return getSous_total().multiply(TPS).setScale(2, RoundingMode.HALF_UP);
	}

	public BigDecimal getTvq() {
		return getSous_total().multiply(TVQ).setScale(2, RoundingMode.HALF_UP);
	}

	public BigDecimal getTotal() {
		return getSous_total().add(this.getTps()).add(this.getTvq());
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
	
	public LignePanier getLignePanier(int ligne_id) {
		for(LignePanier ligne : lignesPanier) {
			if(ligne.getId() == ligne_id) {
				return ligne;
			}
		}
		return null;
	}
	
	public int get_line_count() {
		return this.lignesPanier.size();
	}
	
	public void vider_panier() {
		lignesPanier.clear();
	}

}
