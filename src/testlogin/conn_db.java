package testlogin;

//public class conn_db {
//
//}

//package 注册信息;

 

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

import java.sql.Statement;

 

public class conn_db{

	Connection con;

	String url = null;

	//Statement stmt;

	

	public void connection() throws ClassNotFoundException{

//		url = "jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false","root", "cys19971111";

		try{

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bus_db?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false",
												"root",
												"123456");

			System.out.println("连接成功");

			//stmt = con.createStatement();

		}

		catch(SQLException e){

			e.printStackTrace();

		}

	}

	

	

//	public static void main(String[] args) throws ClassNotFoundException {

//		conn_db conn = new conn_db();

//		conn.connection();

//		

//	}

}
