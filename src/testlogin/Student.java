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
 * ���࣬ʵ�ֱ��Ŀ��ӻ������Լ������ݿ������ɾ�Ĳ����
 */
public class Student extends JFrame implements ActionListener 
{//�̳�JFrame�ಢʵ��ActionListener�ӿ�
    //��������������
	JTable jt = null;
	JScrollPane jsp = null;
	JPanel jp1 ,jp2,jp3;//���
	JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9;//�ĸ���ť
	JLabel jl1,jl2,jl3,jl4;//��ǩ���ṩ��ʾ��Ϣ
	JTextField jtf1,jtf2,jtf3;//�ı���
	Table_Model tm;//����ģ�Ͷ��󣬸���table��
	  //TableModel��JTable��ģ��.
//	�൱������.
//	һ��洢���ݶ���TableModelȥ�洢.
//	�����,�ŵ�JTable��ȥ�Ϳ�����.����
//	JTable jb = new JTable ();
//	TableModel tm = new TableModel();
//	jb.setModel(tm); 

	
//	
//		public static void main(String[] args) 
//	{
//		Student s1 = new Student();
//	}
	
	//����student�ĺ�����������,��������
	public Student() {
		
		
//�ϲ�
		jp1 = new JPanel();
		jtf1 = new JTextField(7);
		jtf2 = new JTextField(7);
		jtf3 = new JTextField(7);
		jb1 = new JButton("��ѯ");
		jb8 = new JButton("��ѯ");
		jb5 = new JButton("��Ʊ");
		jb6 = new JButton("��Ʊ");
		//ע��jb1�ļ����������ǰѵ�ǰ�������button1��Listener;
		//��ô�Ϳ����ڵ�ǰ��������ӷ�������Ӧbutton1�ĵ��,����:
			//void actionPerformed(ActionEvent e)
			//{
			//��Ӧbutton1�ĵ���Ĵ���;
			//}
		jb1.addActionListener(this);
		jb8.addActionListener(this);
		
		jl1 = new JLabel("�����������");
		jl2 = new JLabel("Ŀ�ĵ�");
		jl3 = new JLabel("     ");
		jl4 = new JLabel("�����복��");
		
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
		
//�²�
		

		jp2 = new JPanel();
		jl3 = new JLabel("����Ա����");
		jb9 = new JButton("�鿴������Ϣ");
	//	jb5 = new JButton("��Ʊ����");
		//jb6 = new JButton("��Ʊ����");
		jb2 = new JButton("���");
		jb3 = new JButton("�޸�");
		jb4 = new JButton("ɾ��");
		jb7 = new JButton("�鿴�û�������Ϣ");

//		jb2.setBackground(Color.white); 
//		jb3.setBackground(Color.white); 
//		jb4.setBackground(Color.white);
//		jb7.setBackground(Color.white);// ������ɫ
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

		
//�в�
		
		 //* ����һ������ģ�Ͷ��󣬸���table
		Table_Model tm = new Table_Model();
		
		//��ʼ��jtable
		jt = new JTable(tm);
		
		//��ʼ��JScrollBar�����ù����������
		jsp = new JScrollPane(jt);
		jsp.getHorizontalScrollBar();
		
		//����
		this.add(jsp);
		this.add(jp1,"North");
		//this.add(jp3,"Left");
		this.add(jp2,"South");
		this.setSize(900, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("��;������Ϣ����ϵͳ(321��΢�ܣ�PIKA_TANG��)");
		this.setLocationRelativeTo(null);	
		
	}
	//����
		public void actionPerformed(ActionEvent e) 
		{
			
			//�жϵ���İ�ť
			
//			//��Ʊ
			if(e.getSource() ==jb5) {
				
					int rownum =this.jt.getSelectedRow();
					if(rownum == -1) {
						JOptionPane.showMessageDialog(this, "��ѡ��Ҫ����ĳ���");
						return;
					}
					else {
						 //��ʾ�޸ĶԻ���
					   Table_Buy ta = new Table_Buy(this,"��Ʊҳ��",true,rownum);
					//	Table_Update tu= new Table_Update(this,"�޸��г���Ϣ",true,rownum);
					}
					Table_Model tm = new Table_Model();
					jt.setModel(tm);
					
			}      
			
//			else {
//				 //��ʾ�޸ĶԻ���
//			     Table_Update tu= new Table_Update(this,"�޸��г���Ϣ",true,rownum);
//			}
//			Table_Model tm = new Table_Model();
//			jt.setModel(tm);
//		}
//			
			
			//��Ʊ
			else if(e.getSource() ==jb6) {
				
				int rownum =this.jt.getSelectedRow();
				if(rownum == -1) {
					JOptionPane.showMessageDialog(this, "��ѡ��Ҫ��Ʊ�ĳ���");
					return;
				}
				else {
					 //��ʾ�޸ĶԻ���
				   Table_Delete td = new Table_Delete(this,"��Ʊҳ��",true,rownum);
				//	Table_Update tu= new Table_Update(this,"�޸��г���Ϣ",true,rownum);
				}
				Table_Model tm = new Table_Model();
				jt.setModel(tm);
				
		}      
			
			
			//1����ѯ
			else if(e.getSource() == jb1)  //ʹ��getsource����ʱ��Ҫ��֤��д��actionPerformed�������������İ�ť��ͬһ������
			{//��������ʱ���ǲ���jb1,��jb1��û�б����
				//��ȡjtf1����Ϣ����ȡjtf2����Ϣ
				String start = this.jtf1.getText().trim() ;
				String endd = this.jtf2.getText().trim() ;
				//��һ��sql���
				String sql = "select * from train where start = '"+start+"'and endd = '"+endd+"'";
				//�����µ�����ģ�͡�������
				Table_Model tm = new Table_Model(sql);
				//����ѯ������Ϣд��jtable��
				jt.setModel(tm);
				System.out.println("��ѯ�ɹ�");
				
				
			}
			   //��ѯ2
			else if(e.getSource() == jb8)  //ʹ��getsource����ʱ��Ҫ��֤��д��actionPerformed�������������İ�ť��ͬһ������
			{//��������ʱ���ǲ���jb1,��jb1��û�б����
				//��ȡjtf1����Ϣ����ȡjtf2����Ϣ
				String id = this.jtf3.getText().trim() ;
				
				//��һ��sql���
				String sql = "select * from train where id = '"+id+"'";
				//�����µ�����ģ�͡�������
				Table_Model tm = new Table_Model(sql);
				//����ѯ������Ϣд��jtable��
				jt.setModel(tm);
				System.out.println("��ѯ�ɹ�");
				
				
			}
			//2�����
			else if(e.getSource() == jb2) 
			{
				Table_add ta = new Table_add(this,"��ӳ���",true);//Table_add��
				Table_Model tm = new Table_Model();
				jt.setModel(tm);
				
			}
			//3���޸�
			else if(e.getSource()==jb3) 
			{
				int rownum =this.jt.getSelectedRow();
				if(rownum==-1)
				{
				//��ʾ
				JOptionPane.showMessageDialog(this,"��ѡ��һ��");
				return;
				}
				else {
					 //��ʾ�޸ĶԻ���
				     Table_Update tu= new Table_Update(this,"�޸��г���Ϣ",true,rownum);
				}
				Table_Model tm = new Table_Model();
				jt.setModel(tm);
			}
			
	        //4��ɾ��
			else if(e.getSource() == jb4)
			{
				int rownum =this.jt.getSelectedRow();
				if(rownum == -1) {
					JOptionPane.showMessageDialog(this, "��ѡ��һ��");
					return;
				}
				
				else {
					Table_Model tm = new Table_Model();
					
					//��ȡ����id
					String id = (String) tm.getValueAt(rownum, 0);
					System.out.println("ɾ������Ϊ"+id+"�ĳ���");
					
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
					//ˢ�±��
					 tm = new Table_Model();
					 jt.setModel(tm);
				
				}
				
			}
		//  }5.�鿴�û������¼
			else if(e.getSource() == jb7) 
			{   
			
				Table_Display td = new Table_Display();//
				td.setTitle("�û������ѯ����");
			    Table_Model tm = new Table_Model();
				jt.setModel(tm);
				
			}
			
			else if(e.getSource() == jb9) 
			{         
			
				Table_Display2 td2 = new Table_Display2();//
				td2.setTitle("��;������Ϣ��ѯ");
			    Table_Model tm = new Table_Model();
				jt.setModel(tm);
				
			}
		}}
//private static final String URL = "jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
