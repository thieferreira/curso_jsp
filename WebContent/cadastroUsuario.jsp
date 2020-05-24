<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Usuário</title>
</head>
<body>
<h1>Cadastro de novos usuários</h1>


<form action="cadastroUsuario" method="post">
					<p>
						<label for="id_login" >Id: </label> 
						<input id="id_login"
							name="id_login" readonly="readonly" type="text"
							 value="${user.id }"/>
					</p>
					
					<p>
						<label for="novo_login">Login: </label> 
						<input id="novo_login"
							name="novo_login" required="required" type="text"
							placeholder="ex. contato@htmlecsspro.com" value="${user.login }"/>
					</p>

					<p>
						<label for="nova_senha">Senha: </label> 
						<input id="nova_senha"
							name="nova_senha" required="required" type="password"
							placeholder="ex. senha" value="${user.senha }"/>
					</p>

					<p>
						<input type="submit" value="cadastrar" />
					</p>


</form>

<table>
<c:forEach items="${usuarios}" var="user">
<tr>
<td style="width: 150px"><c:out value="${user.login}"></c:out></td>
<td style="width: 150px"><c:out value="${user.senha}"></c:out></td>
<td style="width: 150px"><c:out value="${user.id }"></c:out></td>
<td><a href="cadastroUsuario?acao=delete&user=${user.login}">Excluir</a></td>
<td><a href="cadastroUsuario?acao=editar&user=${user.login}">Editar</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>