package ets.gti525.tp2;

import java.util.ArrayList;

public class Representation {
	private RepresentationBean representation;

	public Representation(int id, Salle salle, String date, int[] billets, float prix) {
		representation.setBillets(billets);
		representation.setDate(date);
		representation.setId(id);
		representation.setSalle(salle);
		representation.setPrix(prix);
	}

	public RepresentationBean getRepresentationBean() {
		return representation;
	}
	
	
}
