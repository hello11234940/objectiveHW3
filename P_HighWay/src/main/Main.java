package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import highway.DateTime;
import highway.VehiclesSystem;
import highway.vehicle.Bus;
import highway.vehicle.Car;
import highway.vehicle.HybridCar;
import highway.vehicle.Truck;
import highway.vehicle.Vehicle;





public class Main {
	
	public String getVehicleType(Vehicle v) {
		if(v instanceof Car) {
			return "car";
		}
		
		
		return "";
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new InputStreamReader(new FileInputStream("vehicles.txt")));
		
		int carCnt = Integer.parseInt(sc.nextLine());
		
		List<Vehicle> vehiclesList = new ArrayList<>();
		
		Car c;
		
		vehiclesList.add(c);
		
		if(c instanceof Car) {
			
		}
		
		
		
		
		
		
		for(int i = 0; i<carCnt;i++) {
			//ex) c 1234 2000
			String[] word = sc.nextLine().split(" ");
			String type = word[0];
			int number = Integer.parseInt(word[1]);
			
			if(type.equals("c")) {
				int volume = Integer.parseInt(word[2]);
				vehiclesList.add(new Car(type,number,volume));
				
			}
			
			else if(type.equals("h")) {
				int volume = Integer.parseInt(word[2]);
				vehiclesList.add(new HybridCar(type,number,volume));
				
			}
			
			else if(type.equals("b")) {
				int people = Integer.parseInt(word[2]);
				vehiclesList.add(new Bus(type,number,people));
				
			}
			
			else if(type.equals("t")) {
				int weight = Integer.parseInt(word[2]);
				vehiclesList.add(new Truck(type,number,weight));
				
			}
			
		}
		
		sc = new Scanner(new InputStreamReader(new FileInputStream("test.txt")));
		VehiclesSystem vs = new VehiclesSystem(sc,vehiclesList);
		
		 while(true) {
			String[] cmds = sc.nextLine().split(" ");
			
			switch(cmds[0]) {
			// t 2023 6 2 12 00
			case "t":
				DateTime currentTime = new DateTime(Integer.parseInt(cmds[1]), Integer.parseInt(cmds[2]), Integer.parseInt(cmds[3]), 
						Integer.parseInt(cmds[4]), Integer.parseInt(cmds[5]));
				if(!DateTime.isValid(currentTime)) {
					System.out.println("현재시간 :");
				}
				
				else
				{
					System.out.println("현재시간 :" + currentTime);
				}
				break;
				// n 1234 서울 대전 100
			case "n":
				
				break;
			case "o":
				
				break;
			case "x":
				
				break;
			case "c":
				
				break;
			}
			
			
		}
		
		
		
		
		
		
		
		
	}
	

}
