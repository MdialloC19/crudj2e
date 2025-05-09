<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Erreur - Gestion des Utilisateurs</title>
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
        
        .error-container {
            width: 90%;
            max-width: 600px;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
            padding: 40px;
            text-align: center;
        }
        
        .error-icon {
            font-size: 80px;
            color: #dc3545;
            margin-bottom: 20px;
        }
        
        .error-title {
            font-size: 28px;
            color: #343a40;
            margin-bottom: 20px;
            font-weight: 600;
        }
        
        .error-message {
            color: #6c757d;
            margin-bottom: 30px;
            font-size: 16px;
            line-height: 1.6;
        }
        
        .error-details {
            background-color: #f8f9fa;
            padding: 15px;
            border-radius: 4px;
            margin-bottom: 30px;
            text-align: left;
            font-family: monospace;
            font-size: 14px;
            color: #6c757d;
            max-height: 200px;
            overflow-y: auto;
        }
        
        .btn {
            display: inline-block;
            padding: 12px 24px;
            border: none;
            border-radius: 4px;
            text-decoration: none;
            color: white;
            font-weight: 600;
            font-size: 16px;
            cursor: pointer;
            transition: all 0.3s ease;
            margin: 10px;
        }
        
        .btn-primary {
            background-color: #007bff;
        }
        
        .btn:hover {
            opacity: 0.9;
            transform: translateY(-2px);
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
    <div class="error-container">
        <div class="error-icon">&#9888;</div>
        <div class="error-title">Une erreur est survenue</div>
        <p class="error-message">
            Nous sommes désolés, mais une erreur s'est produite lors du traitement de votre demande.
            Veuillez réessayer ou contacter l'administrateur si le problème persiste.
        </p>
        
        <% if (exception != null) { %>
        <div class="error-details">
            <%= exception.getMessage() %>
        </div>
        <% } %>
        
        <a href="index.jsp" class="btn btn-primary">Retour à l'accueil</a>
    </div>
</body>
</html>
