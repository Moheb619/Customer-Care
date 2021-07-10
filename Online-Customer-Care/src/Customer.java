import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;
import javax.swing.JScrollPane;

public class Customer extends JFrame {

	private JPanel contentPane;
	private ButtonGroup bg;
	private String choice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
					Customer frame = new Customer();
					frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Customer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 876, 506);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(210,253,187));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer Help Line");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(315, 23, 261, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Problem-");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(112, 83, 90, 24);
		contentPane.add(lblNewLabel_1);
				
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Device sound not working properly");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNewRadioButton.setBackground(new Color(210,253,187));
		rdbtnNewRadioButton.setBounds(88, 133, 261, 23);
		contentPane.add(rdbtnNewRadioButton);	
		
		JRadioButton rdbtnDeviceKeepsRestarting = new JRadioButton("Device Keeps Restarting");
		rdbtnDeviceKeepsRestarting.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnDeviceKeepsRestarting.setBackground(new Color(210, 253, 187));
		rdbtnDeviceKeepsRestarting.setBounds(88, 161, 261, 23);
		contentPane.add(rdbtnDeviceKeepsRestarting);
		
		JRadioButton rdbtnDeviceScreenKeeps = new JRadioButton("Device Screen Keeps Glitching");
		rdbtnDeviceScreenKeeps.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnDeviceScreenKeeps.setBackground(new Color(210, 253, 187));
		rdbtnDeviceScreenKeeps.setBounds(88, 187, 261, 23);
		contentPane.add(rdbtnDeviceScreenKeeps);
		
		JRadioButton rdbtnTheScreenIs = new JRadioButton("The Screen is Frozen");
		rdbtnTheScreenIs.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnTheScreenIs.setBackground(new Color(210, 253, 187));
		rdbtnTheScreenIs.setBounds(88, 213, 261, 23);
		contentPane.add(rdbtnTheScreenIs);
		
		JRadioButton rdbtnTheScreenIs_1 = new JRadioButton("The Screen is Black");
		rdbtnTheScreenIs_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnTheScreenIs_1.setBackground(new Color(210, 253, 187));
		rdbtnTheScreenIs_1.setBounds(88, 239, 261, 23);
		contentPane.add(rdbtnTheScreenIs_1);
		
		JRadioButton rdbtnYouCannotFind = new JRadioButton("Cannot find your problem here");
		rdbtnYouCannotFind.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnYouCannotFind.setBackground(new Color(210, 253, 187));
		rdbtnYouCannotFind.setBounds(88, 265, 261, 23);
		contentPane.add(rdbtnYouCannotFind);
		
		bg=new ButtonGroup();
		bg.add(rdbtnYouCannotFind);
		bg.add(rdbtnTheScreenIs_1);
		bg.add(rdbtnTheScreenIs);
		bg.add(rdbtnDeviceScreenKeeps);
		bg.add(rdbtnDeviceKeepsRestarting);
		bg.add(rdbtnNewRadioButton);
		
		JLabel lblNewLabel_1_1 = new JLabel("Solution");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(476, 83, 90, 24);
		contentPane.add(lblNewLabel_1_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setBounds(476, 118, 332, 170);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("Find Solutioin");
		btnNewButton.setBounds(148, 319, 110, 23);
		contentPane.add(btnNewButton);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
		btnClear.setBounds(582, 319, 110, 23);
		contentPane.add(btnClear);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Enumeration<AbstractButton> bgchoice=bg.getElements();
					while(bgchoice.hasMoreElements()) {
						JRadioButton jrd=(JRadioButton) bgchoice.nextElement();
						if(jrd.isSelected()) {
							choice=jrd.getText().toString();
						}
					}
					if(choice.equals("Device sound not working properly")) {
						textArea.setText("Try Restarting your Device");
					}
					else if(choice.equals("Device Keeps Restarting")) {
						textArea.setText("Check if connection of device is stable");
					}
					else if(choice.equals("Device Screen Keeps Glitching")) {
						textArea.setText("You may need to change the battery of your device");
					}
					else if(choice.equals("The Screen is Frozen")){
						textArea.setText("You have to reboot your device by holding the power button till it shtus down");
					}
					else if(choice.equals("The Screen is Black")) {
						textArea.setText("Check the connection between the power supply and monitor");
					}
					else {
						dispose();
						try {
							Complain_Form c=new Complain_Form();
							c.setVisible(true);
						}
						catch(Exception ex) {
							ex.printStackTrace();
						}
					}
					
			}
		});
	}
}
