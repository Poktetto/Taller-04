package GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.SwingConstants;

import Logica.Sistema;
import Logica.SistemaImplementado;

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
			sistema.ordenarCartasNombre();
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

			ImageIcon imagen = new ImageIcon(sistema.verImagen(i));
			JLabel imagenE = new JLabel(imagen); 
			JPanel datos = new JPanel();
			
			datos.setLayout(new BoxLayout(datos,BoxLayout.Y_AXIS));
			datos=cargarDatos(datos,i);
			ventanaDialog.add(imagenE,BorderLayout.CENTER);
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
			ventanaAdmin.setSize(300,200);
			ventanaAdmin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			
			JPanel botonera = new JPanel();
			
			JButton b1= agregarCarta(ventana);
			JButton b2= eliminarCarta(ventana);
			JButton b3= modificarCarta(ventana);
			botonera.add(b1);
			botonera.add(b2);
			botonera.add(b3);
		
			
			ventanaAdmin.add(botonera,BorderLayout.CENTER);
			ventanaAdmin.setVisible(true);
			
		});
		
		return b;
	}
	private JButton modificarCarta(JFrame ventana) {
		JButton b = new JButton("Modificar Carta");
		b.addActionListener(e->{
			JDialog ventanaDialog = new JDialog(ventana, "Eliminar Carta");
			ventanaDialog.setSize(200,300);
			
			JLabel titulo = new JLabel("Elija su carta a eliminar ",SwingConstants.CENTER); //para que este constantemente en el centro
			
			JPanel botonera = new JPanel();
			botonera.setLayout(new BoxLayout(botonera,BoxLayout.X_AXIS));
			
			ventanaDialog.add(titulo,BorderLayout.NORTH);
			JPanel texto = new JPanel(); //para la impresion de las Carta
			texto.setLayout(new BoxLayout(texto,BoxLayout.Y_AXIS));
			
			ultimaCarta=0;
			
		
			cargarModificarCarta(ventana, texto);
			
			//carga la ventana con los pokemones 
			JButton inicio = inicioModificarCarta(texto, ventana);
			JButton avanzar = avanzarModificarCarta(texto,ventana);
			botonera.add(inicio);
			botonera.add(avanzar);
			ventanaDialog.add(botonera,BorderLayout.SOUTH);
			ventanaDialog.add(texto,BorderLayout.CENTER);
			ventanaDialog.setVisible(true);
		
			
			
			
			
			
			
			
			
			
			
		});
		
		return b;
	}

	private JButton avanzarModificarCarta(JPanel texto, JFrame ventana) {
		JButton b = new JButton(">");
		b.addActionListener(e->{
			anvanzarPagModificarCarta(ventana, texto);
		});
		return b;
	}

	private void anvanzarPagModificarCarta(JFrame ventana, JPanel texto) {
		texto.removeAll();
		
		for (int i =ultimaCarta;i<sistema.verCantCartas();i++) {
			
			JButton b = cartaABorrar(i, ventana);
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

	private JButton cartaAModificar(int i, JFrame ventana) {
		JButton b = new JButton(sistema.verNombreCarta(i));
		b.addActionListener(e->{
			sistema.modificarCarta();
		});
		return b;
	}

	private JButton inicioModificarCarta(JPanel texto, JFrame ventana) {
		JButton b = new JButton("🏠");
		b.addActionListener(e->{
			cargarModificarCarta(ventana, texto);
		});
		return b;
	}

	private void cargarModificarCarta(JFrame ventana, JPanel texto) {
		texto.removeAll();
		ultimaCarta=0;
		
	
		for (int i =0;i<sistema.verCantCartas();i++) {
			
			
			JButton b = cartaABorrar(i, ventana);
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

	private JButton eliminarCarta(JFrame ventana) {
		JButton b = new JButton("Eliminar Carta");
		b.addActionListener(e->{
			JDialog ventanaDialog = new JDialog(ventana, "Eliminar Carta");
			ventanaDialog.setSize(200,300);
			
			JLabel titulo = new JLabel("Elija su carta a eliminar ",SwingConstants.CENTER); //para que este constantemente en el centro
			
			JPanel botonera = new JPanel();
			botonera.setLayout(new BoxLayout(botonera,BoxLayout.X_AXIS));
			
			ventanaDialog.add(titulo,BorderLayout.NORTH);
			JPanel texto = new JPanel(); //para la impresion de las Carta
			texto.setLayout(new BoxLayout(texto,BoxLayout.Y_AXIS));
			
			ultimaCarta=0;
			
		
			cargarEliminarCarta(ventana, texto);
			
			//carga la ventana con los pokemones 
			JButton inicio = inicioEliminarCarta(texto, ventana);
			JButton avanzar = avanzarEliminarCarta(texto,ventana);
			botonera.add(inicio);
			botonera.add(avanzar);
			ventanaDialog.add(botonera,BorderLayout.SOUTH);
			ventanaDialog.add(texto,BorderLayout.CENTER);
			ventanaDialog.setVisible(true);
			
		});
		
		return b;
	}

	private JButton avanzarEliminarCarta(JPanel texto, JFrame ventana) {
		JButton b = new JButton(">");
		b.addActionListener(e->{
			anvanzarPagEliminarCarta(ventana, texto);
		});
		return b;
	}
	
	private void anvanzarPagEliminarCarta(JFrame ventana, JPanel texto) {
		texto.removeAll();
	
		for (int i =ultimaCarta;i<sistema.verCantCartas();i++) {
			
			JButton b = cartaABorrar(i, ventana);
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
	private JButton inicioEliminarCarta(JPanel texto, JFrame ventana) {
		JButton b = new JButton("🏠");
		b.addActionListener(e->{
			cargarEliminarCarta(ventana, texto);
		});
		return b;
	}
	
	private void cargarEliminarCarta(JFrame ventana, JPanel texto) {
		texto.removeAll();
		ultimaCarta=0;
		
	
		for (int i =0;i<sistema.verCantCartas();i++) {
			
			
			JButton b = cartaABorrar(i, ventana);
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
	
	private JButton cartaABorrar(int i, JFrame ventana) {
		JButton b = new JButton(sistema.verNombreCarta(i));
		b.addActionListener(e->{
			sistema.eliminarCarta();
			
		});
		return b;
	}

	private JButton agregarCarta(JFrame ventana) {
		JButton b = new JButton("Agregar Carta");
		b.addActionListener(e->{
			JDialog ventanaDialog = new JDialog(ventana, "Agregar Carta");
			ventanaDialog.setSize(200,300);
			
			JLabel titulo = new JLabel("Elija su tipo de carta a agregar",SwingConstants.CENTER); //para que este constantemente en el centro
			
			ventanaDialog.add(titulo,BorderLayout.NORTH);
			
			JButton b1= new JButton("Pokemon");
			JButton b2= new JButton("Item");
			JButton b3= new JButton("Energy");
			JButton b4= new JButton("Supporter");
			
			JPanel botonera = new JPanel();
			botonera.add(b1);
			botonera.add(b2);
			botonera.add(b3);
			botonera.add(b4);
			
			ventanaDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			ventanaDialog.setLocationRelativeTo(null); //para que salga en el centro
			ventanaDialog.add(botonera,BorderLayout.CENTER);
			ventanaDialog.setVisible(true);
			

			
		});
		
		return b;
	}
}
