package ets.gti525.tp2;

import java.io.File;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


public class SpectacleDAOPosgresql implements ISpectacleDAO{
	private HashMap<Integer, Spectacle> listeSpectacles = new HashMap<Integer, Spectacle>();
	private HashMap<Integer, Salle> listeSalles = new HashMap<Integer, Salle>();
	private HashMap<Integer, Representation> listeRepresentations = new HashMap<Integer, Representation>();
	private Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	
	public SpectacleDAOPosgresql() {
		fillListeSalles();
			
	}
	
	private void fillListeSalles()
	{
		session.beginTransaction();
        List result = session.createQuery("from Salle").list();
        session.getTransaction().commit();
        for (int i = 0; i < result.size(); i++) {
            Salle salle = (Salle) result.get(i);
            this.listeSalles.put(salle.getId(), salle);
        }
	}
	
	private void fillListeBillets()
	{
		session.beginTransaction();
        List result = session.createQuery("from Billet").list();
        session.getTransaction().commit();
        for (int i = 0; i < result.size(); i++) {
            Billet billet = (Billet) result.get(i);
            this.listeSpectacles.get(billet.getId_spectacle()).getRepresentations().get(billet.getId_representation()).ajouterBillet(billet);
        }
	}
	
	private void fillListeRepresentations()
	{
		session.beginTransaction();
        List result = session.createQuery("from Representation").list();
        session.getTransaction().commit();
        for (int i = 0; i < result.size(); i++) {
            Representation representation = (Representation) result.get(i);
           
            this.listeRepresentations.put(representation.getId(), representation);
        }
	}
	
	private void fillListeSpectacles()
	{
		session.beginTransaction();
        List result = session.createQuery("from Spectacle").list();
        session.getTransaction().commit();
        for (int i = 0; i < result.size(); i++) {
        	Spectacle spectacle = (Spectacle) result.get(i);
            this.listeSpectacles.put(spectacle.getId(), spectacle);
        }
	}


	@Override
	public HashMap<Integer, Spectacle> getSpectacles(String nomSpectacle) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Spectacle getSpectacle(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public HashMap<Integer, Representation> getRepresentations(int idSpectacle) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Representation getRepresentation(int idSpectacle,
			int idRepresentation) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
