package gloo.project.grid;

public class Cell {
	private int end; // end is the number of the path, if it is set to zero the cell isn't an end at all
	private int color;
	private int previousColor; // To check if the color has been changed from a non-negative integer to another

	public Cell(int xCoord, int yCoord, int end) {
		this.end = end;
		this.color = end;
		this.previousColor = 0;
	}
	public void setEnd(int end) {
		this.end = end;
		this.color = end;
	}
	public int getEnd() {
		return this.end;
	}
	public int getColor() {
		return this.color;
	}
	public int getPreviousColor() {
		return this.previousColor;
	}

	
	public void setColor(int color) {
		if (color * this.color != 0 && this.color != color) this.previousColor = this.color;
		// The product is to check that none of them is equal to 0
		this.color = color;
	}
	public void setColorChanged() {
		this.previousColor = 0;
	}
}
