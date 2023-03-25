package gloo.project.renderer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ScreenBegin extends JPanel {
	private static final long serialVersionUID = 1L;
	private int width;
	private int height;
	
	public void setScreenSize(int width, int height) {
		this.height = height;
		this.width = width;
	}
	
	public void updatePopUp() {
        setLayout(null);
        JButton buttonEasy = new JButton ("Cliquez ici pour jouer en mode facile !");
        JButton buttonMedium= new JButton ("Cliquez ici pour jouer en mode moyen !");
        JButton buttonHard = new JButton ("Cliquez ici pour jouer en mode difficile !");
        JButton buttonHarder = new JButton ("Cliquez ici pour jouer en mode ultra difficile !");
        
        buttonEasy.setBounds(0,3*height/8,width/4,height/4);
        buttonEasy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Renderer("easy.txt");
				Renderer.main(null);
				
			}
        });
        buttonMedium.setBounds(2*width/8,3*height/8,width/4,height/4);
        buttonMedium.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Renderer("medium.txt");
				Renderer.main(null);
				
			}
        });
        buttonHard.setBounds(4*width/8,3*height/8,width/4,height/4);
        buttonHard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Renderer("hard.txt");
				Renderer.main(null);
				
			}
        });
        buttonHarder.setBounds(6*width/8,3*height/8,width/4,height/4);
        buttonHarder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Renderer("harder.txt");
				Renderer.main(null);
				
			}
        });
        add(buttonEasy);
        add(buttonMedium);
        add(buttonHard);
        add(buttonHarder);
        buttonEasy.setVisible(true);
        buttonMedium.setVisible(true);
        buttonHard.setVisible(true);
        buttonHarder.setVisible(true);
	}
}
