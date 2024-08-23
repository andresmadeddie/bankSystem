import main.java.com.solvd.entities.accounts.BusinessAccount;
import main.java.com.solvd.entities.accounts.CheckingAccount;
import main.java.com.solvd.entities.accounts.CreditCardAccount;
import main.java.com.solvd.entities.accounts.LoanAccount;
import main.java.com.solvd.entities.accounts.SavingsAccount;
import main.java.com.solvd.entities.Branch;
import main.java.com.solvd.entities.people.Customer;
import main.java.com.solvd.entities.people.Person;

public class Main {
    public static void main(String[] args) {
        // Create instances of different account types
        BusinessAccount businessAccount = new BusinessAccount("BA123456", 5000.00, "Tech Solutions", "123-456-789");
        CheckingAccount checkingAccount = new CheckingAccount("CA987654", 2000.00, 500.00);
        CreditCardAccount creditCardAccount = new CreditCardAccount("CC112233", 1000.00, 5000.00, 200.00);
        LoanAccount loanAccount = new LoanAccount("LA445566", 1500.00, 50000.00, 3.5);
        SavingsAccount savingsAccount = new SavingsAccount("SA778899", 3000.00, 2.5);

        // Create instances of Customer, Branch, and Person
        Customer customer = new Customer("Alice Johnson", "123 Main St", "CUST001");
        customer.greeting();
        customer.talk();
        Branch branch = new Branch("BR001", "Downtown Branch", "456 Elm St");
        Person bankManager = new Person("John Smith", "789 Oak St");

        // Display initial account details
        System.out.println(branch.getBankName());
        System.out.println("Initial Account Details:");
        System.out.println(businessAccount);
        System.out.println(checkingAccount);
        System.out.println(creditCardAccount);
        System.out.println(loanAccount);
        System.out.println(savingsAccount);

        // Display customer, branch, and person details
        System.out.println("\nCustomer Details:");
        System.out.println(customer);

        System.out.println("\nBranch Details:");
        System.out.println(branch);

        System.out.println("\nBank Manager Details:");
        System.out.println(bankManager);

        // Perform some operations
        System.out.println("\nPerforming operations...\n");

        // Deposit and withdraw on BusinessAccount
        businessAccount.deposit(1000.00);
        System.out.println("Business Account after deposit: " + businessAccount);
        customer.pay();
        businessAccount.withdraw(2000.00);
        System.out.println("Business Account after withdrawal: " + businessAccount);
        customer.receipt();

        // Deposit and withdraw on CheckingAccount
        checkingAccount.deposit(500.00);
        System.out.println("Checking Account after deposit: " + checkingAccount);
        customer.pay();
        checkingAccount.withdraw(2500.00);
        System.out.println("Checking Account after withdrawal: " + checkingAccount);
        customer.receipt();

        // Deposit and withdraw on CreditCardAccount
        creditCardAccount.deposit(500.00);
        System.out.println("Credit Card Account after deposit: " + creditCardAccount);
        customer.pay();
        creditCardAccount.withdraw(1200.00);
        System.out.println("Credit Card Account after withdrawal: " + creditCardAccount);
        customer.receipt();

        // Deposit and withdraw on LoanAccount
        loanAccount.deposit(300.00);
        System.out.println("Loan Account after deposit: " + loanAccount);
        customer.pay();
        loanAccount.withdraw(1500.00);
        System.out.println("Loan Account after withdrawal: " + loanAccount);
        customer.receipt();

        // Deposit and withdraw on SavingsAccount
        savingsAccount.deposit(200.00);
        System.out.println("Savings Account after deposit: " + savingsAccount);
        customer.pay();
        savingsAccount.withdraw(500.00);
        System.out.println("Savings Account after withdrawal: " + savingsAccount);
        customer.receipt();
    }
}
