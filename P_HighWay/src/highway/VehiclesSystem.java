package highway;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehiclesSystem {
	private List<Vehicle> vehicleList;
	private List<Car> carList;
	private List<HybridCar> hybridList;
	private List<Bus> busList;
	private List<Truck> truckList;
	private Scanner sc;
	
	public VehiclesSystem(Scanner sc,List<Vehicle> vehicleList)
	{
		this.sc = sc;
		this.vehicleList = vehicleList;
	}
	public VehiclesSystem(Scanner sc, List<Car> carList, List<HybridCar> hybridList, List<Bus> busList, List<Truck> truckList) {
	    this.sc = sc;
	    this.carList = carList;
	    this.hybridList = hybridList;
	    this.busList = busList;
	    this.truckList = truckList;

	    this.vehicleList = new ArrayList<>();
	    vehicleList.addAll(carList);
	    vehicleList.addAll(hybridList);
	    vehicleList.addAll(busList);
	    vehicleList.addAll(truckList);
	}
	
	public List<Vehicle> enterHighway(int number, String startPlace, String endPlace, int speed) {
	    List<Vehicle> enteredVehicles = new ArrayList<>();
	    
	    // 차량 리스트에서 번호에 해당하는 차량을 찾아 진입 처리
	    for (Vehicle vehicle : vehicleList) {
	        if (vehicle.getNumber() == number) {
	        	
	            vehicle.enterHighway(startPlace, endPlace, speed);
	            enteredVehicles.add(vehicle);
	            break;
	        }
	    }

	    return enteredVehicles;
	}
	
	
}