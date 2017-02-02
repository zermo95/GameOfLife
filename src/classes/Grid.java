package classes;

import java.util.ArrayList;

public class Grid {
	private ArrayList<Cell> cells;
	private Cell[][] grid; // righe x colonne
	private int width;
	private int height;

	public Grid(ArrayList<Cell> cells, int w, int h) throws CellCoordinateOutOfBoundariesException {
		this(w, h);
		this.cells = cells;
		fillGrid();
	}

	public Grid(int w, int h) throws CellCoordinateOutOfBoundariesException {
		// this.cells = new ArrayList<>();
		if (w != h) {
			throw new CellCoordinateOutOfBoundariesException("Grid must be a square");
		} else {
			this.width = w;
			this.height = h;
			grid = new Cell[height][width];
		}
	}

	public String print() {
		String gridString = "";

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (cells.get(j + i).isAlive()) {
					gridString = gridString.concat("*");
				} else {
					gridString = gridString.concat("-");
				}
			}
			gridString = gridString.concat("\n");
		}
		return gridString;
	}

	private void fillGrid() {

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				grid[j][i] = cells.get(j + i);
				grid[j][i].setX(j);
				grid[j][i].setX(i);
			}
		}
	}

	public Grid tick() {

		Cell[][] gridClone = grid.clone();

		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				if (gridClone[j][i].isAlive()) {
					if (getLivingNeighbors(gridClone[j][i]) < 2) {
						grid[j][i].setAlive(false);
					} else if (getLivingNeighbors(gridClone[j][i]) <= 3) {
						grid[j][i].setAlive(true);
					} else if (getLivingNeighbors(gridClone[j][i]) > 3) {
						grid[j][i].setAlive(false);
					}
				} else {
					if (getLivingNeighbors(gridClone[j][i]) == 3) {
						grid[j][i].setAlive(true);
					}

				}
			}
		}
		return this;

	}

	private int getLivingNeighbors(Cell cell) {
		int count = 0;

		// Check cell on the right
		if (cell.getY() != this.width) {
			if (grid[cell.getX()][cell.getY() + 1].isAlive()) {
				count++;
			}
		}

		// Check cell on the bottom right
		if (cell.getY() != this.width - 1 && cell.getX() != this.height - 1) {
			if (grid[cell.getX() + 1][cell.getY() + 1].isAlive()) {
				count++;
			}
		}

		// Check cell on the bottom
		if (cell.getX() != this.height - 1) {
			if (grid[cell.getX() + 1][cell.getY()].isAlive()) {
				count++;
			}
		}

		// Check cell on the bottom left
		if (cell.getY() > 0 && cell.getX() != this.height) {
			if (grid[cell.getX() + 1][cell.getY() - 1].isAlive()) {
				count++;
			}
		}

		// Check cell on the left
		if (cell.getY() != 0) {
			if (grid[cell.getX() - 1][cell.getY()].isAlive()) {
				count++;
			}
		}

		// Check cell on the top left
		if (cell.getY() != 0 && cell.getX() != 0) {
			if (grid[cell.getX() - 1][cell.getY() - 1].isAlive()) {
				count++;
			}
		}

		// Check cell on the top
		if (cell.getX() != 0) {
			if (grid[cell.getX() - 1][cell.getY()].isAlive()) {
				count++;
			}
		}

		// Check cell on the top right
		if (cell.getX() != 0 && cell.getY() != this.width) {
			if (grid[cell.getX() - 1][cell.getY() + 1].isAlive()) {
				count++;
			}
		}

		return count;
	}
}
