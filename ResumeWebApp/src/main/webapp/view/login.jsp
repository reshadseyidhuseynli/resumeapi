<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>Login Page</title>
    </head>
    <body>
    <center>
        <h1>Login</h1>
    </center>
    <hr/>
    <div class="container">
        <form action="login" method="POST">
            <div class="form-floating mb-3">
                <input class="form-control" id="floatingInput" placeholder="name@example.com" type="email" name="email">
                <label for="floatingInput">Email address</label>
            </div>
            <div class="form-floating">
                <input class="form-control" id="floatingPassword" placeholder="Password" type="password" name="password">
                <label for="floatingPassword">Password</label>
            </div>
            <br/>
            <button class="btn btn-primary" type="submit">Login</button>
        </form>
    </div>
</body>
</html>
