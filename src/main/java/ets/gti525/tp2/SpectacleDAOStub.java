package ets.gti525.tp2;

import java.util.ArrayList;

public class SpectacleDAOStub implements InterfaceDAO {
	
	private ArrayList<SpectacleBean> spectacles = new ArrayList<SpectacleBean>();
	
	public SpectacleDAOStub(){
		
		
		//Spectacle bidon 1
		int[] t1= {1,2,3};
		Spectacle spectacle1 = new Spectacle(1, "Les Heures Verticales", "Les heures verticales. Pour l’humoriste, Les heures verticales, c’est le temps où l’être humain est debout, à partir du jour où il a appris à marcher, mais aussi dans les moments où il doit se tenir droit devant ou dans l’adversité.", "Louis-José Houde", "ljh.jpg","ljh-banner.jpg", t1);
		spectacles.add(spectacle1.getSpectacleBean());
		
		//Spectacle bidon 2
		int[] t2= {4,5,6,7,8};
		Spectacle spectacle2 = new Spectacle(2, "Dan et ses bottes", "Le spectacle avec des gens moins habillés que la normale.", "Danny Boyer", "sugar.png","sugarsammy-banner.jpg", t2);
		spectacles.add(spectacle2.getSpectacleBean());
		
		//Spectacle bidon 3
		int[] t3= {8,10,11,12};
		Spectacle spectacle3 = new Spectacle(3, "Le bonhomme carnaval", "Le plus grand citoyen de la vieille capitale.", "Registre Labombe", "54589463.jpg","varekai_bg.jpg", t3);
		spectacles.add(spectacle3.getSpectacleBean());
	}

	@Override
	public Object find(int id) {
		for (int i = 0; i < this.spectacles.size(); i++) {
			if (((SpectacleBean) this.spectacles.get(i)).getId() == id) {
				return (SpectacleBean) this.spectacles.get(i);
			}
		}
		return null;
	}

	@Override
	public ArrayList find() {
		return this.spectacles;
	}
}
