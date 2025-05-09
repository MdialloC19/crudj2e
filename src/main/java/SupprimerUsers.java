import jakarta.servlet.ServletException;
import dao.UtilisateurDao;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class SupprimerUsers
 * Cette servlet gère la suppression des utilisateurs
 */
@WebServlet("/SupprimerUsers")
public class SupprimerUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerUsers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupération de l'ID de l'utilisateur à supprimer
		String idParam = request.getParameter("id");
		
		if (idParam != null && !idParam.isEmpty()) {
			try {
				// Conversion de l'ID en entier
				int id = Integer.parseInt(idParam);
				
				// Suppression de l'utilisateur
				boolean supprime = UtilisateurDao.supprimer(id);
				
				if (supprime) {
					// Ajout d'un message de succès
					request.getSession().setAttribute("message", "Utilisateur supprimé avec succès.");
				} else {
					// Ajout d'un message d'erreur
					request.getSession().setAttribute("erreur", "Échec de la suppression de l'utilisateur.");
				}
			} catch (NumberFormatException e) {
				// En cas d'erreur de conversion
				request.getSession().setAttribute("erreur", "ID d'utilisateur invalide.");
			}
		} else {
			// Si l'ID n'est pas fourni
			request.getSession().setAttribute("erreur", "ID d'utilisateur non spécifié.");
		}
		
		// Redirection vers la liste des utilisateurs
		response.sendRedirect("ListeUsers");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Appel de la méthode doGet pour traiter la suppression
		doGet(request, response);
	}
}
