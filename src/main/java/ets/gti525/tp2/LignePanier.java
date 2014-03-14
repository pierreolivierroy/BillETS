package ets.gti525.tp2;

import java.math.BigDecimal;

public class LignePanier {
	private int id;
	private int quantite;
	private String titre;
	private String description;
	private BigDecimal prixUnitaire;
	private BigDecimal prix;

	public LignePanier() {
		super();
	}
	
	
	public LignePanier(int id, int quantite, String titre, String description,
			BigDecimal prixUnitaire, BigDecimal prix) {
		super();
		this.id = id;
		this.quantite = quantite;
		this.titre = titre;
		this.description = description;
		this.prixUnitaire = prixUnitaire;
		this.prix = prix;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
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
	public BigDecimal getPrix() {
		return prix;
	}
	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}
}
	
	
	