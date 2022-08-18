<%@ page import="dao.concrete.UserDao" %>
<%@ page import="model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.stream.Stream" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    UserDao userDao = new UserDao();
    User currentUser = (User)request.getSession().getAttribute("user");
    String empty = "";
%>
<html>
    <head>
        <title>Title</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/634df3b099.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
        <script src="assets/js/users.js"></script>
    </head>
    <body>
    <p >Logged in as: <%=currentUser!=null? currentUser.getName():empty %></p>
        <form method="post" action="common">
            <button type="submit" class="btn btn-primary" name="action" value="logout">Logout</button>
        </form>
        <div class="container">

            <table class="table">
                <thead>
                <tr class="row">
                    <th class = "col">#</th>
                    <th class = "col">Name</th>
                    <th class = "col">Surname</th>
                    <th class = "col">Email</th>
                    <th class = "col">Phone</th>
                    <th class = "col">Operations</th>
                </tr>
                </thead>
                <tbody>
                <%
                    List<User> users = userDao.getAll();%>
                <%for(User user : users) { %>
                <tr class="row justify-content-center">
                    <th class="col"><%=user.getId()%></th>
                    <td class="col"><%=user.getName()%></td>
                    <td class="col"><%=user.getSurname()%></td>
                    <td class="col"><%=user.getEmail()%></td>
                    <td class="col"><%=user.getPhone()%></td>
                    <td class="col">
                        <form action="user" method="get">
                            <input type="hidden" name="id" value="<%=user.getId()%>">
                            <button class="btn-secondary" type="submit" name="action" value="update">
                                <i class="fa-solid fa-pen-to-square"></i>
                            </button>
                        </form>
                        <button class="btn-danger" type="button" data-bs-toggle="modal" data-bs-target="#deleteModal" onclick="setIdForDelete(<%=user.getId()%>)">
                            <i class="fa-solid fa-trash-can"></i>
                        </button>

                    </td>
                </tr>
                <%};%>
                </tbody>
            </table>
            <div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="deleteModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="deleteModalLabel">Delete user</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            Are you sure?
                        </div>
                        <div class="modal-footer">
                            <form method="POST" action="users">
                                <input type="hidden" id="idForDelete" value="empty" name="id">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                <button type="submit" class="btn btn-danger" name="action" value="delete">Delete</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
