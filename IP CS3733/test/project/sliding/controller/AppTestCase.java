package project.sliding.controller;

import org.junit.After;
import org.junit.Before;

import project.sliding.boundary.MathPuzzleApp;
import project.sliding.model.ModelTestCase;

public abstract class AppTestCase extends ModelTestCase{

	protected MathPuzzleApp app;
	
	@Before
	public void createApp() {
		app = new MathPuzzleApp(model);
		app.setVisible(true);
	}
	
	@After
	public void tearDown() {
		app.setVisible(false);
	}

}
