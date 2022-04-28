<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.com.vemprafam.pojo.Funcionario"%>
<%@page import="java.util.List"%>
<%@page import="br.com.vemprafam.dao.DaoFuncionario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Funcionários</title>
</head>
<body>
<table border="1">
<tr><th>RE</th><th>nome</th><th>salário</th><th>data de nascimento</th></tr>
<%
DaoFuncionario dao = new DaoFuncionario();
List<Funcionario> funcionarios = dao.getFuncionarios();
SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
for( Funcionario f: funcionarios ) {
	String salario = currencyFormat.format(f.getSalario());
	String dataNascimento = dateFormat.format(f.getDataNascimento());
%>
<tr>
	<td><%=f.getRe()%></td>
	<td><%=f.getNome()%></td>
	<td><%=salario%></td>
	<td><%=dataNascimento%></td>
</tr>
<%
}
%>
</table>
<a href="/Projeto">voltar</a>
</body>
</html>