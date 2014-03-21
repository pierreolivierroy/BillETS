package ets.gti525.tp2;

import gti525.paiement.InformationsPaiementTO;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Facture {
	private int id;
	private Date date;
	private InformationsLivraisonBean info_livraison;
	private InformationsPaiementTO info_paiement;
	private ArrayList<LignePanier> lignesPanier;
	private BigDecimal sous_total;
	private BigDecimal tps;
	private BigDecimal tvq;
	private BigDecimal total;
	private String numeroFacture;
	private String carteDeCredit;
	
	public Facture(InformationsLivraisonBean info_livraison, InformationsPaiementTO info_paiement, ArrayList<LignePanier> lignesPanier, BigDecimal sous_total, BigDecimal tps, BigDecimal tvq, BigDecimal total, String carteDeCredit) {
		super();
		this.info_livraison = info_livraison;
		this.info_paiement = info_paiement;
		this.lignesPanier = lignesPanier;
		this.sous_total = sous_total;
		this.tps = tps;
		this.tvq = tvq;
		this.total = total;
		this.date = new Date();
		this.numeroFacture = genererNumeroFacture(16);
		this.carteDeCredit = carteDeCredit;
	}

	public String getCarteDeCredit() {
		return carteDeCredit;
	}

	public void setCarteDeCredit(String carteDeCredit) {
		this.carteDeCredit = carteDeCredit;
	}

	public String getNumeroFacture() {
		return numeroFacture;
	}

	public void setNumeroFacture(String numeroFacture) {
		this.numeroFacture = numeroFacture;
	}

	private String genererNumeroFacture(int size) {
		//Numéro de facture aléatoire
		StringBuffer buffer = new StringBuffer();
		String c = "0123456789";
		for (int i = 0; i < size; i++) {
			double index = Math.random() * c.length();
			buffer.append(c.charAt((int) index));
		}	
		
		return buffer.toString();
	}
	
	public int getId() {
		return id;
	}

	public String getDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		return dateFormat.format(this.date);
	}

	public InformationsLivraisonBean getInfo_livraison() {
		return info_livraison;
	}

	public InformationsPaiementTO getInfo_paiement() {
		return info_paiement;
	}

	public ArrayList<LignePanier> getLignesPanier() {
		return lignesPanier;
	}

	public BigDecimal getSous_total() {
		return sous_total;
	}

	public BigDecimal getTps() {
		return tps;
	}

	public BigDecimal getTvq() {
		return tvq;
	}

	public BigDecimal getTotal() {
		return total;
	}
	
}
