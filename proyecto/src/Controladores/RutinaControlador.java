package Controladores;

import java.sql.Connection;
import java.util.List;

import Interfaces.RutinaRepository;
import Modelo.Profesor;
import Modelo.Rutina;

public class RutinaControlador implements RutinaRepository {
	private final Connection connection;
	
	
	  public RutinaControlador() {
	        this.connection = DatabaseConnection.getInstance().getConnection();
	    }


	@Override
	public List<Rutina> getAllRutina() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Profesor getRutinaById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void addRutina(Profesor profesor) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateRutina(Profesor profesor) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteRutina(int id) {
		// TODO Auto-generated method stub
		
	}
	  
}
