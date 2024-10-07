package be.condorcet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/QueryStringReceiver")
public class QueryStringReceiver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QueryStringReceiver() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupération des paramètres de la query string
        String name = request.getParameter("name");
        String firstname = request.getParameter("firstname");
        String age = request.getParameter("age");
        
        // Génération de la réponse HTML
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Bonjour " + firstname + " " + name + ", vous avez " + age + " ans.</h1>");
        response.getWriter().println("</body></html>");
	}
}
