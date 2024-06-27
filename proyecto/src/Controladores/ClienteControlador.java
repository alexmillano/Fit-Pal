package Controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import Interfaces.ClienteRepository;
import Modelo.Cliente;
import Modelo.Cuota;

public class ClienteControlador implements ClienteRepository {
    private final Connection connection;
    private int lastInsertedClientId;

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
            	Cliente user = new Cliente(resultSet.getInt("id_cliente"),resultSet.getString("Nombre"), resultSet.getString("Apellido"),
            			resultSet.getString("Contraseña"), resultSet.getInt("DNI"),resultSet.getString("Correo"), 
            			resultSet.getInt("ID_Nivel"),resultSet.getInt("Telefono"));
                users.add(user);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }


    
    @Override
    public Cliente getClienteById(int id) {
    	Cliente user = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM cliente WHERE ID_Cliente = ?");
            statement.setInt(1, id);
            
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
            	user = new Cliente(resultSet.getString("Nombre"), resultSet.getString("Apellido"),
            			resultSet.getString("Contraseña"), resultSet.getInt("DNI"),resultSet.getString("Correo"), 
            			resultSet.getInt("ID_Nivel"),resultSet.getInt("Telefono"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    
    
 
	@Override
	public void addCliente(String nombre, String apellido, int dni, String contraseña, String correo, int nivel, int telefono, Cuota cuota) {
	    
	    try {
	        System.out.println("Intentando agregar cliente:");
	        System.out.println("Nombre: " + nombre);
	        System.out.println("Apellido: " + apellido);
	        System.out.println("DNI: " + dni);
	        System.out.println("Contraseña: " + contraseña);
	        System.out.println("Correo: " + correo);
	        System.out.println("Nivel: " + nivel);
	        System.out.println("Teléfono: " + telefono);
	        System.out.println("ID Cuota: " + cuota);

	        String sql = "INSERT INTO cliente(Contraseña, Apellido, DNI, Correo, Telefono, Nombre, ID_Nivel, ID_Cuota) "
	                   + "VALUES (?, ?, ?, ?, ?, ?, ?, NULL)";

	        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	        statement.setString(1, contraseña);
	        statement.setString(2, apellido);
	        statement.setInt(3, dni);
	        statement.setString(4, correo);
	        statement.setInt(5, telefono);
	        statement.setString(6, nombre);
	        statement.setInt(7, nivel);
	        

	        int rowsInserted = statement.executeUpdate();
	        if (rowsInserted > 0) {
	            System.out.println("Cliente insertado exitosamente");

	            ResultSet generatedKeys = statement.getGeneratedKeys();
	            if (generatedKeys.next()) {
	            	lastInsertedClientId = generatedKeys.getInt(1);
	                System.out.println("ID del cliente generado: " + lastInsertedClientId);

	                Cliente clienteSetearId = new Cliente();
	                clienteSetearId.setID_Cliente(lastInsertedClientId);
	                clienteSetearId.setNombre(nombre);
	                clienteSetearId.setApellido(apellido);
	                clienteSetearId.setDni(dni);
	                clienteSetearId.setContraseña(contraseña);
	                clienteSetearId.setCorreo(correo);
	                clienteSetearId.setNivel(nivel);
	                clienteSetearId.setTelefono(telefono);
	                

	                System.out.println("ID del cliente actual: " + clienteSetearId.getID_Cliente());
	                
	            } else {
	                System.out.println("Fallo al obtener el ID del cliente insertado.");
	            }
	        }
	    } catch (SQLException e) {
	        System.out.println("Error al agregar cliente: " + e.getMessage());
	        e.printStackTrace();
	        
	    }
	}
	
	public int getLastInsertedClientId() {
        return lastInsertedClientId;
    }
	
	@Override
    public boolean updateCliente(Cliente cliente) {
		boolean actualizar = false;
		try {
			PreparedStatement statement = connection.prepareStatement("UPDATE users SET Nombre = ?, Correo = ? WHERE ID_Cliente = ?");
	        statement.setString(1, cliente.getNombre());
	        statement.setString(2, cliente.getCorreo());
	        statement.setInt(3, cliente.getID_Cliente());

	        
	        int rowsUpdated = statement.executeUpdate();
	        if (rowsUpdated > 0) {
	            System.out.println("Cliente actualizado correctamente");
	            
	            
	            actualizar = true;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        actualizar = false;
	    }
		return actualizar;
    }

	@Override
	public void deleteCliente(int idCliente) {
	    try {
	        PreparedStatement statement = connection.prepareStatement("DELETE FROM cliente WHERE ID_Cliente = ?");
	        statement.setInt(1, idCliente);

	        int rowsDeleted = statement.executeUpdate();
	        if (rowsDeleted > 0) {
	            System.out.println("Cliente eliminado exitosamente");
	        } else {
	            System.out.println("Cliente no encontrado");
	        }
	    } catch (SQLException e) {
	        System.out.println("Error al eliminar el cliente: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	public int getClienteIdPorDni(int dni) {
	    int id = -1;
	    try {
	        PreparedStatement statement = connection.prepareStatement(
	            "SELECT ID_Cliente FROM cliente WHERE DNI = ?"
	        );
	        statement.setInt(1, dni);
	        ResultSet resultSet = statement.executeQuery();
	        if (resultSet.next()) {
	            id = resultSet.getInt("ID_Cliente");
	        }
	    } catch (SQLException e) {
	        System.out.println("Error al obtener el ID del cliente: " + e.getMessage());
	        e.printStackTrace();
	    }
	    return id;
	}
	
    
    
    @Override
    public List<Cliente> getAllClienteConID_Cliente() {
        List<Cliente> users = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM cliente ");
            ResultSet resultSet = statement.executeQuery();
       
            while (resultSet.next()) {
            	Cliente user = new Cliente( resultSet.getInt("ID_Cliente"), resultSet.getString("Nombre"), resultSet.getString("Apellido"),
            			resultSet.getString("Contraseña"), resultSet.getInt("DNI"),resultSet.getString("Correo"), 
            			resultSet.getInt("ID_Nivel"),resultSet.getInt("Telefono"));
                users.add(user);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

}