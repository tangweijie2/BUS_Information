package testlogin;

//public class login_db {
//
//}
//
//package ע����Ϣ;
//
// 

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.sql.Connection;

import java.sql.ResultSet;

import java.sql.Statement;

 

import javax.swing.*;

 

public class login_db extends conn_db implements ActionListener {

	JTextField accT,nameT;

	JButton okB,registB;

	register re;

	ResultSet rs;
	
	
	

	public void setaccountT(JTextField a){

		accT = a;

	}

	public void setnameT(JTextField n){

		nameT = n;

	}

	public void setButton(JButton b1,JButton b2){

		okB = b1;

		registB = b2;

	}

	

	public void actionPerformed(ActionEvent e){

		if(e.getSource() == okB){

			if(accT.getText().equals(""))			//�ж��û������Ƿ�Ϊ�գ�

				JOptionPane.showMessageDialog(null, "����д�˺ţ�");

			else if(nameT.getText().equals(""))

				JOptionPane.showMessageDialog(null, "����������");

			else{

				String accountT = accT.getText();//��ȡ�����������

				String namesT = nameT.getText();

				try {

					connection(); 		//����conn_db�࣬�������ݿ⣻

					boolean com = compareWithSql(accountT,namesT);

					if(com) {
                        
						//JOptionPane.showMessageDialog(null, "��¼�ɹ�");
						Student s1 = new Student();
					}
					else{

						JOptionPane.showMessageDialog(null, "�˺Ż����벻��ȷ������������");

						accT.setText("");

						nameT.setText("");

					}

				} 

				catch (Exception e1) {

					e1.printStackTrace();

				}

			}

		}

		else if(e.getSource() == registB){

			new JFrame().dispose();

			re = new register();

		}

	}

	

	//�û�������

	boolean compareWithSql(String accountT,String namesT) throws Exception{

		String sql;		

		Connection con = super.con;

		Statement stmt = con.createStatement();

		sql = "select * from login";

//		System.out.println(sql);

		rs = stmt.executeQuery(sql);

		while(rs.next()){				//�û��������Ϣ�����ݿ��е���Ϣ���Ƚϣ��ж������Ƿ���ȷ��

			String acc = rs.getString(1);

			String names = rs.getString(2);

			if(acc.equals(accountT) && names.equals(namesT)){
				//if(acc.equals(name) && names.equals(password){

				//break;

				return true;

			}

//			System.out.println(acc + "   " + names);

//			System.out.println(accountT + "   " + namesT);

			

		}

//		System.out.println("hahahaha");

		return false;

		

	}

	

}
