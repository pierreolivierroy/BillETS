package ets.gti525.tp2;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class LignePanier {
	private int id;
	private int quantite;
	private String titre;
	private String description;
	private BigDecimal prixUnitaire;

	private HashMap<Integer, Billet> billets;

	public LignePanier() {
		super();
	}
	
	public HashMap<Integer, Billet> getBillets() {
		return billets;
	}

	public void setBillets(HashMap<Integer, Billet> billets) {
		this.billets = billets;
	}

	public LignePanier(int id, int quantite, String titre, String description,
			BigDecimal prixUnitaire, BigDecimal prix) {
		super();
		this.id = id;
		this.quantite = quantite;
		this.titre = titre;
		this.description = description;
		this.prixUnitaire = prixUnitaire;
		this.billets = new HashMap<Integer, Billet>();
	}

	public void ajouterReferenceBillet(Billet billet)
	{
		billets.put(billet.getId(), billet);
	}
	
	public void libererBillets()
	{
		for (Billet billet : billets.values()) {
			billet.setDateReserve(null);
		}
		billets.clear();
	}
	
	public long tempsRestantAvantLiberation()
	{
		// Nombre de minutes avant la libération d'un billet
		Billet billet = (Billet) billets.values().iterator().next();
		
		// Conversion de milisecondes en minutes
		return 20 - (new Date().getTime() - billet.getDateReserve().getTime()) / (60 * 1000) % 60;
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
		return prixUnitaire.multiply(new BigDecimal(quantite));
	}

	public void vendre_billets() {
		Iterator<Entry<Integer, Billet>> it = billets.entrySet().iterator();
		while(it.hasNext()) {
			Billet billet  = it.next().getValue();
			billet.setVendu(true);	
		}
		
	}
}
	
	
	