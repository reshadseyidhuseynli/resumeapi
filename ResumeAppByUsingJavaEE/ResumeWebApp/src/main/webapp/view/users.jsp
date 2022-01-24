<%@page import="java.util.List"%>
<%@page import="mycompany.main.Context"%>
<%@page import="com.company.entity.User"%>
<%@page import="com.company.inter.UserDAOInter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            .mycontainer{
                width: 10%;
                margin:0 auto 10px auto;
            }
        </style>
        <script src="https://kit.fontawesome.com/12594b404f.js" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>Users Page</title>
    </head>
    <body>

        <%
            User user = (User) session.getAttribute("loggedInUser");
            List<User> list = (List<User>) request.getAttribute("list");
        %>
    <center>
        <h5><%="Welcome " + user.getName()%></h5>
    </center>
    <div style="margin: 0 0 0 1150px">
        <form action="logout" method="POST">
            <button class="btn btn-secondary" type="submit" name="logout">Log out</button>
        </form>
    </div>
    <div class="container col-12">
        <div  class="col-4">
            <form action="users" method="GET">
                <div class="form-group">
                    <label class="mycontainer" for="name">name:</label>
                    <input class="form-control" placeholder="Enter Name" type="text" name="name" value=""/>
                </div>
                <div class="form-group">
                    <label class="mycontainer" for="surname">surname:</label>
                    <input class="form-control" placeholder="Enter Surname" type="text" name="surname" value=""/>
                </div>
                <br/>
                <input class="btn btn-primary" type="submit" name="search" value="Search"/>
            </form>
        </div>

        <div>
            <table class="table">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Name</th>
                        <th>Surname</th>
                        <th></th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>

                    <%
                        for (int i = 0; i < list.size(); i++) {
                            User u = list.get(i);
                    %>
                    <tr>
                        <td><%=i + 1%></td>
                        <td><%=u.getName()%></td>
                        <td><%=u.getSurname()%></td>
                        <td style="width:5px">
                            <form action="userdetail" method="POST">
                                <button class="btn btn-danger" type="button">
                                    <input type="hidden" name="id" value="<%=u.getId()%>"/>
                                    <input type="hidden" name="action" value="delete"/>
                                    <i class="fas fa-user-times"></i>
                                </button>
                            </form>
                        </td>
                        <td style="width:5px">
                            <form action="userdetail" method="GET">
                                <button class="btn btn-secondary" type="submit">
                                    <input type="hidden" name="id" value="<%=u.getId()%>"/>
                                    <input type="hidden" name="action" value="update"/>
                                    <i class="fas fa-user-edit"></i>
                                </button>
                            </form>
                        </td>
                        <td style="width:5px">
                            <form action="userinfo" method="GET">
                                <button class="btn btn-primary" type="submit">
                                    <input type="hidden" name="id" value="<%=u.getId()%>"/>
                                    <input type="hidden" name="action" value="info"/>
                                    <i class="fas fa-address-card"></i>
                                </button>
                            </form>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
