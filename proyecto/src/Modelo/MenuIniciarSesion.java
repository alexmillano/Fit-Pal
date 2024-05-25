package Modelo;

import javax.swing.JOptionPane;

public interface MenuIniciarSesion {

		boolean IniciarSesion(String mail, String contrasena);
		
		default boolean CambiarContraseña() {
			return true;
		}
		
		 void Menu();
	
}
