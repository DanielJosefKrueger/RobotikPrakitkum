package subsumption;

import subsumption.arbitrator.Arbitrator;
import subsumption.sensor.SubSensor;
import subsumption.wish.Effector;
import supsumption.behavior.Behavior;

public class SubsumptionMain {

	public static void main(String... args) {
		Effector[] effectors = { Effector.make("Lamp"), Effector.make("Chassis") };
		Arbitrator arbitrator = new Arbitrator(effectors);
		// Array aller Verhalten
		// jedes Mal, wenn man eine Priority verwendet hat, hochzählen
		// fuer das nächste Verhalten.
		int priority = 1;
		Behavior[] behaviors = { 
				Behavior.make("Blink", arbitrator, priority++),
				Behavior.make("Go", arbitrator, priority++), Behavior.make("Stop", arbitrator, priority++),
				Behavior.make("WallFollower", arbitrator, priority),
				Behavior.make("BumperHitBackAndTurnRight", arbitrator, ++priority),
				Behavior.make("LineFollower", arbitrator, ++priority),
				Behavior.make("Killer", arbitrator, ++priority)
			 };
		// Konkrete Sensoren wie hier ButtonSensor erzeugen
		SubSensor[] sensors = { 
				SubSensor.make("ButtonSensor", behaviors), 
				SubSensor.make("SonicWaveSensor", behaviors),
				SubSensor.make("BumperSensor", behaviors),
				SubSensor.make("LightSensor", behaviors) 
		};
		// Starten aller Threads
		for (Behavior behavior : behaviors)
			behavior.start();
		for (SubSensor sensor : sensors)
			sensor.start();
	}

}
