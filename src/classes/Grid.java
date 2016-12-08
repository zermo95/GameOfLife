package classes;

import java.util.ArrayList;

public class Grid {
	public static final Object DEAD = null;
	public static final Object ALIVE = null;
	private ArrayList<Cell> cells;
	private int width;
	private int height;


	public Grid(ArrayList<Cell> cells, int w, int h) throws CellCoordinateOutOfBoundariesException{
	}
	
	public Grid(int w, int h) throws CellCoordinateOutOfBoundariesException {
	}

	public Grid(int i) {
		// TODO Auto-generated constructor stub
	}

	public String print() {
	    return null;
	}
	
	public Grid tick() {
	    return null;
	}

	public void fillRandomly() {
		// TODO Auto-generated method stub
		
	}

	public int countAliveCells() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int countDeadCells() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void addCell(Cell cell) {
		// TODO Auto-generated method stub
		
	}

	public Object getLife() {
		// TODO Auto-generated method stub
		return null;
	}
}
