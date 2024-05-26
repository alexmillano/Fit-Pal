package Controladores;

import java.sql.Connection;
import java.util.List;

import Interfaces.ZonaRepository;
import Modelo.Zona_Ejercicio;

public class ZonaControlador implements ZonaRepository{
		private final Connection connection;
	
	
	  public ZonaControlador() {
	        this.connection = DatabaseConnection.getInstance().getConnection();
	    }


	@Override
	public List<Zona_Ejercicio> getAllZonas() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Zona_Ejercicio getZonaById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void addZona(Zona_Ejercicio zona_ejercicio) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateZona(Zona_Ejercicio zona_ejercicio) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteZona(int id) {
		// TODO Auto-generated method stub
		
	}


	  
}
