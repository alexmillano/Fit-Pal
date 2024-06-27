package Interfaces;

import java.util.List;

import Modelo.Rutinas_Ejercicios;

public interface Rutina_EjerciciosRepository {
	
    List<Rutinas_Ejercicios> getAllRutinasEjercicios();
    
    Rutinas_Ejercicios getRutinasEjerciciosById(int rutina); 
    
    void addRutinaEjercicio(Rutinas_Ejercicios rutinaejercicio); //añade clase a la bdd

	void deleteRutinaEjercicio(int idrutina);

	void updateRutinaEjercicio(Rutinas_Ejercicios rutinaejercicio);

}
