package proyecto;

public class Persona{
		private String nombre;
		private String apellido;
		private String contraseña;
		private int dni;
		private String correo;
		public Persona(String nombre, String apellido, String contraseña, int dni, String correo) {
			super();
			this.nombre = nombre;
			this.apellido = apellido;
			this.contraseña = contraseña;
			this.dni = dni;
			this.correo = correo;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getApellido() {
			return apellido;
		}
		public void setApellido(String apellido) {
			this.apellido = apellido;
		}
		public String getContraseña() {
			return contraseña;
		}
		public void setContraseña(String contraseña) {
			this.contraseña = contraseña;
		}
	
		public int getDni() {
			return dni;
		}
		public void setDni(int dni) {
			this.dni = dni;
		}
		public String getCorreo() {
			return correo;
		}
		public void setCorreo(String correo) {
			this.correo = correo;
		}
		@Override
		public String toString() {
			return "Nombre: " + nombre + "\nApellido: " + apellido + "\nContraseña: " + contraseña + "\nDNI: "
					+ dni + "\nCorreo: " + correo;
		}
		
		
}
