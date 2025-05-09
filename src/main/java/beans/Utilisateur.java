package beans;

/**
 * Concentre toi sur le DAO, moom gua wara xoll, tu touches rarement ce projet donc il faut toujours commenter
 * Cette classe représente un utilisateur dans le système.
 * Elle contient les informations de base d'un utilisateur, telles que son identifiant, son nom, son prénom, son login et son mot de passe.
 */
public class Utilisateur {

    /** Identifiant unique de l'utilisateur */
    private int ID;
    
    /** Nom de l'utilisateur */
    private String nom;
    
    /** Prénom de l'utilisateur */
    private String prenom;
    
    /** Login de l'utilisateur */
    private String login;
    
    /** Mot de passe de l'utilisateur */
    private String password;
    
    /**
     * Constructeur par défaut.
     */
    public Utilisateur() {
        // Constructeur vide
    }
    
    /**
     * Constructeur permettant d'initialiser un utilisateur avec ses informations de base.
     *
     * @param nom le nom de l'utilisateur
     * @param prenom le prénom de l'utilisateur
     * @param login le login de l'utilisateur
     * @param password le mot de passe de l'utilisateur
     */
    public Utilisateur(String nom, String prenom, String login, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
    }
    
    public Utilisateur(int ID, String nom, String prenom, String login, String password) {
        this.ID=ID;
    	this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
    }
    
    
    /**
     * Retourne l'identifiant de l'utilisateur.
     *
     * @return l'ID de l'utilisateur
     */
    public int getID() {
        return ID;
    }
    
    /**
     * Définit l'identifiant de l'utilisateur.
     *
     * @param iD l'identifiant à attribuer
     */
    public void setID(int iD) {
        ID = iD;
    }
    
    /**
     * Retourne le nom de l'utilisateur.
     *
     * @return le nom de l'utilisateur
     */
    public String getNom() {
        return nom;
    }
    
    /**
     * Définit le nom de l'utilisateur.
     *
     * @param nom le nom à attribuer
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    /**
     * Retourne le prénom de l'utilisateur.
     *
     * @return le prénom de l'utilisateur
     */
    public String getPrenom() {
        return prenom;
    }
    
    /**
     * Définit le prénom de l'utilisateur.
     *
     * @param prenom le prénom à attribuer
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    /**
     * Retourne le login de l'utilisateur.
     *
     * @return le login de l'utilisateur
     */
    public String getLogin() {
        return login;
    }
    
    /**
     * Définit le login de l'utilisateur.
     *
     * @param login le login à attribuer
     */
    public void setLogin(String login) {
        this.login = login;
    }
    
    /**
     * Retourne le mot de passe de l'utilisateur.
     *
     * @return le mot de passe de l'utilisateur
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * Définit le mot de passe de l'utilisateur.
     *
     * @param password le mot de passe à attribuer
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
