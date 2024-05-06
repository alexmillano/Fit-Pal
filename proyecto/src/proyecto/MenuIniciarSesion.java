package proyecto;

import javax.swing.JOptionPane;

public interface MenuIniciarSesion {

		default String IniciarSesion() {
				
			String correo= JOptionPane.showInputDialog("Ingrese su correo");
			String contrasena= JOptionPane.showInputDialog("Ingrese su contraseña");
			
			if (correo.equalsIgnoreCase("profesor")) {
				return "profesor";
			}else if (correo.equalsIgnoreCase("cliente")) {
				return "cliente";
			}else if (correo.equalsIgnoreCase("recepcion")) {
				return "recepcion";
			}else {
				JOptionPane.showMessageDialog(null, "Error al iniciar sesion");
				return "error";
			}
		}
		
		default boolean CambiarContraseña() {
			return true;
		}
		
		 void Menu();
	
}
