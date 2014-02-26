package ets.gti525.tp2;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AccueilController {

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		Spectacle spectacleJumbotron = SpectaclesFacade.getInstance().getSpectacle(3);
		Spectacle prochainSpectacle1 = SpectaclesFacade.getInstance().getSpectacle(1);
		Spectacle prochainSpectacle2 = SpectaclesFacade.getInstance().getSpectacle(2);
		Spectacle prochainSpectacle3 = SpectaclesFacade.getInstance().getSpectacle(3);
		model.addAttribute("spectacleJumbotron", spectacleJumbotron);
		model.addAttribute("prochainSpectacle1", prochainSpectacle1);
		model.addAttribute("prochainSpectacle2", prochainSpectacle2);
		model.addAttribute("prochainSpectacle3", prochainSpectacle3);
		model.addAttribute("section", "Accueil");
		return "accueil";
	}

}