package Controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import Interfaces.Cliente_Rutina_ClaseRepository;
import Modelo.Cliente_Rutina_Clase;

public class Cliente_Rutina_ClaseControlador implements Cliente_Rutina_ClaseRepository{
    private final Connection connection;

    public Cliente_Rutina_ClaseControlador() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

	@Override
	public List<Cliente_Rutina_Clase> getAllClienteRutinaClase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente_Rutina_Clase getClienteRutinaClaseById(int ID_Cliente, int ID_Rutina, int ID_Clase) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addClienteRutinaClase(Cliente_Rutina_Clase Cliente_Rutina_Clase) {
		try {
        	PreparedStatement statement = connection.prepareStatement("INSERT INTO cliente_rutina_clase(ID_Cliente, ID_Rutinas, ID_Clases) "
        			+ "VALUES (?,?,?)");
        	statement.setInt(1, Cliente_Rutina_Clase.getID_Cliente());
        	statement.setInt(2, Cliente_Rutina_Clase.getID_Rutina());
        	statement.setInt(3, Cliente_Rutina_Clase.getID_Clase());

        
        int rowsInserted = statement.executeUpdate();
        	if (rowsInserted > 0) {
            System.out.println("cliente_rutina_clases insertada exitosamente");
        	}
        	} catch (SQLException e) {
        		e.printStackTrace();
        	}
		
	}

	@Override
	public void updateClase(Cliente_Rutina_Clase Cliente_Rutina_Clase) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteClase(int ID_Cliente, int ID_Rutina, int ID_Clase) {
		// TODO Auto-generated method stub
		
	}
    
    
}
