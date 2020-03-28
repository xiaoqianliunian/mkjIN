package student;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
//删除
import javax.swing.JTextField;

public class StudentDelete extends JPanel implements ActionListener {

	Connection con;
	Statement sql;
	JTextField t1, t2, t3, t4, t5, t6;
	JButton b1, b2;
	Box baseBox, bv1, bv2;
	int flag = 0;

	public StudentDelete() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university?characterEncoding=utf8", "root",
					"123456");
			sql = con.createStatement();
		} catch (SQLException ee) {
		}
		setLayout(new BorderLayout());
		b1 = new JButton("删除");
	//	b2 = new JButton("删除");
		b1.setBackground(Color.CYAN);
		b1.addActionListener(this);
	//	b2.setBackground(Color.RED);
		//b2.addActionListener(this);

		t1 = new JTextField(8);
		t2 = new JTextField(16);
		t3 = new JTextField(16);
		t4 = new JTextField(16);
		t5 = new JTextField(16);
		t6 = new JTextField(16);

		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();

		p1.add(new JLabel("请删除不在范围内学生的学号："));
		p1.add(t1);
		p1.add(b1);

		bv1 = Box.createVerticalBox();
		bv1.add(new JLabel("姓名"));
		bv1.add(Box.createVerticalStrut(8));
		bv1.add(new JLabel("性别"));
		bv1.add(Box.createVerticalStrut(8));
		bv1.add(new JLabel("本属地址"));
		bv1.add(Box.createVerticalStrut(8));
		bv1.add(new JLabel("电话"));
		bv1.add(Box.createVerticalStrut(8));
		bv1.add(new JLabel("目前所在地区"));
		bv1.add(Box.createVerticalStrut(8));

		bv2 = Box.createVerticalBox();
		bv2.add(t2);
		bv2.add(Box.createVerticalStrut(8));
		bv2.add(t3);
		bv2.add(Box.createVerticalStrut(8));
		bv2.add(t4);
		bv2.add(Box.createVerticalStrut(8));
		bv2.add(t5);
		bv2.add(Box.createVerticalStrut(8));
		bv2.add(t6);
		bv2.add(Box.createVerticalStrut(8));

		baseBox = Box.createHorizontalBox();
		baseBox.add(bv1);
		baseBox.add(Box.createHorizontalStrut(10));
		baseBox.add(bv2);

		p2.add(baseBox);

		add(p1, "North");
		add(p2, "Center");
	//	add(b2, "South");

		setSize(350, 300);
		setBackground(Color.white);

	}

	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == b1) {
			try {
				delete();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	

	public void delete() throws SQLException {
		String num, name, gender, address, phone, major;
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university?characterEncoding=utf8", "root",
				"123456");
		num = t1.getText().trim();
		ResultSet rs = sql.executeQuery("SELECT* FROM student WHERE id = '" + num + "'");

		if (rs.next()) {
			name = rs.getString("name");
			gender = rs.getString("gender");
			address = rs.getString("address");
			phone = rs.getString("phone");
			major = rs.getString("major");
			t2.setText(name);
			t3.setText(gender);
			t4.setText(address);
			t5.setText(phone);
			t6.setText(major);
			flag = 1;
			num = "'" + t1.getText().trim() + "'";
			String s1 = "DELETE FROM student WHERE ID=" + num;
			sql.executeUpdate(s1);
			int n = JOptionPane.showConfirmDialog(this, "确定删除？", "确定", JOptionPane.YES_NO_OPTION);// i=0/1
			if (n == 0) {
				JOptionPane.showMessageDialog(this, "删除成功!", "提示对话框", JOptionPane.INFORMATION_MESSAGE);
			}
			con.close();

		} else {
			JOptionPane.showMessageDialog(this, "没有该学生!", "提示对话框", JOptionPane.INFORMATION_MESSAGE);
		}
		con.close();
		if (flag == 0) {
			t1.setText("没有该学生");
		}
	}
}
