<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SAITH - LOGIN</title>
<%@include file="partial/estilos.txt" %>
<link rel="stylesheet" href="styles/signin.css" />
</head>
<body>
 <div class="container">
      <form class="form-signin">
        <h2 class="form-signin-heading">SAITH</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <div class="checkbox hidden">
          <label>
            <input type="checkbox"  value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>
    </div>
</body>
</html>