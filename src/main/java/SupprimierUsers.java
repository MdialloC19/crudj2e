

import jakarta.servlet.ServletException;

import dao.UtilisateurDao;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class SupprimierUsers
 */
@WebServlet("/SupprimerUsers")
public class SupprimierUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimierUsers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Moussa rappel toi d'une chose
		// pour convertir un string en int il faut utiliser parseInt qui se trouve dans la classe Integer c'est une méthode static
		request.setAttribute("utilisateur", UtilisateurDao.trouver(Integer.parseInt(request.getParameter("id"))));
		System.out.println(request);
		
		getServletContext().getRequestDispatcher("/WEB-INF/modifierUtilisateurs.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
