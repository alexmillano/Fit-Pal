package Modelo;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;

public class Clase {
	private int ID_Clases;
	private String nombre;
	private LocalTime inicio;
	private LocalTime fin;	
	private int nivel;
	private Profesor profesor;	

	
	//Lista de los alumnos de la clase creada
	private LinkedList<Cliente> alumnos_de_la_clase = new LinkedList<>();
	
	//Lista con las rutinas que se hacen en la clase creada
	private LinkedList<Rutina> rutina_de_la_clase = new LinkedList<>();
	
	
	//Lista con todas las clases que se crean. Por eso es static
	static LinkedList<Clase> clases = new LinkedList<>();
	

	
	public Clase(String nombre, LocalTime inicio, LocalTime fin,int nivel, Profesor profesor) {
		super();
		this.nombre=nombre;
		this.inicio = inicio;
		this.fin = fin;
		this.nivel = nivel;
		this.profesor=profesor;

	}
	
	
	

	public int getID_Clases() {
		return ID_Clases;
	}

	public void setID_Clases(int iD_Clases) {
		ID_Clases = iD_Clases;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalTime getInicio() {
		return inicio;
	}

	public void setInicio(LocalTime inicio) {
		this.inicio = inicio;
	}

	public LocalTime getFin() {
		return fin;
	}

	public void setFin(LocalTime fin) {
		this.fin = fin;
	}

	public LinkedList<Cliente> getAlumnos_de_la_clase() {
		return alumnos_de_la_clase;
	}

	public void setAlumnos_de_la_clase(LinkedList<Cliente> alumnos_de_la_clase) {
		this.alumnos_de_la_clase = alumnos_de_la_clase;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public static LinkedList<Clase> getClases() {
		return clases;
	}

	public static void setClases(LinkedList<Clase> clases) {
		Clase.clases = clases;
	}

	public LinkedList<Rutina> getRutina_de_la_clase() {
		return rutina_de_la_clase;
	}

	public void setRutina_de_la_clase(LinkedList<Rutina> rutina_de_la_clase) {
		this.rutina_de_la_clase = rutina_de_la_clase;
	}

	
	@Override
	public String toString() {
		return "Clase [ID_Clases=" + ID_Clases + ", nombre=" + nombre + ", inicio=" + inicio + ", fin=" + fin
				+ ", alumnos_de_la_clase=" + alumnos_de_la_clase + ", profesor=" + profesor + ", nivel=" + nivel
				+ ", rutina_de_la_clase=" + rutina_de_la_clase + "]";
	}

	
	


	
	
}
