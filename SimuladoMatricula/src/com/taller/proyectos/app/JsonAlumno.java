package com.taller.proyectos.app;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JsonAlumno extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		String dota ="nothing";	
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb",
					"root", "simulacion");
			String sql="select Desc_Curso from T_Curso where ID_Curso = '93'";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				dota = rs.getString("Desc_Curso");
				
			}
		}catch(Exception ex){
			ex.printStackTrace();
			dota = ex.getMessage();
		}finally{
			try{if(con!=null)con.close();}catch(Exception ex){}
		}
		
		
		request.setAttribute("reporte", dota);
		RequestDispatcher rd =
		getServletContext().getRequestDispatcher("/json.jsp");
		rd.forward(request, response);
		
		
	}
	

}
