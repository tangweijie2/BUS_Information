package testlogin;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class Table_Buy extends JDialog implements ActionListener {
	//定义我需要的swing组件
    JLabel jl1, jl2,jl3,jl4,jl5;
    JButton jb1,jb2;
    JTextField jtf1,jtf2,jtf3,jtf4,jtf5;
    JPanel jp1,jp2,jp3;
    Table_Model tm = new Table_Model();
       
public Table_Buy(Frame owner,String title,boolean model,int rownum) {
		
		super(owner,title, model); 
		jl1=new JLabel("身份证号");
		jl2=new JLabel("姓名");
		jl3=new JLabel("购买车次");
		jl4=new JLabel("出发地");
		jl5=new JLabel("目的地");
		
		
		
		jtf1=new JTextField();
		jtf2=new JTextField();
		jtf3=new JTextField();
		jtf4=new JTextField();
		jtf5=new JTextField();
		
		//初始化数据
		jtf3.setText((String)tm.getValueAt(rownum,0).toString());
		//setEditable设置指定的 boolean 变量，以指示此 文本控件 是否应该为可编辑的
		jtf3.setEditable(false);//购买车次点击默认呈现，不能编辑
		
		jb1=new JButton ("购买");
		jb2=new JButton ("取消");
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		//设置布局
		jp1.setLayout(new GridLayout(5,1,3,0));
		jp2.setLayout(new GridLayout(5,13,3,0));
		//添加组件
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jl4);
		jp1.add(jl5);
		
		
		
		jp2.add(jtf1);
		jp2.add(jtf2);
		jp2.add(jtf3);
		jp2.add(jtf4);
		jp2.add(jtf5);
		
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
			PreparedStatement ps2 = null;
			
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/bus_db?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false",
												"root", 
												"123456");
				//传入SQL语句
				ps=ct.prepareStatement("insert into users values(?,?,?,?,?);");
				//ps2=ct.prepareStatement("update train set remine=remine-1 where id =1231;");//where name='百度知道团长';
				ps.setString(1, this.jtf1.getText().trim());
				ps.setString(2, this.jtf2.getText().trim());
				ps.setString(3, this.jtf3.getText().trim());
				ps.setString(4, this.jtf4.getText().trim());
				ps.setString(5, this.jtf5.getText().trim());
				
				ps.executeUpdate();
		        
				ps2=ct.prepareStatement("update train set remine=remine-1 where id =?;");//where name='百度知道团长';
				ps2.setString(1, this.jtf3.getText().trim());//占位符，代表id=?
				
				//ps2.executeUpdate();
		//}
				
				int i=ps2.executeUpdate();
//		int i = ps.executeUpdate();
				if(i != 0) {
					
					System.out.println("购票成功");				
				}
				else {
				
					System.out.println("购票失败");		
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

				


