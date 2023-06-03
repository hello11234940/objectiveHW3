package highway;

public class Truck extends Vehicle{
	private int distanceRate;//거리요율 
	private int distance;//거리 
	private int weight; // 중량 
	private double weightRate;// 중량요율
	private int fee;
	
	
	public Truck(String type, int number, int weight) {
		super(type, number);
		this.setWeight(weight);
		
	}

	@Override
	public int calcToll() {
		checkWeightRate(getWeight());
		
		int toll = (int)(getDistance()*getDistanceRate()*getWeightRate()) + getFee();
		
		return toll;
	}

	@Override
	public int getDistance() {
		return distance;
	}

	@Override
	public void setDistance(int distance) {
		this.distance = distance;
		
	}
	public void checkWeightRate(int weight)
	{
		if(weight>=4)
		{
			this.setWeightRate(1.2);
		}
		
		else if(weight>=2 && weight<4)
		{
			this.setWeightRate(1.0);
		}
		
		else if(weight<2)
		{
			this.setWeightRate(0.8);
		}
		
		
	}
	
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public double getWeightRate() {
		return weightRate;
	}

	public void setWeightRate(double weightRate) {
		this.weightRate = weightRate;
	}

	public int getDistanceRate() {
		return distanceRate;
	}

	public void setDistanceRate(int distanceRate) {
		this.distanceRate = distanceRate;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}
	
	
}
