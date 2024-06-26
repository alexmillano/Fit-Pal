package Modelo;

import java.util.LinkedList;

public class Ejercicio {
		private int ID_Ejercicios;
		private String nombre;
		private int repeticion;
		private int series;
		private int ID_Zona_Ejercicio;
		
		static LinkedList<Ejercicio> ejercicio = new LinkedList<>();
		
		public Ejercicio(String nombre, int repeticion, int series, int ID_Zona_Ejercicio) {
			super();
			this.nombre = nombre;
			this.repeticion = repeticion;
			this.series = series;
			this.ID_Zona_Ejercicio=ID_Zona_Ejercicio;
			
		}
		
		
		public Ejercicio(int ID_Ejercicios, String nombre, int repeticion, int series, int ID_Zona_Ejercicio) {
			super();
			this.ID_Ejercicios=ID_Ejercicios;
			this.nombre = nombre;
			this.repeticion = repeticion;
			this.series = series;
			this.ID_Zona_Ejercicio=ID_Zona_Ejercicio;
			
		}
		
		
		public Ejercicio() {
			super();
			
		}
		
		
		
		
		public int getID_Ejercicios() {
			return ID_Ejercicios;
		}

		public void setID_Ejercicios(int iD_Ejercicios) {
			ID_Ejercicios = iD_Ejercicios;
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
