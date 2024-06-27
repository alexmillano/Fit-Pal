package Interfaces;

import java.time.LocalTime;
import java.util.List;

import Modelo.Clase;

public interface ClaseRepository {
	
    List<Clase> getAllClase(); // llama a todos las clientes de la bdd
    
    Clase getClaseById(int id); //llama solo a uno, por su id
    
    boolean addClase(int profesorId, String nombre, LocalTime inicio, LocalTime fin, int nivel); //añade clase a la bdd
    
    boolean updateClase(int profesorId, String nombre, LocalTime inicio, LocalTime fin, int nivel,int ID_Clases); //actualiza las clase de la bdd
    
    boolean deleteClase(int id); //eliminar clase de la bdd
}
