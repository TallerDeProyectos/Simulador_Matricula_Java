package com.taller.proyectos.app;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	private Connection con=null;
	
	public Connection conectar(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "simulacion");
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{if(con!=null)con.close();}catch(Exception ex){}
		}
		
		
		return con;
	}
	
	
	
}
