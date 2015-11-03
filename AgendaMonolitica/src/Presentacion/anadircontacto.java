package Presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dominio.GestorContacto;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings({ "serial", "unused" })
public class anadircontacto extends JFrame {

	private JPanel contentPane;
	private JLabel lblnombre;
	private JLabel lbltelefono;
	private JTextField txtnombre;
	private JTextField txttelefono;
	private JButton btnAnadir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					anadircontacto frame = new anadircontacto();
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
	public anadircontacto() {
		setName("frmadd");
		setIconImage(Toolkit.getDefaultToolkit().getImage(anadircontacto.class.getResource("/Presentacion/images.png")));
		setTitle("añadir contacto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 242, 158);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 80, 0};
		gbl_contentPane.rowHeights = new int[]{14, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		{
			lblnombre = new JLabel("Nombre:");
			GridBagConstraints gbc_lblnombre = new GridBagConstraints();
			gbc_lblnombre.insets = new Insets(0, 0, 5, 5);
			gbc_lblnombre.gridx = 0;
			gbc_lblnombre.gridy = 1;
			contentPane.add(lblnombre, gbc_lblnombre);
		}
		{
			txtnombre = new JTextField();
			txtnombre.addFocusListener(new TxtnombreFocusListener());
			txtnombre.addKeyListener(new TxtnombreKeyListener());
			GridBagConstraints gbc_txtnombre = new GridBagConstraints();
			gbc_txtnombre.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtnombre.gridwidth = 2;
			gbc_txtnombre.insets = new Insets(0, 0, 5, 0);
			gbc_txtnombre.gridx = 2;
			gbc_txtnombre.gridy = 1;
			contentPane.add(txtnombre, gbc_txtnombre);
			txtnombre.setColumns(10);
		}
		{
			lbltelefono = new JLabel("Telefono:");
			GridBagConstraints gbc_lbltelefono = new GridBagConstraints();
			gbc_lbltelefono.insets = new Insets(0, 0, 5, 5);
			gbc_lbltelefono.gridx = 0;
			gbc_lbltelefono.gridy = 2;
			contentPane.add(lbltelefono, gbc_lbltelefono);
		}
		{
			txttelefono = new JTextField();
			txttelefono.addFocusListener(new TxttelefonoFocusListener());
			txttelefono.addKeyListener(new TxttelefonoKeyListener());
			GridBagConstraints gbc_txttelefono = new GridBagConstraints();
			gbc_txttelefono.insets = new Insets(0, 0, 5, 0);
			gbc_txttelefono.fill = GridBagConstraints.HORIZONTAL;
			gbc_txttelefono.gridwidth = 2;
			gbc_txttelefono.gridx = 2;
			gbc_txttelefono.gridy = 2;
			contentPane.add(txttelefono, gbc_txttelefono);
			txttelefono.setColumns(10);
		}
		{
			btnAnadir = new JButton("añadir");
			btnAnadir.addActionListener(new BtnAnadirActionListener());
			GridBagConstraints gbc_btnAnadir = new GridBagConstraints();
			gbc_btnAnadir.anchor = GridBagConstraints.EAST;
			gbc_btnAnadir.gridx = 3;
			gbc_btnAnadir.gridy = 3;
			contentPane.add(btnAnadir, gbc_btnAnadir);
		}
	}

	
	private class TxtnombreKeyListener extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent e) {
			char c= e.getKeyChar();
			if((c<'a' || c>'z') && (c<'A' || c>'Z')) e.consume();
		}
	}
	private class TxttelefonoKeyListener extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent e) {
			char c= e.getKeyChar();
			if(c<'0' || c>'9') e.consume();
		}
	}
	private class TxtnombreFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent e) {
			txtnombre.setBackground(new Color(250,250,210));
		}
		
		@Override
		public void focusLost(FocusEvent e) {
			txtnombre.setBackground(new Color(250,250,250));
		}
	}
	private class TxttelefonoFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent e) {
			txttelefono.setBackground(new Color(250,250,210));
		}
		@Override
		public void focusLost(FocusEvent e) {
			txttelefono.setBackground(new Color(250,250,250));
		}
	}
	private class BtnAnadirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			GestorContacto gc= new GestorContacto();
				try {
					gc.add(txtnombre.getText(), txttelefono.getText());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			mascara window = new mascara();
			window.frmAgendaMonolitica.setVisible(true);
		}
	}
}
