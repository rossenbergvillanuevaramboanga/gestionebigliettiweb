package it.prova.gestionebigliettiweb.web.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionebigliettiweb.model.Utente;




@WebFilter(filterName = "CheckAuthFilter", urlPatterns = { "/*" })
public class CheckAuthFilter implements Filter {
	
	private static final String HOME_PATH = "";
	private static final String[] EXCLUDED_URLS = {"/login.jsp","/LoginServlet","/LogoutServlet","/css/","/js/","/index.jsp"};
	private static final String[] PROTECTED_URLS = {"/admin/"};

    public CheckAuthFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("Nel filtro di check user in session");

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		//prendo il path della request che sta passando in questo momento es. /LoginServlet
		String pathAttuale = httpRequest.getServletPath();
		System.out.println("Invocazione di: " + pathAttuale);
		
		//vediamo se il path risulta tra quelli 'liberi di passare'
		boolean isInWhiteList = isPathInWhiteList(pathAttuale);
		
		//se non lo e' bisogna controllare sia sessione che percorsi protetti
		if (!isInWhiteList) {
			Utente utenteInSession = (Utente)httpRequest.getSession().getAttribute("userInfo");
			//intanto verifico se utente in sessione
			if (utenteInSession == null) {
				//httpResponse.sendRedirect(httpRequest.getContextPath());
				httpRequest.getRequestDispatcher("/login.jsp").forward(httpRequest, httpResponse);
				return;
			}
			//controllo che utente abbia ruolo admin se nel path risulta presente /admin/
			if(isPathForOnlyAdministrators(pathAttuale) && !utenteInSession.isAdmin()) {
				httpRequest.setAttribute("errorMessage", "Non si è autorizzati alla navigazione richiesta");
				httpRequest.getRequestDispatcher("/index.jsp").forward(httpRequest, httpResponse);
				return;
			}
		}

		chain.doFilter(request, response);
	}
	
	private boolean isPathInWhiteList(String requestPath) {
		//bisogna controllare che se il path risulta proprio "" oppure se 
		//siamo in presenza un url 'libero'
		if(requestPath.equals(HOME_PATH))
			return true;
		
		for (String urlPatternItem : EXCLUDED_URLS) {
			if (requestPath.contains(urlPatternItem)) {
				System.out.println("url invocabile liberamente");
				return true;
			}
		}
		return false;
	}
	
	private boolean isPathForOnlyAdministrators(String requestPath) {
		for (String urlPatternItem : PROTECTED_URLS) {
			if (requestPath.contains(urlPatternItem)) {
				System.out.println("url invocabile solo se sei Admin");
				return true;
			}
		}
		return false;
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
