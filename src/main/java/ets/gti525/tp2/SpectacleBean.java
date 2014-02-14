package ets.gti525.tp2;

import java.io.Serializable;
import java.util.ArrayList;

public class SpectacleBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String nom;
	private ArrayList<String> artistes;
	private ArrayList<Integer> representations;
	private String description;
	private String imagePath;
	
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
	public ArrayList<String> getArtistes() {
		return artistes;
	}
	public void setArtistes(ArrayList<String> artistes) {
		this.artistes = artistes;
	}
	public ArrayList<Integer> getRepresentations() {
		return representations;
	}
	public void setRepresentations(ArrayList<Integer> representations) {
		this.representations = representations;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	
}
