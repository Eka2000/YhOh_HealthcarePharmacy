<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Healthcare Pharmacy</title>
    <style>
        body { margin: 0; font-family: Arial, sans-serif; display: flex; }

        .sidebar {
            width: 220px;
            height: 100vh;
            background: #27D1D0;
            color: #fff;
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            position: fixed;
            top: 0;
            left: 0;
            padding: 20px;
            box-sizing: border-box;
        }
        .sidebar .top { text-align: center; }
        .sidebar .top h1 { font-size: 26px; margin: 0; font-family: Oblique; }
        .sidebar .top h2 { font-size: 16px; margin: 5px 0 20px 0; font-weight: normal; }

        .sidebar .menu a {
            display: block; margin: 12px 0; color: #fff; text-decoration: none; font-weight: bold;
            padding: 8px 12px; border-radius: 5px; transition: background 0.3s ease;
        }
        .sidebar .menu a:hover, .sidebar .menu a.active { background-color: #1fa1a0; }

        .sidebar .bottom { text-align: center; margin-top: 20px; }
        .sidebar .bottom span { display: block; margin-bottom: 8px; }
        .sidebar .bottom a {
            color: #fff; text-decoration: none; font-weight: bold; padding: 5px 10px; border-radius: 5px;
            background-color: #1fa1a0; transition: background 0.3s ease;
        }
        .sidebar .bottom a:hover { background-color: #0d7373; }

        .content { margin-left: 240px; padding: 20px; flex: 1; }
    </style>
</head>
<body>

<div class="sidebar">
    <div class="top">
        <h1>YhOh</h1>
        <h2>Healthcare Pharmacy</h2>
    </div>

    <div class="menu">
        <a href="<c:url value='/branches' />" class="${page eq 'branches' ? 'active' : ''}">Branches</a>
        <a href="<c:url value='/employees' />" class="${page eq 'employees' ? 'active' : ''}">Employees</a>
        <a href="<c:url value='/permissions' />" class="${page eq 'permissions' ? 'active' : ''}">Permissions</a>
         <a href="<c:url value='/roles' />" class="${page eq 'roles' ? 'active' : ''}">User Roles</a>
	</div>

    <div class="bottom">
        <span>Welcome, <c:out value="${username}" /></span>
        <a href="<c:url value='/logout' />">Logout</a>
    </div>
</div>

<div class="content">
    <jsp:include page="${body}" />
</div>

</body>
</html>