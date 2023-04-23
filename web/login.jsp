<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <%@include file="head.jsp"%>
</head>
<body>

    <%@include file="navbar.jsp"%>
    <% if (request.getParameter("error") != null) { %>
    <div class="row">
        <div class="alert alert-danger alert-dismissible fade show" role="alert">
            Incorrect <strong>password</strong> or <strong>email</strong>.
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    </div>
    <% } %>

    <div class="container w-50">
        <form action="/login" method="post">
            <div class="row text-bg-light border border-opacity-50 rounded-top py-1">
                <h2>LogIn Page</h2>
            </div>
            <div class="row border border-opacity-50 rounded-bottom border-top-0">
                <div class="my-3 row">
                    <label for="staticEmail" class="col-sm-2 col-form-label">Email</label>
                    <div class="col-10">
                        <input type="email" class="form-control" id="staticEmail" name="email">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label class="col-sm-2 col-form-label">Password</label>
                    <div class="col-10">
                        <input type="password" class="form-control" name="password">
                    </div>
                </div>
                <div class="mb-3 row">
                    <div class="col-3">
                        <button type="submit" class="btn btn-success">Login</button>
                    </div>
                </div>
            </div>
        </form>
    </div>

</body>
</html>
