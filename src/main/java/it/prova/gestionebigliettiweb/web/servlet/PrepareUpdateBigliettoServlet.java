package it.prova.gestionebigliettiweb.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionebigliettiweb.service.MyServiceFactory;


@WebServlet("/admin/PrepareUpdateBigliettoServlet")
public class PrepareUpdateBigliettoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idBigliettoDaModificare = request.getParameter("idBigliettoUpdate");
		
		try {
			request.setAttribute("bigliettoDaInviareAdUpdate", 
					MyServiceFactory.getBigliettoServiceInstance()
					.caricaSingoloElemento(Long.parseLong(idBigliettoDaModificare)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/biglietto/update.jsp").forward(request, response);
		
	}

}
