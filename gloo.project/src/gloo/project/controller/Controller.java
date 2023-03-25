package gloo.project.controller;
import java.awt.Color;
import java.util.ArrayList;

import gloo.project.grid.Grid;
import gloo.project.renderer.ScreenPopUp;
import gloo.project.renderer.Window;
import gloo.project.listener.Selector;

public class Controller {

	private Grid grid;
	private Selector selector;
	private boolean isEnded;
	private ScreenPopUp screenPopUp;
	private Window window;

	public Controller (Grid grid, Selector selector){
		this.grid = grid;
		this.selector = selector;
		this.isEnded = false;
	}
	public int getNbLines() {
		return this.grid.getNbLines();
	}
	public int getNbColumns() {
		return this.grid.getNbColumns();
	}
	public int getX() {
		return this.selector.getX();
	}
	public int getY() {
		return this.selector.getY();
	}
	public boolean isDrawing() {
		return this.selector.isDrawing();
	}
	public int getColor(int i, int j) {
		return this.grid.getCell(i, j).getColor();
	}
	public int getEnd(int i, int j) {
		return this.grid.getCell(i, j).getEnd();
	}
	public int getLastX() {
		return this.selector.getLastX();
	}
	public int getLastY() {
		return this.selector.getLastY();
	}
	public Window getWindow() {
		return this.window;
	}
	public static Color screenColor(int colorId) {
		switch(colorId) {
		case 1:
			return Color.RED;
		case 2:
			return Color.BLUE;
		case 3:
			return Color.GREEN;
		case 4:
			return Color.ORANGE;
		case 5:
			return Color.YELLOW;
		case 6:
			return Color.CYAN;
		case 7:
			return Color.PINK;
		case 8:
			return Color.BLACK;
		case 9:
			return Color.MAGENTA;
		default:
			return Color.WHITE;
		}
	}
	public int getDrawingColor() {
		return this.selector.getColor();
	}
	public int getPreviousColor(int i, int j) {
		return this.grid.getPreviousColor(i, j);
	}
	public ArrayList<Integer> getPendingDeletions() {
		return this.selector.getPendingDeletions();
	}
	public boolean isAlreadyDone(int color) {
		return this.grid.isAlreadyDone(color);
	}

	public ScreenPopUp getScreenPopUp() {
		return this.screenPopUp;
	}

	public boolean isEnded () {
		return this.isEnded;
	}
	public void setSelectorX(int x) {
		this.selector.setX(x);
	}
	public void setSelectorY(int y) {
		this.selector.setY(y);
	}
	public void setDrawingState() {
		this.selector.setIsDrawing();
	}
	public void setColor(int i, int j, int color) {
		this.grid.setColor(i, j, color);
	}
	public void setDrawingColor(int color) {
		this.selector.setColor(color);
	}
	public void setLastX(int x) {
		this.selector.setLastX(x);
	}
	public void setLastY(int y) {
		this.selector.setLastY(y);
	}
	public void removeLastX() {
		this.selector.removeLastX();
	}
	public void removeLastY() {
		this.selector.removeLastY();
	}
	public void initMemory() {
		this.selector.initMemory();
		this.grid.reinitColorChanged();
	}

	public void removePath(int color) {
		this.grid.removePath(color);
	}
	public void addPendingColor(int color) {
		this.selector.addPendingColor(color);
	}
	public void removeLastPendingColor() {
		this.selector.removeLastPendingColor();
	}
	public void confirmPathsDeletions() {
		ArrayList<Integer> pending = this.selector.getPendingDeletions();
		for (int i = 0; i < pending.size(); i++) {
			this.removePath(pending.get(i));
		}
	}
	public void setEndedState() {
		this.isEnded = this.grid.isFull();
	}
	public void restoreChangedColor(int color) {
		this.grid.restoreChangedColor(color);
	}
	public void setScreenPopUp(ScreenPopUp screenPopUp) {
		this.screenPopUp = screenPopUp;
	}
	public void setWindow(Window window) {
		this.window = window;
	}
	public void updateToScreenPopUp() {
		this.window.updateToScreenPopUp(this.screenPopUp);
	}
}