package testlogin;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class Table_Buy extends JDialog implements ActionListener {
	//��������Ҫ��swing���
    JLabel jl1, jl2,jl3,jl4,jl5;
    JButton jb1,jb2;
    JTextField jtf1,jtf2,jtf3,jtf4,jtf5;
    JPanel jp1,jp2,jp3;
    Table_Model tm = new Table_Model();
       
public Table_Buy(Frame owner,String title,boolean model,int rownum) {
		
		super(owner,title, model); 
		jl1=new JLabel("����֤��");
		jl2=new JLabel("����");
		jl3=new JLabel("���򳵴�");
		jl4=new JLabel("������");
		jl5=new JLabel("Ŀ�ĵ�");
		
		
		
		jtf1=new JTextField();
		jtf2=new JTextField();
		jtf3=new JTextField();
		jtf4=new JTextField();
		jtf5=new JTextField();
		
		//��ʼ������
		jtf3.setText((String)tm.getValueAt(rownum,0).toString());
		//setEditable����ָ���� boolean ��������ָʾ�� �ı��ؼ� �Ƿ�Ӧ��Ϊ�ɱ༭��
		jtf3.setEditable(false);//���򳵴ε��Ĭ�ϳ��֣����ܱ༭
		
		jb1=new JButton ("����");
		jb2=new JButton ("ȡ��");
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		//���ò���
		jp1.setLayout(new GridLayout(5,1,3,0));
		jp2.setLayout(new GridLayout(5,13,3,0));
		//�������
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
		//չ��
		this.setSize(300,300);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
}


	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb1){
			//�������ݿ��������
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
				//����SQL���
				ps=ct.prepareStatement("insert into users values(?,?,?,?,?);");
				//ps2=ct.prepareStatement("update train set remine=remine-1 where id =1231;");//where name='�ٶ�֪���ų�';
				ps.setString(1, this.jtf1.getText().trim());
				ps.setString(2, this.jtf2.getText().trim());
				ps.setString(3, this.jtf3.getText().trim());
				ps.setString(4, this.jtf4.getText().trim());
				ps.setString(5, this.jtf5.getText().trim());
				
				ps.executeUpdate();
		        
				ps2=ct.prepareStatement("update train set remine=remine-1 where id =?;");//where name='�ٶ�֪���ų�';
				ps2.setString(1, this.jtf3.getText().trim());//ռλ��������id=?
				
				//ps2.executeUpdate();
		//}
				
				int i=ps2.executeUpdate();
//		int i = ps.executeUpdate();
				if(i != 0) {
					
					System.out.println("��Ʊ�ɹ�");				
				}
				else {
				
					System.out.println("��Ʊʧ��");		
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

				

