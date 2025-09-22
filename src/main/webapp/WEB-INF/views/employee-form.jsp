<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2 style="text-align:center;">Employee Details</h2>

<style>
    .employee-form-container {
        display: flex;
        justify-content: center;
        align-items: center;
        padding: 40px 20px;
    }
    .employee-form {
        width: 100%;
        max-width: 600px;
        background: #f9f9f9;
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        font-family: Arial, sans-serif;
    }
    .employee-form label {
        display: block;
        margin: 10px 0 5px;
        font-weight: bold;
    }
    .employee-form input[type="text"],
    .employee-form input[type="email"],
    .employee-form select {
        width: 100%;
        padding: 10px 12px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 5px;
        font-size: 14px;
        box-sizing: border-box;
    }
    .employee-form button {
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
    .employee-form button:hover {
        background-color: #1fa1a0;
    }
</style>

<div class="employee-form-container">
    <div class="employee-form">

        <!-- Form action depends on create or edit -->
        <c:choose>
            <c:when test="${isEdit}">
                <form action="/employees/update/${employee.id}" method="post">
            </c:when>
            <c:otherwise>
                <form action="/employees/save" method="post">
            </c:otherwise>
        </c:choose>

            <label>Code:</label>
            <input type="text" name="code" value="${employee.code}" required/>

            <label>First Name:</label>
            <input type="text" name="firstName" value="${employee.firstName}" required/>

            <label>Last Name:</label>
            <input type="text" name="lastName" value="${employee.lastName}" required/>

            <label>Email:</label>
            <input type="email" name="email" value="${employee.email}" required/>

            <label>Phone:</label>
            <input type="text" name="phone" value="${employee.phone}" required/>

            <label>Designation:</label>
            <input type="text" name="designation" value="${employee.designation}" />

            <label>Status:</label>
            <select name="status" required>
                <option value="ACTIVE" ${employee.status=='ACTIVE' ? 'selected' : ''}>ACTIVE</option>
                <option value="INACTIVE" ${employee.status=='INACTIVE' ? 'selected' : ''}>INACTIVE</option>
            </select>

            <label>Branch:</label>
            <select name="branchId" required>
                <option value="">--Select Branch--</option>
                <c:forEach var="b" items="${branches}">
                    <option value="${b.id}" ${b.id eq employee.branchId ? 'selected' : ''}>${b.name}</option>
                </c:forEach>
            </select>

            <button type="submit">
                <c:choose>
                    <c:when test="${isEdit}">Update</c:when>
                    <c:otherwise>Save</c:otherwise>
                </c:choose>
            </button>
        </form>
    </div>
</div>