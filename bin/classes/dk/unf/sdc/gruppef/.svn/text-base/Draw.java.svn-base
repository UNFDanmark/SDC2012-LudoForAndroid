package dk.unf.sdc.gruppef;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Draw extends SurfaceView implements SurfaceHolder.Callback {
	private DrawSquare[] map = {
			// mål start gul
			new DrawSquare(50 - 40, 50, 3), // 1
			// gul (henad øvre)
			new DrawSquare(50 - 40, 50 - 7, 3),
			new DrawSquare(50 - 34, 50 - 7, 3, Board.YELLOW_COLOR),
			new DrawSquare(50 - 28, 50 - 7, 3),
			new DrawSquare(50 - 22, 50 - 7, 3), // 5
			new DrawSquare(50 - 16, 50 - 7, 3),
			// gul hjørne
			new DrawSquare(50 - 9, 50 - 9, 3),
			// gul (opad venstre)
			new DrawSquare(50 - 7, 50 - 16, 3),
			new DrawSquare(50 - 7, 50 - 22, 3),
			new DrawSquare(50 - 7, 50 - 28, 3),// 10
			new DrawSquare(50 - 7, 50 - 34, 3),
			new DrawSquare(50 - 7, 50 - 40, 3),
			// mål start grøn
			new DrawSquare(50, 50 - 40, 3),
			// grøn opad (venstre)
			new DrawSquare(50 + 7, 50 - 40, 3),
			new DrawSquare(50 + 7, 50 - 34, 3, Board.GREEN_COLOR), // 15
			new DrawSquare(50 + 7, 50 - 28, 3),
			new DrawSquare(50 + 7, 50 - 22, 3),
			new DrawSquare(50 + 7, 50 - 16, 3),
			// grøn hjørne
			new DrawSquare(50 + 9, 50 - 9, 3),
			// grøn henad (venstre)
			new DrawSquare(50 + 16, 50 - 7, 3), // 20
			new DrawSquare(50 + 22, 50 - 7, 3),
			new DrawSquare(50 + 28, 50 - 7, 3),
			new DrawSquare(50 + 34, 50 - 7, 3),
			new DrawSquare(50 + 40, 50 - 7, 3),
			// mål start rød
			new DrawSquare(50 + 40, 50, 3),
			// rød (henad nedre)
			new DrawSquare(50 + 40, 50 + 7, 3), // 25
			new DrawSquare(50 + 34, 50 + 7, 3, Board.RED_COLOR),
			new DrawSquare(50 + 28, 50 + 7, 3),
			new DrawSquare(50 + 22, 50 + 7, 3),
			new DrawSquare(50 + 16, 50 + 7, 3),
			// rød hjørne
			new DrawSquare(50 + 9, 50 + 9, 3), // 30

			// rød nedad (højre)
			new DrawSquare(50 + 7, 50 + 16, 3),
			new DrawSquare(50 + 7, 50 + 22, 3),
			new DrawSquare(50 + 7, 50 + 28, 3),
			new DrawSquare(50 + 7, 50 + 34, 3),
			new DrawSquare(50 + 7, 50 + 40, 3), // 35
			// mål start blå
			new DrawSquare(50, 50 + 40, 3),
			// blå nedad (venstre)
			new DrawSquare(50 - 7, 50 + 40, 3),
			new DrawSquare(50 - 7, 50 + 34, 3, Board.BLUE_COLOR),
			new DrawSquare(50 - 7, 50 + 28, 3),
			new DrawSquare(50 - 7, 50 + 22, 3), // 40
			new DrawSquare(50 - 7, 50 + 16, 3),

			// blå hjørne
			new DrawSquare(50 - 9, 50 + 9, 3),
			// blå (henad øvre)
			new DrawSquare(50 - 16, 50 + 7, 3),
			new DrawSquare(50 - 22, 50 + 7, 3),
			new DrawSquare(50 - 28, 50 + 7, 3), // 45
			new DrawSquare(50 - 34, 50 + 7, 3),
			new DrawSquare(50 - 40, 50 + 7, 3),

			// Omkreds
			new DrawSquare(50, 50, 49, Board.GRAY_COLOR),
			// mål
			new DrawSquare(50, 50, 6),
			// rød mål (højre)
			new DrawSquare(50 + 9, 50, 3, Board.RED_COLOR), // 50 // 51?
			new DrawSquare(50 + 15, 50, 3, Board.RED_COLOR),
			new DrawSquare(50 + 21, 50, 3, Board.RED_COLOR),
			new DrawSquare(50 + 27, 50, 3, Board.RED_COLOR),
			new DrawSquare(50 + 33, 50, 3, Board.RED_COLOR),
			// blå mål (nedad)
			new DrawSquare(50, 50 + 9, 3, Board.BLUE_COLOR), // 55
			new DrawSquare(50, 50 + 15, 3, Board.BLUE_COLOR),
			new DrawSquare(50, 50 + 21, 3, Board.BLUE_COLOR),
			new DrawSquare(50, 50 + 27, 3, Board.BLUE_COLOR),
			new DrawSquare(50, 50 + 33, 3, Board.BLUE_COLOR),

			// grøn mål(opad)
			new DrawSquare(50, 50 - 9, 3, Board.GREEN_COLOR), // 60
			new DrawSquare(50, 50 - 15, 3, Board.GREEN_COLOR),
			new DrawSquare(50, 50 - 21, 3, Board.GREEN_COLOR),
			new DrawSquare(50, 50 - 27, 3, Board.GREEN_COLOR),
			new DrawSquare(50, 50 - 33, 3, Board.GREEN_COLOR),

			// gul mål (venstre)
			new DrawSquare(50 - 9, 50, 3, Board.YELLOW_COLOR), // 65
			new DrawSquare(50 - 15, 50, 3, Board.YELLOW_COLOR),
			new DrawSquare(50 - 21, 50, 3, Board.YELLOW_COLOR),
			new DrawSquare(50 - 27, 50, 3, Board.YELLOW_COLOR),
			new DrawSquare(50 - 33, 50, 3, Board.YELLOW_COLOR),

			// hjem blå
			new DrawSquare(50 - 23, 50 + 30, 8, Board.BLUE_COLOR), // 70
			new DrawSquare(50 - 19, 50 + 34, 3),
			new DrawSquare(50 - 27, 50 + 34, 3),
			new DrawSquare(50 - 19, 50 + 26, 3),
			new DrawSquare(50 - 27, 50 + 26, 3),
			// hjem rød
			new DrawSquare(50 + 30, 50 + 23, 8, Board.RED_COLOR),
			new DrawSquare(50 + 26, 50 + 27, 3),
			new DrawSquare(50 + 34, 50 + 27, 3),
			new DrawSquare(50 + 34, 50 + 19, 3),
			new DrawSquare(50 + 26, 50 + 19, 3),
			// hjem gul
			new DrawSquare(50 - 30, 50 - 23, 8, Board.YELLOW_COLOR),
			new DrawSquare(50 - 26, 50 - 19, 3),
			new DrawSquare(50 - 34, 50 - 27, 3),
			new DrawSquare(50 - 34, 50 - 19, 3),
			new DrawSquare(50 - 26, 50 - 27, 3),
			// hjem grøn
			new DrawSquare(50 + 23, 50 - 30, 8, Board.GREEN_COLOR),
			new DrawSquare(50 + 19, 50 - 34, 3),
			new DrawSquare(50 + 19, 50 - 26, 3),
			new DrawSquare(50 + 27, 50 - 26, 3),
			new DrawSquare(50 + 27, 50 - 34, 3), //
	};
	private boolean sizeset = false;
	private DrawDice mDice;
	private DrawThread mThread;
	private Paint mPaint;
	private Board mGame;

	private StartScreen mStartScreen;
	// 0 = startscreen, 1 = mGame
	private int mScreenDraw = 0;

	public static int SMALLEST;

	public Draw(Context context) {
		super(context);
		getHolder().addCallback(this);
		mThread = new DrawThread(this);
		mPaint = new Paint();
		mPaint.setColor(Color.BLACK);
		mPaint.setStrokeWidth(3);

		mGame = new Board();
		// TODO FIX X,Y
		mDice = new DrawDice(120, 20, mGame);

		mStartScreen = new StartScreen();
	}

	public void DoDraw(Canvas canvas) {
		// loop through all the Square..
		canvas.drawColor(Color.WHITE);
		switch (mScreenDraw) {
		case 1:
			try {

				/*
				 * TODO implement this in DrawSquare mPaint.setStrokeWidth(0);
				 * mPaint.setColor(Color.CYAN); canvas.drawRect(33, 60, 77, 77,
				 * mPaint );
				 */

				for (int i = 48; i < map.length; i++) {
					map[i].Draw(canvas, mPaint);
				}
				for (int i = 0; i < 48; i++) {
					map[i].Draw(canvas, mPaint);
				}
				mDice.Draw(canvas, mPaint);
				mGame.Draw(canvas, mPaint);
			} catch (Exception d) {
			}
			break;
		case 0:
			
			mStartScreen.Draw(canvas, mPaint);
			break;
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		int x = (int) event.getX();
		int y = (int) event.getY();
		switch (mScreenDraw) {
		case 1:

			if (mGame.CanRoll()) {
				if (mDice.IsClicked(x, y)) {
					int roll = mGame.StartRoll();
					mDice.setRoll(roll);
				}
			}
			mGame.CheckButtonClick(x, y);
			if(mGame.isTotallyDone())
				mScreenDraw = 0;
			break;
		case 0:
			if(mStartScreen.StartGame(x, y)) {
				mScreenDraw = 1;
				mGame.Restart();
			}
			break;
		}
		return super.onTouchEvent(event);
	}

	public Board GetGame() {
		return mGame;
	}

	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		if (sizeset)
			return;
		for (int i = 0; i < map.length; i++) {
			map[i].setSmallest(Math.min(height, width));
		}
		mDice.setSmallest(Math.min(height, width));
		for (int i = 0; i < 48; i++) {
			mGame.AddBoxOuterBox(map[i].GetX(), map[i].GetY());
		}
		for (int i = map.length - 1; i > (map.length - 5); i--) {
			mGame.AddStartingBox(map[i].GetX(), map[i].GetY(),
					Board.GREEN_COLOR);
			mGame.AddStartingBox(map[i - 5].GetX(), map[i - 5].GetY(),
					Board.YELLOW_COLOR);
			mGame.AddStartingBox(map[i - 10].GetX(), map[i - 10].GetY(),
					Board.RED_COLOR);
			mGame.AddStartingBox(map[i - 15].GetX(), map[i - 15].GetY(),
					Board.BLUE_COLOR);
		}
		for (int i = 49 + 5; i > 49; i--) {
			mGame.AddWinBox(map[i].GetX(), map[i].GetY(), Board.RED_COLOR);
		}
		for (int i = 59; i > 54; i--) {
			mGame.AddWinBox(map[i].GetX(), map[i].GetY(), Board.BLUE_COLOR);
		}
		for (int i = 59 + 5; i > 59; i--) {
			mGame.AddWinBox(map[i].GetX(), map[i].GetY(), Board.GREEN_COLOR);
		}
		for (int i = 65 + 4; i > 65 - 1; i--)
			mGame.AddWinBox(map[i].GetX(), map[i].GetY(), Board.YELLOW_COLOR);
		mGame.AddLastBox(map[49].GetX(), map[49].GetY());
		SMALLEST = Math.min(height, width);
		mGame.SetBoxesUp();
		sizeset = true;
		
		mStartScreen.SetScale(SMALLEST, height, width );
	}

	public void surfaceCreated(SurfaceHolder holder) {
		if (!mThread.isAlive()) {
			mThread = new DrawThread(this);
			mThread.setRunning(true);
			mThread.start();
		}
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		if (mThread.isAlive()) {
			mThread.setRunning(false);
		}
	}
}
