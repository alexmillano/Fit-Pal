package Interfaces;

import java.time.LocalDateTime;
import java.util.List;

import Modelo.Clase;
import Modelo.Profesor;

public interface ClaseRepository {
	
    List<Clase> getAllClase(); // llama a todos las clientes de la bdd
    
    Clase getClaseById(int id); //llama solo a uno, por su id
    
    void addClase(Profesor profesor, String nombre, LocalDateTime inicio, LocalDateTime fin, int nivel); //añade clase a la bdd
    
    void updateClase(Clase clase); //actualiza las clase de la bdd
    
    void deleteClase(int id); //eliminar clase de la bdd
}
