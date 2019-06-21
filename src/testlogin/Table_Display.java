package testlogin;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class Table_Display extends JFrame  {//�̳�JFrame�ࣨJFrame��ͨ�������
	 Vector rowData,columnNames;
	 //rowDataΪ������ݣ�columnΪ����ͷ 
	    
	    JTable jt=null;  //ע����
	    JScrollPane jsp=null; //ע��������
	    
	    PreparedStatement ps=null;  //���ݿ�����ӿڶ���
	    Connection ct=null;  //��Ҫ�����������ݿ�
	    ResultSet rs=null;  //����ѯ���ݿ�ʱ�����ص���һ����ά�Ľ������������Ҫ�õ�ResultSet���������������ȡÿһ�е�����
	    //�������ݿ��������  
	    
	    public  Table_Display(){  //���캯��
	    	
	        columnNames=new Vector();  
	        //��������  
	        columnNames.add("���֤��");  
	        columnNames.add("����");  
	        columnNames.add("���򳵴�");
	        columnNames.add("������");  
	        columnNames.add("Ŀ�ĵ�"); 
	        rowData = new Vector();  
            //rowData���Դ�Ŷ���,��ʼ�����ݿ���ȡ  
              
            try {  
                //��������  
            	
            	Class.forName("com.mysql.cj.jdbc.Driver");//Class.forName ���� com.mysql.jdbc.Driver ֮��,��֪�������ӵ����ݿ��� mysql
				ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/bus_db?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false",
												"root",
												"123456");
				ps =  ct.prepareStatement("select * from users;");
                //Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");  
                //�õ�����  
              //  ct=DriverManager.getConnection("jdbc:microsoft:sqlserver://127.0.0.1:1433;databaseName=spdb1","sa","sa");  
                  
              //  ps=ct.prepareStatement("select * from stu");  
                  
                rs=ps.executeQuery();  //executeQuery()����������ݿ���Ӧ�Ĳ�ѯ��������ResultSet������й�����ʹ��
                  
                while(rs.next()){  //.next()����������:ָ��ָ����һ����¼,�м�¼(��ֵ)����true���Ѽ�¼���ݴ��뵽��Ӧ�Ķ�����
                    //rowData���Դ�Ŷ���  
                    Vector hang=new Vector();  
                    hang.add(rs.getString(1));  
                    hang.add(rs.getString(2));  
                    hang.add(rs.getString(3)); 
                    hang.add(rs.getString(4));  
                    hang.add(rs.getString(5));  
                    rowData.add(hang);  
                }  
            } catch (Exception e) {  
                e.printStackTrace();  //�쳣�����ӡ
            } finally{  
                  
                    try {  
                        if(rs!=null){  
                        rs.close();  
                        }  
                        if(ps!=null){  
                            ps.close();  
                        }  
                        if(ct!=null){  
                            ct.close();  
                        }  
                    } catch (SQLException e) {  
                        e.printStackTrace();  
                    }  
            }  
              
                          
            //��ʼ��Jtable  
            jt = new JTable(rowData,columnNames);  
              
            //��ʼ�� jsp  
            jsp = new JScrollPane(jt);  
              
            //��jsp���뵽jframe  
            this.add(jsp);  
              
            this.setSize(500, 300);  
              
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //�Ӵ��ڹرգ�����������
          //  this.setDefaultCloseOption(JFrame.DISPOSE_ON_CLOSE);EXIT_ON_CLOSE
            this.setVisible(true);  
              
        }  





}