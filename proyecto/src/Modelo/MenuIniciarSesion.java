package Modelo;

import javax.swing.JOptionPane;

import Controladores.ClienteControlador;
import Controladores.ProfesorControlador;
import Controladores.RecepcionControlador;
import Validaciones.Validaciones_Interface;

public interface MenuIniciarSesion {
	
		default boolean IniciarSesion(String mail, String contrasena) {
			mail = Validaciones_Interface.ValidarEsMail(mail);
			contrasena = Validaciones_Interface.ValidarEsNumero(contrasena);
			
			ClienteControlador clientecontrolador = new ClienteControlador();
			RecepcionControlador recepcioncontrolador = new RecepcionControlador();
			ProfesorControlador profesorcontrolador = new ProfesorControlador();

			boolean flag=false;
			
			for (Cliente cliente : clientecontrolador.getAllCliente()) {
				if (cliente.getCorreo().equals(mail) && cliente.getContraseña().equals(contrasena)) {	
					JOptionPane.showMessageDialog(null, "Email correcto");
					flag=true;
					break;
				}
			}
			
			for (Recepcion recepcion : recepcioncontrolador.getAllRecepcion()) {
				if (recepcion.getCorreo().equals(mail) && recepcion.getContraseña().equals(contrasena)) {	
					JOptionPane.showMessageDialog(null, "Email correcto");
					flag=true;
					break;
				}
			}
			
			for (Profesor profesor : profesorcontrolador.getAllProfesor()) {
				if (profesor.getCorreo().equals(mail) && profesor.getContraseña().equals(contrasena)) {	
					JOptionPane.showMessageDialog(null, "Email correcto");
					flag=true;
					break;
				}
			}
			
			
			return flag;
			
		};
		
		
		
		default boolean CambiarContraseña() {
			return true;
		}
		
		 void Menu();
	
}
