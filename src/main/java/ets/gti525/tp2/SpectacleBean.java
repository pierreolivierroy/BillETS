package ets.gti525.tp2;

import java.io.Serializable;
import java.util.ArrayList;

public class SpectacleBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String nom;
	private String artistes;
	private int[] representations;
	private String description;
	private String thumbnailPath;
	private String bannerPath;
	
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
	public int[] getRepresentations() {
		return representations;
	}
	public void setRepresentations(int[] representations) {
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
