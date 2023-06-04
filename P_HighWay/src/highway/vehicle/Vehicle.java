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
	
	
	public DateTime getEnterTime()
	{
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
        // Calculate the difference in minutes between two DateTime instances
        // This assumes that startTime is always before or equal to endTime
        // You might want to add validation for this
        int differenceInMinutes = (endTime.year - startTime.year) * 525600 // Minutes in a year
                + (endTime.month - startTime.month) * 43800 // Minutes in a month
                + (endTime.day - startTime.day) * 1440 // Minutes in a day
                + (endTime.hour - startTime.hour) * 60 // Minutes in an hour
                + (endTime.minute - startTime.minute); // Minutes

        return differenceInMinutes;
    }
    
    public int getDistance(DateTime currentTime) {
        int minutesPassed = getMinutesDifference(this.enterTime, currentTime);
        int distanceTravelled = this.speed * minutesPassed / 60;
        return distanceTravelled;
    }

	
	
	public abstract String carInfo();
	public abstract int calcToll();

}
