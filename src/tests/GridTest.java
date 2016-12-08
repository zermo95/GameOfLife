package tests;

import static org.junit.Assert.*;
import classes.Cell;
import classes.CustomLifeException;
import classes.Grid;

import org.junit.Test;

public class GridTest {
	
	@Test
	public void numberOfAliveAndDeadCellsShouldBeEqual() {
		Grid grid = new Grid(2);
		grid.fillRandomly();
		int alive = grid.countAliveCells();
		int dead = grid.countDeadCells();
		assertEquals(2, alive);
		assertEquals(0, alive-dead);		
	}
	
	@Test
	public void numberOfAliveAndDeadCellsShouldBeRoughlyEqual() {
		Grid grid = new Grid(3);
		grid.fillRandomly();
		int alive = grid.countAliveCells();
		int dead = grid.countDeadCells();		
		assertEquals(5, Math.max(alive, dead));
		assertEquals(1, Math.abs(alive-dead));		
	}
	
	@Test
	public void gridShouldHave1AliveCellAfterTicking(){
		Grid grid = new Grid(3);
		grid.addCell(new Cell(0, 0, true));
		grid.addCell(new Cell(0, 1, false));
		grid.addCell(new Cell(0, 2, false));
		grid.addCell(new Cell(1, 0, false));
		grid.addCell(new Cell(1, 1, true));
		grid.addCell(new Cell(1, 2, false));
		grid.addCell(new Cell(2, 0, false));
		grid.addCell(new Cell(2, 1, false));
		grid.addCell(new Cell(2, 2, true));
		
		grid.tick();
		StringBuilder buffer = new StringBuilder();
		buffer.append(Grid.DEAD).append(Grid.DEAD).append(Grid.DEAD).append("\n");
		buffer.append(Grid.DEAD).append(Grid.ALIVE).append(Grid.DEAD).append("\n");
		buffer.append(Grid.DEAD).append(Grid.DEAD).append(Grid.DEAD).append("\n");
		assertEquals(buffer.toString(), grid.getLife());
	}
	
	@Test
	public void gridShouldHave2AliveCellsAfterTicking(){
		Grid grid = new Grid(3);
		grid.addCell(new Cell(0, 0, false));
		grid.addCell(new Cell(0, 1, false));
		grid.addCell(new Cell(0, 2, false));
		grid.addCell(new Cell(1, 0, true));
		grid.addCell(new Cell(1, 1, false));
		grid.addCell(new Cell(1, 2, true));
		grid.addCell(new Cell(2, 0, false));
		grid.addCell(new Cell(2, 1, true));
		grid.addCell(new Cell(2, 2, false));
		grid.tick();
		StringBuilder buffer = new StringBuilder();
		buffer.append(Grid.DEAD).append(Grid.DEAD).append(Grid.DEAD).append("\n");
		buffer.append(Grid.DEAD).append(Grid.ALIVE).append(Grid.DEAD).append("\n");
		buffer.append(Grid.DEAD).append(Grid.ALIVE).append(Grid.DEAD).append("\n");
		assertEquals(buffer.toString(), grid.getLife());
	}
	
	@Test(expected=CustomLifeException.class)
	public void xCoordGreaterThanNShouldRaisException(){
		Grid grid = new Grid(3);
		grid.addCell(new Cell(4, 0, false));
	}
	
	@Test(expected=CustomLifeException.class)
	public void yCoordGreaterThanNShouldRaisException(){
		Grid grid = new Grid(3);
		grid.addCell(new Cell(0, 4, false));
	}
	
	@Test(expected=CustomLifeException.class)
	public void negaviteXCoordShouldRaisException(){
		Grid grid = new Grid(3);
		grid.addCell(new Cell(-1, 0, false));
	}
	
	@Test(expected=CustomLifeException.class)
	public void negaviteYCoordShouldRaisException(){
		Grid grid = new Grid(3);
		grid.addCell(new Cell(0, -1, false));
	}
	
	@Test(expected=CustomLifeException.class)
	public void nullCellShouldRaisException(){
		Grid grid = new Grid(3);
		grid.addCell(new Cell(0, 0, false));
		grid.tick();
	}
}
