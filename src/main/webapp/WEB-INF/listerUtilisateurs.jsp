<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des Utilisateurs</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
        min-height: 100vh;
    }
    
    .container {
        width: 90%;
        max-width: 1200px;
        margin: 40px auto;
        background-color: white;
        border-radius: 8px;
        box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
        padding: 30px;
    }
    
    h1 {
        color: #333;
        font-size: 28px;
        margin-bottom: 25px;
        text-align: center;
        border-bottom: 2px solid #f0f0f0;
        padding-bottom: 15px;
    }
    
    table {
        border-collapse: collapse;
        width: 100%;
        margin: 30px 0;
        box-shadow: 0 2px 8px rgba(0, 0, 0, 0.05);
        border-radius: 8px;
        overflow: hidden;
    }
    
    th, td {
        padding: 15px;
        text-align: left;
    }
    
    th {
        background-color: #343a40;
        color: white;
        font-weight: 600;
        text-transform: uppercase;
        font-size: 14px;
        letter-spacing: 0.5px;
    }
    
    tr:nth-child(even) {
        background-color: #f8f9fa;
    }
    
    tr:hover {
        background-color: #e9ecef;
    }
    
    .btn {
        padding: 8px 12px;
        border: none;
        border-radius: 4px;
        text-decoration: none;
        color: white;
        cursor: pointer;
        margin: 3px;
        font-size: 14px;
        display: inline-block;
        transition: all 0.3s ease;
    }
    
    .btn-add { 
        background-color: #28a745; 
        padding: 12px 20px;
        font-size: 16px;
        font-weight: 600;
        display: inline-block;
        margin-bottom: 20px;
    }
    
    .btn-view { background-color: #007bff; }
    .btn-edit { background-color: #ffc107; color: #212529; }
    .btn-delete { background-color: #dc3545; }
    
    .btn:hover { 
        opacity: 0.9; 
        transform: translateY(-2px);
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }
    
    .btn-container { 
        text-align: center; 
        white-space: nowrap;
    }
    
    .message {
        padding: 15px;
        margin: 20px 0;
        border-radius: 4px;
        text-align: center;
        font-weight: 500;
    }
    
    .success {
        background-color: #d4edda;
        color: #155724;
        border: 1px solid #c3e6cb;
    }
    
    .error {
        background-color: #f8d7da;
        color: #721c24;
        border: 1px solid #f5c6cb;
    }
    
    .header-actions {
        display: flex;
        justify-content: space-between;
        align-items: center;
        margin-bottom: 20px;
    }
    
    .app-title {
        font-size: 32px;
        color: #343a40;
        margin-bottom: 10px;
        font-weight: 700;
    }
    
    .empty-message {
        text-align: center;
        padding: 30px;
        color: #6c757d;
        font-style: italic;
    }
</style>
</head>
<body>
    <div class="container">
        <div class="app-title">Gestion des Utilisateurs</div>
        <h1>Liste des Utilisateurs</h1>
        
        <!-- Affichage des messages de succès -->
        <c:if test="${not empty sessionScope.message}">
            <div class="message success">
                ${sessionScope.message}
                <% session.removeAttribute("message"); %>
            </div>
        </c:if>
        
        <!-- Affichage des messages d'erreur -->
        <c:if test="${not empty sessionScope.erreur}">
            <div class="message error">
                ${sessionScope.erreur}
                <% session.removeAttribute("erreur"); %>
            </div>
        </c:if>
        
        <div class="header-actions">
            <a href="AjouterUtilisateur" class="btn btn-add">+ Ajouter un utilisateur</a>
        </div>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nom</th>
                    <th>Prénom</th>
                    <th>Login</th>
                    <th>Password</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
               
                <c:choose>
                    <c:when test="${not empty utilisateurs}">
                        <c:forEach var="utilisateur" items="${utilisateurs}">
                            <tr>
                                <td>${utilisateur.ID}</td>
                                <td>${utilisateur.nom}</td>
                                <td>${utilisateur.prenom}</td>
                                <td>${utilisateur.login}</td>
                                <td>${utilisateur.password}</td>
                                <td class="btn-container">
                                    <a href="viewUser?id=${utilisateur.ID}" class="btn btn-view">Voir</a>
                                    <a href="ModifierUsers?id=${utilisateur.ID}" class="btn btn-edit">Modifier</a>
                                    <a href="SupprimerUsers?id=${utilisateur.ID}" class="btn btn-delete" 
                                       onclick="return confirm('Êtes-vous sûr de vouloir supprimer cet utilisateur ?');">Supprimer</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td colspan="6" class="empty-message">Aucun utilisateur trouvé dans la base de données</td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </tbody>
        </table>
    </div>
</body>
</html>
