package ets.gti525.tp2;

import java.util.HashMap;
import java.util.Locale;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SpectaclesController {
	
	@RequestMapping(value = "/spectacles", method = RequestMethod.GET)
	public String index(Locale locale, Model model) {
		
		HashMap<Integer, Spectacle> spectacles = SpectaclesFacade.getInstance().getSpectacles();
		model.addAttribute("spectacles", spectacles);
		model.addAttribute("section", "Spectacles");
		
		
		return "spectacles/index";
	}

	//Exemple : http://codetutr.com/2013/04/09/spring-mvc-easy-rest-based-json-services-with-responsebody/
	@RequestMapping(value = "/spectacles/{spectacle_id}", method = RequestMethod.GET)
	public String show(@PathVariable String spectacle_id, Model model) {

		try {
			Spectacle spectacle = SpectaclesFacade.getInstance().getSpectacle(Integer.parseInt(spectacle_id));
			model.addAttribute("spectacle", spectacle);
			model.addAttribute("section", "None");
		}
		catch (Exception e) {
			// Spectacle inexistant.
		}

		return "spectacles/show";
	}
	
	/*
	 * À AJOUTER POUR RETOURNER DU JSON : 
	 * 
	 * http://mvnrepository.com/artifact/org.codehaus.jackson/jackson-core-asl/1.9.13
	 */
	@RequestMapping(value = "/chercherSpectacle", method = RequestMethod.GET) 
	public @ResponseBody HashMap<Integer, Spectacle> rechercher(@RequestParam String spectacle_nom) {			
		
		HashMap<Integer, Spectacle> spectacles = SpectaclesFacade.getInstance().getSpectacleNom(spectacle_nom);
		
		return spectacles;
	}
}
