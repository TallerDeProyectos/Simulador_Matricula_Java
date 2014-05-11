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
  <tr>
    <td>Codigo</td>
    <td>Nombre</td>
    <td>Apellido Paterno</td>
    <td>Apellido Materno</td>
     <td>Nro_cre_aprobados</td>
      <td>Promedio</td>
  </tr>
  <% if(grupo1 !=null && grupo1 .size()>0){
	   for(Alumno alumno : grupo1){%>
  <tr>
    <td><%=alumno.getID_Alumno()%></td>
    <td><%=alumno.getNombre()%></td>
    <td><%=alumno.getApellido_Paterno()%></td>
    <td><%=alumno.getApellido_Materno()%></td>
    <td><%=alumno.getNro_cre_aprobados()%></td>
    <td><%=alumno.getPromedio()%></td>
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