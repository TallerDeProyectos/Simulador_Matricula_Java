package com.taller.proyectos.bean;


public class Matricula {
	private int Id_Alumno, Id_Curso, Ciclo_Curso, Ciclo_Alumno, Prioridad, Credito_Curso,n_c_acu;
	private String estado_curso;
	
	public String getEstado_curso() {
		return estado_curso;
	}
	public void setEstado_curso(String estado_curso) {
		this.estado_curso = estado_curso;
	}
	public int getN_c_acu() {
		return n_c_acu;
	}
	public void setN_c_acu(int n_c_acu) {
		this.n_c_acu = n_c_acu;
	}
	private String Nombre_Alumno, Nombre_Curso;
	
	public int getId_Alumno() {
		return Id_Alumno;
	}
	public void setId_Alumno(int id_Alumno) {
		Id_Alumno = id_Alumno;
	}
	public int getId_Curso() {
		return Id_Curso;
	}
	public void setId_Curso(int id_Curso) {
		Id_Curso = id_Curso;
	}
	public int getCiclo_Curso() {
		return Ciclo_Curso;
	}
	public void setCiclo_Curso(int ciclo_Curso) {
		Ciclo_Curso = ciclo_Curso;
	}
	public int getCiclo_Alumno() {
		return Ciclo_Alumno;
	}
	public void setCiclo_Alumno(int ciclo_Alumno) {
		Ciclo_Alumno = ciclo_Alumno;
	}
	public int getPrioridad() {
		return Prioridad;
	}
	public void setPrioridad(int prioridad) {
		Prioridad = prioridad;
	}
	public int getCredito_Curso() {
		return Credito_Curso;
	}
	public void setCredito_Curso(int credito_Curso) {
		Credito_Curso = credito_Curso;
	}
	public String getNombre_Alumno() {
		return Nombre_Alumno;
	}
	public void setNombre_Alumno(String nombre_Alumno) {
		Nombre_Alumno = nombre_Alumno;
	}
	public String getNombre_Curso() {
		return Nombre_Curso;
	}
	public void setNombre_Curso(String nombre_Curso) {
		Nombre_Curso = nombre_Curso;
	}
	
	


}