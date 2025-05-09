<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Ajouter un Utilisateur</title>
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

        input {
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
            background: #28a745;
            color: white;
            width: 100%;
        }

        .btn-primary:hover {
            background: #218838;
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
    </style>
</head>
<body>

    <div class="container">
        <h1>Ajouter un Utilisateur</h1>
        <form action="AfficherFormulaire" method="POST">
            <label for="nom">Nom :</label>
            <input type="text" id="nom" name="nom" placeholder="Entrez le nom" required>

            <label for="prenom">Prénom :</label>
            <input type="text" id="prenom" name="prenom" placeholder="Entrez le prénom" required>

            <label for="login">Login :</label>
            <input type="text" id="login" name="login" placeholder="Entrez le login" required>

            <label for="password">Mot de passe :</label>
            <input type="password" id="password" name="password" placeholder="Entrez le mot de passe" required>

            <input type="submit" class="btn btn-primary" value="Ajouter l'utilisateur">
            
            <div class="form-footer">
                <a href="ListeUsers" class="btn btn-secondary">Retour à la liste</a>
            </div>
        </form>
    </div>

</body>
</html>
