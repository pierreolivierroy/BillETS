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
    private ArrayList<Spectacle> spectacles = new ArrayList<Spectacle>();
    
    
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

	public ArrayList<Spectacle> getSpectacles(){
		
		spectacles.clear();

		Spectacle spectacle1 = new Spectacle();
		spectacle1.setId(1);
		spectacle1.setNom("Les Heures Verticales");
		ArrayList<String> liste1 = new ArrayList<String>();
		liste1.add("Louis-José Houde");
		spectacle1.setArtistes(liste1);
		spectacle1.setDescription("Les heures verticales. Pour l’humoriste, Les heures verticales, c’est le temps où l’être humain est debout, à partir du jour où il a appris à marcher, mais aussi dans les moments où il doit se tenir droit devant ou dans l’adversité.");
		spectacle1.setImagePath("ljh.jpg");
		spectacles.add(spectacle1);
		
		Spectacle spectacle2 = new Spectacle();
		spectacle2.setId(2);
		spectacle2.setNom("Les Heures Verticales");
		ArrayList<String> liste2 = new ArrayList<String>();
		liste2.add("Louis-José Houde");
		spectacle2.setDescription("Les heures verticales. Pour l’humoriste, Les heures verticales, c’est le temps où l’être humain est debout, à partir du jour où il a appris à marcher, mais aussi dans les moments où il doit se tenir droit devant ou dans l’adversité.");
		spectacle2.setArtistes(liste2);
		spectacle2.setImagePath("ljh.jpg");
		spectacles.add(spectacle2);
		
		return spectacles;
	}

	public Spectacle getSpectacle(int id){
		return spectacles.get(id+1);
	}
}
