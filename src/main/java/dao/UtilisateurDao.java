package dao;

import beans.Utilisateur;
import java.util.ArrayList;

/**
 * C'est la classe qu'il faut en premier tout le temps!!!!!
 * Data Access Object (DAO) pour la gestion des Utilisateurs.
 * Utilise une liste statique en mémoire pour simuler une base de données. 
 * (Mr Diop dit qu'à chaque fois qu'on veut des données se charge à la chargement de la classe,
 * il faut le mettre dans une portée static.
 */
public class UtilisateurDao {

    private static int lastId = 1;
    private static ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();

    // Initialisation avec quelques utilisateurs par défaut
    static {
        ajouter(new Utilisateur("Dupont", "Jean", "jdupont", "password123"));
        ajouter(new Utilisateur("Smith", "Alice", "asmith", "securepass"));
        ajouter(new Utilisateur("Doe", "John", "jdoe", "qwerty123"));
        ajouter(new Utilisateur("Brown", "Emma", "ebrown", "emma2024"));
        ajouter(new Utilisateur("Johnson", "Michael", "mjohnson", "mikepass"));
    }

    /**
     * Ajoute un nouvel utilisateur à la liste.
     *
     * @param utilisateur L'utilisateur à ajouter.
     */
    public static void ajouter(Utilisateur utilisateur) {
        utilisateur.setID(lastId++);
        utilisateurs.add(utilisateur);
    }

    /**
     * Retourne la liste de tous les utilisateurs.
     *
     * @return La liste des utilisateurs.
     */
    public static ArrayList<Utilisateur> lister() {
        return utilisateurs;
    }

    /**
     * Supprime un utilisateur de la liste en fonction de son identifiant.
     *
     * Cette méthode utilise une boucle for classique pour parcourir la liste.
     *
     * @param id L'identifiant de l'utilisateur à supprimer.
     */
    public static void supprimer(int id) {
        for (int i = 0; i < utilisateurs.size(); i++) {
            if (utilisateurs.get(i).getID() == id) {
                utilisateurs.remove(i);
                break; // Sortir de la boucle dès que l'utilisateur est supprimé
            }
        }
    }

    /**
     * Recherche et retourne un utilisateur par son identifiant.
     *
     * @param id L'identifiant de l'utilisateur recherché.
     * @return L'utilisateur correspondant, ou null si non trouvé.
     */
    public static Utilisateur trouver(int id) {
        for (Utilisateur user : utilisateurs) {
            if (user.getID() == id) {
                return user;
            }
        }
        return null;
    }

    /**
     * Met à jour les informations d'un utilisateur.
     * Remplace l'utilisateur existant avec les nouvelles informations.
     *
     * @param utilisateur L'utilisateur avec les informations mises à jour.
     */
    public static boolean mettreAJour(Utilisateur utilisateur) {
        for (int i = 0; i < utilisateurs.size(); i++) {
            if (utilisateurs.get(i).getID() == utilisateur.getID()) {
                utilisateurs.set(i, utilisateur);
                return true;
                
            }
        }
        return false;
    }
}
