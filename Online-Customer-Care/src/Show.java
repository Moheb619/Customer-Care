import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Show extends JFrame {

	private JPanel contentPane;
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
						Show frame = new Show("");
						frame.setVisible(true);
					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
	}

	/**
	 * Create the frame.
	 */
	public Show(String num) throws Exception {
		url="jdbc:mysql://localhost:3306/database-name";
		uname="root";
		pass="password";
		con=DriverManager.getConnection(url,uname,pass);
		st=con.createStatement();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 630);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Show Detail");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(215, 11, 145, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(60, 81, 108, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(60, 121, 108, 23);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Phone Number:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(60, 169, 108, 23);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Address:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(60, 219, 108, 23);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Priority:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4.setBounds(60, 313, 108, 23);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Problem:");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_5.setBounds(60, 371, 108, 23);
		contentPane.add(lblNewLabel_1_5);
		
		JTextArea addressText = new JTextArea();
		addressText.setEditable(false);
		addressText.setWrapStyleWord(true);
		addressText.setLineWrap(true);
		addressText.setBounds(217, 220, 286, 73);
		contentPane.add(addressText);
		
		JTextArea nameText = new JTextArea();
		nameText.setEditable(false);
		nameText.setBounds(217, 82, 286, 23);
		contentPane.add(nameText);
		
		JTextArea emailText = new JTextArea();
		emailText.setEditable(false);
		emailText.setBounds(217, 122, 286, 23);
		contentPane.add(emailText);
		
		JTextArea phoneText = new JTextArea();
		phoneText.setEditable(false);
		phoneText.setBounds(217, 170, 286, 23);
		contentPane.add(phoneText);
		
		
		JTextArea problemText = new JTextArea();
		problemText.setEditable(false);
		problemText.setWrapStyleWord(true);
		problemText.setLineWrap(true);
		problemText.setBounds(218, 372, 285, 138);
		contentPane.add(problemText);
		
		JTextArea priorityText = new JTextArea();
		priorityText.setEditable(false);
		priorityText.setBounds(217, 314, 286, 23);
		contentPane.add(priorityText);
		
		JButton btnNewButton = new JButton("Go Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					Employee emp=new Employee();
					emp.setVisible(true);
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(455, 545, 89, 23);
		contentPane.add(btnNewButton);
		
		String phn="'"+num+"'";
		String sql="SELECT*FROM complain WHERE Phone="+phn+";";
		ResultSet rs=st.executeQuery(sql);
		
		if(rs.next()) {
			nameText.setText(rs.getString("Name"));
			emailText.setText(rs.getString("Email"));
			phoneText.setText(rs.getString("Phone"));
			addressText.setText(rs.getString("Address"));
			priorityText.setText(rs.getString("Priority"));
			problemText.setText(rs.getString("Problem"));
		}

	}
}
