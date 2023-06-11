package highway.vehicle;

import java.util.ArrayList;

import highway.DateTime;
import highway.Place;

public abstract class Vehicle {

	// protected
	protected int carNumber;
	protected int rate;
	protected String carType;
	protected DateTime enterTime;
	protected DateTime endTime;
	protected Place startPlace;
	protected Place endPlace;
	protected int distance;
	protected int speed;
	protected int fee;
	protected DateTime exitTime;

	ArrayList<Vehicle> vehicleList;

	public Vehicle(String carType, int carNumber, int fee, int rate) {
		this.carType = carType;
		this.carNumber = carNumber;
		this.fee = fee;
		this.rate = rate;
	}

	public Vehicle(int carNumber, Place startPlace, Place endPlace, int speed) {
		this.carNumber = carNumber;
		this.startPlace = startPlace;
		this.endPlace = endPlace;
		this.speed = speed;
	}

	public int getDistance() {
		return startPlace.getDistance(endPlace);
	}

	public void setHighwayInfo(DateTime dt, Place startPlace, Place endPlace, int speed) {
		this.enterTime = dt;
		this.startPlace = startPlace;
		this.endPlace = endPlace;
		this.speed = speed;
	}

	public DateTime getEnterTime() {
		return enterTime;
	}
	
	
	
	public void setCurrentTime(DateTime currentTime) {
		this.enterTime = currentTime;
	}

	public void setEndTime(DateTime endTime) {
		this.endTime = endTime;
	}

	public String enterHighwayInfo() {
		return "진입시간: " + enterTime + " 진입장소: " + startPlace.getName() + " 진출장소: " + endPlace.getName() + " 시속: "
				+ speed + "km";
	}

	public String exitHighwayInfo() {
		return carType + " " + carNumber + " " + carInfo() + " " + exitTime + " " + startPlace.getName() + "->"
				+ endPlace.getName() + " " + fee + "원";
	}
	
	

	public int getcarNumber() {
		return carNumber;
	}

	public void setcarNumber(int cn) {
		this.carNumber = cn;
	}

	public String getCarType() {
		return carType;
	}

	public void setStartPoint(Place startPoint) {
		this.startPlace = startPoint;
	}

	public void setEndPoint(Place endPoint) {
		this.endPlace = endPoint;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	 public void setExitTime(DateTime exitTime) {
	        this.exitTime = exitTime;
	}
	  
	public DateTime getExitTime() {
		return this.exitTime;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public int getFee() {
		return this.fee;
	}

	public ArrayList<Vehicle> getVehicleList() {
		return vehicleList;
	}

	public Place getStartPlace() {
		return this.startPlace;
	}

	public Place getEndPlace() {
		return this.endPlace;
	}

	public int getCarSpeed() {
		return this.speed;
	}

	public int getDistanceFromTime(DateTime inputTime) {
		int minutesPassed = getMinutesDifference(this.enterTime, inputTime);
		int distanceTravelled = this.speed * minutesPassed / 60;
		return distanceTravelled;
	}

	private int getMinutesDifference(DateTime startTime, DateTime endTime) {
		
		int differenceInMinutes = (endTime.year - startTime.year) * 525600 
				+ (endTime.month - startTime.month) * 43800 
				+ (endTime.day - startTime.day) * 1440 
				+ (endTime.hour - startTime.hour) * 60 
				+ (endTime.minute - startTime.minute); 

		return differenceInMinutes;
	}

	public int getDistance(DateTime currentTime) {
		int minutesPassed = getMinutesDifference(this.enterTime, currentTime);
		int distanceTravelled = this.speed * minutesPassed / 60;
		return distanceTravelled;
	}
	
	public void calculateExitTime() {
	    int distance = this.startPlace.getDistance(this.endPlace);
	    int travelTimeInMinutes = (distance * 60) / this.speed; 

	    
	    this.exitTime = new DateTime(this.enterTime);
	    
	    this.exitTime.addMinutes(travelTimeInMinutes);
	}

	public boolean hasExited(DateTime currentTime) {
	    
	    calculateExitTime();
	    return currentTime.isAfter(this.exitTime);
	}
	
	public int calculatePosition(DateTime currentTime) {
	    if (hasExited(currentTime)) {
	    
	        return this.startPlace.getDistance(this.endPlace);
	    } else {
	       
	        int minutesPassed = getMinutesDifference(this.enterTime, currentTime);
	        return (this.speed * minutesPassed) / 60;
	    }
	}
	

	public abstract String carInfo();

	public abstract int calcToll();

}
