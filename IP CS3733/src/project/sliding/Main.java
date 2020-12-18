package project.sliding;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import project.sliding.boundary.MathPuzzleApp;
import project.sliding.controller.ExitController;
import project.sliding.model.Model;
import project.sliding.model.Puzzle;
import project.sliding.model.Tile;

public class Main {

	public static void main(String[] args) {	
	
		Model m = new Model();
		Puzzle puzzle = new Puzzle(3, 3);
		
		Tile middle = new Tile(4);
		middle.setWinner(true);
		puzzle.add(middle, 1, 1);
		
		puzzle.add(new Tile(7), 0, 0);
		puzzle.add(new Tile(2), 0, 1);
		puzzle.add(new Tile(8), 0, 2);
		puzzle.add(new Tile(1), 1, 0);
		puzzle.add(new Tile(9), 1, 2);
		puzzle.add(new Tile(6), 2, 0);
		puzzle.add(new Tile(3), 2, 1);
		puzzle.add(new Tile(5), 2, 2);
		
		
		m.setPuzzle(puzzle);
		MathPuzzleApp app = new MathPuzzleApp(m);
		
		app.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				new ExitController(app).exit();
			}});
		
		app.setVisible(true);
	}

}
