package gloo.project.renderer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ScreenPopUp extends JPanel {
	private static final long serialVersionUID = 1L;
	private int width;
	private int height;
	
	public ScreenPopUp getScreenPopUp() {
		return this;
	}
	public void setScreenSize(int width, int height) {
		this.height = height;
		this.width = width;
	}
	public void updatePopUp() {
        setLayout(null);
        JButton button = new JButton ("Cliquez ici pour rejouer !");
        button.setBounds(3*width/8,3*height/8,width/4,height/4);
        button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Renderer(null);
				Renderer.main(null);
				
			}
        });
        add(button);
        button.setVisible(true);        
	}
}
