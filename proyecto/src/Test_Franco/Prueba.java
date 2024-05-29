package Test_Franco;
import Modelo.Clase;
import Modelo.Cliente;
import Validaciones.Validaciones_Interface;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import org.junit.Test;

import Controladores.ClaseControlador;
import Controladores.ClienteControlador;

public class Prueba implements Validaciones_Interface{
	@Test
	public void PruebaIniciarSesionV() {
		ClienteControlador controlador = new ClienteControlador();
		boolean flag =false;
		
		for (Cliente cliente : controlador.getAllCliente()) {
			if (cliente.IniciarSesion("pablo.fernandez@davinci.edu.ar", ValidarEsNumero("123"))==true) {
				flag=true;
				break;
			}
		}
		
		assertEquals(true,flag);
	}
	
	
	@Test
	public void PruebaIniciarSesionF() {
		ClienteControlador controlador = new ClienteControlador();
		boolean flag =false;
		
		for (Cliente cliente : controlador.getAllCliente()) {
			if (cliente.IniciarSesion("alexander@gmail.com",ValidarEsNumero(""))==true) {
				flag=true;
				break;
			}
		}
		
		assertEquals(false,flag);
	}

	
	/* Tiene opciones para elegir
	@Test
	public void PruebaUnirseAClaseV() {
		Cliente clientePrueba = new Cliente("Prueba", "Prueba", "Prueba", 0, "Prueba", 1, 24658595);
		boolean flag =false;
		
		ClaseControlador controlador = new ClaseControlador();			
		LinkedList<Clase> clasesACoincidir = new LinkedList<>();
		
		if (controlador.getAllClase().size()>0) {
			for (int i = 0; i < controlador.getAllClase().size(); i++) {
				
				if (clientePrueba.getNivel()==controlador.getAllClase().get(i).getNivel()) {		
					clasesACoincidir.add(controlador.getAllClase().get(i));						
				}
			}
			
		}
		
		if (clasesACoincidir.size()>0) {
			Clase[] mostrarClase = new Clase[clasesACoincidir.size()];
			
			for (int i = 0; i < clasesACoincidir.size(); i++) {
				mostrarClase[i]= clasesACoincidir.get(i);
			}
			
			Clase claseSeleccionada= (Clase)JOptionPane.showInputDialog(null, "Seleccione la clase para unirse: " , "Elección de Clase", 0, null,  mostrarClase, mostrarClase[0]);
			
			if (claseSeleccionada!=null) {
				
				clientePrueba.getMis_clases().add(claseSeleccionada);
				JOptionPane.showMessageDialog(null, "Lista de tus clases.\n" + claseSeleccionada);			
				claseSeleccionada.getAlumnos_de_la_clase().add(clientePrueba);

				flag=true;
			
			}else {			
				JOptionPane.showMessageDialog(null, "Por favor seleccione una clase");
			}
		
		} else {				
			JOptionPane.showMessageDialog(null, "Por el momento no hay clases de tu nivel para unirte");
		}

		
		assertEquals(true,flag);
	}*/
	
	
	
	
	@Test
	public void PruebaUnirseAClaseV() {
		Cliente clientePrueba = new Cliente("Prueba", "Prueba", "Prueba", 0, "Prueba", 1, 24658595);
		boolean flag =false;
		
		ClaseControlador controlador = new ClaseControlador();			
		LinkedList<Clase> clasesACoincidir = new LinkedList<>();
		
		if (controlador.getAllClase().size()>0) {
			for (int i = 0; i < controlador.getAllClase().size(); i++) {
				
				if (clientePrueba.getNivel()==controlador.getAllClase().get(i).getNivel()) {		
					clientePrueba.getMis_clases().add(controlador.getAllClase().get(i));
					flag=true;
				}
			}
			
		}
		assertEquals(true,flag);
	}
	
	
	
	
	
	@Test
	public void PruebaUnirseAClaseF() {
		Cliente clientePrueba = new Cliente("Prueba", "Prueba", "Prueba", 0, "Prueba", 3, 24658595);
		boolean flag =false;
		
		ClaseControlador controlador = new ClaseControlador();			
		LinkedList<Clase> clasesACoincidir = new LinkedList<>();
		
		if (controlador.getAllClase().size()>0) {
			for (int i = 0; i < controlador.getAllClase().size(); i++) {
				
				if (clientePrueba.getNivel()==controlador.getAllClase().get(i).getNivel()) {		
					clientePrueba.getMis_clases().add(controlador.getAllClase().get(i));
					flag=true;
				}
			}
			
		}
		assertEquals(false,flag);
	}
	
	
	
	@Test
	public void PruebaUnirseAClaseF2() {
		Cliente clientePrueba = new Cliente("Prueba", "Prueba", "Prueba", 0, "Prueba", 3, 24658595);
		boolean flag =false;
		
		LinkedList<Clase> clases = new LinkedList<>();
		
		ClaseControlador controlador = new ClaseControlador();			
		LinkedList<Clase> clasesACoincidir = new LinkedList<>();
		
		if (clases.size()>0) {
			for (int i = 0; i < controlador.getAllClase().size(); i++) {
				
				if (clientePrueba.getNivel()==controlador.getAllClase().get(i).getNivel()) {		
					clientePrueba.getMis_clases().add(controlador.getAllClase().get(i));
					
				}
			}
			
		}else {
			flag=true;
		}
		
		assertEquals(true,flag);
	}
	
	
}
