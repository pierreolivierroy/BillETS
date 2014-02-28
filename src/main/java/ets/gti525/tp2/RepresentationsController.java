package ets.gti525.tp2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class RepresentationsController {

	@RequestMapping(value = "/spectacles/{spectacle_id}/representations/{representation_id}", method = RequestMethod.GET)
	public String show(@PathVariable int spectacle_id, @PathVariable int representation_id, Model model) {
		
		Representation rep = SpectaclesFacade.getInstance().getRepresentation(spectacle_id, representation_id);
		Spectacle spectacle = SpectaclesFacade.getInstance().getSpectacle(spectacle_id);
		model.addAttribute("section", "Spectacles");
		model.addAttribute("representation", rep);
		model.addAttribute("spectacle", spectacle);
		
		return "representations/show";
	}
	
}
