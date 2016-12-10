
public class SavingsAccount extends BankAccount {
	private double interestRate;

	public SavingsAccount(String a, double b) {
		super(a);
		if (b > 0 && b < .10) {
			interestRate = b;
		} else
			interestRate = 0.01;
	}

	public double getRate() {
		return interestRate;

	}

	public String toString() {
		return "Savings Account\n" + super.toString() + "\nInterest Rate:\t%" + String.format("%1.3f", interestRate);

	}

	public void addInterest() {
		interestRate += balance;
	}

}
