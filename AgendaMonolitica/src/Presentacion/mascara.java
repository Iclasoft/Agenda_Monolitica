package Presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JList;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;

public class mascara {

	private JFrame frmAgendaMonolitica;
	private JPanel pnlPrincipal;
	private JScrollPane spContactos;
	private JList listContactos;
	private JPanel pnlDatos;
	private JLabel lblNombre;
	private JLabel lblTelefono;
	private JComboBox comboBox;
	private JButton btnAnadir;
	private JButton btnModificar;
	private JButton btnBorrar;
	private JButton btnBuscar;
	private JTextField txtBuscar;

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
	private void initialize() {
		frmAgendaMonolitica = new JFrame();
		frmAgendaMonolitica.setResizable(false);
		frmAgendaMonolitica.setTitle("Agenda Monolítica");
		frmAgendaMonolitica.setIconImage(Toolkit.getDefaultToolkit().getImage(mascara.class.getResource("/presentacion/agenda.png")));
		frmAgendaMonolitica.setBounds(100, 100, 409, 304);
		frmAgendaMonolitica.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		{
			pnlPrincipal = new JPanel();
			frmAgendaMonolitica.getContentPane().add(pnlPrincipal, BorderLayout.CENTER);
			GridBagLayout gbl_pnlPrincipal = new GridBagLayout();
			gbl_pnlPrincipal.columnWidths = new int[]{160, 63, 72, 0, 0};
			gbl_pnlPrincipal.rowHeights = new int[]{0, 141, 0, 0, 0, 0};
			gbl_pnlPrincipal.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_pnlPrincipal.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
			pnlPrincipal.setLayout(gbl_pnlPrincipal);
			{
				spContactos = new JScrollPane();
				spContactos.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				spContactos.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
				spContactos.setBorder(new TitledBorder(null, "Contactos", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
				GridBagConstraints gbc_spContactos = new GridBagConstraints();
				gbc_spContactos.gridheight = 2;
				gbc_spContactos.insets = new Insets(0, 0, 5, 5);
				gbc_spContactos.fill = GridBagConstraints.BOTH;
				gbc_spContactos.gridx = 0;
				gbc_spContactos.gridy = 0;
				pnlPrincipal.add(spContactos, gbc_spContactos);
				{
					listContactos = new JList();
					listContactos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					listContactos.setLayoutOrientation(JList.HORIZONTAL_WRAP);
					spContactos.setViewportView(listContactos);
				}
			}
			{
				txtBuscar = new JTextField();
				GridBagConstraints gbc_txtBuscar = new GridBagConstraints();
				gbc_txtBuscar.insets = new Insets(0, 0, 5, 5);
				gbc_txtBuscar.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtBuscar.gridx = 1;
				gbc_txtBuscar.gridy = 1;
				pnlPrincipal.add(txtBuscar, gbc_txtBuscar);
				txtBuscar.setColumns(10);
			}
			{
				comboBox = new JComboBox();
				comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nombre", "Telefono"}));
				GridBagConstraints gbc_comboBox = new GridBagConstraints();
				gbc_comboBox.insets = new Insets(0, 0, 5, 5);
				gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboBox.gridx = 2;
				gbc_comboBox.gridy = 1;
				pnlPrincipal.add(comboBox, gbc_comboBox);
			}
			{
				btnBuscar = new JButton("Buscar");
				GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
				gbc_btnBuscar.insets = new Insets(0, 0, 5, 0);
				gbc_btnBuscar.gridx = 3;
				gbc_btnBuscar.gridy = 1;
				pnlPrincipal.add(btnBuscar, gbc_btnBuscar);
			}
			{
				pnlDatos = new JPanel();
				pnlDatos.setBorder(new TitledBorder(null, "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
				pnlDatos.setLayout(null);
				GridBagConstraints gbc_pnlDatos = new GridBagConstraints();
				gbc_pnlDatos.gridheight = 3;
				gbc_pnlDatos.insets = new Insets(0, 0, 0, 5);
				gbc_pnlDatos.fill = GridBagConstraints.BOTH;
				gbc_pnlDatos.gridx = 0;
				gbc_pnlDatos.gridy = 2;
				pnlPrincipal.add(pnlDatos, gbc_pnlDatos);
				{
					lblNombre = new JLabel("Nombre");
					lblNombre.setBounds(10, 21, 135, 14);
					pnlDatos.add(lblNombre);
				}
				{
					lblTelefono = new JLabel("Telefono");
					lblTelefono.setBounds(10, 45, 135, 14);
					pnlDatos.add(lblTelefono);
				}
			}
			{
				btnAnadir = new JButton("Añadir");
				GridBagConstraints gbc_btnAnadir = new GridBagConstraints();
				gbc_btnAnadir.anchor = GridBagConstraints.EAST;
				gbc_btnAnadir.insets = new Insets(0, 0, 5, 5);
				gbc_btnAnadir.gridx = 1;
				gbc_btnAnadir.gridy = 2;
				pnlPrincipal.add(btnAnadir, gbc_btnAnadir);
			}
			{
				btnModificar = new JButton("Modify");
				GridBagConstraints gbc_btnModificar = new GridBagConstraints();
				gbc_btnModificar.insets = new Insets(0, 0, 5, 5);
				gbc_btnModificar.gridx = 2;
				gbc_btnModificar.gridy = 2;
				pnlPrincipal.add(btnModificar, gbc_btnModificar);
			}
			{
				btnBorrar = new JButton("Borrar");
				GridBagConstraints gbc_btnBorrar = new GridBagConstraints();
				gbc_btnBorrar.insets = new Insets(0, 0, 5, 0);
				gbc_btnBorrar.gridx = 3;
				gbc_btnBorrar.gridy = 2;
				pnlPrincipal.add(btnBorrar, gbc_btnBorrar);
			}
		}
	}
}
