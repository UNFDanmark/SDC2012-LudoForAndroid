package dk.unf.sdc.gruppef;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;

public class Player {
	private static int id = 0;
	private final float RADIUS = 10;
	private int mColor;
	private boolean mIsInGame = false;
	private boolean mIsDone = false;
	private Box mCurrentBox;
	private int RealId;
	private int mId;

	public Player(int Color) {
		mColor = Color;
		mId = -1;
		RealId = ++id;
	}

	public int getColor() {
		return mColor;
	}

	public boolean IsInGame() {
		return mIsInGame;
	}

	public void SetCurrentBox(Box p) {
		mCurrentBox = p;
	}

	public Box GetCurrentBox() {
		return mCurrentBox;
	}

	public void GetRoll(int roll) {
		// TODO fix
		mCurrentBox.RemovePlayer(this);
		Box next = mCurrentBox;
		if(next.IsLastBox())
			mIsDone = true;
		for (int i = 0; i < roll; i++)
			if (next.GetWinColor() == mColor)
				next = next.GetNextWinBox();
			else
				next = next.GetNextBox();
		mCurrentBox = next;
		next.AddPlayer(this);
	}

	public void SetInGame() {
		mIsInGame = true;
	}

	public void SetInGame(boolean b) {
		mIsInGame = false;
	}
	public void Draw(int x, int y, Canvas canv) {
		if(mCurrentBox.IsLastBox() && !mIsDone){
			mIsDone = true;
		}
		if(mIsDone) return;
		Paint p = new Paint();
		switch (mColor) {
		case Board.YELLOW_COLOR:
			p.setColor(0xFFC58917);
			break;
		case Board.BLUE_COLOR:
			p.setColor(0xFF3BB9FF);
			break;
		case Board.RED_COLOR:
			p.setColor(0xFFFAAFBE);
			break;
		case Board.GREEN_COLOR:
			p.setColor(0xFF357C26);
			break;
		}
		p.setStrokeWidth(0);
		canv.drawCircle(x, y, RADIUS, p);
		p.setStyle(Style.FILL);
		p.setColor(Color.BLACK);
		p.setStrokeWidth(3);
		// canv.drawCircle(x, y, RADIUS, p);
		p.setTextSize(25);
		if (mId != -1)
			canv.drawText(Integer.valueOf(mId + 1).toString(), x - 7, y + 7, p);
	}

	public boolean IsDone() {
		return mIsDone;
	}

	public void SetDone(boolean mIsDone) {
		this.mIsDone = mIsDone;
	}

	public int getID() {
		return mId;
	}

	public void setID(int mId) {
		this.mId = mId;
	}

	
	public boolean playerCanMove(int steps) {
		int color = getColor();
		Box start = GetCurrentBox();
		for(int i = 0; i < steps; i++) {
			if(start.IsLastBox())
				return false;
			if(start.GetWinColor() == color) 
				start = start.GetNextWinBox();
			else
				start = start.GetNextBox();
		}
		return true;
	}
	
	public int GetId() {
		return RealId;
	}

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return ((Player)o).getID() == this.getID();
	}
	
	
}
