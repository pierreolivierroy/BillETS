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
public class SpectaclesController {

	@RequestMapping(value = "/spectacles", method = RequestMethod.GET)
	public String index(Locale locale, Model model) {
		
		return "spectacles/index";
	}

	@RequestMapping(value = "/spectacles/{spectacle_id}", method = RequestMethod.GET)
	public String show(Locale locale, Model model) {
		
		return "spectacles/show";
	}
	
}
