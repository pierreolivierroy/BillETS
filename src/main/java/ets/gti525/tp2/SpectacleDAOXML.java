package ets.gti525.tp2;

import java.io.File;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SpectacleDAOXML implements ISpectacleDAO {
	
	private HashMap<Integer, Spectacle> listeSpectacles = new HashMap<Integer, Spectacle>();
	private HashMap<Integer, Salle> listeSalles = new HashMap<Integer, Salle>();
	private HashMap<Integer, Representation> listeRepresentations = new HashMap<Integer, Representation>();
	private static final String XML_SALLES_PATH = "salles.xml";
	private static final String XML_REPRESENTATIONS_PATH = "representations.xml";
	private static final String XML_SPECTACLES_PATH = "spectacles.xml";
	private static final String XML_BILLETS_PATH = "billets.xml";
	
	public SpectacleDAOXML() {
		
		/** src/main/resources/
		 * Source : http://www.mkyong.com/java/how-to-read-xml-file-in-java-dom-parser/
		 */	 		
		Document docSalles = buildXMLFile(XML_SALLES_PATH);
		Document docRepresentations = buildXMLFile(XML_REPRESENTATIONS_PATH);
		Document docSpectacles = buildXMLFile(XML_SPECTACLES_PATH);
		Document docBillets = buildXMLFile(XML_BILLETS_PATH);
		
		createSalles(docSalles);
		createRepresentations(docRepresentations); 
		createSpectacles(docSpectacles); 
		createBillets(docBillets);
	}
	
	private Document buildXMLFile(String path) {
		
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
	
	private void createSalles(Document doc) {
		
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
	
	private void createRepresentations(Document doc) {
			
		doc.getDocumentElement().normalize();
		NodeList nList = doc.getElementsByTagName("representation");
		
		for (int i = 0; i < nList.getLength(); i++) {
	 
			Node nNode = nList.item(i);
	 
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	 
				Element eElement = (Element) nNode;  
				
				Representation representation = new Representation(
						Integer.parseInt(eElement.getAttribute("id")), 
						Integer.parseInt(eElement.getElementsByTagName("spectacle").item(0).getTextContent()),
						this.listeSalles.get(Integer.parseInt(eElement.getElementsByTagName("salle").item(0).getTextContent())),
						eElement.getElementsByTagName("date").item(0).getTextContent(),
						new BigDecimal(eElement.getElementsByTagName("prix").item(0).getTextContent()));
				
				this.listeRepresentations.put(representation.getId(), representation);
			}
		}
	}

	private void createSpectacles(Document doc) {
		
		doc.getDocumentElement().normalize();
		NodeList nList = doc.getElementsByTagName("spectacle"); 
		
		for (int i = 0; i < nList.getLength(); i++) {
	 
			Node nNode = nList.item(i);
	 	 
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	 
				Element eElement = (Element) nNode;
				
				HashMap<Integer, Representation> liste = new HashMap<Integer, Representation>();				
				for(Entry<Integer, Representation> entry : this.listeRepresentations.entrySet()) {					
					if(entry.getValue().getIdSpectacle() == Integer.parseInt(eElement.getAttribute("id")))
						liste.put(entry.getKey(), entry.getValue());
				}
				
				Spectacle spectacle = new Spectacle(
						Integer.parseInt(eElement.getAttribute("id")), 
						eElement.getElementsByTagName("nom").item(0).getTextContent(),
						eElement.getElementsByTagName("artistes").item(0).getTextContent(),
						liste,
						eElement.getElementsByTagName("description").item(0).getTextContent(),
						eElement.getElementsByTagName("thumbnailPath").item(0).getTextContent(),
						eElement.getElementsByTagName("bannerPath").item(0).getTextContent());
				
				this.listeSpectacles.put(spectacle.getId(), spectacle);		 
			}
		}
	}
	
	private void createBillets(Document doc) {
		
		doc.getDocumentElement().normalize();
		NodeList nList = doc.getElementsByTagName("billet"); 
		
		for (int i = 0; i < nList.getLength(); i++) {
	 
			Node nNode = nList.item(i);  
	 	 
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	 
				Element eElement = (Element) nNode; 
				
				for (int j = 0; j < 10; j++) {
					
					StringBuffer _id = new StringBuffer(); 					
					_id.append(j + 1);
					_id.append(eElement.getElementsByTagName("id_spectacle").item(0).getTextContent());
					_id.append(eElement.getElementsByTagName("id_representation").item(0).getTextContent());
					int id = Integer.parseInt(_id.toString());
					int id_spectacle = Integer.parseInt(eElement.getElementsByTagName("id_spectacle").item(0).getTextContent());
					int id_representation = Integer.parseInt(eElement.getElementsByTagName("id_representation").item(0).getTextContent());
					
					Billet billet = new Billet(
							id,
							id_spectacle,
							id_representation,
							false);
					System.out.println(billet.getId());
					this.listeSpectacles.get(id_spectacle).getRepresentations().get(id_representation).ajouterBillet(billet);
				}
				
				
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
	
	public Spectacle getSpectacle(int id) {
		return this.listeSpectacles.get(id);
	}
	
	public HashMap<Integer, Representation> getRepresentations(int idSpectacle) {
		return this.listeSpectacles.get(idSpectacle).getRepresentations();
	}
	
	public Representation getRepresentation(int idSpectacle, int idRepresentation) {
		return this.listeSpectacles.get(idSpectacle).getRepresentations().get(idRepresentation);
	}

}
