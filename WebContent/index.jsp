<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tela de Login</title>
<link rel="stylesheet" type="text/css" href="style.css" />

</head>
<body>
<br>
<br>
<br>
<br>
<br>
	<div class="container">
		<a class="links" id="paracadastro"></a> <a class="links"
			id="paralogin"></a>

		<div class="content">
			<!--FORMULÁRIO DE LOGIN-->
			<div id="login">
				<form action="LoginServlet" method="post">
					<h1>Acesso ao Sistema</h1>
					<p>
						<label for="user_login">Seu Login</label> <input id="user_login"
							name="user_login" required="required" type="text"
							placeholder="ex. contato@htmlecsspro.com" />
					</p>

					<p>
						<label for="user_senha">Sua Senha</label> <input id="user_senha"
							name="user_senha" required="required" type="password"
							placeholder="ex. senha" />
					</p>

					<p>
						<input type="submit" value="Logar" />
					</p>


				</form>
			</div>

		</div>

	</div>
</body>
</html>