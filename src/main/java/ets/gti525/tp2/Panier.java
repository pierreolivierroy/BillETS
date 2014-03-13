package ets.gti525.tp2;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Panier {
	private ArrayList<LignePanier> lignesPanier;
	
	public Panier(){
		lignesPanier = new ArrayList<LignePanier>();
	}
	
	/**
	 * Ajouter une ligne dans le panier
	 * @param ligne
	 */
	public void addLine(LignePanier ligne){
		lignesPanier.add(ligne);
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
		for (int i=0;i<lignesPanier.size();i++)
		{
			total = total.add(lignesPanier.get(i).getTotal());
		}
		return total;
	}
}
