package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class StoreApp extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Á¡Æ÷ Á¤º¸ Å×ÀÌºí, Á÷¿ø Á¤º¸ Å×ÀÌºí
	JTable storeTable, memberTable;
	//Á¡Æ÷ Á¤º¸ ÀÔ·Â TextField - Á¡Æ÷ ¹øÈ£, Á¡Æ÷ ÀÌ¸§, ÀüÈ­¹øÈ£
	JTextField sno_tf, sname_tf, sphone_tf;
	//Á÷¿ø Á¤º¸ ÀÔ·Â TextField - Á÷¿ø ¹øÈ£, Á÷¿ø ÀÌ¸§, ÀüÈ­¹øÈ£, ÀÔ»çÀÏ, ¿ù±Þ
	JTextField mno_tf, mname_tf, mphone_tf, mdate_tf, mpay_tf;
	//Á¡Æ÷ °ü·Ã JButton - Á¡Æ÷ ¹øÈ£ °Ë»ö, Á¡Æ÷ ÀÌ¸§ °Ë»ö, Á¡Æ÷ Ãß°¡, Á¡Æ÷ ¼öÁ¤, Á¡Æ÷ »èÁ¦, °Ë»ö ÃÊ±âÈ­ 
	JButton searchSno_btn, searchSname_btn, addStore_btn, updateStore_btn, deleteStore_btn, initSearchStore_btn;
	//Á÷¿ø °ü·Ã JButton - Á÷¿ø ¹øÈ£ °Ë»ö, Á÷¿ø ÀÌ¸§ °Ë»ö, Á÷¿ø Ãß°¡, Á÷¿ø ¼öÁ¤, Á÷¿ø »èÁ¦, °Ë»ö ÃÊ±âÈ­ 
	JButton searchMno_btn, searchMname_btn, addMember_btn, updateMember_btn, deleteMember_btn, initSearchMember_btn;
	
	public StoreApp() {
		setTitle("Á¡Æ÷º° Á÷¿ø °ü¸® ÇÁ·Î±×·¥");
		setLayout(new GridLayout(0,2));
		
		JPanel store_p=new JPanel();
		JPanel member_p=new JPanel();
		

		//store_p JPanel
		store_p.setLayout(new BorderLayout());
		
		
		JPanel searchStore_pnl = new JPanel();
		store_p.add(searchStore_pnl, BorderLayout.NORTH);
		
		JLabel sno_lbl = new JLabel("Á¡Æ÷ ¹øÈ£");
		searchStore_pnl.add(sno_lbl);
		
		sno_tf = new JTextField();
		searchStore_pnl.add(sno_tf);
		sno_tf.setColumns(10);

		
		searchSno_btn = new JButton("°Ë»ö");
		searchStore_pnl.add(searchSno_btn);
		
		JLabel sname_lbl = new JLabel("Á¡Æ÷ ÀÌ¸§");
		searchStore_pnl.add(sname_lbl);
		
		sname_tf = new JTextField();
		searchStore_pnl.add(sname_tf);
		sname_tf.setColumns(10);
		
		searchSname_btn = new JButton("°Ë»ö");
		searchStore_pnl.add(searchSname_btn);
		
		
		
		
		Object[] sTitle={"Á¡Æ÷ ¹øÈ£","ÀÌ¸§","ÀüÈ­¹øÈ£"};
		storeTable=new JTable(new DefaultTableModel(sTitle, 0));
		storeTable.getTableHeader().setReorderingAllowed(false);
		storeTable.getTableHeader().setResizingAllowed(false);
		

		JScrollPane storeTable_sp=new JScrollPane(storeTable);
		store_p.add(storeTable_sp, BorderLayout.CENTER);	
		
		JPanel updateStore_pnl = new JPanel();
		store_p.add(updateStore_pnl, BorderLayout.SOUTH);
		
		updateStore_pnl.add(addStore_btn = new JButton("Á¡Æ÷ Ãß°¡"));
		updateStore_pnl.add(updateStore_btn = new JButton("Á¡Æ÷ ¼öÁ¤"));
		updateStore_pnl.add(deleteStore_btn = new JButton("Á¡Æ÷ »èÁ¦"));
		updateStore_pnl.add(initSearchStore_btn = new JButton("°Ë»ö ÃÊ±âÈ­"));
		

		//member_p JPanel
		member_p.setLayout(new BorderLayout());
		
		JPanel searchMember_pnl = new JPanel();
		member_p.add(searchMember_pnl, BorderLayout.NORTH);
		
		JLabel mno_lbl = new JLabel("Á÷¿ø ¹øÈ£");
		searchMember_pnl.add(mno_lbl);
		
		mno_tf = new JTextField();
		searchMember_pnl.add(mno_tf);
		mno_tf.setColumns(10);
		
		searchMno_btn = new JButton("°Ë»ö");
		searchMember_pnl.add(searchMno_btn);
		
		JLabel mname_lbl = new JLabel("Á÷¿ø ÀÌ¸§");
		searchMember_pnl.add(mname_lbl);
		
		mname_tf = new JTextField();
		searchMember_pnl.add(mname_tf);
		mname_tf.setColumns(10);
		
		searchMname_btn = new JButton("°Ë»ö");
		searchMember_pnl.add(searchMname_btn);
		
	
		Object[] mTitle={"Á÷¿ø ¹øÈ£","ÀÌ¸§","ÀüÈ­¹øÈ£","ÀÔ»çÀÏ","¿ù±Þ","Á¡Æ÷ ¹øÈ£"};
		memberTable=new JTable(new DefaultTableModel(mTitle, 0));
		memberTable.getTableHeader().setReorderingAllowed(false);
		memberTable.getTableHeader().setResizingAllowed(false);
		
		JScrollPane memberTable_sp=new JScrollPane(memberTable);
		member_p.add(memberTable_sp, BorderLayout.CENTER);	
		
		JPanel updateMember_pnl = new JPanel();
		member_p.add(updateMember_pnl, BorderLayout.SOUTH);
		
		updateMember_pnl.add(addMember_btn = new JButton("Á÷¿ø Ãß°¡"));
		updateMember_pnl.add(updateMember_btn = new JButton("Á÷¿ø ¼öÁ¤"));
		updateMember_pnl.add(deleteMember_btn = new JButton("Á÷¿ø »èÁ¦"));
		updateMember_pnl.add(initSearchMember_btn = new JButton("°Ë»ö ÃÊ±âÈ­"));
		
		
		add(store_p);
		add(member_p);
		
		addStore_btn.addActionListener(new EventHandler());
		deleteStore_btn.addActionListener(new EventHandler());
		updateStore_btn.addActionListener(new EventHandler());
		initSearchStore_btn.addActionListener(new EventHandler());

		addMember_btn.addActionListener(new EventHandler());
		deleteMember_btn.addActionListener(new EventHandler());
		updateMember_btn.addActionListener(new EventHandler());
		initSearchMember_btn.addActionListener(new EventHandler());
		
		
		storeTable.addMouseListener(new EventHandler());
		memberTable.addMouseListener(new EventHandler());
		
		searchSno_btn.addActionListener(new EventHandler());
		searchSname_btn.addActionListener(new EventHandler());
		searchMno_btn.addActionListener(new EventHandler());
		searchMname_btn.addActionListener(new EventHandler());
		
		
		displayStore();
		displayMember();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(500, 200, 1000, 600);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new StoreApp();
	}
	

	public class EventHandler extends MouseAdapter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object eventSource=e.getSource();
			
			if(eventSource instanceof JButton) {
				if(eventSource==addStore_btn) {
					new addStoreDialog();
					storeSetEnable(1);
				} else if(eventSource==addMember_btn) {
					new addMemberDialog();
					memberSetEnable(1);
				} else if(eventSource==deleteStore_btn) {
					removeStore();
				} else if(eventSource==deleteMember_btn) {
					removeMember();
				} else if(eventSource==updateStore_btn) {
					updateStore();
				} else if(eventSource==updateMember_btn) {
					updateMember();
				} else if(eventSource==searchSno_btn) {
					searchSno();
				} else if(eventSource==searchSname_btn) {
					searchSname();
				} else if(eventSource==searchMno_btn) {
					searchMno();
				} else if(eventSource==searchMname_btn) {
					searchMname();
				} else if(eventSource==initSearchStore_btn) {
					displayStore();
				} else if(eventSource==initSearchMember_btn) {
					displayMember();
				}
			}
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			Object eventSource=e.getSource();
			
			if(eventSource instanceof JTable) {
				if(eventSource==storeTable) {
//					displayMember();
					storeSetEnable(2);
				} 
				if(eventSource==memberTable) {
					memberSetEnable(2);
				}
			} 
		}
	}
	
	//°Ë»ö TextField ÃÊ±âÈ­ ¸Þ¼Òµå
	public void initSearchTF() {
		sno_tf.setText("");
		sname_tf.setText("");
		mno_tf.setText("");
		mname_tf.setText("");
	}
	
	
	public void storeSetEnable(int n) {
		
		addStore_btn.setEnabled(true);
		switch (n) {
		case 1 : 
			updateStore_btn.setEnabled(false);
			deleteStore_btn.setEnabled(false);
			initSearchStore_btn.setEnabled(false);
			break;
		case 2:
			updateStore_btn.setEnabled(true);
			deleteStore_btn.setEnabled(true);
//			initSearchStore_btn.setEnabled(false);
			break;
		case 3:
			updateStore_btn.setEnabled(false);
			deleteStore_btn.setEnabled(false);
			initSearchStore_btn.setEnabled(true);
			break;
		}		
	}
	
	public void memberSetEnable(int n) {
		
		addMember_btn.setEnabled(true);
		switch (n) {
		case 1 : 
			updateMember_btn.setEnabled(false);
			deleteMember_btn.setEnabled(false);
			initSearchMember_btn.setEnabled(false);
			break;
		case 2 : 
			updateMember_btn.setEnabled(true);
			deleteMember_btn.setEnabled(true);
//			initSearchMember_btn.setEnabled(false);
			break;
		case 3:
			updateMember_btn.setEnabled(false);
			deleteMember_btn.setEnabled(false);
			initSearchMember_btn.setEnabled(true);
			break;
		}
	}

	
	public class addStoreDialog extends JFrame {
		private static final long serialVersionUID = 1L;
		public addStoreDialog() {
			setTitle("Á¡Æ÷ Ãß°¡");
			setLayout(new GridLayout(2, 0));
			
			JPanel store_pnl = new JPanel();
			store_pnl.add(new JLabel("¹øÈ£"));
			store_pnl.add(sno_tf = new JTextField(10));

			store_pnl.add(new JLabel("ÀÌ¸§"));
			store_pnl.add(sname_tf = new JTextField(10));
			
			store_pnl.add(new JLabel("ÀüÈ­¹øÈ£"));
			store_pnl.add(sphone_tf = new JTextField(10));
			
			JPanel btn_ok_cancel = new JPanel();
			JButton addStore_btn_OK = new JButton("È®ÀÎ");
			JButton addStore_btn_CANCEL = new JButton("Ãë¼Ò");
			btn_ok_cancel.add(addStore_btn_OK);
			btn_ok_cancel.add(addStore_btn_CANCEL);
		
			add(store_pnl);
			add(btn_ok_cancel);
			
			addStore_btn_OK.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					addStore();
				}
			});
			
			addStore_btn_CANCEL.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
			
		
			setBounds(750, 450, 500, 150);
			setVisible(true);
		}
		
		public addStoreDialog(int sno, String sname, String sphone) {
			setTitle("Á¡Æ÷ ¼öÁ¤");
			setLayout(new GridLayout(2, 0));
			
			
			JPanel store_pnl = new JPanel();
			store_pnl.add(new JLabel("¹øÈ£"));
			store_pnl.add(sno_tf = new JTextField(10));
			sno_tf.setText(sno+"");
			sno_tf.setEditable(false);

			store_pnl.add(new JLabel("ÀÌ¸§"));
			store_pnl.add(sname_tf = new JTextField(10));
			sname_tf.setText(sname);
			
			store_pnl.add(new JLabel("ÀüÈ­¹øÈ£"));
			store_pnl.add(sphone_tf = new JTextField(10));
			sphone_tf.setText(sphone);
			
			JPanel btn_ok_cancel = new JPanel();
			JButton updateStore_btn_OK = new JButton("È®ÀÎ");
			JButton updateStore_btn_CANCEL = new JButton("Ãë¼Ò");
			btn_ok_cancel.add(updateStore_btn_OK);
			btn_ok_cancel.add(updateStore_btn_CANCEL);
		
			
			add(store_pnl);
			add(btn_ok_cancel);
			
			updateStore_btn_OK.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					modifyStore();
					setVisible(false);
				}
			});
			
			updateStore_btn_CANCEL.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
			
		
			setBounds(750, 450, 500, 150);
			setVisible(true);
		}
		
		public void addStore() {
			//À¯È¿¼º °Ë»ç
			String snoTemp=sno_tf.getText();
			
			if(snoTemp.equals("")) {//ÀÔ·Â°ªÀÌ ¾ø´Â °æ¿ì
				JOptionPane.showMessageDialog(this, "Á¡Æ÷ ¹øÈ£¸¦ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
				sno_tf.requestFocus();
				return;
			}
			
			String snoReg="\\d{2}";//Á¤±ÔÇ¥Çö½Ä - 2ÀÚ¸® ¼ýÀÚ ÀÔ·Â °¡´É
			if(!Pattern.matches(snoReg, snoTemp)) {//Á¤±ÔÇ¥Çö½Ä°ú ÀÔ·Â°ªÀÇ Çü½ÄÀÌ ´Ù¸¥ °æ¿ì
				JOptionPane.showMessageDialog(this, "Á¡Æ÷ ¹øÈ£´Â 2ÀÚ¸®ÀÇ ¼ýÀÚ·Î¸¸ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
				sno_tf.requestFocus();
				return;
			}
			
			int sno=Integer.parseInt(snoTemp);
			
			if(StoreDAO.getDAO().selectSno(sno)!=null) {
				JOptionPane.showMessageDialog(this, "ÀÌ¹Ì »ç¿ëÁßÀÎ Á¡Æ÷ ¹øÈ£ÀÔ´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
				sno_tf.requestFocus();
				return;
			}
			
			String sname=sname_tf.getText();
			
			if(sname.equals("")) {//ÀÔ·Â°ªÀÌ ¾ø´Â °æ¿ì
				JOptionPane.showMessageDialog(this, "ÀÌ¸§À» ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
				sname_tf.requestFocus();//ÀÔ·ÂÃÐÁ¡À» ÀÌµ¿ÇÏ´Â ¸Þ¼Òµå
				return;
			}
			
			
			String sphone=sphone_tf.getText();
			
			if(sphone.equals("")) {//ÀÔ·Â°ªÀÌ ¾ø´Â °æ¿ì
				JOptionPane.showMessageDialog(this, "ÀüÈ­¹øÈ£¸¦ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
				sphone_tf.requestFocus();//ÀÔ·ÂÃÐÁ¡À» ÀÌµ¿ÇÏ´Â ¸Þ¼Òµå
				return;
			}
			
			String sphoneReg="0\\d{1,2}-\\d{3,4}-\\d{4}";//Á¤±ÔÇ¥Çö½Ä
			if(!Pattern.matches(sphoneReg, sphone)) {//Á¤±ÔÇ¥Çö½Ä°ú ÀÔ·Â°ªÀÇ Çü½ÄÀÌ ´Ù¸¥ °æ¿ì
				JOptionPane.showMessageDialog(this, "ÀüÈ­¹øÈ£¸¦ Çü½Ä¿¡ ¸Â°Ô ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
				sphone_tf.requestFocus();
				return;
			}
			
			
			//DTO ÀÎ½ºÅÏ½º¸¦ »ý¼ºÇÏ°í ÄÄÆÛ³ÍÆ®ÀÇ ÀÔ·Â°ªÀ¸·Î ÇÊµå°ª º¯°æ
			StoreDTO store=new StoreDTO();
			store.setSno(sno);
			store.setSname(sname);
			store.setSphone(sphone);
			
			//ÇÐ»ýÁ¤º¸¸¦ Àü´ÞÇÏ¿© STUDENT Å×ÀÌºí¿¡ ÀúÀåÇÏ´Â DAO Å¬·¡½ºÀÇ ¸Þ¼Òµå È£Ãâ
			int rows=StoreDAO.getDAO().insertStore(store);
			
			JOptionPane.showMessageDialog(this, rows+"¸íÀÇ Á¡Æ÷ Á¤º¸¸¦ ÀúÀåÇÏ¿´½À´Ï´Ù.");
			
			displayStore();
			setVisible(false);
		}
	}
	
	public class addMemberDialog extends JFrame {
		private static final long serialVersionUID = 1L;
		
		
		public addMemberDialog() {
			setTitle("Á÷¿ø Ãß°¡");
			setLayout(new GridLayout(3, 0));
			
			JPanel member_pnl = new JPanel();
			member_pnl.add(new JLabel("Á¡Æ÷ ¹øÈ£"));
			member_pnl.add(sno_tf = new JTextField(10));

			member_pnl.add(new JLabel("Á÷¿ø ¹øÈ£"));
			member_pnl.add(mno_tf = new JTextField(10));
			
			member_pnl.add(new JLabel("ÀÌ¸§"));
			member_pnl.add(mname_tf = new JTextField(10));
			
			JPanel member_pnl2 = new JPanel();
			member_pnl2.add(new JLabel("ÀüÈ­¹øÈ£"));
			member_pnl2.add(mphone_tf = new JTextField(10));
			
			member_pnl2.add(new JLabel("ÀÔ»çÀÏ"));
			member_pnl2.add(mdate_tf = new JTextField(10));
			
			member_pnl2.add(new JLabel("¿ù±Þ"));
			member_pnl2.add(mpay_tf = new JTextField(10));
			
			JPanel btn_ok_cancel = new JPanel();
			JButton addMember_btn_OK = new JButton("È®ÀÎ");
			JButton addMember_btn_CANCEL = new JButton("Ãë¼Ò");
			btn_ok_cancel.add(addMember_btn_OK);
			btn_ok_cancel.add(addMember_btn_CANCEL);
			
			add(member_pnl);
			add(member_pnl2);
			add(btn_ok_cancel);
			
			
			addMember_btn_OK.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					addMember();
				}
			});
			
			addMember_btn_CANCEL.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});

		
			setBounds(700, 400, 600, 200);
			setVisible(true);
		}
		
		public addMemberDialog(int mno, String mname, String mphone, String mdate, int mpay, int sno) {
			setTitle("Á÷¿ø ¼öÁ¤");
			setLayout(new GridLayout(3, 0));
			
			JPanel member_pnl = new JPanel();
			member_pnl.add(new JLabel("Á¡Æ÷ ¹øÈ£"));
			member_pnl.add(sno_tf = new JTextField(10));
			sno_tf.setText(sno+"");
			sno_tf.setEditable(false);

			member_pnl.add(new JLabel("Á÷¿ø ¹øÈ£"));
			member_pnl.add(mno_tf = new JTextField(10));
			mno_tf.setText(mno+"");
			mno_tf.setEditable(false);
			
			member_pnl.add(new JLabel("ÀÌ¸§"));
			member_pnl.add(mname_tf = new JTextField(10));
			mname_tf.setText(mname);
			
			JPanel member_pnl2 = new JPanel();
			member_pnl2.add(new JLabel("ÀüÈ­¹øÈ£"));
			member_pnl2.add(mphone_tf = new JTextField(10));
			mphone_tf.setText(mphone);
			
			member_pnl2.add(new JLabel("ÀÔ»çÀÏ"));
			member_pnl2.add(mdate_tf = new JTextField(10));
			mdate_tf.setText(mdate);
			
			member_pnl2.add(new JLabel("¿ù±Þ"));
			member_pnl2.add(mpay_tf = new JTextField(10));
			mpay_tf.setText(mpay+"");
			
			JPanel btn_ok_cancel = new JPanel();
			JButton updateMember_btn_OK = new JButton("È®ÀÎ");
			JButton updateMember_btn_CANCEL = new JButton("Ãë¼Ò");
			btn_ok_cancel.add(updateMember_btn_OK);
			btn_ok_cancel.add(updateMember_btn_CANCEL);
			
			add(member_pnl);
			add(member_pnl2);
			add(btn_ok_cancel);
			
			
			updateMember_btn_OK.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					modifyMember();
					setVisible(false);
				}
			});
			
			updateMember_btn_CANCEL.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});

		
			setBounds(700, 400, 600, 200);
			setVisible(true);
		
		}
		
		public void addMember() {
			//À¯È¿¼º °Ë»ç
			String snoTemp=sno_tf.getText();
			
			if(snoTemp.equals("")) {//ÀÔ·Â°ªÀÌ ¾ø´Â °æ¿ì
				JOptionPane.showMessageDialog(this, "Á¡Æ÷ ¹øÈ£¸¦ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
				sno_tf.requestFocus();
				return;
			}
			
			int sno=Integer.parseInt(snoTemp);
			
			
			String mnoTemp=mno_tf.getText();
			
			if(mnoTemp.equals("")) {//ÀÔ·Â°ªÀÌ ¾ø´Â °æ¿ì
				JOptionPane.showMessageDialog(this, "Á÷¿ø ¹øÈ£¸¦ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
				mno_tf.requestFocus();
				return;
			}
			
			String mnoReg="\\d{4}";//Á¤±ÔÇ¥Çö½Ä
			if(!Pattern.matches(mnoReg, mnoTemp)) {//Á¤±ÔÇ¥Çö½Ä°ú ÀÔ·Â°ªÀÇ Çü½ÄÀÌ ´Ù¸¥ °æ¿ì
				JOptionPane.showMessageDialog(this, "Á÷¿ø ¹øÈ£´Â 4ÀÚ¸®ÀÇ ¼ýÀÚ·Î¸¸ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
				mno_tf.requestFocus();
				return;
			}
			
			int mno=Integer.parseInt(mnoTemp);
			
			if(MemberDAO.getDAO().selectMno(mno)!=null) {
				JOptionPane.showMessageDialog(this, "ÀÌ¹Ì »ç¿ëÁßÀÎ Á÷¿ø ¹øÈ£ÀÔ´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
				mno_tf.requestFocus();
				return;
			}
			
			String mname=mname_tf.getText();
			
			if(mname.equals("")) {//ÀÔ·Â°ªÀÌ ¾ø´Â °æ¿ì
				JOptionPane.showMessageDialog(this, "Á÷¿ø ÀÌ¸§À» ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
				mname_tf.requestFocus();
				return;
			}
			
			String mnameReg="[°¡-ÆR]{2,7}";//Á¤±ÔÇ¥Çö½Ä
			if(!Pattern.matches(mnameReg, mname)) {//Á¤±ÔÇ¥Çö½Ä°ú ÀÔ·Â°ªÀÇ Çü½ÄÀÌ ´Ù¸¥ °æ¿ì
				JOptionPane.showMessageDialog(this, "Á÷¿ø ÀÌ¸§Àº 2~5 ¹üÀ§ÀÇ ÇÑ±Û·Î ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
				mname_tf.requestFocus();
				return;
			}
			
			String mphone=mphone_tf.getText();
			
			if(mphone.equals("")) {//ÀÔ·Â°ªÀÌ ¾ø´Â °æ¿ì
				JOptionPane.showMessageDialog(this, "ÀüÈ­¹øÈ£¸¦ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
				mphone_tf.requestFocus();
				return;
			}
			
			String mphoneReg="(01[016789])-\\d{3,4}-\\d{4}";//Á¤±ÔÇ¥Çö½Ä
			if(!Pattern.matches(mphoneReg, mphone)) {//Á¤±ÔÇ¥Çö½Ä°ú ÀÔ·Â°ªÀÇ Çü½ÄÀÌ ´Ù¸¥ °æ¿ì
				JOptionPane.showMessageDialog(this, "ÀüÈ­¹øÈ£¸¦ Çü½Ä¿¡ ¸Â°Ô ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
				mphone_tf.requestFocus();
				return;
			}
			
			String mdate=mdate_tf.getText();
			
			if(mdate.equals("")) {//ÀÔ·Â°ªÀÌ ¾ø´Â °æ¿ì
				JOptionPane.showMessageDialog(this, "ÀÔ»çÀÏÀ» ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
				mdate_tf.requestFocus();
				return;
			}
			
			String mdateReg="(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";//Á¤±ÔÇ¥Çö½Ä
			if(!Pattern.matches(mdateReg, mdate)) {//Á¤±ÔÇ¥Çö½Ä°ú ÀÔ·Â°ªÀÇ Çü½ÄÀÌ ´Ù¸¥ °æ¿ì
				JOptionPane.showMessageDialog(this, "ÀÔ»çÀÏÀ» ³¯Â¥ Çü½Ä¿¡ ¸Â°Ô ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
				mdate_tf.requestFocus();
				return;
			}
			
			String mpayTemp=mpay_tf.getText();
			
			if(mpayTemp.equals("")) {//ÀÔ·Â°ªÀÌ ¾ø´Â °æ¿ì
				JOptionPane.showMessageDialog(this, "¿ù±ÞÀ» ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
				mpay_tf.requestFocus();
				return;
			}
			
//			String mpayReg="\\d";//Á¤±ÔÇ¥Çö½Ä
//			if(!Pattern.matches(mpayReg, mpayTemp)) {//Á¤±ÔÇ¥Çö½Ä°ú ÀÔ·Â°ªÀÇ Çü½ÄÀÌ ´Ù¸¥ °æ¿ì
//				JOptionPane.showMessageDialog(this, "¿ù±ÞÀº ¼öÄ¡·Î¸¸ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
//				mpay_tf.requestFocus();
//				return;
//			}
			
			int mpay=Integer.parseInt(mpayTemp);

			
			
			//DTO ÀÎ½ºÅÏ½º¸¦ »ý¼ºÇÏ°í ÄÄÆÛ³ÍÆ®ÀÇ ÀÔ·Â°ªÀ¸·Î ÇÊµå°ª º¯°æ
			MemberDTO member=new MemberDTO();
			member.setMno(mno);
			member.setMname(mname);
			member.setMphone(mphone);
			member.setMdate(mdate);
			member.setMpay(mpay);
			member.setSno(sno);

			int rows=MemberDAO.getDAO().insertMember(member);
			
			JOptionPane.showMessageDialog(this, rows+"¸íÀÇ Á÷¿ø Á¤º¸¸¦ ÀúÀåÇÏ¿´½À´Ï´Ù.");
			
			
			
			displayMember();
			
			setVisible(false);
		}
		
	}
	
	public void displayStore() {
		List<StoreDTO> storeList=StoreDAO.getDAO().selectStoreList();
		
		if(storeList.isEmpty()) {
			JOptionPane.showMessageDialog(this, "ÀúÀåµÈ Á¡Æ÷ Á¤º¸°¡ ¾ø½À´Ï´Ù.");
			return;
		}
		
		DefaultTableModel model=(DefaultTableModel)storeTable.getModel();

		for(int i=model.getRowCount();i>0;i--) {
			model.removeRow(0);
		}
		
		for(StoreDTO store:storeList) {
			Vector<Object> rowData=new Vector<Object>();
			rowData.add(store.getSno());
			rowData.add(store.getSname());
			rowData.add(store.getSphone());

			
			model.addRow(rowData);
		}
		
		storeSetEnable(1);
		initSearchTF();
		sno_tf.requestFocus();
	}
	
	public void displayMember() {
		List<MemberDTO> memberList=MemberDAO.getDAO().selectMemberList();
		
		if(memberList.isEmpty()) {
			JOptionPane.showMessageDialog(this, "ÀúÀåµÈ Á÷¿ø Á¤º¸°¡ ¾ø½À´Ï´Ù.");
			return;
		}
		
		DefaultTableModel model=(DefaultTableModel)memberTable.getModel();

		for(int i=model.getRowCount();i>0;i--) {
			model.removeRow(0);
		}
		
		for(MemberDTO member:memberList) {
			Vector<Object> rowData=new Vector<Object>();
			rowData.add(member.getMno());
			rowData.add(member.getMname());
			rowData.add(member.getMphone());
			rowData.add(member.getMdate());
			rowData.add(member.getMpay());
			rowData.add(member.getSno());
			
			model.addRow(rowData);
		}
		
		memberSetEnable(1);
		initSearchTF();
		mno_tf.requestFocus();
	}
	
	
//	public void displayMember() {
//		int row=storeTable.getSelectedRow();
//		int sno=(int) storeTable.getValueAt(row, 0);
//		
//		List<MemberDTO> memberList=MemberDAO.getDAO().selectSnoMemberList(sno);
//		
//		if(memberList.isEmpty()) {
//			JOptionPane.showMessageDialog(this, "ÀúÀåµÈ Á÷¿ø Á¤º¸°¡ ¾ø½À´Ï´Ù.");
//			return;
//		}
//		
//		DefaultTableModel model=(DefaultTableModel)memberTable.getModel();
//
//		for(int i=model.getRowCount();i>0;i--) {
//			model.removeRow(0);
//		}
//		
//		for(MemberDTO member:memberList) {
//			Vector<Object> rowData=new Vector<Object>();
//			rowData.add(member.getMno());
//			rowData.add(member.getMname());
//			rowData.add(member.getMphone());
//			rowData.add(member.getMdate());
//			rowData.add(member.getMpay());
//			rowData.add(member.getSno());
//			
//			model.addRow(rowData);
//		}
//		
//		memberSetEditable(1);
//	}
	
	public void removeStore() {
		int row = storeTable.getSelectedRow();
		int cloumn = 0;
		
		
		int sno=(int) storeTable.getValueAt(row, cloumn);
		
		int rows=StoreDAO.getDAO().deleteStore(sno);
		
		
		JOptionPane.showMessageDialog((Component)null, "¼±ÅÃÇÑ Á¡Æ÷ Á¤º¸¸¦ »èÁ¦ÇÏ½Ã°Ú½À´Ï±î?", "Á¡Æ÷ Á¤º¸ »èÁ¦", JOptionPane.QUESTION_MESSAGE);
		JOptionPane.showMessageDialog(this, rows+"°³ÀÇ Á¡Æ÷ Á¤º¸¸¦ »èÁ¦ÇÏ¿´½À´Ï´Ù.");
		
		displayStore();
		
	}
	
	public void removeMember() {
		int row = memberTable.getSelectedRow();
		int cloumn = 0;
		
		
		int mno=(int) memberTable.getValueAt(row, cloumn);
		
		int rows=MemberDAO.getDAO().deleteMember(mno);
		
		
		JOptionPane.showMessageDialog((Component)null, "¼±ÅÃÇÑ Á÷¿ø Á¤º¸¸¦ »èÁ¦ÇÏ½Ã°Ú½À´Ï±î?", "Á÷¿ø Á¤º¸ »èÁ¦", JOptionPane.QUESTION_MESSAGE);
		JOptionPane.showMessageDialog(this, rows+"¸íÀÇ Á÷¿ø Á¤º¸¸¦ »èÁ¦ÇÏ¿´½À´Ï´Ù.");
		
		displayMember();
	
	}
	
	public void updateStore() {
		int row = storeTable.getSelectedRow();
		int sno=(int) storeTable.getValueAt(row, 0);
		String sname=(String) storeTable.getValueAt(row, 1);
		String sphone=(String) storeTable.getValueAt(row, 2);
		
		new addStoreDialog(sno, sname, sphone);
	}
	
	
	public void modifyStore() {
		//À¯È¿¼º °Ë»ç - sno °Ë»ç ÇÊ¿ä X
		int sno=Integer.parseInt(sno_tf.getText());
		
		String sname=sname_tf.getText();
		
		if(sname.equals("")) {//ÀÔ·Â°ªÀÌ ¾ø´Â °æ¿ì
			JOptionPane.showMessageDialog(this, "Á¡Æ÷ ÀÌ¸§À» ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			sname_tf.requestFocus();//ÀÔ·ÂÃÐÁ¡À» ÀÌµ¿ÇÏ´Â ¸Þ¼Òµå
			return;
		}
		
		
		String sphone=sphone_tf.getText();
		
		if(sphone.equals("")) {//ÀÔ·Â°ªÀÌ ¾ø´Â °æ¿ì
			JOptionPane.showMessageDialog(this, "ÀüÈ­¹øÈ£¸¦ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			sphone_tf.requestFocus();//ÀÔ·ÂÃÐÁ¡À» ÀÌµ¿ÇÏ´Â ¸Þ¼Òµå
			return;
		}
		
		String sphoneReg="0\\d{1,2}-\\d{3,4}-\\d{4}";//Á¤±ÔÇ¥Çö½Ä
		if(!Pattern.matches(sphoneReg, sphone)) {//Á¤±ÔÇ¥Çö½Ä°ú ÀÔ·Â°ªÀÇ Çü½ÄÀÌ ´Ù¸¥ °æ¿ì
			JOptionPane.showMessageDialog(this, "ÀüÈ­¹øÈ£¸¦ Çü½Ä¿¡ ¸Â°Ô ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			sphone_tf.requestFocus();
			return;
		}
		
		StoreDTO store=new StoreDTO();
		store.setSno(sno);
		store.setSname(sname);
		store.setSphone(sphone);

		int rows=StoreDAO.getDAO().updateStore(store);
		
		JOptionPane.showMessageDialog(this, rows+"°³ÀÇ Á¡Æ÷ Á¤º¸¸¦ º¯°æÇÏ¿´½À´Ï´Ù.");
		displayStore();
		
		
	}
	
	public void updateMember() {
		int row = memberTable.getSelectedRow();
		
		int mno = (int) memberTable.getValueAt(row, 0);
		String mname = (String) memberTable.getValueAt(row, 1);
		String mphone = (String) memberTable.getValueAt(row, 2);
		String mdate = (String) memberTable.getValueAt(row, 3);
		int mpay = (int)memberTable.getValueAt(row, 4);
		int sno = (int)memberTable.getValueAt(row, 5);
		
		new addMemberDialog(mno, mname, mphone, mdate, mpay, sno);
	}
	
	public void modifyMember() {
		//À¯È¿¼º °Ë»ç - sno°ú mnoÀº °Ë»ç ÇÊ¿ä X
		int mno=Integer.parseInt(mno_tf.getText());
		
		String mname=mname_tf.getText();
		
		if(mname.equals("")) {//ÀÔ·Â°ªÀÌ ¾ø´Â °æ¿ì
			JOptionPane.showMessageDialog(this, "Á÷¿ø ÀÌ¸§À» ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			mname_tf.requestFocus();
			return;
		}
		
		String mnameReg="[°¡-ÆR]{2,7}";//Á¤±ÔÇ¥Çö½Ä
		if(!Pattern.matches(mnameReg, mname)) {//Á¤±ÔÇ¥Çö½Ä°ú ÀÔ·Â°ªÀÇ Çü½ÄÀÌ ´Ù¸¥ °æ¿ì
			JOptionPane.showMessageDialog(this, "Á÷¿ø ÀÌ¸§Àº 2~5 ¹üÀ§ÀÇ ÇÑ±Û·Î ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			mname_tf.requestFocus();
			return;
		}
		
		String mphone=mphone_tf.getText();
		
		if(mphone.equals("")) {//ÀÔ·Â°ªÀÌ ¾ø´Â °æ¿ì
			JOptionPane.showMessageDialog(this, "ÀüÈ­¹øÈ£¸¦ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			mphone_tf.requestFocus();
			return;
		}
		
		String mphoneReg="(01[016789])-\\d{3,4}-\\d{4}";//Á¤±ÔÇ¥Çö½Ä
		if(!Pattern.matches(mphoneReg, mphone)) {//Á¤±ÔÇ¥Çö½Ä°ú ÀÔ·Â°ªÀÇ Çü½ÄÀÌ ´Ù¸¥ °æ¿ì
			JOptionPane.showMessageDialog(this, "ÀüÈ­¹øÈ£¸¦ Çü½Ä¿¡ ¸Â°Ô ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			mphone_tf.requestFocus();
			return;
		}
		
		String mdate=mdate_tf.getText();
		
		if(mdate.equals("")) {//ÀÔ·Â°ªÀÌ ¾ø´Â °æ¿ì
			JOptionPane.showMessageDialog(this, "ÀÔ»çÀÏÀ» ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			mdate_tf.requestFocus();
			return;
		}
		
		String mdateReg="(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";//Á¤±ÔÇ¥Çö½Ä
		if(!Pattern.matches(mdateReg, mdate)) {//Á¤±ÔÇ¥Çö½Ä°ú ÀÔ·Â°ªÀÇ Çü½ÄÀÌ ´Ù¸¥ °æ¿ì
			JOptionPane.showMessageDialog(this, "ÀÔ»çÀÏÀ» ³¯Â¥ Çü½Ä¿¡ ¸Â°Ô ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			mdate_tf.requestFocus();
			return;
		}
		
		String mpayTemp=mpay_tf.getText();
		
		if(mpayTemp.equals("")) {//ÀÔ·Â°ªÀÌ ¾ø´Â °æ¿ì
			JOptionPane.showMessageDialog(this, "¿ù±ÞÀ» ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			mpay_tf.requestFocus();
			return;
		}
		
//		String mpayReg="\\d";//Á¤±ÔÇ¥Çö½Ä
//		if(!Pattern.matches(mpayReg, mpayTemp)) {//Á¤±ÔÇ¥Çö½Ä°ú ÀÔ·Â°ªÀÇ Çü½ÄÀÌ ´Ù¸¥ °æ¿ì
//			JOptionPane.showMessageDialog(this, "¿ù±ÞÀº ¼öÄ¡·Î¸¸ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
//			mpay_tf.requestFocus();
//			return;
//		}
		
		int mpay=Integer.parseInt(mpayTemp);
		
		int sno=Integer.parseInt(sno_tf.getText());
		
		MemberDTO member=new MemberDTO();
		member.setMno(mno);
		member.setMname(mname);
		member.setMphone(mphone);
		member.setMdate(mdate);
		member.setMpay(mpay);
		member.setSno(sno);

		int rows=MemberDAO.getDAO().updateMember(member);
		
		
		JOptionPane.showMessageDialog(this, rows+"¸íÀÇ Á÷¿ø Á¤º¸¸¦ º¯°æÇÏ¿´½À´Ï´Ù.");
		displayMember();
	}
	
	public void searchSno() {
		String snoTemp=sno_tf.getText();
		
		if(snoTemp.equals("")) {
			JOptionPane.showMessageDialog(this, "Á¡Æ÷ ¹øÈ£¸¦ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			sno_tf.requestFocus();
			return;
		}
		
		String snoReg="\\d{2}";
		if(!Pattern.matches(snoReg, snoTemp)) {
			JOptionPane.showMessageDialog(this, "Á¡Æ÷ ¹øÈ£´Â 2ÀÚ¸®ÀÇ ¼ýÀÚ·Î¸¸ ÀÔ·Â °¡´ÉÇÕ´Ï´Ù.");
			sno_tf.requestFocus();
			return;
		}
		
		int sno=Integer.parseInt(snoTemp);
		
		StoreDTO store = StoreDAO.getDAO().selectSno(sno);
		
		if(store==null) {
			JOptionPane.showMessageDialog(this, "°Ë»öµÈ Á¡Æ÷ Á¤º¸°¡ ¾ø½À´Ï´Ù.");
			mno_tf.requestFocus();
			mno_tf.setText("");//JTextField ÄÄÆÛ³ÍÆ® ÃÊ±âÈ­
			return;
		}
		DefaultTableModel model=(DefaultTableModel)storeTable.getModel();
		
		for(int i=model.getRowCount();i>0;i--) {
			model.removeRow(0);
		}
		
		Vector<Object> rowData=new Vector<Object>();
		rowData.add(store.getSno());
		rowData.add(store.getSname());
		rowData.add(store.getSphone());
		
		model.addRow(rowData);
		
		storeSetEnable(3);
	}
	
	public void searchSname() {
		String sname=sname_tf.getText();
		
		if(sname.equals("")) {
			JOptionPane.showMessageDialog(this, "Á¡Æ÷ ÀÌ¸§À» ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			sname_tf.requestFocus();
			return;
		}
		
		StoreDTO store = StoreDAO.getDAO().selectSname(sname);
		
		if(store==null) {
			JOptionPane.showMessageDialog(this, "°Ë»öµÈ Á¡Æ÷ Á¤º¸°¡ ¾ø½À´Ï´Ù.");
			sname_tf.requestFocus();
			sname_tf.setText("");//JTextField ÄÄÆÛ³ÍÆ® ÃÊ±âÈ­
			return;
		}
		DefaultTableModel model=(DefaultTableModel)storeTable.getModel();
		
		for(int i=model.getRowCount();i>0;i--) {
			model.removeRow(0);
		}
		
		Vector<Object> rowData=new Vector<Object>();
		rowData.add(store.getSno());
		rowData.add(store.getSname());
		rowData.add(store.getSphone());
		
		model.addRow(rowData);
		
		storeSetEnable(3);
	}
	
	public void searchMno() {
		String mnoTemp=mno_tf.getText();
		
		if(mnoTemp.equals("")) {
			JOptionPane.showMessageDialog(this, "Á÷¿ø ¹øÈ£¸¦ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			mno_tf.requestFocus();
			return;
		}
		
		String mnoReg="\\d{4}";
		if(!Pattern.matches(mnoReg, mnoTemp)) {
			JOptionPane.showMessageDialog(this, "Á÷¿ø ¹øÈ£´Â 4ÀÚ¸®ÀÇ ¼ýÀÚ·Î¸¸ ÀÔ·Â °¡´ÉÇÕ´Ï´Ù.");
			mno_tf.requestFocus();
			return;
		}
		
		int mno=Integer.parseInt(mnoTemp);
		
		MemberDTO member = MemberDAO.getDAO().selectMno(mno);
		
		if(member==null) {
			JOptionPane.showMessageDialog(this, "°Ë»öµÈ Á÷¿ø Á¤º¸°¡ ¾ø½À´Ï´Ù.");
			mno_tf.requestFocus();
			mno_tf.setText("");//JTextField ÄÄÆÛ³ÍÆ® ÃÊ±âÈ­
			return;
		}
		DefaultTableModel model=(DefaultTableModel)memberTable.getModel();
		
		for(int i=model.getRowCount();i>0;i--) {
			model.removeRow(0);
		}
		
		Vector<Object> rowData=new Vector<Object>();
		rowData.add(member.getMno());
		rowData.add(member.getMname());
		rowData.add(member.getMphone());
		rowData.add(member.getMdate());
		rowData.add(member.getMpay());
		rowData.add(member.getSno());
		
		model.addRow(rowData);
		
		memberSetEnable(3);
	}
	
	public void searchMname() {
		String mname=mname_tf.getText();
		
		if(mname.equals("")) {
			JOptionPane.showMessageDialog(this, "Á÷¿ø ÀÌ¸§À» ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			mname_tf.requestFocus();
			return;
		}
		
		MemberDTO member = MemberDAO.getDAO().selectMname(mname);
		
		if(member==null) {
			JOptionPane.showMessageDialog(this, "°Ë»öµÈ Á÷¿ø Á¤º¸°¡ ¾ø½À´Ï´Ù.");
			mname_tf.requestFocus();
			mname_tf.setText("");//JTextField ÄÄÆÛ³ÍÆ® ÃÊ±âÈ­
			return;
		}
		DefaultTableModel model=(DefaultTableModel)memberTable.getModel();
		
		for(int i=model.getRowCount();i>0;i--) {
			model.removeRow(0);
		}
		
		Vector<Object> rowData=new Vector<Object>();
		rowData.add(member.getMno());
		rowData.add(member.getMname());
		rowData.add(member.getMphone());
		rowData.add(member.getMdate());
		rowData.add(member.getMpay());
		rowData.add(member.getSno());
		
		model.addRow(rowData);
		
		memberSetEnable(3);
	}
}