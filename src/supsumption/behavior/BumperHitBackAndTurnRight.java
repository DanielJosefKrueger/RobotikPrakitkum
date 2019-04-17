package supsumption.behavior;

import subsumption.arbitrator.Arbitrator;
import subsumption.common.Reading;
import subsumption.common.Wish;

public class BumperHitBackAndTurnRight extends Behavior {

	public BumperHitBackAndTurnRight(Arbitrator arbitrator, int priority) {
		super(arbitrator, priority, Reading.Bumper);
	}

	@Override
	public void run() {
		while (true) {
			int pressed = getReadingValue();
			// 0: not pressed or only one
			// 1: both pressed

			while (pressed == 0) {
				pressed = getReadingValue();
			}
			rightReset();
			/*
			 * 
			 * if(pressed ==-1) { rightReset(); System.out.println("RightReset"); }
			 * if(pressed ==1) { leftReset(); System.out.println("LeftReset"); }
			 */
		}

	}

	void leftReset() {
		sendWish(Wish.BACKWARD);
		try {
			Thread.sleep(600);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sendWish(Wish.TURNLEFT);
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sendWish(Wish.Reset);
	}

	void rightReset() {
		sendWish(Wish.BACKWARD);
		try {
			Thread.sleep(600);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sendWish(Wish.TURNRIGHT);
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sendWish(Wish.Reset);

	}

}
