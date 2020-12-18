package project.sliding.model;

import org.junit.Before;

public abstract class ModelTestCase {

	protected Model model;
	
	@Before
	public void setup() {
		model = new Model();
		Puzzle puzzle = new Puzzle(3, 3);
		Tile t = new Tile(4);
		t.setWinner(true);
		puzzle.add(t, 1, 1);
		
		puzzle.add(new Tile(7), 0, 0);
		puzzle.add(new Tile(2), 0, 1);
		puzzle.add(new Tile(8), 0, 2);
		puzzle.add(new Tile(1), 1, 0);
		puzzle.add(new Tile(9), 1, 2);
		puzzle.add(new Tile(6), 2, 0);
		puzzle.add(new Tile(3), 2, 1);
		puzzle.add(new Tile(5), 2, 2);
		
		model.setPuzzle(puzzle);
	}
	
}
