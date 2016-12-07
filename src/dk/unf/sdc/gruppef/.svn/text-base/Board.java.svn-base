package dk.unf.sdc.gruppef;

import java.util.ArrayList;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;

public class Board {
	public static final int NONE_COLOR = 0;
	public static final int YELLOW_COLOR = 1;
	public static final int GREEN_COLOR = 2;
	public static final int RED_COLOR = 3;
	public static final int BLUE_COLOR = 4;
	public static final int GRAY_COLOR = 5;
	public static final int WHITE_COLOR = 6;

	// All the players
	private ArrayList<Player> Red, Blue, Green, Yellow;
	// The squares
	private ArrayList<Box> Boxes;
	// array list with an
	private ArrayList<Box> ZoneRed, ZoneBlue, ZoneYellow, ZoneGreen;

	// WinColorTrack
	private ArrayList<Box> WRed, WGreen, WBlue, WYellow;

	// So we know where the players start
	private Box StartRed, StartBlue, StartGreen, StartYellow;

	private Box LastWinBoxThingy;
	// The dice
	private Dice dice;

	/*
	 * 1 = GUL, 2 = GRØN, 3 = RØD, 4 = BLÅ,
	 */
	private int mTurn;

	private boolean mCanRoll;

	private ArrayList<Button> Buttons;

	private int RollCount = 0;

	private boolean IsTotallyDone = false;

	public boolean isTotallyDone() {
		return IsTotallyDone;
	}

	public Board() {
		Red = new ArrayList<Player>();
		Blue = new ArrayList<Player>();
		Green = new ArrayList<Player>();
		Yellow = new ArrayList<Player>();

		for (int i = 0; i < 4; i++) {
			Red.add(new Player(RED_COLOR));
			Green.add(new Player(GREEN_COLOR));
			Blue.add(new Player(BLUE_COLOR));
			Yellow.add(new Player(YELLOW_COLOR));
		}
		dice = new Dice();

		Boxes = new ArrayList<Box>();
		ZoneBlue = new ArrayList<Box>();
		ZoneRed = new ArrayList<Box>();
		ZoneGreen = new ArrayList<Box>();
		ZoneYellow = new ArrayList<Box>();

		mTurn = 1;

		mCanRoll = true;

		Buttons = new ArrayList<Button>();

		WRed = new ArrayList<Box>();
		WGreen = new ArrayList<Box>();
		WYellow = new ArrayList<Box>();
		WBlue = new ArrayList<Box>();
	}

	public int StartRoll() {
		if (!mCanRoll)
			return -1;
		mCanRoll = false;
		int roll = dice.roll();
		Handler handler = new Handler();
		synchronized (Buttons) {
			switch (mTurn) {
			case 1: // GUL
				if (RollCount == 0) {
					if (CountPlayersOnMap(Yellow) > 0) {
						RollCount = 1;
						for (Integer i = 0, C = 0; i < 4; i++) {
							if (Yellow.get(i).IsInGame()
									&& !Yellow.get(i).IsDone()
									&& Yellow.get(i).playerCanMove(roll)) {
								C++;
								Buttons.add(new Button(120, 40 + 20 * C, 15, C
										.toString()));
								Yellow.get(i).setID(i);
							}
						}
						for (int i = 0; i < Buttons.size(); i++)
							Buttons.get(i).setSmallest(Draw.SMALLEST);
					} else {
						RollCount = 3;
					}
				}
				if (roll == 6) {
					/* we rolled 6!! */
					// add extra roll
					RollCount = 2;
					for (Integer i = 0; i < 4; i++) {
						if (Yellow.get(i).IsDone()
								|| !Yellow.get(i).playerCanMove(roll))
							continue;
						Buttons.add(new Button(120, 40 + 10 * i, 5, (++i)
								.toString()));
						i--;
						Yellow.get(i).setID(i);
					}
					for (int i = 0; i < Buttons.size(); i++)
						Buttons.get(i).setSmallest(Draw.SMALLEST);
				} else {
					for (Integer i = 0; i < 4; i++) {
						if (Yellow.get(i).IsDone() || !Yellow.get(i).IsInGame()
								|| !Yellow.get(i).playerCanMove(roll))
							continue;
						Buttons.add(new Button(120, 40 + 10 * i, 5, (++i)
								.toString()));
						i--;
						Yellow.get(i).setID(i);
					}
					for (int i = 0; i < Buttons.size(); i++)
						Buttons.get(i).setSmallest(Draw.SMALLEST);
				}
				RollCount--;
				break;
			case 2: // grøn
				if (RollCount == 0) {
					if (CountPlayersOnMap(Green) > 0) {
						RollCount = 1;
						for (Integer i = 0, C = 0; i < 4; i++) {
							if (Green.get(i).IsInGame()
									&& !Green.get(i).IsDone()
									&& Green.get(i).playerCanMove(roll)) {
								C++;
								Buttons.add(new Button(120, 40 + 20 * C, 15, C
										.toString()));
								Green.get(i).setID(i);
							}
						}
						for (int i = 0; i < Buttons.size(); i++)
							Buttons.get(i).setSmallest(Draw.SMALLEST);
					} else {
						RollCount = 3;
					}
				}
				if (roll == 6) {
					/* we rolled 6!! */
					// add extra roll
					RollCount = 2;
					for (Integer i = 0; i < 4; i++) {
						if (Green.get(i).IsDone()
								|| !Green.get(i).playerCanMove(roll))
							continue;
						Buttons.add(new Button(120, 40 + 10 * i, 5, (++i)
								.toString()));
						i--;
						Green.get(i).setID(i);
					}
					for (int i = 0; i < Buttons.size(); i++)
						Buttons.get(i).setSmallest(Draw.SMALLEST);
				} else {
					for (Integer i = 0; i < 4; i++) {
						if (Green.get(i).IsDone() || !Green.get(i).IsInGame()
								|| !Green.get(i).playerCanMove(roll))
							continue;
						Buttons.add(new Button(120, 40 + 10 * i, 5, (++i)
								.toString()));
						i--;
						Green.get(i).setID(i);
					}
					for (int i = 0; i < Buttons.size(); i++)
						Buttons.get(i).setSmallest(Draw.SMALLEST);

				}
				RollCount--;
				break;
			case 3: // rød
				if (RollCount == 0) {
					if (CountPlayersOnMap(Red) > 0) {
						RollCount = 1;
						for (Integer i = 0, C = 0; i < 4; i++) {
							if (Red.get(i).IsInGame() && !Red.get(i).IsDone()
									&& Red.get(i).playerCanMove(roll)) {
								C++;
								Buttons.add(new Button(120, 40 + 20 * C, 15, C
										.toString()));
								Red.get(i).setID(i);
							}
						}
						for (int i = 0; i < Buttons.size(); i++)
							Buttons.get(i).setSmallest(Draw.SMALLEST);
					} else {
						RollCount = 3;
					}
				}
				if (roll == 6) {
					/* we rolled 6!! */
					// add extra roll
					RollCount = 2;
					for (Integer i = 0; i < 4; i++) {
						if (Red.get(i).IsDone()
								|| !Red.get(i).playerCanMove(roll))
							continue;
						Buttons.add(new Button(120, 40 + 10 * i, 5, (++i)
								.toString()));
						i--;
						Red.get(i).setID(i);
					}
					for (int i = 0; i < Buttons.size(); i++)
						Buttons.get(i).setSmallest(Draw.SMALLEST);
				} else {
					for (Integer i = 0; i < 4; i++) {
						if (Red.get(i).IsDone() || !Red.get(i).IsInGame()
								|| !Red.get(i).playerCanMove(roll))
							continue;
						Buttons.add(new Button(120, 40 + 10 * i, 5, (++i)
								.toString()));
						i--;
						Red.get(i).setID(i);
						// Buttons.get(i).setSmallest(Draw.SMALLEST);
					}
					for (int i = 0; i < Buttons.size(); i++)
						Buttons.get(i).setSmallest(Draw.SMALLEST);
				}
				RollCount--;
				break;
			case 4: // blå
				if (RollCount == 0) {
					if (CountPlayersOnMap(Blue) > 0) {
						RollCount = 1;
						for (Integer i = 0, C = 0; i < 4; i++) {
							if (Blue.get(i).IsInGame() && !Blue.get(i).IsDone()
									&& Blue.get(i).playerCanMove(roll)) {
								C++;
								Buttons.add(new Button(120, 40 + 20 * C, 15, C
										.toString()));
								Blue.get(i).setID(i);
							}
						}
						for (int i = 0; i < Buttons.size(); i++)
							Buttons.get(i).setSmallest(Draw.SMALLEST);
					} else {
						RollCount = 3;

					}
				}
				if (roll == 6) {
					/* we rolled 6!! */
					// add extra roll
					RollCount = 2;
					for (Integer i = 0; i < 4; i++) {
						if (Blue.get(i).IsDone()
								|| !Blue.get(i).playerCanMove(roll))
							continue;
						Buttons.add(new Button(120, 40 + 10 * i, 5, (++i)
								.toString()));
						i--;
						Blue.get(i).setID(i);
					}
					for (int i = 0; i < Buttons.size(); i++)
						Buttons.get(i).setSmallest(Draw.SMALLEST);
				} else {
					for (Integer i = 0; i < 4; i++) {
						if (Blue.get(i).IsDone() || !Blue.get(i).IsInGame()
								|| !Blue.get(i).playerCanMove(roll))
							continue;
						Buttons.add(new Button(120, 40 + 10 * i, 5, (++i)
								.toString()));
						i--;
						Blue.get(i).setID(i);
					}
					for (int i = 0; i < Buttons.size(); i++)
						Buttons.get(i).setSmallest(Draw.SMALLEST);
				}
				RollCount--;
				break;
			}
			if (Buttons.isEmpty())
				canRollTimer(handler);
		}
		// canRollTimer(handler);
		// runRollCountDown(handler, Yellow.get(0));
		return roll;
	}

	public int GetTurn() {
		return mTurn;
	}

	public void NextTurn() {
		if (IsAllDone(Yellow) && IsAllDone(Green) && IsAllDone(Red)
				&& IsAllDone(Blue) || IsTotallyDone) {
			IsTotallyDone = true;
			return;
		}

		if (++mTurn > 4)
			mTurn = 1;
		// 1 = GUL, 2 = GRØN, 3 = RØD, 4 = BLÅ,
		switch (mTurn) {
		case 1:
			if (IsAllDone(Yellow))
				NextTurn();
			break;
		case 2:
			if (IsAllDone(Green))
				NextTurn();
			break;
		case 3:
			if (IsAllDone(Red))
				NextTurn();
			break;
		case 4:
			if (IsAllDone(Blue))
				NextTurn();
		}

	}

	public void AddBoxOuterBox(int x, int y) {
		Box tmp = new Box(x, y);
		Boxes.add(tmp);
	}

	public void AddStartingBox(int x, int y, int color) {
		Box tmp = new Box(x, y);
		switch (color) {
		case YELLOW_COLOR:
			ZoneYellow.add(tmp);
			break;
		case GREEN_COLOR:
			ZoneGreen.add(tmp);
			break;
		case RED_COLOR:
			ZoneRed.add(tmp);
			break;
		case BLUE_COLOR:
			ZoneBlue.add(tmp);
			break;
		}
	}

	public void SetBoxesUp() {
		for (int i = 0; i < Boxes.size() - 1; i++) {
			Boxes.get(i).SetNextBox(Boxes.get(i + 1));
		}
		Boxes.get(Boxes.size() - 1).SetNextBox(Boxes.get(0));

		StartYellow = Boxes.get(2);
		StartGreen = Boxes.get(2 + 12);
		StartRed = Boxes.get(2 + 12 + 12);
		StartBlue = Boxes.get(2 + 12 + 12 + 12);

		/*
		 * Yellow.get(0).SetInGame(); Boxes.get(0).AddPlayer(Yellow.get(0));
		 * Yellow.get(0).SetCurrentBox(StartYellow);
		 */
		for (int i = 0; i < 4; i++) {
			ZoneYellow.get(i).AddPlayer(Yellow.get(i));
			ZoneBlue.get(i).AddPlayer(Blue.get(i));
			ZoneGreen.get(i).AddPlayer(Green.get(i));
			ZoneRed.get(i).AddPlayer(Red.get(i));

			Yellow.get(i).SetCurrentBox(ZoneYellow.get(i));
			Red.get(i).SetCurrentBox(ZoneRed.get(i));
			Green.get(i).SetCurrentBox(ZoneGreen.get(i));
			Blue.get(i).SetCurrentBox(ZoneBlue.get(i));

			ZoneYellow.get(i).SetNextBox(StartYellow);
			ZoneRed.get(i).SetNextBox(StartRed);
			ZoneGreen.get(i).SetNextBox(StartGreen);
			ZoneBlue.get(i).SetNextBox(StartBlue);

			// set win turn box up
			WRed.get(i).SetNextBox(WRed.get(i + 1));
			WBlue.get(i).SetNextBox(WBlue.get(i + 1));
			WYellow.get(i).SetNextBox(WYellow.get(i + 1));
			WGreen.get(i).SetNextBox(WGreen.get(i + 1));

		}
		// Yellow win corner stuff
		Boxes.get(0).SetNextWinBox(WYellow.get(0));
		Boxes.get(0).SetWinColor(YELLOW_COLOR);
		Boxes.get(12).SetNextWinBox(WGreen.get(0));
		Boxes.get(12).SetWinColor(GREEN_COLOR);
		Boxes.get(12 + 12).SetNextWinBox(WRed.get(0));
		Boxes.get(12 + 12).SetWinColor(RED_COLOR);
		Boxes.get(12 + 12 + 12).SetNextWinBox(WBlue.get(0));
		Boxes.get(12 + 12 + 12).SetWinColor(BLUE_COLOR);

		WYellow.get(4).SetNextBox(LastWinBoxThingy);
		WBlue.get(4).SetNextBox(LastWinBoxThingy);
		WGreen.get(4).SetNextBox(LastWinBoxThingy);
		WRed.get(4).SetNextBox(LastWinBoxThingy);

		/*
		 * Red.get(0).SetInGame(); Red.get(0).SetCurrentBox(WRed.get(0));
		 * Blue.get(0).SetInGame(); Blue.get(0).SetCurrentBox(WBlue.get(0));
		 */

		/*
		 * Red.get(0).SetInGame(); Red.get(0).SetCurrentBox(Boxes.get(5));
		 * Yellow.get(0).SetInGame(); Yellow.get(0).SetCurrentBox(Boxes.get(4));
		 * ZoneRed.get(0).RemovePlayer(Red.get(0));
		 */

	}

	public void Restart() {
		for (int i = 0; i < 4; i++) {
			Yellow.get(i).SetCurrentBox(ZoneYellow.get(i));
			Red.get(i).SetCurrentBox(ZoneRed.get(i));
			Green.get(i).SetCurrentBox(ZoneGreen.get(i));
			Blue.get(i).SetCurrentBox(ZoneBlue.get(i));

			Red.get(i).SetDone(false);
			Yellow.get(i).SetDone(false);
			Blue.get(i).SetDone(false);
			Green.get(i).SetDone(false);

			Red.get(i).SetInGame(false);
			Green.get(i).SetInGame(false);
			Blue.get(i).SetInGame(false);
			Yellow.get(i).SetInGame(false);
		}
		dice.Clear();
		mTurn = 1;
		IsTotallyDone = false;
	}

	public void Draw(Canvas canv, Paint p) {
		for (int i = 0; i < 4; i++) {
			if (!Red.get(i).IsDone()) {
				Box b = Red.get(i).GetCurrentBox();
				Red.get(i).Draw(b.GetX(), b.GetY(), canv);
			}
			if (!Yellow.get(i).IsDone()) {
				Box b = Yellow.get(i).GetCurrentBox();
				Yellow.get(i).Draw(b.GetX(), b.GetY(), canv);
			}
			if (!Blue.get(i).IsDone()) {
				Box b = Blue.get(i).GetCurrentBox();
				Blue.get(i).Draw(b.GetX(), b.GetY(), canv);
			}
			if (!Green.get(i).IsDone()) {
				Box b = Green.get(i).GetCurrentBox();
				Green.get(i).Draw(b.GetX(), b.GetY(), canv);
			}
		}
		synchronized (Buttons) {
			if (!Buttons.isEmpty()) {
				for (Button b : Buttons)
					b.Draw(canv, p);
			}
		}

	}

	public boolean CanRoll() {
		return mCanRoll;
	}

	private void runRollCountDown(final Handler handler, final Player Moveable) {
		Runnable Run = new Runnable() {
			public void run() {
				Moveable.GetRoll(1);
				dice.DecrementCountDown();
				if (dice.GetCountDown() <= 0) {
					mCanRoll = true;
					dice.Clear();
					// canRollTimer(handler);
					// if (dice.GetLastRoll() == 6)
					// return;
					/*
					 * mTurn++; if (mTurn > 4) mTurn = 1;
					 */
					/*
					 * Box b = Moveable.GetCurrentBox();
					 * 
					 * if (b.IsLastBox()) return;
					 * 
					 * ArrayList<Player> plr = b.GetPlayersOnBox(); int
					 * AnotherColor = -1, count = 0; for (Player p : plr) { if
					 * (!p.equals(Moveable)) { if (p.getColor() !=
					 * Moveable.getColor()) { AnotherColor = p.getColor();
					 * count++; } } } if (AnotherColor != -1) { if (count > 1) {
					 * b.RemovePlayer(Moveable); Moveable.SetInGame(false);
					 * switch (Moveable.getColor()) { case YELLOW_COLOR:
					 * Moveable.SetCurrentBox(StartYellow); break; case
					 * BLUE_COLOR: Moveable.SetCurrentBox(StartBlue); break;
					 * case GREEN_COLOR: Moveable.SetCurrentBox(StartGreen);
					 * break; case RED_COLOR: Moveable.SetCurrentBox(StartRed);
					 * break; } } else { for (Player p : plr) { if
					 * (!p.equals(Moveable)) { Moveable.SetInGame(false);
					 * b.RemovePlayer(p); switch (p.getColor()) { case
					 * YELLOW_COLOR:
					 * 
					 * p.SetCurrentBox(StartYellow); break; case BLUE_COLOR:
					 * p.SetCurrentBox(StartBlue); break; case GREEN_COLOR:
					 * p.SetCurrentBox(StartGreen); break; case RED_COLOR:
					 * p.SetCurrentBox(StartRed); break; } break; } }
					 */
					Box b = Moveable.GetCurrentBox();

					if (b.IsLastBox())
						return;

					ArrayList<Player> collisions = new ArrayList<Player>(
							b.CheckCollision(Moveable));
					if (collisions.isEmpty())
						return;

					int OtherColor = -1, Count = 0;
					for (Player plr : collisions) {
						if (plr.getColor() != Moveable.getColor()) {
							OtherColor = plr.getColor();
							Count++;
						}
					}
					if (OtherColor == -1)
						return;
					Box StartP = null, Start2 = null;
					switch (Moveable.getColor()) {
					case YELLOW_COLOR:
						StartP = StartYellow;
						break;
					case GREEN_COLOR:
						StartP = StartGreen;
						break;
					case BLUE_COLOR:
						StartP = StartBlue;
						break;
					case RED_COLOR:
						StartP = StartRed;
						break;
					}
					switch (OtherColor) {
					case YELLOW_COLOR:
						Start2 = StartYellow;
						break;
					case GREEN_COLOR:
						Start2 = StartGreen;
						break;
					case BLUE_COLOR:
						Start2 = StartBlue;
						break;
					case RED_COLOR:
						Start2 = StartRed;
						break;
					case -1:
						Start2 = new Box(-1000, -1000);
					}
					boolean IsEnemyAtStart = (Start2.GetX() == b.GetX() && Start2
							.GetY() == b.GetY());
					// boolean IsAttackerAtStart = (StartP.GetX() == b.GetX() &&
					// StartP.GetY() == b.GetY());

					if (Count == 1 && !IsEnemyAtStart) {
						for (Player plr : collisions) {
							if (plr.getColor() == Moveable.getColor())
								continue;

							b.RemovePlayer(plr);
							plr.SetInGame(false);
							switch (plr.getColor()) {
							case YELLOW_COLOR:
								// ZoneRed

								for (Box boxy : ZoneYellow) {
									if (!boxy.IsThereAPlayer()) {
										boxy.AddPlayer(plr);
										plr.SetCurrentBox(boxy);
										break;
									}
								}

								/*
								 * for (int i = 0; i < 4; i++) { if
								 * (Yellow.get(i).equals(plr)) {
								 * plr.SetCurrentBox(ZoneYellow.get(i));
								 * ZoneYellow.get(i).AddPlayer(plr); } }
								 */
								break;
							case GREEN_COLOR:

								for (Box boxy : ZoneGreen) {
									if (!boxy.IsThereAPlayer()) {
										boxy.AddPlayer(plr);
										plr.SetCurrentBox(boxy);
										break;
									}
								}
								/*
								 * for (int i = 0; i < 4; i++) { if
								 * (Green.get(i).equals(plr)) {
								 * plr.SetCurrentBox(ZoneGreen.get(i));
								 * ZoneGreen.get(i).AddPlayer(plr); } }
								 */
								break;
							case BLUE_COLOR:

								for (Box boxy : ZoneBlue) {
									if (!boxy.IsThereAPlayer()) {
										boxy.AddPlayer(plr);
										plr.SetCurrentBox(boxy);
										break;
									}
								}

								/*
								 * for (int i = 0; i < 4; i++) { if
								 * (Blue.get(i).equals(plr)) {
								 * plr.SetCurrentBox(ZoneBlue.get(i));
								 * ZoneBlue.get(i).AddPlayer(plr); } }
								 */
								break;
							case RED_COLOR:

								for (Box boxy : ZoneRed) {
									if (!boxy.IsThereAPlayer()) {
										boxy.AddPlayer(plr);
										plr.SetCurrentBox(boxy);
										break;
									}
								}

								/*
								 * for (int i = 0; i < 4; i++) { if
								 * (Blue.get(i).equals(plr)) {
								 * plr.SetCurrentBox(ZoneBlue.get(i));
								 * ZoneBlue.get(i).AddPlayer(plr); } }
								 */
								break;
							}
						}
					} else {
						// remove le player
						b.RemovePlayer(Moveable);
						Moveable.SetInGame(false);
						switch (Moveable.getColor()) {
						case YELLOW_COLOR:
							// ZoneRed

							for (Box boxy : ZoneYellow) {
								if (!boxy.IsThereAPlayer()) {
									boxy.AddPlayer(Moveable);
									Moveable.SetCurrentBox(boxy);
									break;
								}
							}
							/*
							 * for (int i = 0; i < 4; i++) { if
							 * (Yellow.get(i).equals(Moveable)) {
							 * Moveable.SetCurrentBox(ZoneYellow.get(i));
							 * ZoneYellow.get(i).AddPlayer(Moveable); } }
							 */
							break;
						case GREEN_COLOR:

							for (Box boxy : ZoneGreen) {
								if (!boxy.IsThereAPlayer()) {
									boxy.AddPlayer(Moveable);
									Moveable.SetCurrentBox(boxy);
									break;
								}
							}
							/*
							 * for (int i = 0; i < 4; i++) { if
							 * (Green.get(i).equals(Moveable)) {
							 * Moveable.SetCurrentBox(ZoneGreen.get(i));
							 * ZoneGreen.get(i).AddPlayer(Moveable); } }
							 */
							break;
						case BLUE_COLOR:

							for (Box boxy : ZoneBlue) {
								if (!boxy.IsThereAPlayer()) {
									boxy.AddPlayer(Moveable);
									Moveable.SetCurrentBox(boxy);
									break;
								}
							}
							/*
							 * for (int i = 0; i < 4; i++) { if
							 * (Blue.get(i).equals(Moveable)) {
							 * Moveable.SetCurrentBox(ZoneBlue.get(i));
							 * ZoneBlue.get(i).AddPlayer(Moveable); } }
							 */
							break;
						case RED_COLOR:

							for (Box boxy : ZoneRed) {
								if (!boxy.IsThereAPlayer()) {
									boxy.AddPlayer(Moveable);
									Moveable.SetCurrentBox(boxy);
									break;
								}
							}
							/*
							 * for (int i = 0; i < 4; i++) { if
							 * (Red.get(i).equals(Moveable)) {
							 * Moveable.SetCurrentBox(ZoneRed.get(i));
							 * ZoneRed.get(i).AddPlayer(Moveable); } }
							 */
							break;

						}
					}

				} else {
					runRollCountDown(handler, Moveable);
				}
			}
		};
		handler.postDelayed(Run, 400);
	}

	private void runRollCountDown(final Handler handler, final Player Moveable,
			final boolean check) {
		Runnable Run = new Runnable() {
			public void run() {
				Moveable.GetRoll(1);
				dice.DecrementCountDown();
				if (dice.GetCountDown() <= 0) {
					mCanRoll = true;
					dice.Clear();
					// canRollTimer(handler);
					// if (dice.GetLastRoll() == 6)
					// return;
					if (!check) {
						// remove the other player
						// we just moved out...
						Box p = Moveable.GetCurrentBox();
						ArrayList<Player> plr = p.CheckCollision(Moveable);
						for(int i = 0; i < plr.size(); i++) {
							if(plr.get(i).getColor() != Moveable.getColor()) {
								// go home!!
								p.RemovePlayer(plr.get(i));
								switch (plr.get(i).getColor()) {
								case YELLOW_COLOR:
									for (Box boxy : ZoneYellow) {
										if (!boxy.IsThereAPlayer()) {
											boxy.AddPlayer(plr.get(i));
											plr.get(i).SetCurrentBox(boxy);
											break;
										}
									}

									/*
									 * for (int i = 0; i < 4; i++) { if
									 * (Yellow.get(i).equals(plr)) {
									 * plr.SetCurrentBox(ZoneYellow.get(i));
									 * ZoneYellow.get(i).AddPlayer(plr); } }
									 */
									break;
								case GREEN_COLOR:

									for (Box boxy : ZoneGreen) {
										if (!boxy.IsThereAPlayer()) {
											boxy.AddPlayer(plr.get(i));
											plr.get(i).SetCurrentBox(boxy);
											break;
										}
									}
									/*
									 * for (int i = 0; i < 4; i++) { if
									 * (Green.get(i).equals(plr)) {
									 * plr.SetCurrentBox(ZoneGreen.get(i));
									 * ZoneGreen.get(i).AddPlayer(plr); } }
									 */
									break;
								case BLUE_COLOR:

									for (Box boxy : ZoneBlue) {
										if (!boxy.IsThereAPlayer()) {
											boxy.AddPlayer(plr.get(i));
											plr.get(i).SetCurrentBox(boxy);
											break;
										}
									}

									/*
									 * for (int i = 0; i < 4; i++) { if
									 * (Blue.get(i).equals(plr)) {
									 * plr.SetCurrentBox(ZoneBlue.get(i));
									 * ZoneBlue.get(i).AddPlayer(plr); } }
									 */
									break;
								case RED_COLOR:

									for (Box boxy : ZoneRed) {
										if (!boxy.IsThereAPlayer()) {
											boxy.AddPlayer(plr.get(i));
											plr.get(i).SetCurrentBox(boxy);
											break;
										}
									}

									/*
									 * for (int i = 0; i < 4; i++) { if
									 * (Blue.get(i).equals(plr)) {
									 * plr.SetCurrentBox(ZoneBlue.get(i));
									 * ZoneBlue.get(i).AddPlayer(plr); } }
									 */
									break;
								}
								plr.get(i).SetInGame(false);
							}
						}
						
						return;
					}

					NextTurn();
					/*
					 * 1 = GUL, 2 = GRØN, 3 = RØD, 4 = BLÅ,
					 */
					/*
					 * switch(mTurn) { case 1: for(int i = 0; i < 4; i++){
					 * if(Yellow.get(i).IsDone()) continue;
					 * 
					 * } break; case 2:
					 * 
					 * break; case 3:
					 * 
					 * break; case 4:
					 * 
					 * break; }
					 */

					for (Player p : Red)
						p.setID(-1);
					for (Player p : Blue)
						p.setID(-1);
					for (Player p : Green)
						p.setID(-1);
					for (Player p : Yellow)
						p.setID(-1);

					Box b = Moveable.GetCurrentBox();

					if (b.IsLastBox())
						return;

					ArrayList<Player> collisions = new ArrayList<Player>(
							b.CheckCollision(Moveable));
					if (collisions.isEmpty())
						return;

					int OtherColor = -1, Count = 0;
					for (Player plr : collisions) {
						if (plr.getColor() != Moveable.getColor()) {
							OtherColor = plr.getColor();
							Count++;
						}
					}
					if (OtherColor == -1)
						return;
					Box StartP = null, Start2 = null;
					switch (Moveable.getColor()) {
					case YELLOW_COLOR:
						StartP = StartYellow;
						break;
					case GREEN_COLOR:
						StartP = StartGreen;
						break;
					case BLUE_COLOR:
						StartP = StartBlue;
						break;
					case RED_COLOR:
						StartP = StartRed;
						break;
					}
					switch (OtherColor) {
					case YELLOW_COLOR:
						Start2 = StartYellow;
						break;
					case GREEN_COLOR:
						Start2 = StartGreen;
						break;
					case BLUE_COLOR:
						Start2 = StartBlue;
						break;
					case RED_COLOR:
						Start2 = StartRed;
						break;
					case -1:
						Start2 = new Box(-1000, -1000);
					}
					boolean IsEnemyAtStart = (Start2.GetX() == b.GetX() && Start2
							.GetY() == b.GetY());
					// boolean IsAttackerAtStart = (StartP.GetX() == b.GetX() &&
					// StartP.GetY() == b.GetY());

					if (Count == 1 && !IsEnemyAtStart) {
						for (Player plr : collisions) {
							if (plr.getColor() == Moveable.getColor())
								continue;

							b.RemovePlayer(plr);
							plr.SetInGame(false);
							switch (plr.getColor()) {
							case YELLOW_COLOR:
								for (Box boxy : ZoneYellow) {
									if (!boxy.IsThereAPlayer()) {
										boxy.AddPlayer(plr);
										plr.SetCurrentBox(boxy);
										break;
									}
								}

								/*
								 * for (int i = 0; i < 4; i++) { if
								 * (Yellow.get(i).equals(plr)) {
								 * plr.SetCurrentBox(ZoneYellow.get(i));
								 * ZoneYellow.get(i).AddPlayer(plr); } }
								 */
								break;
							case GREEN_COLOR:

								for (Box boxy : ZoneGreen) {
									if (!boxy.IsThereAPlayer()) {
										boxy.AddPlayer(plr);
										plr.SetCurrentBox(boxy);
										break;
									}
								}
								/*
								 * for (int i = 0; i < 4; i++) { if
								 * (Green.get(i).equals(plr)) {
								 * plr.SetCurrentBox(ZoneGreen.get(i));
								 * ZoneGreen.get(i).AddPlayer(plr); } }
								 */
								break;
							case BLUE_COLOR:

								for (Box boxy : ZoneBlue) {
									if (!boxy.IsThereAPlayer()) {
										boxy.AddPlayer(plr);
										plr.SetCurrentBox(boxy);
										break;
									}
								}

								/*
								 * for (int i = 0; i < 4; i++) { if
								 * (Blue.get(i).equals(plr)) {
								 * plr.SetCurrentBox(ZoneBlue.get(i));
								 * ZoneBlue.get(i).AddPlayer(plr); } }
								 */
								break;
							case RED_COLOR:

								for (Box boxy : ZoneRed) {
									if (!boxy.IsThereAPlayer()) {
										boxy.AddPlayer(plr);
										plr.SetCurrentBox(boxy);
										break;
									}
								}

								/*
								 * for (int i = 0; i < 4; i++) { if
								 * (Blue.get(i).equals(plr)) {
								 * plr.SetCurrentBox(ZoneBlue.get(i));
								 * ZoneBlue.get(i).AddPlayer(plr); } }
								 */
								break;
							}
						}
					} else {
						// remove le player
						b.RemovePlayer(Moveable);
						Moveable.SetInGame(false);
						switch (Moveable.getColor()) {
						case YELLOW_COLOR:
							// ZoneRed

							for (Box boxy : ZoneYellow) {
								if (!boxy.IsThereAPlayer()) {
									boxy.AddPlayer(Moveable);
									Moveable.SetCurrentBox(boxy);
									break;
								}
							}
							/*
							 * for (int i = 0; i < 4; i++) { if
							 * (Yellow.get(i).equals(Moveable)) {
							 * Moveable.SetCurrentBox(ZoneYellow.get(i));
							 * ZoneYellow.get(i).AddPlayer(Moveable); } }
							 */
							break;
						case GREEN_COLOR:

							for (Box boxy : ZoneGreen) {
								if (!boxy.IsThereAPlayer()) {
									boxy.AddPlayer(Moveable);
									Moveable.SetCurrentBox(boxy);
									break;
								}
							}
							/*
							 * for (int i = 0; i < 4; i++) { if
							 * (Green.get(i).equals(Moveable)) {
							 * Moveable.SetCurrentBox(ZoneGreen.get(i));
							 * ZoneGreen.get(i).AddPlayer(Moveable); } }
							 */
							break;
						case BLUE_COLOR:

							for (Box boxy : ZoneBlue) {
								if (!boxy.IsThereAPlayer()) {
									boxy.AddPlayer(Moveable);
									Moveable.SetCurrentBox(boxy);
									break;
								}
							}
							/*
							 * for (int i = 0; i < 4; i++) { if
							 * (Blue.get(i).equals(Moveable)) {
							 * Moveable.SetCurrentBox(ZoneBlue.get(i));
							 * ZoneBlue.get(i).AddPlayer(Moveable); } }
							 */
							break;
						case RED_COLOR:

							for (Box boxy : ZoneRed) {
								if (!boxy.IsThereAPlayer()) {
									boxy.AddPlayer(Moveable);
									Moveable.SetCurrentBox(boxy);
									break;
								}
							}
							/*
							 * for (int i = 0; i < 4; i++) { if
							 * (Red.get(i).equals(Moveable)) {
							 * Moveable.SetCurrentBox(ZoneRed.get(i));
							 * ZoneRed.get(i).AddPlayer(Moveable); } }
							 */
							break;

						}
					}

				} else {
					if (!check)
						runRollCountDown(handler, Moveable);
					else
						runRollCountDown(handler, Moveable, check);
				}
			}
		};
		handler.postDelayed(Run, 400);
	}

	private void canRollTimer(final Handler handler) {
		Runnable Run = new Runnable() {
			public void run() {
				mCanRoll = true;
				dice.Clear();
				if (RollCount == 0) {
					// mTurn++;
					// if (mTurn > 4)
					// mTurn = 1;
					NextTurn();
				}
			}
		};
		// Set back to
		 handler.postDelayed(Run, 2500);
		//handler.postDelayed(Run, 100);
	}

	public int GetDiceNumber() {
		return dice.GetLastRoll();
	}

	private int CountPlayersOnMap(ArrayList<Player> players) {
		int c = 0;
		for (Player p : players) {
			if (!p.IsDone() && p.IsInGame())
				c++;
		}
		return c;
	}

	public void CheckButtonClick(int x, int y) {
		synchronized (Buttons) {
			if (Buttons.isEmpty())
				return;
			for (int i = 0; i < Buttons.size(); i++) {
				if (Buttons.get(i).IsClicked(x, y)) {
					// okay we clicked something O.o
					Handler handler = new Handler();
					switch (mTurn) {
					case 1:
						for (Player plr : Yellow) {
							if (Integer.valueOf(plr.getID() + 1).toString()
									.equals(Buttons.get(i).GetString())) {
								boolean InGame = plr.IsInGame();
								if (!plr.IsInGame() && !plr.IsDone()
										&& dice.GetLastRoll() == 6) {
									plr.SetInGame();
									dice.ShortCountDown();
								}
								runRollCountDown(handler, plr,
										dice.GetLastRoll() != 6 && InGame);
								Buttons.clear();
								/*
								 * if(dice.GetLastRoll() != 6 && InGame) {
								 * mTurn++; if (mTurn > 4) mTurn = 1; }
								 */
								break;
							}
						}
						break;
					case 2:
						for (Player plr : Green) {
							if (Integer.valueOf(plr.getID() + 1).toString()
									.equals(Buttons.get(i).GetString())) {
								boolean InGame = plr.IsInGame();
								if (!plr.IsInGame() && !plr.IsDone()) {
									plr.SetInGame();
									dice.ShortCountDown();
								}
								runRollCountDown(handler, plr,
										dice.GetLastRoll() != 6 && InGame);
								Buttons.clear();
								// if(dice.GetLastRoll() != 6 && InGame) {
								// mTurn++;
								// if (mTurn > 4)
								// mTurn = 1;
								// }
								break;
							}
						}
						break;
					case 3:
						for (Player plr : Red) {
							if (Integer.valueOf(plr.getID() + 1).toString()
									.equals(Buttons.get(i).GetString())) {
								boolean InGame = plr.IsInGame();
								if (!plr.IsInGame() && !plr.IsDone()
										&& dice.GetLastRoll() == 6) {
									plr.SetInGame();
									dice.ShortCountDown();
								}

								runRollCountDown(handler, plr,
										dice.GetLastRoll() != 6 && InGame);
								Buttons.clear();
								/*
								 * if(dice.GetLastRoll() != 6 && InGame) {
								 * mTurn++; if (mTurn > 4) mTurn = 1; }
								 */
								break;
							}
						}
						break;
					case 4:
						for (Player plr : Blue) {
							if (Integer.valueOf(plr.getID() + 1).toString()
									.equals(Buttons.get(i).GetString())) {
								boolean InGame = plr.IsInGame();
								if (!plr.IsInGame() && !plr.IsDone()
										&& dice.GetLastRoll() == 6) {
									plr.SetInGame();
									dice.ShortCountDown();
								}
								runRollCountDown(handler, plr,
										dice.GetLastRoll() != 6 && InGame);
								Buttons.clear();
								/*
								 * if(dice.GetLastRoll() != 6 && InGame) {
								 * mTurn++; if (mTurn > 4) mTurn = 1; }
								 */
								break;
							}
						}
						break;
					}
					break;
				}
			}

		}
	}

	public void AddWinBox(int x, int y, int color) {
		Box tmp = new Box(x, y);
		switch (color) {
		case YELLOW_COLOR:
			WYellow.add(tmp);
			break;
		case GREEN_COLOR:
			WGreen.add(tmp);
			break;
		case BLUE_COLOR:
			WBlue.add(tmp);
			break;
		case RED_COLOR:
			WRed.add(tmp);
			break;
		}
	}

	public void AddLastBox(int x, int y) {
		Box tmp = new Box(x, y, true);
		LastWinBoxThingy = tmp;
	}

	public boolean IsAllDone(ArrayList<Player> p) {
		for (Player plr : p)
			if (!plr.IsDone())
				return false;
		return true;
	}
}
