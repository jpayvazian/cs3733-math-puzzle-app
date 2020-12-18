package project.sliding.controller;
import javax.swing.JOptionPane;
import project.sliding.boundary.MathPuzzleApp;

public class ExitController {
	MathPuzzleApp app;
	
	public ExitController(MathPuzzleApp app) {
		this.app = app;
	}

	public void exit() {
		int exit = JOptionPane.showConfirmDialog(app, "Do you wish to exit application?");
		if (exit == JOptionPane.OK_OPTION) {
			app.setVisible(false);
			app.dispose();
		}
	}
}
