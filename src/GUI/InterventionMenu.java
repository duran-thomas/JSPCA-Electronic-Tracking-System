package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class InterventionMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterventionMenu window = new InterventionMenu();
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
	public InterventionMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblInterventionType = new JLabel("Intervention Type");
		lblInterventionType.setFont(new Font("Lucida Bright", Font.BOLD, 20));
		lblInterventionType.setHorizontalAlignment(SwingConstants.CENTER);
		lblInterventionType.setBounds(131, 12, 182, 24);
		frame.getContentPane().add(lblInterventionType);
		
		JButton btnAppointment = new JButton("Appointment");
		btnAppointment.setBounds(152, 95, 143, 25);
		frame.getContentPane().add(btnAppointment);
		
		JButton btnRemoval = new JButton("Removal");
		btnRemoval.setBounds(152, 149, 143, 25);
		frame.getContentPane().add(btnRemoval);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(183, 217, 77, 25);
		frame.getContentPane().add(btnBack);
	}
}
