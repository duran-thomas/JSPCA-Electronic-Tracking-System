package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RemovalReportMenu {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemovalReportMenu window = new RemovalReportMenu();
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
	public RemovalReportMenu() {
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
		
		JLabel lblVetClinic = new JLabel("Removal REquest");
		lblVetClinic.setFont(new Font("Lucida Bright", Font.BOLD, 20));
		lblVetClinic.setHorizontalAlignment(SwingConstants.CENTER);
		lblVetClinic.setBounds(175, 12, 124, 28);
		frame.getContentPane().add(lblVetClinic);
		
		JLabel lblHowWoudlYou = new JLabel("How Would You Like To Search?");
		lblHowWoudlYou.setBounds(12, 62, 243, 15);
		frame.getContentPane().add(lblHowWoudlYou);
		
		JButton btnByLocation = new JButton("By Location");
		btnByLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							SearchByAnimalRem window = new SearchByAnimalRem();
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnByLocation.setBounds(175, 99, 138, 25);
		frame.getContentPane().add(btnByLocation);
		
		JButton btnByAnimal = new JButton("By Animal");
		btnByAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							SearchByAnimalVet window = new SearchByAnimalVet();
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnByAnimal.setBounds(175, 138, 138, 25);
		frame.getContentPane().add(btnByAnimal);
		
		JButton btnByVisitDate = new JButton("By Removal Date");
		btnByVisitDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							SearchByDateRem window = new SearchByDateRem();
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnByVisitDate.setBounds(175, 180, 138, 25);
		frame.getContentPane().add(btnByVisitDate);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ReportMenu window = new ReportMenu();
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnBack.setBounds(12, 236, 67, 25);
		frame.getContentPane().add(btnBack);
	}
}
