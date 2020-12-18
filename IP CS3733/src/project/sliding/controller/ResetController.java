package project.sliding.controller;
import java.util.ArrayList;

import project.sliding.boundary.MathPuzzleApp;
import project.sliding.boundary.UpdateButtons;
import project.sliding.model.Model;
import project.sliding.model.MoveType;


public class ResetController {

	Model model;
	MathPuzzleApp app;
	
	public ResetController(Model m, MathPuzzleApp app) {
		this.model = m;
		this.app = app;
	}

	public void reset() {
		model.resetPuzzle();
		UpdateButtons.enableButtons(app, new ArrayList<MoveType>());
		app.repaint();
	}
}
