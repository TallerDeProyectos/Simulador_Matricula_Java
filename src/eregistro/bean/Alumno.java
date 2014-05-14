package eregistro.bean;

public class Alumno {
	private int ID_Alumno, Ciclo, ID_Curso;
	private String Nombre, Apellido_Paterno, Apellido_Materno, Nro_Cre_Aprobados;
	private double Promedio;
	
	public int getID_Alumno() {
		return ID_Alumno;
	}
	public void setID_Alumno(int iD_Alumno) {
		ID_Alumno = iD_Alumno;
	}
	public int getCiclo() {
		return Ciclo;
	}
	public void setCiclo(int ciclo) {
		Ciclo = ciclo;
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
	public String getNro_Cre_Aprobados() {
		return Nro_Cre_Aprobados;
	}
	public void setNro_Cre_Aprobados(String nro_Cre_Aprobados) {
		Nro_Cre_Aprobados = nro_Cre_Aprobados;
	}
	public double getPromedio() {
		return Promedio;
	}
	public void setPromedio(double promedio) {
		Promedio = promedio;
	}
	public int getID_Curso() {
		return ID_Curso;
	}
	public void setID_Curso(int iD_Curso) {
		ID_Curso = iD_Curso;
	}
	
	
	
}
