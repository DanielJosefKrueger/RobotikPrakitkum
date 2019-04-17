package subsumption.sensor;

import lejos.hardware.Button;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.BaseSensor;
import lejos.hardware.sensor.EV3ColorSensor;
import subsumption.common.Reading;
import supsumption.behavior.Behavior;

public class LightSensor extends SubSensor {
	
	private final EV3ColorSensor sensor = new EV3ColorSensor(SensorPort.S2);
	private int previousValue=-99;
	
	public LightSensor(Behavior[] behaviors) {
		super(behaviors, Reading.BRIGHTNESS);
		sensor.getRedMode();
	}

	public void run() {
		while (true) {
			float sample[] = new float[sensor.sampleSize()];
			sensor.fetchSample(sample, 0);
			int brightness = (int)(sample[0]*100);
			if(brightness != previousValue) {
				send(brightness);
			}
		}
	}
}
