package supsumption.behavior;

import subsumption.Configuration;
import subsumption.arbitrator.Arbitrator;
import subsumption.common.Reading;
import subsumption.common.Wish;

public class DriveForward extends Behavior{
	
	public DriveForward(Arbitrator arbitrator, int priority) {
		super(arbitrator, priority, Reading.SonicWave);
	}

	
	@Override
	public void run() {
		while(true) {
			int distance = getReadingValue();
			while (distance < Configuration.MIN_DISTANCE || distance > Configuration.MAX_DISTANCE) {
				System.out.println(distance);
				distance = getReadingValue();
			}
			sendWish(Wish.DRIVEFORWARD);
		}

		
	}
	
	
	

}
