package dk.unf.sdc.gruppef;

import android.graphics.Canvas;
import android.graphics.Paint;

public class DrawLine {
	public float s_x;
	public float s_y;
	public float e_x;
	public float e_y;
	public DrawLine(float start_x, float start_y, float end_x, float end_y) {
		s_x = start_x/100.f;
		e_x = end_x/100.f;
		s_y = start_y/100.f;
		e_y = end_y/100.f; 
	}
	public void Draw(Canvas c, Paint p)
	{
		c.drawLine(s_x, s_y, e_x, e_y, p);
	}
}
