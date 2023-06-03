package highway.vehicle;

import highway.DateTime;
import highway.Place;

public abstract class  Vehicle {
	
	//protected
	private int carNumber;
	private DateTime enterTime;
	private Place startPlace;
	private Place endPlace;
	private int distance;
	private int speed;
	private int fee;
	
	public Vehicle(String sp,String ep, int s)
	{
		
		
	}
	

	public void printVehicleInfo(DateTime nowTime) {
		
	}
	
	// ... calcToll 메소드 생략 ...
	public abstract int calcToll();
	// ... instance variable을 위한 get/set 메소드 생략 ...
	

}
