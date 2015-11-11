package Presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.TitledBorder;

import Dominio.Gestores.GestorContacto;
import Dominio.POJO.Contacto;
import Dominio.Gestores.GestorAgente;

import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.MaskFormatter;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;

@SuppressWarnings("unused")
public class mascara {

	JFrame frmAgendaMonolitica;
	private JPanel pnlPrincipal;
	private JScrollPane spContactos;
	@SuppressWarnings("rawtypes")
	private JList listContactos;
	private JPanel pnlDatos;
	private JLabel lblNombre;
	private JLabel lblTelefono;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	private JButton btnAnadir;
	private JButton btnModificar;
	private JButton btnBorrar;
	private JButton btnBuscar;
	private JTextField txtBuscar;
	
	private GestorAgente gestorAgente=new GestorAgente();
	private GestorContacto gestorContacto=new GestorContacto();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mascara window = new mascara();
					window.frmAgendaMonolitica.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mascara() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frmAgendaMonolitica = new JFrame();
		
		frmAgendaMonolitica.addWindowListener(new FrmAgendaMonoliticaWindowListener());
		frmAgendaMonolitica.setResizable(false);
		frmAgendaMonolitica.setTitle("Agenda Monolitica");
		frmAgendaMonolitica.setIconImage(Toolkit.getDefaultToolkit().getImage(mascara.class.getResource("/Presentacion/agenda.png")));
		frmAgendaMonolitica.setBounds(100, 100, 409, 304);
		frmAgendaMonolitica.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		{
			pnlPrincipal = new JPanel();
			frmAgendaMonolitica.getContentPane().add(pnlPrincipal, BorderLayout.CENTER);
			GridBagLayout gbl_pnlPrincipal = new GridBagLayout();
			gbl_pnlPrincipal.columnWidths = new int[]{160, 63, 72, 0, 0};
			gbl_pnlPrincipal.rowHeights = new int[]{0, 0, 0, 120, 46, 0, 0, 0, 0};
			gbl_pnlPrincipal.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_pnlPrincipal.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			pnlPrincipal.setLayout(gbl_pnlPrincipal);
			{
				spContactos = new JScrollPane();
				spContactos.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				spContactos.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
				spContactos.setBorder(new TitledBorder(null, "Contactos", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
				GridBagConstraints gbc_spContactos = new GridBagConstraints();
				gbc_spContactos.gridheight = 4;
				gbc_spContactos.insets = new Insets(0, 0, 5, 5);
				gbc_spContactos.fill = GridBagConstraints.BOTH;
				gbc_spContactos.gridx = 0;
				gbc_spContactos.gridy = 0;
				pnlPrincipal.add(spContactos, gbc_spContactos);
				{
					listContactos = new JList();
					listContactos.addListSelectionListener(new ListContactosListSelectionListener());
					listContactos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					listContactos.setLayoutOrientation(JList.HORIZONTAL_WRAP);
					spContactos.setViewportView(listContactos);
				}
			}
			{
				txtBuscar = new JFormattedTextField();
				txtBuscar.addFocusListener(new TxtBuscarFocusListener());
				GridBagConstraints gbc_txtBuscar = new GridBagConstraints();
				gbc_txtBuscar.anchor = GridBagConstraints.SOUTH;
				gbc_txtBuscar.gridwidth = 2;
				gbc_txtBuscar.insets = new Insets(0, 0, 5, 5);
				gbc_txtBuscar.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtBuscar.gridx = 1;
				gbc_txtBuscar.gridy = 2;
				pnlPrincipal.add(txtBuscar, gbc_txtBuscar);
				txtBuscar.setColumns(10);
			}
			{
				comboBox = new JComboBox();
				comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nombre", "Telefono"}));
				GridBagConstraints gbc_comboBox = new GridBagConstraints();
				gbc_comboBox.gridwidth = 2;
				gbc_comboBox.anchor = GridBagConstraints.NORTH;
				gbc_comboBox.insets = new Insets(0, 0, 5, 5);
				gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboBox.gridx = 1;
				gbc_comboBox.gridy = 3;
				pnlPrincipal.add(comboBox, gbc_comboBox);
			}
			{
				btnBuscar = new JButton("Buscar");
				btnBuscar.addActionListener(new BtnBuscarActionListener());
				GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
				gbc_btnBuscar.anchor = GridBagConstraints.NORTH;
				gbc_btnBuscar.insets = new Insets(0, 0, 5, 0);
				gbc_btnBuscar.gridx = 3;
				gbc_btnBuscar.gridy = 3;
				pnlPrincipal.add(btnBuscar, gbc_btnBuscar);
			}
			{
				pnlDatos = new JPanel();
				pnlDatos.setBorder(new TitledBorder(null, "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
				pnlDatos.setLayout(null);
				GridBagConstraints gbc_pnlDatos = new GridBagConstraints();
				gbc_pnlDatos.gridheight = 4;
				gbc_pnlDatos.insets = new Insets(0, 0, 0, 5);
				gbc_pnlDatos.fill = GridBagConstraints.BOTH;
				gbc_pnlDatos.gridx = 0;
				gbc_pnlDatos.gridy = 4;
				pnlPrincipal.add(pnlDatos, gbc_pnlDatos);
				{
					lblNombre = new JLabel("");
					lblNombre = new JLabel("Nombre:");
					lblNombre.setBounds(10, 21, 135, 14);
					pnlDatos.add(lblNombre);
				}
				{
					lblTelefono = new JLabel("");
					lblTelefono = new JLabel("Teléfono:");
					lblTelefono.setBounds(10, 45, 135, 14);
					pnlDatos.add(lblTelefono);
				}
			}
			{
				btnAnadir = new JButton("Añadir");
				btnAnadir.addActionListener(new BtnAnadirActionListener());
				GridBagConstraints gbc_btnAnadir = new GridBagConstraints();
				gbc_btnAnadir.anchor = GridBagConstraints.EAST;
				gbc_btnAnadir.insets = new Insets(0, 0, 5, 5);
				gbc_btnAnadir.gridx = 1;
				gbc_btnAnadir.gridy = 4;
				pnlPrincipal.add(btnAnadir, gbc_btnAnadir);
			}
			{
				btnModificar = new JButton("Modificar");
				btnModificar.addActionListener(new BtnModificarActionListener());
				GridBagConstraints gbc_btnModificar = new GridBagConstraints();
				gbc_btnModificar.insets = new Insets(0, 0, 5, 5);
				gbc_btnModificar.gridx = 2;
				gbc_btnModificar.gridy = 4;
				pnlPrincipal.add(btnModificar, gbc_btnModificar);
			}
			{
				btnBorrar = new JButton("Borrar");
				btnBorrar.addActionListener(new BtnBorrarActionListener());
				GridBagConstraints gbc_btnBorrar = new GridBagConstraints();
				gbc_btnBorrar.insets = new Insets(0, 0, 5, 0);
				gbc_btnBorrar.gridx = 3;
				gbc_btnBorrar.gridy = 4;
				pnlPrincipal.add(btnBorrar, gbc_btnBorrar);
			}
			
			try {
				gestorAgente.connect();
			} catch (ClassNotFoundException e) {
				JOptionPane.showMessageDialog(frmAgendaMonolitica,"Error al cargar el driver de la base de datos...\nEl programa se cerrarÃ¡","Error",JOptionPane.WARNING_MESSAGE);
				cerrar();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(frmAgendaMonolitica,"Error al cargar la base da datos...\nEl programa se cerrarÃ¡","Error",JOptionPane.WARNING_MESSAGE);
				cerrar();
			}
			cargarDatos();
		}
		
	}
	@SuppressWarnings("unchecked")
	public void cargarDatos(){
		try {
			listContactos.setListData(gestorContacto.cargarDatos());
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frmAgendaMonolitica,"Error al cargar la lista de contactos...\nEl programa se cerrarÃ¡","Error",JOptionPane.WARNING_MESSAGE);
			cerrar();
		}
	}
	private void cerrar(){
		frmAgendaMonolitica.setVisible(false);
		frmAgendaMonolitica.dispose();
		System.exit(-1);
	}
	private class FrmAgendaMonoliticaWindowListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
				gestorAgente.disconect();
		}
	}
	private class TxtBuscarFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent arg0) {
			txtBuscar.setBackground(new Color(250,250,210));
		}
		@Override
		public void focusLost(FocusEvent e) {
			txtBuscar.setBackground(new Color(250,250,250));
		}
	}
	
	private class BtnAnadirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			//Se crea una instancia de la segunda ventana (JFrame)
			anadircontacto otraVentana = new anadircontacto();
			//se hace visible
			otraVentana.setVisible(true);
			cargarDatos();
			
		}
	}
	private class ListContactosListSelectionListener implements ListSelectionListener {
		@SuppressWarnings("rawtypes")
		public void valueChanged(ListSelectionEvent arg0) {
			Contacto c;
			int index=listContactos.getSelectedIndex();
			ListModel model = listContactos.getModel();
			if (index!=-1){
				c=(Contacto) model.getElementAt(index);
				lblNombre.setText("Nombre: "+c.getNombre());
				lblTelefono.setText("Teléfono: "+c.getTelefono());
			}
			
		}
	}	
	
	private class BtnBuscarActionListener implements ActionListener {
		@SuppressWarnings("unchecked")
		public void actionPerformed(ActionEvent arg0) {
			try{
				if(comboBox.getSelectedIndex()==0){
					listContactos.setListData(gestorContacto.buscarContactoNombre(txtBuscar.getText()));
				}
				else{
					listContactos.setListData(gestorContacto.buscarContactoTelefono(txtBuscar.getText()));
				}
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			lblNombre.setText(null);
			lblTelefono.setText(null);
		}
	}
	
	private class BtnBorrarActionListener implements ActionListener {
		@SuppressWarnings("rawtypes")
		public void actionPerformed(ActionEvent arg0) {
			Contacto c;
			int index=listContactos.getSelectedIndex();
			ListModel model = listContactos.getModel();
			if (index!=-1){
				c=(Contacto) model.getElementAt(index);
				try {
					gestorContacto.borrar(c.getTelefono());
					cargarDatos();
					listContactos.clearSelection();
					lblNombre.setText(null);
					lblTelefono.setText(null);
					lblNombre.setText("Nombre:");
					lblTelefono.setText("Teléfono:");
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(frmAgendaMonolitica,"Error al eliminar de la base de datoss...","Error",JOptionPane.WARNING_MESSAGE);
				}
			}
		}
	}

	private class BtnModificarActionListener implements ActionListener {
		@SuppressWarnings("rawtypes")
		public void actionPerformed(ActionEvent e) {
			
			Contacto c;
			int index=listContactos.getSelectedIndex();
			ListModel model = listContactos.getModel();
			if (index!=-1){
				c=(Contacto) model.getElementAt(index);
				Modify modificar = new Modify(c);
				modificar.setVisible(true);
				cargarDatos();
				listContactos.clearSelection();
				lblNombre.setText(null);
				lblTelefono.setText(null);
			}
			
		}
	}

}