package gloo.project.renderer;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import gloo.project.controller.Controller;
import gloo.project.listener.KeyboardListener;

public class Window extends JFrame {
	private static final long serialVersionUID = 1L;
	private static JPanel currentScreen;
	private KeyboardListener keyboard;
	private int width;
	private int height;
	
	public Window() {
		setTitle(" Jeu ");
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH); // Full screen
		
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		this.width = (int)size.getWidth();
		this.height = (int)size.getHeight();
	}
	public void setKeyboard(Controller controller, Screen screen) {
		this.keyboard = new KeyboardListener(controller, screen);
		addKeyListener( this.keyboard );
	}
	public void updateToScreenPopUp(ScreenPopUp screenPopUp) {
		dispose();
		
		screenPopUp.setScreenSize(this.width, this.height);
		screenPopUp.updatePopUp();
		removeKeyListener(this.keyboard);
		remove(Window.currentScreen);
		
		add(screenPopUp);
		setVisible(true);
        validate();
                
	}
	public void updateToScreen(Screen screen) {
		dispose();
		
		Window.currentScreen = (JPanel)screen;
		add(screen);
		setVisible(true);
		
        validate();
	}
	public void initiateScreen(ScreenBegin screenBegin) {
		screenBegin.setScreenSize(this.width, this.height);
		screenBegin.updatePopUp();
		add(screenBegin);
		Window.currentScreen = (JPanel)screenBegin;
		setVisible(true);
        validate();
        
	}
}
