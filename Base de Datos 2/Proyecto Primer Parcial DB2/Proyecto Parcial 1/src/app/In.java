/*
 * Created by JFormDesigner on Tue Sep 29 16:34:34 CDT 2015
 */

package app;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Angel Jaime
 */
public class In extends JFrame {
	private String user = "Angel";
	private char[] password = {'b', 'd', '2'};
	
	public In() {
		initComponents();
		this.setTitle("Admin");
	}

	private void btnExitMouseClicked(MouseEvent e) {
		this.dispose();
	}

	private void btnNextMouseClicked(MouseEvent e) {
		char[] temp = pwdPass.getPassword();
		if(temp.length != password.length) {
			JOptionPane.showMessageDialog(null, "Usuario y/o Contraseņa Incorrectos. Intente de Nuevo.");
			return;
		}
		boolean flag = true;
		for(int i = 0 ; i < password.length ; i++) {
			if(password[i] != temp[i]) {
				flag = false;
				break;
			}
		}
		if(!flag) {
			JOptionPane.showMessageDialog(null, "Usuario y/o Contraseņa Incorrectos. Intente de Nuevo.");
			txtUser.requestFocusInWindow();
		} else {
			JOptionPane.showMessageDialog(null, "Acceso Validado.");
			ChooseTable ch = new ChooseTable();
			ch.setVisible(true);
			this.dispose();
		}
	}

	private void btnExitKeyPressed(KeyEvent e) {
		this.dispose();
	}

	private void btnNextKeyPressed(KeyEvent e) {
		char[] temp = pwdPass.getPassword();
		if(temp.length != password.length) {
			JOptionPane.showMessageDialog(null, "Usuario y/o Contraseņa Incorrectos. Intente de Nuevo.");
			return;
		}
		boolean flag = true;
		for(int i = 0 ; i < password.length ; i++) {
			if(password[i] != temp[i]) {
				flag = false;
				break;
			}
		}
		if(!flag) {
			JOptionPane.showMessageDialog(null, "Usuario y/o Contraseņa Incorrectos. Intente de Nuevo.");
			txtUser.requestFocusInWindow();
		} else {
			JOptionPane.showMessageDialog(null, "Acceso Validado.");
			ChooseTable ch = new ChooseTable();
			ch.setVisible(true);
			this.dispose();
		}
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Angel Jaime
		lblUser = new JLabel();
		lblPass = new JLabel();
		txtUser = new JTextField();
		pwdPass = new JPasswordField();
		btnExit = new JButton();
		btnNext = new JButton();

		//======== this ========
		setResizable(false);
		Container contentPane = getContentPane();

		//---- lblUser ----
		lblUser.setText("Usuario:");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 12));

		//---- lblPass ----
		lblPass.setText("Contrase\u00f1a:");
		lblPass.setFont(new Font("Tahoma", Font.BOLD, 12));

		//---- pwdPass ----
		pwdPass.setEchoChar('*');

		//---- btnExit ----
		btnExit.setText("Salir");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnExitMouseClicked(e);
			}
		});
		btnExit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				btnExitKeyPressed(e);
			}
		});

		//---- btnNext ----
		btnNext.setText("Ingresar");
		btnNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnNextMouseClicked(e);
			}
		});
		btnNext.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				btnNextKeyPressed(e);
			}
		});

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addContainerGap(244, Short.MAX_VALUE)
							.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGroup(contentPaneLayout.createParallelGroup()
								.addGroup(contentPaneLayout.createSequentialGroup()
									.addGroup(contentPaneLayout.createParallelGroup()
										.addGroup(contentPaneLayout.createSequentialGroup()
											.addGap(47, 47, 47)
											.addComponent(lblUser, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
										.addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
											.addContainerGap()
											.addComponent(lblPass, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addGroup(contentPaneLayout.createParallelGroup()
										.addComponent(txtUser, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
										.addComponent(pwdPass, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)))
								.addGroup(contentPaneLayout.createSequentialGroup()
									.addGap(47, 47, 47)
									.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
							.addGap(0, 1, Short.MAX_VALUE)))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGap(50, 50, 50)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(lblUser, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtUser, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(18, 18, 18)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(lblPass, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(pwdPass, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(18, 18, 18)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Angel Jaime
	private JLabel lblUser;
	private JLabel lblPass;
	private JTextField txtUser;
	private JPasswordField pwdPass;
	private JButton btnExit;
	private JButton btnNext;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
