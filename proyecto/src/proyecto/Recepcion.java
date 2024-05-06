package proyecto;

import javax.swing.JOptionPane;

public class Recepcion extends Persona implements MenuIniciarSesion {

		private int ID_recepcion;
		
		//Lista de todas las cuotas
		//Lista de todos los clientes

		public Recepcion(String nombre, String apellido, String contraseña, int dNI, String correo, int iD_recepcion) {
			super(nombre, apellido, contraseña, dNI, correo);
			ID_recepcion = iD_recepcion;
		}

		public int getID_recepcion() {
			return ID_recepcion;
		}

		public void setID_recepcion(int iD_recepcion) {
			ID_recepcion = iD_recepcion;
		}

		@Override
		public String toString() {
			return "ID Recepcion: " + ID_recepcion;
		}

		@Override
		public void Menu() {
			int contswitchgeneral=0;////Contador para salir del do general, es decir para cerrar sesion.
			do {
							
				String [] opcionesRol={"Cuotas", "Usuarios", "Clases", "Cronograma", "Perfil" ,"Cerrar sesion"};
				int opcionRol= JOptionPane.showOptionDialog(null, "Seleccione su rol", "Menú recepcion", 0, 0, null, opcionesRol, opcionesRol[0]);
				
				switch (opcionRol) {
				case 0://Cuotas
									
					int cont0=0;//Contador para salir de Cuotas y volver al menu principal de Recepcion
					do {
						
						String [] opcionesCuotas={"Asignar valor", "Ver cuotas socios", "Volver"};
						int opcionCuota= JOptionPane.showOptionDialog(null, "Seleccione una opcion", "Menú Cliente", 0, 0, null, opcionesCuotas, opcionesCuotas[0]);
						
						switch (opcionCuota) {
						case 0://Asignar valor
							
							break;
							
						case 1://Ver cuota socios
							
							break;
			
						case 2://Volver
							cont0++;
							break;
						}
						
					} while (cont0==0);
					
					break;
		
				
				
				
				
				case 1://Usuarios
					
					int cont1=0;//Contador para salir de Usuarios y volver al menu principal de Recepcion
					do {
						
						String [] opcionesUsuarios={"Dar de alta", "Dar de baja", "Socios registrados" ,  "Volver"};
						int opcionUsuario= JOptionPane.showOptionDialog(null, "Seleccione una opcion", "Menú Cliente", 0, 0, null, opcionesUsuarios, opcionesUsuarios[0]);
						
						switch (opcionUsuario) {
						case 0://Dar de alta
							
							break;
							
						case 1://Dar de baja
							
							break;
			
						case 2://Socios registrados
							
							break;
												
						case 3://Volver
							cont1++;
							break;
						}
						
					} while (cont1==0);
					
					break;
					
					
				
				case 2://Clase
					
					int cont2=0;//Contador para salir de Clase y volver al menu principal de Recepcion
					do {
						
						String [] opcionesClases={"Crear clase", "Ver informacion", "Volver"};
						int opcionClases= JOptionPane.showOptionDialog(null, "Seleccione una opcion", "Menú Cliente", 0, 0, null, opcionesClases, opcionesClases[0]);
						
						switch (opcionClases) {
						case 0://Crear clase
							
							break;
							
						case 1://Ver informacion
							
							break;
			
						case 2://Volver
							cont2++;
							break;
						}
						
					} while (cont2==0);
					
					break;
					
					
					
				case 3://Cronograma
					
					break;	
					
					
				case 4://Perfil
					
					int cont4=0;//Contador para salir de Perfil y volver al menu principal de Recepcion
					do {
						
						String [] opcionesPerfil={"Cambiar contraseña", "Volver"};
						int opcionPerfil= JOptionPane.showOptionDialog(null, "Seleccione una opcion", "Menú Cliente", 0, 0, null, opcionesPerfil, opcionesPerfil[0]);
						
						switch (opcionPerfil) {
						case 0://Cambiar contraseña
							
							break;
							
						case 1://Volver
							cont4++;
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
