package Controladores;

import java.sql.Connection;
import java.util.List;

import Interfaces.CuotaRepository;
import Modelo.Cuota;


public class CuotaControlador implements CuotaRepository{
	private final Connection connection;
	
	
	  public CuotaControlador() {
	        this.connection = DatabaseConnection.getInstance().getConnection();
	    }


	@Override
	public List<Cuota> getAllCuota() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Cuota getCuotaById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void addCuota(Cuota cuota) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateCuota(Cuota cuota) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteCuota(int id) {
		// TODO Auto-generated method stub
		
	}
	  
}
