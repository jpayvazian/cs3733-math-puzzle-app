package project.sliding.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestModel extends ModelTestCase{
	
	@Test
	public void testAvailableMoves() {
		assertEquals(3, model.availableMoves(model.getPuzzle().getTile(new Coordinate(0,1))).size());
		assertEquals(2, model.availableMoves(model.getPuzzle().getTile(new Coordinate(2,0))).size());
		assertEquals(1, model.availableMoves(model.getPuzzle().getTile(new Coordinate(1,2))).size());
		
		model.getPuzzle().getTile(new Coordinate(1,0)).setEmpty(true);
		assertEquals(0, model.availableMoves(model.getPuzzle().getTile(new Coordinate(1,0))).size());
		assertEquals(1, model.availableMoves(model.getPuzzle().getTile(new Coordinate(2,0))).size());
		
		model.getPuzzle().getTile(new Coordinate(0,1)).setEmpty(true);
		assertEquals(0, model.availableMoves(model.getPuzzle().getTile(new Coordinate(0,1))).size());
		assertEquals(0, model.availableMoves(model.getPuzzle().getTile(new Coordinate(0,0))).size());
		assertEquals(0, model.availableMoves(model.getPuzzle().getTile(new Coordinate(0,2))).size());
	}
	@Test 
	public void testMove() {	
		model.setSelectedTile(model.getPuzzle().getTile(new Coordinate(0,0)));
		model.move(MoveType.Right);
		assertTrue(model.getPuzzle().getTile(new Coordinate(0,0)).isEmpty());
		assertEquals(9, model.getPuzzle().getTile(new Coordinate(0,1)).getValue());
		
		model.setSelectedTile(model.getPuzzle().getTile(new Coordinate(0,2)));
		model.move(MoveType.Left);
		assertTrue(model.getPuzzle().getTile(new Coordinate(0,2)).isEmpty());
		assertEquals(1, model.getPuzzle().getTile(new Coordinate(0,1)).getValue());
		
		model.setSelectedTile(model.getPuzzle().getTile(new Coordinate(0,1)));
		model.move(MoveType.Down);
		assertTrue(model.getPuzzle().getTile(new Coordinate(0,1)).isEmpty());
		assertEquals(4, model.getPuzzle().getTile(new Coordinate(1,1)).getValue());
		
		model.setSelectedTile(model.getPuzzle().getTile(new Coordinate(2,2)));
		model.move(MoveType.Up);
		assertTrue(model.getPuzzle().getTile(new Coordinate(2,2)).isEmpty());
		assertEquals(45, model.getPuzzle().getTile(new Coordinate(1,2)).getValue());
	}
	
	@Test
	public void testGameConditions() {
		model.setSelectedTile(model.getPuzzle().getTile(new Coordinate(2,1)));
		model.clearSelectedTile();
		assertNull(model.getSelectedTile());
		model.setGameOver(true);
		model.setGameWin(true);
		
		assertTrue(model.isGameOver());
		assertTrue(model.isGameWin());
		model.resetPuzzle();
		assertFalse(model.isGameOver());
	}

	@Test
	public void testWinLoseCondition() {
		assertFalse(model.isWinCondition());
		assertFalse(model.isLoseCondition());
		
		model.getPuzzle().getTile(new Coordinate(0,0)).setEmpty(true);
		model.getPuzzle().getTile(new Coordinate(0,1)).setEmpty(true);
		model.getPuzzle().getTile(new Coordinate(0,2)).setEmpty(true);
		model.getPuzzle().getTile(new Coordinate(1,0)).setEmpty(true);
		model.getPuzzle().getTile(new Coordinate(1,2)).setEmpty(true);
		model.getPuzzle().getTile(new Coordinate(2,0)).setEmpty(true);
		model.getPuzzle().getTile(new Coordinate(2,1)).setEmpty(true);
		model.getPuzzle().getTile(new Coordinate(2,2)).setEmpty(true);
		
		assertTrue(model.isWinCondition());
		assertFalse(model.isLoseCondition());
		
		model.getPuzzle().getTile(new Coordinate(1,1)).setEmpty(true);
		model.getPuzzle().getTile(new Coordinate(0,2)).setEmpty(false);
		assertFalse(model.isWinCondition());
		model.getPuzzle().getTile(new Coordinate(1,0)).setEmpty(false);
		
		assertFalse(model.isWinCondition());
		assertTrue(model.isLoseCondition());
	}
	
}
