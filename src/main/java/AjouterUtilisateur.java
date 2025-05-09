import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import beans.Utilisateur;
import dao.UtilisateurDao;

/**
 * Servlet implementation class AjouterUtilisateur
 * Cette servlet traite l'ajout d'un nouvel utilisateur dans la base de données
 */
@WebServlet("/AjouterUtilisateur")
public class AjouterUtilisateur extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterUtilisateur() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirection vers la page d'ajout
        getServletContext().getRequestDispatcher("/WEB-INF/ajoutUtilisateurs.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupération des paramètres du formulaire
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        // Validation des champs
        if (nom == null || prenom == null || login == null || password == null ||
            nom.isEmpty() || prenom.isEmpty() || login.isEmpty() || password.isEmpty()) {
            // Si un champ est vide, afficher un message d'erreur
            request.setAttribute("error", "Tous les champs sont obligatoires !");
            getServletContext().getRequestDispatcher("/WEB-INF/ajoutUtilisateurs.jsp").forward(request, response);
            return;
        }
        
        // Création de l'utilisateur
        Utilisateur utilisateur = new Utilisateur(nom, prenom, login, password);
        
        // Ajout de l'utilisateur à la base de données
        UtilisateurDao.ajouter(utilisateur);
        
        // Message de succès
        request.getSession().setAttribute("message", "Utilisateur ajouté avec succès.");
        
        // Redirection vers la liste des utilisateurs
        response.sendRedirect("ListeUsers");
    }
}
