package project.sliding.model;

import static org.junit.Assert.*;

import org.junit.Test;


public class TestTile {

	@Test
	public void testConstructor() {
		Tile tile = new Tile(5);
		assertEquals(5, tile.getValue());
	}
	
	@Test
	public void testContains() {
		Tile tile = new Tile(1);
		tile.setRow(1);
		tile.setColumn(2);
		assertTrue(tile.contains(new Coordinate(1,2)));
		assertFalse(tile.contains(new Coordinate(2,1)));
	}

	@Test
	public void testValue() {
		Tile tile = new Tile(1);
		tile.setValue(3);
		assertEquals(3, tile.getValue());
		tile.setEmpty(true);
		assertTrue(tile.isEmpty());
	}
}
