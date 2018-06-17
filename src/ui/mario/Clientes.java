package ui.mario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Clientes extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientes frame = new Clientes();
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
	public Clientes() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Clientes");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label.setBackground(SystemColor.menu);
		label.setBounds(0, 11, 434, 31);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Agregar Cliente");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBounds(90, 53, 174, 31);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Modificar Cliente");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_2.setBounds(90, 95, 174, 31);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Eliminar Cliente");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_3.setBounds(90, 137, 174, 31);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Ver Clientes");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_4.setBounds(90, 179, 174, 31);
		contentPane.add(label_4);
		
		JButton button = new JButton("");
		button.setBounds(256, 187, 89, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Eliminar_Cliente VentanaAgregar = new Eliminar_Cliente();
				VentanaAgregar.setVisible (true);
			}
		});
		button_1.setBounds(256, 145, 89, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Modificar_Cliente VentanaAgregar = new Modificar_Cliente();
				VentanaAgregar.setVisible (true);
			
			}
		});
		button_2.setBounds(256, 103, 89, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Agregar_Cliente VentanaAgregar = new Agregar_Cliente();
				VentanaAgregar.setVisible (true);
			}
		});
		button_3.setBounds(256, 61, 89, 23);
		contentPane.add(button_3);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(68, 53, 322, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(68, 95, 322, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(68, 132, 322, 2);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(68, 179, 322, 2);
		contentPane.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(68, 221, 322, 2);
		contentPane.add(separator_4);
	}

}
