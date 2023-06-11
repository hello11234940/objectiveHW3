package highway.vehicle;

import highway.Place;

public class Car extends Vehicle{
	
	protected int volume;
	
	public Car(String carType, int carNumber, int fee, int rate,int volume) {
		super(carType, carNumber, fee, rate);
		this.volume = volume;
		// TODO Auto-generated constructor stub
	}
	
	public Car(int carNumber, Place startPlace, Place endPlace,int speed) {
		super(carNumber,startPlace,endPlace,speed);
	}
	



	public double getVolumeRate(int volume)
	{	double volumeRate = 0;
		
		if(this.volume>2400) {
			 volumeRate = 1.2;
		}
		
		else if(this.volume>= 1000 && this.volume<2400) {
			 volumeRate = 1.0;
		}
		
		else if(this.volume<1000) {
			 volumeRate = 0.8;
		}
		
		
		return volumeRate;
	}
	
	


	@Override
	public int calcToll() {
		// TODO Auto-generated method stub
		int toll = this.fee + (int)(this.getStartPlace().getDistance(endPlace)*this.rate*this.getVolumeRate(volume));
		return toll;
	}

	@Override
	public String carInfo() {
		// TODO Auto-generated method stub
		return this.volume + " cc";
	}

	
	
	
}
