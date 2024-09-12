package com.solvd;

import com.solvd.entities.*;
import com.solvd.entities.accounts.BusinessAccount;
import com.solvd.entities.accounts.CheckingAccount;
import com.solvd.entities.accounts.CreditCardAccount;
import com.solvd.entities.accounts.LoanAccount;
import com.solvd.entities.accounts.SavingsAccount;
import com.solvd.entities.people.Customer;
import com.solvd.entities.people.Person;
import com.solvd.interfaces.functionalinterfaces.IConverter;
import com.solvd.interfaces.functionalinterfaces.IFinder;
import com.solvd.interfaces.functionalinterfaces.ITalker;
import com.solvd.utils.UniqueWorldCounter;
import org.apache.logging.log4j.core.util.JsonUtils;

import javax.xml.namespace.QName;

public class Main {
    public static void main(String[] args) {
        // Create instances of different account types
        BusinessAccount businessAccount = new BusinessAccount("BA123456", 5000.00, "Tech Solutions", "123-456-789");
        CheckingAccount checkingAccount = new CheckingAccount("CA987654", 2000.00, 500.00);
        CreditCardAccount creditCardAccount = new CreditCardAccount("CC112233", 1000.00, 5000.00);
        LoanAccount loanAccount = new LoanAccount("LA445566", 1500.00, 50000.00, 3.5);
        SavingsAccount savingsAccount = new SavingsAccount("SA778899", 3000.00, 2.5);

        // Create instances of Customer, Branch, and Person
        Customer customer = new Customer("Alice Johnson", "123 Main St", "CUST001");
        customer.greeting();
        customer.talk();
        Branch branch = new Branch("BR001", "Downtown Branch", "456 Elm St", "New York");
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

        // Exceptions test
        System.out.println("Exceptions list:");
        creditCardAccount.withdraw(12);
        creditCardAccount.withdraw(10000);
        checkingAccount.withdraw(12);
        checkingAccount.withdraw(10000);

        // Exception with resources
        //CheckReading.readCheck();

        // MyLinkedList
        System.out.println();
        branch.addPersonTOPayroll(bankManager);
        branch.printPayroll();
        branch.addPersonTOPayroll(bankManager);
        branch.getPayroll().toList()
                .forEach(System.out::println);

        // Hashset
        System.out.println();
        branch.addCustomerDB(customer);
        branch.getCustomerDB().forEach(System.out::println);
        branch.addCustomerDB(customer);

        // List
        System.out.println();
        Branch.getTransactionDB().forEach(System.out::println);

        // Map
        System.out.println();
        System.out.println(Bank.getBranchesByCity("New York"));
        System.out.println(Bank.getBranchesByCity("Madrid"));
        Branch branch2 = new Branch("BR002", "Central Branch", "532 calle Barcelona", "Madrid");
        System.out.println(Bank.getBranchesByCity("Madrid"));

        // Queue
        System.out.println();
        WaitingList waitingList = new WaitingList();
        waitingList.addToWaitingList("Bowser");
        waitingList.addToWaitingList("Mario");
        waitingList.addToWaitingList("Peach");
        System.out.println("Waiting list size: " + waitingList.getListSize());
        waitingList.peekNextPerson();
        waitingList.serveNextPerson();
        System.out.println("Waiting list size: " + waitingList.getListSize());
        waitingList.serveNextPerson();
        waitingList.serveNextPerson();
        waitingList.serveNextPerson();
        System.out.println("Is the waiting list empty? " + waitingList.isEmpty());

        // Dequeue LIFO
        System.out.println();
        WithdrawalMachine machine = new WithdrawalMachine();
        machine.addBill(new Bill("SN123", 20));
        machine.addBill(new Bill("SN124", 20));
        machine.addBill(new Bill("SN125", 20));
        System.out.println("\nListing all bills in the machine: \n" + machine.listAllBills());
        System.out.println("\nCheck Bill SN124: " + machine.checkBillBySerialNumber("SN124") + "\n");
        //Withdrawal
        System.out.println("Withdrawn Bill: " + machine.withdrawBill());
        System.out.println("Withdrawn Bill: " + machine.withdrawBill());
        System.out.println("Withdrawn Bill: " + machine.withdrawBill());
        System.out.println("Withdrawn Bill: " + machine.withdrawBill());
        System.out.println("\n Listing all bills in the machine: \n" + machine.listAllBills());

        // Word counter
        System.out.println();
        UniqueWorldCounter.uniqueWordCounter();
        UniqueWorldCounter.uniqueWordCounter2();

        // 3 Lambda function with generics
        System.out.println();
        IConverter<Double, Float> convertCurrency = (Double amount, Float rate) -> amount * rate * 100;
        System.out.println(convertCurrency.convert(50.0, 0.25F));
        ITalker<String> talkRobot = (String something) -> System.out.println(something);
        talkRobot.talk("Welcome to BankMine, where your money is mine");
        IFinder<String> findCustomer = (String customerName) ->
                branch.getCustomerDB().stream()
                        .filter(c -> c.name.equals(customerName))
                        .findFirst()
                        .ifPresentOrElse(
                                c -> System.out.println("Customer found. \nName: " + customerName + "\nAddress: " + c.address),
                                () -> System.out.println("No customer found with the name: " + customerName)
                        );
        findCustomer.finder("Hannibal");
        findCustomer.finder(String.valueOf(branch.getCustomerDB().stream().findAny().get().name));
    }




}
