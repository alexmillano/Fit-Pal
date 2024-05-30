package Modelo;

public class Cliente_Rutina_Clase {
	private int ID_Cliente;
	private int ID_Rutina;
	private int ID_Clase;
	
	
	public Cliente_Rutina_Clase(int iD_Cliente, int iD_Rutina, int iD_Clase) {
		super();
		ID_Cliente = iD_Cliente;
		ID_Rutina = iD_Rutina;
		ID_Clase = iD_Clase;
	}
	
	public int getID_Cliente() {
		return ID_Cliente;
	}
	public void setID_Cliente(int iD_Cliente) {
		ID_Cliente = iD_Cliente;
	}
	public int getID_Rutina() {
		return ID_Rutina;
	}
	public void setID_Rutina(int iD_Rutina) {
		ID_Rutina = iD_Rutina;
	}
	public int getID_Clase() {
		return ID_Clase;
	}
	public void setID_Clase(int iD_Clase) {
		ID_Clase = iD_Clase;
	}
	
	
}
