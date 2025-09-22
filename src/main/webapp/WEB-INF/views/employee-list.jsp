<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2 style="text-align:center;">Employee List</h2>

<div style="padding:20px; display:flex; justify-content:flex-end; align-items:center;">
    <a href="/employees/new" 
       style="background:#27D1D0; color:white; padding:10px 15px; border-radius:5px; text-decoration:none;">
       + New Employee
    </a>
</div>

<div style="padding:0 20px;">
    <table border="1" width="100%" cellpadding="8" cellspacing="0" style="border-collapse:collapse; text-align:left;">
        <tr style="background:#27D1D0; color:white;">
            <th>S.No</th>
            <th>Code</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Designation</th>
            <th>Status</th>
            <th>Branch</th>
            <th>Actions</th>
            <th>User Account</th>
        </tr>
        <c:forEach var="emp" items="${employees}" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${emp.code}</td>
                <td>${emp.firstName} ${emp.lastName}</td>
                <td>${emp.email}</td>
                <td>${emp.phone}</td>
                <td>${emp.designation}</td>
                <td>${emp.status}</td>
                <td>${emp.branchName}</td>
                <td>
                    <a href="/employees/edit/${emp.id}" style="color:green; font-weight:bold;">Edit</a> |
                    <a href="/employees/delete/${emp.id}" style="color:red; font-weight:bold;" 
                       onclick="return confirm('Are you sure to delete this employee?');">Delete</a>
                </td>
                <td style="text-align:center;">
                    <!-- User account creation icon (you can replace with an actual icon image if needed) -->
                    <a href="/useraccount/create/${emp.id}" title="Create User Account" style="color:#27D1D0; font-size:18px; font-weight:bold;">&#128100;</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>