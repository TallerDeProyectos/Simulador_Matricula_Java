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
 * Servlet implementation class SimulacionPrueba1
 */
@WebServlet("/SimPrueba1")
public class SimulacionPrueba1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SimulacionPrueba1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Alumno> grupo1 =  new ArrayList<Alumno>();
		List<Alumno> grupo2 =  new ArrayList<Alumno>();
		List<Alumno> grupo3 =  new ArrayList<Alumno>();
		List<Alumno> grupo4 =  new ArrayList<Alumno>();
		List<Alumno> grupo5 =  new ArrayList<Alumno>();
		Connection con=null;
		
		try{
			
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb",
					"root", "root");
			
			//String sql="select Promedio from T_SemestrexAlumno";
			
			String sql1="select a.id_alumno, a.nombre,a.apellido_paterno,a.apellido_materno,a.semestre_ingreso,a.nro_cre_aprobados,b.promedio from t_alumno a,t_semestrexalumno b where a.id_alumno=b.id_alumno";
			
			Statement st=con.createStatement();
			
			//ResultSet rs=st.executeQuery(sql);
	
			ResultSet rs2=st.executeQuery(sql1);
			
			System.out.print("entro7");
			while(rs2.next()){
				
			
				if(rs2.getDouble("promedio")>=13.28 && rs2.getDouble("promedio")<=20){
					
					
					Alumno alumno=new Alumno();
					
					alumno.setID_Alumno(rs2.getInt("ID_Alumno"));
					alumno.setNombre(rs2.getString("Nombre"));
					alumno.setApellido_Paterno(rs2.getString("Apellido_Paterno"));
					alumno.setApellido_Materno(rs2.getString("Apellido_Materno"));
					alumno.setNro_cre_aprobados(rs2.getString("Nro_cre_aprobados"));
					alumno.setPromedio(rs2.getDouble("promedio"));
					
					grupo1.add(alumno);
					
				
					
				}else{
					if(rs2.getDouble("promedio")>=12.3 && rs2.getDouble("promedio")<=13.27){
						
						Alumno alumno=new Alumno();
						
						
						alumno.setID_Alumno(rs2.getInt("ID_Alumno"));
						alumno.setNombre(rs2.getString("Nombre"));
						alumno.setApellido_Paterno(rs2.getString("Apellido_Paterno"));
						alumno.setApellido_Materno(rs2.getString("Apellido_Materno"));
						alumno.setNro_cre_aprobados(rs2.getString("Nro_cre_aprobados"));
						alumno.setPromedio(rs2.getDouble("promedio"));
						
						grupo2.add(alumno);
						
						
						
					}else{
						if(rs2.getDouble("promedio")>=11.0 && rs2.getDouble("promedio")<=12.12){
							
							Alumno alumno=new Alumno();
							
							
							alumno.setID_Alumno(rs2.getInt("ID_Alumno"));
							alumno.setNombre(rs2.getString("Nombre"));
							alumno.setApellido_Paterno(rs2.getString("Apellido_Paterno"));
							alumno.setApellido_Materno(rs2.getString("Apellido_Materno"));
							alumno.setNro_cre_aprobados(rs2.getString("Nro_cre_aprobados"));
							alumno.setPromedio(rs2.getDouble("promedio"));
							
							grupo3.add(alumno);
							
							
						}else{
							
							if(rs2.getDouble("promedio")>=9.09 && rs2.getDouble("promedio")<=10.99){
								
								Alumno alumno=new Alumno();
								
								
								alumno.setID_Alumno(rs2.getInt("ID_Alumno"));
								alumno.setNombre(rs2.getString("Nombre"));
								alumno.setApellido_Paterno(rs2.getString("Apellido_Paterno"));
								alumno.setApellido_Materno(rs2.getString("Apellido_Materno"));
								alumno.setNro_cre_aprobados(rs2.getString("Nro_cre_aprobados"));
								alumno.setPromedio(rs2.getDouble("promedio"));
								
								grupo4.add(alumno);
								
								
							}else{
								
								
								if(rs2.getDouble("promedio")>=0.0 && rs2.getDouble("promedio")<=9.09){
									Alumno alumno=new Alumno();
									
									
									alumno.setID_Alumno(rs2.getInt("ID_Alumno"));
									alumno.setNombre(rs2.getString("Nombre"));
									alumno.setApellido_Paterno(rs2.getString("Apellido_Paterno"));
									alumno.setApellido_Materno(rs2.getString("Apellido_Materno"));
									alumno.setNro_cre_aprobados(rs2.getString("Nro_cre_aprobados"));
									alumno.setPromedio(rs2.getDouble("promedio"));
									
									grupo5.add(alumno);
									
								
								}
							}
							
							
						}
						
						
						
					}
					
					
				}
				

				
			}
			
		}catch(Exception ex ){
			ex.printStackTrace();
			
		}finally{
			try{if(con!=null)con.close();}catch(Exception ex){}
			
		}
		
		request.setAttribute("grupo1", grupo1);
		request.setAttribute("grupo2",  grupo2);
		request.setAttribute("grupo3",  grupo3);
		request.setAttribute("grupo4",  grupo4);
		request.setAttribute("grupo5",  grupo5);
		request.getRequestDispatcher("simular2.jsp").
		forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
