package dao;

import beans.Utilisateur;
import java.sql.*;
import java.util.ArrayList;


/**
 * C'est la classe qu'il faut regarder en premier tout le temps!!!!! Boul dofff
 * Data Access Object (DAO) pour la gestion des Utilisateurs.
 * V2 on va utiliser
 * Utilise JDBC pour interagir avec une base de données.
 */

public class UtilisateurDao {

    /**
     * Ajoute un nouvel utilisateur à la base de données.
     *
     * @param utilisateur L'utilisateur à ajouter.
     */
    public static void ajouter(Utilisateur utilisateur) {
        String sql = "INSERT INTO utilisateurs (nom, prenom, login, password) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, utilisateur.getNom());
            stmt.setString(2, utilisateur.getPrenom());
            stmt.setString(3, utilisateur.getLogin());
            stmt.setString(4, utilisateur.getPassword());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    utilisateur.setID(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Ajoute plusieurs utilisateurs fictifs à la base de données.
     */
    public static void ajouterUtilisateursFictifs() {
        String sql = "INSERT INTO utilisateurs (nom, prenom,login, password) VALUES (?, ?, ?, ?)";
        String[][] fakeUsers = {
            {"Diallo", "Mamadou", "mdiallo", "password123"},
            {"Ndour", "Aissatou", "aissatou.ndour", "azerty"},
            {"Diop", "Alioune", "adiop", "pass456"},
            {"Fall", "Fatou", "fatou.fall", "123456"},
            {"Sow", "Boubacar", "bsow", "motdepasse"}
        };

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            for (String[] user : fakeUsers) {
                stmt.setString(1, user[0]);
                stmt.setString(2, user[1]);
                stmt.setString(3, user[2]);
                stmt.setString(4, user[3]);
                stmt.addBatch();
            }
            stmt.executeBatch();
            System.out.println("Utilisateurs fictifs ajoutés avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retourne la liste de tous les utilisateurs.
     *
     * @return La liste des utilisateurs.
     */
    public static ArrayList<Utilisateur> lister() {
        ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
        String sql = "SELECT * FROM utilisateurs";
        try (Connection conn = ConnectionManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                utilisateurs.add(new Utilisateur(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("login"),
                        rs.getString("password")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("voir "+utilisateurs.isEmpty());
        if(utilisateurs.isEmpty()) {
        	
        	ajouterUtilisateursFictifs();
        }
        return utilisateurs;
    }


 
    public static boolean mettreAJour(Utilisateur utilisateur) {
        String sql = "UPDATE utilisateurs SET nom = ?, prenom = ?, login = ?, password = ? WHERE id = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, utilisateur.getNom());
            stmt.setString(2, utilisateur.getPrenom());
            stmt.setString(3, utilisateur.getLogin());
            stmt.setString(4, utilisateur.getPassword());
            stmt.setInt(5, utilisateur.getID());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    /**
     * Supprime un utilisateur de la base de données.
     *
     * @param id L'identifiant de l'utilisateur à supprimer.
     * @return true si la suppression a réussi, false sinon.
     */
    public static boolean supprimer(int id) {
        String sql = "DELETE FROM utilisateurs WHERE id = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    /**
     * Trouve un utilisateur par son identifiant.
     *
     * @param id L'identifiant de l'utilisateur à trouver.
     * @return L'utilisateur trouvé ou null si aucun utilisateur n'a été trouvé.
     */
    public static Utilisateur trouver(int id) {
        String sql = "SELECT * FROM utilisateurs WHERE id = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Utilisateur(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("login"),
                        rs.getString("password")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}


