package highway;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import exception.InvaildCarNumberException;
import exception.InvaildLocationException;
import exception.InvaildPlaceException;
import exception.InvaildSpeedException;
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
	
	

	public void enterHighway(DateTime dt, int carNumber, Place startPoint, Place endPoint, int speed) throws InvaildCarNumberException,InvaildLocationException,InvaildSpeedException{
	    if(!(carNumber >=1000 && carNumber <= 9999)) {
	    	throw new InvaildCarNumberException("유효하지않은 번호입니다.");
	    }
	    if(startPoint.equals(endPoint)) {
	        throw new InvaildLocationException("시작점과 종점이 같습니다.");
	    }
	    if(!(speed >49 && speed <121)) {
	    	throw new InvaildSpeedException("속도가 올바르지 않습니다.");
	    }
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
	
	public boolean printExitedVehicles(DateTime currentTime) {
	    List<Vehicle> exitedVehicles = new ArrayList<>();
	    for (Vehicle vehicle : vehicleList) {
	        if (vehicle.hasExited(currentTime)) {
	            exitedVehicles.add(vehicle);
	        }
	    }

	    if (exitedVehicles.isEmpty()) {
	        System.out.println("진출한 차량이 없습니다!");
	        return false;
	    }

	    // Implement the sorting logic here

	    int count = 1;
	    for (Vehicle vehicle : exitedVehicles) {
	    	System.out.println(count + ". " + vehicle.getCarType() + " " + vehicle.getcarNumber() + " " + vehicle.carInfo()
	    	+ " " + vehicle.getEnterTime() + " " + vehicle.getStartPlace().getName() + "->" + vehicle.getEndPlace().getName()
	    	+ " 시속:" + vehicle.getCarSpeed() + "km 위치:"
	    	+ vehicle.calculatePosition(currentTime) + "km"
	    	+ " " + vehicle.getExitTime() + " " + vehicle.calcToll() + "원");
	    	count++;
	    }

	    return true;
	}
	

	

	public boolean printAllVehicles(DateTime currentTime) throws InvaildPlaceException {
	    List<Vehicle> sortedList = new ArrayList<>(vehicleList);

	    // 정렬 순서를 지정하는 맵
	    Map<String, Integer> carTypeOrder = new HashMap<>();
	    carTypeOrder.put("c", 1);
	    carTypeOrder.put("h", 2);
	    carTypeOrder.put("b", 3);
	    carTypeOrder.put("t", 4);

	    // 지정한 순서와 시간으로 정렬
	    sortedList.sort(Comparator.comparing((Vehicle v) -> carTypeOrder.get(v.getCarType()))
	            .thenComparing(Vehicle::getEnterTime));

	    if (sortedList.isEmpty()) {
	        System.out.println("통행 차량이 없습니다!");
	        return false;
	    }

	    int count = 1;
	    for (Vehicle vehicle : sortedList) {
	    	System.out.println(count + ". " + vehicle.getCarType() + " " + vehicle.getcarNumber() + " " + vehicle.carInfo()
	        + " " + vehicle.getEnterTime() + " " + vehicle.getStartPlace().getName() + "->" + vehicle.getEndPlace().getName()
	        + " 시속:" + vehicle.getCarSpeed() + "km 위치:"
	        + Math.abs(vehicle.getDistanceFromTime(currentTime) 
	        - Place.getByName(vehicle.getStartPlace().getName()).location) + "km");

	        count++;
	    }

	    return true;
	}
	
	
	
}