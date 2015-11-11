package Presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Dialog.ModalityType;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dominio.POJO.Contacto;
import Dominio.Gestores.GestorContacto;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

@SuppressWarnings({ "serial", "unused" })
public class Modify extends JDialog {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNombre;
	private JLabel lblTelefono;
	private JTextField txtName;
	private JTextField txtTLFN;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private Contacto c;

	
	public Modify(Contacto c) {
		setModalityType(ModalityType.DOCUMENT_MODAL);
		addWindowListener(new ThisWindowListener());
		this.c=c;
		
		setTitle("Modificar Contacto");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 312, 201);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(44, 35, 46, 14);
		panel.add(lblNombre);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(44, 60, 57, 14);
		panel.add(lblTelefono);
		
		txtName = new JTextField();
		txtName.addFocusListener(new TxtNameFocusListener());
		txtName.setBounds(133, 32, 86, 20);
		panel.add(txtName);
		txtName.setColumns(10);
		txtName.setText(c.getNombre());
		
		txtTLFN = new JTextField();
		txtTLFN.setEnabled(false);
		txtTLFN.addFocusListener(new TxtTLFNFocusListener());
		txtTLFN.setBounds(133, 57, 86, 20);
		panel.add(txtTLFN);
		txtTLFN.setColumns(10);
		txtTLFN.setText(c.getTelefono());
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new BtnAceptarActionListener());
		btnAceptar.setBounds(31, 97, 89, 23);
		panel.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new BtnCancelarActionListener());
		btnCancelar.setBounds(143, 97, 89, 23);
		panel.add(btnCancelar);
	}
	private class BtnCancelarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			dispose();
			setVisible(false);
		}
	}
	private class BtnAceptarActionListener implements ActionListener{
		@SuppressWarnings("unchecked")
		public void actionPerformed(ActionEvent e) {
			try{
				String Nombre= txtName.getText();
				String Telefono= txtTLFN.getText();
				new GestorContacto().modify(txtName.getText(),txtTLFN.getText());
			}
			catch(Exception q){
				q.printStackTrace();
			}
			dispose();
			setVisible(false);
		}
	}
	private class ThisWindowListener extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent arg0) {
			contentPane.setVisible(false);
			dispose();
		}
	}
	private class TxtNameFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent arg0) {
			txtName.setBackground(new Color(250,250,210));
		}
		@Override
		public void focusLost(FocusEvent e) {
			txtName.setBackground(new Color(250,250,250));
		}
	}
	private class TxtTLFNFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent e) {
			txtTLFN.setBackground(new Color(250,250,210));
		}
		@Override
		public void focusLost(FocusEvent e){
			txtTLFN.setBackground(new Color(250,250,250));
		}
	}
			
}
