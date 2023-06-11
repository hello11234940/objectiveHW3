package highway.vehicle;

import highway.Place;

public class Bus extends Vehicle{
	
	public Bus(String carType, int carNumber, int fee, int rate,int passengerNum) {
		super(carType, carNumber, fee, rate);
		this.passengerNum = passengerNum;
		// TODO Auto-generated constructor stub
	}
	
	public Bus(int carNumber, Place startPlace, Place endPlace,int speed) {
		super(carNumber,startPlace,endPlace,speed);
	}
	
	public double getPassengerRate(int passenger)
	{	double passengerRate = 0;
		
		if(this.passengerNum>=40) {
			 passengerRate = 1.2;
		}
		
		else if(this.passengerNum>40 && this.passengerNum<20) {
			 passengerRate = 1.0;
		}
		
		else if(this.passengerNum<20) {
			 passengerRate = 0.8;
		}
		
		
		return passengerRate;
	}


	protected int passengerNum;



	@Override
	public int calcToll() {
		int toll = this.fee + (int)(this.getStartPlace().getDistance(endPlace)*this.rate*this.getPassengerRate(passengerNum));
		return toll;
	}

	@Override
	public String carInfo() {
		// TODO Auto-generated method stub
		return this.passengerNum + " 인승 ";
	}

}
