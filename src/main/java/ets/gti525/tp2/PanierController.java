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

	public PanierController() {
		super();
		//this is a test line remove it
		LignePanier une_ligne = new LignePanier(1, 2, "Un titre", "Le vendredi 31 janvier 2013 à 21h Salle Wilfrid-Pelletier - Place des Arts",
				new BigDecimal(19.99).setScale(2, BigDecimal.ROUND_HALF_UP), new BigDecimal(39.98).setScale(2, BigDecimal.ROUND_HALF_UP));
		panier.ajouterLigne(une_ligne);
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
