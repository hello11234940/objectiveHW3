package highway.vehicle;

import highway.Place;

public class HybridCar extends Car{

	public HybridCar(String carType, int carNumber, int fee, int rate, int volume) {
		super(carType, carNumber, fee, rate, volume);
		// TODO Auto-generated constructor stub
	}
	public HybridCar(int carNumber, Place startPlace, Place endPlace,int speed) {
		super(carNumber,startPlace,endPlace,speed);
	}
	
	public String carInfo() {
		return this.volume + "cc";
	}
	
	public int calcToll() {
		return super.calcToll()/2;
	}
	
	
	
}
