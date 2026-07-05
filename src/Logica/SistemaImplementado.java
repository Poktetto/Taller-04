package Logica;

import java.util.ArrayList;
import java.util.List;
import Dominio.*;
import GUI.*;
import Strategy.*;
import Visitor.*;

public class SistemaImplementado implements Sistema{
	//Creacion de variables estaticas
	private static Sistema instancia; //para el Singleton
	private static List<Carta> cartas = new ArrayList<>();
	
	
	private void SistemaImplementado() {}
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
	public void agregarImagen() {
		IVisitor visitor = new BuscarImagenVisitor();
		for (Carta carta: cartas) {
			carta.aceptar(visitor);
		}
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
		//es medio especifico el ToString
		return cartas.get(i).toString();
	}
	@Override
	public String verNombreCarta(int i) {
		return cartas.get(i).getNombre();
	}
	@Override
	public void ordenarCartasRareza() {
		
		for (int i=0;i<cartas.size()-1;i++) {
			for (int j=0;j<cartas.size()-1;j++) {
				if(cartas.get(j).getRareza()<cartas.get(j+1).getRareza()) {
					Carta temp = cartas.get(j);
					cartas.set(j, cartas.get(j+1));
					cartas.set(j+1, temp);
				}
			}
		
		}
		
	}
	@Override
	public void odenarCartasPoder() {
		
		for (int i=0;i<cartas.size()-1;i++) {
			for (int j=0;j<cartas.size()-1;j++) {
				if(cartas.get(j).getPoder()<cartas.get(j+1).getPoder()) {
					Carta temp = cartas.get(j);
					cartas.set(j, cartas.get(j+1));
					cartas.set(j+1, temp);
				}
			}
		
		}
		
	}
	@Override
	public void calcularPoder() {
		CalcularPoderContexto contexto = new CalcularPoderContexto();
		for (int i =0;i<cartas.size();i++) {
			contexto.setStrategy(cartas.get(i).getTipo());
			cartas.get(i).setPoder(contexto.ejecutar(cartas.get(i).getDatos()));
		}

		
	}
	
	@Override
	public void eliminarCarta() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void ordenarCartasNombre() {
		for (int i=0;i<cartas.size()-1;i++) {
			for (int j=0;j<cartas.size()-1;j++) {
				if(cartas.get(j).getNombre().compareToIgnoreCase(cartas.get(j+1).getNombre())>0) {
					Carta temp = cartas.get(j);
					cartas.set(j, cartas.get(j+1));
					cartas.set(j+1, temp);
				}
			}
		}
	}
}
