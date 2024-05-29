package Modelo;

public class Persona implements MenuIniciarSesion, Validaciones_Interface{
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
		public boolean IniciarSesion(String mail, String contrasena) {
			ValidarEsNumero(contrasena);
			if (this.getCorreo().equals(mail) && this.getContraseña().equals(contrasena)) {
				return true;
			} else {
				return false;
			}
		}
		
		@Override
		public void Menu() {
			// TODO Auto-generated method stub
			
		}
		
}
