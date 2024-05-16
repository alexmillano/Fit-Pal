package Modelo;

import javax.swing.JOptionPane;

public class Profesor extends Persona implements MenuIniciarSesion {
	private int ID_Profesor;
	
	//Lista de clases
	//Lista de rutinas
	

	public Profesor(String nombre, String apellido, String contraseña, int dNI, String correo, int iD_Profesor) {
		super(nombre, apellido, contraseña, dNI, correo);
		ID_Profesor = iD_Profesor;
	}

	public int getID_Profesor() {
		return ID_Profesor;
	}

	public void setID_Profesor(int iD_Profesor) {
		ID_Profesor = iD_Profesor;
	}

	@Override
	public String toString() {
		return "ID Profesor: " + ID_Profesor;
	}
	
	public void ArmarRutinas() {
		
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
	
	
	
}
