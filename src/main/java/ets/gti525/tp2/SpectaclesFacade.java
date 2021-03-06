/**
 * Facade pour obtenir les spectacles. Les spectacles sont créer dans un arraylist pour le tp2
 */
package ets.gti525.tp2;

import java.util.HashMap;

public class SpectaclesFacade {
	
    // L'utilisation du mot clé volatile permet, en Java version 5 et supérieur, 
    // permet d'éviter le cas où "Singleton.instance" est non-nul,
    // mais pas encore "réellement" instancié.
    // De Java version 1.2 à 1.4, il est possible d'utiliser la classe ThreadLocal.
	private static volatile SpectaclesFacade instance = null;
	
    private SpectacleDAOXML spectacleDAO = new SpectacleDAOXML();
//    private SpectacleDAOPostgre spectacleDAO = new SpectacleDAOPostgre();
    
    private SpectaclesFacade() {
        // La présence d'un constructeur privé supprime le constructeur public par défaut.
        // De plus, seul le singleton peut s'instancier lui même.
        super();
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

	public HashMap<Integer, Spectacle> getSpectacles(){
		return this.spectacleDAO.getSpectacles();
	}
	
	public HashMap<Integer, Spectacle> getSpectacles(String nomSpectacle){
		return this.spectacleDAO.getSpectacles(nomSpectacle);
	}
	
	public  Spectacle getSpectacle(int id){
		return this.spectacleDAO.getSpectacle(id);
	}
	
	public  HashMap<Integer, Representation> getRepresentations(int idSpectacle){
		return this.spectacleDAO.getRepresentations(idSpectacle);
	}
	
	public  Representation getRepresentation(int idSpectacle, int idRepresentation){
		return this.spectacleDAO.getRepresentation(idSpectacle, idRepresentation);
	}
	
}
