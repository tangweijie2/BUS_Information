package testlogin;
/*
 * 创建一个table模型，实现对表格的更新
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

	//roeData存放数据，columnName存放列名
	Vector rowData,columnName;
	//定义操作数据库所需的变量
	PreparedStatement ps =null;
	Connection ct = null;
	ResultSet rs = null;  //结果集是一个存储查询结果的对象，但是结果集并不仅仅具有存储的功能，
	                     //他同时还具有操纵数据的功能，可能完成对数据的更新
	
	
	public void inint(String sql) {
		if(sql.equals("")) {
			sql = "select * from train;";
		}
			
		//设置列名
		columnName= new Vector();  
		columnName.add("车次");
		columnName.add("出发地");
		columnName.add("目的地");
		columnName.add("日期");
		columnName.add("时间");
		
		columnName.add("管理员");
		columnName.add("票价");
		columnName.add("余量");
		columnName.add("行驶时间");
		
		//导入数据
		rowData =new Vector();
		
		//从数据库导入数据
		try 
		{
			
			//加载mysql驱动
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
				
				//将数据添加到表格
				rowData.add(data);
			}
			
		}
		catch(Exception e)
				{
					e.printStackTrace();
				}
		
		//关闭
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
	
	
	//构造函数，初始化表模型
	public Table_Model() {
		
		this.inint("");
				
	}
	
	//返回行数
	public int getRowCount() {  
		
		return this.rowData.size();
	}

	 //返回列数
	public int getColumnCount() { 
		
		return this.columnName.size();
	} 

	//获取某行列的数据
	public Object getValueAt(int row, int column) {  
		
		return ((Vector)this.rowData.get(row)).get(column);
	}
	
    //获取表头数据，即列名
	public String getColumnName(int column) {
		
		return (String)this.columnName.get(column);
	}

}
