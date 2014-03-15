package ets.gti525.tp2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CheckoutController {
	
	@RequestMapping(value = "/panier/paiement", method = RequestMethod.GET)
	public String paiement(Model model) {
		model.addAttribute("section", "None");
		return "panier/paiement";
	}
	
	@RequestMapping(value = "/panier/confirmation_achat", method = RequestMethod.POST)
	public String confirmation_achat(Model model) {
		model.addAttribute("section", "None");
		return "panier/confirmation_achat";
	}

}
