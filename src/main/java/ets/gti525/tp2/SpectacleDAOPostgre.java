package ets.gti525.tp2;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;

public class SpectacleDAOPostgre implements ISpectacleDAO {

	private HashMap<Integer, Spectacle> listeSpectacles = new HashMap<Integer, Spectacle>();
	private HashMap<Integer, Salle> listeSalles = new HashMap<Integer, Salle>();
	private HashMap<Integer, Representation> listeRepresentations = new HashMap<Integer, Representation>();
	private Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	
	public SpectacleDAOPostgre() {
		fillListeSalles();
		fillListeSpectacles();
		fillListeRepresentations();
		fillListeBillets();
			
	}
	
	private void fillListeSalles()
	{
		session.beginTransaction();
        List result = session.createQuery("from Salle").list();
//        session.getTransaction().commit();
        for (int i = 0; i < result.size(); i++) {
            Salle salle = (Salle) result.get(i);
            this.listeSalles.put(salle.getId(), salle);
        }
	}
	
	private void fillListeBillets()
	{
//		session.beginTransaction();
        List result = session.createQuery("from Billet").list();
        session.getTransaction().commit();
        for (int i = 0; i < result.size(); i++) {
            Billet billet = (Billet) result.get(i);
            this.listeSpectacles.get(billet.getId_spectacle()).getRepresentations().get(billet.getId_representation()).ajouterBillet(billet);
        }
	}
	
	private void fillListeRepresentations()
	{
//		session.beginTransaction();
        List result = session.createQuery("from Representation").list();
//        session.getTransaction().commit();
        for (int i = 0; i < result.size(); i++) {
            Representation representation = (Representation) result.get(i);
            representation.setSalle(listeSalles.get(representation.getIdSalle()));
            this.listeSpectacles.get(representation.getIdSpectacle()).ajouterRepresentation(representation.getId(), representation);
            this.listeRepresentations.put(representation.getId(), representation);
        }
	}
	
	private void fillListeSpectacles()
	{
//		session.beginTransaction();
        List result = session.createQuery("from Spectacle").list();
//        session.getTransaction().commit();
        for (int i = 0; i < result.size(); i++) {
        	Spectacle spectacle = (Spectacle) result.get(i);
            this.listeSpectacles.put(spectacle.getId(), spectacle);
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
