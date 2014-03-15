package ets.gti525.tp2;

import java.math.BigDecimal;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Handles requests for the application home page.
 */
@Controller
public class PanierController {

	/**
	 * Simply selects the panier view to render by returning its name.
	 */
	@RequestMapping(value = "/panier", method = RequestMethod.GET)
	public String panier(Model model, HttpSession session) {
		Panier panier = (Panier) session.getAttribute("panier");
		model.addAttribute("section", "Panier");
		model.addAttribute("panier", panier);
		return "panier/index";
	}
	
	@RequestMapping(value = "/panier", method = RequestMethod.POST)
	public synchronized String panierAdd(@RequestParam(value="quantite", required=true) int quantite, @RequestParam(value="spectacle_id", required=true) int spectacle_id, @RequestParam(value="representation_id", required=true) int representation_id, Model model, HttpSession session) {
		Panier panier = (Panier) session.getAttribute("panier");
		Representation representation = SpectaclesFacade.getInstance().getRepresentation(spectacle_id, representation_id);
		Spectacle spectacle = SpectaclesFacade.getInstance().getSpectacle(spectacle_id);
		
		LignePanier ligne = new LignePanier(representation.getId(), quantite, spectacle.getNom(), representation.getSalle().getAdresse(),
				representation.getPrix(), representation.getPrix().multiply(new BigDecimal(quantite)));
		
		panier.ajouterLigne(ligne);
		
		model.addAttribute("section", "Panier");
		return "redirect:/panier";
	}
	
	/**
	 * Remove the specified line
	 * @param representation_id
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/panier/lignePanier/{ligne_id}", method = RequestMethod.GET)
	public String panierRemove(@PathVariable int ligne_id, Model model, HttpSession session) {
		Panier panier = (Panier) session.getAttribute("panier");
		panier.enleverLigne(ligne_id);
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
