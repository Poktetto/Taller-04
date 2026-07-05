package Visitor;

import Dominio.Carta;
import java.io.*;
import java.io.File;
public class BuscarImagenVisitor implements IVisitor {

	public BuscarImagenVisitor() {
		// TODO Auto-generated constructor stub
	}

	public void visitar(Carta carta) {
		try {
		String rutaImagen= "images/"+carta.getNombre()+".png";
		
		if (existeArchivo(rutaImagen)) { //verifica si es la imagen existente es png
			carta.setRutaImagen(rutaImagen);
			
		}else {//si no busca jpg
			rutaImagen= "images/"+carta.getNombre()+".jpg";
			carta.setRutaImagen(rutaImagen);
			
		}
		

	}catch(Exception e) {
		System.out.println("La imagen no existe");
		
	}
	}
	
	
	private boolean existeArchivo (String rutaImagen) {// para revisar su existencia en el disco
		File arch = new File(rutaImagen); 
		
		return arch.exists();
		
	}

}
