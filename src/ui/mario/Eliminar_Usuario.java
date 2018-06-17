package ui.mario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Eliminar_Usuario extends JFrame {

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
					Eliminar_Usuario frame = new Eliminar_Usuario();
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
	public Eliminar_Usuario() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 477, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Identificacion");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(21, 54, 144, 25);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(154, 60, 181, 20);
		contentPane.add(textField);
		
		JButton button = new JButton("Buscar");
		button.setBounds(339, 59, 89, 23);
		contentPane.add(button);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(21, 90, 416, 3);
		contentPane.add(separator);
		
		JLabel label_1 = new JLabel("Nombres");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBounds(21, 104, 144, 25);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(116, 110, 219, 20);
		contentPane.add(textField_1);
		
		JLabel lblEliminarUsuario = new JLabel("Eliminar Usuario");
		lblEliminarUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminarUsuario.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblEliminarUsuario.setBackground(SystemColor.menu);
		lblEliminarUsuario.setBounds(0, 0, 461, 31);
		contentPane.add(lblEliminarUsuario);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.setBounds(178, 157, 89, 42);
		contentPane.add(btnEliminar);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(21, 42, 416, 3);
		contentPane.add(separator_1);
	}
}
