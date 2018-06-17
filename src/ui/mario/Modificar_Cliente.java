package ui.mario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JSeparator;

public class Modificar_Cliente extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modificar_Cliente frame = new Modificar_Cliente();
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
	public Modificar_Cliente() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 471, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 455, 272);
		contentPane.add(panel);
		
		JLabel lblModificarCliente = new JLabel("Modificar Cliente");
		lblModificarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificarCliente.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblModificarCliente.setBackground(SystemColor.menu);
		lblModificarCliente.setBounds(0, 0, 496, 31);
		panel.add(lblModificarCliente);
		
		JLabel label_1 = new JLabel("Identificacion");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBounds(21, 54, 144, 25);
		panel.add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(154, 60, 181, 20);
		panel.add(textField);
		
		JLabel label_2 = new JLabel("Nombres");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_2.setBounds(21, 104, 144, 25);
		panel.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(116, 110, 219, 20);
		panel.add(textField_1);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEdad.setBounds(21, 144, 191, 25);
		panel.add(lblEdad);
		
		JLabel label_4 = new JLabel("Telefono");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_4.setBounds(21, 183, 144, 25);
		panel.add(label_4);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(116, 189, 219, 20);
		panel.add(textField_2);
		
		JLabel label_5 = new JLabel("Direccion");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_5.setBounds(21, 219, 144, 25);
		panel.add(label_5);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(116, 225, 219, 20);
		panel.add(textField_3);
		
		JButton button = new JButton("Modificar");
		button.setBackground(Color.WHITE);
		button.setBounds(356, 214, 89, 42);
		panel.add(button);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(21, 90, 416, 3);
		panel.add(separator);
		
		JButton button_1 = new JButton("Buscar");
		button_1.setBounds(339, 59, 89, 23);
		panel.add(button_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(21, 42, 416, 3);
		panel.add(separator_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(223, 150, 112, 20);
		panel.add(textField_4);
	}
}
