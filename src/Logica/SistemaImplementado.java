package Logica;

import java.util.ArrayList;
import java.util.List;
import Dominio.*;
import GUI.*;

public class SistemaImplementado implements Sistema{
	//Creacion de variables estaticas
	private static Sistema instancia; //para el Singleton
	private static List<Carta> cartas = new ArrayList<>();
	
	
	private void SistemaImplentado() {}
	public static Sistema getInstance() {
		if (instancia==null) {
			instancia= new SistemaImplementado();
		}
		return instancia;
	}
	@Override
	public void crearSobres(String linea) {
		CartasFactory factory = new CartasFactory();
		cartas.add(factory.fabricarCarta(linea));
		
	}
	@Override
	public void crearGUI() {
		GUI gui = new GUI();
		
	}
	@Override
	public int verCantCartas() {
		return cartas.size();
	}
	@Override
	public String verCarta(int i) {
		return cartas.get(i).toString();
	}
	@Override
	public String verNombreCarta(int i) {
		return cartas.get(i).getNombre();
	}
	
	

}
