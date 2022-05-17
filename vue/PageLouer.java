package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class PageLouer extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PageLouer frame = new PageLouer();
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
	public PageLouer() {
		
		
		
		setTitle("LouScoot");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 204));
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		//btnLouer.setPreferredSize(new Dimension(200, 90));
		
		
		
		
		JPanel grandPanel = new JPanel();
		grandPanel.setLayout(new BorderLayout());
		contentPane.add(grandPanel);
		
		
		
		JPanel petitPanel = new JPanel();
		petitPanel.setLayout(new BorderLayout(5, 5));
		grandPanel.add(petitPanel, BorderLayout.CENTER);
		petitPanel.setBackground(new Color(51, 153, 204));
		
		
		////////// panel du haut /////////
		JPanel panelHaut = new JPanel();
		panelHaut.setBackground(new Color(51, 51, 102));
		grandPanel.add(panelHaut, BorderLayout.NORTH);
		
		
		JLabel Titre = new JLabel("Louer un Scootert");
		Titre.setForeground(Color.WHITE);
		Titre.setFont(new Font("Lao MN", Font.PLAIN, 28));
		panelHaut.add(Titre);
		
		
		
		////////// panel de droite //////////
		JPanel panelDroite = new JPanel();
		panelDroite.setBackground(new Color(51, 153, 204));
		petitPanel.add(panelDroite, BorderLayout.EAST);
		panelDroite.setLayout(new GridLayout(4, 1));

		
		
		///////// panel de gauche //////////
		JPanel panelGauche = new JPanel();
		panelGauche.setBackground(new Color(51, 153, 204));
		petitPanel.add(panelGauche, BorderLayout.WEST);
		panelGauche.setLayout(new GridLayout(1, 1));

		
		
		
		///////// panel du centre //////////
		JPanel panelCentre = new JPanel();
		panelCentre.setBackground(new Color(51, 153, 204));
		petitPanel.add(panelCentre, BorderLayout.CENTER);
		panelCentre.setLayout(new GridLayout(1,1));
		
		
		
		
		this.setVisible(true);
		//this.pack();
	}
	

}
