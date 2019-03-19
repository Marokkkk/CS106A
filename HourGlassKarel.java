/*
 * File: HourGlassKarel.java
 * Author : Chirag Maroke
 * Date : 19 March 2019
 * Citation : N.A.
 * --------------------------
 */

import stanford.karel.*;

public class HourGlassKarel extends SuperKarel {
	public void run() {
		putBeeper();
		FillRow();
		FillFirstDiagonal();
		turnRight();
		FillRow();
		FillSecondDiagonal();
		turnRight();
		while(frontIsClear()) {
			move();
			pickBeeper();
		}
	}
	
	private void FillRow() {
		while(frontIsClear()) {
			move();
			putBeeper();
		}
	}
	
	private void FillFirstDiagonal() {
		turnLeft();
		while(frontIsClear()) {
			move();
			turnLeft();
			move();
			if(noBeepersPresent()) {
			putBeeper();
			}
			turnRight();
		}
	}
		
	private void FillSecondDiagonal() {
		turnRight();
			while(frontIsClear()) {
				move();
				turnRight();
				move();
				if(noBeepersPresent()) {
					putBeeper();
				}
				turnLeft();		
				}
	}
}
