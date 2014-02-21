package ets.gti525.tp2;

import java.util.ArrayList;

public class SpectacleDAOStub implements ISpectacleDAO {
	
	private ArrayList<SpectacleBean> spectacles = new ArrayList<SpectacleBean>();
	
	public SpectacleDAOStub(){
		
		//Spectacle bidon 1
		ArrayList<String> liste1 = new ArrayList<String>();
		liste1.add("Louis-José Houde");
		liste1.add("Chuck Norris");
		Spectacle spectacle1 = new Spectacle(1, "Les Heures Verticales", "Les heures verticales. Pour l’humoriste, Les heures verticales, c’est le temps où l’être humain est debout, à partir du jour où il a appris à marcher, mais aussi dans les moments où il doit se tenir droit devant ou dans l’adversité.", liste1, "ljh.jpg","ljh-banner.jpg", new ArrayList<Integer>());
		spectacles.add(spectacle1.getSpectacleBean());
		
		//Spectacle bidon 2
		ArrayList<String> liste2 = new ArrayList<String>();
		liste2.add("Danny Boyer");
		Spectacle spectacle2 = new Spectacle(2, "Dan et ses bottes", "Le spectacle avec des gens moins habillés que la normale.", liste2, "sugar.png","sugarsammy-banner.jpg", new ArrayList<Integer>());
		spectacles.add(spectacle2.getSpectacleBean());
		
		//Spectacle bidon 3
		ArrayList<String> liste3 = new ArrayList<String>();
		liste3.add("Registre Labombe");
		Spectacle spectacle3 = new Spectacle(3, "Le bonhomme carnaval", "Le plus grand citoyen de la vieille capitale.", liste3, "54589463.jpg","varekai_bg.jpg", new ArrayList<Integer>());
		spectacles.add(spectacle3.getSpectacleBean());
	}
	
	/**
	 * Obtenir la liste de tous les spectacles
	 */
	public ArrayList<SpectacleBean> get(){
		return this.spectacles;
	}
}
