<%@page import="com.company.entity.User"%>
<%@page import="mycompany.main.Context"%>
<%@page import="com.company.inter.UserDAOInter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Info Page</title>
    </head>
    <body>
        
        <%
            User u = (User) request.getAttribute("user");
        %>
        
        <h1><%=u.getName()%></h1><h1><%=u.getSurname()%></h1>
        <p>ID: <%=u.getId()%></p>
        <p>Email: <%=u.getEmail()%></p>
        <p>Phone: <%=u.getPhone()%></p>
        <p>Profile Description: <%=u.getProfileDescription()%></p>
        <p>Address: <%=u.getAddress()%></p>
        <p>Birth Date: <%=u.getBirthDate()%></p>
        <p>Country Name: <%=u.getCountryId().getCountryName()%></p>
        <p>Nationality: <%=u.getNationalityId().getNationality()%></p>
    </body>
</html>
