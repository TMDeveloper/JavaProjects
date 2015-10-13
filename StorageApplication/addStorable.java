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
import java.io.File;
import java.util.ArrayList;


public class addStorable extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField typeTextField;
	private JTextField locationTextField;
	private JTextField quantityTextField;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;

	/**
	 * Create the frame.
	 */
	public addStorable() {
		
		this.setVisible(true);
		Image AppIcon = new ImageIcon(this.getClass().getResource("/AppIcon.png")).getImage();
		setIconImage(AppIcon);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton saveBtn = new JButton("\u0391\u03C0\u03BF\u03B8\u03AE\u03BA\u03B5\u03C5\u03C3\u03B7");
		saveBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				ArrayList<Storable> items = new ArrayList<Storable>();
				File dir = new File("C:/StorageApplication/items.ser");
				if(dir.exists()){
				items = DBReadWrite.dbRead();
				}
				String itemType = typeTextField.getText();
				String itemLocation = locationTextField.getText();
				String itemQuantity = quantityTextField.getText();
				Storable item = new Storable(itemType, itemLocation, itemQuantity);
				items.add(item);
				DBReadWrite.dbWrite(items);
				dispose();
				JOptionPane.showMessageDialog(null, "Επιτυχής προσθήκη!");
			}
		});
		saveBtn.setBounds(54, 214, 140, 23);
		contentPane.add(saveBtn);
		
		JButton cancelBtn = new JButton("\u0391\u03BA\u03CD\u03C1\u03C9\u03C3\u03B7");
		cancelBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				dispose();
			}
		});
		cancelBtn.setBounds(236, 214, 140, 23);
		contentPane.add(cancelBtn);
		
		typeTextField = new JTextField();
		typeTextField.setBounds(140, 64, 171, 20);
		contentPane.add(typeTextField);
		typeTextField.setColumns(10);
		
		locationTextField = new JTextField();
		locationTextField.setBounds(140, 95, 171, 20);
		contentPane.add(locationTextField);
		locationTextField.setColumns(10);
		
		quantityTextField = new JTextField();
		quantityTextField.setBounds(140, 126, 171, 20);
		contentPane.add(quantityTextField);
		quantityTextField.setColumns(10);
		
		label = new JLabel("\u0395\u03AF\u03B4\u03BF\u03C2 :");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setForeground(Color.WHITE);
		label.setBounds(54, 63, 78, 20);
		contentPane.add(label);
		
		label_1 = new JLabel("\u0398\u03AD\u03C3\u03B7 :");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(54, 96, 78, 17);
		contentPane.add(label_1);
		
		label_2 = new JLabel("\u03A0\u03BF\u03C3\u03CC\u03C4\u03B7\u03C4\u03B1:");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(54, 127, 80, 17);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7 \u03C3\u03C4\u03B7\u03BD \u03B1\u03C0\u03BF\u03B8\u03AE\u03BA\u03B7");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(119, 21, 207, 20);
		contentPane.add(label_3);
	}
}
