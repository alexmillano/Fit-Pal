package Interfaces;

import java.util.List;

import Modelo.Zona_Ejercicio;


public interface ZonaRepository {
	
	
	List<Zona_Ejercicio> getAllZonas(); // llama a todos las zonas de la bdd
    
    Zona_Ejercicio getZonaById(int id); //llama solo a una, por su id
    
    void addZona(Zona_Ejercicio zona_ejercicio); //añade zona a la bdd
    
    void updateZona(Zona_Ejercicio zona_ejercicio); //actualiza las zonas de la bdd
    
    void deleteZona(int id); //eliminar zona de la bdd
}
