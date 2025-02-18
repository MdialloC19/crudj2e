<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="beans.Utilisateur" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modifier Utilisateur</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f2f2f2;
            padding: 20px;
        }
        .container {
            max-width: 500px;
            margin: auto;
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        h1 {
            text-align: center;
        }
        label {
            display: block;
            margin-top: 10px;
            font-weight: bold;
        }
        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        .btn {
            display: block;
            width: 100%;
            margin-top: 20px;
            padding: 10px;
            background: #007BFF;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .btn:hover {
            background: #0056b3;
        }
        .error {
            color: red;
            margin-top: 10px;
            text-align: center;
        }
        .back-link {
            display: block;
            text-align: center;
            margin-top: 15px;
            text-decoration: none;
            color: #007BFF;
        }
        .back-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Modifier Utilisateur</h1>
    <%
        // Récupération de l'utilisateur passé en attribut de requête
        Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur");
        if (utilisateur == null) {
    %>
        <p class="error">Aucun utilisateur à modifier.</p>
        <a class="back-link" href="ListeUsers">Retour à la liste</a>
    <%
        } else {
    %>
    <form action="ModifierUsers" method="post">
        <!-- Champ caché pour transmettre l'ID de l'utilisateur -->
        <input type="hidden" name="id" value="<%= utilisateur.getID() %>">
        
        <label for="nom">Nom :</label>
        <input type="text" name="nom" id="nom" value="<%= utilisateur.getNom() %>" required>
        
        <label for="prenom">Prénom :</label>
        <input type="text" name="prenom" id="prenom" value="<%= utilisateur.getPrenom() %>" required>
        
        <label for="login">Login :</label>
        <input type="text" name="login" id="login" value="<%= utilisateur.getLogin() %>" required>
        
        <label for="password">Mot de passe :</label>
        <input type="password" name="password" id="password" value="<%= utilisateur.getPassword() %>" required>
        
        <button type="submit" class="btn">Mettre à jour</button>
    </form>
    <a class="back-link" href="AfficherFormulaire">Retour à la liste</a>
    <%
        }
    %>
</div>
</body>
</html>
