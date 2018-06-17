package ui.mario;

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
import javax.swing.JButton;
import java.awt.Color;

public class Agregar_Cliente extends JFrame {

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
					Agregar_Cliente frame = new Agregar_Cliente();
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
	public Agregar_Cliente() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 482, 337);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Agregar Cliente");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label.setBackground(SystemColor.menu);
		label.setBounds(0, 0, 434, 31);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Identificacion");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBounds(21, 65, 144, 25);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(154, 71, 181, 20);
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
		
		JButton button = new JButton("Guardar");
		button.setBackground(Color.WHITE);
		button.setBounds(358, 252, 89, 42);
		contentPane.add(button);
	}

}
