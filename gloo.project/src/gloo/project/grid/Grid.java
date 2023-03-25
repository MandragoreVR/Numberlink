package gloo.project.grid;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Grid {
	private int nbLines;
	private int nbColumns;
	private int maxColor = 0;
	private Cell[][] cells; 
	
	public Grid(int nbLines, int nbColumns, String file) {
		this.nbLines = nbLines;
		this.nbColumns = nbColumns;
		this.cells = new Cell[nbLines][nbColumns];
		for (int i = 0; i < nbLines; i++) {
			for (int j = 0; j < nbColumns; j++) {
				this.cells[i][j] = new Cell(i,j,-1);
			}
		}
		this.setPath(file);
	}
	public int getNbLines() {
		return this.nbLines;
	}
	public int getNbColumns() {
		return this.nbColumns;
	}
	public Cell getCell(int i, int j) {
		return this.cells[i][j];
	}
	public int getPreviousColor(int i, int j) {
		return this.cells[i][j].getPreviousColor();
	}
	
	public void setPath(String file)
	{
		int currentLine = 0;
		FileReader reader;
	    try {
	        reader = new FileReader(file);
	        BufferedReader buffer = new BufferedReader(reader,16384);
	        String line = "";
	        do {
	        	try {
	        		line =  buffer.readLine();
	        	}
	        	catch (IOException e) {
	        		e.printStackTrace();
	        	}
	        	if (line != null) {
		        	for (int currentColumn = 0; currentColumn < line.length(); currentColumn++) {
		        		char charNumber = line.toCharArray()[currentColumn];
		        		int number = Character.getNumericValue(charNumber);
		        		this.cells[currentLine][currentColumn].setEnd(number);
		        		if (number > maxColor) {
		        			maxColor = number;
		        		}
		        	}
	        	}
	        	currentLine++; 
	        }while (line != null);
	        try {
	        	buffer.close();
	        	reader.close();
	        }
	        catch (IOException e) {
	        	e.printStackTrace();
	        }
	    }
	    catch (FileNotFoundException e) {
	    	e.printStackTrace();
	    }
	}
	
	public boolean isFull() {
		for (int i = 1; i <= this.maxColor; i++) {
			if (!isAlreadyDone(i)) return false;
		}
		return true;
	}
	
	public boolean isAlreadyDone(int color) {
		for (int i = 0; i < this.nbLines; i++) {
			for (int j = 0; j < this.nbColumns; j++) {
				if (this.cells[i][j].getEnd() == 0 && this.cells[i][j].getColor() == color) return true;
			}
		}
		return false;
	}
	
	public void setColor(int i, int j, int color) {
		this.cells[i][j].setColor(color);
	}
	
	public void removePath(int color) {
		for (int i = 0; i < this.nbLines; i++) {
			for (int j = 0; j < this.nbColumns; j++) {
				if (this.cells[i][j].getColor() == color && this.cells[i][j].getEnd() == 0) {
					this.cells[i][j].setColor(0);
				}
			}
		}
	}
	public void reinitColorChanged() {
		for (int i = 0; i < this.nbLines; i++) {
			for (int j = 0; j < this.nbColumns; j++) {
				this.cells[i][j].setColorChanged();
			}
		}
	}
	public void restoreChangedColor(int color) {
		for (int i = 0; i < this.nbLines; i++) {
			for (int j = 0; j < this.nbColumns; j++) {
				if (this.cells[i][j].getPreviousColor() == color) {
					this.cells[i][j].setColor(color);
				}
			}
		}
	}
}
