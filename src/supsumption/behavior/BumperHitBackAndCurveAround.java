package supsumption.behavior;

import subsumption.Constants;
import subsumption.arbitrator.Arbitrator;
import subsumption.common.Reading;
import subsumption.common.Wish;

public class BumperHitBackAndCurveAround extends Behavior {

	public BumperHitBackAndCurveAround(Arbitrator arbitrator, int priority) {
		super(arbitrator, priority, Reading.Bumper);
	}

	@Override
	public void run() {
		while (true) {
			int pressed = getReadingValue();

			while (pressed == 0) {
				pressed = getReadingValue();
			}
			intitiateCurveAround();
		}

	}

	void intitiateCurveAround() {
		sendWish(Wish.BACKWARD, Constants.MAX_WISH);
		try {
			Thread.sleep(600);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sendWish(Wish.TURNLEFT, Constants.MAX_WISH);
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sendWish(Wish.Reset);
	}

}
