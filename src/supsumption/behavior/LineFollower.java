package supsumption.behavior;

import subsumption.Configuration;
import subsumption.arbitrator.Arbitrator;
import subsumption.common.Reading;
import subsumption.common.Wish;

public class LineFollower extends Behavior{
	
	int counter =0;
	
	public LineFollower(Arbitrator arbitrator, int priority) {
		super(arbitrator, priority, Reading.BRIGHTNESS);
	}

	
	@Override
	public void run() {
		while(true) {
			int brightness = getReadingValue();
			
			counter++;
			if(counter%100==0) {
			
				System.out.println("Brightness:"+  brightness);
				if(brightness < Configuration.LIGHT_THRESHOLD) {
					System.out.println("HELL");
					behaviorLight();
				}else{
					System.out.println("DUNKEL");
					behaviorDark();
				}
			}
		}	
	}
	
	void behaviorLight() {
		sendWish(Wish.LIGHTRIGHT);
	}
	
	void behaviorDark() {
		sendWish(Wish.LIGHTLEFT);
		
	}
	
	
	
	
}
