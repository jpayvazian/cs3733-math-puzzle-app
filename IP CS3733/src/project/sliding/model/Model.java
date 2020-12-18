package project.sliding.model;

import java.util.ArrayList;

public class Model {

	Puzzle puzzle;
	Tile selectedTile;
	boolean gameOver;
	boolean gameWin;
	
	public Model() {}
	
	public void setPuzzle(Puzzle p) { 
		puzzle = p;
		gameOver = false;
		gameWin = false;
		selectedTile = null;
	}
	public Puzzle getPuzzle() { return puzzle; }
	
	public void setSelectedTile(Tile t) { selectedTile = t; }
	public void clearSelectedTile() { selectedTile = null; } 
	public Tile getSelectedTile() { return selectedTile; }
	
	public boolean isGameOver() { return gameOver; }
	public void setGameOver(boolean flag) { gameOver = flag; }
	
	public boolean isGameWin() { return gameWin; }
	public void setGameWin(boolean flag) { gameWin = flag; }
	
	//returns list of available moves for a given tile
	public ArrayList<MoveType> availableMoves(Tile t){
		ArrayList<MoveType> moves = new ArrayList<>();
		boolean up = true;
		boolean down = true;
		boolean left = true;
		boolean right = true;
		
		int row = t.getRow();
		int col = t.getColumn();
		int val = t.getValue();
		
		//checking each condition that would make a direction invalid		
		//up - cant be on top row, if current tile is empty, or if tile above is empty
		if(row == 0 || puzzle.getTile(new Coordinate(row-1, col)).isEmpty() || t.isEmpty()) {
			up = false;
		}
		//down - cant be on bottom row, if current tile is empty, if tile below is empty, or if division has a remainder
		if(row == 2 || puzzle.getTile(new Coordinate(row+1, col)).isEmpty() || puzzle.getTile(new Coordinate(row+1, col)).getValue() % val != 0 || t.isEmpty()) {
			down = false;
		}
		//left - cant be on left column, if current tile is empty, if tile to left is empty, or if subtraction is less than 1
		if(col == 0 || puzzle.getTile(new Coordinate(row, col-1)).isEmpty() || puzzle.getTile(new Coordinate(row, col-1)).getValue() - val < 1 || t.isEmpty()) {
			left = false;
		}
		//right - cant be on right column, if current tile is empty, or if tile to right is empty
		if(col == 2 || puzzle.getTile(new Coordinate(row, col+1)).isEmpty() || t.isEmpty()) {
			right = false;
		}
		
		if(up) { //if direction is valid, add to list of available moves
			moves.add(MoveType.Up);
		}
		if(down) {
			moves.add(MoveType.Down);
		}
		if(left) {
			moves.add(MoveType.Left);
		}
		if(right) {
			moves.add(MoveType.Right);
		}
		return moves; 
	}
	
	//moves selected tile in given direction by updating tile that is being moved to
	//assumed this will only be called for a valid move in a tiles list of available moves
	public void move(MoveType dir) {
		int up = 0;
		int down = 0;
		int left = 0;
		int right = 0;
		
		if(dir == MoveType.Up) { //using these values to get the coordinate of tile being moved to
			up = -1;
		}
		else if(dir == MoveType.Down) {
			down = 1;
		}
		else if(dir == MoveType.Left) {
			left = -1;
		}
		else if(dir == MoveType.Right) {
			right = 1;
		}
		int startVal = selectedTile.getValue();
		int row = selectedTile.getRow();
		int col = selectedTile.getColumn();
		int endVal = puzzle.getTile(new Coordinate(row+up+down, col+right+left)).getValue(); //get the original value of tile being moved to 
		int finalVal = 0;
		
		if(dir == MoveType.Up) {//up - multiply
			finalVal = startVal * endVal;
		}
		else if(dir == MoveType.Down) {//down - divide
			finalVal = endVal / startVal;
		}
		else if(dir == MoveType.Left) {//left - subtract
			finalVal = endVal - startVal;
		}
		else if(dir == MoveType.Right) {//right add
			finalVal = startVal + endVal;
		}
		
		this.getPuzzle().getTile(new Coordinate(row+up+down, col+right+left)).setValue(finalVal);//update tile value from operation
		this.getSelectedTile().setEmpty(true); //clear the tile that was moved
		
	}
	//clear game conditions and reset the puzzle
	public void resetPuzzle() {
		puzzle.reset();
		this.clearSelectedTile();
		this.setGameOver(false);
		this.setGameWin(false);
		
	}
	//checks win condition use case if only center tile remains
	public boolean isWinCondition() {
		int emptyTiles = 0;
		boolean isWinnerPresent = false;
		for (Tile t : puzzle.tiles) {
			if (t.isEmpty()) {
				emptyTiles++; //must have 8 empty tiles
			}
			if(t.isWinner()) {
				if(!t.isEmpty()) { //winner tile must be non-empty
					isWinnerPresent = true;
				}
			}
		}
		if (emptyTiles == 8 && isWinnerPresent) {//true if both conditions met
			return true;
		}
		else return false;
	}

	//checks lose condition use case if win condition is false and no more valid moves
	public boolean isLoseCondition() {
		int validMoves = 0;
		
		for (Tile t : puzzle.tiles) {
			validMoves += availableMoves(t).size();//checking each tiles available moves
		}
		
		if (validMoves == 0 && !this.isWinCondition()) { //no valid moves and not a win condition is a loss
			return true;
		} else
			return false;
	}

}
