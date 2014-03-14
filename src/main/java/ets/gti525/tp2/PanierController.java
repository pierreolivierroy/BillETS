package ets.gti525.tp2;

import java.math.BigDecimal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Handles requests for the application home page.
 */
@Controller
public class PanierController {
	
	private Panier panier = new Panier();
	private final BigDecimal TPS = new BigDecimal(0.05);
	private final BigDecimal TVQ = new BigDecimal(0.09975);

	public PanierController() {
		super();
		//this is a test line remove it
		LignePanier une_ligne = new LignePanier(1, 2, "Un titre", "Le vendredi 31 janvier 2013 à 21h Salle Wilfrid-Pelletier - Place des Arts",
				new BigDecimal(19.99).setScale(2, BigDecimal.ROUND_HALF_UP), new BigDecimal(39.98).setScale(2, BigDecimal.ROUND_HALF_UP));
		ajouterLigne(une_ligne);
	}
	
	private void ajouterLigne(LignePanier ligne) {
		BigDecimal prix_ligne = ligne.getPrix();
		BigDecimal sous_total = panier.getSous_total().add(prix_ligne);
		BigDecimal tps = sous_total.multiply(TPS);
		BigDecimal tvq = sous_total.multiply(TVQ);
		
		panier.getLignesPanier().add(ligne);
		panier.setSous_total(sous_total.setScale(2, BigDecimal.ROUND_HALF_UP));
		panier.setTps(tps.setScale(2, BigDecimal.ROUND_HALF_UP));
		panier.setTvq(tvq.setScale(2, BigDecimal.ROUND_HALF_UP));
		panier.setTotal(sous_total.add(tps.add(tvq)).setScale(2, BigDecimal.ROUND_HALF_UP));
	}
	
	//private void enleverLigne()...

	/**
	 * Simply selects the panier view to render by returning its name.
	 */
	@RequestMapping(value = "/panier", method = RequestMethod.GET)
	public String panier(Model model) {		
		model.addAttribute("section", "Panier");
		model.addAttribute("panier", panier);
		return "panier/index";
	}
	
	@RequestMapping(value = "/panier", method = RequestMethod.POST)
	public String panierAdd(Model model) {	
		model.addAttribute("section", "Panier");
		return "panier/index";
	}
	
	@RequestMapping(value = "/panier/paiement")
	public String paiement(Model model) {
		model.addAttribute("section", "None");
		return "panier/paiement";
	}
	
	@RequestMapping(value = "/panier/confirmation_achat")
	public String confirmation_achat(Model model) {
		model.addAttribute("section", "None");
		return "panier/confirmation_achat";
	}
	
}
