package ets.gti525.tp2;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Panier {
	private ArrayList<LignePanier> lignesPanier = new ArrayList<LignePanier>();
	private BigDecimal sous_total = new BigDecimal(0);
	private BigDecimal tps  = new BigDecimal(0);
	private BigDecimal tvq  = new BigDecimal(0);
	private BigDecimal total  = new BigDecimal(0);
	private final BigDecimal TPS = new BigDecimal(0.05);
	private final BigDecimal TVQ = new BigDecimal(0.09975);

	public ArrayList<LignePanier> getLignesPanier() {
		return lignesPanier;
	}
	public void setLignesPanier(ArrayList<LignePanier> lignesPanier) {
		this.lignesPanier = lignesPanier;
	}
	public BigDecimal getSous_total() {
		return sous_total;
	}
	public void setSous_total(BigDecimal sous_total) {
		this.sous_total = sous_total;
	}
	public BigDecimal getTps() {
		return tps;
	}
	public void setTps(BigDecimal tps) {
		this.tps = tps;
	}
	public BigDecimal getTvq() {
		return tvq;
	}
	public void setTvq(BigDecimal tvq) {
		this.tvq = tvq;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
	public void ajouterLigne(LignePanier ligne) {
		BigDecimal prix_ligne = ligne.getPrix();
		BigDecimal sous_total = getSous_total().add(prix_ligne);
		BigDecimal tps = sous_total.multiply(TPS);
		BigDecimal tvq = sous_total.multiply(TVQ);
		
		this.getLignesPanier().add(ligne);
		this.setSous_total(sous_total.setScale(2, BigDecimal.ROUND_HALF_UP));
		this.setTps(tps.setScale(2, BigDecimal.ROUND_HALF_UP));
		this.setTvq(tvq.setScale(2, BigDecimal.ROUND_HALF_UP));
		this.setTotal(sous_total.add(tps.add(tvq)).setScale(2, BigDecimal.ROUND_HALF_UP));
	}

}
