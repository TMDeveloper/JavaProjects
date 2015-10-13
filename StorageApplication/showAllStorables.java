import java.awt.Image;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;

import java.awt.Color;

import javax.swing.border.MatteBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class showAllStorables extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public showAllStorables() {
		
		JList<String> itemsList = new JList<String>();
		DefaultListModel<String> modelForItems = new DefaultListModel<String>();
		
		ArrayList<Storable> allItems = DBReadWrite.dbRead();
		
		if(allItems.size()>0){
				for(Storable anItem : allItems){
					modelForItems.addElement(anItem.getType() + "   »≈”«: " + anItem.getLocation() + "   –œ”œ‘«‘¡: " + anItem.getQuantity());
				}
				itemsList.setModel(modelForItems);
		}
		Image AppIcon = new ImageIcon(this.getClass().getResource("/AppIcon.png")).getImage();
		setIconImage(AppIcon);
		setBounds(100, 100, 611, 407);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(Color.GRAY);
		panel.setBounds(10, 43, 575, 235);
		contentPane.add(panel);
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(10, 10, 555, 214);
		panel.add(scrollPane);
		
		
		itemsList.setVisibleRowCount(10);
		itemsList.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		scrollPane.setViewportView(itemsList);
				
		JLabel label = new JLabel("\u0395\u03B3\u03B3\u03C1\u03B1\u03C6\u03AD\u03C2 \u0391\u03C0\u03BF\u03B8\u03AE\u03BA\u03B7\u03C2");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(224, 11, 144, 16);
		contentPane.add(label);
		
		JButton buttonEdit = new JButton("\u0395\u03C0\u03B5\u03BE\u03B5\u03C1\u03B3\u03B1\u03C3\u03AF\u03B1");
		buttonEdit.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent arg0) {
				String item = (String) itemsList.getSelectedValue();
				for(Storable anItem : allItems){
					String itemInfo = anItem.getType() + "   »≈”«: " + anItem.getLocation() + "   –œ”œ‘«‘¡: " + anItem.getQuantity();
					if(itemInfo.equals(item)){
						new editStorableInfo(anItem);
						break;
					}
				}
			}
		});
		buttonEdit.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonEdit.setBounds(145, 305, 126, 30);
		contentPane.add(buttonEdit);
		
		JButton buttonDel = new JButton("\u0394\u03B9\u03B1\u03B3\u03C1\u03B1\u03C6\u03AE");
		buttonDel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent arg0) {
				String item = (String) itemsList.getSelectedValue();
				
				for(Storable anItem : allItems){
					String itemInfo = anItem.getType() + "   »≈”«: " + anItem.getLocation() + "   –œ”œ‘«‘¡: " + anItem.getQuantity();
						if(itemInfo.equals(item)){
							allItems.remove(anItem);
							DBReadWrite.dbWrite(allItems);
							JOptionPane.showMessageDialog(null, "≈ÈÙı˜ﬁÚ ‰È·„Ò·ˆﬁ!");
							refreshItemsList(itemsList);
							break;
						}
				}
			}
		});
		buttonDel.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonDel.setBounds(337, 305, 126, 30);
		contentPane.add(buttonDel);
		
		JButton reloadListBtn = new JButton("");
		Image reload = new ImageIcon(this.getClass().getResource("/Refresh-icon.png")).getImage();
		reloadListBtn.setIcon(new ImageIcon(reload));
		reloadListBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refreshItemsList(itemsList);
			}
		});
		reloadListBtn.setBounds(378, 11, 23, 21);
		contentPane.add(reloadListBtn);
	}
	@SuppressWarnings("unchecked")
	public void refreshItemsList(@SuppressWarnings("rawtypes") JList itemsList) {
		@SuppressWarnings("rawtypes")
		DefaultListModel modelForItems = new DefaultListModel();
		ArrayList<Storable> allItems = DBReadWrite.dbRead();
		
		if(allItems.size()>0){
				for(Storable anItem : allItems){
					modelForItems.addElement(anItem.getType() + "   »≈”«: " + anItem.getLocation() + "   –œ”œ‘«‘¡: " + anItem.getQuantity());
				}
				itemsList.setModel(modelForItems);
		}	
	}
}
