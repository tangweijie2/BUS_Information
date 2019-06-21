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

public class Table_Display extends JFrame  {//继承JFrame类（JFrame普通窗体对象）
	 Vector rowData,columnNames;
	 //rowData为填充数据，column为表格表头 
	    
	    JTable jt=null;  //注册表格
	    JScrollPane jsp=null; //注册滚动面板
	    
	    PreparedStatement ps=null;  //数据库操作接口对象
	    Connection ct=null;  //主要用于连接数据库
	    ResultSet rs=null;  //　查询数据库时，返回的是一个二维的结果集，我们需要用到ResultSet来遍历结果集，获取每一行的数据
	    //定义数据库所需变量  
	    
	    public  Table_Display(){  //构造函数
	    	
	        columnNames=new Vector();  
	        //设置列名  
	        columnNames.add("身份证号");  
	        columnNames.add("名字");  
	        columnNames.add("购买车次");
	        columnNames.add("出发地");  
	        columnNames.add("目的地"); 
	        rowData = new Vector();  
            //rowData可以存放多行,开始从数据库里取  
              
            try {  
                //加载驱动  
            	
            	Class.forName("com.mysql.cj.jdbc.Driver");//Class.forName 传入 com.mysql.jdbc.Driver 之后,就知道我连接的数据库是 mysql
				ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/bus_db?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false",
												"root",
												"123456");
				ps =  ct.prepareStatement("select * from users;");
                //Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");  
                //得到连接  
              //  ct=DriverManager.getConnection("jdbc:microsoft:sqlserver://127.0.0.1:1433;databaseName=spdb1","sa","sa");  
                  
              //  ps=ct.prepareStatement("select * from stu");  
                  
                rs=ps.executeQuery();  //executeQuery()方法会把数据库响应的查询结果存放在ResultSet类对象中供我们使用
                  
                while(rs.next()){  //.next()方法的作用:指针指向下一条记录,有记录(有值)返回true并把记录内容存入到对应的对象中
                    //rowData可以存放多行  
                    Vector hang=new Vector();  
                    hang.add(rs.getString(1));  
                    hang.add(rs.getString(2));  
                    hang.add(rs.getString(3)); 
                    hang.add(rs.getString(4));  
                    hang.add(rs.getString(5));  
                    rowData.add(hang);  
                }  
            } catch (Exception e) {  
                e.printStackTrace();  //异常处理打印
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
              
                          
            //初始化Jtable  
            jt = new JTable(rowData,columnNames);  
              
            //初始化 jsp  
            jsp = new JScrollPane(jt);  
              
            //把jsp放入到jframe  
            this.add(jsp);  
              
            this.setSize(500, 300);  
              
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //子窗口关闭，父窗口仍在
          //  this.setDefaultCloseOption(JFrame.DISPOSE_ON_CLOSE);EXIT_ON_CLOSE
            this.setVisible(true);  
              
        }  





}