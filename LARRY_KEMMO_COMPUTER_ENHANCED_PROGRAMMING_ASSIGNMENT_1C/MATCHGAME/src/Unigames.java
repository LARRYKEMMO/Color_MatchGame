import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class Unigames extends JFrame implements ActionListener{

	private JPanel contentPane;
	private static final Integer FRAMETIME = 5000;			// Data member declaration (FRAMETIME)
	
	private Timer tickTock = new Timer(FRAMETIME,this);		// Time declaration and instantiation (tickTock) based on the frame time
	
	private static  int ScreenCounter = 0;
	
	private static JLabel lblBackground;
	
	private static JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new Unigames();
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
	public Unigames() {
		tickTock.start();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 610, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 lblBackground = new JLabel(Assets.Load1);
		lblBackground.setBounds(0, -26, 610, 399);
		contentPane.add(lblBackground);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ScreenCounter ++;
		
		if(ScreenCounter == 1) {
			lblBackground.setIcon(Assets.Load2);
		}
		else if(ScreenCounter == 2) {
			lblBackground.setIcon(Assets.Load3);
		}
		else if(ScreenCounter == 3) {
			lblBackground.setIcon(Assets.Load4);
		}
		else if(ScreenCounter == 4) {
			lblBackground.setIcon(Assets.Load5);
		}
		else if(ScreenCounter == 5) {
			lblBackground.setIcon(Assets.Load5);
			tickTock.stop();
			frame.dispose();
			SplashScreen.main(null);
		}
	}

}
