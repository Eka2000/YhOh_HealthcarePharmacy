<h2 style="text-align:center;">New Branch Details</h2>

<style>
    /* Center the form on the page */
    .branch-form-container {
        display: flex;
        justify-content: center;
        align-items: center;
        padding: 40px 20px;
    }

    /* Form styling */
    .branch-form {
        width: 100%;
        max-width: 600px;
        background: #f9f9f9;
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        font-family: Arial, sans-serif;
    }

    /* Form labels and inputs */
    .branch-form label {
        display: block;
        margin: 10px 0 5px;
        font-weight: bold;
    }

    .branch-form input[type="text"],
    .branch-form textarea,
    .branch-form select {
        width: 100%;
        padding: 10px 12px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 5px;
        font-size: 14px;
        box-sizing: border-box;
    }

    .branch-form textarea {
        resize: vertical;
        height: 60px;
    }

    /* Checkbox styling */
    .branch-form .checkbox-container {
        display: flex;
        align-items: center;
        margin-bottom: 20px;
    }

    .branch-form .checkbox-container input {
        margin-right: 10px;
    }

    /* Primary button */
    .branch-form button {
        background-color: #27D1D0; /* Updated primary color */
        color: white;
        padding: 12px;
        border: none;
        border-radius: 5px;
        font-size: 16px;
        cursor: pointer;
        transition: background 0.3s ease;
        width: 100%; /* Full width button */
    }

    .branch-form button:hover {
        background-color: #1fa1a0; /* Slightly darker on hover */
    }
</style>

<div class="branch-form-container">
    <div class="branch-form">
        <form action="${isEdit ? '/branches/update/' + branch.id : '/branches/save'}" method="post">
            <label>Code:</label>
            <input type="text" name="code" value="${branch.code}" required/>

            <label>Name:</label>
            <input type="text" name="name" value="${branch.name}" required/>

            <label>Address:</label>
            <textarea name="address">${branch.address}</textarea>

            <label>City:</label>
            <input type="text" name="city" value="${branch.city}"/>

            <label>State:</label>
            <input type="text" name="state" value="${branch.state}"/>

            <label>Country:</label>
            <input type="text" name="country" value="${branch.country}"/>

            <label>Pincode:</label>
            <input type="text" name="pincode" value="${branch.pincode}"/>

            <label>Contact Number:</label>
            <input type="text" name="contactNumber" value="${branch.contactNumber}"/>

            <label>Status:</label>
            <select name="status">
                <option value="ACTIVE" ${branch.status=='ACTIVE' ? 'selected' : ''}>ACTIVE</option>
                <option value="INACTIVE" ${branch.status=='INACTIVE' ? 'selected' : ''}>INACTIVE</option>
            </select>

            <div class="checkbox-container">
                <input type="checkbox" name="parentBranch" ${branch.parentBranch ? 'checked' : ''}/>
                <label>Parent Branch</label>
            </div>

            <button type="submit">Save</button>
        </form>
    </div>
</div>
