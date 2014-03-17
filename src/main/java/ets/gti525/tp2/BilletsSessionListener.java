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
		// Si le panier existe
		if (panier != null)
		{
			// Si il y a quelque chose dans le panier
			if (panier.getLignesPanier().size() > 0)
			{
				// Pour chaque ligne du panier
				for (LignePanier l : panier.getLignesPanier())
				{
					l.libererBillets();
					panier.enleverLigne(l.getId());
				}
			}
		}
		
		System.out.println("Session #" + se.getSession().getId() + " a été supprimée et les billets ont été libérés.");
		
	}

}
