package gloo.project.renderer;

import javax.swing.SwingUtilities;

import gloo.project.controller.Controller;
import gloo.project.listener.Selector;
import gloo.project.grid.Grid;

public class Renderer implements Runnable {
	private static String file = null;
	private int size;
	private static Window windowBegin;
	public Renderer(String file) {
		this.setFile(file);
	}
	public static void main (String[] args ) {
		SwingUtilities.invokeLater( new Renderer(file) );
	}
	@Override
	public void run() {
		if (Renderer.file == null) {
			Renderer.windowBegin = new Window();
			ScreenBegin screenBegin = new ScreenBegin();
			Renderer.windowBegin.initiateScreen(screenBegin);
		}
		else {
			Renderer.windowBegin.dispose();
			Window window = new Window();
			this.setSize();
			Grid grid = new Grid(this.size, this.size, Renderer.file);
			Selector selector = new Selector(0,0);
			Controller controller = new Controller(grid, selector );
			
			ScreenPopUp screenPopUp = new ScreenPopUp();
			Screen screen = new Screen(controller);
			window.setKeyboard(controller, screen);
		
			controller.setScreenPopUp(screenPopUp);
			controller.setWindow(window);
			window.updateToScreen(screen);
		}
		
	}
	public void setFile (String file) {
		Renderer.file = file;
	}
	public void setSize () {
		switch (Renderer.file) {
		case "easy.txt"	:
			this.size = 6;
			break;
		case "medium.txt" :
			this.size = 7;
			break;
		case "hard.txt" :
			this.size = 8;
			break;
		case "harder.txt" :
			this.size = 9;
			break;
		default :
			throw new IllegalArgumentException ("erreur fichier de configuration non reconnue");
	}
	
	}
}

