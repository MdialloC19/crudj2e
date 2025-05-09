import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import beans.Utilisateur;
import dao.UtilisateurDao;

/**
 * Servlet implementation class ViewUser
 * Cette servlet gère l'affichage des détails d'un utilisateur
 */
@WebServlet("/viewUser")
public class ViewUser extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewUser() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupération de l'ID de l'utilisateur à afficher
        String idParam = request.getParameter("id");
        
        if (idParam != null && !idParam.isEmpty()) {
            try {
                // Conversion de l'ID en entier
                int id = Integer.parseInt(idParam);
                
                // Récupération de l'utilisateur
                Utilisateur utilisateur = UtilisateurDao.trouver(id);
                
                if (utilisateur != null) {
                    // Ajout de l'utilisateur comme attribut de la requête
                    request.setAttribute("utilisateur", utilisateur);
                    
                    // Redirection vers la page de détails
                    request.getRequestDispatcher("/WEB-INF/viewUser.jsp").forward(request, response);
                } else {
                    // Si l'utilisateur n'existe pas
                    request.getSession().setAttribute("erreur", "Utilisateur non trouvé.");
                    response.sendRedirect("ListeUsers");
                }
            } catch (NumberFormatException e) {
                // En cas d'erreur de conversion
                request.getSession().setAttribute("erreur", "ID d'utilisateur invalide.");
                response.sendRedirect("ListeUsers");
            }
        } else {
            // Si l'ID n'est pas fourni
            request.getSession().setAttribute("erreur", "ID d'utilisateur non spécifié.");
            response.sendRedirect("ListeUsers");
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirection vers doGet
        doGet(request, response);
    }
}
