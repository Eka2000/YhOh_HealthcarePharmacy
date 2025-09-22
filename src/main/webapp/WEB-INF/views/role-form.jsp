<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2 style="text-align:center;">Role Details</h2>

<style>
    .role-form-container {
        display: flex;
        justify-content: center;
        align-items: center;
        padding: 40px 20px;
    }
    .role-form {
        width: 100%;
        max-width: 600px;
        background: #f9f9f9;
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        font-family: Arial, sans-serif;
    }
    .role-form label {
        display: block;
        margin: 10px 0 5px;
        font-weight: bold;
    }
    .role-form input[type="text"] {
        width: 100%;
        padding: 10px 12px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 5px;
        font-size: 14px;
        box-sizing: border-box;
    }
    .role-form .permissions-list {
        margin-bottom: 20px;
        max-height: 200px;
        overflow-y: auto;
        padding: 8px;
        border: 1px solid #ccc;
        border-radius: 5px;
        background: #fff;
    }
    .role-form .permissions-list label {
        font-weight: normal;
        display: flex;
        align-items: center;
        margin-bottom: 8px;
    }
    .role-form button {
        background-color: #27D1D0;
        color: white;
        padding: 12px;
        border: none;
        border-radius: 5px;
        font-size: 16px;
        cursor: pointer;
        transition: background 0.3s ease;
        width: 100%;
    }
    .role-form button:hover {
        background-color: #1fa1a0;
    }
</style>

<div class="role-form-container">
    <div class="role-form">

        <c:choose>
            <c:when test="${role != null && role.id != null}">
                <form action="<c:url value='/roles/update/${role.id}' />" method="post">
            </c:when>
            <c:otherwise>
                <form action="<c:url value='/roles' />" method="post">
            </c:otherwise>
        </c:choose>

            <!-- Hidden ID for edit -->
            <c:if test="${role != null && role.id != null}">
                <input type="hidden" name="id" value="${role.id}" />
            </c:if>

            <label>Role Name:</label>
            <input type="text" name="name" value="<c:out value='${role.name}'/>" required/>

            <label>Permissions:</label>
            <div class="permissions-list">
                <c:forEach var="perm" items="${permissions}">
                    <label>
                        <input type="checkbox" name="permissionIds"
                               value="${perm.id}"
                               <c:if test="${role.permissions != null && role.permissions.contains(perm)}">checked</c:if> />
                        ${perm.name}
                    </label>
                </c:forEach>
            </div>

            <button type="submit">
                <c:choose>
                    <c:when test="${role != null && role.id != null}">Update</c:when>
                    <c:otherwise>Save</c:otherwise>
                </c:choose>
            </button>
        </form>
    </div>
</div>