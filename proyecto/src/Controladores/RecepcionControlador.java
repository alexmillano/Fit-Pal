package Controladores;

import java.sql.Connection;
import java.util.List;

import Interfaces.RecepcionRepository;
import Modelo.Recepcion;

public class RecepcionControlador implements RecepcionRepository{
    private final Connection connection;

    public RecepcionControlador() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

	@Override
	public List<Recepcion> getAllRecepcion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Recepcion getRecepcionById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addRecepcion(Recepcion recepcion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateRecepcion(Recepcion recepcion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRecepcion(int id) {
		// TODO Auto-generated method stub
		
	}




}
