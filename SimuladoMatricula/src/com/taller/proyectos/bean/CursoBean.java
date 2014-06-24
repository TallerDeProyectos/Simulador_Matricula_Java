package com.taller.proyectos.bean;

public class CursoBean {
	
	
	private int idCurso;
	private String nombre;
	private int alumnos;
	private int ciclo;
	
	
	public CursoBean(int idCurso, String nombre, int alumnos, int ciclo) {
		super();
		this.idCurso = idCurso;
		this.nombre = nombre;
		this.alumnos = alumnos;
		this.ciclo =  ciclo;
	}

	public CursoBean() {
		super();
		// TODO Auto-generated constructor stub
		this.idCurso = 0;
		this.nombre = "";
		this.alumnos = 0;
		this.ciclo = 0;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(int alumnos) {
		this.alumnos = alumnos;
	}

	public int getCiclo() {
		return ciclo;
	}

	public void setCiclo(int ciclo) {
		this.ciclo = ciclo;
	}
	
	

}

