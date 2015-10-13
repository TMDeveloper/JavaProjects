import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Image;
import java.awt.Color;

import javax.swing.ImageIcon;


import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.SwingConstants;



public class mainGUI {

	private JFrame frame;
	private JTextField SearchTextField;
	JPanel searchPanel = new JPanel();
	JPanel buttonsPanel = new JPanel();
	JPanel searchResultsPanel = new JPanel();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainGUI window = new mainGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mainGUI() {
		initialize();
	}
		
	private void initialize() {
				
		DefaultListModel<String> modelForItems = new DefaultListModel<String>();
		JList<String> itemList = new JList<String>(modelForItems);
		
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 12));
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBackground(Color.GRAY);
		frame.getContentPane().setForeground(new Color(128, 128, 128));
		frame.setForeground(Color.GRAY);
		Image AppIcon = new ImageIcon(this.getClass().getResource("/AppIcon.png")).getImage();
		frame.setIconImage(AppIcon);
		frame.setTitle("\u03A0\u03C1\u03CC\u03B3\u03C1\u03B1\u03BC\u03BC\u03B1 \u0391\u03C0\u03BF\u03B8\u03AE\u03BA\u03B7\u03C2");
		frame.setBounds(100, 100, 602, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		searchPanel.setBackground(Color.LIGHT_GRAY);
		searchPanel.setForeground(Color.DARK_GRAY);
		searchPanel.setBounds(0, 0, 584, 86);
		frame.getContentPane().add(searchPanel);
		searchPanel.setLayout(null);
		
		SearchTextField = new JTextField();
		SearchTextField.setBounds(217, 55, 147, 20);
		searchPanel.add(SearchTextField);
		
		JButton showAllItems = new JButton("");
		showAllItems.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				File dir = new File("C:/StorageApplication/items.ser");
				if(dir.exists()){
					showAllStorables showStorage = new showAllStorables();
					showStorage.setVisible(true);
				}
				else{
					JOptionPane.showMessageDialog(null, "Δεν υπάρχουν εγγραφές!");
				}
			}		
		});
		Image search = new ImageIcon(this.getClass().getResource("/SearchIcon.png")).getImage();
		showAllItems.setIcon(new ImageIcon(search));
		showAllItems.setBounds(392, 55, 21, 20);
		searchPanel.add(showAllItems);
		
		JLabel searchLabel = new JLabel("\u0391\u03BD\u03B1\u03B6\u03AE\u03C4\u03B7\u03C3\u03B7 \u0395\u03AF\u03B4\u03BF\u03C5\u03C2");
		searchLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		searchLabel.setBounds(235, 32, 119, 20);
		searchPanel.add(searchLabel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 584, 21);
		searchPanel.add(menuBar);
		
		JMenu menuFile = new JMenu("\u0391\u03C1\u03C7\u03B5\u03AF\u03BF");
		menuBar.add(menuFile);
		
		JMenuItem menuFileExit = new JMenuItem("\u0388\u03BE\u03BF\u03B4\u03BF\u03C2");
		menuFileExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		menuFile.add(menuFileExit);
		
		JMenu menuInfo = new JMenu("\u03A0\u03BB\u03B7\u03C1\u03BF\u03C6\u03BF\u03C1\u03AF\u03B5\u03C2");
		menuBar.add(menuInfo);
		
		JMenuItem menuInfoAppInfo = new JMenuItem("\u03A0\u03BB\u03B7\u03C1\u03BF\u03C6\u03BF\u03C1\u03AF\u03B5\u03C2 \u03B3\u03B9\u03B1 \u03C4\u03B7\u03BD \u03B5\u03C6\u03B1\u03C1\u03BC\u03BF\u03B3\u03AE");
		menuInfoAppInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				appInfo info = new appInfo();
				info.setVisible(true);
			}
		});
		menuInfo.add(menuInfoAppInfo);
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBackground(Color.LIGHT_GRAY);
		buttonsPanel.setForeground(Color.DARK_GRAY);
		buttonsPanel.setBounds(0, 308, 584, 103);
		frame.getContentPane().add(buttonsPanel);
		buttonsPanel.setLayout(null);
		
		JButton addBtn = new JButton("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7");
		addBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				addStorable aStorable = new addStorable();		
				aStorable.setVisible(true);
				
			}
		});
		addBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		addBtn.setBounds(53, 20, 101, 23);
		buttonsPanel.add(addBtn);
		
		JButton editBtn = new JButton("\u0395\u03C0\u03B5\u03BE\u03B5\u03C1\u03B3\u03B1\u03C3\u03AF\u03B1");
		editBtn.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent arg0) {
				ArrayList<Storable> allItems = DBReadWrite.dbRead();
				String item = (String) itemList.getSelectedValue();
				for(Storable anItem : allItems){
					String itemInfo = anItem.getType() + "   ΘΕΣΗ: " + anItem.getLocation() + "   ΠΟΣΟΤΗΤΑ: " + anItem.getQuantity();
						if(itemInfo.equals(item)){
							new editStorableInfo(anItem);
							break;
						}
				}
			}
		});
		editBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		editBtn.setBounds(230, 20, 126, 23);
		buttonsPanel.add(editBtn);
		
		JButton deleteBtn = new JButton("\u0394\u03B9\u03B1\u03B3\u03C1\u03B1\u03C6\u03AE");
		deleteBtn.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent arg0) {
				ArrayList<Storable> allItems = DBReadWrite.dbRead();
				String item = (String) itemList.getSelectedValue();
				for(Storable anItem : allItems){
					String itemInfo = anItem.getType() + "   ΘΕΣΗ: " + anItem.getLocation() + "   ΠΟΣΟΤΗΤΑ: " + anItem.getQuantity();
						if(itemInfo.equals(item)){
							allItems.remove(anItem);
							DBReadWrite.dbWrite(allItems);
							JOptionPane.showMessageDialog(null, "Επιτυχής διαγραφή!");
							modelForItems.removeElement(item);
							break;
						}
				}
			}
		});
		deleteBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		deleteBtn.setBounds(430, 20, 101, 23);
		buttonsPanel.add(deleteBtn);
		
		JLabel appBuildNum = new JLabel("\u0388\u03BA\u03B4\u03BF\u03C3\u03B7 1.0.1");
		appBuildNum.setVerticalAlignment(SwingConstants.BOTTOM);
		appBuildNum.setHorizontalAlignment(SwingConstants.CENTER);
		appBuildNum.setFont(new Font("Tahoma", Font.BOLD, 11));
		appBuildNum.setForeground(Color.WHITE);
		appBuildNum.setBounds(254, 80, 75, 23);
		buttonsPanel.add(appBuildNum);
		
		JLabel StorageApp = new JLabel("StorageApp");
		StorageApp.setHorizontalAlignment(SwingConstants.CENTER);
		StorageApp.setFont(new Font("Tahoma", Font.BOLD, 11));
		StorageApp.setForeground(Color.WHITE);
		StorageApp.setBounds(246, 69, 89, 23);
		buttonsPanel.add(StorageApp);
		
		JPanel searchResultsPanel = new JPanel();
		searchResultsPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		searchResultsPanel.setBackground(Color.GRAY);
		searchResultsPanel.setBounds(10, 84, 566, 205);
		frame.getContentPane().add(searchResultsPanel);
		searchResultsPanel.setLayout(null);
		
		
		itemList.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		itemList.setBounds(10, 10, 526, 184);
		itemList.setVisibleRowCount(10);
		JScrollPane scrollPane = new JScrollPane(itemList);
		scrollPane.setBounds(10, 10, 546, 184);
		searchResultsPanel.add(scrollPane);
		
			
		SearchTextField.getDocument().addDocumentListener(new DocumentListener(){		
			boolean NoResults = true;
			@Override
			public void changedUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
			}
			@Override
			public void insertUpdate(DocumentEvent e) {
				ArrayList<Storable> allItems = null;
				File dir = new File("C:/StorageApplication/items.ser");
				if(dir.exists()){
					allItems = DBReadWrite.dbRead();		
					modelForItems.removeAllElements();
					String searchText = SearchTextField.getText();
					for(Storable anItem : allItems){
						String item = anItem.getType();
						String location = anItem.getLocation();
						String quantity = anItem.getQuantity();
						if(item.startsWith(searchText)){
							modelForItems.addElement(item + "   ΘΕΣΗ: " + location + "   ΠΟΣΟΤΗΤΑ: " + quantity);
							NoResults = false;
						}
					}
						if(NoResults==true){
							modelForItems.addElement("Δεν βρέθηκαν αποτελέσματα");	
						}
						itemList.setModel(modelForItems);
				}
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				ArrayList<Storable> allItems = null;
				File dir = new File("C:/StorageApplication/items.ser");
				if(dir.exists()){
				allItems = DBReadWrite.dbRead();
				modelForItems.removeAllElements();
				String searchText = SearchTextField.getText();
					for(Storable anItem : allItems){
						String item = anItem.getType();
						if(item.startsWith(searchText) && searchText.length()>0){
							modelForItems.addElement(item);
							NoResults = false;
						}
					}
					if(NoResults==true){
						modelForItems.addElement("Δεν βρέθηκαν αποτελέσματα");	
					}
					itemList.setModel(modelForItems);
				}
			}
		});
	}
}
