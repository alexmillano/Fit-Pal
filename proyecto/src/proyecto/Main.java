package proyecto;

import javax.swing.JOptionPane;

public class Main implements MenuIniciarSesion{

	public static void main(String[] args) {
		
		Recepcion recepcion1= new Recepcion("Franco", "Jarc", "franco123",45415444,"franco.jarc@davinci.edu.ar",1);
		Profesor profesor1= new Profesor("Franco", "Jarc", "franco123",45415444,"franco.jarc@davinci.edu.ar",1);
		Cliente cliente1= new Cliente("Franco", "Jarc", "franco123",45415444,"franco.jarc@davinci.edu.ar","Intermedio",1,1124655611);
		String devolucion= recepcion1.IniciarSesion();
		
		switch (devolucion) {
		case "profesor":
			
			profesor1.Menu();
			
			break;
			
		case "cliente":
			
			cliente1.Menu();
					
			break;

		case "recepcion":
			
			recepcion1.Menu();
									
			break;
		}
		

	}

	@Override
	public void Menu() {
		// TODO Auto-generated method stub
		
	}


}
