package Controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Interfaces.RecepcionRepository;
import Modelo.Profesor;
import Modelo.Recepcion;

public class RecepcionControlador implements RecepcionRepository{
    private final Connection connection;

    public RecepcionControlador() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

	@Override
	public List<Recepcion> getAllRecepcion() {
		List<Recepcion> recepcionLista = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM recepcion ");
            ResultSet resultSet = statement.executeQuery();
       
            while (resultSet.next()) {
            	Recepcion recepcion = new Recepcion(resultSet.getString("Nombre"), resultSet.getString("Apellido"),
            			resultSet.getString("Contraseña"), resultSet.getInt("DNI"),resultSet.getString("Correo"),  resultSet.getInt("ID_Recepcion"));
            	recepcionLista.add(recepcion);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recepcionLista;
	}

	@Override
	public Recepcion getRecepcionById(int id) {
		Recepcion recepcion = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM recepcion WHERE ID_Recepcion = ?");
            statement.setInt(1, id);
            
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
            	recepcion = new Recepcion(resultSet.getString("Nombre"), resultSet.getString("Apellido"),
            			resultSet.getString("Contraseña"), resultSet.getInt("DNI"),resultSet.getString("Correo"), resultSet.getInt("ID_Recepcion"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recepcion;
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
	
	
	
	public List<Recepcion> getAllRecepcionConIDRecepcion() {
		List<Recepcion> recepciones = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM recepcion ");
            ResultSet resultSet = statement.executeQuery();
       
            while (resultSet.next()) {
            	Recepcion recepcion = new Recepcion(resultSet.getString("Nombre"), resultSet.getString("Apellido"),
            			resultSet.getString("Contraseña"), resultSet.getInt("DNI"),resultSet.getString("Correo"),resultSet.getInt("ID_Recepcion"));
            	recepciones.add(recepcion);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recepciones;
	}




}
