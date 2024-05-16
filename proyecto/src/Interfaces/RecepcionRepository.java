package Interfaces;

import java.util.List;

import Modelo.Recepcion;

public interface RecepcionRepository {
	
	 List<Recepcion> getAllRecepcion(); // llama a todos los Recepcion de la bdd
	    
	 Recepcion getRecepcionById(int id); //llama solo a uno, por su id
	    
	    void addRecepcion(Recepcion recepcion); //añade Recepcion a la bdd
	    
	    void updateRecepcion(Recepcion recepcion); //actualiza los Recepcion de la bdd
	    
	    void deleteRecepcion(int id); //eliminar Recepcion de la bdd

}
