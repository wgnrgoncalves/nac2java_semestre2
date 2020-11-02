<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SAITH - Cadastra Paciente</title>
<%@include file="../partial/estilos.txt"%>
</head>
<body>
	<%@include file="../partial/header.txt"%>

	<div class="container body-content">
		<form method="post" action="PacienteController">
			<h3>Cadastra paciente</h3>



			<div class="form-group">
				<label for="nome">Nome</label> 
				<input type="text" class="form-control" id="nome" name="nome" placeholder="Nome" required />
			</div>
			<div class="form-group">
				<label for="cpf">CPF</label>
				<input type="text" class="form-control"  name="cpf" id="cpf" placeholder="CPF" />
			</div>
			<div class="form-group">
				<label for="email">E-mail</label>
				<input type="email" class="form-control"  name="email" id="email" placeholder="E-mail" />
			</div>
			<div class="form-group">
				<label for="nascimento">Nascimento</label>
				<input type="date" class="form-control"  name="nascimento" id="nascimento" placeholder="Nascimento" />
			</div>
			
			<div class="form-group">
				<label for="responsavel">Responsável</label>
				<input type="text" class="form-control"  name="responsavel" id="responsavel" placeholder="Responsavel" />
			</div>
			<div class="form-group">
				<label for="telefone">Telefone</label>
				<input type="text" class="form-control"  name="telefone" id="telefone" placeholder="Telefone" />
			</div>
			<input type="submit" value="inclui" class="btn btn-primary"/>
		</form>
	</div>
	<%@include file="../partial/footer.txt"%>
</body>
</html>