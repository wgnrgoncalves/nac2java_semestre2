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
 	<div class="alert alert-primary">
		<p>${erro}</p>
	</div>
      <form class="form-signin" method="post" action="loginController">
        <h2 class="form-signin-heading">SAITH</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="email" name="email" class="form-control" placeholder="Email" required autofocus>
        <label for="inputPassword" class="sr-only">Senha</label>
        <input type="password" id="senha" name="senha" class="form-control" placeholder="Senha" required>
        <div class="checkbox hidden">
          <label>
            <input type="checkbox"  value="remember-me"> Remember me
          </label>
        </div>
        <div class="row">
        <div class="col-md-4">
        <button class="btn btn-primary btn-block" type="submit">Login</button>
        </div>
        <div class="col-md-8">
        <a class="btn btn-primary btn-block" href="FuncionarioController">Novo Funcionário</a>
        </div>
        </div>
      </form>
    </div>
</body>
</html>