
// Name: Jeffery Brown
// Assignment: PA12 BankAccount
// Description: This class is used to create BankAccount objects
// Time spent: 2.5 hours

// Name: Jeffery Brown
// Assignment: PA12 BankAccount
// Description: This class is used to create BankAccount objects
// Time spent: 2.5 hours
import java.util.Date;
import java.util.Random;

public class BankAccount {
	protected String name;
	protected double balance;
	protected int acctNum;
	protected Date date = new Date();
	protected static int accountsCreated;

	public BankAccount(String na) {
		name = na;
		acctNum = generateAcctNum();
		accountsCreated++;
	}

	public double getBalance() {
		return balance;
	}

	public double getAccountNumber() {
		return acctNum;
	}

	public boolean deposit(double i) {
		if (i < 0)
			return false;
		else {
			balance += i;
			return true;
		}
	}

	public boolean withdraw(double x) {
		if (x > balance || x < 0)
			return false;
		else {
			balance -= x;
			return true;
		}

	}

	public String toString() {
		return name + " [" + acctNum + "]\n" + date + "\n" + String.format("$%,.2f", balance);

	}

	public boolean equals(BankAccount that) {
		if (this.acctNum == that.acctNum)
			return true;
		else
			return false;

	}

	protected int generateAcctNum() {
		Random r = new Random();
		String s = r.nextInt(9) + 1 + "";
		for (int i = 1; i <= 8; i++)
			s += r.nextInt(10);
		return Integer.parseInt(s);
	}

	public boolean transfer(BankAccount a, double x) {
		if (balance >= 0) {
			a.deposit(x);
			balance = balance - x;
			return true;
		}

		return false;
	}

	public static int getAccountsCreated() {
		return accountsCreated;
	}

}
