
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

import beans.Utilisateur;
import dao.UtilisateurDao;

/**
 * Servlet implementation class ModifierUsers
 */
@WebServlet("/ModifierUsers")
public class ModifierUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierUsers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupérer l'id de l'utilisateur à modifier
		int idUser = Integer.parseInt(request.getParameter("id"));
		System.out.println("ID utilisateur à modifier: " + idUser);
		
		// Récupérer l'utilisateur et le mettre dans la requête
		request.setAttribute("utilisateur", UtilisateurDao.trouver(idUser));
		
		// Rediriger vers la page de modification
		request.getRequestDispatcher("/WEB-INF/modifierUtilisateurs.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            int id = Integer.parseInt(request.getParameter("id"));
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String login = request.getParameter("login");
            String password = request.getParameter("password");

            if (nom == null || prenom == null || login == null || password == null ||
                nom.isEmpty() || prenom.isEmpty() || login.isEmpty() || password.isEmpty()) {
                // Utilisation de la session pour stocker le message d'erreur
                request.getSession().setAttribute("erreur", "Tous les champs sont obligatoires.");
                // Récupération de l'utilisateur pour pré-remplir le formulaire
                request.setAttribute("utilisateur", UtilisateurDao.trouver(id));
                request.getRequestDispatcher("/WEB-INF/modifierUtilisateurs.jsp").forward(request, response);
                return;
            }

            Utilisateur utilisateur = new Utilisateur(nom, prenom, login, password);
            utilisateur.setID(id); 

            boolean updated = UtilisateurDao.mettreAJour(utilisateur);

            if (updated) {
                request.getSession().setAttribute("message", "Utilisateur modifié avec succès.");
                response.sendRedirect("ListeUsers"); 
            } else {
                request.getSession().setAttribute("erreur", "La modification a échoué. Veuillez réessayer.");
                request.setAttribute("utilisateur", utilisateur);
                request.getRequestDispatcher("/WEB-INF/modifierUtilisateurs.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.getSession().setAttribute("erreur", "Erreur lors de la modification : " + e.getMessage());
            response.sendRedirect("ListeUsers");
        }
    }
	

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
