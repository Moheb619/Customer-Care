import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField passfield;

	public static void main(String[] args) {
				Login frame=new Login();
				frame.setVisible(true);
				}
			

	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 494);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(179,224,255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login Form");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(292, 86, 104, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Online Customer Care Service");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(192, 11, 358, 37);
		contentPane.add(lblNewLabel_1);
		
		passfield = new JTextField();
		passfield.setBounds(292, 193, 86, 20);
		contentPane.add(passfield);
		passfield.setColumns(10);
		
		JLabel passlabel = new JLabel("Password");
		passlabel.setBounds(220, 196, 62, 14);
		contentPane.add(passlabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().equals("Customer")) {
					passlabel.setVisible(false);
					passfield.setVisible(false);
				}
				else {
					passlabel.setVisible(true);
					passfield.setVisible(true);
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Employee", "Customer"}));
		comboBox.setBounds(292, 146, 88, 22);
		contentPane.add(comboBox);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().toString().equals("Employee")) {
					if(passfield.getText().equals("1234")) {
						dispose();
						try {
							Employee emp=new Employee();
							emp.setVisible(true);
						}
						catch(Exception ex) {
							ex.printStackTrace();
						}
					}
					else {
						passfield.setText("");
						JOptionPane.showInternalMessageDialog(null, "You Entered Wrong Password", "Wrong Password", JOptionPane.WARNING_MESSAGE);
					}
				}
				else {
					dispose();
					try {
						Customer c=new Customer();
						c.setVisible(true);
					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setBounds(291, 244, 89, 23);
		contentPane.add(btnNewButton);
		
		
	}
}
