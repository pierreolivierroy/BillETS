package ets.gti525.tp2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {
	 
	@RequestMapping(value="/errors/404.html")
	public String handle404() {
		return "error_pages/general";
	}
	
	@RequestMapping(value="/errors/500.html")
	public String handle500() {
		return "error_pages/general";
	}

}
