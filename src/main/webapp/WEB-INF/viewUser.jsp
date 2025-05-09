<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="beans.Utilisateur" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Détails de l'Utilisateur</title>
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
            width: 500px;
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
        
        .app-title {
            font-size: 32px;
            color: #343a40;
            margin-bottom: 10px;
            font-weight: 700;
            text-align: center;
        }

        .user-info {
            margin-bottom: 30px;
        }

        .user-field {
            margin-bottom: 20px;
            border-bottom: 1px solid #f0f0f0;
            padding-bottom: 10px;
        }

        .field-label {
            font-weight: 600;
            color: #6c757d;
            font-size: 14px;
            display: block;
            margin-bottom: 5px;
        }

        .field-value {
            color: #343a40;
            font-size: 18px;
        }

        .btn {
            border: none;
            padding: 12px;
            margin-top: 10px;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
            transition: all 0.3s;
            font-weight: 600;
            display: inline-block;
            text-decoration: none;
            text-align: center;
            width: 100%;
        }
        
        .btn-primary {
            background: #007bff;
            color: white;
        }
        
        .btn-warning {
            background: #ffc107;
            color: #212529;
        }
        
        .btn-danger {
            background: #dc3545;
            color: white;
        }
        
        .btn-secondary {
            background: #6c757d;
            color: white;
        }

        .btn:hover {
            opacity: 0.9;
            transform: translateY(-2px);
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        
        .actions {
            display: flex;
            flex-direction: column;
            gap: 10px;
            margin-top: 20px;
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
        <div class="app-title">Gestion des Utilisateurs</div>
        <h1>Détails de l'Utilisateur</h1>
        
        <%
            // Récupération de l'utilisateur passé en attribut de requête
            Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur");
            if (utilisateur == null) {
        %>
            <p class="error">Utilisateur non trouvé.</p>
            <div class="actions">
                <a href="ListeUsers" class="btn btn-secondary">Retour à la liste</a>
            </div>
        <%
            } else {
        %>
        <div class="user-info">
            <div class="user-field">
                <span class="field-label">ID</span>
                <div class="field-value"><%= utilisateur.getID() %></div>
            </div>
            
            <div class="user-field">
                <span class="field-label">Nom</span>
                <div class="field-value"><%= utilisateur.getNom() %></div>
            </div>
            
            <div class="user-field">
                <span class="field-label">Prénom</span>
                <div class="field-value"><%= utilisateur.getPrenom() %></div>
            </div>
            
            <div class="user-field">
                <span class="field-label">Login</span>
                <div class="field-value"><%= utilisateur.getLogin() %></div>
            </div>
            
            <div class="user-field">
                <span class="field-label">Mot de passe</span>
                <div class="field-value">••••••••</div>
            </div>
        </div>
        
        <div class="actions">
            <a href="ModifierUsers?id=<%= utilisateur.getID() %>" class="btn btn-warning">Modifier</a>
            <a href="SupprimerUsers?id=<%= utilisateur.getID() %>" class="btn btn-danger" 
               onclick="return confirm('Êtes-vous sûr de vouloir supprimer cet utilisateur ?');">Supprimer</a>
            <a href="ListeUsers" class="btn btn-secondary">Retour à la liste</a>
        </div>
        <%
            }
        %>
    </div>
</body>
</html>
