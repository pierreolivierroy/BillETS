package ets.gti525.tp2;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class BilletsSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {

		// Créer un panier vide lors de la création d'une session
		se.getSession().setAttribute("panier", new Panier());
		System.out.println("Nouvelle session créée: # " + se.getSession().getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		
		// Libérer les billets après la destruction de la session.
		Panier panier = (Panier)se.getSession().getAttribute("panier");
		
		// Libérer les items
		//panier.
		
		System.out.println("Session #" + se.getSession().getId() + " a été supprimée et les billets ont été libérés.");
		
	}

}
