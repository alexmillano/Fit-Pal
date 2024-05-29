package Validaciones;

import javax.swing.JOptionPane;

public interface Validaciones_Interface {

	public default String ValidarEsNumero(String cadena) {
		
		boolean flag;
		do {
			flag=true;
			
			
			if (cadena.length()==0) {
				flag=false;
			}else {
				for (int i = 0; i < cadena.length(); i++) {
					
					if (Character.isAlphabetic(cadena.charAt(i))) {
						flag=false;
					}
				}
			}

			
			if (flag==false) {
				cadena=JOptionPane.showInputDialog("Error. Debe ingresar un número.");
			}else if (Integer.parseInt(cadena)<0) {
				cadena=JOptionPane.showInputDialog("Error. Ingrese un número positivo.");
				flag=false;
			}
			
			return cadena;
			
		} while (flag==false);

	}
}
