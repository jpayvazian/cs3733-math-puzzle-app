package project.sliding.controller;

import java.awt.Point;
import java.util.List;

import project.sliding.boundary.MathPuzzleApp;
import project.sliding.boundary.UpdateButtons;
import project.sliding.model.Coordinate;
import project.sliding.model.Model;
import project.sliding.model.MoveType;
import project.sliding.model.Puzzle;
import project.sliding.model.Tile;

public class SelectTileController {

	Model model;
	MathPuzzleApp app;
	
	public SelectTileController(Model m, MathPuzzleApp app) {
		this.model = m;
		this.app = app;
	}

	public void process(Point point) {
		Coordinate c = app.getPuzzlePanel().pointToCoordinate(point);
		Puzzle puzzle = model.getPuzzle();
		
		for (Tile t : puzzle) {
			if (t.contains(c)) {
				model.clearSelectedTile();
				model.setSelectedTile(t);
				List<MoveType> moves = model.availableMoves(t);
				UpdateButtons.enableButtons(app, moves);
				app.repaint();
			}
		}
	}
}
