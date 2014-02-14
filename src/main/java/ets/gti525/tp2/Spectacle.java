package ets.gti525.tp2;

import java.util.ArrayList;

public class Spectacle {
	
	private int id;
	private String nom;
	private ArrayList<String> artistes;
	private ArrayList<Representation> representations;
	private String description;
	private String imagePath;
	
	public ArrayList<Representation> getRepresentations() {
		return representations;
	}
	public void setRepresentations(ArrayList<Representation> representations) {
		this.representations = representations;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<String> getArtistes() {
		return artistes;
	}
	public void setArtistes(ArrayList<String> artistes) {
		this.artistes = artistes;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImagePath() {
		return this.imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
}
