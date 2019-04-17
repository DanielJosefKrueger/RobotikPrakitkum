package subsumption.sensor;

import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.SampleProvider;
import subsumption.common.Reading;
import supsumption.behavior.Behavior;

public class BumperSensor extends SubSensor{

	EV3TouchSensor sensor1 = new EV3TouchSensor(SensorPort.S1);
	EV3TouchSensor sensor2 = new EV3TouchSensor(SensorPort.S4);
	
	int counter =0;
	
	
	public BumperSensor(Behavior[] behaviors) {
		super(behaviors, Reading.Bumper);
	}

	public void run() {
		while (true) {
			SampleProvider touch1 = sensor1.getMode("Touch");
		    float sample[] = new float[touch1.sampleSize()];
		    touch1.fetchSample(sample, 0);
		    float pressed1 = sample[0];
		  
			SampleProvider touch2 = sensor2.getMode("Touch");
		    float sample2[] = new float[touch2.sampleSize()];
		    touch2.fetchSample(sample2, 0);
		    float pressed2 = sample2[0];
		    if(counter++ % 100000 ==0) {
			    System.out.println("pressed1:" + pressed1 + "pressed2:" + pressed2);
			    counter =1;
		    }
		    
		    
		    
		    if(pressed1 != 0 || pressed2 !=0) {
		    	 float difference = pressed1- pressed2; 
				    if(difference<0) {
				    	send(1);
				    }else {
				    	send(-1);
				    }
		    }
		}
	}
	
	
	
}
