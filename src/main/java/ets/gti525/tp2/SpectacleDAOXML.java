package ets.gti525.tp2;

import java.io.File;
import java.math.BigDecimal;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SpectacleDAOXML {
	
	private HashMap<Integer, Spectacle> listeSpectacles = new HashMap<Integer, Spectacle>();
	private HashMap<Integer, Salle> listeSalles = new HashMap<Integer, Salle>();
	private HashMap<Integer, Representation> listeRepresentations = new HashMap<Integer, Representation>();
	private static final String XML_SALLES_PATH = "salles.xml";
	private static final String XML_REPRESENTATIONS_PATH = "representations.xml";
	private static final String XML_SPECTACLES_PATH = "spectacles.xml";
	
	public SpectacleDAOXML() {
		
		/** src/main/resources/
		 * Source : http://www.mkyong.com/java/how-to-read-xml-file-in-java-dom-parser/
		 */	 		
		Document docSalles = buildXMLFile(XML_SALLES_PATH);
		Document docRepresentations = buildXMLFile(XML_REPRESENTATIONS_PATH);
		Document docSpectacles = buildXMLFile(XML_SPECTACLES_PATH);
		
		createSalles(docSalles);
		createRepresentations(docRepresentations); 
		createSpectacles(docSpectacles); 
	}
	
	public Document buildXMLFile(String path) {
		
		Document doc = null;   
		
		try {
			File fXmlFile = new File(this.getClass().getClassLoader().getResource(path).toURI());
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(fXmlFile);
		} 
		catch (Exception e) {
			e.printStackTrace();
	    }
		return doc;		
	}
	
	public void createSalles(Document doc) {
		
		doc.getDocumentElement().normalize();
		NodeList nList = doc.getElementsByTagName("salle"); 
		
		for (int i = 0; i < nList.getLength(); i++) {
	 
			Node nNode = nList.item(i);  
	 	 
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	 
				Element eElement = (Element) nNode; 
				 
				Salle salle = new Salle(
						Integer.parseInt(eElement.getAttribute("id")), 
						eElement.getElementsByTagName("nom").item(0).getTextContent(),
						eElement.getElementsByTagName("adresse").item(0).getTextContent());

				this.listeSalles.put(salle.getId(), salle);
			}
		}
	}
	
	public void createRepresentations(Document doc) {
			
		doc.getDocumentElement().normalize();
		NodeList nList = doc.getElementsByTagName("representation");
		
		for (int i = 0; i < nList.getLength(); i++) {
	 
			Node nNode = nList.item(i);
	 
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	 
				Element eElement = (Element) nNode;  
				
				Representation representation = new Representation(
						Integer.parseInt(eElement.getAttribute("id")), 
						this.listeSalles.get(Integer.parseInt(eElement.getElementsByTagName("salle").item(0).getTextContent())),
						eElement.getElementsByTagName("date").item(0).getTextContent(),
						Integer.parseInt(eElement.getElementsByTagName("billets").item(0).getTextContent()),
						new BigDecimal(eElement.getElementsByTagName("prix").item(0).getTextContent()));
				
				this.listeRepresentations.put(representation.getId(), representation);
			}
		}
	}

	public void createSpectacles(Document doc) {
		
		doc.getDocumentElement().normalize();
		NodeList nList = doc.getElementsByTagName("spectacle"); 
		
		for (int i = 0; i < nList.getLength(); i++) {
	 
			Node nNode = nList.item(i);
	 	 
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	 
				Element eElement = (Element) nNode;
				
				Spectacle spectacle = new Spectacle(
						Integer.parseInt(eElement.getAttribute("id")), 
						eElement.getElementsByTagName("nom").item(0).getTextContent(),
						eElement.getElementsByTagName("artistes").item(0).getTextContent(),
						//this.listeRepresentations.get(Integer.parseInt(eElement.getElementsByTagName("representations").item(0).getTextContent())),
						this.listeRepresentations,
						eElement.getElementsByTagName("description").item(0).getTextContent(),
						eElement.getElementsByTagName("thumbnailPath").item(0).getTextContent(),
						eElement.getElementsByTagName("bannerPath").item(0).getTextContent());
				
				this.listeSpectacles.put(spectacle.getId(), spectacle);		 
			}
		}
	}
	
	public HashMap<Integer, Spectacle> getSpectacles(){
		return this.listeSpectacles; 
	}
	
	public HashMap<Integer, Spectacle> getSpectacles(String nomSpectacle){
		
		HashMap<Integer, Spectacle> liste = new HashMap<Integer, Spectacle>();
		
		for (int i = 1; i <= this.listeSpectacles.size(); i++) {
			
			Spectacle s = this.listeSpectacles.get(i);
			
			if(s.getNom().toLowerCase().contains(nomSpectacle.toLowerCase())){
				liste.put(s.getId(), s);
			}
		}
		
		/**
		 * Si on trouve aucun spectacle pour ce nom, on retourne la liste complète
		 */
		if(liste.size() > 0) {
			return liste;
		}
		else {
			return this.listeSpectacles;
		}
		
	}
	
	public Spectacle getSpectacle(int id){
		return this.listeSpectacles.get(id);
	}
	
	public HashMap<Integer, Representation> getRepresentations(int idSpectacle){
		return this.listeSpectacles.get(idSpectacle).getRepresentations();
	}
	
	public Representation getRepresentation(int idSpectacle, int idRepresentation){
		return this.listeSpectacles.get(idSpectacle).getRepresentations().get(idRepresentation);
	}

}
