package eregistro.bean;

public class Alumno {
	private int ID_Alumno;
	private String Nombre, Apellido_Paterno, Apellido_Materno;
	private char Estado;
	
	public int getID_Alumno() {
		return ID_Alumno;
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
