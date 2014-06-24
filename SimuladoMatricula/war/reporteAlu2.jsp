<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%@ page import="java.util.List" %>
<%@ page import="com.taller.proyectos.bean.AlumnoBean" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>
  	Simulacion de Matricula USMP
  </title>

  <link rel="stylesheet" type="text/css" href="./style.css">
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>

  <style type="text/css">
  section{
    height: 70%;
  }
.matri{
cursor: pointer;
background: #fff;
border: 2px solid #ddd;
padding: 50px 50px 50px 50px;
border-radius: 20px;
}
.sect{
width: 100%;
font-size: 20px;
text-align: left;
}
  </style>

</head>
<body>
<div id="page"> 
  <div id="header">
    <div class="left"><img src="./images/logo.jpg"></div>
    <div class="right"><br>Simulacion de Matricula USMP</div>
    
  </div>
            
  <div id="content">
    <div class="left col1">
      <section>
      
      <form style="width: 100%; height: 100%; text-align: center; line-height: 40;" action=/matricular method="POST" class="ciclo-form">
      	<input type="hidden" name="ciclo" value="1">
      	<input type="submit" style="display: none;" id="go">
      	<label class="matri" for="go">Simular Matr&iacute;cula</label>
      
      </form>
<!--         <a href="http://simulador-matricula.appspot.com/matricular?ciclo=1">Simular Matr&iacute;cula</a> -->

      </section>
    </div>
    <div class="left col2">
      <section class="sect">
      <%   String nombre = (String)request.getAttribute("nombre");%>
      
      
      
        <article style="position: relative;top: 10%;line-height: 30px; overflow: auto; height: 88%; font-size: 16px;">
		<label style="font-size: 20px;"><%=nombre %></label>
          <%
			List<AlumnoBean> reporte = ( ArrayList<AlumnoBean>)request.getAttribute("reporte");
			%>
			
			<%for(int i=0; i<reporte.size(); i++){%>
			<br><%=reporte.get(i).getNombre()%>
			<%}%>
          
        </article>
      </section>
    </div>
  </div>
  <div class="clear"></div>
  <div id="footer">
    <div id="pc">Simulacion de Matricula 2013</div>
  </div>
            
</div>


</body></html>