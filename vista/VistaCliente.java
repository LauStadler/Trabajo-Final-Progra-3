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

public class VistaCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField cantPasajeros;

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

	/**
	 * Create the frame.
	 */
	public VistaCliente() {
		setTitle("Solicitar Viaje");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelGeneral = new JPanel();
		contentPane.add(panelGeneral, BorderLayout.CENTER);
		panelGeneral.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelCreaViaje = new JPanel();
		panelGeneral.add(panelCreaViaje);
		panelCreaViaje.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panelCreaViaje.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel IngresarCantidad = new JLabel("Ingrese cantidad de pasajeros: ");
		panel.add(IngresarCantidad);
		
		cantPasajeros = new JTextField();
		panel.add(cantPasajeros);
		cantPasajeros.setColumns(10);
		
		JButton BotonAceptar = new JButton("Aceptar");
		panel.add(BotonAceptar);
		
		JPanel panelZonas = new JPanel();
		panelCreaViaje.add(panelZonas);
		
		JLabel LabelZona = new JLabel("Elija la Zona");
		LabelZona.setBackground(new Color(240, 240, 240));
		panelZonas.add(LabelZona);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Zona Peligrosa", "Zona Calle de Tierra ", "Zona Estandar"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panelZonas.add(list);
		
		JPanel panelMascota = new JPanel();
		panelCreaViaje.add(panelMascota);
		panelMascota.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panelMascota.add(panel_3);
		
		JPanel panel_2 = new JPanel();
		panelMascota.add(panel_2);
		
		JPanel panelBaul = new JPanel();
		panelCreaViaje.add(panelBaul);
		
		JPanel panelDistancia = new JPanel();
		panelCreaViaje.add(panelDistancia);
		
		JPanel panelEstadoDelViaje = new JPanel();
		panelGeneral.add(panelEstadoDelViaje);
		panelEstadoDelViaje.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panelEstadoDelViaje.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("Estado del Viaje");
		panel_1.add(lblNewLabel_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panelEstadoDelViaje.add(scrollPane_1);
	}

	public JPanel getContentPane() {
		return this.contentPane;
	}

	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

	public JTextField getCantPasajeros() {
		return this.cantPasajeros;
	}

	public void setCantPasajeros(JTextField cantPasajeros) {
		this.cantPasajeros = cantPasajeros;
	}

	public void setControlador(Controlador c){
	
	}

}
