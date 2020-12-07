package chargePositionCalc;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ChargeVariableAcquisition {
		
	public static float outerCircleRadius () throws IOException {
		String request = "Insert outer circle radius in millimeters";
		float readValue = numberRead(request);
	return readValue;		
	}
	
	public static float innerCircleMinimumRadius () throws IOException {
		String request = "Insert inner circle minimum radius in millimeters";
		float readValue = numberRead(request);
	return readValue;
	}
	
	public static float innerCircleMaximumRadius () throws IOException {
		String request = "Insert inner circle maximum radius in millimeters";
		float readValue = numberRead(request);
	return readValue;
	}
	
	private static float numberRead (String request) throws IOException {
		float readValue = (float) 0.0;
		System.out.println(request);
	    BufferedReader reader =
	            new BufferedReader(new InputStreamReader(System.in));
	    String readString = reader.readLine();
	    try {
		readValue = Float.parseFloat(readString);
	    } catch (NumberFormatException nfe){
	    	System.out.println(nfe);
	    } catch (NullPointerException npe) {
	    	System.out.println(npe);
	    }
	return readValue;		
	}		
}