<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2 style="text-align:center;">User Roles</h2>

<style>
    .role-actions {
        display: flex;
        justify-content: flex-end;
        margin-bottom: 15px;
    }
    .add-role-btn {
        background: #27D1D0;
        color: white;
        padding: 10px 15px;
        border-radius: 5px;
        text-decoration: none;
        transition: background 0.3s ease;
    }
    .add-role-btn:hover {
        background: #1fa1a0;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        font-family: Arial, sans-serif;
    }
    th, td {
        padding: 12px;
        border: 1px solid #ddd;
    }
    thead {
        background: #27D1D0;
        color: white;
        text-align: center;
    }
    tr:nth-child(even) {
        background: #f9f9f9;
    }
    tr:hover {
        background: #f1f1f1;
    }
    /* Alignment fixes */
    td:nth-child(1), 
    td:nth-child(4) {
        text-align: center; /* S.No + Actions */
        width: 10%;
    }
    td:nth-child(2) {
        text-align: left;   /* Role Name */
        width: 20%;
    }
    td:nth-child(3) {
        text-align: left;   /* Permissions */
        width: 50%;
        word-wrap: break-word;
        white-space: normal;
    }
    .action-links a {
        margin: 0 5px;
        text-decoration: none;
        color: #27D1D0;
        font-weight: bold;
    }
    .action-links a:hover {
        color: #1fa1a0;
    }
</style>

<div class="role-actions">
    <a href="<c:url value='/roles/new' />" class="add-role-btn">
        + New Role
    </a>
</div>

<table>
    <thead>
        <tr>
            <th>S.No</th>
            <th>Role Name</th>
            <th>Permissions</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="role" items="${roles}" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td><c:out value="${role.name}" /></td>
                <td>
                    <c:forEach var="perm" items="${role.permissions}" varStatus="loop">
                        <c:out value="${perm.name}" />
                        <c:if test="${!loop.last}">, </c:if>
                    </c:forEach>
                </td>
                <td class="action-links">
                    <a href="<c:url value='/roles/edit/${role.id}' />">Edit</a> |
                    <a href="<c:url value='/roles/delete/${role.id}' />"
                       onclick="return confirm('Are you sure you want to delete this role?')">
                        Delete
                    </a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>