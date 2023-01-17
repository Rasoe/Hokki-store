package scootbikerental;

public class Scooter extends Vehicle {
	
	private int batteryDrainRate;

	public Scooter(String vehicleID, int speed, double basePrice, int batteryDrainRate) {
		super(vehicleID, speed, basePrice);
		this.batteryDrainRate = batteryDrainRate;
	}

	public int getBatteryDrainRate() {
		return batteryDrainRate;
	}

	public void setBatteryDrainRate(int batteryDrainRate) {
		this.batteryDrainRate = batteryDrainRate;
	}

	@Override
	public double calculateTotalPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

}
