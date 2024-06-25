package Modelo;

import java.time.Duration;
import java.util.LinkedList;

public class Rutina {
	
		private int ID_Rutinas;
		private String nombre;
		private Profesor profesor;
		private int ID_Profesor;
		private int nivel;
		
		//Lista donde se agregan todas las rutinas creadas. Por eso es STATIC
		static LinkedList<Rutina> rutinas_general = new LinkedList<>();
		
		//Lista de los ejercicios que tiene la rutina creada
		private LinkedList<Ejercicio> ejercicios_de_la_rutina = new LinkedList<>();
		
		
		
		public Rutina(String nombre, Profesor profesor, int nivel) {
			super();
			this.nombre = nombre;
			this.profesor = profesor;	
			this.nivel = nivel;	
			
		}

		public Rutina(int ID_Rutinas ,int ID_Profesor, int ID_Nivel,String nombre) {
			super();
			this.nombre = nombre;
			this.ID_Profesor = ID_Profesor;	
			this.nivel = ID_Nivel;	
			this.ID_Rutinas=ID_Rutinas;		
		}
		
		public Rutina(int ID_Profesor, int ID_Nivel,String nombre) {
			super();
			this.nombre = nombre;
			this.ID_Profesor = ID_Profesor;	
			this.nivel = ID_Nivel;			
		}
		
		public Rutina(int ID_Nivel,String nombre) {
			super();
			this.nombre = nombre;
			this.nivel = ID_Nivel;			
		}
		
		public Rutina() {
		
		}


		public int getID_Rutinas() {
			return ID_Rutinas;
		}



		public void setID_Rutinas(int iD_Rutinas) {
			ID_Rutinas = iD_Rutinas;
		}



		public String getNombre() {
			return nombre;
		}



		public void setNombre(String nombre) {
			this.nombre = nombre;
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
	

		public int getID_Profesor() {
			return ID_Profesor;
		}

		public void setID_Profesor(int iD_Profesor) {
			ID_Profesor = iD_Profesor;
		}

		public static LinkedList<Rutina> getRutinas_general() {
			return rutinas_general;
		}



		public static void setRutinas_general(LinkedList<Rutina> rutinas_general) {
			Rutina.rutinas_general = rutinas_general;
		}



		public LinkedList<Ejercicio> getEjercicios_de_la_rutina() {
			return ejercicios_de_la_rutina;
		}



		public void setEjercicios_de_la_rutina(LinkedList<Ejercicio> ejercicios_de_la_rutina) {
			this.ejercicios_de_la_rutina = ejercicios_de_la_rutina;
		}



		@Override
		public String toString() {
			return "Rutina [ID_Rutinas=" + ID_Rutinas + ", nombre=" + nombre + ", profesor=" + profesor + ", nivel="
					+ nivel + "]";
		}

		
		

		
		
		
}
