package gloo.project.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import gloo.project.controller.Controller;

public class KeyboardListener implements KeyListener {

	private Controller controller;
	private JPanel screen;

	public KeyboardListener(Controller controller, JPanel screen) {
		this.controller = controller;
		this.screen = screen;
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			int x = controller.getX();
			int y = controller.getY();
			if (x < controller.getNbColumns() - 1) {
				if (controller.isDrawing()) {
					if (controller.getColor(x+1, y) == 0) {
						controller.setSelectorX(x+1);
						controller.setLastX(x);
						controller.setLastY(-1);
						controller.setColor(x+1, y, controller.getDrawingColor());
					}
					else if (controller.getColor(x+1, y) != controller.getDrawingColor() && controller.getEnd(x+1, y) == 0) {
						controller.setSelectorX(x+1);
						controller.setLastX(x);
						controller.setLastY(-1);
						controller.addPendingColor(controller.getColor(x+1, y));
						controller.setColor(x+1, y, controller.getDrawingColor());
					}
					else if (controller.getColor(x+1, y) == controller.getDrawingColor()) {
						if (controller.getEnd(x+1, y) != 0 && controller.getLastX() != x+1) {
							controller.setSelectorX(x+1);
							controller.setLastX(x);
							controller.setLastY(-1);
						} else if (controller.getLastX() == x+1) {
							controller.setSelectorX(x+1);
							controller.removeLastX();
							controller.removeLastY();
							if (controller.getEnd(x, y) == 0) {
								if (controller.getPreviousColor(x+1, y) != controller.getDrawingColor()) {
									controller.removeLastPendingColor();
								}
								controller.setColor(x, y, controller.getPreviousColor(x, y));
							}
						}
					}
				} else { controller.setSelectorX(x+1); controller.setLastX(x); }
			}
			break;
		case KeyEvent.VK_LEFT:
			int x1 = controller.getX();
			int y1 = controller.getY();
			if (x1 > 0) {
				if (controller.isDrawing()) {
					if (controller.getColor(x1-1, y1) == 0) {
						controller.setSelectorX(x1-1);
						controller.setLastX(x1);
						controller.setLastY(-1);
						controller.setColor(x1-1, y1, controller.getDrawingColor());
					}
					else if (controller.getColor(x1-1, y1) != controller.getDrawingColor() && controller.getEnd(x1-1, y1) == 0) {
						controller.setSelectorX(x1-1);
						controller.setLastX(x1);
						controller.setLastY(-1);
						controller.addPendingColor(controller.getColor(x1-1, y1));
						controller.setColor(x1-1, y1, controller.getDrawingColor());
					}
					else if (controller.getColor(x1-1, y1) == controller.getDrawingColor()) {
						if (controller.getEnd(x1-1, y1) != 0 && controller.getLastX() != x1-1) {
							controller.setSelectorX(x1-1);
							controller.setLastX(x1);
							controller.setLastY(-1);
						} else if (controller.getLastX() == x1-1) {
							controller.setSelectorX(x1-1);
							controller.removeLastX();
							controller.removeLastY();
							if (controller.getEnd(x1, y1) == 0) {
								if (controller.getPreviousColor(x1-1, y1) != controller.getDrawingColor()) {
									controller.removeLastPendingColor();
								}
								controller.setColor(x1, y1, controller.getPreviousColor(x1, y1));
							}
						}
					}
				} else { controller.setSelectorX(x1-1); controller.setLastX(x1); }
			}
			break;
		case KeyEvent.VK_UP:
			int x2 = controller.getX();
			int y2 = controller.getY();
			if (y2 > 0) {
				if (controller.isDrawing()) {
					if (controller.getColor(x2, y2-1) == 0) {
						controller.setSelectorY(y2-1);
						controller.setLastY(y2);
						controller.setLastX(-1);
						controller.setColor(x2, y2-1, controller.getDrawingColor());
					}
					else if (controller.getColor(x2, y2-1) != controller.getDrawingColor() && controller.getEnd(x2, y2-1) == 0) {
						controller.setSelectorY(y2-1);
						controller.setLastY(y2);
						controller.setLastX(-1);
						controller.addPendingColor(controller.getColor(x2, y2-1));
						controller.setColor(x2, y2-1, controller.getDrawingColor());
					}
					else if (controller.getColor(x2, y2-1) == controller.getDrawingColor()) {
						if (controller.getEnd(x2, y2-1) != 0 && controller.getLastY() != y2-1) {
							controller.setSelectorY(y2-1);
							controller.setLastY(y2);
							controller.setLastX(-1);
						} else if (controller.getLastY() == y2-1) {
							controller.setSelectorY(y2-1);
							controller.removeLastY();
							controller.removeLastX();
							if (controller.getEnd(x2, y2) == 0) {
								if (controller.getPreviousColor(x2, y2-1) != controller.getDrawingColor()) {
									controller.removeLastPendingColor();
								}
								controller.setColor(x2, y2, controller.getPreviousColor(x2, y2));
							}						
						}
					}
				} else { controller.setSelectorY(y2-1); controller.setLastY(y2); }
			}
			break;
		case KeyEvent.VK_DOWN:
			int x3 = controller.getX();
			int y3 = controller.getY();
			if (y3 < controller.getNbLines() - 1) {
				if (controller.isDrawing()) {
					if (controller.getColor(x3, y3+1) == 0) {
						controller.setSelectorY(y3+1);
						controller.setLastY(y3);
						controller.setLastX(-1);
						controller.setColor(x3, y3+1, controller.getDrawingColor());
					}
					else if (controller.getColor(x3, y3+1) != controller.getDrawingColor() && controller.getEnd(x3, y3+1) == 0) {
						controller.setSelectorY(y3+1);
						controller.setLastY(y3);
						controller.setLastX(-1);
						controller.addPendingColor(controller.getColor(x3, y3+1));
						controller.setColor(x3, y3+1, controller.getDrawingColor());
					}
					else if (controller.getColor(x3, y3+1) == controller.getDrawingColor()) {
						if (controller.getEnd(x3, y3+1) != 0 && controller.getLastY() != y3+1) {
							controller.setSelectorY(y3+1);
							controller.setLastY(y3);
							controller.setLastX(-1);
						} else if (controller.getLastY() == y3+1) {
							controller.setSelectorY(y3+1);
							controller.removeLastY();
							controller.removeLastX();
							if (controller.getEnd(x3, y3) == 0) {
								if (controller.getPreviousColor(x3, y3+1) != controller.getDrawingColor()) {
									controller.removeLastPendingColor();
								}
								controller.setColor(x3, y3, controller.getPreviousColor(x3, y3));
							}						
						}
					}
				} else { controller.setSelectorY(y3+1); controller.setLastY(y3); }
			}
			break;
		case KeyEvent.VK_ENTER:
			int x4 = controller.getX();
			int y4 = controller.getY();
			if (controller.getEnd(x4, y4) != 0) {
				if (!controller.isDrawing() && !controller.isAlreadyDone(controller.getColor(x4, y4))) {
					controller.setDrawingState();
					controller.initMemory();
					controller.setDrawingColor(controller.getColor(x4, y4));
				} else if (controller.isDrawing()) controller.setDrawingState();
				
				if (!controller.isDrawing()) {
					controller.confirmPathsDeletions();
					controller.initMemory();
				}
				this.controller.setEndedState();
				if (this.controller.isEnded()) {
					this.controller.updateToScreenPopUp();
				}
			}
			break;
			

		case KeyEvent.VK_C: // To clear the board, for tests
			for (int color = 0; color < 10; color++) {
				controller.removePath(color);
			if (controller.isDrawing()) controller.setDrawingState();
			}
			break;
		
		case KeyEvent.VK_BACK_SPACE:
			int color = controller.getColor(controller.getX(), controller.getY());
			if (color != 0) controller.removePath(color);
		
		case KeyEvent.VK_ESCAPE:
			if (controller.isDrawing()) {
				controller.removePath(controller.getDrawingColor());
				controller.setDrawingState();
				ArrayList<Integer> pending = controller.getPendingDeletions();
				for (int i = 0; i < pending.size(); i++) {
					controller.restoreChangedColor(pending.get(i));
				}
				controller.initMemory();
			}
		}
		this.screen.repaint();
	}
	public KeyboardListener getKeyListener() {
		return this;
	}
}
