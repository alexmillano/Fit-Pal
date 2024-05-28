package Controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Interfaces.ClaseRepository;
import Modelo.Clase;
import Modelo.Cliente;

public class ClaseControlador implements ClaseRepository{
	private final Connection connection;
	
	
	  public ClaseControlador() {
	        this.connection = DatabaseConnection.getInstance().getConnection();
	    }


	@Override
	public List<Clase> getAllClase() {
        List<Clase> clases = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM clases ");
            ResultSet resultSet = statement.executeQuery();
            
            /*
            while (resultSet.next()) {
            	Clase clase = new Clase(resultSet.getString("Nombre"), resultSet.getString("Apellido"),
            			resultSet.getString("Contraseña"), resultSet.getInt("DNI"),resultSet.getString("Correo"), 
            			resultSet.getInt("ID_Nivel"),resultSet.getInt("Telefono"));
            	clases.add(clase);
                
            }*/
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clases;
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
