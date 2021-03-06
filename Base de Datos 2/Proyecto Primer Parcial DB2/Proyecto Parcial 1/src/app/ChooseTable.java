/*
 * Created by JFormDesigner on Tue Sep 29 16:51:04 CDT 2015
 */

package app;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Angel Jaime
 */
public class ChooseTable extends JFrame {
	public ChooseTable() {
		initComponents();
		this.setTitle("Selecci�n De Tablas");
	}

	private void btnExitMouseClicked(MouseEvent e) {
		this.dispose();
	}

	private void menuClientsMouseClicked(MouseEvent e) {
		Clientes c = new Clientes();
		c.setVisible(true);
		this.setVisible(false);
	}

	private void menuProductsMouseClicked(MouseEvent e) {
		Productos pr = new Productos();
		pr.setVisible(true);
		this.setVisible(false);
	}

	private void menuSuppliersMouseClicked(MouseEvent e) {
		Proveedores p = new Proveedores();
		p.setVisible(true);
		this.setVisible(false);
	}

	private void menuClientProductMouseClicked(MouseEvent e) {
		ClienteProducto cp = new ClienteProducto();
		cp.setVisible(true);
		this.setVisible(false);
	}

	private void btnExitKeyPressed(KeyEvent e) {
		this.dispose();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Angel Jaime
		menubTables = new JMenuBar();
		menuClients = new JMenu();
		menuProducts = new JMenu();
		menuSuppliers = new JMenu();
		menuClientProduct = new JMenu();
		btnExit = new JButton();

		//======== this ========
		setResizable(false);
		Container contentPane = getContentPane();

		//======== menubTables ========
		{

			//======== menuClients ========
			{
				menuClients.setText("Clientes");
				menuClients.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						menuClientsMouseClicked(e);
					}
				});
			}
			menubTables.add(menuClients);

			//======== menuProducts ========
			{
				menuProducts.setText("Productos");
				menuProducts.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						menuProductsMouseClicked(e);
					}
				});
			}
			menubTables.add(menuProducts);

			//======== menuSuppliers ========
			{
				menuSuppliers.setText("Proveedores");
				menuSuppliers.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						menuSuppliersMouseClicked(e);
					}
				});
			}
			menubTables.add(menuSuppliers);

			//======== menuClientProduct ========
			{
				menuClientProduct.setText("Cliente - Producto");
				menuClientProduct.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						menuClientProductMouseClicked(e);
					}
				});
			}
			menubTables.add(menuClientProduct);
		}
		setJMenuBar(menubTables);

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
				btnExitKeyPressed(e);
			}
		});

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
					.addContainerGap(89, Short.MAX_VALUE)
					.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addGap(85, 85, 85))
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
					.addContainerGap(38, Short.MAX_VALUE)
					.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(24, 24, 24))
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Angel Jaime
	private JMenuBar menubTables;
	private JMenu menuClients;
	private JMenu menuProducts;
	private JMenu menuSuppliers;
	private JMenu menuClientProduct;
	private JButton btnExit;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
