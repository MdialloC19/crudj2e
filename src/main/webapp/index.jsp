<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestion des Utilisateurs - Accueil</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            min-height: 100vh;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
        }
        
        .container {
            width: 90%;
            max-width: 800px;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
            padding: 40px;
            text-align: center;
        }
        
        .app-title {
            font-size: 36px;
            color: #343a40;
            margin-bottom: 20px;
            font-weight: 700;
        }
        
        .app-description {
            color: #6c757d;
            margin-bottom: 40px;
            font-size: 18px;
            line-height: 1.6;
        }
        
        .features {
            display: flex;
            justify-content: space-around;
            flex-wrap: wrap;
            margin: 30px 0;
        }
        
        .feature {
            flex-basis: 30%;
            min-width: 200px;
            margin: 15px;
            padding: 20px;
            border-radius: 8px;
            background-color: #f8f9fa;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.05);
        }
        
        .feature-title {
            font-weight: 600;
            color: #343a40;
            margin-bottom: 10px;
            font-size: 20px;
        }
        
        .feature-description {
            color: #6c757d;
            font-size: 14px;
        }
        
        .btn {
            display: inline-block;
            padding: 14px 28px;
            border: none;
            border-radius: 4px;
            text-decoration: none;
            color: white;
            font-weight: 600;
            font-size: 18px;
            cursor: pointer;
            transition: all 0.3s ease;
            margin: 10px;
        }
        
        .btn-primary {
            background-color: #28a745;
        }
        
        .btn-secondary {
            background-color: #007bff;
        }
        
        .btn:hover {
            opacity: 0.9;
            transform: translateY(-2px);
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        
        .footer {
            margin-top: 40px;
            color: #6c757d;
            font-size: 14px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="app-title">Gestion des Utilisateurs</div>
        <p class="app-description">
            Bienvenue dans l'application de gestion des utilisateurs. Cette application vous permet de créer, consulter, 
            modifier et supprimer des utilisateurs facilement.
        </p>
        
        <div class="features">
            <div class="feature">
                <div class="feature-title">Créer</div>
                <p class="feature-description">Ajoutez de nouveaux utilisateurs avec leurs informations complètes.</p>
            </div>
            <div class="feature">
                <div class="feature-title">Consulter</div>
                <p class="feature-description">Visualisez la liste de tous les utilisateurs enregistrés.</p>
            </div>
            <div class="feature">
                <div class="feature-title">Gérer</div>
                <p class="feature-description">Modifiez ou supprimez les informations des utilisateurs existants.</p>
            </div>
        </div>
        
        <a href="ListeUsers" class="btn btn-primary">Voir les utilisateurs</a>
        <a href="AfficherFormulaire" class="btn btn-secondary">Ajouter un utilisateur</a>
        
        <div class="footer">
            &copy; 2025 Application CRUD J2EE - Développée par Moussa Diallo
        </div>
    </div>
</body>
</html>
