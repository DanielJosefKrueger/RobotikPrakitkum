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
		//System.out.println(command);
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
			motorLeft.setSpeed(Configuration.NORMAL_SPEED- Configuration.SOFT_DELTA_SPEED);
			motorRight.forward();
			motorLeft.forward();
			break;
		case HARDLEFT:
			motorRight.setSpeed(Configuration.NORMAL_SPEED);
			motorLeft.setSpeed(Configuration.NORMAL_SPEED- Configuration.HARD_DELTA_SPEED);
			motorRight.forward();
			motorLeft.forward();
			break;
		case SOFTRIGHT:
			motorRight.setSpeed(Configuration.NORMAL_SPEED- Configuration.SOFT_DELTA_SPEED);
			motorLeft.setSpeed(Configuration.NORMAL_SPEED);
			motorRight.forward();
			motorLeft.forward();
			break;
		case HARDRIGHT:
			motorRight.setSpeed(Configuration.NORMAL_SPEED- Configuration.HARD_DELTA_SPEED);
			motorLeft.setSpeed(Configuration.NORMAL_SPEED);
			motorRight.forward();
			motorLeft.forward();
			break;	
		case LIGHTRIGHT:
			motorRight.setSpeed(Configuration.LIGHT_NORMAL_SPEED- Configuration.LIGHT_DELTA_SPEED);
			motorLeft.setSpeed(Configuration.LIGHT_NORMAL_SPEED);
			motorRight.forward();
			motorLeft.forward();
			break;
		case LIGHTLEFT:
			motorRight.setSpeed(Configuration.LIGHT_NORMAL_SPEED);
			motorLeft.setSpeed(Configuration.LIGHT_NORMAL_SPEED- Configuration.LIGHT_DELTA_SPEED);
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
	
	void turnLeft() {
		motorLeft.backward();
		motorRight.forward();
	}

}
