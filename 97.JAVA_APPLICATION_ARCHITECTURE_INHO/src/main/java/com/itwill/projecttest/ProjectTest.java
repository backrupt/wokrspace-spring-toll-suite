package com.itwill.projecttest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JScrollBar;

public class ProjectTest extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectTest frame = new ProjectTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ProjectTest() {
		setTitle("쇼핑몰");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane shopTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(shopTabbedPane, BorderLayout.CENTER);
		
		JPanel shopPanel = new JPanel();
		shopTabbedPane.addTab("회원", null, shopPanel, null);
		shopPanel.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane memberTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		shopPanel.add(memberTabbedPane, BorderLayout.CENTER);
		
		JPanel memberLoginPanel = new JPanel();
		memberTabbedPane.addTab("로그인", null, memberLoginPanel, null);
		memberLoginPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("회원 가입");
		lblNewLabel_1.setBounds(167, 44, 57, 15);
		memberLoginPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("아이디");
		lblNewLabel_2.setBounds(45, 95, 57, 15);
		memberLoginPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("비밀번호");
		lblNewLabel_3.setBounds(45, 120, 57, 15);
		memberLoginPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("비밀번호 확인");
		lblNewLabel_4.setBounds(45, 145, 57, 15);
		memberLoginPanel.add(lblNewLabel_4);
		
		JPanel memberJoinPanel = new JPanel();
		memberTabbedPane.addTab("회원가입", null, memberJoinPanel, null);
		
		JPanel memberInfoPanel = new JPanel();
		memberTabbedPane.addTab("마이페이지", null, memberInfoPanel, null);
		
		JPanel memberWishListPanel = new JPanel();
		memberTabbedPane.addTab("관심목록", null, memberWishListPanel, null);
		
		JPanel memberAdminPanel = new JPanel();
		memberTabbedPane.addTab("회원관리", null, memberAdminPanel, null);
		
		JPanel productPanel = new JPanel();
		shopTabbedPane.addTab("상품", null, productPanel, null);
		productPanel.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		productPanel.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("이벤트", null, panel, null);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_9 = new JPanel();
		panel.add(panel_9, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("전체보기", null, panel_3, null);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("카테고리별", null, panel_4, null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("상품등록", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		shopTabbedPane.addTab("주문", null, panel_2, null);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		panel_2.add(tabbedPane_1, BorderLayout.CENTER);
		
		JPanel panel_6 = new JPanel();
		tabbedPane_1.addTab("New tab", null, panel_6, null);
		panel_6.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		tabbedPane_1.addTab("New tab", null, panel_7, null);
		
		JPanel panel_8 = new JPanel();
		tabbedPane_1.addTab("New tab", null, panel_8, null);
		
		JPanel panel_5 = new JPanel();
		contentPane.add(panel_5, BorderLayout.NORTH);
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		textField = new JTextField();
		panel_5.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ProjectTest.class.getResource("/images/search_image20.png")));
		panel_5.add(lblNewLabel);
	}
}
