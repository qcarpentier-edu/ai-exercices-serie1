package be.condorcet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DataReceiver")
public class DataReceiver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DataReceiver() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupération des données envoyées via le formulaire
        String lastname = request.getParameter("lastname");
        String firstname = request.getParameter("firstname");
        String description = request.getParameter("description");
        
        // Génération de la réponse HTML
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Données reçues :</h1>");
        response.getWriter().println("<p><strong>Nom :</strong> " + lastname + "</p>");
        response.getWriter().println("<p><strong>Prénom :</strong> " + firstname + "</p>");
        response.getWriter().println("<p><strong>Description :</strong> " + description + "</p>");
        response.getWriter().println("</body></html>");
    }
}
