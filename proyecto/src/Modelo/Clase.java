package Modelo;

import java.util.LinkedList;
import java.time.LocalDateTime;

public class Clase {
	private int ID_Clases;
	private String nombre;
	private LocalDateTime inicio;
	private LocalDateTime fin;
	private int nivel;
	
	private int ID_Profesor;

	
	//Lista de los alumnos de la clase creada
	private LinkedList<Cliente> alumnos_de_la_clase = new LinkedList<>();
	
	//Lista con las rutinas que se hacen en la clase creada
	private LinkedList<Rutina> rutina_de_la_clase = new LinkedList<>();
	
	public Clase(int ID_Profesor,int i, String nombre, LocalDateTime inicio, LocalDateTime fin,int nivel) {
		super();
		this.nombre=nombre;
		this.inicio = inicio;
		this.fin = fin;
		this.nivel = nivel;
		this.ID_Profesor=ID_Profesor;

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

	public LocalDateTime getInicio() {
		return inicio;
	}

	public void setInicio(LocalDateTime inicio) {
		this.inicio = inicio;
	}

	public LocalDateTime getFin() {
		return fin;
	}

	public void setFin(LocalDateTime fin) {
		this.fin = fin;
	}

	public LinkedList<Cliente> getAlumnos_de_la_clase() {
		return alumnos_de_la_clase;
	}

	public void setAlumnos_de_la_clase(LinkedList<Cliente> alumnos_de_la_clase) {
		this.alumnos_de_la_clase = alumnos_de_la_clase;
	}

	public int getID_Profesor() {
		return ID_Profesor;
	}

	public void setID_Profesor(int ID_Profesor) {
		this.ID_Profesor = ID_Profesor;
	}


	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}


	public LinkedList<Rutina> getRutina_de_la_clase() {
		return rutina_de_la_clase;
	}

	public void setRutina_de_la_clase(LinkedList<Rutina> rutina_de_la_clase) {
		this.rutina_de_la_clase = rutina_de_la_clase;
	}



//Intentar no modificar este ToString. Falta agregar profesor
	@Override
	public String toString() {
		String horaYMinutosInicio = String.format("%02d:%02d", inicio.getHour(), inicio.getMinute());
		String horaYMinutosFin = String.format("%02d:%02d", fin.getHour(), fin.getMinute());

		return "Clase [nombre=" + nombre + " , Inicio=" + horaYMinutosInicio + " , Fin=" + horaYMinutosFin
				+ " , Nivel=" + nivel + " , Inscriptos=" + alumnos_de_la_clase.size()
				+  "]";
	}



	public String MostrarParaAlumno() {
		
		
		return "Clase: " + this.getNombre() + ". Inicio: " + this.getInicio() + ". Fin: " + this.getFin() + ". Inscriptos: " + alumnos_de_la_clase.size();
		
	}
	
	
	


	
	
}
