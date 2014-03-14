package ets.gti525.tp2;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


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
	public String panierAdd(@RequestParam(value="quantite", required=true) int quantite, @RequestParam(value="spectacle_id", required=true) int spectacle_id, @RequestParam(value="representation_id", required=true) int representation_id, Model model) {

		Representation representation = SpectaclesFacade.getInstance().getRepresentation(spectacle_id, representation_id);
		Spectacle spectacle = SpectaclesFacade.getInstance().getSpectacle(spectacle_id);
		
		LignePanier ligne = new LignePanier(representation.getId(), quantite, spectacle.getNom(), representation.getSalle().getAdresse(),
				representation.getPrix(), representation.getPrix().multiply(new BigDecimal(quantite)));
		
		panier.ajouterLigne(ligne);
		
		model.addAttribute("section", "Panier");
		return "redirect:/panier";
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
