import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Employee extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private String url;		
	private String uname;
	private String pass; 
	private Connection con;
	private Statement st; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Employee frame=new Employee();
			frame.setVisible(true);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public Employee() throws Exception{
		url="jdbc:mysql://localhost:3306/database-name";
		uname="root";
		pass="password";
		con=DriverManager.getConnection(url,uname,pass);
		st=con.createStatement();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 896, 502);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255,250,160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Service Rrequest List");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(358, 11, 194, 25);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 47, 860, 332);
		contentPane.add(scrollPane);
		
		model=new DefaultTableModel() {
			@Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		
		table=new JTable();
		Object[] column= {"Name","Email","Phone","Address","Priority","Complain Box"};
		Object[] row=new Object[6];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		ResultSet rs = st.executeQuery("SELECT*FROM complain");
        while(rs.next())
		{
				row[0]=rs.getString("Name");
				row[1]=rs.getString("Email");
				row[2]=rs.getString("Phone");
				row[3]=rs.getString("Address");
				row[4]=rs.getString("Priority");
				row[5]=rs.getString("Problem");
				model.addRow(row);
		}
		
		JButton btnNewButton = new JButton("Show");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=table.getSelectedRow();
				String num=model.getValueAt(i, 2).toString();
				try {
					dispose();
					Show s=new Show(num);
					s.setVisible(true);
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(276, 410, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=table.getSelectedRow();
				String num="'"+model.getValueAt(i, 2).toString()+"'";
				try {
					String sql="DELETE FROM complain WHERE Phone="+num+";";
					st.executeUpdate(sql);
					model.removeRow(i);
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnClear.setBounds(525, 410, 89, 23);
		contentPane.add(btnClear);
		
		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Login l=new Login();
				l.setVisible(true);
			}
		});
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(76, 19, 46, 17);
		contentPane.add(lblNewLabel_1);
		
	}
}
