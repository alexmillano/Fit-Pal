package Controladores;

import java.sql.Connection;
import java.util.List;

import Interfaces.ClaseRepository;
import Modelo.Clase;

public class ClaseControlador implements ClaseRepository{
	private final Connection connection;
	
	
	  public ClaseControlador() {
	        this.connection = DatabaseConnection.getInstance().getConnection();
	    }


	@Override
	public List<Clase> getAllClase() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Clase getClaseById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void addClase(Clase clase) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateClase(Clase clase) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteClase(int id) {
		// TODO Auto-generated method stub
		
	}

}
