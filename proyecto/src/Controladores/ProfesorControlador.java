package Controladores;

import java.sql.Connection;
import java.util.List;

import Interfaces.ProfesorRepository;
import Modelo.Profesor;

public class ProfesorControlador implements ProfesorRepository{
	private final Connection connection;
	
	
	  public ProfesorControlador() {
	        this.connection = DatabaseConnection.getInstance().getConnection();
	    }


	@Override
	public List<Profesor> getAllProfesor() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Profesor getProfesorById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void addProfesor(Profesor profesor) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateProfesor(Profesor profesor) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteProfesor(int id) {
		// TODO Auto-generated method stub
		
	}
	  
}
