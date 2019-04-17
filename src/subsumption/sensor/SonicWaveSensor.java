package subsumption.sensor;

import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.BaseSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import subsumption.common.Reading;
import supsumption.behavior.Behavior;

public class SonicWaveSensor extends SubSensor {
	
	private final BaseSensor sensor = new EV3UltrasonicSensor(SensorPort.S3);
	int counter =0;
	int previousDistance=-1;
	
	
	public SonicWaveSensor(Behavior[] behaviors) {
		super(behaviors, Reading.SonicWave);
	}

	public void run() {
		while (true) {
			float sample[] = new float[sensor.sampleSize()];
			sensor.fetchSample(sample, 0);
			int distance = (int)(sample[0]*100);
			if(counter++ % 10000 ==0) {
			//System.out.println("Distance meassured: "+ distance);
			  counter =1;
		    }
			if(distance != this.previousDistance) {
				send(distance);
			}
		}
	}
	
	
}
