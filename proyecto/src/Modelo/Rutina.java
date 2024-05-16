package Modelo;

import java.time.Duration;
import java.util.LinkedList;

public class Rutina {
		private Duration descanso;
		private LinkedList<Ejercicio> ejercicio = new LinkedList<>();
		private String nombre;
		public Rutina(Duration descanso, LinkedList<Ejercicio> ejercicio, String nombre) {
			super();
			this.descanso = descanso;
			this.ejercicio = ejercicio;
			this.nombre = nombre;
		}
		public Duration getDescanso() {
			return descanso;
		}
		public void setDescanso(Duration descanso) {
			this.descanso = descanso;
		}
		public LinkedList<Ejercicio> getEjercicio() {
			return ejercicio;
		}
		public void setEjercicio(LinkedList<Ejercicio> ejercicio) {
			this.ejercicio = ejercicio;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		@Override
		public String toString() {
			return "\nNombre: " + nombre + "\nDescanso: " + descanso + "\nEjercicio: " + ejercicio;
		}
		
		
}
