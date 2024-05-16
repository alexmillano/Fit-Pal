package Modelo;

import java.time.Duration;
import java.util.LinkedList;

public class Rutinas {
		private Duration descanso;
		private LinkedList<Ejercicios> ejercicios = new LinkedList<>();
		private String nombre;
		public Rutinas(Duration descanso, LinkedList<Ejercicios> ejercicios, String nombre) {
			super();
			this.descanso = descanso;
			this.ejercicios = ejercicios;
			this.nombre = nombre;
		}
		public Duration getDescanso() {
			return descanso;
		}
		public void setDescanso(Duration descanso) {
			this.descanso = descanso;
		}
		public LinkedList<Ejercicios> getEjercicios() {
			return ejercicios;
		}
		public void setEjercicios(LinkedList<Ejercicios> ejercicios) {
			this.ejercicios = ejercicios;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		@Override
		public String toString() {
			return "\nNombre: " + nombre + "\nDescanso: " + descanso + "\nEjercicios: " + ejercicios;
		}
		
		
}
