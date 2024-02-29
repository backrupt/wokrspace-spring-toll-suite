package com.itwill.address.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.address.Address;
import com.itwill.address.AddressService;

import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AddressMainFramePre extends JFrame {
	/*************AddressService멤버필드선언*********************/
	AddressService addressService;
	private JPanel contentPane;
	private JTable addressListTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddressMainFramePre frame = new AddressMainFramePre();
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
	public AddressMainFramePre() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel addressWritePanel = new JPanel();
		addressWritePanel.setBackground(new Color(255, 128, 128));
		tabbedPane.addTab("주소록쓰기", null, addressWritePanel, null);
		addressWritePanel.setLayout(null);
		
		JButton addressWriteButton = new JButton("주소록쓰기");
		addressWriteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/******************************주소록 쓰기******************************/
				try {
					Address address = Address.builder().name("김미영")
							.phone("111-1111")
							.address("서울중앙지검")
							.build();
					int insertRowCount = addressService.addressWrite(address);
					if(insertRowCount>0) {
						int result = JOptionPane.showConfirmDialog(null, "쓰기성공 메인으로이동하시겠습니까.");
						System.out.println("showConfirmDialog result -->"+result);
						return;
					}
					addressService.addressWrite(address);
				} catch (Exception e1) {
					// TODO: handle exception
					e1.printStackTrace();
				}
				/******************************주소록 쓰기******************************/
			}
		});
		addressWriteButton.setBounds(154, 165, 115, 23);
		addressWritePanel.add(addressWriteButton);
		
		JPanel addressListPanel = new JPanel();
		addressListPanel.setBackground(new Color(128, 255, 128));
		tabbedPane.addTab("주소록리스트", null, addressListPanel, null);
		addressListPanel.setLayout(null);
		
		JButton addressListButton = new JButton("주소록리스트");
		addressListButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/******************************주소록 리스트*************************************/
				try {
					List<Address> addressList = addressService.addressList();
					Vector<String> columnVector = new Vector<String>();
					columnVector.add("번호");
					columnVector.add("이름");
					columnVector.add("전화번호");
					columnVector.add("주소");
					Vector<Vector> tableVector=new Vector<Vector>();
					for (Address address : addressList) {
						Vector rowVector = new Vector();						
						rowVector.add(address.getNo());
						rowVector.add(address.getName());
						rowVector.add(address.getPhone());
						rowVector.add(address.getAddress());
						tableVector.add(rowVector);
					}
					DefaultTableModel tableModel = new DefaultTableModel(tableVector,columnVector);
					
					addressListTable.setModel(tableModel);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "호갱님 죄송합니다");
				}
				/******************************주소록 리스트*************************************/
			}
		});
		addressListButton.setBounds(153, 167, 122, 23);
		addressListPanel.add(addressListButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 395, 147);
		addressListPanel.add(scrollPane);
		
		addressListTable = new JTable();
		addressListTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"\uBC88\uD638", "\uC774\uB984", "\uC804\uD654\uBC88\uD638", "\uC8FC\uC18C"
			}
		));
		scrollPane.setViewportView(addressListTable);
		
		JPanel addressDetailPanel = new JPanel();
		addressDetailPanel.setBackground(new Color(128, 255, 255));
		tabbedPane.addTab("주소록상세보기", null, addressDetailPanel, null);
		addressDetailPanel.setLayout(null);
		
		JButton addressDetailButton = new JButton("주소록상세보기");
		addressDetailButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/******************************주소록 상세보기*************************************/
				try {
					//addressService = null;
					Address address = addressService.addressDetail(10);
					if(address==null) {
						JOptionPane.showMessageDialog(null, "존재하지않는 주소입니다.");
						return;
					}
					System.out.println("UI>>>>"+address);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "호갱님 죄송합니다");
				}
				/******************************주소록 상세보기*************************************/
			}
		});
		addressDetailButton.setBounds(153, 160, 133, 23);
		addressDetailPanel.add(addressDetailButton);
		
		/********************2.AddressService 객체생성***************************/
		try {
			this.addressService = new AddressService();
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
	} //생성자 끝
}//클래스 끝
