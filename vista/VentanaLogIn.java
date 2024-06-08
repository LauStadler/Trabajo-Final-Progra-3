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
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.SpringLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import controlador.ControladorLogIn;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VentanaLogIn extends JFrame{

	private ControladorLogIn controlador;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblIniciarSesion;
	private JPanel panel_5;
	private JPanel panel_3;
	private JLabel lblUser;
	private JTextField textField_User;
	private JPanel panel_4;
	private JLabel lblContrasena;
	private JPasswordField passwordField_Contrasena;
	private JPanel panel_6;
	private JButton btnIniciarSesion;
	private JPanel panel_2;
	private JLabel lblRegistrarse;
	private JPanel panel_7;
	private JPanel panel_8;
	private JLabel lblNuevoUser;
	private JTextField textField_NuevoUser;
	private JPanel panel_9;
	private JLabel lblNuevaContrasena;
	private JPasswordField passwordField_NuevaContrasena;
	private JPanel panel_10;
	private JButton btnRegistrarse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogIn frame = new VentanaLogIn();
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
	public VentanaLogIn() {
		setTitle("Ventana Simulacion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		this.contentPane.setBackground(new Color(255, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		this.panel = new JPanel();
		this.panel.setBackground(new Color(128, 255, 255));
		this.contentPane.add(this.panel, BorderLayout.CENTER);
		this.panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.panel_1 = new JPanel();
		this.panel.add(this.panel_1);
		this.panel_1.setLayout(new GridLayout(3, 2, 0, 0));
		
		this.lblIniciarSesion = new JLabel("Iniciar Sesion");
		this.lblIniciarSesion.setHorizontalAlignment(SwingConstants.CENTER);
		this.panel_1.add(this.lblIniciarSesion);
		
		this.panel_5 = new JPanel();
		this.panel_1.add(this.panel_5);
		this.panel_5.setLayout(new GridLayout(2, 1, 0, 0));
		
		this.panel_3 = new JPanel();
		this.panel_5.add(this.panel_3);
		
		this.lblUser = new JLabel("User");
		this.panel_3.add(this.lblUser);
		
		this.textField_User = new JTextField();
		this.textField_User.setColumns(10);
		this.panel_3.add(this.textField_User);
		
		this.panel_4 = new JPanel();
		this.panel_5.add(this.panel_4);
		
		this.lblContrasena = new JLabel("Contrasena");
		this.panel_4.add(this.lblContrasena);
		
		this.passwordField_Contrasena = new JPasswordField();
		this.passwordField_Contrasena.setColumns(10);
		this.panel_4.add(this.passwordField_Contrasena);
		
		this.panel_6 = new JPanel();
		this.panel_1.add(this.panel_6);
		
		this.btnIniciarSesion = new JButton("Iniciar Sesion");
		//this.btnIniciarSesion.addActionListener(controlador);    		         (esta la saque del video de guille)
		this.btnIniciarSesion.setActionCommand("Iniciar Sesion");//(esta la saque de las filminas)  	   NOSE CUAL DE ESTAS DOS ES LA CORRECTA
		this.panel_6.add(this.btnIniciarSesion);
		
		this.panel_2 = new JPanel();
		this.panel.add(this.panel_2);
		this.panel_2.setLayout(new GridLayout(3, 2, 0, 0));
		
		this.lblRegistrarse = new JLabel("Registrarse");
		this.lblRegistrarse.setHorizontalAlignment(SwingConstants.CENTER);
		this.panel_2.add(this.lblRegistrarse);
		
		this.panel_7 = new JPanel();
		this.panel_2.add(this.panel_7);
		this.panel_7.setLayout(new GridLayout(2, 1, 0, 0));
		
		this.panel_8 = new JPanel();
		this.panel_7.add(this.panel_8);
		
		this.lblNuevoUser = new JLabel("Nuevo User");
		this.panel_8.add(this.lblNuevoUser);
		
		this.textField_NuevoUser = new JTextField();
		this.textField_NuevoUser.setColumns(10);
		this.panel_8.add(this.textField_NuevoUser);
		
		this.panel_9 = new JPanel();
		this.panel_7.add(this.panel_9);
		
		this.lblNuevaContrasena = new JLabel("Nueva Contrasena");
		this.panel_9.add(this.lblNuevaContrasena);
		
		this.passwordField_NuevaContrasena = new JPasswordField();
		this.passwordField_NuevaContrasena.setColumns(10);
		this.panel_9.add(this.passwordField_NuevaContrasena);
		
		this.panel_10 = new JPanel();
		this.panel_2.add(this.panel_10);
		
		this.btnRegistrarse = new JButton("Registrarse");
		//this.btnRegistrarse.addActionListener(controlador);                (esta la saque del video de guille)
		this.btnRegistrarse.setActionCommand("Registrarse");// (esta la saque de las filminas)  		NOSE CUAL DE ESTAS DOS ES LA CORRECTA
		this.panel_10.add(this.btnRegistrarse);
		
	}

}
