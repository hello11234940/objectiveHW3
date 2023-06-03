package highway;

public class Bus extends Vehicle{
	private int distacne;
	private int distanceRate;
	private int people;
	private double peopleRate;
	private int fee;
	
	
	public Bus(String type, int number,int people) {
		super(type, number);
		this.people = people;
	}

	@Override
	public int calcToll() {
		
		checkPeopleRate(getPeople());
		
		int toll = (int) (getDistance()*getDistanceRate()*getPeopleRate())+ getFee();
		return toll;
	}

	@Override
	public int getDistance() {

		return distacne;
	}

	@Override
	public void setDistance(int distance) {
		this.distacne = distance;
		
	}
	
	public void checkPeopleRate(int people)
	{
		if(people>=40)
		{
			this.setPeopleRate(1.2);
		}
		
		else if(people>=20 && people<40)
		{
			this.setPeopleRate(1.0);
		}
		
		else if(people<20)
		{
			this.setPeopleRate(0.8);
		}
	}

	public int getDistanceRate() {
		return distanceRate;
	}

	public void setDistanceRate(int distanceRate) {
		this.distanceRate = distanceRate;
	}

	public int getPeople() {
		return people;
	}

	public void setPeople(int people) {
		this.people = people;
	}

	public double getPeopleRate() {
		return peopleRate;
	}

	public void setPeopleRate(double peopleRate) {
		this.peopleRate = peopleRate;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}



}
