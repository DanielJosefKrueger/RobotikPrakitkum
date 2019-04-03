package subsumption.sensor;

import subsumption.common.Reading;
import supsumption.behavior.Behavior;

public abstract class SubSensor extends Thread {
	private final Behavior[] behaviors;
	private final Reading type;

	public SubSensor(Behavior[] behaviors, Reading type) {
		this.behaviors = behaviors;
		this.type = type;
		setDaemon(true);

	}

	void send(int value) {
	//	System.out.println("sending type " + type + ", value=" + value);
		for (Behavior behavior : behaviors)
			behavior.accept(type, value);
	}

	public static SubSensor make(String typeName, Behavior[] behaviors) {
		switch (typeName) {
		case "ButtonSensor":
			return new ButtonSensor(behaviors);
		case "BumperSensor":
			return new BumperSensor(behaviors);
		case "SonicWaveSensor":
			return new SonicWaveSensor(behaviors);
		default:
			new RuntimeException("unbekannter Sensortyp: " + typeName);
			return null;
		}

	}

}
