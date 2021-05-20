<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CADASTRO DE FUNCIONARIOS</title>

</head>
<h1>CADASTRO DE FUNCIONARIOS</h1>
<body>
<form action= "SvFuncionarioCadastrar"method="get">
<label>nome:<input type=text name =nome > <br></label>
<label>cpf:<input type=text name=cpf > <br></label>
<label>tel:<input type="tel" name=tel > <br></label>
<label>cel:<input type=text name=cel > <br></label>
<label>idt:<input type=text name=idt ><br> </label> 
<label>email:<input type=text name=email > <br></label>
<input type="submit" name="salvar"value=salvar	>
<input type="reset"name = "redefinir" value= "limpar" >
<a href=pesquisarFuncionario.jsp >Pesquisar Funcionario</a><br>
</form>
<c:choose>
        <c:when test="${not empty alertMsg}">
            <p >${alertMsg}</p>
        </c:when>
    </c:choose>

</body>
</html>