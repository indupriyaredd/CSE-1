package send_data;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class signin_signup {

	private JFrame frame;
	private JTextField tb1;
	private JPasswordField p1;
	private JTextField tb2;
	private JPasswordField p2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signin_signup window = new signin_signup();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public signin_signup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 376);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(34, 69, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPswd = new JLabel("pswd");
		lblPswd.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPswd.setBounds(34, 129, 46, 19);
		frame.getContentPane().add(lblPswd);
		
		tb1 = new JTextField();
		tb1.setBounds(113, 68, 86, 20);
		frame.getContentPane().add(tb1);
		tb1.setColumns(10);
		
		p1 = new JPasswordField();
		p1.setBounds(113, 128, 86, 20);
		frame.getContentPane().add(p1);
		
		JLabel lblNewLabel_1 = new JLabel("name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(261, 71, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		tb2 = new JTextField();
		tb2.setColumns(10);
		tb2.setBounds(317, 68, 86, 20);
		frame.getContentPane().add(tb2);
		
		JLabel lblPswd_1 = new JLabel("pswd");
		lblPswd_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPswd_1.setBounds(261, 129, 46, 19);
		frame.getContentPane().add(lblPswd_1);
		
		p2 = new JPasswordField();
		p2.setBounds(317, 128, 86, 20);
		frame.getContentPane().add(p2);
		
		JButton btnNewButton = new JButton("sign in");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user=tb1.getText();
				String pswd=p1.getText();
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mrec","root","mrec");
					PreparedStatement stn=con.prepareStatement("select user,password from users where user=?and password=?");
					stn.setString(1, user);
					stn.setString(2, pswd);
					ResultSet rs=stn.executeQuery();
					if(rs.next())
					{
						JOptionPane.showMessageDialog(btnNewButton, "valid user");
					}
					else
						{
						JOptionPane.showMessageDialog(btnNewButton, "invalid user");	
						}
					}
					
				 catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(78, 226, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSignUp = new JButton("sign up");
		btnSignUp.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSignUp.setBounds(306, 226, 97, 23);
		frame.getContentPane().add(btnSignUp);
	}
}
