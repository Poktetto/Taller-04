package GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.SwingConstants;
import Logica.SistemaImplementado;
import Logica.Sistema;

public class GUI {
	private static int ultimaCarta;
	private static Sistema sistema =SistemaImplementado.getInstance(); //no estoy muy seguro pero creo que es asi
	public GUI(){
		JFrame ventana = new JFrame("Administrador de Cartas");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(300, 100);
		ventana.setLocationRelativeTo(null);
		ventana.getContentPane().add(crearGui(ventana));
		ventana.setVisible(true);
	}

	private JPanel crearGui(JFrame ventana) {
		JPanel panelPrincipal = new JPanel(new BorderLayout());
		JPanel botonera = new JPanel();
		
		JLabel titulo = new JLabel("Desea administrar O ver la coleccion?",SwingConstants.CENTER); // para el titulo
		
		JButton administracion = botonAdmin(ventana);
		JButton coleccion = botonColec(ventana);
		
		botonera.add(administracion);
		botonera.add(coleccion);
		
		panelPrincipal.add(titulo,BorderLayout.NORTH);
		panelPrincipal.add(botonera,BorderLayout.CENTER);
		return panelPrincipal;
	}

	private JButton botonColec(JFrame ventana) {
		JButton b = new JButton("Ver Coleccion");
		b.addActionListener(e->{
			JDialog ventanaColeccion = new JDialog(ventana,"Coleccion");
			ventanaColeccion.setSize(600,700);
			ventanaColeccion.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			JLabel titulo = new JLabel("~~~ Coleccion 🎴~~~",SwingConstants.CENTER); 
			JPanel botonera = new JPanel();
			
			
			
			JPanel texto = new JPanel(); //para la impresion de las Carta
			texto.setLayout(new BoxLayout(texto,BoxLayout.Y_AXIS));
			
			ultimaCarta= 0;
			mostrarCartas(texto, ventana);
		
			
			JButton regresar = reiniciarColec(texto, ventana);
			JButton b1= ordenarRareza(texto,ventana);
			JButton b2= ordenarNombre(texto,ventana);
			JButton b3= ordenarPoder(texto,ventana);
			JButton avanzar = avanzarColec(texto, ventana);
			
			botonera.add(regresar);
			botonera.add(b1);
			botonera.add(b2);
			botonera.add(b3);
			botonera.add(avanzar);
			
			
			ventanaColeccion.add(titulo,BorderLayout.NORTH);
			ventanaColeccion.add(botonera, BorderLayout.SOUTH);
			ventanaColeccion.add(texto, BorderLayout.CENTER);
			
			ventanaColeccion.setVisible(true);
		});
		return b;
	}
	private JButton ordenarPoder(JPanel texto, JFrame ventana) {
		JButton b = new JButton("Ordenar por Poder");
		b.addActionListener(e->{
			sistema.odenarCartasPoder();
			inicioCartas(texto, ventana);
		});
		return b;
	}

	private JButton ordenarNombre(JPanel texto, JFrame ventana) {
		JButton b = new JButton("Ordenar por Nombre");
		b.addActionListener(e->{
			//hacer el ordenamiento
			inicioCartas(texto, ventana);
		});
		return b;
	}

	private JButton ordenarRareza(JPanel texto, JFrame ventana) {
		JButton b = new JButton("Ordenar por Rareza");
		b.addActionListener(e->{
			sistema.ordenarCartasRareza();
			inicioCartas(texto, ventana);
		});
		return b;
	}

	private JButton avanzarColec(JPanel texto, JFrame ventana) {
		JButton b = new JButton(">");
		b.addActionListener(e->{
			mostrarCartas(texto, ventana);
		});
		return b;
	}

	private JButton reiniciarColec(JPanel texto, JFrame ventana) {
		JButton b = new JButton("🏠");
		b.addActionListener(e->{
			inicioCartas(texto, ventana);
		});
		return b;
	}

	private void inicioCartas(JPanel texto, JFrame ventana) {
	texto.removeAll();
		ultimaCarta=0;
		
	
		for (int i =0;i<sistema.verCantCartas();i++) {
			
			
			JButton b = cartaSingular(i, ventana);
			b.setAlignmentX(Component.CENTER_ALIGNMENT);
			texto.add(b);
			if (i>ultimaCarta+20) {
				ultimaCarta=i;
				break;
			}
			
		}
		texto.revalidate();
		texto.repaint();
	}

	private void mostrarCartas(JPanel texto, JFrame ventana) {
		texto.removeAll();
		
		
	
		for (int i =ultimaCarta;i<sistema.verCantCartas();i++) {
			
			
			JButton b = cartaSingular(i, ventana);
			b.setAlignmentX(Component.CENTER_ALIGNMENT);
			texto.add(b);
			if (i>ultimaCarta+20) {
				ultimaCarta=i;
				break;
			}
			
		}
		texto.revalidate();
		texto.repaint();
	}

	private JButton cartaSingular(int i, JFrame ventana) {
		JButton b = new JButton(sistema.verNombreCarta(i));
		b.addActionListener(e->{
			JDialog ventanaDialog = new JDialog(ventana, sistema.verNombreCarta(i));
			ventanaDialog.setSize(700,400);
			
			ventanaDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			ventanaDialog.setLocationRelativeTo(null); 

			
			JPanel datos = new JPanel();
			datos.setLayout(new BoxLayout(datos,BoxLayout.Y_AXIS));
			datos=cargarDatos(datos,i);
			ventanaDialog.add(datos,BorderLayout.EAST);
			
			
			ventanaDialog.setVisible(true);
		});
		return b;
	}


	private JPanel cargarDatos(JPanel datos, int i) {
		String[] stringDatos = sistema.verCarta(i).split(";");

		for (int j=0; j<stringDatos.length;j++) {
			
			JLabel texto = new JLabel(stringDatos[j]+"      ");
			JLabel espacio = new JLabel(" ");
			
			
			datos.add(texto);
			datos.add(espacio);
		}
		return datos;
	}

	private JButton botonAdmin(JFrame ventana) {

		JButton b = new JButton("Administrar");
		b.addActionListener(e->{
			JDialog ventanaAdmin = new JDialog(ventana,"Administrar");
			ventanaAdmin.setSize(500,700);
			ventanaAdmin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			
			JPanel botonera = new JPanel();
			
			JButton b1= agregarCarta(ventana);
			JButton b2= eliminarCarta();
			JButton b3= modificarCarta();
			botonera.add(b1);
			botonera.add(b2);
			botonera.add(b3);
			
			ventanaAdmin.add(botonera,BorderLayout.SOUTH);
			ventanaAdmin.setVisible(true);
			
		});
		
		return b;
	}
	private JButton modificarCarta() {
		JButton b = new JButton("Modificar Carta");
		b.addActionListener(e->{
			
		
		});
		
		return b;
	}

	private JButton eliminarCarta() {
		JButton b = new JButton("Eliminar Carta");
		b.addActionListener(e->{

			
		});
		
		return b;
	}

	private JButton agregarCarta(JFrame ventana) {
		JButton b = new JButton("Agregar Carta");
		b.addActionListener(e->{
			JDialog ventanaDialog = new JDialog(ventana, "Agregar Carta");
			ventanaDialog.setSize(200,300);
			
			JLabel titulo = new JLabel("Agregar de cartas",SwingConstants.CENTER); //para que este constantemente en el centro
			
			ventanaDialog.add(titulo,BorderLayout.NORTH);
			
			ventanaDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			ventanaDialog.setLocationRelativeTo(null); //para que salga en el centro

			ventanaDialog.setVisible(true);
			

			
		});
		
		return b;
	}
}
