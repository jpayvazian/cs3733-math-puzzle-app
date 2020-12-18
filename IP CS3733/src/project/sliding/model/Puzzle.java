package project.sliding.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Puzzle implements Iterable<Tile>{

	ArrayList<Tile> tiles = new ArrayList<>();
	ArrayList<Tile> copy = new ArrayList<>();
	public final int numRows;
	public final int numCols;
	
	public Puzzle(int numRows, int numCols) {
		this.numRows = numRows;
		this.numCols = numCols;
	}
	
	public void add(Tile t, int row, int col) {
		t.setRow(row);
		t.setColumn(col);
		tiles.add(t);
		copy.add(t.copy());
	}
	
	@Override
	public Iterator<Tile> iterator() {
		return tiles.iterator();
	}
	
	public Tile getTile(Coordinate c) {
		for(Tile t : tiles ) {
			if(t.contains(c)) {
				return t;
			}
		}
		return null;
	}

	//clears current tiles and resets to originals
	public void reset() {
		tiles.clear();
		for(Tile t : copy) {
			tiles.add(t.copy());
		}
	}

}
