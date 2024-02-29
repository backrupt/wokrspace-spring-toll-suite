package com.itwill.layout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.itwill.member.MemberService;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberJoinPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public MemberJoinPanel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(73, 117, 57, 15);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(73, 208, 57, 15);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(73, 287, 57, 15);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(73, 387, 57, 15);
		add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(215, 114, 116, 21);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(215, 205, 116, 21);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(215, 284, 116, 21);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(215, 384, 116, 21);
		add(textField_3);
		
		JButton btnNewButton = new JButton("회원가입");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberService memberService;
				try {
					memberService = new MemberService();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//memberService.addMember(null);
			}
		});
		btnNewButton.setBounds(67, 506, 97, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("로그인");
		btnNewButton_1.setBounds(234, 506, 97, 23);
		add(btnNewButton_1);

	}

}
