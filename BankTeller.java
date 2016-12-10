import java.util.Scanner;

public class BankTeller {

	public static void main(String[] args) {
		Bank chaseBank = new Bank(2);

		char command;
		Scanner input = new Scanner(System.in);
		printMenu();
		do {
			// ask a user to choose a command
			System.out.println("\nPlease enter a command or type ?");
			command = input.nextLine().toLowerCase().charAt(0);

			switch (command) {
			case 'a': // add
				int SaveOrCheck = -1;
				while (SaveOrCheck < 1 || SaveOrCheck > 2) {
					System.out.print("\nEnter 1 for Savings Account or 2 for Checking Account: ");
					SaveOrCheck = Integer.parseInt(input.nextLine());
				}
				System.out.print("Enter account holder name: ");
				String name = input.nextLine();

				BankAccount x;
				if (SaveOrCheck == 1) {
					System.out.print("Enter interest rate: ");
					int interestrate = Integer.parseInt(input.nextLine());
					x = new SavingsAccount(name, interestrate);
				} else {
					System.out.print("Enter starting check number: ");
					int checknum = Integer.parseInt(input.nextLine());
					x = new CheckingAccount(name, checknum);
				}
				if (chaseBank.add(x))
					System.out.print("\nBank Account successfully added.\n");
				else
					System.out.print("Bank Account not added. No duplicates please.\n");
				break;
			case 'b': // remove
				System.out.print("\nEnter account number: ");
				int acctNum = Integer.parseInt(input.nextLine());
				if (chaseBank.remove(chaseBank.find(acctNum)))
					System.out.print("\nBank Account successfully removed.\n");
				else
					System.out.print("Bank Account not found. Cannot remove.\n");
				break;
			case 'c': // display
				System.out.println(chaseBank.toString());
				break;
			case 'd': // count
				System.out.println("\nThere are " + chaseBank.getCount() + "BankAccounts in the bank");
				break;
			 case 'e':
				chaseBank.sort();
				break;
			 case 'f':
				System.out.print("Enter account number: ");
				int accntnum = Integer.parseInt(input.nextLine());
				BankAccount b = chaseBank.find(accntnum);
				int DepOrWith = -1;
				while (DepOrWith < 1 || DepOrWith > 2) {
					System.out.print("\nEnter 1 for deposit or 2 for withdraw: ");
					DepOrWith = Integer.parseInt(input.nextLine());
				}
				System.out.print("Enter amount: ");
				double amt = Double.parseDouble(input.nextLine());
				if (DepOrWith == 1) {
					if (b.deposit(amt))
						System.out.print("Transaction successful");
					else
						System.out.print("Transaction not successful");
				} else {
					if (b.withdraw(amt))
						System.out.print("Transaction successful");
					else
						System.out.print("Transaction not successful");
				}

				break;
			case '?':
				printMenu();
				break;
			case 'q':
				System.out.println("GOOD BYE!");
				break;
			default:
				System.out.println("Invalid Input");

			}

		} while (command != 'q');

		input.close();
	}

	public static void printMenu() {
		System.out.print("\n BankTeller Options\n" + "-----------------------------------\n"
				+ "\n a: add an account to the bank" + "\n b: remove an account from the bank"
				+ "\n c: display the accounts in the bank" + "\n d: count the accounts in the bank"
				+ "\n e: sort the accounts in the bank" + "\n f: update an account in the bank"
				+ "\n ?: display the menu again" + "\n q: quit this program");
	}

}
