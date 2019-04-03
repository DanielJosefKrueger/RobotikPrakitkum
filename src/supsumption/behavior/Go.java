package supsumption.behavior;

import lejos.hardware.Button;
import subsumption.arbitrator.Arbitrator;
import subsumption.common.Reading;
import subsumption.common.Wish;

public class Go extends Behavior {

	public Go(Arbitrator arbitrator, int priority) {
		super(arbitrator, priority, Reading.Button);
	}

	@Override
	public void run() {
		while(true) {
			int button = getReadingValue();
			while (button != Button.ID_ENTER) {
			//	System.out.println("Go got:" + button);
				button = getReadingValue();
			}
			sendWish(Wish.FORWARD);	
		}
	}

}
