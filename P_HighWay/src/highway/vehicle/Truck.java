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
	
	public double getWeightRate(int weight)
	{	double weightRate = 0;
		
		if(this.weight>=4) {
			 weightRate = 1.2;
		}
		
		else if(this.weight>4 && this.weight<=2) {
			 weightRate = 1.0;
		}
		
		else if(this.weight<2) {
			 weightRate = 0.8;
		}
		
		
		return weightRate;
	}




	protected int weight;

	

	@Override
	public int calcToll() {
		int toll = this.fee + (int)(this.getStartPlace().getDistance(endPlace)*this.rate*this.getWeightRate(weight));
		return toll;
	}
	@Override
	public String carInfo() {
		// TODO Auto-generated method stub
		return this.weight + "톤";
	}

}
