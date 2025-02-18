<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/taglibs/standard/permittedTaglibs" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des Utilisateurs</title>
<style>
    body {
        font-family: Arial, sans-serif;
    }
    .container {
        width: 80%;
        margin: 20px auto;
        text-align: center;
    }
    table {
        border-collapse: collapse;
        width: 100%;
        margin-top: 20px;
        box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
    }
    th, td {
        border: 1px solid #ddd;
        padding: 12px;
        text-align: left;
    }
    th {
        background-color: #f2f2f2;
    }
    tr:nth-child(even) {
        background-color: #f9f9f9;
    }
    tr:hover {
        background-color: #f1f1f1;
    }
    .btn {
        padding: 8px 12px;
        border: none;
        border-radius: 4px;
        text-decoration: none;
        color: white;
        cursor: pointer;
        margin: 5px;
        font-size: 14px;
    }
    .btn-add { background-color: #28a745; }
    .btn-view { background-color: #007bff; }
    .btn-edit { background-color: #ffc107; }
    .btn-delete { background-color: #dc3545; }
    .btn:hover { opacity: 0.9; }
    .btn-container { text-align: center; }
</style>
</head>
<body>
    <div class="container">
        <h1>Liste des Utilisateurs</h1>
        <a href="/crud/AfficherFormulaire" class="btn btn-add">Ajouter un utilisateur</a>
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
                                    <a href="deleteUser?id=${utilisateur.ID}" class="btn btn-delete" 
                                       onclick="return confirm('Êtes-vous sûr de vouloir supprimer cet utilisateur ?');">Supprimer</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td colspan="6" style="text-align: center;">Aucun utilisateur trouvé:${utilisateurs}</td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </tbody>
        </table>
    </div>
</body>
</html>
