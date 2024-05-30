package Validaciones;

import javax.swing.JOptionPane;

public interface Validaciones_Interface {


	public static String ValidarEsNumero(String cadena) {
		
		try {
			
			boolean flag;
			do {
				flag=true;
							
				if (cadena.length()==0) {
					flag=false;
				}else {
					for (int i = 0; i < cadena.length(); i++) {
						
						if (!Character.isDigit(cadena.charAt(i))) {
							flag=false;
						}
					}
				}
				
				if (flag==false || Integer.parseInt(cadena)<0) {
					cadena=JOptionPane.showInputDialog("Error. Debe ingresar un número válido.");
				}
				
			} while (flag==false);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocurrió un error inesperado");
		}
		

		return cadena;

	}
	
	
	
public static String ValidarEsMail(String cadena) {
		
		try {
			boolean flag;
			do {
				
				flag=true;						
				
				if (cadena.length()==0 || !cadena.contains("@")) {
					flag=false;	 
					cadena = JOptionPane.showInputDialog("Ingrese correctamente el mail");
				}
				
			} while (flag==false);
					
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocurrió un error inesperado");
		}
		return cadena;
	}
	
}
