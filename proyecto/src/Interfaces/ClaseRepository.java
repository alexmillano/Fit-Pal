package Interfaces;

import java.util.List;

import Modelo.Clase;

public interface ClaseRepository {
	
    List<Clase> getAllClase(); // llama a todos las clientes de la bdd
    
    Clase getClaseById(int id); //llama solo a uno, por su id
    
    void addClase(Clase clase); //añade clase a la bdd
    
    void updateClase(Clase clase); //actualiza las clase de la bdd
    
    void deleteClase(int id); //eliminar clase de la bdd
}
