package supsumption.behavior;

import subsumption.Configuration;
import subsumption.arbitrator.Arbitrator;
import subsumption.common.Reading;
import subsumption.common.Wish;

public class SoftRightCurve extends Behavior{
	
	
	int counter =0;
	
	public SoftRightCurve(Arbitrator arbitrator, int priority) {
		super(arbitrator, priority, Reading.SonicWave);
	}

	
	@Override
	public void run() {
		while(true) {
			int distance = getReadingValue();
			// 0: not pressed or only one 
			// 1: both pressed
			
			
			while (distance < Configuration.MAX_DISTANCE) {
				//System.out.println("Go got:" + distance);
				distance = getReadingValue();
			}
			
			
			System.out.println("Go soft right");
			sendWish(Wish.SOFTRIGHT);
	
		}

		
	}
	
	
	

}
