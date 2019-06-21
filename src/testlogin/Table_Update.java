package testlogin;
/*
 * 修改学生信息页面
 */

/*
 * public class Table_Update {
 * 
 * }
 */
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class Table_Update extends JDialog implements ActionListener {
	//定义我需要的swing组件
    JLabel jl1, jl2,jl3, jl4, jl5 ,jl6,jl7,jl8;
    JButton jb1,jb2;
    JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7,jtf8;
    JPanel jp1,jp2,jp3;
    //将table对象作为变量传过来
	Table_Model tm = new Table_Model();

	//构造函数 Frame代表父窗口口,title代表窗口的名字,model指定是模式窗口,还是非模式的窗口，rownum代表行号
	public Table_Update(Frame owner,String title,boolean model,int rownum) {
		
		super(owner,title, model); 
		jl1=new JLabel("车次");
		jl2=new JLabel("出发地");
		jl3=new JLabel("目的地");
		
		jl4=new JLabel("日期");
		jl5=new JLabel("时间");
		jl6=new JLabel("管理员");
		jl7=new JLabel("票价");
		jl8=new JLabel("余量");
		
		jtf1=new JTextField();
		jtf2=new JTextField();
		jtf3=new JTextField();
		jtf4=new JTextField();
		jtf5=new JTextField();
		jtf6=new JTextField();
		jtf7=new JTextField();
		jtf8=new JTextField();
		//初始化数据
		jtf1.setText((String)tm.getValueAt(rownum,0).toString());
		//setEditable设置指定的 boolean 变量，以指示此 文本控件 是否应该为可编辑的
		jtf1.setEditable(false);
		//jtf1.setText((String)tm.getValueAt(rownum,0));
		jtf2.setText((String)tm.getValueAt(rownum,1));
		jtf3.setText((String)tm.getValueAt(rownum,2));
		jtf4.setText((String)tm.getValueAt(rownum,3));
		jtf5.setText((String)tm.getValueAt(rownum,4));
		jtf6.setText((String)tm.getValueAt(rownum,5));
		jtf7.setText((String)tm.getValueAt(rownum,6));
		jtf8.setText((String)tm.getValueAt(rownum,7));
		jb1=new JButton ("修改");
		jb2=new JButton ("取消");
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		//设置布局
		jp1.setLayout(new GridLayout(8,1,3,0));
		jp2.setLayout(new GridLayout(8,13,3,0));
		//添加组件
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jl4);
		jp1.add(jl5);
		jp1.add(jl6);
		jp1.add(jl7);
		jp1.add(jl8);
		jp2.add(jtf1);
		jp2.add(jtf2);
		jp2.add(jtf3);
		jp2.add(jtf4);
		jp2.add(jtf5);
		jp2.add(jtf6);
		jp2.add(jtf7);
		jp2.add(jtf8);
		jp3.add(jb1);
		jp3.add(jb2);
		this.add(jp1,BorderLayout.WEST);
		this.add(jp2,BorderLayout.CENTER);
		this.add(jp3,BorderLayout.SOUTH);
		
		//注册监听
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		//展现
		this.setSize(300,600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb1){
			//连接数据库所需变量
			Connection ct = null;
			Statement stm = null;
			
			PreparedStatement ps = null;
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/bus_db?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false",
												"root",
												"123456");
				//传入SQL语句
				ps=ct.prepareStatement("update train set start=?,endd=?,data=?,time=?,respond=?,price=?,remine=? where id = ?;");

				//获取数据在文本框中显示
				ps.setString(1, this.jtf2.getText());
				ps.setString(2, this.jtf3.getText());
				ps.setString(3, this.jtf4.getText());
				ps.setString(4, this.jtf5.getText());
				ps.setString(5, this.jtf6.getText());
				ps.setString(6, this.jtf7.getText());
				ps.setString(7, this.jtf8.getText());
				ps.setString(8, this.jtf1.getText());
				ps.executeUpdate();
				
				
				int i=ps.executeUpdate();
				if(i==1){
				System.out.println("修改成功");
				}
				else{
				System.out.print("修改失败");
				}
				
				
			}
			catch(Exception e3) {
				e3.printStackTrace();
			}
			finally {
				try {
					ps.close();
					ct.close();
					} 
				catch (SQLException e4) {
					e4.printStackTrace();
					}
			}
			this.dispose();
		}
		else if(e.getSource() == jb2)
		{
		dispose();
		}
	}
	
}

