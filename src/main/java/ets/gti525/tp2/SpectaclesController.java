package ets.gti525.tp2;

import java.util.ArrayList;
import java.util.Locale;




import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SpectaclesController {

	private SpectaclesFacade facade = new SpectaclesFacade();
	
	@RequestMapping(value = "/spectacles", method = RequestMethod.GET)
	public String index(Locale locale, Model model) {
		
		return "spectacles/index";
	}

	//Exemple : http://codetutr.com/2013/04/09/spring-mvc-easy-rest-based-json-services-with-responsebody/
	@RequestMapping(value = "/spectacles/{spectacle_id}", method = RequestMethod.GET)
	public String show(Locale locale, Model model) {
		
		return "spectacles/show";
	}
	
	/*
	 * � AJOUTER POUR RETOURNER DU JSON : 
	 * 
	 * http://mvnrepository.com/artifact/org.codehaus.jackson/jackson-core-asl/1.9.13
	 */
	@RequestMapping(value = "/chercherSpectacle", method = RequestMethod.GET) 
	public @ResponseBody ArrayList<Spectacle> test(@RequestParam String spectacle_nom) {			
		
		//String spectacle_nom = request.getParameter("spectacle_nom");
		
		//System.out.println(spectacle_nom);
		
		ArrayList<Spectacle> liste_tmp = this.facade.getSpectacleDAO().getSpectacleNom(spectacle_nom);

		/*for (int i = 0; i < this.facade.getSpectacleDAO().getListeSpectacles().size(); i++) {
			
			Spectacle s = this.facade.getSpectacleDAO().getListeSpectacles().get(i);
			
			if(spectacle_nom.toLowerCase().contains(s.getNom().toLowerCase())){
				liste_tmp.add(s);
			}
			
		}*/
		
		return liste_tmp;
	}
}
