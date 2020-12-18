package project.sliding.controller;

import static org.junit.Assert.*;

import org.junit.Test;

import java.awt.Point;

import javax.swing.JOptionPane;

import project.sliding.model.Coordinate;
import project.sliding.model.MoveType;

public class TestMoveTileController extends AppTestCase{
	
	@Test
	public void testMove() {	
		
		//getting coverage for numbers with 2,3,4 digits for painting
		model.getPuzzle().getTile(new Coordinate(0,0)).setValue(13);
		model.getPuzzle().getTile(new Coordinate(2,0)).setValue(1003);
		
	
		SelectTileController stc = new SelectTileController (model, app);
		MoveTileController mtc = new MoveTileController(model, app);
		
		Point pt = app.getPuzzlePanel().coordinateToPoint(new Coordinate(1,1));
		assertEquals (1, app.getPuzzlePanel().pointToCoordinate(pt).row);
		assertEquals (1, app.getPuzzlePanel().pointToCoordinate(pt).col);

		assertFalse(mtc.move(MoveType.Right));
		stc.process(pt);
		assertTrue(mtc.move(MoveType.Right));
		assertEquals(13, model.getPuzzle().getTile(new Coordinate(1, 2)).getValue());
		
		stc.process(app.getPuzzlePanel().coordinateToPoint(new Coordinate(1,2)));
		assertTrue(mtc.move(MoveType.Up));
		
		stc.process(app.getPuzzlePanel().coordinateToPoint(new Coordinate(0,1)));
		assertTrue(mtc.move(MoveType.Left));
		
		stc.process(app.getPuzzlePanel().coordinateToPoint(new Coordinate(1,0)));
		assertTrue(mtc.move(MoveType.Down));
	}
}
