package Controladores;

import java.sql.Connection;

import Interfaces.ClaseRepository;

public class ClasesControlador implements ClaseRepository{
	private final Connection connection;
	
	
	  public ClasesControlador() {
	        this.connection = DatabaseConnection.getInstance().getConnection();
	    }

}
