<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker({dateFormat:'dd/mm/yy'});
  } );
  </script>
  <meta charset="ISO-8859-1">
  <title>Cadastro de Funcion�rio</title>
</head>
<body>
<form action="cadastrarFuncionario">
RE:<input type="text" name="re"/><br/>
nome:<input type="text" name="nome"/><br/>
sal�rio:<input type="text" name="salario"/><br/>
data de nascimento<input type="text" id="datepicker" name="dataNascimento"/><br/>
e-mail:<input type="text" name="email"/><br/>
<input type="submit" value="Enviar"> 
</form>
<a href="/Projeto">voltar</a>
</body>
</html>