

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import beans.Utilisateur;
import dao.UtilisateurDao;
import java.util.*;


/**
 * Servlet implementation class AfficherFormulaire
 */
@WebServlet("/AfficherFormulaire")
public class AfficherFormulaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficherFormulaire() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//request.setAttribute("utilisateurs", UtilisateurDao.lister());
		getServletContext().getRequestDispatcher("/WEB-INF/ajoutUtilisateurs.jsp").forward(request, response);
        
	}
	

	/**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        
        if (nom != null && prenom != null && login != null && password != null &&
            !nom.isEmpty() && !prenom.isEmpty() && !login.isEmpty() && !password.isEmpty()) {
        	
        	
        	 Utilisateur utilisateur = new Utilisateur(nom, prenom, login, password);

            
            UtilisateurDao.ajouter(utilisateur);

           
            response.sendRedirect("ListeUsers");
        } else {
           
            request.setAttribute("error", "Tous les champs sont obligatoires !");
            getServletContext().getRequestDispatcher("/WEB-INF/listerUtilisateurs.jsp").forward(request, response);
        }
    }

}


