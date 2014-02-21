package ets.gti525.tp2;

import java.util.ArrayList;

public class Spectacle {
	
	private SpectacleBean spectacle;

	public Spectacle(int id,String nom,String description, ArrayList<String> artistes,String thumbnailPath, String bannerPath, ArrayList<Integer> representations ) {
		this.spectacle = new SpectacleBean();
		this.spectacle.setArtistes(artistes);
		this.spectacle.setDescription(description);
		this.spectacle.setId(id);
		this.spectacle.setThumbnailPath(thumbnailPath);
		this.spectacle.setBannerPath(bannerPath);
		this.spectacle.setNom(nom);
		this.spectacle.setRepresentations(representations);
	}

	public SpectacleBean getSpectacleBean() {
		return this.spectacle;
	}
}
