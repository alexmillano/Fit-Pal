package Test_Franco;
import Modelo.Cliente;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Controladores.ClienteControlador;

public class Prueba {
	@Test
	public void PruebaIniciarSesionV() {
		ClienteControlador controlador = new ClienteControlador();
		boolean flag =false;
		
		for (Cliente cliente : controlador.getAllCliente()) {
			if (cliente.IniciarSesion("pablo.fernandez@davinci.edu.ar","123")==true) {
				flag=true;
				break;
			}
		}
		
		assertEquals(true,flag);
	}
	

	
}
