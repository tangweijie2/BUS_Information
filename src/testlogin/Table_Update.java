package testlogin;
/*
 * �޸�ѧ����Ϣҳ��
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
	//��������Ҫ��swing���
    JLabel jl1, jl2,jl3, jl4, jl5 ,jl6,jl7,jl8;
    JButton jb1,jb2;
    JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7,jtf8;
    JPanel jp1,jp2,jp3;
    //��table������Ϊ����������
	Table_Model tm = new Table_Model();

	//���캯�� Frame�������ڿ�,title�����ڵ�����,modelָ����ģʽ����,���Ƿ�ģʽ�Ĵ��ڣ�rownum�����к�
	public Table_Update(Frame owner,String title,boolean model,int rownum) {
		
		super(owner,title, model); 
		jl1=new JLabel("����");
		jl2=new JLabel("������");
		jl3=new JLabel("Ŀ�ĵ�");
		
		jl4=new JLabel("����");
		jl5=new JLabel("ʱ��");
		jl6=new JLabel("����Ա");
		jl7=new JLabel("Ʊ��");
		jl8=new JLabel("����");
		
		jtf1=new JTextField();
		jtf2=new JTextField();
		jtf3=new JTextField();
		jtf4=new JTextField();
		jtf5=new JTextField();
		jtf6=new JTextField();
		jtf7=new JTextField();
		jtf8=new JTextField();
		//��ʼ������
		jtf1.setText((String)tm.getValueAt(rownum,0).toString());
		//setEditable����ָ���� boolean ��������ָʾ�� �ı��ؼ� �Ƿ�Ӧ��Ϊ�ɱ༭��
		jtf1.setEditable(false);
		//jtf1.setText((String)tm.getValueAt(rownum,0));
		jtf2.setText((String)tm.getValueAt(rownum,1));
		jtf3.setText((String)tm.getValueAt(rownum,2));
		jtf4.setText((String)tm.getValueAt(rownum,3));
		jtf5.setText((String)tm.getValueAt(rownum,4));
		jtf6.setText((String)tm.getValueAt(rownum,5));
		jtf7.setText((String)tm.getValueAt(rownum,6));
		jtf8.setText((String)tm.getValueAt(rownum,7));
		jb1=new JButton ("�޸�");
		jb2=new JButton ("ȡ��");
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		//���ò���
		jp1.setLayout(new GridLayout(8,1,3,0));
		jp2.setLayout(new GridLayout(8,13,3,0));
		//������
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
		
		//ע�����
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		//չ��
		this.setSize(300,600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb1){
			//�������ݿ��������
			Connection ct = null;
			Statement stm = null;
			
			PreparedStatement ps = null;
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/bus_db?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false",
												"root",
												"123456");
				//����SQL���
				ps=ct.prepareStatement("update train set start=?,endd=?,data=?,time=?,respond=?,price=?,remine=? where id = ?;");

				//��ȡ�������ı�������ʾ
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
				System.out.println("�޸ĳɹ�");
				}
				else{
				System.out.print("�޸�ʧ��");
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

