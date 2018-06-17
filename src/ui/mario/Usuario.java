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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class Usuario extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuario frame = new Usuario();
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
	public Usuario() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Usuarios");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label.setBackground(SystemColor.menu);
		label.setBounds(0, 11, 434, 31);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Agregar Usuario");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBounds(90, 68, 174, 31);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Modificar Usuario");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_2.setBounds(90, 110, 174, 31);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Eliminar Usuario");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_3.setBounds(90, 152, 174, 31);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Ver Usuarios");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_4.setBounds(90, 194, 174, 31);
		contentPane.add(label_4);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Agregar_usuario nuevaVentana = new Agregar_usuario();
				 nuevaVentana.setVisible (true);	
			}
		});
		button.setBounds(256, 76, 89, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Modificar_Usuario Ventana = new Modificar_Usuario();
				 Ventana.setVisible (true);
			}
		});
		button_1.setBounds(256, 118, 89, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Eliminar_Usuario VentanaEliminar = new Eliminar_Usuario();
				VentanaEliminar.setVisible (true);
			}
		});
		button_2.setBounds(256, 160, 89, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setBounds(256, 202, 89, 23);
		contentPane.add(button_3);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(53, 63, 322, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(53, 105, 322, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(53, 147, 322, 2);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(53, 194, 322, 2);
		contentPane.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(53, 233, 322, 2);
		contentPane.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(396, 68, 1, 162);
		contentPane.add(separator_5);
	}
}
