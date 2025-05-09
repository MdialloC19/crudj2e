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
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            min-height: 100vh;
        }

        .container {
            background: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0px 4px 15px rgba(0, 0, 0, 0.1);
            width: 400px;
            margin: 50px auto;
        }

        h1 {
            color: #333;
            font-size: 24px;
            margin-bottom: 25px;
            text-align: center;
            border-bottom: 2px solid #f0f0f0;
            padding-bottom: 15px;
        }

        label {
            display: block;
            text-align: left;
            font-weight: 600;
            margin-top: 12px;
            color: #444;
            font-size: 14px;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 12px;
            margin-top: 6px;
            border: 1px solid #ddd;
            border-radius: 4px;
            font-size: 14px;
            outline: none;
            box-sizing: border-box;
            transition: border-color 0.3s;
        }

        input:focus {
            border-color: #28a745;
            box-shadow: 0 0 0 3px rgba(40, 167, 69, 0.2);
        }

        .btn {
            border: none;
            padding: 12px;
            margin-top: 20px;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
            transition: all 0.3s;
            font-weight: 600;
            display: inline-block;
            text-decoration: none;
            text-align: center;
        }
        
        .btn-primary {
            background: #ffc107;
            color: #212529;
            width: 100%;
        }

        .btn-primary:hover {
            background: #e0a800;
            transform: translateY(-2px);
        }
        
        .btn-secondary {
            background: #6c757d;
            color: white;
            margin-top: 10px;
            width: 100%;
        }
        
        .btn-secondary:hover {
            background: #5a6268;
        }
        
        .form-footer {
            margin-top: 20px;
            text-align: center;
        }
        
        .error {
            color: #dc3545;
            background-color: #f8d7da;
            border: 1px solid #f5c6cb;
            padding: 10px;
            border-radius: 4px;
            margin-bottom: 20px;
            text-align: center;
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
        <input type="text" name="nom" id="nom" value="<%= utilisateur.getNom() %>" placeholder="Entrez le nom" required>
        
        <label for="prenom">Prénom :</label>
        <input type="text" name="prenom" id="prenom" value="<%= utilisateur.getPrenom() %>" placeholder="Entrez le prénom" required>
        
        <label for="login">Login :</label>
        <input type="text" name="login" id="login" value="<%= utilisateur.getLogin() %>" placeholder="Entrez le login" required>
        
        <label for="password">Mot de passe :</label>
        <input type="password" name="password" id="password" value="<%= utilisateur.getPassword() %>" placeholder="Entrez le mot de passe" required>
        
        <button type="submit" class="btn btn-primary">Mettre à jour l'utilisateur</button>
        
        <div class="form-footer">
            <a href="ListeUsers" class="btn btn-secondary">Retour à la liste</a>
        </div>
    </form>
    <%
        }
    %>
</div>
</body>
</html>
