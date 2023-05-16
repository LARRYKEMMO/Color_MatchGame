import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SplashScreen extends JFrame {

	private JPanel contentPane;
	public static JFrame frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new SplashScreen();
					frame.setVisible(true);
					MatchGame.OpenSound();  // Calls the Opening sound function
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SplashScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 150, 710, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MatchGame.ClickSound();
				frame.dispose();
				MatchGame.main(null);
			}
		});
		btnStart.setForeground(Color.RED);
		btnStart.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnStart.setBounds(304, 480, 85, 21);
		contentPane.add(btnStart);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MatchGame.ClickSound();
				frame.dispose();
			}
		});
		btnQuit.setForeground(Color.RED);
		btnQuit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnQuit.setBounds(304, 525, 85, 21);
		contentPane.add(btnQuit);
		
		JLabel lblBackGround = new JLabel(Assets.SplashScreen);
		lblBackGround.setBounds(0, -17, 707, 602);
		contentPane.add(lblBackGround);
		
		
	}
}
