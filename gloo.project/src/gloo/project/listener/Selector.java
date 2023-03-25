package gloo.project.listener;

import java.util.ArrayList;

public class Selector {
	// Coordonn�es du s�lecteur
	private int x;
	private int y;
	private boolean isDrawing;
	private int color; // Color with which the selector draws
	private ArrayList<Integer> lastX;
	private ArrayList<Integer> lastY;
	private ArrayList<Integer> pendingDeletions;

	public Selector(int x, int y) {
		this.x = x; this.y = y;
		this.isDrawing = false;
		this.lastX = new ArrayList<Integer>();
		this.lastY = new ArrayList<Integer>();
		this.pendingDeletions = new ArrayList<Integer>();
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public boolean isDrawing() {
		return this.isDrawing;
	}
	public int getColor() {
		return this.color;
	}
	public int getLastX() {
		if (this.lastX.size() > 0) return this.lastX.get(this.lastX.size() - 1);
		else return -1;
	}
	public int getLastY() {
		if (this.lastY.size() > 0) return this.lastY.get(this.lastY.size() - 1);
		else return -1;
	}
	public ArrayList<Integer> getPendingDeletions() {
		return this.pendingDeletions;
	}

	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setIsDrawing() {
		this.isDrawing = !this.isDrawing;
	}
	public void setColor(int color) {
		this.color = color;
	}
	public void setLastX(int x) {
		this.lastX.add(x);
	}
	public void setLastY(int y) {
		this.lastY.add(y);
	}
	public void removeLastX() {
		if (this.lastX.size() > 0) this.lastX.remove(this.lastX.size() - 1);
	}
	public void removeLastY() {
		if (this.lastY.size() > 0) this.lastY.remove(this.lastY.size() - 1);
	}
	public void initMemory() {
		this.lastX = new ArrayList<Integer>();
		this.lastY = new ArrayList<Integer>();
		this.pendingDeletions = new ArrayList<Integer>();
	}
	public void addPendingColor(int color) {
		this.pendingDeletions.add(color);
	}
	public void removeLastPendingColor() {
		if (this.pendingDeletions.size() > 0) this.pendingDeletions.remove(this.pendingDeletions.size() - 1);
	}
}
