<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2 style="text-align:center;">Permission Details</h2>

<style>
    .permission-form-container {
        display: flex;
        justify-content: center;
        align-items: center;
        padding: 40px 20px;
    }
    .permission-form {
        width: 100%;
        max-width: 500px;
        background: #f9f9f9;
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        font-family: Arial, sans-serif;
    }
    .permission-form label {
        display: block;
        margin: 10px 0 5px;
        font-weight: bold;
    }
    .permission-form input[type="text"] {
        width: 100%;
        padding: 10px 12px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 5px;
        font-size: 14px;
        box-sizing: border-box;
    }
    .permission-form button {
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
    .permission-form button:hover {
        background-color: #1fa1a0;
    }
</style>

<div class="permission-form-container">
    <div class="permission-form">

        <c:choose>
            <c:when test="${isEdit}">
                <form action="<c:url value='/permissions/update/${id}' />" method="post">
            </c:when>
            <c:otherwise>
                <form action="<c:url value='/permissions/save' />" method="post">
            </c:otherwise>
        </c:choose>

            <label>Permission Name:</label>
            <input type="text" name="name" value="${permission.name}" required/>

            <button type="submit">
                <c:choose>
                    <c:when test="${isEdit}">Update</c:when>
                    <c:otherwise>Save</c:otherwise>
                </c:choose>
            </button>
        </form>
    </div>
</div>