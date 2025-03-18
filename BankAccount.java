import java.util.Scanner;

class BankAccount {
    private double balance;

  
    public BankAccount(double initialBalance) 
    {
        this.balance = initialBalance;
    }

    
    public String deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return "Deposit successful! New balance: $" + String.format("%.2f", balance);
        } else {
            return "Invalid deposit amount.";
        }
    }

    
    public String withdraw(double amount) {
        if (amount > balance) {
            return "Insufficient funds.";
        } else if (amount <= 0) {
            return "Invalid withdrawal amount.";
        } else {
            balance -= amount;
            return "Withdrawal successful! New balance: $" + String.format("%.2f", balance);
        }
    }

   
    public String checkBalance() {
        return "Current balance: $" + String.format("%.2f", balance);
    }
}

class ATM {
    private final BankAccount account;
    private final Scanner scanner;


    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    
    public void displayMenu() {
        while (true) {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); 
                continue;
            }

            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1 -> System.out.println(account.checkBalance());
                case 2 -> {
                    System.out.print("Enter deposit amount: ");
                    if (!scanner.hasNextDouble()) {
                        System.out.println("Invalid input. Please enter a valid amount.");
                        scanner.next(); 
                        continue;
                    }
                    double depositAmount = scanner.nextDouble();
                    System.out.println(account.deposit(depositAmount));
                }
                case 3 -> {
                    System.out.print("Enter withdrawal amount: ");
                    if (!scanner.hasNextDouble()) {
                        System.out.println("Invalid input. Please enter a valid amount.");
                        scanner.next(); 
                        continue;
                    }
                    double withdrawAmount = scanner.nextDouble();
                    System.out.println(account.withdraw(withdrawAmount));
                }
                case 4 -> {
                    try (scanner) {
                        System.out.println("Thank you for using the ATM. Goodbye!"); 
                    }
                    return;
                }

                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
}


