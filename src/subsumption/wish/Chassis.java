package subsumption.wish;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import subsumption.Configuration;
import subsumption.common.Wish;

public class Chassis extends Effector {

	final RegulatedMotor motorRight = new EV3LargeRegulatedMotor(MotorPort.A);
	final RegulatedMotor motorLeft = new EV3LargeRegulatedMotor(MotorPort.D);

	
	@Override
	public void accept(Wish command) {
		System.out.println(command);
		switch(command) {
		case FORWARD:
		case DRIVEFORWARD:
			motorRight.setSpeed(Configuration.NORMAL_SPEED);
			motorLeft.setSpeed(Configuration.NORMAL_SPEED);
			motorRight.forward();
			motorLeft.forward();
			break;
		case BACKWARD:
			motorRight.backward();
			motorLeft.backward();
			break;	
		case STOP:
			motorRight.stop();
			motorLeft.stop();
			break;
		case TURNRIGHT:
			turnRight();
			break;
		case SOFTLEFT:
			motorRight.setSpeed(Configuration.NORMAL_SPEED);
			motorLeft.setSpeed(Configuration.NORMAL_SPEED- Configuration.DELTA_SPEED);
			motorRight.forward();
			motorLeft.forward();
			break;
		case SOFTRIGHT:
			motorRight.setSpeed(Configuration.NORMAL_SPEED- Configuration.DELTA_SPEED);
			motorLeft.setSpeed(Configuration.NORMAL_SPEED);
			motorRight.forward();
			motorLeft.forward();
			break;
		default:
			break;
		}
	}
	
	
	void turnRight() {
		motorRight.backward();
		motorLeft.forward();
	}

}
