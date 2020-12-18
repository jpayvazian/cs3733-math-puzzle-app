package project.sliding.controller;

import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import project.sliding.boundary.MathPuzzleApp;
import project.sliding.boundary.UpdateButtons;
import project.sliding.model.Model;
import project.sliding.model.MoveType;

public class MoveTileController {

	Model model;
	MathPuzzleApp app;
	
	public MoveTileController(Model m, MathPuzzleApp app) {
		this.model = m;
		this.app = app;
	}
	
	public boolean move(MoveType dir) {
		if(model.isGameOver() || model.getSelectedTile() == null) { return false; }
		
			model.move(dir);
			UpdateButtons.enableButtons(app, new ArrayList<MoveType>());
			app.repaint();
			
			if(model.isWinCondition()) { //check win condition after each move
				model.setGameOver(true);
				model.setGameWin(true);
			
				JOptionPane.showMessageDialog(app, "Congratulations, You Win!");
			}

		else if(model.isLoseCondition()){ //check lose condition
				model.setGameOver(true);
				JOptionPane.showMessageDialog(app, "Game Over, You Lose");
			}
		return true;
	}
}
