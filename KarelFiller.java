*
 * File : KarelFiller.java
 * Author : Chirag Maroke
 * Date : 19th March 2019
 * Citations : N.A.
 * --------------------------------
 * KarelFiller program looks for pairs of beepers separated by 
 * empty horizontal space and "fills in" the space between 
 * them with beepers to create a contiguous line of beepers.
 */

import stanford.karel.* ; 

public class KarelFiller extends SuperKarel {
	
	public void run() {
		while(frontIsClear()) { //condition to test if top most row is reached.
			FillOneRow();
			ChangeDirections();
		}
	}
	
	/*
	 * Traverse right or left according to it's location on the row.
	 */
	private void FillOneRow() {
		while(frontIsClear()) {
			DetectFirstBeeperOfPair();
		    FillBetweenPair();
		}
	}
	
	/*
	 * Moves to next row once a row filling is completed.
	 */
	private void ChangeDirections() {
		if(facingWest()) {
			CheckRight();
		}
		else{
			CheckLeft();
		}
	}
	
	/*
	 * When at east end of row, moves to next row by checking left.
	 */
	private void CheckLeft() {
		turnLeft();
		if(frontIsClear()) {
		move();
		turnLeft();
		}
	}
	
	/*
	 * When at west end of row, moves to next row by checking right.
	 */
	private void CheckRight() {
		turnRight();
		if(frontIsClear()) {
		move();
		turnRight();
		}
	}
	
	/*
	 * Self-Explanatory; required because beepers require between pair
	 */
	private void DetectFirstBeeperOfPair() {
		while(noBeepersPresent()) {
			move();
		}
		move();
	}

	/*
	 * Self explanatory
	 */
	private void FillBetweenPair() {
		while(noBeepersPresent()) {
			putBeeper();
			move();
		}
		if(frontIsClear()) {
		move();
		}
	}
}
