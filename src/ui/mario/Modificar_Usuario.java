package ui.mario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JSeparator;

public class Modificar_Usuario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modificar_Usuario frame = new Modificar_Usuario();
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
	public Modificar_Usuario() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 478, 347);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModificarUsuario = new JLabel("Modificar Usuario");
		lblModificarUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificarUsuario.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblModificarUsuario.setBackground(SystemColor.menu);
		lblModificarUsuario.setBounds(0, 0, 496, 31);
		contentPane.add(lblModificarUsuario);
		
		JLabel label_1 = new JLabel("Identificacion");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBounds(21, 54, 144, 25);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(154, 60, 181, 20);
		contentPane.add(textField);
		
		JLabel label_2 = new JLabel("Nombres");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_2.setBounds(21, 104, 144, 25);
		contentPane.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(116, 110, 219, 20);
		contentPane.add(textField_1);
		
		JLabel label_3 = new JLabel("Fecha de Nacimiento");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_3.setBounds(21, 144, 191, 25);
		contentPane.add(label_3);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(222, 149, 113, 20);
		contentPane.add(dateChooser);
		
		JLabel label_4 = new JLabel("Telefono");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_4.setBounds(21, 183, 144, 25);
		contentPane.add(label_4);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(116, 189, 219, 20);
		contentPane.add(textField_2);
		
		JLabel label_5 = new JLabel("Direccion");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_5.setBounds(21, 219, 144, 25);
		contentPane.add(label_5);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(116, 225, 219, 20);
		contentPane.add(textField_3);
		
		JLabel label_6 = new JLabel("Rol");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_6.setBounds(21, 257, 144, 25);
		contentPane.add(label_6);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(116, 263, 219, 20);
		contentPane.add(comboBox);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBackground(Color.WHITE);
		btnModificar.setBounds(358, 252, 89, 42);
		contentPane.add(btnModificar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(21, 90, 416, 3);
		contentPane.add(separator);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(339, 59, 89, 23);
		contentPane.add(btnNewButton);
	}
}
