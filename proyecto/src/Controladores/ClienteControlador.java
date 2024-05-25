package Controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Interfaces.ClienteRepository;
import Modelo.Cliente;
import Modelo.Cuota;

public class ClienteControlador implements ClienteRepository {
    private final Connection connection;

    public ClienteControlador() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public List<Cliente> getAllCliente() {
        List<Cliente> users = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM cliente ");
            ResultSet resultSet = statement.executeQuery();
       
            while (resultSet.next()) {
            	Cliente user = new Cliente(resultSet.getString("Nombre"), resultSet.getString("Apellido"),
            			resultSet.getString("Contraseña"), resultSet.getInt("DNI"),resultSet.getString("Correo"), 
            			resultSet.getInt("ID_Nivel"),resultSet.getInt("ID_Cliente"),resultSet.getInt("Telefono"),resultSet.getInt("ID_Cuota"));
                users.add(user);
               
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    /*
    @Override
    public Cliente getClienteById(int id) {
    	Cliente user = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
            statement.setInt(1, id);
            
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                user = new Usuario(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }*/

	@Override
    public void addCliente(String nombre, String apellido, int dni, String contraseña, String correo, int nivel, int telefono, Cuota cuota) {
        try {
        	PreparedStatement statement = connection.prepareStatement("INSERT INTO cliente(Contraseña, Apellido, DNI, Correo, Telefono, Nombre, ID_Nivel, ID_Cuota) "
        			+ "VALUES (?,?,?,?,?,?,?,?,?,?)");
        	statement.setString(1, contraseña);
        	statement.setString(2, apellido);
        	statement.setInt(3, dni);
        	statement.setString(4, correo);
        	statement.setInt(5, telefono);
        	statement.setString(6, nombre);
        	statement.setInt(7, nivel);
        	statement.setInt(8, cuota.getID_Cuota());
        
        int rowsInserted = statement.executeUpdate();
        	if (rowsInserted > 0) {
            System.out.println("Cliente insertado exitosamente");
        	}
        	} catch (SQLException e) {
        		e.printStackTrace();
        	}
    }
	/*
	@Override
    public void updateCliente(Cliente cliente) {
		try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM clientes WHERE id = ?");
            statement.setInt(1, idCliente);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Cliente eliminado exitosamente");
            } else {
                System.out.println("No se encontró el cliente con el ID proporcionado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCliente(int idCliente) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM clientes WHERE id = ?");
            statement.setInt(1, idCliente);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Cliente eliminado exitosamente");
            } else {
                System.out.println("No se encontró el cliente con el ID proporcionado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

	}
}