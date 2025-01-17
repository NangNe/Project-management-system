package cuoiky;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop.Action;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import cuoiky.ConnectionDB;

//import chucnang.ConnectionDB;

public class sinhvien extends JFrame {
	private Statement stmt;
	private PreparedStatement ps;
	private ConnectionDB conn;

	private static DefaultTableModel dtm;

	JButton btnBACK = new JButton("RETURN");
	JButton btnRE = new JButton("REFRESH");
	JButton btnADD = new JButton("ADD");
	JButton btnSUA = new JButton("EDIT");
	JButton btnDEL = new JButton("DELETE");
	JButton btnFIND = new JButton("FIND");
	JButton btnCOUNT = new JButton("COUNT");
	
	JLabel Jlbid = new JLabel("ID SV:             ");
	JLabel Jlbht = new JLabel("Name:             ");
	JLabel Jlbns = new JLabel("Date of birth :");
	JLabel Jlbgt = new JLabel("Sex:(1:M)(0:F)");
	JLabel Jlbdc = new JLabel("Adress:           ");
	JLabel Jlbem = new JLabel("Email:             ");
	JLabel Jlblp = new JLabel("Class:             ");
	JLabel Jlbpro = new JLabel("ID Project:     ");

	JTextField tfid = new JTextField(30);
	JTextField tfht = new JTextField(30);
	JTextField tfns = new JTextField(30);
	JTextField tfgt = new JTextField(10);
	JTextField tfdc = new JTextField(30);
	JTextField tfem = new JTextField(30);
	JTextField tflp = new JTextField(30);
	JTextField tfpro = new JTextField(30);
	JTextField tfcount = new JTextField(5);
	public sinhvien() {

		dtm = new DefaultTableModel();
		JTable jtableKQ = new JTable(dtm);
		dtm.addColumn("ID SV");
		dtm.addColumn("Name ");
		dtm.addColumn("Date of birth");
		dtm.addColumn("Sex");
		dtm.addColumn("Adress");
		dtm.addColumn("Email");
		dtm.addColumn("Class");
		dtm.addColumn("ID Project");
		loadata();
		JScrollPane sc = new JScrollPane(jtableKQ);
		loadata();

		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder title = BorderFactory.createTitledBorder(border, "STUDENT INFORMATION");

		Border border1 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder title1 = BorderFactory.createTitledBorder(border1, "INFORMATION INSERT");

		Border border2 = BorderFactory.createLineBorder(Color.green);
		TitledBorder title2 = BorderFactory.createTitledBorder(border2, "");

		JFrame JFrKQ = new JFrame();

		JPanel north = new JPanel();
		JPanel n_north = new JPanel();
		JPanel nn_west = new JPanel();
		JPanel south = new JPanel();
		JPanel center = new JPanel();
		JPanel east = new JPanel();
		JPanel id = new JPanel();
		JPanel ht = new JPanel();
		JPanel ns = new JPanel();
		JPanel gt = new JPanel();
		JPanel dc = new JPanel();
		JPanel em = new JPanel();
		JPanel lp = new JPanel();
		JPanel pro = new JPanel();

		JFrKQ.setLayout(new BorderLayout());
		center.setLayout(new GridLayout(8, 2));
		east.setLayout(new GridLayout(4, 1));
		north.setLayout(new BorderLayout());
		n_north.setLayout(new BorderLayout());
		nn_west.setLayout(new GridLayout(1, 2));

		JFrKQ.add(north, "North");
		JFrKQ.add(south, "East");
		JFrKQ.add(center, "Center");
		JFrKQ.add(east, "West");
		north.add(n_north, "West");
		n_north.add(nn_west, "West");

		south.add(sc);
		south.setBorder(title);
		center.setBorder(title1);
		east.setBorder(title2);

		id.add(Jlbid);
		id.add(tfid);
		ht.add(Jlbht);
		ht.add(tfht);
		ns.add(Jlbns);
		ns.add(tfns);
		gt.add(Jlbgt);
		gt.add(tfgt);
		dc.add(Jlbdc);
		dc.add(tfdc);

		em.add(Jlbem);
		em.add(tfem);
		lp.add(Jlblp);
		lp.add(tflp);
		pro.add(Jlbpro);
		pro.add(tfpro);

		center.add(id);
		center.add(ht);
		center.add(ns);
		center.add(gt);
		center.add(dc);
		center.add(em);
		center.add(lp);
		center.add(pro);
		center.add(btnADD);
		center.add(btnSUA);
		center.add(btnDEL);
		center.add(btnFIND);
		center.add(btnRE);
	//	center.add(btnCOUNT);
	//	center.add(tfcount);

		nn_west.add(btnBACK);
		center.setLayout(new GridLayout(3, 2));
		center.setLayout(new FlowLayout(FlowLayout.LEFT));
		center.setBackground(Color.white);
		south.setBackground(Color.white);

//		JFrKQ.pack();
		JFrKQ.setTitle("Quản lí thông tin sinh viên");
		JFrKQ.setSize(950, 500);
		JFrKQ.setLocationRelativeTo(null);
		JFrKQ.setVisible(true);
		btnBACK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JFrKQ.dispose();
				new create();
			}
		});

		btnADD.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				conn = new ConnectionDB();
				try {
					ps = conn.getConn().prepareCall("insert into sinhvien values (?, ?, ?, ?, ?, ?, ?, ? )");
					ps.setString(1, tfid.getText());
					ps.setString(2, tfht.getText());
					ps.setString(3, tfns.getText());
					ps.setString(4, tfgt.getText());
					ps.setString(5, tfdc.getText());
					ps.setString(6, tfem.getText());
					ps.setString(7, tflp.getText());
					ps.setString(8, tfpro.getText());

					ps.execute();
					dtm.addRow(new String[] { tfid.getText(), tfht.getText(), tfns.getText(), tfgt.getText(),
							tfdc.getText(), tfem.getText(), tflp.getText(), tfpro.getText() });
					dtm.setRowCount(0);

					tfid.setText("");
					tfht.setText("");
					tfns.setText("");
					tfgt.setText("");
					tfdc.setText("");
					tfem.setText("");
					tflp.setText("");
					tfpro.setText("");

					loadata();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e.getMessage()); 
				}
			}
		});

		jtableKQ.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				tfid.setText((String) jtableKQ.getValueAt(jtableKQ.getSelectedRow(), 0));
				tfht.setText((String) jtableKQ.getValueAt(jtableKQ.getSelectedRow(), 1));
				tfns.setText((String) jtableKQ.getValueAt(jtableKQ.getSelectedRow(), 2));
				tfgt.setText((String) jtableKQ.getValueAt(jtableKQ.getSelectedRow(), 3));
				tfdc.setText((String) jtableKQ.getValueAt(jtableKQ.getSelectedRow(), 4));
				tfem.setText((String) jtableKQ.getValueAt(jtableKQ.getSelectedRow(), 5));
				tflp.setText((String) jtableKQ.getValueAt(jtableKQ.getSelectedRow(), 6));
				tfpro.setText((String) jtableKQ.getValueAt(jtableKQ.getSelectedRow(), 7));
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		btnSUA.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				conn = new ConnectionDB();
				try {
					ps = conn.getConn().prepareStatement(
							"update sinhvien set Name = ? , Dateofbirth = ?, Sex = ?, Adress = ?,Email = ?, Class = ?,IDProject = ? where IDSV ="
									+ "'" + jtableKQ.getValueAt(jtableKQ.getSelectedRow(), 0) + "'");
					ps.setString(1, tfht.getText());
					ps.setString(2, tfns.getText());
					ps.setString(3, tfgt.getText());
					ps.setString(4, tfdc.getText());
					ps.setString(5, tfem.getText());
					ps.setString(6, tflp.getText());
					ps.setString(7, tfpro.getText());
					ps.executeUpdate();
					dtm.setRowCount(0);
					// loadata();

					tfid.setText("");
					tfht.setText("");
					tfns.setText("");
					tfgt.setText("");
					tfdc.setText("");
					tfem.setText("");
					tflp.setText("");
					tfpro.setText("");
					loadata();
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, ex.getMessage()); //bÃ¡o lá»—i
				}
			}
		});
		btnRE.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tfid.setText("");
				tfht.setText("");
				tfns.setText("");
				tfgt.setText("");
				tfdc.setText("");
				tfem.setText("");
				tflp.setText("");
				tfpro.setText("");

				loadata();
			}
		});

		btnDEL.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					ps = conn.getConn().prepareStatement("DELETE FROM sinhvien WHERE IDSV = ?");
					ps.setString(1, jtableKQ.getValueAt(jtableKQ.getSelectedRow(), 0).toString());
					ps.executeUpdate();
					dtm.setRowCount(0);

					tfid.setText("");
					tfht.setText("");
					tfns.setText("");
					tfgt.setText("");
					tfdc.setText("");
					tfem.setText("");
					tflp.setText("");
					tfpro.setText("");

					loadata();

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});

		btnFIND.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				ResultSet rs;
				conn = new ConnectionDB();
				try {
					// rs = conn.getStm().executeQuery("select * from sinhvien where IDSV = N" + "'"
					// + tfid.getText() + "'" );
					// dtm.setRowCount(0);
					rs = conn.getStm().executeQuery("select * from sinhvien where IDSV = N" + "'" + tfid.getText() + "'"
							+ " or Name = N" + "'" + tfht.getText() + "'" + " or Dateofbirth = N" + "'" + tfns.getText()
							+ "'" + " or Sex = N" + "'" + tfgt.getText() + "'" + " or Adress = N" + "'" + tfdc.getText()
							+ "'" + " or Email = N" + "'" + tfem.getText() + "'" + " or Class = N" + "'"
							+ tflp.getText() + "'" + " or IDProject = N" + "'" + tfpro.getText() + "'");
					dtm.setRowCount(0);

					while (rs.next()) {
						dtm.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
								rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8) });

					}

				} catch (Exception e2) {
					// TODO: handle exception
				}

			}
		});
		btnCOUNT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ResultSet rs;
				int count = 0;
				  conn = new ConnectionDB();
				try {
						rs = conn.getStm().executeQuery("select * from sinhvien ");
						
						while(rs.next()) {	
							++count;
						}	
						tfcount.setText(Integer.toString(count));
					}

				 catch (Exception e2) {
					// TODO: handle exception
				}

			
			}
		});

	}

	public static void main(String args[]) {
		new sinhvien();
	}

	public void loadata() {
		conn = new ConnectionDB();
		ResultSet rs;
		try {
			dtm.setRowCount(0);
			rs = conn.getStm().executeQuery("select * from sinhvien");
			while (rs.next()) {
				dtm.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8) });
			}
		} catch (SQLException e) { // TODOAuto-generated catch block e.printStackTrace();
		}
	}
}
