package chargePositionCalc;

public class InnerCircleMaxRadiusArray {
	private float radius;
	private int quantity;
	
	public InnerCircleMaxRadiusArray() {
		radius = 0;
		quantity = 0;
	}

	public InnerCircleMaxRadiusArray(float radius_, int quantity_) {
		radius = radius_;
		quantity = quantity_;
	}

	public void setMaxCircleRadius(float val) {
		radius = val;
	}
	
	public void setCircleNumber(int val) {
		quantity = val;
	}
	
	public float getMaxCircleRadius() {
		return radius;
	}
	
	public int getCircleNumber() {
		return quantity;
	}
}