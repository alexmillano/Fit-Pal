package Controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Interfaces.RutinaRepository;
import Modelo.Cliente;
import Modelo.Profesor;
import Modelo.Rutina;

public class RutinaControlador implements RutinaRepository {
	private final Connection connection;
	
	
	  public RutinaControlador() {
	        this.connection = DatabaseConnection.getInstance().getConnection();
	    }


	@Override
	public List<Rutina> getAllRutina() {
        List<Rutina> rutinas_bd = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM rutinas ");
            ResultSet resultSet = statement.executeQuery();
       
            while (resultSet.next()) {
            	Rutina rutina = new Rutina (resultSet.getInt("ID_Rutinas"),resultSet.getInt("ID_Profesor")
            			, resultSet.getInt("ID_Nivel"), resultSet.getString("Nombre"));
                rutinas_bd.add(rutina);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rutinas_bd;
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
