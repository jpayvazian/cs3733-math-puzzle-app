package project.sliding.boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JPanel;

import project.sliding.model.Coordinate;
import project.sliding.model.Model;
import project.sliding.model.Puzzle;
import project.sliding.model.Tile;

public class PuzzlePanel extends JPanel {

	Model model;
	public static final int boxSize = 80;
	public static final int offset = 2;

	public PuzzlePanel(Model m) {
		this.model = m;
	}

	public Rectangle computeRectangle(Tile t) {
		int row = t.getRow();
		int col = t.getColumn();
		Rectangle r = new Rectangle(row * boxSize + offset, col * boxSize + offset, boxSize - 2 * offset, boxSize - 2 * offset);
		return r;
	}
	
	public Coordinate pointToCoordinate(Point p) {
		return new Coordinate(p.y/boxSize, p.x/boxSize);
	}
	
	public Point coordinateToPoint(Coordinate c) {
		return new Point(c.col * PuzzlePanel.boxSize + PuzzlePanel.boxSize/2, c.row * PuzzlePanel.boxSize + PuzzlePanel.boxSize/2);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (model == null) { return; }
		Tile selectedTile = model.getSelectedTile();
		Puzzle puzzle = model.getPuzzle();
		
		for (Tile t : puzzle) {
			
			g.setColor(new Color(0,0,0,50));
			
			if(model.isGameWin() && t.isWinner()) { //highlight center yellow if win
			g.setColor(Color.yellow);
			}
						
			Rectangle r = computeRectangle(t);
			g.fillRect(r.x, r.y, r.width, r.height);
			
			g.setFont(new Font("Times New Roman", 1, 50));
			
			if(t.equals(selectedTile)) { //highlight selected tile number as red
				g.setColor(Color.red);
			}
			else { g.setColor(Color.black); }
			
			if(!t.isEmpty()) { //adjusting font sizes and offsets for gui
				if(t.getValue() >= 10 && t.getValue() < 100) {
					g.drawString(String.valueOf(t.getValue()), 16 + 80*t.getColumn(), 50 + 80*t.getRow());
				}
				else if(t.getValue() >= 100 && t.getValue() < 1000) {
					g.setFont(new Font("Times New Roman", 1, 40));
					g.drawString(String.valueOf(t.getValue()), 9 + 80*t.getColumn(), 50 + 80*t.getRow());
				}
				else if(t.getValue() > 1000) {
					g.setFont(new Font("Times New Roman", 1, 35));
					g.drawString(String.valueOf(t.getValue()), 4 + 80*t.getColumn(), 50 + 80*t.getRow());
				}
				else { 
					g.drawString(String.valueOf(t.getValue()), 28 + 80*t.getColumn(), 50 + 80*t.getRow()); 
				}
			}
		}
	}
}
