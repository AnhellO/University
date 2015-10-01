/*
 * Created by JFormDesigner on Tue Sep 29 18:40:48 CDT 2015
 */

package app;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cnx.Conexion;
/**
 * @author Angel Jaime
 */
public class Proveedores extends JFrame {
	public Proveedores() {
		initComponents();
		this.setTitle("Proveedores");
	}
	
	private void cleanTxt() {
		txtCode.setText("");
		txtName.setText("");
		txtAddress.setText("");
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

	private void btnShowMouseClicked(MouseEvent e) {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código del proveedor: "));
		boolean flag = false;
		try {
			Conexion c = new Conexion();
			Statement st = c.getConexion().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM BD2.Proveedor");
			while(rs.next()) {
				if(rs.getInt(1) == id) {
					flag = true;
					txtCode.setText(rs.getString(1));
					txtName.setText(rs.getString(2));
					txtAddress.setText(rs.getString(3));
				}
			}
			if(!flag) {
				JOptionPane.showMessageDialog(null, "No se encontró el registro!");
			} else {
				JOptionPane.showMessageDialog(null, "Consulta exitosa!");
			}
			c.getConexion().close();
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "No se pudo consultar a la Base de Datos!");
			e1.printStackTrace();
		}
	}

	private void btnCleanMouseClicked(MouseEvent e) {
		cleanTxt();
	}

	private void btnAddMouseClicked(MouseEvent e) {
		try {
			String code = JOptionPane.showInputDialog("Ingrese el código del proveedor. El campo de código no puede estar vacío: ");
			while(code.isEmpty()) {
				code = JOptionPane.showInputDialog("Ingrese el código del proveedor. El campo de código no puede estar vacío: ");
			}
			String name = JOptionPane.showInputDialog("Ingrese el nombre del proveedor: ");
			String address = JOptionPane.showInputDialog("Ingrese la dirección del proveedor: ");
			if(name.isEmpty()) {
				name += ".";
			}
			if(address.isEmpty()) {
				address += ".";
			}
			Conexion c = new Conexion();
			Statement st = c.getConexion().createStatement();
			String insert = "INSERT INTO BD2.Proveedor VALUES (" + code + ", '" + name + "', '" + address + "')";
			//System.out.println(insert);
			st.executeUpdate(insert);
			JOptionPane.showMessageDialog(null, "Adición exitosa!");
			c.getConexion().close();
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "No se pudo insertar nuevos registros a la Base de Datos!. Intente de nuevo");
			e1.printStackTrace();
		}
	}

	private void btnUpdMouseClicked(MouseEvent e) {
		try {
			String code = JOptionPane.showInputDialog("Ingrese el código del proveedor a actualizar. El campo de código no puede estar vacío: ");
			while(code.isEmpty()) {
				code = JOptionPane.showInputDialog("Ingrese el código del proveedor a actualizar. El campo de código no puede estar vacío: ");
			}
			String name = JOptionPane.showInputDialog("Ingrese el nuevo nombre del proveedor: ");
			String address = JOptionPane.showInputDialog("Ingrese la nueva dirección del proveedor: ");
			if(name.isEmpty()) {
				name += ".";
			}
			if(address.isEmpty()) {
				address += ".";
			}
			String upd;
			upd = "UPDATE BD2.Proveedor SET Nombre = ?, Direccion = ? WHERE IdProveedor = ?";
			Conexion c = new Conexion();
			PreparedStatement st = c.getConexion().prepareStatement(upd);
			st.setString(1, name);
			st.setString(2, address);
			st.setInt(3, Integer.parseInt(code));
			//System.out.println(upd);
			st.executeUpdate();
			JOptionPane.showMessageDialog(null, "Actualización exitosa!");
			c.getConexion().close();
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "No se pudo actualizar los registros de la Base de Datos!. Intente de nuevo");
			e1.printStackTrace();
		}
	}

	private void btnDelMouseClicked(MouseEvent e) {
		try {
			String s = JOptionPane.showInputDialog("Ingrese el Registro a eliminar. Este no puede estar vacío: ");
			while(s.isEmpty()) {
				s = JOptionPane.showInputDialog("Ingrese el Registro a eliminar. Este no puede estar vacío: ");
			}
			int id = Integer.parseInt(s);
			String del;
			del = "DELETE BD2.Proveedor WHERE IdProveedor = ?";
			Conexion c = new Conexion();
			PreparedStatement st = c.getConexion().prepareStatement(del);
			st.setInt(1, id);
			//System.out.println(upd);
			st.executeUpdate();
			JOptionPane.showMessageDialog(null, "Eliminación exitosa!");
			c.getConexion().close();
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro de la Base de Datos!. Intente de nuevo");
			e1.printStackTrace();
		}
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Angel Jaime
		lblCode = new JLabel();
		txtCode = new JTextField();
		lblName = new JLabel();
		txtName = new JTextField();
		lblAddress = new JLabel();
		txtAddress = new JTextField();
		btnBack = new JButton();
		btnExit = new JButton();
		btnShow = new JButton();
		btnAdd = new JButton();
		btnDel = new JButton();
		btnUpd = new JButton();
		btnClean = new JButton();

		//======== this ========
		setResizable(false);
		Container contentPane = getContentPane();

		//---- lblCode ----
		lblCode.setText("C\u00f3digo Proveedor:");
		lblCode.setFont(new Font("Tahoma", Font.BOLD, 12));

		//---- txtCode ----
		txtCode.setEnabled(false);

		//---- lblName ----
		lblName.setText("Nombre:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));

		//---- txtName ----
		txtName.setEnabled(false);

		//---- lblAddress ----
		lblAddress.setText("Direcci\u00f3n:");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 12));

		//---- txtAddress ----
		txtAddress.setEnabled(false);

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

		//---- btnShow ----
		btnShow.setText("Consultar");
		btnShow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnShowMouseClicked(e);
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

		//---- btnDel ----
		btnDel.setText("Eliminar");
		btnDel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnDelMouseClicked(e);
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
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGroup(contentPaneLayout.createParallelGroup()
								.addGroup(contentPaneLayout.createSequentialGroup()
									.addGroup(contentPaneLayout.createParallelGroup()
										.addComponent(btnShow, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnUpd, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGroup(contentPaneLayout.createParallelGroup()
										.addGroup(contentPaneLayout.createSequentialGroup()
											.addComponent(lblCode, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
											.addComponent(txtCode, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE))
										.addGroup(contentPaneLayout.createSequentialGroup()
											.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
											.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE))
										.addGroup(contentPaneLayout.createSequentialGroup()
											.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
											.addComponent(txtAddress, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE))))
								.addGroup(contentPaneLayout.createSequentialGroup()
									.addGap(154, 154, 154)
									.addComponent(btnClean, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
									.addGap(31, 31, 31)
									.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
									.addGap(27, 27, 27)
									.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
							.addGap(22, 22, 22))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addComponent(btnDel, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(lblCode, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCode, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnShow, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(57, 57, 57)
							.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(28, 28, 28)
							.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)))
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(53, 53, 53)
							.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtAddress, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
							.addGap(47, 47, 47))
						.addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
							.addGap(6, 6, 6)
							.addComponent(btnDel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnUpd, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addGap(18, 18, 18)))
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnClean, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Angel Jaime
	private JLabel lblCode;
	private JTextField txtCode;
	private JLabel lblName;
	private JTextField txtName;
	private JLabel lblAddress;
	private JTextField txtAddress;
	private JButton btnBack;
	private JButton btnExit;
	private JButton btnShow;
	private JButton btnAdd;
	private JButton btnDel;
	private JButton btnUpd;
	private JButton btnClean;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
