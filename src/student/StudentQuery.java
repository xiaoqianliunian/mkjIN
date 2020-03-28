package student;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
//query  查询
public class StudentQuery extends JPanel implements ActionListener{
	Connection con;
	Statement sql;
	JTextField t1,t2,t3,t4,t5,t6;
	JButton b;
	Box baseBox,bv1,bv2;
	int flag = 0;
	StudentQuery(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e){}
		try{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university?characterEncoding=utf8","root","123456");
			sql = con.createStatement();
		}
		catch(SQLException ee){}
		setLayout (new BorderLayout());
		b = new JButton("查询");
		b.setBackground(Color.orange);
		b.addActionListener(this);
		t1 = new JTextField(8);
		t2 = new JTextField(16);
		t3 = new JTextField(16);
		t4= new JTextField(16);
		t5 = new JTextField(16);
		t6 = new JTextField(16);
		t2.setEditable(false);
		t3.setEditable(false);
		t4.setEditable(false);
		t5.setEditable(false);
		t6.setEditable(false);
		JPanel p1= new JPanel(),p2 = new JPanel();
		p1.add(new JLabel("请输入学号："));
		p1.add(t1);
		p1.add(b);
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
		add(p1,"North");
		add(p2,"Center");
		setSize(350,300);
		setBackground(Color.white);
	}
	public void actionPerformed(ActionEvent e){
		flag = 0;
		try{query();}
		catch(SQLException ee){}
	}
	public void query() throws SQLException{
		String num,name,gender,address,phone,major;
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university?characterEncoding=utf8","root","123456");
		num = t1.getText().trim();
		ResultSet rs = sql.executeQuery("SELECT* FROM student WHERE id = '"+ num +"'");		
	
		if(rs.next()){
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
		}else{
			JOptionPane.showMessageDialog(this,"没有该学生!","提示对话框",JOptionPane.INFORMATION_MESSAGE);
		}
		con.close();
		if(flag == 0){t1.setText("没有该学生");}		
	}
}
