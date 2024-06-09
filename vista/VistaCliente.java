package vista; 

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.JTextArea;
import java.awt.Color;

import controlador.Controlador;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;

public class VistaCliente extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel panelGeneral;
	private JPanel panelCreaPedido;
	private JPanel panelEstadoPedido;
	private JPanel panelCantPasajeros;
	private JPanel panelZona;
	private JPanel panelMascotas;
	private JPanel panelBaul;
	private JPanel panelDistancia;
	private JLabel CantidadPasajeros;
	private JTextField CantPasajeros;
	private JComboBox comboBox;
	private JLabel ingresaZona;
	private JPanel panelEtiqueta;
	private JPanel panelOpciones;
	private JRadioButton RadioBotonNo;
	private JRadioButton RadioBotonSi;
	private JPanel panelEtiquetaBaul;
	private JPanel panelOpcionesBaul;
	private JLabel labelDistancia;
	private JLabel LabelBaul;
	private JRadioButton radioBotonSi;
	private JRadioButton radioBotonNo;
	private JLabel LabelMascota;
	private JTextField ingresaDistancia;
	private JButton botonAceptar;
	private JScrollPane scrollPaneEstadoViaje;
	private JPanel panelEstado;
	private JPanel panelPago;
	private JLabel labelEstado;
	private JButton botonPagar;
	private JTextArea logviaje;
	
	public VistaCliente() {
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		this.panelGeneral = new JPanel();
		getContentPane().add(this.panelGeneral);
		this.panelGeneral.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.panelCreaPedido = new JPanel();
		this.panelGeneral.add(this.panelCreaPedido);
		this.panelCreaPedido.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.panelCantPasajeros = new JPanel();
		this.panelCreaPedido.add(this.panelCantPasajeros);
		
		this.CantidadPasajeros = new JLabel("Ingrese la cantidad de pasajeros");
		this.panelCantPasajeros.add(this.CantidadPasajeros);
		
		this.CantPasajeros = new JTextField();
		this.panelCantPasajeros.add(this.CantPasajeros);
		this.CantPasajeros.setColumns(10);
		
		this.panelZona = new JPanel();
		this.panelCreaPedido.add(this.panelZona);
		
		this.ingresaZona = new JLabel("Ingrese la Zona");
		this.panelZona.add(this.ingresaZona);
		
		this.comboBox = new JComboBox();
		this.comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Zona Peligrosa", "Zona Estandar ", "Zona Calle de  Tierra"}));
		this.panelZona.add(this.comboBox);
		
		this.panelMascotas = new JPanel();
		this.panelCreaPedido.add(this.panelMascotas);
		this.panelMascotas.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.panelEtiqueta = new JPanel();
		this.panelMascotas.add(this.panelEtiqueta);
		this.panelEtiqueta.setLayout(new BorderLayout(0, 0));
		
		this.LabelMascota = new JLabel("Lleva Mascota?");
		this.panelEtiqueta.add(this.LabelMascota, BorderLayout.CENTER);
		
		this.panelOpciones = new JPanel();
		this.panelMascotas.add(this.panelOpciones);
		this.panelOpciones.setLayout(new GridLayout(1, 0, 0, 0));
		
		this.RadioBotonSi = new JRadioButton("si");
		this.panelOpciones.add(this.RadioBotonSi);
		
		this.RadioBotonNo = new JRadioButton("no");
		this.panelOpciones.add(this.RadioBotonNo);
		
		this.panelBaul = new JPanel();
		this.panelCreaPedido.add(this.panelBaul);
		this.panelBaul.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.panelEtiquetaBaul = new JPanel();
		this.panelBaul.add(this.panelEtiquetaBaul);
		this.panelEtiquetaBaul.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.LabelBaul = new JLabel("Con Baul");
		this.panelEtiquetaBaul.add(this.LabelBaul);
		
		this.panelOpcionesBaul = new JPanel();
		this.panelBaul.add(this.panelOpcionesBaul);
		this.panelOpcionesBaul.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.radioBotonSi = new JRadioButton("si");
		this.panelOpcionesBaul.add(this.radioBotonSi);
		
		this.radioBotonNo = new JRadioButton("no");
		this.panelOpcionesBaul.add(this.radioBotonNo);
		
		this.panelDistancia = new JPanel();
		this.panelCreaPedido.add(this.panelDistancia);
		
		this.labelDistancia = new JLabel("Ingrese la distancia");
		this.panelDistancia.add(this.labelDistancia);
		
		this.ingresaDistancia = new JTextField();
		this.panelDistancia.add(this.ingresaDistancia);
		this.ingresaDistancia.setColumns(10);
		
		this.botonAceptar = new JButton("Aceptar");
		this.botonAceptar.setActionCommand("Aceptar");
		this.panelDistancia.add(this.botonAceptar);
		
		this.panelEstadoPedido = new JPanel();
		this.panelGeneral.add(this.panelEstadoPedido);
		this.panelEstadoPedido.setLayout(new BorderLayout(0, 0));
		
		this.panelPago = new JPanel();
		this.panelEstadoPedido.add(this.panelPago, BorderLayout.SOUTH);
		
		this.botonPagar = new JButton("Pagar");
		this.panelPago.add(this.botonPagar);
		this.botonPagar.setEnabled(false);
		
		this.scrollPaneEstadoViaje = new JScrollPane();
		this.panelEstadoPedido.add(this.scrollPaneEstadoViaje, BorderLayout.CENTER);
		
		this.logviaje = new JTextArea();
		this.scrollPaneEstadoViaje.setViewportView(this.logviaje);
		
		this.panelEstado = new JPanel();
		this.panelEstadoPedido.add(this.panelEstado, BorderLayout.NORTH);
		
		this.labelEstado = new JLabel("Estado de su viaje");
		this.panelEstado.add(this.labelEstado);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaCliente frame = new VistaCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Integer getCantPasajeros() {
		String value = CantPasajeros.getText();
		return Integer.parseInt(value);
	}

	public double getIngresaDistancia() {
		String value = CantPasajeros.getText();
		return Double.parseDouble(value);
	}

	public boolean isBaul() {
		if (this.radioBotonSi.isSelected())
			return true;
		else
			return false;
				
	}
	
	public boolean isMascota() {
		if (this.RadioBotonSi.isSelected())
			return true;
		else
			return false;
				
	}
	
	public void setActionListener(Controlador c) {
		
		this.botonAceptar.addActionListener(c);
		this.botonPagar.addActionListener(c);
	}
	
	public void appendText(String arg)
    {
	    this.logviaje.append(arg+"\n");
    }

	public void habilitaPago() {
		this.botonPagar.setEnabled(true);
		
	}
	
}
