package student;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.JOptionPane;
public class StudentManagement extends JFrame implements ActionListener{
	JMenuBar bar = null;
	JMenu menu1,menu2,menu3,menu4,menu5;//    菜单栏
	JMenuItem item1,item2,item3,item4,item5;//  项目栏  
	StudentAdd zengjia;
	StudentQuery chaxun;
	StudentUpdate gengxin;  //.............................
	StudentDelete shanchu;  //.............................
	//JDBCTest ceshi;//...........................................自己添加
	 
	StudentManagement(){
		super("疫情学 生 信 息 管 理 ");
		zengjia = new StudentAdd();
		chaxun = new StudentQuery();
		gengxin = new StudentUpdate();  // ....................
		shanchu = new StudentDelete();   //.....................
		//ceshi = new JDBCTest();//             自己添加
		bar = new JMenuBar();
		menu1 = new JMenu("信息录入");
		menu2 = new JMenu("信息查询");
		menu3 = new JMenu("信息更新");
		menu4 = new JMenu("信息删除");
		menu5 = new JMenu("退出系统");
		item1 = new JMenuItem("录  入");
		item2 = new JMenuItem("查  询");
		item3 = new JMenuItem("更  新");
		item4 = new JMenuItem("删  除");
		item5 = new JMenuItem("退  出");
		menu1.add(item1);
		menu2.add(item2);
		menu3.add(item3);
		menu4.add(item4);
		menu5.add(item5);
		bar.add(menu1);
		bar.add(menu2);
		bar.add(menu3);
		bar.add(menu4);
		bar.add(menu5);
		setJMenuBar(bar);
		item1.addActionListener(this);
		item2.addActionListener(this);
		item3.addActionListener(this);
		item4.addActionListener(this);
		item5.addActionListener(this);
					
		JLabel label = new JLabel("疫情学生信息管理",JLabel.CENTER);
		label.setFont(new Font("疫情学生信息管理",0,35));
		String s = " ";
		Font f = new Font(s,Font.BOLD,60);
		label.setBackground(new Color(0,255,255));
		label.setForeground(new Color(255,128,255));
		add(label,"Center");
		setVisible(true);
		setSize(350,300);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == item1){
			this.getContentPane().removeAll();
			this.getContentPane().add(zengjia,"Center");
			this.getContentPane().repaint();
			this.getContentPane().validate();
			
		}
		if(e.getSource() == item2){
			this.getContentPane().removeAll();
			this.getContentPane().add(chaxun,"Center");
			this.getContentPane().repaint();
			this.getContentPane().validate();
			
		}
		
		
		if(e.getSource() == item3){
			this.getContentPane().removeAll();
			this.getContentPane().add(gengxin,"Center");
			this.getContentPane().repaint();
			this.getContentPane().validate();
			
		
	}
		if(e.getSource() == item4){
			this.getContentPane().removeAll();
			this.getContentPane().add(shanchu,"Center");
			this.getContentPane().repaint();
			this.getContentPane().validate();
			
}
	if(e.getSource() == item5){
		
		System.exit(0);
	}
	}
	public static void main(String args[]){
	StudentManagement stuM = new StudentManagement();
		stuM.setVisible(true);
		
		stuM.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
}

