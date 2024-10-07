package be.condorcet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class PokemonReceiver
 */
@WebServlet("/PokemonReceiver")
public class PokemonReceiver extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PokemonReceiver() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupération des Pokémon sélectionnés
        String[] selectedPokemon = request.getParameterValues("pokemon");

        // Génération de la réponse HTML
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Vous avez choisi :</h1>");
        
        if (selectedPokemon != null && selectedPokemon.length > 0) {
            for (String pokemon : selectedPokemon) {
                response.getWriter().println("<p>" + pokemon + "</p>");
            }
            response.getWriter().println("<p>Merci pour votre choix !</p>");
            response.getWriter().println("<p>Amusez-vous bien avec vos Pokémon !</p>");
        } else {
            response.getWriter().println("<p>Aucun Pokémon sélectionné.</p>");
        }

        response.getWriter().println("</body></html>");
	}

}
