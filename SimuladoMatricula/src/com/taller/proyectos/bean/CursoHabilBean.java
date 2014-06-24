package com.taller.proyectos.bean;

public class CursoHabilBean {
	
	private int idCurso;
	private int creditos;
	private int prioridad;
	private int estado;
	private boolean matriculado;
	private int nroOrden;

	

	public CursoHabilBean(int idCurso, int creditos, int prioridad, int estado, boolean matriculado, int nroOrden) {
		super();
		this.idCurso = idCurso;
		this.creditos = creditos;
		this.prioridad = prioridad;
		this.estado = estado;
		this.matriculado =  matriculado;
		this.nroOrden = nroOrden;
	}

	public CursoHabilBean() {
		super();
		this.idCurso = 0;
		this.creditos = 0;
		this.prioridad = 0;
		this.estado = 0;
		this.matriculado = false;
		this.nroOrden = 0;
	}
	
	public boolean isMatriculado() {
		return matriculado;
	}

	public void setMatriculado(boolean matriculado) {
		this.matriculado = matriculado;
	}

	public int getNroOrden() {
		return nroOrden;
	}

	public void setNroOrden(int nroOrden) {
		this.nroOrden = nroOrden;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	

}



