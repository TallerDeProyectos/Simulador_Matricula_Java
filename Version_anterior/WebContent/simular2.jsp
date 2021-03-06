<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List"  %>
       <%@ page import="eregistro.bean.Alumno"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<script src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.tablesorter.js"></script>
<link href="css/styletable.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
$(document).ready(function() 
    { 
        $("#myTable").tablesorter( {sortList: [[0,0], [1,0]]} ); 
    } 
);
</script> 


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% List<Alumno> grupo1 = (List<Alumno>)request.getAttribute("grupo1"); %>
<table width="200" border="1" id="myTable" class="tablesorter">
Lunes
<thead>
  <tr>
    <th>Codigo</th>
    <th>Nombre</th>
    <th>Apellido Paterno</th>
    <th>Apellido Materno</th>
     <th>Creditos Aprobados</th>
      <th>Promedio</th>
      <th>Cursos</th>
      <th>Seccion</th>
  </tr>
  </thead>
  <% if(grupo1 !=null && grupo1 .size()>0){
	   for(Alumno alumno : grupo1){%>
  <tr>
    <td><%=alumno.getID_Alumno()%></td>
    <td><%=alumno.getNombre()%></td>
    <td><%=alumno.getApellido_Paterno()%></td>
    <td><%=alumno.getApellido_Materno()%></td>
    <td><%=alumno.getNro_Cre_Aprobados()%></td>
    <td><%=alumno.getPromedio()%></td>
    <td><%=alumno.getDesc_Curso()%></td>
    <td><%=alumno.getID_Seccion()%></td>
  </tr>
   <% }
     }else{%>
      <tr>
    <td colspan="8"><div align="center">No existen registros </div></td>
  </tr>
    <% }	  
   %>
</table>


<% List<Alumno> grupo2 = (List<Alumno>)request.getAttribute("grupo2"); %>
<table width="200" border="1" id="myTable" class="tablesorter">
Martes
<thead>
  <tr>
    <th>Codigo</th>
    <th>Nombre</th>
    <th>Apellido Paterno</th>
    <th>Apellido Materno</th>
     <th>Creditos Aprobados</th>
      <th>Promedio</th>
      <th>Cursos</th>
      <th>Seccion</th>
  </tr>
  </thead>
  <% if(grupo2 !=null && grupo2 .size()>0){
	   for(Alumno alumno : grupo2){%>
  <tr>
    <td><%=alumno.getID_Alumno()%></td>
    <td><%=alumno.getNombre()%></td>
    <td><%=alumno.getApellido_Paterno()%></td>
    <td><%=alumno.getApellido_Materno()%></td>
    <td><%=alumno.getNro_Cre_Aprobados()%></td>
    <td><%=alumno.getPromedio()%></td>
   <td><%=alumno.getDesc_Curso()%></td>
    <td><%=alumno.getID_Seccion()%></td>
    
  </tr>
   <% }
     }else{%>
      <tr>
    <td colspan="8"><div align="center">No existen registros </div></td>
  </tr>
    <% }	  
   %>
</table>





<% List<Alumno> grupo3 = (List<Alumno>)request.getAttribute("grupo3"); %>
<table width="200" border="1" id="myTable" class="tablesorter">
Miercoles
<thead>
  <tr>
    <th>Codigo</th>
    <th>Nombre</th>
    <th>Apellido Paterno</th>
    <th>Apellido Materno</th>
     <th>Creditos Aprobados</th>
      <th>Promedio</th>
      <th>Cursos</th>
      <th>Seccion</th>
      
  </tr>
  </thead>
  <% if(grupo3 !=null && grupo3 .size()>0){
	   for(Alumno alumno : grupo3){%>
  <tr>
    <td><%=alumno.getID_Alumno()%></td>
    <td><%=alumno.getNombre()%></td>
    <td><%=alumno.getApellido_Paterno()%></td>
    <td><%=alumno.getApellido_Materno()%></td>
    <td><%=alumno.getNro_Cre_Aprobados()%></td>
    <td><%=alumno.getPromedio()%></td>
    <td><%=alumno.getDesc_Curso()%></td>
    <td><%=alumno.getID_Seccion()%></td>
    
  </tr>
   <% }
     }else{%>
      <tr>
    <td colspan="8"><div align="center">No existen registros </div></td>
  </tr>
    <% }	  
   %>
</table>



<% List<Alumno> grupo4 = (List<Alumno>)request.getAttribute("grupo4"); %>
<table width="200" border="1" id="myTable" class="tablesorter">
Jueves
<thead>
  <tr>
    <th>Codigo</th>
    <th>Nombre</th>
    <th>Apellido Paterno</th>
    <th>Apellido Materno</th>
     <th>Creditos Aprobados</th>
      <th>Promedio</th>
      <th>Cursos</th>
      <th>Seccion</th>
  </tr>
  </thead>
  <% if(grupo4 !=null && grupo4 .size()>0){
	   for(Alumno alumno : grupo4){%>
  <tr>
    <td><%=alumno.getID_Alumno()%></td>
    <td><%=alumno.getNombre()%></td>
    <td><%=alumno.getApellido_Paterno()%></td>
    <td><%=alumno.getApellido_Materno()%></td>
    <td><%=alumno.getNro_Cre_Aprobados()%></td>
    <td><%=alumno.getPromedio()%></td>
 <td><%=alumno.getDesc_Curso()%></td>
    <td><%=alumno.getID_Seccion()%></td>
  </tr>
   <% }
     }else{%>
      <tr>
    <td colspan="8"><div align="center">No existen registros </div></td>
  </tr>
    <% }	  
   %>
</table>



<% List<Alumno> grupo5 = (List<Alumno>)request.getAttribute("grupo5"); %>
<table width="200" border="1" id="myTable" class="tablesorter">
Viernes
<thead>
  <tr>
    <th>Codigo</th>
    <th>Nombre</th>
    <th>Apellido Paterno</th>
    <th>Apellido Materno</th>
     <th>Creditos Aprobados</th>
      <th>Promedio</th>
      <th>Cursos</th>
      <th>Seccion</th>
  </tr>
  </thead>
  <% if(grupo5 !=null && grupo5 .size()>0){
	   for(Alumno alumno : grupo5){%>
  <tr>
    <td><%=alumno.getID_Alumno()%></td>
    <td><%=alumno.getNombre()%></td>
    <td><%=alumno.getApellido_Paterno()%></td>
    <td><%=alumno.getApellido_Materno()%></td>
    <td><%=alumno.getNro_Cre_Aprobados()%></td>
    <td><%=alumno.getPromedio()%></td>
  <td><%=alumno.getDesc_Curso()%></td>
    <td><%=alumno.getID_Seccion()%></td>
  </tr>
   <% }
     }else{%>
      <tr>
    <td colspan="8"><div align="center">No existen registros </div></td>
  </tr>
    <% }	  
   %>
</table>

</body>
</html>