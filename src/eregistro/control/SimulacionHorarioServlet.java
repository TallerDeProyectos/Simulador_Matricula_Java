package eregistro.control;

import java.io.IOException; 

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eregistro.bean.Alumno;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class SimulacionHorarioServlet
 */
@WebServlet("/simulacionhorario")
public class SimulacionHorarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SimulacionHorarioServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Alumno> alumnos =  new ArrayList<Alumno>();
		Connection con=null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb",
					"root", "root");
			String sql="SELECT * FROM t_alumno";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				System.out.print("entro");
				
				Alumno alumno = new Alumno();
				alumno.setID_Alumno(rs.getInt("ID_Alumno"));
				alumno.setNombre(rs.getString("Nombre"));
				alumno.setApellido_Paterno(rs.getString("Apellido_Paterno"));
				alumno.setApellido_Materno(rs.getString("Apellido_Materno"));
				alumnos.add(alumno);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{if(con!=null)con.close();}catch(Exception ex){}
		}
		request.setAttribute("alumnos", alumnos);
		request.getRequestDispatcher("simular.jsp").
			forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
