import java.util.Scanner;

class BankAccount 
{
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public boolean withdraw(double amount) 
    {
        if (amount > 0 && amount <= balance) 
        {
            balance -= amount;
            return true;
        }
        return false;
    }

    public boolean deposit(double amount) 
    {
        if (amount > 0) 
        {
            balance += amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }
}

public class ATM 
{

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount(0.0);

        int choice=0;
        while (true) 
        {
            if (choice == 4) 
                break;

            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
           
            switch (choice) 
            {
                case 1:
                    System.out.println("Your current balance is: "+ account.getBalance());
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    if (account.deposit(depositAmount))
                        System.out.println("Deposit successful.");
                    else
                        System.out.println("Invalid amount. Deposit failed.");
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    if (account.withdraw(withdrawAmount)) 
                        System.out.println("Withdrawal successful.");
                    else 
                        System.out.println("Insufficient balance. Withdrawal failed.");
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM.");
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}


