<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Healthcare Pharmacy</title>
    <style>
        body { 
            margin: 0; 
            font-family: Arial, sans-serif; 
            display: flex;
        }

        /* Sidebar container */
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

        /* Top section: company name */
        .sidebar .top {
            text-align: center;
        }

        .sidebar .top h1 {
            font-size: 26px;
            margin: 0;
        }

        .sidebar .top h2 {
            font-size: 16px;
            margin: 5px 0 20px 0;
            font-weight: normal;
        }

        /* Middle section: menu */
        .sidebar .menu a {
            display: block;
            margin: 12px 0;
            color: #fff;
            text-decoration: none;
            font-weight: bold;
            padding: 8px 12px;
            border-radius: 5px;
            transition: background 0.3s ease;
        }

        .sidebar .menu a:hover {
            background-color: #1fa1a0; /* hover color */
        }

        /* Bottom section: user info */
        .sidebar .bottom {
            text-align: center;
            margin-top: 20px;
        }

        .sidebar .bottom span {
            display: block;
            margin-bottom: 8px;
        }

        .sidebar .bottom a {
            color: #fff;
            text-decoration: none;
            font-weight: bold;
            padding: 5px 10px;
            border-radius: 5px;
            background-color: #1fa1a0;
            transition: background 0.3s ease;
        }

        .sidebar .bottom a:hover {
            background-color: #0d7373;
        }

        /* Main content area */
        .content {
            margin-left: 240px; /* same as sidebar width + padding */
            padding: 20px;
            flex: 1;
        }

       /*  .topbar {
            background: #f8f8f8;
            padding: 10px 20px;
            border-bottom: 1px solid #ddd;
        } */
    </style>
</head>
<body>

<div class="sidebar">
    <!-- Top section -->
    <div class="top">
        <h1 style="font-family:Oblique;">YhOh</h1>
        <h2>Healthcare Pharmacy</h2>
    </div>

    <!-- Menu section -->
    <div class="menu">
        <a href="/branches">Branches</a>
        <a href="/employees">Employees</a>
        <a href="/inventory">Inventory</a>
    </div>

    <!-- Bottom section -->
    <div class="bottom">
        <span>Welcome, <c:out value="${username}" /></span>
        <a href="/logout">Logout</a>
    </div>
</div>

<!-- Main content -->
<div class="content">
    <%-- <div class="topbar">
        <h2><c:out value="${pageTitle}" /></h2>
    </div> --%>
    
    <!-- Include dynamic page content -->
    <jsp:include page="${body}" />
</div>

</body>
</html>
