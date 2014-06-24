package com.taller.proyectos.app;

import java.util.ArrayList;
import java.util.List;

import com.taller.proyectos.bean.AlumnoBean;
import com.taller.proyectos.bean.CursoBean;

public class MatricularAlumno {
	
	
	
	private static final int REPITE = 1;
	private static final int APTO = 2;
	
	private List<CursoBean> listaCursos;
	private List<AlumnoBean> alumnos;

	public MatricularAlumno() {
		super();
		listaCursos = new ConstruirDatos().listarCursos();
		alumnos = new ConstruirDatos().loadAlumnos();
		matricularAlumnos();
	}
	
	public AlumnoBean matricula(AlumnoBean alumno){
		
		int contRepetidos = 0;
		int creditosAlumno = 0;
		int creditosCurso = 0;
		int idCurso = 0;
		int indexCurso = 0;
		int estadoCurso = 0;
		int alumnosEnCurso =0;
		
		System.out.println(alumno.getNombre()+"----------------------------");
		
		
		for(int i=0; i< alumno.getcHabiles().size();i++){
			if(contRepetidos<3){
				
				creditosAlumno = alumno.getCreditos();
				creditosCurso = alumno.getcHabiles().get(i).getCreditos();
				idCurso = alumno.getcHabiles().get(i).getIdCurso();
				indexCurso = getIndexCursoById(idCurso);
				estadoCurso = alumno.getcHabiles().get(i).getEstado();
				alumnosEnCurso = listaCursos.get(indexCurso).getAlumnos();

				System.out.println("Id Curso : \t\t"+idCurso);
				System.out.println("Creditos Alumno: \t"+creditosAlumno);
				System.out.println("Creditos Curso: \t"+creditosCurso);
				System.out.println("Index Curso: \t\t"+indexCurso);
				System.out.println("Estado Curso: \t\t"+estadoCurso);
				System.out.println("Alumnos en curso: \t"+alumnosEnCurso);
				System.out.println("-------------------------------------");
				
				switch (estadoCurso) {
				case REPITE:
					
					alumno.setCreditos(creditosAlumno - creditosCurso);
					alumnosEnCurso++;
					listaCursos.get(indexCurso).setAlumnos(alumnosEnCurso);
					alumno.getcHabiles().get(i).setMatriculado(true);
					alumno.getcHabiles().get(i).setNroOrden(alumnosEnCurso);
					contRepetidos++;
					
					break;
				case APTO:
					
					if(creditosAlumno>12){
						alumno.setCreditos(creditosAlumno - creditosCurso);
						alumnosEnCurso++;
						listaCursos.get(indexCurso).setAlumnos(alumnosEnCurso);
						alumno.getcHabiles().get(i).setMatriculado(true);
						alumno.getcHabiles().get(i).setNroOrden(alumnosEnCurso);
					}else{System.out.println("Se ejecutara mochila ya que tiene "+creditosAlumno+" créditos");
						//MOCHILA
						
						int n = alumno.getcHabiles().size()-i;
						System.out.println("-> Hay "+n+" cursos");
						
				       double reward[]=new double[n];
				       int weight[]=new int[n];
				       int items[]=new int[n];
				       
				       int temp = 0;
				       System.out.println("Item\tPeso\tGanancia");
				       for(int j=i; j<alumno.getcHabiles().size();j++){
				    	   items[temp]= alumno.getcHabiles().get(j).getIdCurso();
				    	   reward[temp] = alumno.getcHabiles().get(j).getPrioridad();  
				    	   weight[temp]= alumno.getcHabiles().get(j).getCreditos();
				    	   System.out.println(items[temp]+"\t"+weight[temp]+"\t"+reward[temp]);
				    	   temp++;
				       }
				       
				       Mochila obj=new Mochila(n, creditosAlumno, items, reward, weight);
				       int cursosId[] = obj.execMochila();
				       
				       for(int h=0; h<cursosId.length;h++){
				    	    if(cursosId[h]!=-1){
				    	    	creditosAlumno = alumno.getCreditos();
					    	    idCurso = cursosId[h];
					    	    int indexCursoHabil = getIndexCursoHabilesById(idCurso,alumno);
								creditosCurso = alumno.getcHabiles().get(indexCursoHabil).getCreditos();
								indexCurso = getIndexCursoById(idCurso);
								estadoCurso = alumno.getcHabiles().get(indexCursoHabil).getEstado();
								alumnosEnCurso = listaCursos.get(indexCurso).getAlumnos();
								
								System.out.println("Id Curso : \t\t"+idCurso);
								System.out.println("Creditos Alumno: \t"+creditosAlumno);
								System.out.println("Creditos Curso: \t"+creditosCurso);
								System.out.println("Index Curso: \t\t"+indexCurso);
								System.out.println("Estado Curso: \t\t"+estadoCurso);
								System.out.println("Alumnos en curso: \t"+alumnosEnCurso);
								System.out.println("-------------------------------------");
								
								alumno.setCreditos(creditosAlumno - creditosCurso);
								alumnosEnCurso++;
								listaCursos.get(indexCurso).setAlumnos(alumnosEnCurso);
								alumno.getcHabiles().get(indexCursoHabil).setMatriculado(true);
								alumno.getcHabiles().get(indexCursoHabil).setNroOrden(alumnosEnCurso);
				    	    }
							
				       }
				       
				       i=alumno.getcHabiles().size();
				       System.out.println("-------------------------------------");
					}
					
					break;


				default:
					break;
				}
			}
		}
		System.out.println("Situación final del alumno");
		System.out.println("-------------------------------------");
		System.out.println("Creditos Alumno: \t"+alumno.getCreditos());
		for(int i=0; i<alumno.getcHabiles().size();i++){
			if(alumno.getcHabiles().get(i).isMatriculado()){
				System.out.println("  Curso: \t"+alumno.getcHabiles().get(i).getIdCurso());
			}
		}
		System.out.println("-------------------------------------");
		return alumno;
	}
	
	
	public int getIndexCursoById(int idCurso){
		for(int i=0; i<listaCursos.size(); i++){
			if(listaCursos.get(i).getIdCurso()==idCurso){
				return i;
			}
		}
		return -1;
	}
	
	public int getIndexCursoHabilesById(int idCurso, AlumnoBean alumno){
		for(int i=0; i<alumno.getcHabiles().size(); i++){
			if(alumno.getcHabiles().get(i).getIdCurso()==idCurso){
				return i;
			}
		}
		return -1;
	}
	
	public void matricularAlumnos(){
		for(int i=0; i<alumnos.size(); i++){
			matricula(alumnos.get(i));
		}
	}
	
	public List<CursoBean> obtenerResultadoPorCiclo(int ciclo){
		
//		matricularAlumnos();
		List<CursoBean> reporte =  new ArrayList<CursoBean>();
		int j=0;
		for(int i=0; i<listaCursos.size(); i++){
			if(listaCursos.get(i).getCiclo()==ciclo){
				reporte.add(listaCursos.get(i));
				j++;
			}
		}
		
		if(ciclo==11 || ciclo==12){
			for(int i=j; i<listaCursos.size(); i++){
				if(listaCursos.get(i).getCiclo()==15){
					reporte.add(listaCursos.get(i));
					j++;
				}
			}
		}
		
		if(ciclo==11 || ciclo==13){
			for(int i=j; i<listaCursos.size(); i++){
				if(listaCursos.get(i).getCiclo()==16){
					reporte.add(listaCursos.get(i));
				}
			}
		}
		
		return reporte;
	}
	
	public List<CursoBean> obtenerCursosPorAlumno(long idAlumno){
		
//		matricularAlumnos();
		List<CursoBean> reporte = new ArrayList<CursoBean>();
		
		for(int i=0; i<alumnos.size();i++){
			if(alumnos.get(i).getIdAlumno()==idAlumno){
				for(int j=0; j<alumnos.get(i).getcHabiles().size();j++){
					if(alumnos.get(i).getcHabiles().get(j).isMatriculado()){
						reporte.add(listaCursos.get(getIndexCursoById(alumnos.get(i).getcHabiles().get(j).getIdCurso())));
					}
				}
				return reporte;
			}
		}
		return reporte;
	}
	
	public List<AlumnoBean> obtenerAlumnosDeUnCurso(int idCurso){
		
//		matricularAlumnos();
		List<AlumnoBean> reporte = new ArrayList<AlumnoBean>();
		
		for(int i=0; i<alumnos.size(); i++){
			for(int j=0; j<alumnos.get(i).getcHabiles().size(); j++){
				if(alumnos.get(i).getcHabiles().get(j).getIdCurso()==idCurso && alumnos.get(i).getcHabiles().get(j).isMatriculado()){
					reporte.add(alumnos.get(i));
				}
			}
		}
		
		return reporte;
	}
	
	public String getNombreAlumno(long idAlumno){
		for(int i=0; i<alumnos.size(); i++){
			if(alumnos.get(i).getIdAlumno()==idAlumno){
				return alumnos.get(i).getNombre();
			}
		}
		return "";
	}
	
	public String getNombreCurso(long idCurso){
		for(int i=0; i<listaCursos.size(); i++){
			if(listaCursos.get(i).getIdCurso()==idCurso){
				return listaCursos.get(i).getNombre();
			}
		}
		return "";
	}
	
	
//	public static void main(String[] args) {
//		
//		MatricularAlumno obj = new MatricularAlumno();	
//		
//		
//		List<CursoBean> reporte = obj.obtenerResultadoPorCiclo(1);
//		System.out.println("Cantidad de alumnos matriculados en cursos del ciclo 1");
//		for(int i=0; i<reporte.size();i++){
//			System.out.println(reporte.get(i).getNombre()+" Alumnos : "+reporte.get(i).getAlumnos());
//		}
//		
//		System.out.println("Cursos del alumno 2");
//		List<CursoBean> reporteAlu = obj.obtenerCursosPorAlumno(1);
//		for(int i=0; i<reporteAlu.size();i++){
//			System.out.println(reporteAlu.get(i).getNombre());
//		}
//		
//		System.out.println("Alumnos que llevaran el curso 4");
//		List<AlumnoBean> reporteAlu2 = obj.obtenerAlumnosDeUnCurso(4);
//		for(int i=0; i<reporteAlu2.size();i++){
//			System.out.println(reporteAlu2.get(i).getNombre());
//		}
//		
//		
//		System.out.println("Done");
//		
//	}
	

}
