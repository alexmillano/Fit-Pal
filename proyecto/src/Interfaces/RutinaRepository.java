package Interfaces;

import java.util.List;

import Modelo.Profesor;
import Modelo.Rutina;
public interface RutinaRepository {
List<Rutina> getAllRutina(); // llama a todos las rutinas de la bdd
    
    Profesor getRutinaById(int id); //llama solo a una, por su id
    
    void addRutina(Profesor profesor); //añade rutina a la bdd
    
    void updateRutina(Profesor profesor); //actualiza las rutinas de la bdd
    
    void deleteRutina(int id); //eliminar rutina de la bdd
}
