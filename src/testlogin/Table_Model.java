package testlogin;
/*
 * ����һ��tableģ�ͣ�ʵ�ֶԱ��ĸ���
 */
/*
 * public class Table_Model {
 * 
 * }
 */



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.table.*;

public class Table_Model extends AbstractTableModel {

	//roeData������ݣ�columnName�������
	Vector rowData,columnName;
	//����������ݿ�����ı���
	PreparedStatement ps =null;
	Connection ct = null;
	ResultSet rs = null;  //�������һ���洢��ѯ����Ķ��󣬵��ǽ���������������д洢�Ĺ��ܣ�
	                     //��ͬʱ�����в������ݵĹ��ܣ�������ɶ����ݵĸ���
	
	
	public void inint(String sql) {
		if(sql.equals("")) {
			sql = "select * from train;";
		}
			
		//��������
		columnName= new Vector();  
		columnName.add("����");
		columnName.add("������");
		columnName.add("Ŀ�ĵ�");
		columnName.add("����");
		columnName.add("ʱ��");
		
		columnName.add("����Ա");
		columnName.add("Ʊ��");
		columnName.add("����");
		columnName.add("��ʻʱ��");
		
		//��������
		rowData =new Vector();
		
		//�����ݿ⵼������
		try 
		{
			
			//����mysql����
			Class.forName("com.mysql.cj.jdbc.Driver");
			ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/bus_db?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false",
											"root",
											"123456");
			ps =  ct.prepareStatement(sql);
			rs = ps.executeQuery();
			
			
			while(rs.next())
			{
				//System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
				Vector data = new Vector();
				data.add(rs.getString(1));
				data.add(rs.getString(2));
				data.add(rs.getString(3));
				data.add(rs.getString(4));
				data.add(rs.getString(5));
				data.add(rs.getString(6));
				data.add(rs.getString(7));
				data.add(rs.getString(8));
				data.add(rs.getString(9));
				
				//��������ӵ����
				rowData.add(data);
			}
			
		}
		catch(Exception e)
				{
					e.printStackTrace();
				}
		
		//�ر�
		try 
		{
			 rs.close();
			 ps.close();
			 ct.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
	}
	
	public Table_Model(String sql) {
		
		this.inint(sql);
	}
	
	
	//���캯������ʼ����ģ��
	public Table_Model() {
		
		this.inint("");
				
	}
	
	//��������
	public int getRowCount() {  
		
		return this.rowData.size();
	}

	 //��������
	public int getColumnCount() { 
		
		return this.columnName.size();
	} 

	//��ȡĳ���е�����
	public Object getValueAt(int row, int column) {  
		
		return ((Vector)this.rowData.get(row)).get(column);
	}
	
    //��ȡ��ͷ���ݣ�������
	public String getColumnName(int column) {
		
		return (String)this.columnName.get(column);
	}

}
