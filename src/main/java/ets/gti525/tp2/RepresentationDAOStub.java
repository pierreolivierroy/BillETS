package ets.gti525.tp2;

import java.util.ArrayList;

public class RepresentationDAOStub implements InterfaceDAO {
	
	private ArrayList<RepresentationBean> representations = new ArrayList<RepresentationBean>();
	
	public RepresentationDAOStub(){
		
		Salle centreBell = new Salle(1,"Centre Bell", "1909 Avenue des Canadiens-de-Montréal, Montréal, QC H4B 5G0");
		Salle metropolis = new Salle(2,"Metropolis", "59 Rue Sainte-Catherine Est, Montréal, QC H2X 1K5");
		ArrayList<Integer> billets = new ArrayList<Integer>();
		for(int i=0;i<100;i++)
		{
			billets.add(i);
		}
		//Représentations bidon
		
		Representation represention1 = new Representation(1,centreBell,"3 mars 2014",billets,105);
		representations.add(represention1.getRepresentationBean());
		
		Representation represention2 = new Representation(2,centreBell,"4 mars 2014",billets,105);
		representations.add(represention2.getRepresentationBean());
		
		Representation represention3 = new Representation(3,centreBell,"5 mars 2014",billets,105);
		representations.add(represention3.getRepresentationBean());
		
		Representation represention4 = new Representation(4,metropolis,"6 mars 2014",billets,150);
		representations.add(represention4.getRepresentationBean());
		
		Representation represention5 = new Representation(5,centreBell,"7 mars 2014",billets,150);
		representations.add(represention5.getRepresentationBean());
		
		Representation represention6 = new Representation(6,centreBell,"8 mars 2014",billets,150);
		representations.add(represention6.getRepresentationBean());
		
		Representation represention7 = new Representation(7,centreBell,"3 mars 2014",billets,105);
		representations.add(represention7.getRepresentationBean());
		
		Representation represention8 = new Representation(8,centreBell,"4 mars 2014",billets,105);
		representations.add(represention8.getRepresentationBean());
		
		Representation represention9 = new Representation(9,centreBell,"5 mars 2014",billets,105);
		representations.add(represention9.getRepresentationBean());
		
		Representation represention10 = new Representation(10,metropolis,"6 mars 2014",billets,150);
		representations.add(represention10.getRepresentationBean());
		
		Representation represention11 = new Representation(11,centreBell,"7 mars 2014",billets,150);
		representations.add(represention11.getRepresentationBean());
		
		Representation represention12 = new Representation(12,centreBell,"8 mars 2014",billets,150);
		representations.add(represention12.getRepresentationBean());
	}
	
	@Override
	public Object find(int id) {
		for (int i = 0; i < this.representations.size(); i++) {
			if (( this.representations.get(i)).getId() == id) {
				return this.representations.get(i);
			}
		}
		return null;
	}
	

	@Override
	public ArrayList find() {
		// TODO Auto-generated method stub
		return null;
	}

}
