package cuoiky;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class create extends JFrame {
//		JButton jbtlogin = new JButton("Ä�Ä‚NG NHáº¬P");

	public create() {
		JFrame frame = new JFrame("--WECOME--");

		ImageIcon imasv = new ImageIcon("C:/Users/Admin/eclipse-workspace/cuoiky/cuoiky/student.png");
		JButton jbtsv = new JButton("SINH VIÊN");
		jbtsv.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				new sinhvien();
			}
		});
		jbtsv.setIcon(imasv);

		/*
		 * //jbtlogin.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
		 * method stub new login(); frame.dispose();
		 * 
		 * } });
		 */

		jbtsv.setBackground(Color.DARK_GRAY);
		jbtsv.setForeground(Color.GREEN);
		jbtsv.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		jbtsv.setBounds(50, 420, 250, 50);

		ImageIcon imagv = new ImageIcon("C:/Users/Admin/eclipse-workspace/cuoiky/cuoiky/teacher.png");
		JButton jbtgv = new JButton("GIẢNG VIÊN");
		jbtgv.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				new giangvien();
			}
		});
		jbtgv.setIcon(imagv);

		jbtgv.setBackground(Color.DARK_GRAY);
		jbtgv.setForeground(Color.GREEN);
		jbtgv.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		jbtgv.setBounds(350, 420, 250, 50);

		ImageIcon jmada = new ImageIcon("C:/Users/Admin/eclipse-workspace/cuoiky/cuoiky/project.png");
		JButton jbtdoan = new JButton("ĐỀ ÁN");
		jbtdoan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				new project();
			}
		});
		jbtdoan.setIcon(jmada);
		jbtdoan.setBackground(Color.DARK_GRAY);
		jbtdoan.setForeground(Color.GREEN);
		jbtdoan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		jbtdoan.setBounds(650, 420, 250, 50);

		ImageIcon imgreturn = new ImageIcon("C:/Users/Admin/eclipse-workspace/cuoiky/cuoiky/return.png");

		JButton jbtreturn = new JButton("LOG OUT");

		jbtreturn.setIcon(imgreturn);
		jbtreturn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new login();
				frame.dispose();
			}
		});

		jbtreturn.setBackground(Color.PINK);
		jbtreturn.setForeground(Color.BLACK);
		jbtreturn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		jbtreturn.setBounds(835, 10, 140, 30);

		ImageIcon icon = new ImageIcon("C:/Users/Admin/eclipse-workspace/cuoiky/cuoiky/htqldatn.png");

		JLabel label = new JLabel();
		label.setText("");
		label.setIcon(icon);

		JPanel pink = new JPanel();
		pink.setBackground(Color.white);
		pink.setBounds(0, 50, 1000, 100);

		/*
		 * ImageIcon imgcreate = new
		 * ImageIcon("D:/bt_java/cuoiki/src/cuoiki/create.png"); JLabel jlbtao = new
		 * JLabel(); jlbtao.setIcon(imgcreate); jlbtao.setText("NEW TABLE");
		 * jlbtao.setBounds(250,50, 250, 50);; jlbtao.setForeground(Color.RED);
		 * jlbtao.setFont(new Font("Times New Roman",Font.PLAIN, 18));
		 * 
		 * JPanel jptao = new JPanel(); jptao.setBackground(Color.ORANGE);
		 * jptao.setBounds(50, 250, 200, 40);
		 */

		ImageIcon welcome = new ImageIcon("C:/Users/Admin/eclipse-workspace/cuoiky/cuoiky/welcome.png");

		JLabel jlwc = new JLabel();
		jlwc.setText("");
		jlwc.setIcon(welcome);

		JPanel jpwc = new JPanel();
		jpwc.setBackground(Color.WHITE);
		jpwc.setBounds(220, 180, 550, 180);

		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(1000, 550);
		frame.setLayout(null);
		frame.setVisible(true);
		pink.add(label);
		frame.add(pink);
		/*
		 * jptao.add(jlbtao); frame.add(jptao);
		 */jpwc.add(jlwc);
		frame.add(jpwc);
		frame.add(jbtsv);
		frame.add(jbtgv);
		frame.add(jbtdoan);
		frame.add(jbtreturn);
		frame.setLocationRelativeTo(null);

	}

	private void setDefaultLookAndFeelDecorated(int exitOnClose) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new create();

	}

}
