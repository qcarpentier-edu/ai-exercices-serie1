package be.condorcet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ResponseHandler")
public class ResponseHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ResponseHandler() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupération des paramètres envoyés par le formulaire
        String username = request.getParameter("username");
        String responseType = request.getParameter("responseType");

        // Définition du type de contenu de la réponse
        response.setContentType("text/html");

        // Début de la génération de la réponse HTML
        response.getWriter().println("<html><body>");
        
        // Génération du message en fonction du type de réponse choisi
        if ("welcome".equals(responseType)) {
            response.getWriter().println("<h1>Bienvenue, " + username + " !</h1>");
            response.getWriter().println("<p>Nous sommes ravis de vous voir.</p>");
        } else if ("encouragement".equals(responseType)) {
            response.getWriter().println("<h1>Continuez comme ça, " + username + " !</h1>");
            response.getWriter().println("<p>Vous êtes sur la bonne voie !</p>");
        } else if ("thanks".equals(responseType)) {
            response.getWriter().println("<h1>Merci, " + username + " !</h1>");
            response.getWriter().println("<p>Merci d'avoir utilisé notre service.</p>");
        }

        // Fin de la génération de la réponse HTML
        response.getWriter().println("</body></html>");
	}

}
