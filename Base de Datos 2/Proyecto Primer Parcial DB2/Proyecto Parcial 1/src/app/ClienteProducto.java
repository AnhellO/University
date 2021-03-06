/*
 * Created by JFormDesigner on Tue Sep 29 18:50:56 CDT 2015
 */

package app;

import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

import cnx.Conexion;

/**
 * @author Angel Jaime
 * @version 2.0.0
 * @date 07/11/2015
 */
public class ClienteProducto extends JFrame {
	public ClienteProducto() {
		initComponents();
		this.setTitle("Clientes - Productos");
		btnUpd.setEnabled(false);
	}
	
	private void cleanTxt() {
		txtCodeClient.setText("");
		txtCodeProd.setText("");
	}
	
	private void btnBackMouseClicked(MouseEvent e) {
		ChooseTable ch = new ChooseTable();
		ch.setVisible(true);
		this.dispose();
	}

	private void btnExitMouseClicked(MouseEvent e) {
		this.dispose();
	}

	private void btnBackKeyPressed(KeyEvent e) {
		ChooseTable ch = new ChooseTable();
		ch.setVisible(true);
		this.dispose();
	}

	private void btnExitKeyPressed(KeyEvent e) {
		this.dispose();
	}

	private void btnAddMouseClicked(MouseEvent e) {
		try {
			String code1 = JOptionPane.showInputDialog("Ingrese el c�digo del cliente. El campo de c�digo no puede estar vac�o: ");
			String code2 = JOptionPane.showInputDialog("Ingrese el c�digo del producto. El campo de c�digo no puede estar vac�o: ");
			while(code1.isEmpty() && code2.isEmpty()) {
				code1 = JOptionPane.showInputDialog("Ingrese el c�digo del cliente. El campo de c�digo no puede estar vac�o: ");
				code2 = JOptionPane.showInputDialog("Ingrese el c�digo del producto. El campo de c�digo no puede estar vac�o: ");
			}
			Conexion c = new Conexion();
			Statement st = c.getConexion().createStatement();
			c.getConexion().setSavepoint();
			String insert = "INSERT INTO BD2.ClienteProducto VALUES (" + code1 + ", " + code2 + ")";
			//System.out.println(insert);
			st.executeUpdate(insert);
			JOptionPane.showMessageDialog(null, "Adici�n exitosa!");
			c.getConexion().commit();
			st.close();
			c.getConexion().close();
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "No se pudo insertar nuevos registros a la Base de Datos!. Intente de Nuevo");
			e1.printStackTrace();
		}
	}

	private void btnShowMouseClicked(MouseEvent e) {
		int id1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el c�digo del cliente: "));
		int id2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el c�digo del producto: "));
		boolean flag = false;
		try {
			Conexion c = new Conexion();
			Statement st = c.getConexion().createStatement();
			c.getConexion().setSavepoint();
			ResultSet rs = st.executeQuery("SELECT * FROM BD2.ClienteProducto");
			while(rs.next()) {
				if(rs.getInt(1) == id1 && rs.getInt(2) == id2) {
					flag = true;
					txtCodeClient.setText(rs.getString(1));
					txtCodeProd.setText(rs.getString(2));
				}
			}
			if(!flag) {
				JOptionPane.showMessageDialog(null, "No se encontr� el registro!");
				c.getConexion().rollback();
			} else {
				JOptionPane.showMessageDialog(null, "Consulta exitosa!");
				c.getConexion().commit();
			}
			st.close();
			c.getConexion().close();
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "No se pudo consultar a la Base de Datos!");
			e1.printStackTrace();
		}
	}

	private void btnCleanMouseClicked(MouseEvent e) {
		cleanTxt();
	}

	private void btnUpdMouseClicked(MouseEvent e) {
		try {
			String code1 = JOptionPane.showInputDialog("Ingrese el c�digo del cliente. El campo de c�digo no puede estar vac�o: ");
			String code2 = JOptionPane.showInputDialog("Ingrese el c�digo del producto. El campo de c�digo no puede estar vac�o: ");
			while(code1.isEmpty() && code2.isEmpty()) {
				code1 = JOptionPane.showInputDialog("Ingrese el c�digo del cliente. El campo de c�digo no puede estar vac�o: ");
				code2 = JOptionPane.showInputDialog("Ingrese el c�digo del producto. El campo de c�digo no puede estar vac�o: ");
			}
			String upd;
			upd = "UPDATE BD2.Producto SET IdCliente = ?, IdProducto = ? WHERE IdCliente = ? AND IdProducto = ?";
			Conexion c = new Conexion();
			PreparedStatement st = c.getConexion().prepareStatement(upd);
			c.getConexion().setSavepoint();
			st.setInt(1, Integer.parseInt(txtCodeClient.getText()));
			st.setInt(2, Integer.parseInt(txtCodeProd.getText()));
			st.setInt(3, Integer.parseInt(txtCodeClient.getText()));
			st.setInt(4, Integer.parseInt(txtCodeProd.getText()));
			//System.out.println(upd);
			st.executeUpdate();
			JOptionPane.showMessageDialog(null, "Actualizaci�n exitosa!");
			c.getConexion().commit();
			st.close();
			c.getConexion().close();
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "No se pudo actualizar los registros de la Base de Datos!. Intente de nuevo");
			e1.printStackTrace();
		}
	}

	private void btnDelMouseClicked(MouseEvent e) {
		try {
			String s1 = JOptionPane.showInputDialog("Ingrese el Registro de c�digo cliente a eliminar. Este no puede estar vac�o: ");
			String s2 = JOptionPane.showInputDialog("Ingrese el Registro de c�digo producto a eliminar. Este no puede estar vac�o: ");
			while(s1.isEmpty() && s2.isEmpty()) {
				s1 = JOptionPane.showInputDialog("Ingrese el Registro de c�digo cliente a eliminar. Este no puede estar vac�o: ");
				s2 = JOptionPane.showInputDialog("Ingrese el Registro de c�digo producto a eliminar. Este no puede estar vac�o: ");
			}
			int id1 = Integer.parseInt(s1);
			int id2 = Integer.parseInt(s2);
			String del;
			del = "DELETE BD2.ClienteProducto WHERE IdCliente = ? AND IdProducto = ?";
			Conexion c = new Conexion();
			PreparedStatement st = c.getConexion().prepareStatement(del);
			c.getConexion().setSavepoint();
			st.setInt(1, id1);
			st.setInt(2, id2);
			//System.out.println(upd);
			st.executeUpdate();
			JOptionPane.showMessageDialog(null, "Eliminaci�n exitosa!");
			c.getConexion().commit();
			st.close();
			c.getConexion().close();
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro de la Base de Datos!. Intente de nuevo");
			e1.printStackTrace();
		}
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Angel Jaime
		lblCodeClient = new JLabel();
		txtCodeClient = new JTextField();
		lblCodeProd = new JLabel();
		txtCodeProd = new JTextField();
		btnBack = new JButton();
		btnExit = new JButton();
		btnUpd = new JButton();
		btnDel = new JButton();
		btnAdd = new JButton();
		btnShow = new JButton();
		btnClean = new JButton();

		//======== this ========
		setResizable(false);
		Container contentPane = getContentPane();

		//---- lblCodeClient ----
		lblCodeClient.setText("C\u00f3digo Cliente:");
		lblCodeClient.setFont(new Font("Tahoma", Font.BOLD, 12));

		//---- txtCodeClient ----
		txtCodeClient.setEnabled(false);

		//---- lblCodeProd ----
		lblCodeProd.setText("C\u00f3digo Producto:");
		lblCodeProd.setFont(new Font("Tahoma", Font.BOLD, 12));

		//---- txtCodeProd ----
		txtCodeProd.setEnabled(false);

		//---- btnBack ----
		btnBack.setText("Volver Al Men\u00fa");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnBackMouseClicked(e);
			}
		});
		btnBack.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				btnBackKeyPressed(e);
			}
		});

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

		//---- btnUpd ----
		btnUpd.setText("Actualizar");
		btnUpd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnUpdMouseClicked(e);
			}
		});

		//---- btnDel ----
		btnDel.setText("Eliminar");
		btnDel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnDelMouseClicked(e);
			}
		});

		//---- btnAdd ----
		btnAdd.setText("Agregar");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnAddMouseClicked(e);
			}
		});

		//---- btnShow ----
		btnShow.setText("Consultar");
		btnShow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnShowMouseClicked(e);
			}
		});

		//---- btnClean ----
		btnClean.setText("Limpiar");
		btnClean.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnCleanMouseClicked(e);
			}
		});

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGroup(contentPaneLayout.createParallelGroup()
								.addComponent(btnShow, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnDel, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnUpd, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
							.addComponent(lblCodeClient, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(txtCodeClient, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(0, 149, Short.MAX_VALUE)
							.addGroup(contentPaneLayout.createParallelGroup()
								.addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
									.addComponent(lblCodeProd, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
								.addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
									.addComponent(btnClean, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
									.addGap(18, 18, 18)))
							.addGroup(contentPaneLayout.createParallelGroup()
								.addGroup(contentPaneLayout.createSequentialGroup()
									.addGap(12, 12, 12)
									.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
									.addGap(34, 34, 34)
									.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
								.addComponent(txtCodeProd, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE))))
					.addGap(21, 21, 21))
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
					.addContainerGap(53, Short.MAX_VALUE)
					.addGroup(contentPaneLayout.createParallelGroup()
						.addComponent(lblCodeClient, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCodeClient, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(63, 63, 63)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(lblCodeProd, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCodeProd, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(94, 94, 94)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnClean, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGap(22, 22, 22)
					.addComponent(btnShow, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(28, 28, 28)
					.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(33, 33, 33)
					.addComponent(btnDel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(33, 33, 33)
					.addComponent(btnUpd, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(59, Short.MAX_VALUE))
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Angel Jaime
	private JLabel lblCodeClient;
	private JTextField txtCodeClient;
	private JLabel lblCodeProd;
	private JTextField txtCodeProd;
	private JButton btnBack;
	private JButton btnExit;
	private JButton btnUpd;
	private JButton btnDel;
	private JButton btnAdd;
	private JButton btnShow;
	private JButton btnClean;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
