package testlogin;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//public class Table_Delete {
//
//}
public class Table_Delete extends JDialog implements ActionListener {
	//定义我需要的swing组件
    JLabel jl1, jl2,jl3;
    JButton jb1,jb2;
    JTextField jtf1,jtf2,jtf3;
    JPanel jp1,jp2,jp3;
    Table_Model tm = new Table_Model();
       
public Table_Delete(Frame owner,String title,boolean model,int rownum) {
		
		super(owner,title, model); 
		jl1=new JLabel("身份证号");
		jl2=new JLabel("姓名");
		jl3=new JLabel("退票车次");
		
		
		
		jtf1=new JTextField();
		jtf2=new JTextField();
		jtf3=new JTextField();
		
		//初始化数据
		jtf3.setText((String)tm.getValueAt(rownum,0).toString());
		//setEditable设置指定的 boolean 变量，以指示此 文本控件 是否应该为可编辑的
		jtf3.setEditable(false);//购买车次点击默认呈现，不能编辑
		
		jb1=new JButton ("退票");
		jb2=new JButton ("取消");
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		//设置布局
		jp1.setLayout(new GridLayout(3,1,3,0));
		jp2.setLayout(new GridLayout(3,13,3,0));
		//添加组件
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		
		jp2.add(jtf1);
		jp2.add(jtf2);
		jp2.add(jtf3);
		
		jp3.add(jb1);
		jp3.add(jb2);
		
		
		this.add(jp1,BorderLayout.WEST);
		this.add(jp2,BorderLayout.CENTER);
		this.add(jp3,BorderLayout.SOUTH);
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		//展现
		this.setSize(300,300);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
}


	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb1){
			//连接数据库所需变量
			Connection ct = null;
			Statement stm = null;
			ResultSet rs = null;
			
			PreparedStatement ps = null;
			PreparedStatement ps2 = null;//		PreparedStatement ps2 = null;
//			
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/bus_db?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false",
												"root",
												"123456");
				//传入SQL语句
				ps=ct.prepareStatement("delete from users where id=?;");
				ps.setString(1, this.jtf1.getText().trim());//占位符，代表id=?
				ps2=ct.prepareStatement("update train set remine=remine+1 where id =?;");//where name='百度知道团长';
				ps2.setString(1, this.jtf3.getText().trim());//占位符，代表id=?
				
				ps.executeUpdate();
//		        
//				ps2=ct.prepareStatement("update train set remine=remine-1 where id =?;");//where name='百度知道团长';
//				ps2.setString(1, this.jtf3.getText().trim());//占位符，代表id=?
//				
				//ps2.executeUpdate();
//		//}
				int i=ps2.executeUpdate();
		//int i = ps.executeUpdate();
				if(i != 0) {
					
					System.out.println("退票成功");				
				}
				else {
				
					System.out.println("退票失败");		
				}
			}
			catch(Exception e2) {
				e2.printStackTrace();
				
			}
			finally {
				
				try {
					ct.close();
					ps.close();
				}
				catch (Exception e2) {
					
					e2.printStackTrace();
				}
			}
			this.dispose();	
		
		}
		
		else if(e.getSource() == jb2) {
			dispose();
		}
    }
	
}

				


