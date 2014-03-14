package ets.gti525.tp2;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Panier {
	private ArrayList<LignePanier> lignesPanier = new ArrayList<LignePanier>();
	private BigDecimal sous_total = new BigDecimal(0);
	private BigDecimal tps  = new BigDecimal(0);
	private BigDecimal tvq  = new BigDecimal(0);
	private BigDecimal total  = new BigDecimal(0);

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

}
