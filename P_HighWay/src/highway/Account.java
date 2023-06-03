package highway;

public class Account {
	private int balance;

	public Account(int b) {
		balance = b;
	}

	public void withdraw(int amt) {
		balance -= amt;
	}

	public int getBalance() {
		return balance;
	}
}
