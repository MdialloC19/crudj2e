

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
		// TODO Auto-generated method stub
		// je dois recupérer d'abord id puis creer recuperer l'utilisateur avec le DAO
		//puis envoyer ça  à la pape 
		
		int idUser=Integer.parseInt(request.getParameter("id"));
		System.out.println(idUser);
		request.setAttribute("utilisateur", UtilisateurDao.trouver(idUser));
		
		
		getServletContext().getRequestDispatcher("/WEB-INF/modifierUtilisateurs.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
          
            int id = Integer.parseInt(request.getParameter("id"));
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String login = request.getParameter("login");
            String password = request.getParameter("password");

           
            if (nom == null || prenom == null || login == null || password == null ||
                nom.isEmpty() || prenom.isEmpty() || login.isEmpty() || password.isEmpty()) {
                request.setAttribute("error", "Tous les champs sont obligatoires.");
                request.getRequestDispatcher("modifierUtilisateur.jsp").forward(request, response);
                return;
            }

           
            Utilisateur utilisateur = new Utilisateur(nom, prenom, login, password);
            utilisateur.setID(id); 

            
            boolean updated = UtilisateurDao.mettreAJour(utilisateur);

            
            if (updated) {
                response.sendRedirect("ListeUsers"); 
            } else {
                request.setAttribute("error", "La modification a échoué. Veuillez réessayer.");
                request.getRequestDispatcher("modifierUtilisateur.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("error", "Erreur lors de la modification : " + e.getMessage());
            request.getRequestDispatcher("modifierUtilisateur.jsp").forward(request, response);
        }
    }
	

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
