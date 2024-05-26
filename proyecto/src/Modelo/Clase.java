package Modelo;

import java.time.Duration;
import java.time.LocalDate;
import java.util.LinkedList;

public class Clase {
	private int ID_Clases;
	private String nombre;
	private LocalDate inicio;
	private LocalDate fin;
	private LinkedList<Cliente> alumnos_de_la_clase = new LinkedList<>();
	private Profesor profesor;	
	private int nivel;
	
	//Lista con todas las clases que se crean
	static LinkedList<Clase> clases = new LinkedList<>();
	//Lista con las rutinas que se hacen en la clase creada
	private LinkedList<Rutina> rutina_de_la_clase = new LinkedList<>();
	
	public Clase(String nombre, LocalDate inicio, LocalDate fin,int nivel) {
		super();
		this.nombre=nombre;
		this.inicio = inicio;
		this.fin = fin;
		this.nivel = nivel;

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

	public LocalDate getInicio() {
		return inicio;
	}

	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}

	public LocalDate getFin() {
		return fin;
	}

	public void setFin(LocalDate fin) {
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
