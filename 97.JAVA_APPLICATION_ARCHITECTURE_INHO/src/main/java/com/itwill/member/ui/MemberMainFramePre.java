package com.itwill.member.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MemberMainFramePre extends JFrame {

	private JPanel contentPane;
	private JTextField searchTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberMainFramePre frame = new MemberMainFramePre();
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
	public MemberMainFramePre() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 371, 645);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("회원");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("로그인");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("로그아웃");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("종료");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("상품");
		menuBar.add(mnNewMenu_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel searchNorthPanel = new JPanel();
		contentPane.add(searchNorthPanel, BorderLayout.NORTH);
		
		searchTextField = new JTextField();
		searchNorthPanel.add(searchTextField);
		searchTextField.setColumns(10);
		
		JButton searchButton = new JButton("검색");
		searchNorthPanel.add(searchButton);
		
		JPanel menuSouthPanel = new JPanel();
		contentPane.add(menuSouthPanel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Home");
		menuSouthPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("MyInfo");
		menuSouthPanel.add(btnNewButton_1);
		
		JTabbedPane shopTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(shopTabbedPane, BorderLayout.CENTER);
		
		JPanel shopMainTabPanel = new JPanel();
		shopTabbedPane.addTab("메인", new ImageIcon(MemberMainFramePre.class.getResource("/images/cart20.png")), shopMainTabPanel, null);
		shopMainTabPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(MemberMainFramePre.class.getResource("/images/o_title_logo.png")));
		shopMainTabPanel.add(lblNewLabel, BorderLayout.CENTER);
		
		JPanel shopMemberTabPanel = new JPanel();
		shopMemberTabPanel.setBackground(new Color(255, 0, 255));
		shopTabbedPane.addTab("회원", null, shopMemberTabPanel, null);
		shopMemberTabPanel.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane memberTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		memberTabbedPane.setBackground(Color.YELLOW);
		shopMemberTabPanel.add(memberTabbedPane, BorderLayout.CENTER);
		
		JPanel memberLoginPanel = new JPanel();
		memberLoginPanel.setBackground(Color.PINK);
		memberTabbedPane.addTab("로그인", null, memberLoginPanel, null);
		
		JPanel memberDetailPanel = new JPanel();
		memberDetailPanel.setBackground(Color.CYAN);
		memberTabbedPane.addTab("회원보기", null, memberDetailPanel, null);
		
		JPanel memberJoinPanel = new JPanel();
		memberJoinPanel.setBackground(Color.LIGHT_GRAY);
		memberTabbedPane.addTab("가입", null, memberJoinPanel, null);
		
		JPanel shopProductTabPanel = new JPanel();
		shopProductTabPanel.setBackground(new Color(0, 255, 0));
		shopTabbedPane.addTab("제품", null, shopProductTabPanel, null);
		shopProductTabPanel.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane productTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		shopProductTabPanel.add(productTabbedPane, BorderLayout.CENTER);
		
		JPanel productListPanel = new JPanel();
		productListPanel.setBackground(new Color(255, 153, 51));
		productTabbedPane.addTab("제품리스트", null, productListPanel, null);
		
		JPanel productDetailPanel = new JPanel();
		productDetailPanel.setBackground(new Color(153, 204, 102));
		productTabbedPane.addTab("제품상세", null, productDetailPanel, null);
		
		JPanel productSearchPanel = new JPanel();
		productSearchPanel.setBackground(new Color(0, 0, 255));
		productTabbedPane.addTab("제품검색", null, productSearchPanel, null);
	}

}
