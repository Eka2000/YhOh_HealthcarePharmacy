<h2 style="margin-bottom: 20px;">Branch List</h2>

<style>
    /* New Branch Button */
    .btn-primary {
        background-color: #27D1D0;
        color: #fff;
        text-decoration: none;
        padding: 10px 18px;
        border-radius: 5px;
        font-weight: bold;
        float: right;
        transition: background 0.3s ease;
    }

    .btn-primary:hover {
        background-color: #1fa1a0;
    }

    /* Clear float */
    .clearfix::after {
        content: "";
        display: table;
        clear: both;
    }

    /* Table Styling */
    table.branch-table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 60px; /* space below button */
        font-family: Arial, sans-serif;
        box-shadow: 0 2px 5px rgba(0,0,0,0.1);
    }

    table.branch-table th, table.branch-table td {
        border: 1px solid #ccc;
        padding: 12px 15px;
        text-align: left;
        font-size: 14px;
    }

    table.branch-table th {
        background-color: #f0f0f0;
        font-weight: bold;
    }

    table.branch-table tr:nth-child(even) {
        background-color: #f9f9f9;
    }

    table.branch-table tr:hover {
        background-color: #e6f7f7; /* subtle hover effect */
    }

    /* Action links styling */
    .action-links a {
        color: #27D1D0;
        text-decoration: none;
        font-weight: bold;
        margin-right: 8px;
    }

    .action-links a:hover {
        color: #1fa1a0;
        text-decoration: underline;
    }

    /* Responsive table scroll */
    .table-responsive {
        overflow-x: auto;
    }
</style>

<div class="clearfix">
    <a href="/branches/createBranch" class="btn-primary">New Branch</a>
</div>

<div class="table-responsive">
    <table class="branch-table">
        <thead>
            <tr>
                <th>Code</th>
                <th>Name</th>
                <th>Address</th>
                <th>City</th>
                <th>State</th>
                <th>Country</th>
                <th>Pincode</th>
                <th>Contact Number</th>
                <th>Status</th>
                <th>Parent Branch</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="b" items="${branches}">
                <tr>
                    <td><c:out value="${b.code}" /></td>
                    <td><c:out value="${b.name}" /></td>
                    <td><c:out value="${b.address}" /></td>
                    <td><c:out value="${b.city}" /></td>
                    <td><c:out value="${b.state}" /></td>
                    <td><c:out value="${b.country}" /></td>
                    <td><c:out value="${b.pincode}" /></td>
                    <td><c:out value="${b.contactNumber}" /></td>
                    <td><c:out value="${b.status}" /></td>
                    <td>
    					<c:choose>
        				<c:when test="${b.parentBranch}">Yes</c:when>
        				<c:otherwise>No</c:otherwise>
    					</c:choose>
					</td>
                    <td class="action-links">
                        <a href="/branches/edit/${b.id}">Edit</a>
                        <a href="/branches/delete/${b.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
