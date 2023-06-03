package highway;

import java.util.List;
import java.util.Scanner;

public class Car extends Vehicle{
	
	private int distanceRate; //거리효율
	private int distance; //거
	private int volume; // 배기량
	private int fee;// 기본 요금
	private double volumeRate;//배기요율
	private String startPlace;
	private String endPlace;
	private int speed;
	private DateTime enterTime;
	private Scanner sc;
	private List<Car> carList;
	
	public Car(Account account, int v) {
		super(account);
		volume = v;
	}
	
	public Car(String type,int number,int v)
	{
		super(type,number);
		this.volume = v;
	}
	
	public Car(String sp,String ep, int s)
	{
		super(sp,ep,s);
	}
	public List<Car> getCarList()
	{
		return carList;
	}
	public int calcToll() {
		// 거리 요율 // 통행 거리
		// 차량 배기량
		// 통행료 계산
		// ... 수정 ...
		// 통행료 = 기본요금 + (거리 * 거리 요율 * 배기량 요율)
		
		checkVolumeRate(getVolume());
		
		
		
		int toll = (int) (getDistance() *getDistanceRate() * getVolumeRate()) + getFee();
		return toll;
	}
	

	public void checkVolumeRate(int volume)
	{	
		if(volume>=2400)
		{
			this.setVolumeRate(1.2);
		}
		
		else if(volume>= 1000 && volume <2400)
		{
			this.setVolumeRate(1.0); 
		}
		
		else if(volume<1000) {
			this.setVolumeRate(0.8);
		}
		
	}
	
	public double getVolumeRate()
	{
		return volumeRate;
	}
	
	public int getFee()
	{
		return fee;
	}

	public int getVolume() {
		return volume;
	}
	
	public  void setVolume(int volume)
	{
		this.volume = volume;
	}

	public void setDistanceRate(int d) {
		distanceRate = d;
	}

	public int getDistanceRate() {
		return distanceRate;
	}
	@Override
	public int getDistance()
	{
		return distance;
	}
	@Override
	public void setDistance(int distance) {
		this.distance = distance;
	}

	public void setVolumeRate(double volumeRate) {
		this.volumeRate = volumeRate;
	}

	

	
	
}
