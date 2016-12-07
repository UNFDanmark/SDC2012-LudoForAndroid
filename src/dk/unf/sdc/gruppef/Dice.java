package dk.unf.sdc.gruppef;

import java.util.Random;

public class Dice {

	private int mLastRoll;
	// used to move the 
	private int mCountDown;
	public Dice() {
		mLastRoll = -1;
	}

	public int roll() {

		int min = 1;
		int max = 6;

		Random r = new Random();
		mLastRoll = r.nextInt(max - min + 1) + min;
		mCountDown = mLastRoll;
		//mLastRoll = 1;
		//mCountDown = 1;
		return mLastRoll;
		//return mLastRoll;
	}
	
	public int GetLastRoll() {
		return mLastRoll;
	}
	
	public void ShortCountDown() {
		mCountDown = 1;
	}

	public int GetCountDown(){
		return mCountDown;
	}
	
	public void DecrementCountDown() {
		mCountDown--;
	}

	public void Clear() {
		mLastRoll = -1;
	}
}