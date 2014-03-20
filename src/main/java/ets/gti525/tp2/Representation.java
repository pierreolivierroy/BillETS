package ets.gti525.tp2;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

public class Representation {
	private int id;
	private int idSpectacle;
	private Salle salle;
	private String date;
	private BigDecimal prix;
	private HashMap<Integer, Billet> billets;
	
	public Representation(int id, int idSpectacle, Salle salle, String date, BigDecimal prix) {
		super();
		this.id = id;
		this.idSpectacle = idSpectacle;
		this.salle = salle;
		this.date = date;
		this.prix = prix;
		this.billets = new HashMap<Integer, Billet>();
	}
	
	public void ajouterBillet(Billet billet)
	{
		billets.put(billet.getId(), billet);
	}
	
	public HashMap<Integer, Billet> obtenirBillets()
	{
		return billets;
	}
	
	public Billet obtenirBillet(Integer id_billet)
	{
		return billets.get(id_billet);
	}
	
	public Billet reserverBillet()
	{
		for (Billet billet : billets.values()) {
			if (!billet.isReserve() && !billet.isVendu())
			{
				billet.setDateReserve(new Date());
				return billet;
			}
		}
		// Dans le cas ou aucun billet n'est dispo.
		return null;

	}
	
	public Integer obtenirNombreBillets() {
		return billets.size();
	}
	
	public Integer obtenirNombreBilletsDisponibles()
	{
		int billets_dispos = 0;
		
		// Boucler sur tous les billets pour vérifier le nombre disponible.
		for (Billet billet : billets.values()) {
			if (!((Billet) billet).isReserve())
			{
				// On incrémente
				billets_dispos++;
			}
		}

		return billets_dispos;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdSpectacle() {
		return idSpectacle;
	}
	public void setIdSpectacle(int idSpectacle) {
		this.idSpectacle = idSpectacle;
	}
	public Salle getSalle() {
		return salle;
	}
	public void setSalle(Salle salle) {
		this.salle = salle;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public BigDecimal getPrix() {
		return prix;
	}
	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}
	
	
}
