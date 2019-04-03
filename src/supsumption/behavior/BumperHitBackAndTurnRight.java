package supsumption.behavior;

import subsumption.arbitrator.Arbitrator;
import subsumption.common.Reading;
import subsumption.common.Wish;

public class BumperHitBackAndTurnRight extends Behavior{

	public BumperHitBackAndTurnRight(Arbitrator arbitrator, int priority) {
		super(arbitrator, priority, Reading.Bumper);
	}

	
	@Override
	public void run() {
		while(true) {
			int pressed = getReadingValue();
			// 0: not pressed or only one 
			// 1: both pressed
			
			
			while (pressed != 1) {
			//	System.out.println("Go got:" + pressed);
				pressed = getReadingValue();
			}
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
			sendWish(Wish.FORWARD);
		}

		
	}
	
	
}
