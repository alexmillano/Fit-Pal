package proyecto;

public class Ejercicios {
		private String nombre;
		private int repeticion;
		private int series;
		public Ejercicios(String nombre, int repeticion, int series) {
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
		@Override
		public String toString() {
			return "Nombre del ejercicio: " + nombre + "\nRepeticion: " + repeticion + "\nSeries: " + series;
		}
		
}
