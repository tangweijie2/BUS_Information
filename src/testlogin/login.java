package testlogin;

//public class login {
//
//}


//package ע����Ϣ;

 

import java.awt.FlowLayout;

import java.awt.event.ActionListener;

 

import javax.swing.JFrame;

import javax.swing.*;

 

public class login extends JFrame{

	//JLabel accountL,nameL;

	JTextField accountT,nameT;

	JButton okB,registB;

	Box baseB1,baseB2,box1,box2,box3;		//�˵�¼ҳ�����Box���ַ�ʽ��

	login_db log;

	

	login(){

		init();

	}

	void init(){

		log = new login_db();

		

		accountT = new JTextField(10);

		nameT = new JTextField(20);

		okB = new JButton("��¼");

		registB = new JButton("ע��");

		

		box1 = Box.createVerticalBox();

		box1.add(new JLabel("�˺ţ�"));

		box1.add(Box.createVerticalStrut(8));

		box1.add(new JLabel("����"));

		

		box2 = Box.createVerticalBox();

		box2.add(accountT);

		box2.add(Box.createVerticalStrut(8));

		box2.add(nameT);

		

		box3 = Box.createHorizontalBox();

		box3.add(okB);

		box3.add(Box.createHorizontalStrut(20));

		box3.add(registB);

		

		baseB1 = Box.createHorizontalBox();

		baseB1.add(box1);

		baseB1.add(Box.createHorizontalStrut(8));

		baseB1.add(box2);

		

		baseB2 = Box.createVerticalBox();

		baseB2.add(baseB1);

		baseB2.add(Box.createVerticalStrut(10));

		baseB2.add(box3);

		

		okB.addActionListener(log);

		registB.addActionListener(log);

		

		log.setaccountT(accountT);

		log.setnameT(nameT);

		log.setButton(okB,registB);

		

		add(baseB2);

		setLayout(new FlowLayout());

		setBounds(200,150,400,300);

		setVisible(true);

		setTitle("��;������Ϣ����ϵͳ��¼����");

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}

	

	public static void main(String[] args) {

		login lo = new login();  //�������

	}

}
