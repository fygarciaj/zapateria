package ui.mario;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.DropMode;
import java.awt.SystemColor;
import java.awt.Window;

import javax.swing.JInternalFrame;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu window = new menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 560, 471);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextPane txtpnRegistroDeEmpleados = new JTextPane();
		txtpnRegistroDeEmpleados.setBackground(SystemColor.menu);
		txtpnRegistroDeEmpleados.setDropMode(DropMode.INSERT);
		txtpnRegistroDeEmpleados.setEditable(false);
		txtpnRegistroDeEmpleados.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtpnRegistroDeEmpleados.setText("CLINICA CALZADITOS");
		
		JInternalFrame internalFrame = new JInternalFrame("Menu");
		internalFrame.getContentPane().setBackground(SystemColor.activeCaption);
		internalFrame.setVisible(true);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtpnRegistroDeEmpleados, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(internalFrame, GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addComponent(txtpnRegistroDeEmpleados, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(internalFrame, GroupLayout.PREFERRED_SIZE, 387, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(12, Short.MAX_VALUE))
		);
		
		JList list = new JList();
		internalFrame.getContentPane().add(list, BorderLayout.NORTH);
		internalFrame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{list}));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("wewe");
		internalFrame.setJMenuBar(menuBar);
		
		JButton btnNewButton = new JButton("Usuarios");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Usuario nuevaVentana = new Usuario();
			 nuevaVentana.setVisible (true);
			
			}
		});
		menuBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cliente");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Clientes nuevaVentana = new Clientes();
				 nuevaVentana.setVisible (true);
				
			}
		});
		menuBar.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Reparaciones");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Reparaciones nuevaVentana = new Reparaciones();
				 nuevaVentana.setVisible (true);
			}
		});
		menuBar.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Ventas");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Venta nuevaVentana = new Venta();
				 nuevaVentana.setVisible (true);
			}
		});
		menuBar.add(btnNewButton_3);
		frame.getContentPane().setLayout(groupLayout);
	}
}
