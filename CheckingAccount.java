
public class CheckingAccount extends BankAccount {
	private int checkNumber;

	public CheckingAccount(String a, int b) {
		super(a);
		if (checkNumber > 0) {
			checkNumber = b;
		} else
			checkNumber = 1000;
	}

	public int getCheckNumber() {
		return checkNumber;
	}

	public String toString() {
		return "Checking Account\n" + super.toString() + "\nNext Check Number:\t" + checkNumber;
	}

	public void writeCheck() {
		++checkNumber;
	}
}
