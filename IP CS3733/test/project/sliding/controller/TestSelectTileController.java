package project.sliding.controller;

import static org.junit.Assert.*;

import org.junit.Test;

import java.awt.Point;

import project.sliding.model.Coordinate;
import project.sliding.model.Tile;

public class TestSelectTileController extends AppTestCase{
	
	@Test
	public void testMove() {	
		SelectTileController stc = new SelectTileController (model, app);
		Point pt = app.getPuzzlePanel().coordinateToPoint(new Coordinate(2,0));

		assertEquals(2, app.getPuzzlePanel().pointToCoordinate(pt).row);
		assertEquals(0, app.getPuzzlePanel().pointToCoordinate(pt).col);
		
		stc.process(pt);
		
		Tile t = model.getPuzzle().getTile(new Coordinate(2,0)); 
		assertEquals(t, model.getSelectedTile());
		
		assertFalse(app.getLeftButton().isEnabled());
		assertFalse(app.getDownButton().isEnabled());
		assertTrue(app.getRightButton().isEnabled());
		assertTrue(app.getUpButton().isEnabled());
	}
}
