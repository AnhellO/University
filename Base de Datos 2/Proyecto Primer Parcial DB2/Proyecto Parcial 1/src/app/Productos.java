/*
 * Created by JFormDesigner on Tue Sep 29 18:31:08 CDT 2015
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
 */
public class Productos extends JFrame {
	public Productos() {
		initComponents();
		this.setTitle("Productos");
	}
	
	private void cleanTxt() {
		txtCode.setText("");
		txtProduct.setText("");
		txtPrice.setText("");
		txtIdSupplier.setText("");
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
			String code = JOptionPane.showInputDialog("Ingrese el c�digo del producto. El campo de c�digo no puede estar vac�o: ");
			while(code.isEmpty()) {
				code = JOptionPane.showInputDialog("Ingrese el c�digo del producto. El campo de c�digo no puede estar vac�o: ");
			}
			String product = JOptionPane.showInputDialog("Ingrese el nombre del producto: ");
			String price = JOptionPane.showInputDialog("Ingrese el precio del producto ");
			String supCode = JOptionPane.showInputDialog("Ingrese el c�digo del proveedor del producto: ");
			if(product.isEmpty()) {
				product += ".";
			}
			if(price.isEmpty()) {
				price = "-1";
			}
			if(supCode.isEmpty()) {
				supCode = "1";
			}
			Conexion c = new Conexion();
			Statement st = c.getConexion().createStatement();
			String insert = "INSERT INTO BD2.Producto VALUES (" + code + ", '" + product + 
							"', " + price + ", " + supCode + ")";
			//System.out.println(insert);
			st.executeUpdate(insert);
			JOptionPane.showMessageDialog(null, "Adici�n exitosa!");
			c.getConexion().close();
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "No se pudo insertar nuevos registros a la Base de Datos!. Intente de nuevo");
			e1.printStackTrace();
		}
	}

	private void btnShowMouseClicked(MouseEvent e) {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el c�digo del producto: "));
		boolean flag = false;
		try {
			Conexion c = new Conexion();
			Statement st = c.getConexion().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM BD2.Producto");
			while(rs.next()) {
				if(rs.getInt(1) == id) {
					flag = true;
					txtCode.setText(rs.getString(1));
					txtProduct.setText(rs.getString(2));
					txtPrice.setText(rs.getString(3));
					txtIdSupplier.setText(rs.getString(4));
				}
			}
			if(!flag) {
				JOptionPane.showMessageDialog(null, "No se encontr� el registro!");
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

	private void btnUpdMouseClicked(MouseEvent e) {
		try {
			String code = JOptionPane.showInputDialog("Ingrese el c�digo del producto. El campo de c�digo no puede estar vac�o: ");
			while(code.isEmpty()) {
				code = JOptionPane.showInputDialog("Ingrese el c�digo del producto. El campo de c�digo no puede estar vac�o: ");
			}
			String product = JOptionPane.showInputDialog("Ingrese el nuevo nombre del producto: ");
			String price = JOptionPane.showInputDialog("Ingrese el nuevo precio del producto ");
			String supCode = JOptionPane.showInputDialog("Ingrese el nuevo c�digo del proveedor del producto: ");
			if(product.isEmpty()) {
				product += ".";
			}
			if(price.isEmpty()) {
				price = "-1";
			}
			if(supCode.isEmpty()) {
				supCode = "1";
			}
			String upd;
			upd = "UPDATE BD2.Producto SET Nombre = ?, Precio = ?, IdProveedor = ? WHERE IdProducto = ?";
			Conexion c = new Conexion();
			PreparedStatement st = c.getConexion().prepareStatement(upd);
			st.setString(1, product);
			st.setInt(2, Integer.parseInt(price));
			st.setInt(3, Integer.parseInt(supCode));
			st.setInt(4, Integer.parseInt(code));
			//System.out.println(upd);
			st.executeUpdate();
			JOptionPane.showMessageDialog(null, "Actualizaci�n exitosa!");
			c.getConexion().close();
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "No se pudo actualizar los registros de la Base de Datos!. Intente de nuevo");
			e1.printStackTrace();
		}
	}

	private void btnDelMouseClicked(MouseEvent e) {
		try {
			String s = JOptionPane.showInputDialog("Ingrese el Registro a eliminar. Este no puede estar vac�o: ");
			while(s.isEmpty()) {
				s = JOptionPane.showInputDialog("Ingrese el Registro a eliminar. Este no puede estar vac�o: ");
			}
			int id = Integer.parseInt(s);
			String del;
			del = "DELETE BD2.Producto WHERE IdProducto = ?";
			Conexion c = new Conexion();
			PreparedStatement st = c.getConexion().prepareStatement(del);
			st.setInt(1, id);
			//System.out.println(upd);
			st.executeUpdate();
			JOptionPane.showMessageDialog(null, "Eliminaci�n exitosa!");
			c.getConexion().close();
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro de la Base de Datos!. Intente de nuevo");
			e1.printStackTrace();
		}
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Angel Jaime
		btnBack = new JButton();
		btnExit = new JButton();
		lblCode = new JLabel();
		txtCode = new JTextField();
		lblProduct = new JLabel();
		txtProduct = new JTextField();
		lblPrice = new JLabel();
		txtPrice = new JTextField();
		lblIdSupplier = new JLabel();
		txtIdSupplier = new JTextField();
		btnUpd = new JButton();
		btnDel = new JButton();
		btnAdd = new JButton();
		btnShow = new JButton();
		btnClean = new JButton();

		//======== this ========
		setResizable(false);
		Container contentPane = getContentPane();

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

		//---- lblCode ----
		lblCode.setText("C\u00f3digo Producto:");
		lblCode.setFont(new Font("Tahoma", Font.BOLD, 12));

		//---- txtCode ----
		txtCode.setEnabled(false);

		//---- lblProduct ----
		lblProduct.setText("Producto:");
		lblProduct.setFont(new Font("Tahoma", Font.BOLD, 12));

		//---- txtProduct ----
		txtProduct.setEnabled(false);

		//---- lblPrice ----
		lblPrice.setText("Precio:");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 12));

		//---- txtPrice ----
		txtPrice.setEnabled(false);

		//---- lblIdSupplier ----
		lblIdSupplier.setText("C\u00f3digo Proveedor:");
		lblIdSupplier.setFont(new Font("Tahoma", Font.BOLD, 12));

		//---- txtIdSupplier ----
		txtIdSupplier.setEnabled(false);

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
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(18, 18, 18)
							.addGroup(contentPaneLayout.createParallelGroup()
								.addComponent(btnShow, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnDel, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnUpd, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(contentPaneLayout.createParallelGroup()
								.addGroup(contentPaneLayout.createSequentialGroup()
									.addComponent(lblCode, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(txtCode, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE))
								.addGroup(contentPaneLayout.createSequentialGroup()
									.addComponent(lblProduct, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(txtProduct, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE))
								.addGroup(contentPaneLayout.createSequentialGroup()
									.addComponent(lblPrice, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(txtPrice, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE))
								.addGroup(contentPaneLayout.createSequentialGroup()
									.addComponent(lblIdSupplier, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(txtIdSupplier, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE))))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(161, 161, 161)
							.addComponent(btnClean, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addGap(32, 32, 32)
							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addGap(29, 29, 29)
							.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
					.addGap(22, 22, 22))
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
					.addGap(11, 11, 11)
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(txtCode, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCode, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
							.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lblProduct, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtProduct, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
							.addGap(28, 28, 28)
							.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(txtPrice, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPrice, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
							.addGap(25, 25, 25)
							.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(txtIdSupplier, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblIdSupplier, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
							.addGap(37, 37, 37))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addComponent(btnShow, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addGap(28, 28, 28)
							.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addGap(33, 33, 33)
							.addComponent(btnDel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addGap(33, 33, 33)
							.addComponent(btnUpd, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)))
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnClean, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Angel Jaime
	private JButton btnBack;
	private JButton btnExit;
	private JLabel lblCode;
	private JTextField txtCode;
	private JLabel lblProduct;
	private JTextField txtProduct;
	private JLabel lblPrice;
	private JTextField txtPrice;
	private JLabel lblIdSupplier;
	private JTextField txtIdSupplier;
	private JButton btnUpd;
	private JButton btnDel;
	private JButton btnAdd;
	private JButton btnShow;
	private JButton btnClean;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
