package ets.gti525.tp2;

import java.util.ArrayList;

public class SpectacleDAOStub implements ISpectacleDAO {
	
	private ArrayList<Spectacle> listeSpectacles = new ArrayList<Spectacle>();
	
	public SpectacleDAOStub(){
		Spectacle spectacle1 = new Spectacle();
		spectacle1.setId(1);
		spectacle1.setNom("Les Heures Verticales");
		ArrayList<String> liste1 = new ArrayList<String>();
		liste1.add("Louis-José Houde1");
		spectacle1.setArtistes(liste1);
		spectacle1.setDescription("Les heures verticales. Pour l’humoriste, Les heures verticales, c’est le temps où l’être humain est debout, à partir du jour où il a appris à marcher, mais aussi dans les moments où il doit se tenir droit devant ou dans l’adversité.");
		spectacle1.setImagePath("ljh.jpg");
		listeSpectacles.add(spectacle1);
		
		Spectacle spectacle2 = new Spectacle();
		spectacle2.setId(2);
		spectacle2.setNom("Danny Boyer est tout nu");
		ArrayList<String> liste2 = new ArrayList<String>();
		liste2.add("Louis-José Houde2");
		spectacle2.setDescription("Les heures verticales. Pour l’humoriste, Les heures verticales, c’est le temps où l’être humain est debout, à partir du jour où il a appris à marcher, mais aussi dans les moments où il doit se tenir droit devant ou dans l’adversité.");
		spectacle2.setArtistes(liste2);
		spectacle2.setImagePath("sugar.png");
		listeSpectacles.add(spectacle2);
		
		Spectacle spectacle3 = new Spectacle();
		spectacle3.setId(2);
		spectacle3.setNom("Les Heures Verticales Part II");
		ArrayList<String> liste3 = new ArrayList<String>();
		liste3.add("Louis-José Houde3");
		spectacle3.setDescription("Les heures verticales. Pour l’humoriste, Les heures verticales, c’est le temps où l’être humain est debout, à partir du jour où il a appris à marcher, mais aussi dans les moments où il doit se tenir droit devant ou dans l’adversité.");
		spectacle3.setArtistes(liste3);
		spectacle3.setImagePath("54589463.jpg");
		listeSpectacles.add(spectacle3);
	}
	
	/**
	 * Obtenir la liste de tous les spectacles
	 */
	public ArrayList<Spectacle> getListeSpectacles(){
		return this.listeSpectacles;
	}
	/**
	 * Obtenir un spectacle selon un ID donn�
	 */
	public Spectacle getSpectacleID(int id){
		return null;
	}
	/**
	 * Obtenir une liste de spectacles selon une recherche de spectacle (AJAX)
	 */
	public ArrayList<Spectacle> getSpectacleNom(String spectacleNom){
		
		ArrayList<Spectacle> liste = new ArrayList<Spectacle>();
		
		for (int i = 0; i < this.listeSpectacles.size(); i++) {
			
			Spectacle s = this.listeSpectacles.get(i);
			
			if(spectacleNom.toLowerCase().contains(s.getNom().toLowerCase())){
				liste.add(s);
			}
		}
		
		/**
		 * Si on trouve aucun spectacle pour ce nom, on retourne la liste compl�te
		 */
		if(liste.size() > 0) {
			return liste;
		}
		else {
			return this.getListeSpectacles();
		}
		
	}
}
