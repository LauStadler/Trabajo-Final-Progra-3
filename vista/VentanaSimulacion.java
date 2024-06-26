package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class VentanaSimulacion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea areaGeneral = new JTextArea();
	private JTextArea areaCliente = new JTextArea();
	private JTextArea areaChofer = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaSimulacion frame = new VentanaSimulacion();
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
	public VentanaSimulacion() {
		setTitle("Ventana Simulacion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelCentral = new JPanel();
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panelGeneral = new JPanel();
		panelCentral.add(panelGeneral);
		panelGeneral.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane(areaGeneral);
		panelGeneral.add(scrollPane);
		
		JPanel panelChofer = new JPanel();
		panelCentral.add(panelChofer);
		panelChofer.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane(areaChofer);
		panelChofer.add(scrollPane_1);
		
		JPanel panelCliente = new JPanel();
		panelCentral.add(panelCliente);
		panelCliente.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane_2 = new JScrollPane(areaCliente);
		panelCliente.add(scrollPane_2);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel subPanelTextoGral = new JPanel();
		panel.add(subPanelTextoGral);
		
		JLabel LabelGeneral = new JLabel("General");
		subPanelTextoGral.add(LabelGeneral);
		
		JPanel subPanelTextoCliente = new JPanel();
		panel.add(subPanelTextoCliente);
		
		JLabel LabelCliente = new JLabel("Chofer");
		subPanelTextoCliente.add(LabelCliente);
		
		JPanel subPanelTextoChofer = new JPanel();
		panel.add(subPanelTextoChofer);
		
		JLabel LabelChofer = new JLabel("Cliente");
		subPanelTextoChofer.add(LabelChofer);
	}

	public void appendTextGeneral(String arg)
    {
	    this.areaGeneral.append(arg+"\n");
    }

	public void appendTextCliente(String arg)
    {
	    this.areaCliente.append(arg+"\n");
    }

	public void appendTextChofer(String arg)
    {
	    this.areaChofer.append(arg+"\n");
    }
	
	public void finalizar() {

		this.setVisible(false);
	}
}
