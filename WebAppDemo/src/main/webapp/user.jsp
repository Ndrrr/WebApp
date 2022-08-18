<%@ page import="dao.concrete.UserDao" %>
<%@ page import="model.User" %>
<%@ page import="com.example.webappdemo.util.UserUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User u = (User) request.getAttribute("user");
    Boolean success = Boolean.parseBoolean(request.getParameter("success"));
%>
<html>
    <head>
        <title>User</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link href="assets/css/style.css" rel="stylesheet" type="text/css">
        <script src="assets/js/user.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="container">


            <form method="post" action="user">
                <div class="form-group">

                    <p class="form-text">Current: <%=u.getName()%></p>
                    <input type="hidden" name="id" value="<%=u.getId()%>">
                    <label for="name">Name: </label>
                    <input class="form-control" type="text" id="name" name="name" value="<%=u.getName()%>"/>
                    <br>
                    <label for="surname">Surname: </label>
                    <input class="form-control" type="text" id="surname" name="surname" value="<%=u.getSurname()%>"/>
                    <br>
                    <label for="email">Email: </label>
                    <input class="form-control" type="email" id="email" name="email" value="<%=u.getEmail()%>"/>
                    <br>
                    <label for="phone">Phone: </label>
                    <input class="form-control" type="text" id="phone" name="phone" value="<%=u.getPhone()%>"/>
                    <br>
                    <input type="hidden" name="action" value="update">
                    <input class="btn btn-primary" type="submit" value="Submit">
                    <button type="button" class="btn btn-primary" onclick="getAllUsers()">Go Back</button>

                    <%
                        if(success){
                    %>
                        <p class="m-2 text-success">Successfully Updated</p>
                    <%}%>
                </div>
            </form>
        </div>
    </body>
</html>
