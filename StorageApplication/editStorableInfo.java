import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class editStorableInfo extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField typeTextField;
	private JTextField locationTextField;
	private JTextField quantityTextField;
	private JLabel typeLabel;
	private JLabel locationLabel;
	private JLabel quantityLabel;

	/**
	 * Create the frame.
	 */
	public editStorableInfo(Storable item) {
								
		this.setVisible(true);
		Image AppIcon = new ImageIcon(this.getClass().getResource("/AppIcon.png")).getImage();
		setIconImage(AppIcon);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton editBtn = new JButton("\u0391\u03C0\u03BF\u03B8\u03AE\u03BA\u03B5\u03C5\u03C3\u03B7 \u0391\u03BB\u03BB\u03B1\u03B3\u03CE\u03BD");
		editBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				updateStorable(item);
			}
		});
		editBtn.setBounds(32, 214, 162, 23);
		contentPane.add(editBtn);
		
		JButton cancelBtn = new JButton("\u0391\u03BA\u03CD\u03C1\u03C9\u03C3\u03B7");
		cancelBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				dispose();
			}
		});
		cancelBtn.setBounds(236, 214, 162, 23);
		contentPane.add(cancelBtn);
		
		typeTextField = new JTextField();
		typeTextField.setEditable(true);
		typeTextField.setBounds(140, 64, 171, 20);
		contentPane.add(typeTextField);
		typeTextField.setColumns(10);
		
		locationTextField = new JTextField();
		locationTextField.setEditable(true);
		locationTextField.setBounds(140, 95, 171, 20);
		contentPane.add(locationTextField);
		locationTextField.setColumns(10);
		
		quantityTextField = new JTextField();
		quantityTextField.setEditable(true);
		quantityTextField.setBounds(140, 126, 171, 20);
		contentPane.add(quantityTextField);
		quantityTextField.setColumns(10);
		
		typeLabel = new JLabel("\u0395\u03AF\u03B4\u03BF\u03C2 :");
		typeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		typeLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		typeLabel.setForeground(Color.WHITE);
		typeLabel.setBounds(54, 63, 78, 20);
		contentPane.add(typeLabel);
		
		locationLabel = new JLabel("\u0398\u03AD\u03C3\u03B7 :");
		locationLabel.setHorizontalAlignment(SwingConstants.LEFT);
		locationLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		locationLabel.setForeground(Color.WHITE);
		locationLabel.setBounds(54, 96, 78, 17);
		contentPane.add(locationLabel);
		
		quantityLabel = new JLabel("\u03A0\u03BF\u03C3\u03CC\u03C4\u03B7\u03C4\u03B1:");
		quantityLabel.setHorizontalAlignment(SwingConstants.LEFT);
		quantityLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		quantityLabel.setForeground(Color.WHITE);
		quantityLabel.setBounds(54, 127, 80, 17);
		contentPane.add(quantityLabel);
		
		JLabel windowInfoLabel = new JLabel("\u03A0\u03BB\u03B7\u03C1\u03BF\u03C6\u03BF\u03C1\u03AF\u03B5\u03C2 \u03B1\u03BD\u03C4\u03B9\u03BA\u03B5\u03B9\u03BC\u03AD\u03BD\u03BF\u03C5");
		windowInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		windowInfoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		windowInfoLabel.setForeground(Color.WHITE);
		windowInfoLabel.setBounds(119, 21, 207, 20);
		contentPane.add(windowInfoLabel);
		
		ShowItemInfo(item);		
	}
	
	public void ShowItemInfo(Storable item){
				typeTextField.setText(item.getType());
				locationTextField.setText(item.getLocation());
				quantityTextField.setText(item.getQuantity());
	}
	
	public void updateStorable(Storable item){
		
		ArrayList<Storable> allItems = DBReadWrite.dbRead();
		String itemType = typeTextField.getText();
		String itemLocation = locationTextField.getText();
		String itemQuantity = quantityTextField.getText();
		
		int index = -1;
		for(Storable anItem : allItems){
			index++;
			if(anItem.getType().equals(item.getType()))
			{
				item.setType(itemType);
				item.setLocation(itemLocation);
				item.setQuantity(itemQuantity);
				allItems.set(index, item);
				DBReadWrite.dbWrite(allItems);
				dispose();
				JOptionPane.showMessageDialog(null, "Επιτυχής Αλλαγή στοιχείων!");
			break;
			}
		}
	}
}
