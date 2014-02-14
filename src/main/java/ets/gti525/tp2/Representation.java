package ets.gti525.tp2;

import java.util.ArrayList;
import java.util.Date;

public class Representation {
	private RepresentationBean representation;

	public Representation(int id, String salle, Date date, ArrayList<Integer>billets) {
		representation.setBillets(billets);
		representation.setDate(date);
		representation.setId(id);
		representation.setSalle(salle);
	}

	public RepresentationBean getRepresentation() {
		return representation;
	}
	
	
}
