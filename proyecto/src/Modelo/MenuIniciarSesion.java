package Modelo;

import javax.swing.JOptionPane;

import Controladores.ClienteControlador;
import Controladores.ProfesorControlador;
import Controladores.RecepcionControlador;
import Validaciones.Validaciones_Interface;

public interface MenuIniciarSesion {
	
		default Object IniciarSesion(String mail, String contrasena) {
						
			String mailValidacion = Validaciones_Interface.ValidarEsMail(mail);
	        if (Validaciones_Interface.ValidarEsMail(mail) != null) {
	            return mailValidacion; 
	        }

	        String contrasenaValidacion = Validaciones_Interface.ValidarEsNumero(contrasena);
	        if (contrasenaValidacion != null) {
	            return contrasenaValidacion;
	        }
						
			ClienteControlador clientecontrolador = new ClienteControlador();
			
			for (Cliente cliente : clientecontrolador.getAllClienteConID_Cliente()) {
				if (cliente.getCorreo().equals(mail) && cliente.getContraseña().equals(contrasena)) {	
					return cliente;
				}
			}
			
			RecepcionControlador recepcioncontrolador = new RecepcionControlador();
			for (Recepcion recepcion : recepcioncontrolador.getAllRecepcionConIDRecepcion()) {
				if (recepcion.getCorreo().equals(mail) && recepcion.getContraseña().equals(contrasena)) {	
					return recepcion;
					
				}
			}
			
			ProfesorControlador profesorcontrolador = new ProfesorControlador();
			for (Profesor profesor : profesorcontrolador.getAllProfesorConIDProfesor()) {
				if (profesor.getCorreo().equals(mail) && profesor.getContraseña().equals(contrasena)) {	
					return profesor;
				}
			}		
			return "No se encontro el usuario";		
		};
		
		
		
		default boolean CambiarContraseña() {
			return true;
		}
		
		 void Menu();
	
}
