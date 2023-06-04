package highway;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import highway.vehicle.Bus;
import highway.vehicle.Car;
import highway.vehicle.HybridCar;
import highway.vehicle.Truck;
import highway.vehicle.Vehicle;

public class VehiclesSystem {
	private List<Vehicle> vehicleList;
	
	private DateTime dt;
	private int carFee;
	
	private Scanner sc;
	
	public VehiclesSystem(Scanner sc,List<Vehicle> vehicleList)
	{
		this.sc = sc;
		this.vehicleList = vehicleList;
	}
	
	public String getVehicleType(Vehicle v) {
		if(v instanceof Car) {
			
			return "승용차";
		}
		
		else if(v instanceof HybridCar) {
			return "하이브리드차";
		}
		
		else if(v instanceof Bus) {
			return "버스";
		}
		
		else if(v instanceof Truck) {
			return "트럭";
		}
		
		return "";
	}
	
	

	public void enterHighway(DateTime dt, int carNumber, Place startPoint, Place endPoint, int speed) {
	    for (Vehicle vehicle : vehicleList) {
	        if (vehicle.getcarNumber() == carNumber) {
	        	vehicle.setCurrentTime(dt);
	            vehicle.setStartPoint(startPoint);
	            vehicle.setEndPoint(endPoint);
	            vehicle.setSpeed(speed);
	            System.out.println(vehicle.getCarType() + " " + carNumber + " 진입");
	            System.out.println(vehicle.enterHighwayInfo());
	            break;
	        }
	    }
	}
	public void showByEndTime(DateTime et) {
		for (Vehicle vehicel : vehicleList) {
			if()
		}
	}
	
	public List<Vehicle> showByTime()
	{
		return null;
	}
	
	
	public static boolean isVaildEnterHighwayBySpeed(int speed) {
		if(speed>120 && speed<50) {
			return false;
		}
		else {
			return true;
		}
	}
	
	
	
	
}