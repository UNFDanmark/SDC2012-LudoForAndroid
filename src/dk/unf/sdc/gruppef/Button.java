package dk.unf.sdc.gruppef;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Button extends DrawSquare{
	
	private String mString;

	public Button(int x, int y, int width, String str) {
		super(x, y, width);
		mString = new String(str);
	}
	
	public Button(int x, int y, int width, int Color, String str) {
		super(x, y, width, Color);
		mString = new String(str);
	}


	@Override
	public void Draw(Canvas c, Paint p) {
		super.Draw(c, p);
		// TODO draw text
		Paint paint = new Paint(p);
		paint.setColor(Color.BLACK);
		paint.setTextSize(50);
		if(mString.equals("Start"))
			c.drawText(mString,GetX()-50, GetY() + 20, paint);
		else
			c.drawText(mString,GetX()-15, GetY()+15, paint); 
	}
	
	public boolean IsClicked(int x, int y){
		int short_x = GetX() - GetWidth(),
			short_y = GetY() - GetWidth(),
			long_x = GetX() + GetWidth(),
			long_y = GetY() + GetWidth();
		return (x > short_x &&
				 x < long_x &&
				 y > short_y &&
				 y < long_y);
	}

	public String GetString() {
		return mString; 
	}
	
	
	
}
