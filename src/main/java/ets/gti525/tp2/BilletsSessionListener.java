package ets.gti525.tp2;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

public class BilletsSessionListener implements HttpSessionListener {
	
	private static final Logger logger = Logger.getLogger(BilletsSessionListener.class);

	@Override
	public void sessionCreated(HttpSessionEvent se) {

		StringBuffer log = new StringBuffer();
		
		// Créer un panier vide lors de la création d'une session
		se.getSession().setAttribute("panier", new Panier());
		
		log.append("Nouvelle session créée : # ");
		log.append(se.getSession().getId());
		logger.info(log.toString());
		
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
		
		StringBuffer log = new StringBuffer();
		
		log.append("Session #");
		log.append(se.getSession().getId());
		log.append(" a été supprimée et les billets ont été libérés.");
		logger.info(log.toString());		
	}

}
