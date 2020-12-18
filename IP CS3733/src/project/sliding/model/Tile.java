package project.sliding.model;

public class Tile {

	int value;
	int row;
	int col;
	boolean isWinner;
	boolean isEmpty;
	
	public Tile(int value) {
		this.value = value;
		isWinner = false;
		isEmpty = false;
	}
	
	public boolean isWinner() { return isWinner; }
	public void setWinner(boolean flag) { isWinner = flag; }
	
	public boolean isEmpty() { return isEmpty; }
	public void setEmpty(boolean flag) { isEmpty = flag; }
	
	public void setRow(int r) { this.row = r; }
	public int getRow() { return row; }
	
	public void setColumn(int c) { this.col = c; }
	public int getColumn() { return col; }
	
	public void setValue(int v) { this.value = v; }
	public int getValue() { return value; }
	
	//returns true if given coordinate matches tile position
	public boolean contains(Coordinate c) {
		if (c.col == col && c.row == row) {
			return true;
		}
		else return false;
	}

	//makes a copy of tile
	public Tile copy() {
		Tile t = new Tile(value);
		t.setWinner(isWinner);
		t.setRow(row);
		t.setColumn(col);
		return t;
	}

}
