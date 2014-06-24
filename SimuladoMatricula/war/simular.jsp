<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List"  %>
       <%@ page import="com.taller.proyectos.bean.Matricula"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% List<Matricula> matriculas = (List<Matricula>)request.getAttribute("matriculas"); %>
<table width="200" border="1">
  <tr>
    <td>Codigo Alumno</td>
    <td>Nombre Alumno</td>
    <td>Ciclo Alumno</td>
    <td>Creditos Acumulados</td>
    <td>Codigo Curso</td>
    <td>Nombre Curso</td>
    <td>Ciclo Curso</td>
    <td>Credito Curso</td>
    <td>Prioridad</td>
    <td>Estado</td>
  </tr>
  <% if(matriculas!=null && matriculas.size()>0){
	   for(Matricula matricula : matriculas){%>
  <tr>
    <td><%=matricula.getId_Alumno()%></td>
    <td><%=matricula.getNombre_Alumno()%></td>
  	<td><%=matricula.getCiclo_Alumno()%></td>
    <td><%=matricula.getN_c_acu()%></td>
    <td><%=matricula.getId_Curso()%></td>
    <td><%=matricula.getNombre_Curso()%></td>
    <td><%=matricula.getCiclo_Curso()%></td>
    <td><%=matricula.getCredito_Curso()%></td>
    <td><%=matricula.getPrioridad()%></td>
    <td><%=matricula.getEstado_curso()%></td>
   
  </tr>
   <% }
     }else{%>
      <tr>
    <td colspan="4"><div align="center" class="style1">No existen registros </div></td>
  </tr>
    <% }	  
   %>
</table>

</body>
</html>