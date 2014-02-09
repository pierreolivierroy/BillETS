/**
 * Facade pour obtenir les spectacles. Les spectacles sont créer dans un arraylist pour le tp2
 */
package ets.gti525.tp2;

import java.util.ArrayList;

public class SpectaclesFacade {
	private ArrayList<Spectacle> listeSpectacles = new ArrayList<Spectacle>();
	
	public SpectaclesFacade(){
		
		Spectacle spectacle1 = new Spectacle();
		spectacle1.setId(1);
		spectacle1.setNom("Les Heures Verticales");
		ArrayList<String> liste1 = new ArrayList<String>();
		liste1.add("Louis-José Houde");
		spectacle1.setArtistes(liste1);
		spectacle1.setDescription("Les heures verticales. Pour l’humoriste, Les heures verticales, c’est le temps où l’être humain est debout, à partir du jour où il a appris à marcher, mais aussi dans les moments où il doit se tenir droit devant ou dans l’adversité.");
		listeSpectacles.add(spectacle1);
		
		Spectacle spectacle2 = new Spectacle();
		spectacle2.setId(2);
		spectacle2.setNom("Les Heures Verticales");
		ArrayList<String> liste2 = new ArrayList<String>();
		liste2.add("Louis-José Houde");
		spectacle2.setDescription("Les heures verticales. Pour l’humoriste, Les heures verticales, c’est le temps où l’être humain est debout, à partir du jour où il a appris à marcher, mais aussi dans les moments où il doit se tenir droit devant ou dans l’adversité.");
		spectacle2.setArtistes(liste2);
		listeSpectacles.add(spectacle2);
	}
	
	/**
	 * Obtenir la liste de spectacles
	 */
	public ArrayList<Spectacle> getListeSpectacles(){
		return listeSpectacles;
	}
	
	/**
	 * Obtenir le spectacle selon son id
	 */
	public Spectacle getSpectacle(int id){
		return listeSpectacles.get(id+1);
	}
	
	
}
