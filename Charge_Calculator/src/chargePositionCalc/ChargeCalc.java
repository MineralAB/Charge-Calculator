package chargePositionCalc;
import java.util.List;
import java.util.ArrayList;

public class ChargeCalc {

	private static final float pi = (float) Math.PI;
	private static final float maximumCirclePacking = (float) 0.902414;

	//Circles area calculation
	private float outerCircleArea;
	private float innerCircleMinimumArea;
	private float innerCircleMaximumArea;
	private int minimumCircleNumber;
	private int maximumCircleNumber;

	public ChargeCalc(float outerCircleRadius, float innerCircleMinimumRadius, float innerCircleMaximumRadius){
		outerCircleArea = (float) (pi * Math.pow(outerCircleRadius, 2));
		innerCircleMinimumArea = (float) (pi * Math.pow(innerCircleMinimumRadius, 2));
		innerCircleMaximumArea = (float) (pi * Math.pow(innerCircleMaximumRadius, 2));
		minimumCircleNumber = calculateMinimumCircleNumber();
		maximumCircleNumber = calculateMaximumCircleNumber();
	}
	
	//Maximum and minimum inner circles number calculation
	private int calculateMinimumCircleNumber(){
		int circleNumber = (int) Math.floor((outerCircleArea * maximumCirclePacking) / innerCircleMaximumArea);
		return circleNumber;
	}
	
	public int getMinimumCircleNumber() {
		return minimumCircleNumber;
	}
	
	private int calculateMaximumCircleNumber(){
		int circleNumber = (int) Math.floor((outerCircleArea * maximumCirclePacking) / innerCircleMinimumArea);
		return circleNumber;
	}
	
	public int getMaximumCircleNumber() {
		return maximumCircleNumber;
	}

	public List<InnerCircleMaxRadiusArray> maxRadiusArr(){
		List<InnerCircleMaxRadiusArray> maxRadiusArray = new ArrayList<InnerCircleMaxRadiusArray>();
		for (int circleNumber = maximumCircleNumber; circleNumber >= minimumCircleNumber; circleNumber--) {
			float maximumAreaOnCircleNumber = ((outerCircleArea * maximumCirclePacking) / circleNumber);
			float maximumRadiusOnCircleNumber = (float) Math.sqrt( maximumAreaOnCircleNumber / pi);
			InnerCircleMaxRadiusArray mra = new InnerCircleMaxRadiusArray(maximumRadiusOnCircleNumber, circleNumber);
			maxRadiusArray.add(mra);
		}
		return maxRadiusArray;
	}
	
	public float[] centerDistCalc(int circleID, int circleNumber, char axis){
		float[] centerDistArray = {};
		return centerDistArray;
	}
	
	public float[] repulsiveForceCalc(char axis){
		float[] repulsiveForceArray = {};
		return repulsiveForceArray;
	}
	
	public float[][] vectorCalc() {
		float xComp = (float) 0.0;
		float yComp = (float) 0.0;
		int vectorID = 0;
		float[][] vectorArray = { {vectorID} , {xComp, yComp} };
		return vectorArray;
	}
}