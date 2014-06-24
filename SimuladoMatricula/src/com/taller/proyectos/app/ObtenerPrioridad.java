package com.taller.proyectos.app;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taller.proyectos.bean.Matricula;


/**
 * Servlet implementation class ObtenerPrioridad
 */
@WebServlet("/ObtenerPrioridad")
public class ObtenerPrioridad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ObtenerPrioridad() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Matricula> matriculas =  new ArrayList<Matricula>();
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb",
					"root", "simulacion");
			String sql="select distinct c.Cod_Alumno,concat(c.Nombre,c.Apellido_Paterno,c.Apellido_Materno) Nombre,c.Nro_Cred_Acum creditoAcu,c.Ciclo + 1 ciclodelalumno,a.Desc_Curso ,a.Cod_Curso,a.Ciclo ciclodelcurso,a.Nro_Cred numerodecreditos,b.Estado_Curso from T_Curso a, T_Cursos_Habiles b,T_Alumno c where a.Id_Curso=b.Id_Curso and b.Cod_Alumno=c.Cod_Alumno order by Nombre";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
				while(rs.next()){
				
				
				Matricula matricula = new Matricula();
				matricula.setId_Alumno(rs.getInt("cod_alumno"));
				matricula.setId_Curso(rs.getInt("cod_curso"));
				matricula.setCiclo_Curso(rs.getInt("ciclodelcurso"));
				matricula.setCiclo_Alumno(rs.getInt("ciclodelalumno"));
				matricula.setCredito_Curso(rs.getInt("numerodecreditos"));
				matricula.setNombre_Alumno(rs.getString("Nombre"));
				matricula.setNombre_Curso(rs.getString("desc_curso"));
				matricula.setN_c_acu(rs.getInt("creditoAcu"));
				matricula.setEstado_curso(rs.getString("estado_curso"));
				
				if(matricula.getCiclo_Alumno()==matricula.getCiclo_Curso()) {
				 	 int prioridad= 3;
				 	 matricula.setPrioridad(prioridad);
				 }else{
					 	if (matricula.getCiclo_Alumno()<matricula.getCiclo_Curso()){
					 		int prioridad= 1;
					 		matricula.setPrioridad(prioridad);
					 		}else {
					
					 			int prioridad= 4;
					 			matricula.setPrioridad(prioridad);
					 		}
				 
				      }
				
				 	 matriculas.add(matricula);
				 }
				
				
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{if(con!=null)con.close();}catch(Exception ex){}
		}
		request.setAttribute("matriculas", matriculas);
		request.getRequestDispatcher("/simular.jsp").
			forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}	
}
