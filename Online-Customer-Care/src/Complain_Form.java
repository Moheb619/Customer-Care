import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Complain_Form extends JFrame {

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
						Complain_Form frame = new Complain_Form();
						frame.setVisible(true);
					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
	}

	/**
	 * Create the frame.
	 */
	public Complain_Form() throws Exception {
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
		
		JLabel lblNewLabel = new JLabel("Service Request Form");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(168, 11, 249, 23);
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
		addressText.setWrapStyleWord(true);
		addressText.setLineWrap(true);
		addressText.setBounds(217, 220, 286, 73);
		contentPane.add(addressText);
		
		JTextArea nameText = new JTextArea();
		nameText.setBounds(217, 82, 286, 23);
		contentPane.add(nameText);
		
		JTextArea emailText = new JTextArea();
		emailText.setBounds(217, 122, 286, 23);
		contentPane.add(emailText);
		
		JTextArea phoneText = new JTextArea();
		phoneText.setBounds(217, 170, 286, 23);
		contentPane.add(phoneText);
		
		JComboBox priorityText = new JComboBox();
		priorityText.setFont(new Font("Tahoma", Font.PLAIN, 13));
		priorityText.setModel(new DefaultComboBoxModel(new String[] {"Urgent", "Normal"}));
		priorityText.setBounds(217, 315, 99, 22);
		contentPane.add(priorityText);
		
		JTextArea problemText = new JTextArea();
		problemText.setWrapStyleWord(true);
		problemText.setLineWrap(true);
		problemText.setBounds(218, 372, 285, 138);
		contentPane.add(problemText);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name="'"+nameText.getText()+"'";
				String address="'"+addressText.getText()+"'";
				String priority="'"+priorityText.getSelectedItem()+"'";
				String email="'"+emailText.getText()+"'";
				String phone="'"+phoneText.getText()+"'";
				String problem="'"+problemText.getText()+"'";
				String sql="INSERT INTO complain VALUES ("+name+","+email+","+phone+","+address+","+priority+","+problem+");";
				try {
					st.executeUpdate(sql);
					
					nameText.setText("");
					addressText.setText("");
					emailText.setText("");
					phoneText.setText("");
					problemText.setText("");
					
					JOptionPane.showMessageDialog(null,"Submitted Successfully");
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(404, 542, 99, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("*Please submit a service request response about your problem");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(60, 44, 440, 26);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Login");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Login l=new Login();
				l.setVisible(true);
			}
		});
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(60, 11, 46, 23);
		contentPane.add(lblNewLabel_3);

	}
}
