/**
 * Facade pour obtenir les spectacles. Les spectacles sont créer dans un arraylist pour le tp2
 */
package ets.gti525.tp2;

import java.util.ArrayList;

public class SpectaclesFacade {
	
    // L'utilisation du mot clé volatile permet, en Java version 5 et supérieur, 
    // permet d'éviter le cas où "Singleton.instance" est non-nul,
    // mais pas encore "réellement" instancié.
    // De Java version 1.2 à 1.4, il est possible d'utiliser la classe ThreadLocal.
    private static volatile SpectaclesFacade instance = null;
    private ISpectacleDAO spectacleDAO = new SpectacleDAOXML();
    private ArrayList<SpectacleBean> spectacles = new ArrayList<SpectacleBean>();
    
    private SpectaclesFacade() {
        // La présence d'un constructeur privé supprime le constructeur public par défaut.
        // De plus, seul le singleton peut s'instancier lui même.
        super();
        this.spectacles = this.spectacleDAO.get();
    }

    public final static SpectaclesFacade getInstance() {
        //Le "Double-Checked Singleton"/"Singleton doublement vérifié" permet 
        //d'éviter un appel coûteux à synchronized, 
        //une fois que l'instanciation est faite.
        if (SpectaclesFacade.instance == null) {
           // Le mot-clé synchronized sur ce bloc empêche toute instanciation
           // multiple même par différents "threads".
           // Il est TRES important.
           synchronized(SpectaclesFacade.class) {
             if (SpectaclesFacade.instance == null) {
            	 SpectaclesFacade.instance = new SpectaclesFacade();
             }
           }
        }
        return SpectaclesFacade.instance;
    }

	public ArrayList<SpectacleBean> getSpectacles(){
		return this.spectacles;
	}

	public ArrayList<SpectacleBean> getSpectacleNom(String nom){
		
		ArrayList<SpectacleBean> liste = new ArrayList<SpectacleBean>();
		
		for (int i = 0; i < this.spectacles.size(); i++) {
			
			SpectacleBean s = this.spectacles.get(i);
			
			if(s.getNom().toLowerCase().contains(nom.toLowerCase())){
				liste.add(s);
			}
		}
		
		/**
		 * Si on trouve aucun spectacle pour ce nom, on retourne la liste complète
		 */
		if(liste.size() > 0) {
			return liste;
		}
		else {
			return this.spectacles;
		}
		
	}

	public SpectacleBean getSpectacle(int id){
		for (int i = 0; i < this.spectacles.size(); i++) {
			if (this.spectacles.get(i).getId() == id) {
				return spectacles.get(i);
			}
		}
		return null;
	}
}
