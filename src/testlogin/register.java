package testlogin;

//public class register {
//
//}

//package ע����Ϣ;

 

import javax.swing.JFrame;

 

import java.awt.FlowLayout;

import javax.swing.*;

 

public class register extends JFrame{

	JLabel accountLabel,nameLabel;

	JButton okButton,resetButton;

	JTextField accountText,nameText;

	Box baseBox1,baseBox2, box1,box2,box3;		 //��ע��ҳ�����Box���ַ�ʽ��

	//JPanel pane1,pane2;

	

	register_db regist;

	

	register(){

		init();

	}

	

	

	void init(){

		setLayout(new FlowLayout());

		accountLabel = new JLabel("�˺�");

		nameLabel= new JLabel("����");

		accountText = new JTextField(10);

		nameText = new JTextField(20);

		okButton = new JButton("ȷ��");

		resetButton = new JButton("����");

		

		regist = new register_db();

		

//		lab = new JLabel("�û�ע��ҳ��");

		

		box1 = Box.createVerticalBox();

		box1.add(accountLabel);

		box1.add(Box.createVerticalStrut(8));

		box1.add(nameLabel);

		box2 = Box.createVerticalBox();

		box2.add(accountText);

		box2.add(Box.createVerticalStrut(8));

		box2.add(nameText);

		box3 = Box.createHorizontalBox();

		box3.add(okButton);

		box3.add(Box.createHorizontalStrut(15));

		box3.add(resetButton);

		baseBox1 = Box.createHorizontalBox();

		baseBox1.add(box1);

		baseBox1.add(Box.createHorizontalStrut(8));

		baseBox1.add(box2);

		baseBox2 = Box.createVerticalBox();

		baseBox2.add(baseBox1);

		baseBox2.add(Box.createVerticalStrut(10));

		baseBox2.add(box3);

		add(baseBox2);

		

		okButton.addActionListener(regist);

		resetButton.addActionListener(regist);

		

		

		regist.setaccountField(accountText);

		regist.setnameField(nameText);

		regist.setokButton(okButton);

		regist.setresetButton(resetButton);

		

		setBounds(200,200,400,300);

		setVisible(true);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		setTitle("�û�ע�����");

	}

	

//	void registAction(){

//		

//	}

	

	

//	public static void main(String[] args) {

//		register re = new register();

//	}

	

}
