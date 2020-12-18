package project.sliding.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPuzzle {

	@Test
	public void testGetTile() {
		Puzzle p = new Puzzle(3, 3);
		Tile t = new Tile(1);
		p.add(t, 1, 2);
		
		assertEquals(p.getTile(new Coordinate(1, 2)), t);
		assertNull(p.getTile(new Coordinate(0, 2)));
	}

	@Test
	public void testReset() {
		Puzzle p = new Puzzle(3, 3);
		Tile t = new Tile(1);
		p.add(t, 1, 2);
		t.setValue(2);
		
		p.reset();
		assertEquals(1, p.tiles.get(0).getValue());
	}
}
