package Validaciones;

import javax.swing.JOptionPane;

public interface Validaciones_Interface {


	public static String ValidarEsNumero(String cadena) {
		
		try {	
			
	          if (cadena.isEmpty() || !cadena.chars().allMatch(Character::isDigit) || Integer.parseInt(cadena) < 0) {
	                return "Error. Debe ingresar una contraseña numerica valida.";
	            }
	        } catch (NumberFormatException e) {
	            e.printStackTrace();
	            return "Ocurrió un error inesperado en su contraseña";
	        }
	        return cadena;
	    }
			
			
			
			
			
			/*	
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
					cadena="Error. Debe ingresar unna contraseña numerica valida.";
				}
				
			} while (flag==false);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return "Ocurrió un error inesperado en su contraseña";
		}

		return cadena;

	}*/
	
	
	
	  public static String ValidarEsMail(String cadena) {
	        try {
	            if (cadena.isEmpty() || !cadena.contains("@")) {
	                return "Ingrese correctamente el mail";
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            return "Ocurrió un error inesperado con su mail";
	        }
	        return cadena;
	    }
	  
	
	/*
	public static String ValidarEsMail(String cadena) {
		
		try {
			boolean flag;
			do {
				
				flag=true;						
				
				if (cadena.length()==0 || !cadena.contains("@")) {
					flag=false;	 
					cadena = "Ingrese correctamente el mail";
				}
				
			} while (flag==false);
					
		} catch (Exception e) {
			e.printStackTrace();
			return "Ocurrió un error inesperado con su mail";
		}
		return cadena;
	}*/
	
}
