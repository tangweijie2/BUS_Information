package testlogin;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.*;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/*
 * �������ģ��
 */

//import com.sun.jdi.connect.spi.Connection;
/*
 * public class Table_add {
 * 
 * }
 */
/*
 * �������ģ��
 */

public class Table_add extends JDialog implements ActionListener{//�̳�AWT��Dialog�����
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9;
	JButton jb1,jb2;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7,jtf8,jtf9;
	JPanel jp1,jp2,jp3;
	
	//���캯��������һ�������Ϣҳ��//Frame �����ڣ�title�������֣�ָ��ģʽ���ģʽ
	
	public Table_add(Frame owner,String title,boolean modal) {
		
		super(owner,title,modal);
		
		jl1 = new JLabel("����");
		jl2 = new JLabel("������");
		jl3 = new JLabel("Ŀ�ĵ�");
		jl4 = new JLabel("����");
		jl5 = new JLabel("ʱ��");
		
		jl6 = new JLabel("����Ա");
		jl7 = new JLabel("Ʊ��");
		jl8 = new JLabel("����");
		jl9 = new JLabel("��ʻʱ��");
		
		jtf1 = new JTextField();
		jtf2 = new JTextField();
		jtf3 = new JTextField();
		jtf4 = new JTextField();
		jtf5 = new JTextField();
		jtf6 = new JTextField();
		jtf7 = new JTextField();
		jtf8 = new JTextField();
		jtf9 = new JTextField();
		
		jb1 = new JButton("���");
		jb2 = new JButton("ȡ��");
		
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		
		
		//���ò���,������
		jp1.setLayout(new GridLayout(9, 1));//��1������
		jp2.setLayout(new GridLayout(9, 1));
		
		jp1.add(jl1);//��һ�������6����ǩ����
		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jl4);
		jp1.add(jl5);
		jp1.add(jl6);
		jp1.add(jl7);
		jp1.add(jl8);
		jp1.add(jl9);
		
		jp2.add(jtf1);//�ڶ��������6�����������
		jp2.add(jtf2);
		jp2.add(jtf3);
		jp2.add(jtf4);
		jp2.add(jtf5);
		jp2.add(jtf6);
		jp2.add(jtf7);
		jp2.add(jtf8);
		jp2.add(jtf9);
		
		
		jp3.add(jb1);//��3�������������ť����
		jp3.add(jb2);
		
		
		this.add(jp1,BorderLayout.WEST);//��
		this.add(jp2,BorderLayout.CENTER);//����
		this.add(jp3, BorderLayout.SOUTH);//����
		
		jb1.addActionListener(this);
		
		this.setSize(300, 500);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		
	}

	
   public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jb1) {
			
			//�������ݿ��������
			java.sql.Connection ct = null;
			Statement stm = null;
			ResultSet rs = null;
			PreparedStatement ps = null;
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/bus_db?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false",
												"root",
												"123456");
				ps =  ct.prepareStatement("insert into train values(?,?,?,?,?,?,?,?,?);");
				
				//��ȡ����
				ps.setInt(1, Integer.parseInt(this.jtf1.getText().trim()));
				//ps.setString(1, this.jtf1.getText().trim());
				ps.setString(2, this.jtf2.getText().trim());
				ps.setString(3, this.jtf3.getText().trim());
				ps.setString(4, this.jtf4.getText().trim());
				ps.setString(5, this.jtf5.getText().trim());
				ps.setString(6, this.jtf6.getText().trim());
				ps.setString(7, this.jtf7.getText().trim());
				ps.setString(8, this.jtf8.getText().trim());
				ps.setString(9, this.jtf9.getText().trim());
				
				int i = ps.executeUpdate();
				if(i != 0) {
					
					System.out.println("��ӳɹ�");				
				}
				else {
				
					System.out.println("���ʧ��");		
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
