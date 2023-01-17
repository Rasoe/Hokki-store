package scootbikerental;

public abstract class Vehicle {
	private String vehicleID;
	private int speed;
	private double basePrice;
	
	public Vehicle(String vehicleID, int speed, double basePrice) {
		super();
		this.vehicleID = vehicleID;
		this.speed = speed;
		this.basePrice = basePrice;
	}
	public String getVehicleID() {
		return vehicleID;
	}
	public void setVehicleID(String vehicleID) {
		this.vehicleID = vehicleID;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public double getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}
	
	public abstract double calculateTotalPrice();
	
}
