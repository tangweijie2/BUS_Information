package testlogin;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
/*
 * public class Student {
 * 
 * }
 */
/*
 * 主类，实现表格的可视化界面以及对数据库进行增删改查操作
 */
public class Student extends JFrame implements ActionListener 
{//继承JFrame类并实现ActionListener接口
    //定义面板所需组件
	JTable jt = null;
	JScrollPane jsp = null;
	JPanel jp1 ,jp2,jp3;//面板
	JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9;//四个按钮
	JLabel jl1,jl2,jl3,jl4;//标签，提供提示信息
	JTextField jtf1,jtf2,jtf3;//文本框，
	Table_Model tm;//数据模型对象，更新table，
	  //TableModel是JTable的模型.
//	相当与替身.
//	一般存储数据都用TableModel去存储.
//	存好了,放到JTable里去就可以了.比如
//	JTable jb = new JTable ();
//	TableModel tm = new TableModel();
//	jb.setModel(tm); 

	
//	
//		public static void main(String[] args) 
//	{
//		Student s1 = new Student();
//	}
	
	//构造student的函数，主函数,程序的入口
	public Student() {
		
		
//上部
		jp1 = new JPanel();
		jtf1 = new JTextField(7);
		jtf2 = new JTextField(7);
		jtf3 = new JTextField(7);
		jb1 = new JButton("查询");
		jb8 = new JButton("查询");
		jb5 = new JButton("购票");
		jb6 = new JButton("退票");
		//注册jb1的监听器，就是把当前的类设成button1的Listener;
		//那么就可以在当前的类中添加方法以响应button1的点击,比如:
			//void actionPerformed(ActionEvent e)
			//{
			//响应button1的点击的代码;
			//}
		jb1.addActionListener(this);
		jb8.addActionListener(this);
		
		jl1 = new JLabel("请输入出发地");
		jl2 = new JLabel("目的地");
		jl3 = new JLabel("     ");
		jl4 = new JLabel("请输入车次");
		
		jb5.addActionListener(this);
		jb6.addActionListener(this);
		
		jp1.add(jl1);
		jp1.add(jtf1);
		jp1.add(jl2);
		
		jp1.add(jtf2);
		jp1.add(jb1);
		jp1.add(jl3);
//		jp1.add(jl4);
//		jp1.add(jtf3);
		
//		jp1.add(jb8);
		
		jp1.add(jb5);
		jp1.add(jb6);
		
//下部
		

		jp2 = new JPanel();
		jl3 = new JLabel("管理员操作");
		jb9 = new JButton("查看车辆信息");
	//	jb5 = new JButton("购票操作");
		//jb6 = new JButton("退票操作");
		jb2 = new JButton("添加");
		jb3 = new JButton("修改");
		jb4 = new JButton("删除");
		jb7 = new JButton("查看用户购买信息");

//		jb2.setBackground(Color.white); 
//		jb3.setBackground(Color.white); 
//		jb4.setBackground(Color.white);
//		jb7.setBackground(Color.white);// 设置颜色
		//jb2.setContentAreaFilled(false);
		//jb3.setContentAreaFilled(false);
		//jb4.setContentAreaFilled(false);
		 //jb5.setIcon(new ImageIcon(getClass().getResource("qq.png")));
			
		
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
//		jb5.addActionListener(this);
	//	jb6.addActionListener(this);
		jb7.addActionListener(this);
		jb9.addActionListener(this);
        
//      jp2.add(jl3);
//        jp2.add(jb5);
//        jp2.add(jb6);
        jp2.add(jb9);
  //  jp2.add(jl3);
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		jp2.add(jb7);

		
//中部
		
		 //* 创建一个数据模型对象，更新table
		Table_Model tm = new Table_Model();
		
		//初始化jtable
		jt = new JTable(tm);
		
		//初始化JScrollBar，利用滚轴滚动窗口
		jsp = new JScrollPane(jt);
		jsp.getHorizontalScrollBar();
		
		//设置
		this.add(jsp);
		this.add(jp1,"North");
		//this.add(jp3,"Left");
		this.add(jp2,"South");
		this.setSize(900, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("长途汽车信息管理系统(321汤微杰（PIKA_TANG）)");
		this.setLocationRelativeTo(null);	
		
	}
	//监听
		public void actionPerformed(ActionEvent e) 
		{
			
			//判断点击的按钮
			
//			//购票
			if(e.getSource() ==jb5) {
				
					int rownum =this.jt.getSelectedRow();
					if(rownum == -1) {
						JOptionPane.showMessageDialog(this, "请选择要购买的车次");
						return;
					}
					else {
						 //显示修改对话框
					   Table_Buy ta = new Table_Buy(this,"购票页面",true,rownum);
					//	Table_Update tu= new Table_Update(this,"修改列车信息",true,rownum);
					}
					Table_Model tm = new Table_Model();
					jt.setModel(tm);
					
			}      
			
//			else {
//				 //显示修改对话框
//			     Table_Update tu= new Table_Update(this,"修改列车信息",true,rownum);
//			}
//			Table_Model tm = new Table_Model();
//			jt.setModel(tm);
//		}
//			
			
			//退票
			else if(e.getSource() ==jb6) {
				
				int rownum =this.jt.getSelectedRow();
				if(rownum == -1) {
					JOptionPane.showMessageDialog(this, "请选择要退票的车次");
					return;
				}
				else {
					 //显示修改对话框
				   Table_Delete td = new Table_Delete(this,"退票页面",true,rownum);
				//	Table_Update tu= new Table_Update(this,"修改列车信息",true,rownum);
				}
				Table_Model tm = new Table_Model();
				jt.setModel(tm);
				
		}      
			
			
			//1、查询
			else if(e.getSource() == jb1)  //使用getsource方法时，要保证复写的actionPerformed方法与所监听的按钮在同一个类中
			{//表明发起时间是不是jb1,即jb1有没有被点击
				//获取jtf1的信息，获取jtf2的信息
				String start = this.jtf1.getText().trim() ;
				String endd = this.jtf2.getText().trim() ;
				//给一个sql语句
				String sql = "select * from train where start = '"+start+"'and endd = '"+endd+"'";
				//构建新的数据模型。并更新
				Table_Model tm = new Table_Model(sql);
				//将查询到的信息写到jtable中
				jt.setModel(tm);
				System.out.println("查询成功");
				
				
			}
			   //查询2
			else if(e.getSource() == jb8)  //使用getsource方法时，要保证复写的actionPerformed方法与所监听的按钮在同一个类中
			{//表明发起时间是不是jb1,即jb1有没有被点击
				//获取jtf1的信息，获取jtf2的信息
				String id = this.jtf3.getText().trim() ;
				
				//给一个sql语句
				String sql = "select * from train where id = '"+id+"'";
				//构建新的数据模型。并更新
				Table_Model tm = new Table_Model(sql);
				//将查询到的信息写到jtable中
				jt.setModel(tm);
				System.out.println("查询成功");
				
				
			}
			//2、添加
			else if(e.getSource() == jb2) 
			{
				Table_add ta = new Table_add(this,"添加车次",true);//Table_add类
				Table_Model tm = new Table_Model();
				jt.setModel(tm);
				
			}
			//3、修改
			else if(e.getSource()==jb3) 
			{
				int rownum =this.jt.getSelectedRow();
				if(rownum==-1)
				{
				//提示
				JOptionPane.showMessageDialog(this,"请选择一行");
				return;
				}
				else {
					 //显示修改对话框
				     Table_Update tu= new Table_Update(this,"修改列车信息",true,rownum);
				}
				Table_Model tm = new Table_Model();
				jt.setModel(tm);
			}
			
	        //4、删除
			else if(e.getSource() == jb4)
			{
				int rownum =this.jt.getSelectedRow();
				if(rownum == -1) {
					JOptionPane.showMessageDialog(this, "请选择一行");
					return;
				}
				
				else {
					Table_Model tm = new Table_Model();
					
					//获取车次id
					String id = (String) tm.getValueAt(rownum, 0);
					System.out.println("删除车次为"+id+"的车次");
					
					PreparedStatement ps = null;
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/bus_db?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false",
																	"root",
																	"123456");
						ps=  ct.prepareStatement("delete from train where id = ?;");
						ps.setString(1, id);
						ps.executeUpdate();
					}
					catch(Exception e4) {
						e4.printStackTrace();
					}
					//刷新表格
					 tm = new Table_Model();
					 jt.setModel(tm);
				
				}
				
			}
		//  }5.查看用户购买记录
			else if(e.getSource() == jb7) 
			{   
			
				Table_Display td = new Table_Display();//
				td.setTitle("用户购买查询界面");
			    Table_Model tm = new Table_Model();
				jt.setModel(tm);
				
			}
			
			else if(e.getSource() == jb9) 
			{         
			
				Table_Display2 td2 = new Table_Display2();//
				td2.setTitle("长途汽车信息查询");
			    Table_Model tm = new Table_Model();
				jt.setModel(tm);
				
			}
		}}
//private static final String URL = "jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
