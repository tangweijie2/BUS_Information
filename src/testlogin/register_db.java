package testlogin;


//package ע����Ϣ;

 

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.sql.Connection;

import java.sql.ResultSet;

import java.sql.Statement;

 

import javax.swing.*;

 

public class register_db extends conn_db implements ActionListener{

 

	JTextField textacc,textname;

	JButton okButton,resetButton;

	Statement stmt;

	ResultSet rs;

//	double acc;

//	String name;

//	Connection con = null;

	

	public void setaccountField(JTextField a){

		textacc = a;

	}

	public void setnameField(JTextField n){

		textname = n;

	}

	public void setokButton(JButton b1){

		okButton = b1;

	}

	public void setresetButton(JButton b2){

		resetButton = b2;

	}

	

	public void actionPerformed(ActionEvent e){

		if(e.getSource() == okButton){

			if(textacc.getText().equals(""))			//�ж��û������Ƿ�Ϊ�գ�

				JOptionPane.showMessageDialog(null, "�������˺�","����Ի���",JOptionPane.WARNING_MESSAGE);

			else if(textname.getText().equals(""))

				JOptionPane.showMessageDialog(null,"����������","����Ի���",JOptionPane.WARNING_MESSAGE);

			else{

				String acc = textacc.getText();

				String name = textname.getText();

				try {

					connection();

					writeInSql(acc,name);

				} catch (Exception e1) {

					System.out.println("����ʧ��");

					e1.printStackTrace();

				}

			}

		}

		else if(e.getSource() == resetButton){

			textacc.setText("");

			textname.setText("");

		}

	}

	

	void writeInSql(String acc,String name) throws Exception{

		String sql;

		

		Connection con = super.con;

		Statement stmt = con.createStatement();

		

		//������������ݿ����û��"my"���򴴽���ִ�в�������������Ѵ��ڣ���ֱ��ִ�в�������������

		sql = "create table if not exists my(account varchar(10),name varchar(20))";

		

		stmt.executeUpdate(sql);

//		System.out.println(sql);		//���

		System.out.println("������ɹ�");	

		

		//������ı����л�ȡ�����ݣ�

		sql = "insert into login(account,name) values('"+acc+"','"+name+"')";

		int rw = stmt.executeUpdate(sql);

//		System.out.println(sql);

		if(rw <= 0){				//�ж������Ƿ����ɹ�

			JOptionPane.showMessageDialog(null,"ע��ʧ��");

		}

		else{

			JOptionPane.showMessageDialog(null, "ע��ɹ�");

		}

	}

}
