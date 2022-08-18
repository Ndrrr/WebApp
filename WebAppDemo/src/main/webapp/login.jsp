<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String msg = request.getParameter("msg");
    String empty = "";
%>
<html>
<head>
    <title>Login</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">

</head>
    <body>
        <div class="container d-flex justify-content-center">
            <form action="login" method="post">
                <h2 class="text-center">Login</h2>
                <div class="form-group">
                    <label for="username">Email</label>
                    <input type="text" class="form-control" id="username" name="email" placeholder="Enter email">
                </div>
                <div class="form-group">

                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="Enter password">
                </div>
                <button type="submit" class="btn btn-primary" name="action" value="login">Login</button>
                <a href="register" class="p-sm-3">Don't have an account??</a>
                <p class="text-danger p-2"><%=(msg == null ?empty:msg)%></p>
            </form>
        </div>

    </body>
</html>
