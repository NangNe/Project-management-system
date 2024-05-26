package cuoiky;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class login extends JFrame {
	String user = "2";
	String pass = "2";

	public login() {

		JFrame jf = new JFrame("LoGin");
		// tạo login
		ImageIcon icon = new ImageIcon("D:/java/cuoiky/src/cuoiky/login.png");

		JLabel jlten = new JLabel("Hi, I'm Root");
		jlten.setBounds(250, 40, 300, 400);
		jlten.setForeground(Color.RED);
		jlten.setFont(new Font("Times New Roman", Font.BOLD, 24));

		JPanel jptao = new JPanel();
		jptao.setBackground(Color.ORANGE);
		jptao.setBounds(150, 20, 250, 50);

		// Tạo username
		JLabel jluser = new JLabel("USERNAME");
		jluser.setBounds(120, 120, 150, 20);
		jluser.setForeground(Color.WHITE);
		jluser.setFont(new Font("Times New Roman", Font.BOLD, 18));

		JPanel jpuser = new JPanel();
		jpuser.setBackground(Color.BLACK);
		jpuser.setBounds(120, 100, 150, 30);
		jpuser.add(jluser);

		// tạo password
		JLabel jlpass = new JLabel("PASSWORD");
		jlpass.setBounds(120, 140, 150, 20);
		jlpass.setForeground(Color.WHITE);
		jlpass.setFont(new Font("Times New Roman", Font.BOLD, 18));

		JPanel jppass = new JPanel();
		jppass.setBackground(Color.BLACK);
		jppass.setBounds(120, 140, 150, 30);
		jppass.add(jlpass);

		// tao text user
		JTextField jtuser = new JTextField();
		jtuser.setBounds(300, 100, 150, 30);
		jtuser.setBackground(Color.WHITE);

		// taopass
		JPasswordField jppasss = new JPasswordField();
		jppasss.setBounds(300, 140, 150, 30);
		jppasss.setBackground(Color.WHITE);

		// taobutonlogin

		ImageIcon iconn = new ImageIcon("D:/java/cuoiky/src/cuoiky/account.png");
		JButton jblogin = new JButton("LOGIN");

		jblogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				if (jtuser.getText().equalsIgnoreCase(user) && jppasss.getText().equals(pass)) {

					JFrame jfok = new JFrame("Successsfully");

					JLabel Jlbok = new JLabel("Logged in successfully");
					Jlbok.setBounds(100, 20, 200, 30);
					Jlbok.setBackground(Color.gray);
					Jlbok.setFont(new Font("Times New Roman", Font.BOLD, 20));

					JButton btnok = new JButton("OK");
					btnok.setBounds(150, 90, 100, 30);
					btnok.setBackground(Color.YELLOW);
					btnok.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							jfok.dispose();
							jf.dispose();
							new create();
							// jfok.disable();
						}
					});
					jfok.add(Jlbok);
					jfok.add(btnok);

					jfok.setSize(400, 180);
					jfok.setDefaultCloseOperation(jfok.EXIT_ON_CLOSE);
					jfok.setLayout(null);
					jfok.setVisible(true);
					jfok.setLocationRelativeTo(null);

				} else {
					// create container "rturn" return container "Login"
					JFrame rturn = new JFrame("Error!");

					JLabel Jlberror = new JLabel("UserName or PassWord is incorrect!");
					Jlberror.setBounds(30, 20, 350, 30);
					Jlberror.setBackground(Color.gray);
					Jlberror.setFont(new Font("Times New Roman", Font.BOLD, 20));

					JButton btnok1 = new JButton("OK");
					btnok1.setBounds(150, 80, 100, 30);
					btnok1.setBackground(Color.YELLOW);
					btnok1.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
							rturn.dispose();

						}
					});
					rturn.add(Jlberror);
					rturn.add(btnok1);

					rturn.setSize(400, 180);
					rturn.setDefaultCloseOperation(rturn.EXIT_ON_CLOSE);
					rturn.setLayout(null);
					rturn.setVisible(true);
					rturn.setLocationRelativeTo(null);

				}
			}
		});

		jblogin.setIcon(iconn);
		jblogin.setBounds(50, 200, 160, 35);
		jblogin.setBackground(Color.pink);
		jblogin.setFont(new Font("Times New Roman", Font.BOLD, 20));

		// buttonreturn
		ImageIcon iconnn = new ImageIcon("D:/java/cuoiky/src/cuoiky/return.png");
		JButton jbreturn = new JButton("RETURN");
		jbreturn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new test();
			}
		});
		jbreturn.setIcon(iconnn);
		jbreturn.setBounds(380, 200, 160, 35);
		jbreturn.setBackground(Color.pink);
		jbreturn.setFont(new Font("Times New Roman", Font.BOLD, 20));

		jlten.setIcon(icon);
		jptao.add(jlten);
		jf.add(jptao);
		jf.add(jppass);
		jf.add(jpuser);
		jf.add(jtuser);
		jf.add(jppasss);
		jf.add(jblogin);
		jf.add(jbreturn);

		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jf.setSize(600, 300);

		jf.setLayout(null);
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new login();
	}

}
