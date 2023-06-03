package highway;

public class HybridCar extends Car{

	public HybridCar(Account account, int v) {
		super(account, v);

	}
	
	public HybridCar(String type,int number,int volume)
	{
		super(type,number,volume);
	}
	
	public int calcToll() {
		int toll = super.calcToll() / 2;
		return toll;
	}
	
	
	
}
