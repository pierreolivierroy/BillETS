package ets.gti525.tp2;

import java.util.HashMap;

public class SpectacleDAOStub extends abstractDAO{
	
	private HashMap<Integer, Spectacle> listeSpectacles = new HashMap<Integer, Spectacle>();
	
	public SpectacleDAOStub(){
		
		//populate listeSpectacles map
		HashMap<Integer, Representation> representationsSpectacle1 = new HashMap<Integer, Representation>();
		Salle centreBell = new Salle(1,"Centre Bell", "1909 Avenue des Canadiens-de-Montréal, Montréal, QC H4B 5G0");
		Salle condo = new Salle(1,"Condo à Saint-Phillipe", "1909 Avenue des Canadiens-de-Montréal, Montréal, QC H4B 5G0");
		Representation r1 = new Representation(1,centreBell,"3 mars 2014",100,105);
		Representation r2 = new Representation(1,condo,"10 mars 2014",25,200);
		representationsSpectacle1.put(r1.getId(), r1);
		representationsSpectacle1.put(r2.getId(), r2);
		
		Spectacle spectacle1 = new Spectacle(1, "Les heures verticales", "Olivier Rivard", representationsSpectacle1, "Les heures verticales. Pour l’humoriste, Les heures verticales, c’est le temps où l’être humain est debout, à partir du jour où il a appris à marcher, mais aussi dans les moments où il doit se tenir droit devant ou dans l’adversité.", "ljh.jpg", "ljh-banner.jpg");
		
		Spectacle spectacle2 = new Spectacle(2, "Dan et ses bottes", "danny boyer", representationsSpectacle1, "Une description bidon", "ljh.jpg", "ljh-banner.jpg");
		
		//put all spectacle in the map
		listeSpectacles.put(spectacle1.getId(), spectacle1);
		listeSpectacles.put(spectacle2.getId(), spectacle2);
	}

	public HashMap<Integer, Spectacle> getSpectacles(){
		return this.listeSpectacles;
	}
	
	public Spectacle getSpectacle(int id){
		return this.listeSpectacles.get(id);
	}
	
	public HashMap<Integer, Representation> getRepresentations(int idSpectacle){
		return this.listeSpectacles.get(idSpectacle).getRepresentations();
	}
	
	public Representation getRepresentation(int idSpectacle, int idRepresentation){
		return this.listeSpectacles.get(idSpectacle).getRepresentations().get(idRepresentation);
	}
}
