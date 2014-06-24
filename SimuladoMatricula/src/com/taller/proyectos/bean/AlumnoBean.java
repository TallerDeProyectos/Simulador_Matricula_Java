package com.taller.proyectos.bean;

import java.util.List;

public class AlumnoBean {
	
	private long idAlumno;
	private String nombre;
	private int creditos;
	private List<CursoHabilBean> cHabiles;

	public AlumnoBean(long idAlumno, String nombre, int creditos,List<CursoHabilBean> cHabiles) {
		super();
		this.idAlumno = idAlumno;
		this.nombre = nombre;
		this.creditos = creditos;
		this.cHabiles = cHabiles;
	}

	public AlumnoBean() {
		this.idAlumno = 0;
		this.nombre = "";
		this.creditos = 0;
		this.cHabiles = null;
	}

	public long getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(long idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public List<CursoHabilBean> getcHabiles() {
		return cHabiles;
	}

	public void setcHabiles(List<CursoHabilBean> cHabiles) {
		this.cHabiles = cHabiles;
	}
	
	

}


