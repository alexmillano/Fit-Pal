package Controladores;

import java.sql.Connection;
import java.util.List;

import Interfaces.EjercicioRepository;
import Modelo.Ejercicio;

public class EjercicioControlador implements EjercicioRepository{
	private final Connection connection;
	
	
	  public EjercicioControlador() {
	        this.connection = DatabaseConnection.getInstance().getConnection();
	    }


	@Override
	public List<Ejercicio> getAllEjercicio() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Ejercicio getEjercicioById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void addEjercicio(Ejercicio ejercicio) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateEjercicio(Ejercicio ejercicio) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteEjercicio(int id) {
		// TODO Auto-generated method stub
		
	}


}
