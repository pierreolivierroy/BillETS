package ets.gti525.tp2;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		else {
			logger.info("CONFIRMATION ACHAT **********************************");
			for(LignePanier ligne : panier.getLignesPanier()) {
				StringBuffer print = new StringBuffer();
				print.append(ligne.getTitre());
				print.append(" X ");
				print.append(ligne.getQuantite());
				print.append(" X ");
				print.append(ligne.getPrixUnitaire());
				print.append(" = ");
				print.append(ligne.getPrix());
				logger.info(print.toString());
			}
			logger.info("*****************************************************");
		}

		model.addAttribute("section", "None");
		return "panier/paiement";
	}
	
	@RequestMapping(value = "/panier/confirmation_achat", method = RequestMethod.POST)
	public String confirmation_achat(Model model) {
		model.addAttribute("section", "None");
		return "panier/confirmation_achat";
	}

}
