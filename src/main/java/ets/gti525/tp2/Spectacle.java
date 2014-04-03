package ets.gti525.tp2;

import java.util.HashMap;

public class Spectacle {
	
	private int id;
	private String nom;
	private String artistes;
	private HashMap<Integer, Representation> representations = new HashMap<Integer, Representation>();
	private String description;
	private String thumbnailPath;
	private String bannerPath;
	
	public Spectacle(int id, String nom, String artistes,
			HashMap<Integer, Representation> representations, String description, String thumbnailPath,
			String bannerPath) {
		super();
		this.id = id;
		this.nom = nom;
		this.artistes = artistes;
		this.representations = representations;
		this.description = description;
		this.thumbnailPath = thumbnailPath;
		this.bannerPath = bannerPath;
	}
	
	public Spectacle(){}
	
	public void ajouterRepresentation(int idRepresentation, Representation representation){
		this.representations.put(idRepresentation, representation);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getArtistes() {
		return artistes;
	}

	public void setArtistes(String artistes) {
		this.artistes = artistes;
	}

	public HashMap<Integer, Representation> getRepresentations() {
		return representations;
	}

	public void setRepresentations(HashMap<Integer, Representation> representations) {
		this.representations = representations;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getThumbnailPath() {
		return thumbnailPath;
	}

	public void setThumbnailPath(String thumbnailPath) {
		this.thumbnailPath = thumbnailPath;
	}

	public String getBannerPath() {
		return bannerPath;
	}

	public void setBannerPath(String bannerPath) {
		this.bannerPath = bannerPath;
	}
	
}
