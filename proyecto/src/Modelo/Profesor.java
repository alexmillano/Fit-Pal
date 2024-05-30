package Modelo;

import java.time.LocalTime;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import Controladores.ClienteControlador;
import Controladores.ProfesorControlador;
import Controladores.RutinaControlador;
import Validaciones.Validaciones_Interface;


public class Profesor extends Persona implements MenuIniciarSesion, Validaciones_Interface {
	private int ID_Profesor;
	
	//Lista static para agregar a todos los profesores que se crean
	static LinkedList<Profesor> profesores_general = new LinkedList<>();
	
	//Lista de las clases que da el profesor
	private LinkedList<Clase> mis_clases = new LinkedList<>();
	
	//Lista de las rutinas que hace el profesor
	private LinkedList<Rutina> mis_rutinas = new LinkedList<>();
		

	public Profesor(String nombre, String apellido, String contraseña, int dNI, String correo) {
		super(nombre, apellido, contraseña, dNI, correo);
		
	}
	
	//Creado solo para probar el test
	public Profesor(int ID_Profesor,String nombre, String apellido, String contraseña, int dNI, String correo) {
		super(nombre, apellido, contraseña, dNI, correo);
		this.ID_Profesor=ID_Profesor;
	}


	public int getID_Profesor() {
		return ID_Profesor;
	}

	public void setID_Profesor(int iD_Profesor) {
		ID_Profesor = iD_Profesor;
	}

	public static LinkedList<Profesor> getProfesores_general() {
		return profesores_general;
	}

	public static void setProfesores_general(LinkedList<Profesor> profesores_general) {
		Profesor.profesores_general = profesores_general;
	}

	public LinkedList<Clase> getMis_clases() {
		return mis_clases;
	}

	public void setMis_clases(LinkedList<Clase> mis_clases) {
		this.mis_clases = mis_clases;
	}

	public LinkedList<Rutina> getMis_rutinas() {
		return mis_rutinas;
	}

	public void setMis_rutinas(LinkedList<Rutina> mis_rutinas) {
		this.mis_rutinas = mis_rutinas;
	}


	
	@Override
	public String toString() {
		return "Profesor [ID_Profesor=" + ID_Profesor + ", mis_clases=" + mis_clases + ", mis_rutinas=" + mis_rutinas
				+ "]";
	}


	@Override
	public void Menu() {
		int contswitchgeneral=0; //Contador para salir del do general, es decir para cerrar sesion.
			do {
				
				String [] opcionesRol={"Rutina", "Ejercicio", "Clases", "Cliente", "Perfil" ,"Cerrar sesion"};
				int opcionRol= JOptionPane.showOptionDialog(null, "Seleccione su rol", "Menú profesor", 0, 0, null, opcionesRol, opcionesRol[0]);
				
				switch (opcionRol) {
				
				case 0: //Rutina
					
					int cont0=0; //Contador para salir de rutina y volver al menu principal del Profesor
					do {
						
						String [] opcionesRutina={"Armar rutina", "Ver rutina", "Volver"};
						int opcionRutina= JOptionPane.showOptionDialog(null, "Seleccione una opcion", "Menú Cliente", 0, 0, null, opcionesRutina, opcionesRutina[0]);
						
						switch (opcionRutina) {
						case 0://Armar rutina
							
							break;
							
						case 1://Ver rutina
							
							break;
			
						case 2://Volver
							cont0++;
							break;
						}
						
					} while (cont0==0);
					
					break;
					
						
				case 1://Ejercicio
			
					int cont1=0;//Contador para salir de ejercicio y volver al menu principal del Profesor
					do {
						
						String [] opcionesEjercicio={"Crear ejercicio", "Ver ejercicio", "Volver"};
						int opcionEjercicio= JOptionPane.showOptionDialog(null, "Seleccione una opcion", "Menú Cliente", 0, 0, null, opcionesEjercicio, opcionesEjercicio[0]);
						
						switch (opcionEjercicio) {
						case 0://Crear ejercicio
							
							break;
							
						case 1://Ver ejercicio
							
							break;
			
						case 2:
							cont1++;
							break;

						}
						
					} while (cont1==0);
					
					break;
					
					
										
				case 2://Clases
					
					int cont2=0;//Contador para salir de Clases y volver al menu principal del Profesor
					do {
						
						String [] opcionesClases={"Armar clase", "Ver clases", "Volver"};
						int opcionClases= JOptionPane.showOptionDialog(null, "Seleccione una opcion", "Menú Cliente", 0, 0, null, opcionesClases, opcionesClases[0]);
						
						switch (opcionClases) {
						case 0://Armar clase
							
							break;
							
						case 1://Ver clase
							
							break;
			
						case 2://Volver
							cont2++;
							break;
						}
						
					} while (cont2==0);
					
					break;

					
					
				case 3://Cliente
					
					int cont3=0;//Contador para salir de Cliente y volver al menu principal del Profesor
					do {
						
						String [] opcionesCliente={"Subir nivel", "Volver"};
						int opcionClases= JOptionPane.showOptionDialog(null, "Seleccione una opcion", "Menú Cliente", 0, 0, null, opcionesCliente, opcionesCliente[0]);
						
						switch (opcionClases) {
						case 0://Subir nivel
							
							break;
							
						case 1://Volver
							cont3++;
							break;
						}
						
					} while (cont3==0);
					
					break;
					
					
				case 4://Perfil
					
					int cont4=0;//Contador para salir de Perfil y volver al menu principal del Profesor
					do {
						
						String [] opcionesPerfil={"Cambiar contraseña", "Volver"};
						int opcionPerfil= JOptionPane.showOptionDialog(null, "Seleccione una opcion", "Menú Cliente", 0, 0, null, opcionesPerfil, opcionesPerfil[0]);
						
						switch (opcionPerfil) {
						case 0:
							
							break;
							
						case 1:
							cont4++;
							break;
			
						default:
							break;
						}
						
					} while (cont4==0);
					
					break;
					
				
					
				case 5://Cerrar sesion
					contswitchgeneral++;
					break;
					
				
				}
		
		} while (contswitchgeneral==0);
	}
	
	
	@Override
	public boolean IniciarSesion(String mail, String contrasena) {
		ProfesorControlador controlador = new ProfesorControlador();
		mail = Validaciones_Interface.ValidarEsMail(mail);
		contrasena = Validaciones_Interface.ValidarEsNumero(contrasena);
		boolean flag=false;
		
		for (Profesor profesor : controlador.getAllProfesor()) {
			if (profesor.getCorreo().equals(mail) && profesor.getContraseña().equals(contrasena)) {	
				/*JOptionPane.showMessageDialog(null, "Email correcto");*/
				flag=true;
				break;
			}
		}
		
		return flag;
	}
	
	
}
