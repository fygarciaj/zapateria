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
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JSeparator;

public class Eliminar_Cliente extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eliminar_Cliente frame = new Eliminar_Cliente();
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
	public Eliminar_Cliente() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 467, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEliminarCliente = new JLabel("Eliminar Cliente");
		lblEliminarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminarCliente.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblEliminarCliente.setBackground(SystemColor.menu);
		lblEliminarCliente.setBounds(10, 0, 441, 31);
		contentPane.add(lblEliminarCliente);
		
		JLabel label_1 = new JLabel("Identificacion");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBounds(21, 54, 144, 25);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(154, 60, 181, 20);
		contentPane.add(textField);
		
		JButton button = new JButton("Buscar");
		button.setBounds(339, 59, 89, 23);
		contentPane.add(button);
		
		JLabel label_2 = new JLabel("Nombres");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_2.setBounds(21, 104, 144, 25);
		contentPane.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(116, 110, 219, 20);
		contentPane.add(textField_1);
		
		JButton button_1 = new JButton("Eliminar");
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(178, 157, 89, 42);
		contentPane.add(button_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 90, 416, 3);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 40, 416, 3);
		contentPane.add(separator_1);
	}

}
