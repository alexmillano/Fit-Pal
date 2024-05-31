package Modelo;

import java.util.LinkedList;

public class Ejercicio {
		private String nombre;
		private int repeticion;
		private int series;
		private int ID_Zona_Ejercicio;
		
		static LinkedList<Ejercicio> ejercicio = new LinkedList<>();
		
		public Ejercicio(String nombre, int repeticion, int series) {
			super();
			this.nombre = nombre;
			this.repeticion = repeticion;
			this.series = series;
			
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public int getRepeticion() {
			return repeticion;
		}
		public void setRepeticion(int repeticion) {
			this.repeticion = repeticion;
		}
		public int getSeries() {
			return series;
		}
		public void setSeries(int series) {
			this.series = series;
		}
		
		public int getID_Zona_Ejercicio() {
			return ID_Zona_Ejercicio;
		}
		public void setID_Zona_Ejercicio(int iD_Zona_Ejercicio) {
			ID_Zona_Ejercicio = iD_Zona_Ejercicio;
		}
		public static LinkedList<Ejercicio> getEjercicio() {
			return ejercicio;
		}
		public static void setEjercicio(LinkedList<Ejercicio> ejercicio) {
			Ejercicio.ejercicio = ejercicio;
		}
		
		
		@Override
		public String toString() {
			return "Nombre del ejercicio: " + nombre + "\nRepeticion: " + repeticion + "\nSeries: " + series;
		}
		
}
