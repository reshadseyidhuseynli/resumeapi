<%@page import="mycompany.main.Context"%>
<%@page import="com.company.entity.User"%>
<%@page import="com.company.inter.UserDAOInter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>User Detail Page</title>
    </head>
    <body class="container">

        <%
            User u = (User) request.getAttribute("user");
        %>
        <div>
            <form action="userdetail" method="POST">
                <input type="hidden" name="action" value="update"/>
                <input type="hidden" name="id" value="<%=u.getId()%>"/>
                <div class="input-group-prepend">
                    <label for="name">name:</label>
                    <input class="form-control" type="text" name="name" value="<%=u.getName()%>"/>
                </div>
                <br/>
                <div>
                    <label for="surname">surname:</label>
                    <input class="form-control" type="text" name="surname" value="<%=u.getSurname()%>"/>
                </div>
                <br/>
                <div>
                    <label for="email">email:</label>
                    <input class="form-control" type="text" name="email" value="<%=u.getEmail()%>"/>
                </div>
                <br/>
                <div>
                    <label for="phone">phone:</label>
                    <input class="form-control" type="text" name="phone" value="<%=u.getPhone()%>"/>
                </div>
                <br/>
                <div>
                    <label for="profile description">profile description:</label>
                    <input class="form-control" type="text" name="profile description" value="<%=u.getProfileDescription()%>"/>
                </div>
                <br/>
                <div>
                    <label for="address">address:</label>
                    <input class="form-control" type="text" name="address" value="<%=u.getAddress()%>"/>
                </div>
                <br/>
                <div>
                    <label for="birth date">birth date:</label>
                    <input class="form-control" type="text" name="birthdate" value="<%=u.getBirthDate()%>"/>
                </div>
                <br/>
                <input class="btn btn-success" type="submit" name="save" value="Save"/>
            </form>
        </div>
    </body>
</html>
