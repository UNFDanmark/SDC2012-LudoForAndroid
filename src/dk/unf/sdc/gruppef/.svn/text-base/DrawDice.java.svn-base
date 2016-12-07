package dk.unf.sdc.gruppef;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class DrawDice {
	private final int mWidth = 10;
	private int mRealWidth;
	private float mX;
	private float mY;
	private int mNumber;
	private DrawSquare DiceImage;
	private Board mGame;
	
	public DrawDice(int x, int y, Board game) {
		mRealWidth = mWidth;
		mX = x / 100.f;
		mY = y / 100.f;
		// not set
		mNumber = -1;
		DiceImage = new DrawSquare(x, y, mWidth, Board.BLUE_COLOR);
		mGame = game;
	}
	
	public void setSmallest(int smallest){
		mX *= smallest;
		mY *= smallest;
		mRealWidth *= smallest/100;
		DiceImage.setSmallest(smallest);
	}
	
	public void setRoll(int roll){
		mNumber = roll;
	}
	
	public void Draw(Canvas c, Paint p) {
		Paint nPaint = new Paint(p);
	
		mNumber = mGame.GetDiceNumber();
		
		if(mGame.GetTurn() == 1){
			DiceImage.SetColor(Board.YELLOW_COLOR);	
		}
		
		if(mGame.GetTurn() == 2){
			DiceImage.SetColor(Board.GREEN_COLOR);	
		}
		
		if(mGame.GetTurn() == 3){
			DiceImage.SetColor(Board.RED_COLOR);	
		}

		if(mGame.GetTurn() == 4){
			DiceImage.SetColor(Board.BLUE_COLOR);	
		}
		
		DiceImage.Draw(c, nPaint);
		Integer nbr = Integer.valueOf(mNumber);
		nPaint.setColor(Color.BLACK);
		nPaint.setTextSize(50);
		if(nbr > 0)
			c.drawText(nbr.toString(),mX-15, mY+15, nPaint); 
	}
	
	public boolean IsClicked(int x, int y) {
		float max_x = mX + mRealWidth,
				max_y = mY + mRealWidth,
				min_x = mX - mRealWidth,
				min_y = mY - mRealWidth;
		boolean Value = (x < max_x && x > min_x &&
				y < max_y && y > min_y);
		return Value;
	}
}
