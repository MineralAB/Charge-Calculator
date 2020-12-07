package chargePositionCalc;

import java.io.IOException;
import java.util.List;

import chargePositionGUI.ChargeGUI;

public class ChargeMain {

	private static float outerCircleRadius = (float) 0.0;
	private static float innerCircleMinimumRadius = (float) 0.0;
	private static float innerCircleMaximumRadius = (float) 0.0;
	
	public static void main (String[] args) {
		System.out.println("Start");
		ChargeGUI.chargeGUILaunch();

		boolean userInputIsOk = false;
		do {
			radiusAllocation();
			userInputIsOk = allocationCheckIsOk();
		} while (!userInputIsOk);
		circleRange();
	}
	
	private static void radiusAllocation() {
		try {
			outerCircleRadius = ChargeVariableAcquisition.outerCircleRadius();
			System.out.println(outerCircleRadius);
			innerCircleMinimumRadius = ChargeVariableAcquisition.innerCircleMinimumRadius();
			System.out.println(innerCircleMinimumRadius);
			innerCircleMaximumRadius = ChargeVariableAcquisition.innerCircleMaximumRadius();
			System.out.println(innerCircleMaximumRadius);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean allocationCheckIsOk() {
		if (innerCircleMinimumRadius >= innerCircleMaximumRadius || innerCircleMaximumRadius >= outerCircleRadius) {
			System.out.println("Inner circles minimum radiuses cannot be equal or greater than the maximum one, also the inner circles maximum radiuses cannot be equal or greater than the outer circle radius");
			System.out.println("Reinsert the radiuses");
			return false;
		} else {
			System.out.println("Inserted variables are valid");
			return true;
		}
	}
	
	public static void circleRange() {
		ChargeCalc chargeCalc = new ChargeCalc(outerCircleRadius, innerCircleMinimumRadius, innerCircleMaximumRadius);
		System.out.println("Minimum theoretical circles number:");
		System.out.println(chargeCalc.getMinimumCircleNumber());
		System.out.println("Maximum theoretical circles number:");
		System.out.println(chargeCalc.getMaximumCircleNumber());	
		List<InnerCircleMaxRadiusArray> radiusArray = chargeCalc.maxRadiusArr();
		radiusArray.forEach((index) -> System.out.println(index.getCircleNumber() + ", " + index.getMaxCircleRadius()));
	}
}