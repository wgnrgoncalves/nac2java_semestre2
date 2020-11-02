<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SAITH - Novo Login</title>

<%@include file="../partial/estilos.txt"%>
</head>
<body>

	<div class="container body-content">
		<h2>Novo Funcionário</h2>
		<div class="alert alert-primary">
		<p>${erro}</p>
		</div>
		<form method="post" action="FuncionarioController" >
			<div class="form-group">
				<label for="nome">Nome</label> 
				<input type="text" class="form-control" id="nome" name="nome" placeholder="Nome" required />
			</div>
			<div class="form-group">
				<label for="email">Email</label> 
				<input type="email" class="form-control" id="email" name="email" placeholder="Email" required />
			</div>
			<div class="form-group">
				<label for="senha">Senha</label>
				<input type="password" class="form-control" id="senha" name="senha" placeholder="Password" required minlength="5"/>
			</div>
			
			<div class="form-group">
				<label for="tipoFuncionario">Tipo Funcionario</label>
				<select name="tipoFuncionario" id="tipoFuncionario" class="form-control" name="tipoFuncionario">
				  <option value="TECNICO">Técnico</option>
				  <option value="ENFERMEIRA">Enfermeira</option>
				  <option value="MEDICO">Médico</option>
				</select>
			</div>
			<button type="submit" class="btn btn-primary">Salvar</button>
		</form>
	</div>

</body>
</html>