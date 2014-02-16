package ets.gti525.tp2;

import java.util.ArrayList;

public class Spectacle {
	
	private SpectacleBean spectacle;

	public Spectacle(int id,String nom,String description, ArrayList<String> artistes,String imagePath, ArrayList<Integer> representations ) {
		this.spectacle = new SpectacleBean();
		this.spectacle.setArtistes(artistes);
		this.spectacle.setDescription(description);
		this.spectacle.setId(id);
		this.spectacle.setImagePath(imagePath);
		this.spectacle.setNom(nom);
		this.spectacle.setRepresentations(representations);
	}

	public SpectacleBean getSpectacleBean() {
		return this.spectacle;
	}
}
