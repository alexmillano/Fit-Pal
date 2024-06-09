package Modelo;

import javax.swing.JOptionPane;

import Controladores.ClienteControlador;
import Controladores.ProfesorControlador;
import Controladores.RecepcionControlador;
import Validaciones.Validaciones_Interface;

public interface MenuIniciarSesion {
	
		default String IniciarSesion(String mail, String contrasena) {
			if (Validaciones_Interface.ValidarEsMail(mail).equals("Ingrese correctamente el mail")) {
				return "Ingrese correctamente el mail";
			}else if (Validaciones_Interface.ValidarEsMail(mail).equals("Ocurrió un error inesperado con su mail")) {
				return "Ocurrió un error inesperado con su mail";
			}
			
			if (Validaciones_Interface.ValidarEsNumero(contrasena).equals("Error. Debe ingresar una contraseña numerica valida.")) {
				return "Error. Debe ingresar unna contraseña numerica valida.";
			}else if (Validaciones_Interface.ValidarEsNumero(contrasena).equals("Ocurrió un error inesperado en su contraseña")) {
				return "Ocurrió un error inesperado en su contraseña";
			}
			
			
			ClienteControlador clientecontrolador = new ClienteControlador();
			RecepcionControlador recepcioncontrolador = new RecepcionControlador();
			ProfesorControlador profesorcontrolador = new ProfesorControlador();
			
			for (Cliente cliente : clientecontrolador.getAllCliente()) {
				if (cliente.getCorreo().equals(mail) && cliente.getContraseña().equals(contrasena)) {	
					return "Email correcto cliente";
				}
			}
			
			for (Recepcion recepcion : recepcioncontrolador.getAllRecepcion()) {
				if (recepcion.getCorreo().equals(mail) && recepcion.getContraseña().equals(contrasena)) {	
					return "Email correcto recepcion";
					
				}
			}
			
			for (Profesor profesor : profesorcontrolador.getAllProfesor()) {
				if (profesor.getCorreo().equals(mail) && profesor.getContraseña().equals(contrasena)) {	
					return "Email correcto profesor";
				}
			}
			
			
			return "No se encontro el usuario";
			
		};
		
		
		
		default boolean CambiarContraseña() {
			return true;
		}
		
		 void Menu();
	
}
