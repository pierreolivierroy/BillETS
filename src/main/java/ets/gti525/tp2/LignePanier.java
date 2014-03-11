package ets.gti525.tp2;

import java.math.BigDecimal;
import java.util.HashMap;

public class LignePanier {
	private int id;
	private String description;
	private BigDecimal prixUnitaire;
	private HashMap<Integer, Billet> billets;
	
	public LignePanier(int id, String description, BigDecimal prixUnitaire,
			HashMap<Integer, Billet> billets) {
		super();
		this.id = id;
		this.description = description;
		this.prixUnitaire = prixUnitaire;
		this.billets = billets;
	}
	
	/**
	 * Obtenir le total pour l'achat de cette ligne
	 * @return total en bigDecimal
	 */
	public BigDecimal getTotal(){
		BigDecimal nombreBillets = new BigDecimal(this.billets.size());
		return (prixUnitaire.multiply(nombreBillets)); 
	}
	
	/**
	 * Obtenir le nombre de billets
	 * @return
	 */
	public int getQuantite(){
		return this.billets.size();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(BigDecimal prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public HashMap<Integer, Billet> getBillets() {
		return billets;
	}

	public void setBillets(HashMap<Integer, Billet> billets) {
		this.billets = billets;
	}
	
	
	
	
}