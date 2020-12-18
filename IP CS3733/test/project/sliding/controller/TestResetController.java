package project.sliding.controller;

import static org.junit.Assert.*;

import org.junit.Test;

import project.sliding.model.Coordinate;
import project.sliding.model.MoveType;
import project.sliding.model.Tile;

public class TestResetController extends AppTestCase{

	@Test
	public void testReset() {
		Tile t = model.getPuzzle().getTile(new Coordinate(2,0));
		model.setSelectedTile(t);
		model.move(MoveType.Right);
	
		assertTrue(model.getPuzzle().getTile(new Coordinate(2,0)).isEmpty());
		
		ResetController rc = new ResetController(model, app);
		rc.reset();
		
		assertFalse(model.getPuzzle().getTile(new Coordinate(2,0)).isEmpty()); 
	}
}
