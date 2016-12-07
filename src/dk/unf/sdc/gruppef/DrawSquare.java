package dk.unf.sdc.gruppef;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;

public class DrawSquare {
	private DrawLine[] lines;
	private int mColor;
	private float mX, mY;
	private float mWidth;
	
	public DrawSquare(int x, int y, int width, int Color) {
		lines = new DrawLine[4];
		float small_x = x - width, 
				big_x = x + width, 
				small_y = y - width, 
				big_y = y + width;
		lines[0] = new DrawLine(small_x, small_y, small_x, big_y);
		lines[1] = new DrawLine(small_x, big_y, big_x, big_y);
		lines[2] = new DrawLine(big_x, big_y, big_x, small_y);
		lines[3] = new DrawLine(big_x, small_y, small_x, small_y);

		mColor = Color;
		
		mX = x/100.f;
		mY = y/100.f;
		mWidth = width/100.f;
	}

	public DrawSquare(int x, int y, int width) {
		lines = new DrawLine[4];
		float small_x = x - width, big_x = x + width, small_y = y - width, big_y = y
				+ width;
		lines[0] = new DrawLine(small_x, small_y, small_x, big_y);
		lines[1] = new DrawLine(small_x, big_y, big_x, big_y);
		lines[2] = new DrawLine(big_x, big_y, big_x, small_y);
		lines[3] = new DrawLine(big_x, small_y, small_x, small_y);

		mColor = Board.WHITE_COLOR;
		
		mX = x/100.f;
		mY = y/100.f;
		mWidth = width/100.f;
	}

	public void setSmallest(float smallest) {
		for (int i = 0; i < 4; i++) {
			lines[i].s_x *= smallest;
			lines[i].s_y *= smallest;
			lines[i].e_x *= smallest;
			lines[i].e_y *= smallest;
		}
		mX *= smallest;
		mY *= smallest;
		mWidth *= smallest;
	}

	public void Draw(Canvas c, Paint p) {
		if (mColor != Board.NONE_COLOR) {
			Paint paint = new Paint(p);
			// mPaint.setColor(Color.CYAN); canvas.drawRect(33, 60, 77, 77,
			// mPaint
			// * );
			paint.setStrokeWidth(0);
			switch (mColor) {
			case Board.BLUE_COLOR:
				paint.setColor(Color.BLUE);
				break;
			case Board.GREEN_COLOR:
				paint.setColor(Color.GREEN);
				break;
			case Board.YELLOW_COLOR:
				paint.setColor(Color.YELLOW);
				break;
			case Board.RED_COLOR:
				paint.setColor(Color.RED);
				break;
			case Board.WHITE_COLOR:
				paint.setColor(Color.WHITE);
				break;
			case Board.GRAY_COLOR:
				paint.setColor(Color.GRAY);
				break;
			}
			c.drawRect(lines[0].s_x, lines[0].s_y, lines[1].e_x, lines[1].e_y,
					paint);
		}
		Paint tmp = new Paint(p);
		tmp.setStyle(Style.STROKE);
		tmp.setColor(Color.BLACK);
		for (int i = 0; i < 4; i++)
			lines[i].Draw(c, tmp);
	}
	
	public void SetColor(int Color){
		mColor = Color;
	}
	
	public int GetX() {
		return (int)mX;
	}
	
	public int GetY() {
		return (int)mY;
	}
	public int GetWidth() {
		return (int)mWidth;
	}
}
