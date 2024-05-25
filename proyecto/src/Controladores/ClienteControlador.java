package Controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Interfaces.ClienteRepository;
import Modelo.Cliente;

public class ClienteControlador implements ClienteRepository {
    private final Connection connection;

    public ClienteControlador() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public List<Cliente> getAllCliente() {
        List<Cliente> users = new ArrayList<>();/*
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users ");
            ResultSet resultSet = statement.executeQuery();
       
            while (resultSet.next()) {
            	Cliente user = new Cliente(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("email"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        return users;
    }

    @Override
    public Cliente getClienteById(int id) {
    	Cliente user = null;/*
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
            statement.setInt(1, id);
            
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                user = new Usuario(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        return user;
    }

	@Override
    public void addCliente(Cliente cliente) {
        try {
        	PreparedStatement statement = connection.prepareStatement("INSERT INTO clientes (nombre, apellido, contraseña, dni, correo, nivel, telefono) VALUES (?, ?, ?, ?, ?, ?, ?)");
        	statement.setString(1, cliente.getNombre());
        	statement.setString(2, cliente.getApellido());
        	statement.setString(3, cliente.getContraseña());
        	statement.setInt(4, cliente.getDni());
        	statement.setString(5, cliente.getCorreo());
        	statement.setString(6, cliente.getNivel());
        	statement.setInt(7, cliente.getTelefono());
        
        int rowsInserted = statement.executeUpdate();
        	if (rowsInserted > 0) {
            System.out.println("Cliente insertado exitosamente");
        	}
        	} catch (SQLException e) {
        		e.printStackTrace();
        	}
    }

	@Override
    public void updateCliente(Cliente cliente) {/*
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
        }*/
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
    }





  
}