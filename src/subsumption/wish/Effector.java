package subsumption.wish;

import subsumption.common.Wish;

public abstract class Effector {
	public abstract void accept(Wish command);

	public static Effector make(String typeName) {
		switch (typeName) {
		case "Lamp":
			return new Lamp();
		case "Chassis":
			return new Chassis();
		default:
			throw new IllegalArgumentException("falscher Effektor");
		}
	}

}
