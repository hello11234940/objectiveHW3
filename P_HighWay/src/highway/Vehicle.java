package highway;



public abstract class  Vehicle {
	private String type;
	private int number;
	private Account account;
	private DateTime enterTime;
	private int numOfCar;
	private String startPlace;
	private String endPlace;
	private int speed;
	
	public Vehicle(String sp,String ep, int s)
	{
		this.speed = s;
		this.startPlace = sp;
		this.endPlace = ep;
	}
	
	public Vehicle(String type, int number)
	{
		this.number = number;
		this.type = type;
	}
	
	public Vehicle(Account account)
	{
		this.account = account;
	}
	public Vehicle(int number,String sp,String ep,int speed)
	{
		this.number = number;
		this.startPlace = sp;
		this.endPlace = ep;
		this.speed = speed;
	}
	public int getNumOfCar()
	{
		return numOfCar;
	}
	
	public DateTime getEnterTime() {
		return enterTime;
	}
	
	public void setEnterTime(DateTime dt)
	{
		enterTime = new DateTime(dt);
	}
	
	public int getNumber()
	{
		return number;
	}
	
	public String getType()
	{
		return type;
	}
	public void pay() // 통행료 인출
	{
		account.withdraw(calcToll());
	}
	
	

	public Account getAccount() 
	{
		return account;
	} 
	  @Override
	    public int compareTo(Vehicle otherCar) {
	        return this.type.compareTo(otherCar.getType());
	  }
	
	// ... calcToll 메소드 생략 ...
	public abstract int calcToll();
	// ... instance variable을 위한 get/set 메소드 생략 ...
	
	public abstract int getDistance();
	public abstract void setDistance(int i);

	public String getStartPlace() {
		return startPlace;
	}

	public void setStartPlace(String startPlace) {
		this.startPlace = startPlace;
	}

	public String getEndPlace() {
		return endPlace;
	}

	public void setEndPlace(String endPlace) {
		this.endPlace = endPlace;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	

	

	
}
