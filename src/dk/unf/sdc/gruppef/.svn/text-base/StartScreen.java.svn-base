package dk.unf.sdc.gruppef;

import android.graphics.Canvas;
import android.graphics.Paint;

public class StartScreen {
	Button Start;
	public StartScreen() {
		Start = new Button(50, 30, 10,"Start");
	}
	public void Draw(Canvas c, Paint p) {
		Start.Draw(c, p);
	}
	public void SetScale(int x, int height, int width ){
		int max = Math.max(height, width);
		int nwidth = (int) (max / (width*1.2) * 100) ;
		Start = new Button(nwidth, 50, 20, Board.GRAY_COLOR,"Start");
		Start.setSmallest(x);
	}
	
	public boolean StartGame(int x, int y) {
		return Start.IsClicked(x, y);
	}
}
