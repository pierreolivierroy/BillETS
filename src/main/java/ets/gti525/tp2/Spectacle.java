package ets.gti525.tp2;

import java.util.ArrayList;

public class Spectacle {
	
	private SpectacleBean spectacle;

	public Spectacle(int id,String nom,String description, ArrayList<String> artistes, ArrayList<String> artiste,String imagePath, ArrayList<Integer> representations ) {
		spectacle = new SpectacleBean();
		spectacle.setArtistes(artiste);
		spectacle.setDescription(description);
		spectacle.setId(id);
		spectacle.setImagePath(imagePath);
		spectacle.setNom(nom);
		spectacle.setRepresentations(representations);
	}

	public SpectacleBean getSpectacle() {
		return spectacle;
	}
	
	
	
}
