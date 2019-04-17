package supsumption.behavior;

import subsumption.Configuration;
import subsumption.arbitrator.Arbitrator;
import subsumption.common.Reading;
import subsumption.common.Wish;

public class WallFollower extends Behavior{
	
	int counter =0;
	
	public WallFollower(Arbitrator arbitrator, int priority) {
		super(arbitrator, priority, Reading.SonicWave);
	}

	
	@Override
	public void run() {
		while(true) {
			int distance = getReadingValue();
			if(distance< Configuration.MIN_DISTANCE) {
				sendWish(Wish.HARDLEFT);
			}else if(distance < Configuration.PERFECT_DISTANCE) {
				sendWish(Wish.SOFTLEFT);
			}else if(distance == Configuration.PERFECT_DISTANCE) {
				sendWish(Wish.DRIVEFORWARD);
			}else if (distance < Configuration.MAX_DISTANCE) {
				sendWish(Wish.SOFTRIGHT);
			}else if(distance >= Configuration.MAX_DISTANCE) {
				sendWish(Wish.HARDRIGHT);
			}else{
				sendWish(Wish.DRIVEFORWARD);
			}
		}

		
	}
	
	
	

}
