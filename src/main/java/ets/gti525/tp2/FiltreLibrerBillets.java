package ets.gti525.tp2;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FiltreLibrerBillets
 */
public class FiltreLibrerBillets implements Filter {

    /**
     * Default constructor. 
     */
    public FiltreLibrerBillets() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		// On doit regarder si des billets sont présent dans le panier depuis plus de 20 minutes.

		HttpSession session = ((HttpServletRequest) request).getSession();
		Panier panier = (Panier) session.getAttribute("panier");
		
		// Si le panier existe
		if (panier != null)
		{
			// Si il y a quelque chose dans le panier
			if (panier.getLignesPanier().size() > 0)
			{
				// Pour chaque ligne du panier
				for (LignePanier l : panier.getLignesPanier())
				{
					// Vérifier la date d'ajout du billet dans cette ligne
					
				}
			}
		}
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
