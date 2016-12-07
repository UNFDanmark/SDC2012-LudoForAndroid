package dk.unf.sdc.gruppef;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class DrawThread extends Thread {
	private boolean mRun = false;
	private Draw mDraw;
	private SurfaceHolder mHolder;
	
	public DrawThread(Draw draw) {
		mDraw = draw;
		mHolder = draw.getHolder();
	}
	
	public void setRunning(boolean run) {
		mRun = run;
	}
	
	@Override
	public void run() {
		Canvas canvas = null;
		while(mRun) {
			canvas = mHolder.lockCanvas();
			// if we don't get a canvas continue
			if(canvas == null)
				continue;
			mDraw.DoDraw(canvas);
			mHolder.unlockCanvasAndPost(canvas);
		}
	}
}
