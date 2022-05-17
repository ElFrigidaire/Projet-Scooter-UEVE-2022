package vue;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FenetreAccueil extends JFrame implements ActionListener {
	
	
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreAccueil frame = new FenetreAccueil();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	JButton btnLouer, btnEtatScooter, btnEtatParc, btnSaisiParc, btnQuitterProg, btnRetourScooter;

	
	
	public FenetreAccueil() {
		
		
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
		/*petitPanel.add(panelDroite, BorderLayout.EAST);
		petitPanel.add(panelGauche, BorderLayout.WEST);
		petitPanel.add(panelCENTRE, BorderLayout.CENTER);*/
		
		
		////////// panel du haut /////////
		JPanel panelHaut = new JPanel();
		panelHaut.setBackground(new Color(51, 51, 102));
		grandPanel.add(panelHaut, BorderLayout.NORTH);
		
		
		JLabel Titre = new JLabel("LouScoot");
		Titre.setForeground(Color.WHITE);
		Titre.setFont(new Font("Lao MN", Font.PLAIN, 28));
		panelHaut.add(Titre);
		
		
		
		////////// panel de droite //////////
		JPanel panelDroite = new JPanel();
		panelDroite.setBackground(new Color(51, 153, 204));
		petitPanel.add(panelDroite, BorderLayout.EAST);
		panelDroite.setLayout(new GridLayout(4, 1));
		
		
		btnEtatScooter = new JButton("État du scooter");
		btnEtatScooter.setForeground(new Color(51, 51, 102));
		btnEtatScooter.addActionListener(this);
		panelDroite.add(btnEtatScooter);
		
		btnEtatParc = new JButton("État du parc");
		btnEtatParc.setForeground(new Color(51, 51, 102));
		btnEtatParc.addActionListener(this);
		panelDroite.add(btnEtatParc);
		
		btnSaisiParc = new JButton("Saisi du parc");
		btnSaisiParc.setForeground(new Color(51, 51, 102));
		btnSaisiParc.addActionListener(this);
		panelDroite.add(btnSaisiParc);
		
		btnQuitterProg = new JButton("Quitter le programme");
		btnQuitterProg.setForeground(new Color(51, 51, 102));
		btnQuitterProg.addActionListener(this);
		panelDroite.add(btnQuitterProg);
		
		
		
		///////// panel de gauche //////////
		JPanel panelGauche = new JPanel();
		panelGauche.setBackground(new Color(51, 153, 204));
		petitPanel.add(panelGauche, BorderLayout.WEST);
		panelGauche.setLayout(new GridLayout(1, 1));
		
		btnLouer = new JButton("Louer un scooter");
		btnLouer.addActionListener(this);
		btnLouer.setForeground(new Color(51, 51, 102));
		panelGauche.add(btnLouer, BorderLayout.WEST);
		btnLouer.setBackground(Color.RED);
		//btnLouer.setPreferredSize(new Dimension(224, 30));
		
		
		
		///////// panel du centre //////////
		JPanel panelCentre = new JPanel();
		panelCentre.setBackground(new Color(51, 153, 204));
		petitPanel.add(panelCentre, BorderLayout.CENTER);
		panelCentre.setLayout(new GridLayout(1,1));
		
		btnRetourScooter = new JButton("Retour de scooter");
		btnRetourScooter.setForeground(new Color(51, 51, 102));
		btnRetourScooter.addActionListener(this);
		panelCentre.add(btnRetourScooter, BorderLayout.CENTER);
		//btnRetourScooter.setPreferredSize(new Dimension(, 30));
		
		this.setVisible(true);
		//this.pack();
		
	}



	public void actionPerformed(ActionEvent e) {
	
		
		Object source = e.getSource();
		
		if (source == btnLouer) {
			new PageLouer();
			this.dispose();
		} else if (source == btnRetourScooter) { 
			new PageRetour();
			this.dispose();
		} else if (source == btnEtatParc) {
			new PageEtatParc();
			this.dispose();
		} else if (source == btnQuitterProg) {
			this.dispose();
		} else if (source == btnEtatScooter) {
			new PageEtatScooter();
			this.dispose();
		} else if (source == btnSaisiParc) {
			new PageSaisiParc();
			this.dispose();
		}
		
		
		
	}

}
