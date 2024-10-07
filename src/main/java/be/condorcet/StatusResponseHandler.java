package be.condorcet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/StatusResponseHandler")
public class StatusResponseHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public StatusResponseHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupération de l'identifiant utilisateur
        String userId = request.getParameter("userId");

        // Vérification des conditions pour renvoyer les codes de statut appropriés
        if (userId == null || userId.isEmpty()) {
            // Si l'identifiant est vide
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400 Bad Request
            response.getWriter().println("<html><body>");
            response.getWriter().println("<h1>Code de statut : 400 Bad Request</h1>");
            response.getWriter().println("<p>Identifiant d'utilisateur requis.</p>");
            response.getWriter().println("</body></html>");
        } else {
            try {
                int userIdInt = Integer.parseInt(userId);
                if (userIdInt > 0) {
                    // Si l'identifiant est un entier valide et supérieur à 0
                    response.setStatus(HttpServletResponse.SC_OK); // 200 OK
                    response.getWriter().println("<html><body>");
                    response.getWriter().println("<h1>Code de statut : 200 OK</h1>");
                    response.getWriter().println("<p>Identifiant valide : " + userIdInt + "</p>");
                    response.getWriter().println("</body></html>");
                } else {
                    // Si l'identifiant est un entier négatif ou nul
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404 Not Found
                    response.getWriter().println("<html><body>");
                    response.getWriter().println("<h1>Code de statut : 404 Not Found</h1>");
                    response.getWriter().println("<p>Identifiant d'utilisateur introuvable.</p>");
                    response.getWriter().println("</body></html>");
                }
            } catch (NumberFormatException e) {
                // Si l'identifiant n'est pas un nombre entier valide
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400 Bad Request
                response.getWriter().println("<html><body>");
                response.getWriter().println("<h1>Code de statut : 400 Bad Request</h1>");
                response.getWriter().println("<p>Identifiant d'utilisateur invalide.</p>");
                response.getWriter().println("</body></html>");
            }
        }
	}

}
