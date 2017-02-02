package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import classes.Cell;
import classes.CellCoordinateOutOfBoundariesException;
import classes.Grid;
import classes.NegativeCoordinateException;

public class TestGrid {

	Grid gridTenXTen;
	Grid gridFiftyXFifty;
	ArrayList<Cell> cells = new ArrayList<>();
	ArrayList<Cell> cells2 = new ArrayList<>();
	Grid gridWithCells;
	
	Grid gridForTick;

	@Before
	public void setUp() throws NegativeCoordinateException {
		gridTenXTen = new Grid(10, 10);
		gridFiftyXFifty = new Grid(50, 50);
		for (int i = 0; i < 10 * 10; i++) {
			cells.add(new Cell());
		}
		gridWithCells = new Grid(cells, 10, 10);
		
		
		for (int i = 0; i < 25; i++) {
			cells2.add(new Cell());
		}
		cells2.get(0).setAlive(true);
		cells2.get(1).setAlive(true);
		cells2.get(5).setAlive(true);
		cells2.get(6).setAlive(true);
		gridForTick = new Grid(cells2, 5, 5);
	}

	@SuppressWarnings("unused")
	@Test(expected = CellCoordinateOutOfBoundariesException.class)
	public void squareGridTest() {
		Grid grid1 = new Grid(10, 20);
		Grid grid2 = new Grid(new ArrayList<Cell>(), 10, 40);
	}

	@Test
	public void printGridTenXTenTest() {
		String allDeadTenXTen = 
				  "----------\n"
				+ "----------\n"
				+ "----------\n"
				+ "----------\n"
				+ "----------\n"
				+ "----------\n"
				+ "----------\n"
				+ "----------\n"
				+ "----------\n"
				+ "----------\n";
		System.out.println(gridWithCells.print());
		
		assertEquals(allDeadTenXTen, gridWithCells.print());
	}
	
	@Test
	public void testTick(){
		System.out.println(gridForTick.print());
		
		
		
		gridForTick.tick();
		System.out.println(gridForTick.print());
		gridForTick.tick();
		System.out.println(gridForTick.print());
		gridForTick.tick();
		System.out.println(gridForTick.print());
		gridForTick.tick();
		System.out.println(gridForTick.print());
		gridForTick.tick();
		System.out.println(gridForTick.print());
		gridForTick.tick();
		System.out.println(gridForTick.print());
		gridForTick.tick();
		System.out.println(gridForTick.print());
		gridForTick.tick();
		
	}

}
