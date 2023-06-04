package highway.vehicle;

import highway.Place;

public class Truck extends Vehicle {
	
	public Truck(String carType, int carNumber, int fee, int rate,int weight) {
		super(carType, carNumber, fee, rate);
		this.weight = weight;
		// TODO Auto-generated constructor stub
	}
	public Truck(int carNumber, Place startPlace, Place endPlace,int speed) {
		super(carNumber,startPlace,endPlace,speed);
	}
	



	protected int weight;

	

	@Override
	public int calcToll() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String carInfo() {
		// TODO Auto-generated method stub
		return this.weight + "톤";
	}

}
