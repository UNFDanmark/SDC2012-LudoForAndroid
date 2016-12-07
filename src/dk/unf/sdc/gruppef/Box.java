package dk.unf.sdc.gruppef;

import java.util.ArrayList;

public class Box {
	private int mX;
	private int mY;
	// the next box after this one
	private Box mNext = null;
	// Set to Board.NONE_COLOR
	private int mWinColor = Board.NONE_COLOR;
	/* 
	 * 	If mWinColor is set to a color then 
	 * 	we must set mNextWinBox to the box, that goes toward the middle	
	 */
	private Box mNextWinBox = null;
	
	// this is the last box in the middle, if get here, then the player is done
	private boolean mIsLastBox = false;
	
	// Players on the box
	private ArrayList<Player> mOnBox;
	
	public Box(int x, int y)
	{
		mOnBox = new ArrayList<Player>();
		mX = x;
		mY = y;
	}
	
	public Box(int x, int y, int wincolor)
	{
		mX = x;
		mY = y;
		// TODO set mNextWinBox...
		mWinColor = wincolor;
		mOnBox = new ArrayList<Player>();
	}
	
	public Box(int x, int y, boolean IsLastBox) 
	{
		mX = x;
		mY = y;
		mIsLastBox = IsLastBox;
		mOnBox = new ArrayList<Player>();
	}
	
	public void SetNextBox(Box next) {
		mNext = next;
	}
	
	public ArrayList<Player> GetPlayersOnBox() {
		return mOnBox;
	}
	
	public boolean IsThereAPlayer() {
		return mOnBox.size() != 0;
	}
	
	public void AddPlayer(Player p) {
		mOnBox.add(p);
	}
	
	public boolean RemovePlayer(Player p) {
		return mOnBox.remove(p);
	}
	
	public boolean IsPlayerOnBox(Player p) {
		return mOnBox.contains(p);
	}
	
	public int GetX() {
		return mX;
	}
	
	public int GetY() {
		return mY;
	}
	
	public Box GetNextBox() {
		return mNext;
	}
	
	public int GetWinColor() {
		return mWinColor;
	}
	
	public void SetNextWinBox(Box b) {
		mNextWinBox = b;
	}
	
	public Box GetNextWinBox() {
		return mNextWinBox;
	}
	
	public boolean IsLastBox() {
		return mIsLastBox;
	}
	
	public void SetWinColor(int Color) {
		mWinColor = Color;
	}

	public ArrayList<Player> CheckCollision(Player moveable) {
		ArrayList<Player> p = new ArrayList<Player>();
		if(mOnBox.size() == 1)
			return p;
		for(Player plr: mOnBox) {
			if(plr.GetId() != moveable.GetId())
				p.add(plr);
		}
		return p;
		
	}
}
