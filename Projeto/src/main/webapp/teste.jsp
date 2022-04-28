<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Testes JSP</title>
</head>
<body>
<jsp:useBean id="funcionario" class="br.com.vemprafam.pojo.Funcionario"/>
${funcionario.nome}
<jsp:useBean id="dao" class="br.com.vemprafam.dao.DaoFuncionario"/>
${dao.funcionarios}
</body>
</html>