<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List"  %>
       <%@ page import="eregistro.bean.Alumno"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% List<Alumno> grupo1 = (List<Alumno>)request.getAttribute("grupo1"); %>
<table width="200" border="1">
Grupo 1
  <tr>
    <td>Codigo</td>
    <td>Nombre</td>
    <td>Apellido Paterno</td>
    <td>Apellido Materno</td>
     <td>Nro_cre_aprobados</td>
      <td>Promedio</td>
      <td>Cursos</td>
  </tr>
  <% if(grupo1 !=null && grupo1 .size()>0){
	   for(Alumno alumno : grupo1){%>
  <tr>
    <td><%=alumno.getID_Alumno()%></td>
    <td><%=alumno.getNombre()%></td>
    <td><%=alumno.getApellido_Paterno()%></td>
    <td><%=alumno.getApellido_Materno()%></td>
    <td><%=alumno.getNro_Cre_Aprobados()%></td>
    <td><%=alumno.getPromedio()%></td>
    <td><%=alumno.getID_Curso()%></td>
  </tr>
   <% }
     }else{%>
      <tr>
    <td colspan="4"><div align="center" class="style1">No existen registros </div></td>
  </tr>
    <% }	  
   %>
</table>


<% List<Alumno> grupo2 = (List<Alumno>)request.getAttribute("grupo2"); %>
<table width="200" border="1">
Grupo 2
  <tr>
    <td>Codigo</td>
    <td>Nombre</td>
    <td>Apellido Paterno</td>
    <td>Apellido Materno</td>
     <td>Nro_cre_aprobados</td>
      <td>Promedio</td>
      <td>Cursos</td>
  </tr>
  <% if(grupo2 !=null && grupo2 .size()>0){
	   for(Alumno alumno : grupo2){%>
  <tr>
    <td><%=alumno.getID_Alumno()%></td>
    <td><%=alumno.getNombre()%></td>
    <td><%=alumno.getApellido_Paterno()%></td>
    <td><%=alumno.getApellido_Materno()%></td>
    <td><%=alumno.getNro_Cre_Aprobados()%></td>
    <td><%=alumno.getPromedio()%></td>
   <td><%=alumno.getID_Curso()%></td>
    
  </tr>
   <% }
     }else{%>
      <tr>
    <td colspan="4"><div align="center" class="style1">No existen registros </div></td>
  </tr>
    <% }	  
   %>
</table>





<% List<Alumno> grupo3 = (List<Alumno>)request.getAttribute("grupo3"); %>
<table width="200" border="1">
Grupo 3
  <tr>
    <td>Codigo</td>
    <td>Nombre</td>
    <td>Apellido Paterno</td>
    <td>Apellido Materno</td>
     <td>Nro_cre_aprobados</td>
      <td>Promedio</td>
      <td>Cursos</td>
  </tr>
  <% if(grupo3 !=null && grupo3 .size()>0){
	   for(Alumno alumno : grupo3){%>
  <tr>
    <td><%=alumno.getID_Alumno()%></td>
    <td><%=alumno.getNombre()%></td>
    <td><%=alumno.getApellido_Paterno()%></td>
    <td><%=alumno.getApellido_Materno()%></td>
    <td><%=alumno.getNro_Cre_Aprobados()%></td>
    <td><%=alumno.getPromedio()%></td>
    <td><%=alumno.getID_Curso()%></td>
    
  </tr>
   <% }
     }else{%>
      <tr>
    <td colspan="4"><div align="center" class="style1">No existen registros </div></td>
  </tr>
    <% }	  
   %>
</table>



<% List<Alumno> grupo4 = (List<Alumno>)request.getAttribute("grupo4"); %>
<table width="200" border="1">
Grupo 4
  <tr>
    <td>Codigo</td>
    <td>Nombre</td>
    <td>Apellido Paterno</td>
    <td>Apellido Materno</td>
     <td>Nro_cre_aprobados</td>
      <td>Promedio</td>
      <td>Cursos</td>
  </tr>
  <% if(grupo4 !=null && grupo4 .size()>0){
	   for(Alumno alumno : grupo4){%>
  <tr>
    <td><%=alumno.getID_Alumno()%></td>
    <td><%=alumno.getNombre()%></td>
    <td><%=alumno.getApellido_Paterno()%></td>
    <td><%=alumno.getApellido_Materno()%></td>
    <td><%=alumno.getNro_Cre_Aprobados()%></td>
    <td><%=alumno.getPromedio()%></td>
 <td><%=alumno.getID_Curso()%></td>
  </tr>
   <% }
     }else{%>
      <tr>
    <td colspan="4"><div align="center" class="style1">No existen registros </div></td>
  </tr>
    <% }	  
   %>
</table>



<% List<Alumno> grupo5 = (List<Alumno>)request.getAttribute("grupo5"); %>
<table width="200" border="1">
Grupo 5
  <tr>
    <td>Codigo</td>
    <td>Nombre</td>
    <td>Apellido Paterno</td>
    <td>Apellido Materno</td>
     <td>Nro_cre_aprobados</td>
      <td>Promedio</td>
      <td>Cursos</td>
  </tr>
  <% if(grupo5 !=null && grupo5 .size()>0){
	   for(Alumno alumno : grupo5){%>
  <tr>
    <td><%=alumno.getID_Alumno()%></td>
    <td><%=alumno.getNombre()%></td>
    <td><%=alumno.getApellido_Paterno()%></td>
    <td><%=alumno.getApellido_Materno()%></td>
    <td><%=alumno.getNro_Cre_Aprobados()%></td>
    <td><%=alumno.getPromedio()%></td>
  <td><%=alumno.getID_Curso()%></td>
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