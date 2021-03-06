import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import DAO.CarHistoryModel;
import DAO.CarProductsDAO;
import DAO.CarProductsModel;
import DAO.CustomerDAO;
import DAO.CustomerModel;
import DAO.HistoryProdutcsDAO;
import DTO.Customer;
import DTO.HistoryCar;
import DTO.SimpleCar;
import Untilities.DBConnection;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ProductsPanel extends JPanel {

	private CarProductsModel tableModel;
	private JTable table;
	private CarProductsDAO cpDAO;
	private HistoryProdutcsDAO hpDAO;
	private CustomerDAO cDAO;
	public ProductsPanel() throws ClassNotFoundException, IOException, SQLException {
		  this.setLayout(null);
		  DBConnection.init("database.properties");
		  Connection conn = DBConnection.getConnection();
		  cpDAO = new CarProductsDAO(conn);
		  cpDAO.loadDataCarToList();
		  hpDAO = new HistoryProdutcsDAO(conn);
		  cDAO = new CustomerDAO(conn);
		  cDAO.loadDataToList();
		  tableModel = new CarProductsModel(cpDAO);
	      table = new JTable(tableModel);
	      table = new JTable(tableModel);
	      table.setFont(new Font("Times New Roman", Font.PLAIN, 10));
	      table.setAutoCreateRowSorter(true);
	      JScrollPane scrollPane = new JScrollPane(table);
	      scrollPane.setBounds(10, 50, 800, 200);
	      this.add(scrollPane);
	      scrollPane.setPreferredSize(new Dimension(800, 200));
	      this.setPreferredSize(new Dimension(800, 600));
	      
	      JLabel lblNewLabel = new JLabel("Searching: ");
	      lblNewLabel.setBounds(10, 10, 66, 18);
	      add(lblNewLabel);
	      
	      JTextField tf_search = new JTextField();
	      tf_search.setBounds(86, 10, 108, 19);
	      add(tf_search);
	      tf_search.setColumns(10);
	      
	      JButton btn_search = new JButton("Search");
	      btn_search.setBounds(239, 9, 85, 21);
	      add(btn_search);
	      
	      JLabel lblNewLabel_1 = new JLabel("Products Information");
	      lblNewLabel_1.setBounds(60, 260, 122, 19);
	      add(lblNewLabel_1);
	      
	      JLabel lblNewLabel_2 = new JLabel("Products Name");
	      lblNewLabel_2.setBounds(10, 288, 97, 18);
	      add(lblNewLabel_2);
	      
	      JTextField tf_name = new JTextField();
	      tf_name.setBounds(151, 289, 122, 26);
	      add(tf_name);
	      tf_name.setColumns(10);
	      
	      JLabel lblNewLabel_3 = new JLabel("Products TradeMark");
	      lblNewLabel_3.setBounds(10, 328, 97, 19);
	      add(lblNewLabel_3);
	      
	      JTextField tf_model = new JTextField();
	      tf_model.setBounds(151, 325, 122, 26);
	      add(tf_model);
	      tf_model.setColumns(10);
	      
	      JLabel lblNewLabel_4 = new JLabel("Products Type");
	      lblNewLabel_4.setBounds(10, 364, 85, 18);
	      add(lblNewLabel_4);
	      
	      JTextField tf_type = new JTextField();
	      tf_type.setBounds(151, 361, 122, 26);
	      add(tf_type);
	      tf_type.setColumns(10);
	      
	      JButton btn_add = new JButton("Add Products");
	      btn_add.setBounds(60, 542, 132, 33);
	      add(btn_add);
	      
	      JLabel lblNewLabel_5 = new JLabel("Customer Information");
	      lblNewLabel_5.setBounds(575, 260, 125, 19);
	      add(lblNewLabel_5);
	      
	      JLabel lblNewLabel_6 = new JLabel("Customer Name");
	      lblNewLabel_6.setBounds(432, 291, 108, 21);
	      add(lblNewLabel_6);
	      
	      JTextField c_name = new JTextField();
	      c_name.setBounds(585, 291, 164, 26);
	      add(c_name);
	      c_name.setColumns(10);
	      
	      JLabel lblNewLabel_7 = new JLabel("Customer Date of Birth");
	      lblNewLabel_7.setBounds(432, 339, 132, 21);
	      add(lblNewLabel_7);
	      
	      JTextField c_date = new JTextField();
	      c_date.setBounds(585, 340, 164, 26);
	      add(c_date);
	      c_date.setColumns(10);
	      
	      JLabel lblNewLabel_8 = new JLabel("Customer Address");
	      lblNewLabel_8.setBounds(432, 387, 108, 21);
	      add(lblNewLabel_8);
	      
	      JTextField c_address = new JTextField();
	      c_address.setBounds(585, 381, 164, 26);
	      add(c_address);
	      c_address.setColumns(10);
	      
	      JLabel lblNewLabel_9 = new JLabel("Customer Phone");
	      lblNewLabel_9.setBounds(432, 433, 108, 21);
	      add(lblNewLabel_9);
	      
	      JTextField c_phone = new JTextField();
	      c_phone.setBounds(585, 431, 164, 26);
	      add(c_phone);
	      c_phone.setColumns(10);
	      
	      JButton btn_sell = new JButton("Sell");
	      btn_sell.setBounds(524, 496, 97, 33);
	      add(btn_sell);
	      
	      JLabel lblNewLabel_10 = new JLabel("Color");
	      lblNewLabel_10.setBounds(10, 401, 66, 18);
	      add(lblNewLabel_10);
	      
	      JTextField tf_color = new JTextField();
	      tf_color.setBounds(146, 401, 132, 19);
	      add(tf_color);
	      tf_color.setColumns(10);
	      
	      JLabel lblNewLabel_11 = new JLabel("Status");
	      lblNewLabel_11.setBounds(10, 441, 45, 13);
	      add(lblNewLabel_11);
	      
	      JTextField tf_status = new JTextField();
	      tf_status.setBounds(156, 434, 96, 19);
	      add(tf_status);
	      tf_status.setColumns(10);
	      
	      JLabel lblNewLabel_12 = new JLabel("Price");
	      lblNewLabel_12.setBounds(10, 482, 45, 13);
	      add(lblNewLabel_12);
	      
	      JTextField tf_price= new JTextField();
	      tf_price.setBounds(156, 479, 96, 19);
	      add(tf_price);
	      tf_price.setColumns(10);
	      btn_add.addActionListener(new ActionListener(){
	  		@Override
	  		public void actionPerformed(ActionEvent arg0) {
	  			// TODO Auto-generated method stub
	  			//int id = Integer.parseInt(tf_id.getText());
	  			
	  			LocalDate date;
	  			try {
	  				SimpleCar sCar = new SimpleCar();
	  				HistoryCar hCar = new HistoryCar();
	  				int products_id = cpDAO.getNewIDInTable();
	  				int history_id =  hpDAO.getNewIDInHistoryTable();
	  				String name = tf_name.getText();
	  				String trademark = tf_model.getText();
	  				String type = tf_type.getText();
	  				String color = tf_color.getText();
	  				String status = tf_status.getText();
	  				double price = Double.parseDouble(tf_price.getText());
	  				date = sCar.getProducts_add_date();
	  				//tf_date.setText(String.valueOf(date));
	  				double p_export_price = price + (price / 100 * 20);
	  				double h_export_price = hCar.getHistory_export_price();
	  				String check = sCar.getProducts_check();
	  				SimpleCar simpleCar = new SimpleCar(products_id, name, trademark, type, color, status, p_export_price, date, check);
	  				
	  				HistoryCar historyCar = new HistoryCar(history_id, name, trademark, type, color, status, price, h_export_price, date);
	  				cpDAO.createNewCarInTable(simpleCar);
	  				hpDAO.createNewCarHistoryInTable(historyCar);
	  				cpDAO.addNewCarToList(simpleCar);
	  				//hpDAO.addNewHistoryProducts(historyCar);
	  				tableModel.fireTableDataChanged();
	  				
	  			} catch (SQLException e1) {
	  				// TODO Auto-generated catch block
	  				e1.printStackTrace();
	  			}	
	  		}
	        });
	      btn_sell.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int r = table.getSelectedRow();
				if(r != -1) {
					int r_model = table.convertRowIndexToModel(r);
					int id = (int) tableModel.getValueAt(r_model, 0);
					try {
						int c_id = cDAO.getNewIDInTableCustomer();
						String name = c_name.getText();
						LocalDate date = LocalDate.parse(c_date.getText());
						String address = c_address.getText();
						String phone = c_phone.getText();
						hpDAO.updateHistoryInTable(id);
						cpDAO.updateStatus(id);
						cpDAO.updateCarInList(id, "Sold Out");
						tableModel.fireTableDataChanged();
						Customer cus = new Customer(c_id, name, date, address, phone, id);
						cDAO.createNewCustomerInTable(cus);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
//	      btn_search.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				TableRowSorter<CarProductsModel> sorter = new TableRowSorter<CarProductsModel>(tableModel);
//				table.setRowSorter(sorter);
//				RowFilter<CarProductsModel, Object> filter = null;
//				filter = RowFilter.regexFilter(tf_search.getText(),2);
//				sorter.setRowFilter(filter);
//			}
//		});
	}
}



