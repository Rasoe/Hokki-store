package scootbikerental;

public class Bike extends Vehicle {
	
	private int totalWheels;

	public Bike(String vehicleID, int speed, double basePrice, int totalWheels) {
		super(vehicleID, speed, basePrice);
		this.totalWheels = totalWheels;
	}

	public int getTotalWheels() {
		return totalWheels;
	}

	public void setTotalWheels(int totalWheels) {
		this.totalWheels = totalWheels;
	}

	@Override
	public double calculateTotalPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

}
