package scootbikerental;

import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;

public class ScootBikeRent {
	
	public static ArrayList<Vehicle> arrayListVehicle = new ArrayList<>();
	
	public static void loadData() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/scootbikerental","root","");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from scooter");
			while(rs.next()) {
				Scooter scooter = new Scooter(rs.getString(1), rs.getInt(2), rs.getDouble(3), rs.getInt(4));
				arrayListVehicle.add(scooter);
			}
			rs = stmt.executeQuery("select * from bike");
			while(rs.next()) {
				Bike bike = new Bike(rs.getString(1), rs.getInt(2), rs.getDouble(3), rs.getInt(4));
				arrayListVehicle.add(bike);
			}
			rs = stmt.executeQuery("select * from scooter");
			while(rs.next()) {
				Scooter scooter = new Scooter(rs.getString(1), rs.getInt(2), rs.getDouble(3), rs.getInt(4));
				arrayListVehicle.add(scooter);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		loadData();
		Scanner scanner = new Scanner(System.in);
		int choice;
		do {
			System.out.println("============================");
			System.out.println("||    Scootbike Rental    ||");
			System.out.println("============================\n");
			System.out.println("1. Rent a Vehicle");
			System.out.println("2. View Transactions");
			System.out.println("3. Delete Transactions");
			System.out.println("4. Exit");
			System.out.print("Choice [1-4]: ");choice = Integer.parseInt(scanner.nextLine());
			switch (choice) {
			case 1:{
				int vehicleChoice;
				System.out.println("==============================================================================");
				System.out.println("|                            < Vehicles >                                    |");
				System.out.println("==============================================================================");
				System.out.printf("|%4s|%12s|%9s|%12s|%20s|%14s|\n", "No", "Vehicle ID", "Speed", "Base Price", "Battery Drain Rate", "Total Wheels");
				System.out.println("==============================================================================");
				for(int i = 0; i<arrayListVehicle.size(); i++) {
					Vehicle vehicle = arrayListVehicle.get(i);
					if(vehicle instanceof Scooter) {
						Scooter scooter = (Scooter) vehicle;
						System.out.printf("|%4d|%12s|%9s|%12s|%20s|%14s|\n", i+1, vehicle.getVehicleID(), vehicle.getSpeed() + " km/h", "$"+vehicle.getBasePrice()+" / h", scooter.getBatteryDrainRate() + "% / min", "-");
					}
					else {
						Bike bike = (Bike) vehicle;
						System.out.printf("|%4d|%12s|%9s|%12s|%20s|%14s|\n", i+1, vehicle.getVehicleID(), vehicle.getSpeed() + " km/h", "$"+vehicle.getBasePrice()+" / h", "-", bike.getTotalWheels()+" wheels");
					}
				}
				System.out.println("==============================================================================");
				System.out.print("Choice [1-"+arrayListVehicle.size()+"]: ");vehicleChoice = Integer.parseInt(scanner.nextLine());
				String name;
				String email;
				String address;
				do {
					System.out.print("Your name [1 - 30 characters] (inclusive):");name = scanner.nextLine();
				}while(name.length() < 1 || name.length() > 30);
				do {
					System.out.print("Your email [contains ‘@’ and ends with ‘.com’]:");email = scanner.nextLine();
				}while(!email.contains("@") && email.endsWith(".com"));
				do {
					System.out.print("Your address [ends with ' Street'");address = scanner.nextLine();
				}while(address.endsWith(" Street"));
			}
			default:
				break;
			}
		}while(choice !=4);
		scanner.close();
	}

}
