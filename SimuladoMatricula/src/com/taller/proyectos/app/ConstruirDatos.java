package com.taller.proyectos.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.taller.proyectos.bean.AlumnoBean;
import com.taller.proyectos.bean.CursoBean;
import com.taller.proyectos.bean.CursoHabilBean;
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
import com.taller.proyectos.bean.Matricula;

public class ConstruirDatos {
	
	public List<CursoBean> listarCursos(){
		
		List<CursoBean> cursos	=  new ArrayList<CursoBean>();
		
		String sql="select ID_Curso,Desc_Curso, Ciclo from T_Curso";
		Connection cn=null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "simulacion");
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
			
				
				
				cursos.add(new CursoBean(rs.getInt("ID_Curso"),rs.getString("Desc_Curso"),0,rs.getInt("Ciclo")));
			}
		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}finally{
			try{if(cn!=null)cn.close();}catch(Exception ex){}
		}
		
		return cursos;
		
	}
	
	public List<AlumnoBean> loadAlumnos(){

		List<AlumnoBean> alumnos = new ArrayList<AlumnoBean>();
		List<Matricula> matriculas =  obtenerHabiles();
		
// select Cod_Alumno from T_Cursos_Habiles group by Cod_Alumno;
		String sql="select H.Cod_Alumno, A.Nombre, A.Apellido_Paterno from T_Cursos_Habiles H  inner join T_Alumno A on H.Cod_Alumno=A.Cod_Alumno group by H.Cod_Alumno order by H.Cod_Alumno;";
		Connection cn=null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "simulacion");
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				List<CursoHabilBean> cHabiles = new ArrayList<CursoHabilBean>();
//				System.out.println("MATRICULAS>>>> "+matriculas.size() );
				for(int i=0; i<matriculas.size();i++){
					if(matriculas.get(i).getId_Alumno()==rs.getInt("H.Cod_Alumno")){
						
						int estado = 2;
						int prioridad = matriculas.get(i).getPrioridad();
						if(matriculas.get(i).getEstado_curso().equals("repite")){
							estado =1;
							prioridad = 5;
						}
						
						cHabiles.add(new CursoHabilBean(	
								matriculas.get(i).getId_Curso()	,//idCurso	
								matriculas.get(i).getCredito_Curso()	,//creditos	
								prioridad	,//prioridad	
								estado	,//estado
								false,//matriculado	
								0	));//nro orden
					}
				}
					
					 
								

				
					new Ordenar().quicksort(cHabiles, 0, cHabiles.size()-1);
					alumnos.add(new AlumnoBean(rs.getInt("H.Cod_Alumno"),rs.getString("A.Nombre")
							+" "+rs.getString("A.Apellido_Paterno"),22,cHabiles));
				
				
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{if(cn!=null)cn.close();}catch(Exception ex){}
		}
		
		return alumnos;
	}
	
	
	public List<Matricula> obtenerHabiles(){
		
		List<Matricula> matriculas =  new ArrayList<Matricula>();
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb",
					"root", "simulacion");
			String sql="select distinct c.Cod_Alumno,concat(c.Nombre,c.Apellido_Paterno,c.Apellido_Materno) Nombre,c.Nro_Cred_Acum creditoAcu,c.Ciclo + 1 ciclodelalumno,a.Desc_Curso ,a.ID_Curso,a.Ciclo ciclodelcurso,a.Nro_Cred numerodecreditos,b.Estado_Curso from T_Curso a, T_Cursos_Habiles b,T_Alumno c where a.Id_Curso=b.Id_Curso and b.Cod_Alumno=c.Cod_Alumno order by Nombre";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
				while(rs.next()){
				
				
				Matricula matricula = new Matricula();
				matricula.setId_Alumno(rs.getInt("cod_alumno"));
				matricula.setId_Curso(rs.getInt("id_curso"));
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
		
		return matriculas;
	}
	

	
	
	
	
}
