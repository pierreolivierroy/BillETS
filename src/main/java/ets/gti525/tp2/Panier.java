package ets.gti525.tp2;

import java.math.BigDecimal;
import java.util.HashMap;

public class Panier {
	private HashMap<Integer, LignePanier> lignesPanier;
	
	public Panier(){
		lignesPanier = new HashMap<Integer, LignePanier>();
	}
	
	/**
	 * Ajouter une ligne dans le panier
	 * @param ligne
	 */
	public void addLine(LignePanier ligne){
		lignesPanier.put(ligne.getId(), ligne);
	}
	
	/**
	 * Supprimer une ligne en spécifiant le id de la ligne
	 * @param id
	 */
	public void removeLine(int id){
		lignesPanier.remove(id);
	}
	
	public Facture generateBill(){
		return new Facture(lignesPanier);
	}
	
	/**
	 * Obtenir le total du panier
	 * @return
	 */
	public BigDecimal getTotal(){
		BigDecimal total = new BigDecimal(0);
		for (Integer mapKey : lignesPanier.keySet()) {
			total = total.add(lignesPanier.get(mapKey).getTotal());
		}
		return total;
	}
}
