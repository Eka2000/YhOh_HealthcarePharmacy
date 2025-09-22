<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2 style="text-align:center; margin-bottom: 20px;">Permission List</h2>

<div style="display: flex; justify-content: flex-end; padding: 0 0 20px 0;">
    <a href="/permissions/new" 
       style="background:#27D1D0; color:white; padding:10px 20px; border-radius:5px; text-decoration:none; font-weight:bold;">
       New Permission
    </a>
</div>

<table style="width:100%; border-collapse: collapse; text-align:center; font-family: Arial, sans-serif;">
    <thead>
        <tr style="background:#27D1D0; color:white; height:40px;">
            <th style="padding:10px;">S.No</th>
            <th style="padding:10px;">Name</th>
            <th style="padding:10px;">Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="p" items="${permissions}" varStatus="status">
            <tr style="height:35px; border-bottom: 1px solid #ddd;">
                <td>${status.index + 1}</td>
                <td>${p.name}</td>
                <td>
                    <a href="/permissions/edit/${p.id}" 
                       style="color:#27D1D0; text-decoration:none; margin-right:10px;">Edit</a>
                    <a href="/permissions/delete/${p.id}" 
                       style="color:red; text-decoration:none;" 
                       onclick="return confirm('Are you sure?');">Delete</a>
                </td>
            </tr>
        </c:forEach>
        <c:if test="${empty permissions}">
            <tr>
                <td colspan="3" style="padding:15px; color:#777;">No permissions found.</td>
            </tr>
        </c:if>
    </tbody>
</table>