package ets.gti525.tp2;

import java.util.ArrayList;

import gti525.paiement.InformationsPaiementTO;
import gti525.paiement.ReponseSystemePaiementTO;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CheckoutController {
	
	//log4j logger
	private static final Logger logger = Logger.getLogger(CheckoutController.class);
	
	@RequestMapping(value = "/panier/paiement", method = RequestMethod.GET)
	public String paiement(Model model, HttpSession session) {
		Panier panier = (Panier) session.getAttribute("panier");
		//check if the shopping cart is empty
		if(panier.get_line_count() <= 0) {
			return "redirect:/panier";
		}

		model.addAttribute("section", "None");
		model.addAttribute("success", "None");
		return "panier/paiement";
	}
	
	@RequestMapping(value = "/panier/confirmation_achat", method = RequestMethod.POST)
	public String confirmation_achat(Model model, InformationsLivraisonBean info_livraison, InformationsPaiementTO info_paiement, HttpSession session) {
		
		Panier panier = (Panier) session.getAttribute("panier");
		ArrayList<LignePanier> lignes_panier = panier.getLignesPanier();
		Facture facture = new Facture(info_livraison, info_paiement, (ArrayList<LignePanier>) lignes_panier.clone(), panier.getSous_total(), panier.getTps(), panier.getTvq(), panier.getTotal());
		System.out.println(facture.getInfo_livraison().getNom());
		
		logger.info("CONFIRMATION ACHAT ***************************************************");
		for(LignePanier ligne : lignes_panier) {
			StringBuffer log = new StringBuffer();
			log.append("Billet vendu : ");
			log.append(ligne.getTitre());
			log.append(" X ");
			log.append(ligne.getQuantite());
			log.append(" X ");
			log.append(ligne.getPrixUnitaire());
			log.append(" = ");
			log.append(ligne.getPrix());
			logger.info(log.toString());
			ligne.vendre_billets();
		}
		panier.vider_panier();
		logger.info("**********************************************************************");
				
		model.addAttribute("section", "None");
		model.addAttribute("facture", facture);
		return "panier/confirmation_achat";
	}
	
	@RequestMapping(value = "/panier/pre_autorisation", method = RequestMethod.POST)
	public String pre_authorise_paiement(Model model, @RequestParam MultiValueMap<String, Object> parameters, HttpSession session) {
		Panier panier = (Panier) session.getAttribute("panier");
		PreAutorisationPaiement pre_autorisation = new PreAutorisationPaiement();
		InformationsPaiementTO info_paiement = new InformationsPaiementTO();
		InformationsLivraisonBean info_livraison = new InformationsLivraisonBean();
		
		//some validation should be done here!
		//

		//set the credit information
		info_paiement.setAmount(panier.getTotal());
		info_paiement.setApi_key("billets");
		info_paiement.setCard_number(Long.valueOf((String) parameters.getFirst("card_number")));
		info_paiement.setFirst_name( (String) parameters.getFirst("card_firstname"));
		info_paiement.setLast_name((String) parameters.getFirst("card_lastname"));
		info_paiement.setMonth(Integer.parseInt((String) parameters.getFirst("expiry_month")));
		info_paiement.setYear(Integer.parseInt((String) parameters.getFirst("expiry_year")));
		info_paiement.setSecurity_code(Integer.parseInt((String) parameters.getFirst("card_cvv")));
		
		//set the shipping info
		info_livraison.setAdresse((String) parameters.getFirst("address"));
		info_livraison.setCode_postal((String) parameters.getFirst("zip"));
		info_livraison.setNom((String) parameters.getFirst("customer_name"));
		info_livraison.setProvince((String) parameters.getFirst("state"));
		info_livraison.setVille((String) parameters.getFirst("city"));
				
		//check pre-autorisation
		ReponseSystemePaiementTO reponse = pre_autorisation.effectuerPreauthorisation(info_paiement);
			
		/**
		 * if code equal 0, the pre-authorisation failled, 
		 * the user is redirected to the payment input form
		 * to make some changes
		 */
		if(reponse.getCode() == 0) {
			//add attribute error "échec de préauthorisation du paiement"
			logger.info("ÉCHEC DE PRÉAUTORISATION DU PAIEMENT.");
			
			model.addAttribute("section", "None");
			model.addAttribute("success", "fail");
			model.addAttribute("info_paiement", info_paiement);
			model.addAttribute("info_livraison", info_livraison);
			return "panier/paiement";
		}
		/**
		 * if code doesn't equal 0, the pre-authorisation succeed,
		 * the bill is generated,
		 * the tickets ar marked as "sold" and shopping cart is emptied
		 * the user is presented a confirmation window
		 */
		else {
			
			model.addAttribute("section", "None");
			model.addAttribute("success", "success");
			model.addAttribute("info_livraison", info_livraison);
			model.addAttribute("info_paiement", info_paiement);
			return "panier/validation";
		}
			
	}

}
