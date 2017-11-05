package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WelcomeScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeScreen window = new WelcomeScreen();
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
	public WelcomeScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 450); 
		frame.getContentPane().setLayout(null);
		
		JLabel lblJspca = new JLabel("Jamaica Society for the Prevention of Cruelty to Animals");
		lblJspca.setFont(new Font("Lucida Bright", Font.BOLD, 18));
		lblJspca.setHorizontalAlignment(SwingConstants.CENTER);
		lblJspca.setBounds(12, 31, 576, 32);
		frame.getContentPane().add(lblJspca);
		
		JLabel lblVetClinic = new JLabel("Electronic Tracking And Registration System");
		lblVetClinic.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblVetClinic.setBounds(146, 85, 312, 32);
		frame.getContentPane().add(lblVetClinic);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setBounds(43, 299, 117, 25);
		frame.getContentPane().add(btnEnter);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setBounds(43, 358, 117, 25);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Background");
		lblNewLabel.setEnabled(false);
		lblNewLabel.setIcon(new ImageIcon("/home/kh40sx/workspace/JSPCA/assets/puppy.jpg"));
		lblNewLabel.setBounds(0, -31, 1115, 1041);
		frame.getContentPane().add(lblNewLabel);
	}
}
