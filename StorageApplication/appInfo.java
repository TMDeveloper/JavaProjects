import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;


public class appInfo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					appInfo frame = new appInfo();
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
	public appInfo() {
		Image AppIcon = new ImageIcon(this.getClass().getResource("/AppIcon.png")).getImage();
		setIconImage(AppIcon);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u0388\u03BA\u03B4\u03BF\u03C3\u03B7 1.0.1");
		label.setBounds(0, 82, 434, 41);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Developed by TMDeveloper");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_1.setBounds(0, 54, 434, 33);
		contentPane.add(label_1);
		
		JLabel lblOpenSourceProject = new JLabel("Simple Storage Application");
		lblOpenSourceProject.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpenSourceProject.setForeground(Color.BLACK);
		lblOpenSourceProject.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOpenSourceProject.setBounds(0, 201, 434, 22);
		contentPane.add(lblOpenSourceProject);
		
		JLabel label_2 = new JLabel("2015");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_2.setBounds(0, 222, 434, 17);
		contentPane.add(label_2);
	}

}
