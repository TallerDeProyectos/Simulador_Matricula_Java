package eregistro.bean;

public class Alumno {
	private int ID_Alumno;
	private String Nombre, Apellido_Paterno, Apellido_Materno,semestre_ingreso,nro_cre_aprobados;
	private char Estado;
	private double promedio;
	
	public double getPromedio() {
		return promedio;
	}
	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}
	public int getID_Alumno() {
		return ID_Alumno;
	}
	public String getSemestre_ingreso() {
		return semestre_ingreso;
	}
	public void setSemestre_ingreso(String semestre_ingreso) {
		this.semestre_ingreso = semestre_ingreso;
	}
	public String getNro_cre_aprobados() {
		return nro_cre_aprobados;
	}
	public void setNro_cre_aprobados(String nro_cre_aprobados) {
		this.nro_cre_aprobados = nro_cre_aprobados;
	}
	public void setID_Alumno(int iD_Alumno) {
		ID_Alumno = iD_Alumno;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido_Paterno() {
		return Apellido_Paterno;
	}
	public void setApellido_Paterno(String apellido_Paterno) {
		Apellido_Paterno = apellido_Paterno;
	}
	public String getApellido_Materno() {
		return Apellido_Materno;
	}
	public void setApellido_Materno(String apellido_Materno) {
		Apellido_Materno = apellido_Materno;
	}
	public char getEstado() {
		return Estado;
	}
	public void setEstado(char estado) {
		Estado = estado;
	}
	
}
