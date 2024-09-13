package com.solvd;

import com.solvd.entities.*;
import com.solvd.entities.accounts.*;
import com.solvd.entities.people.Customer;
import com.solvd.entities.people.Employee;
import com.solvd.enums.*;
import com.solvd.interfaces.functionalinterfaces.IConverter;
import com.solvd.interfaces.functionalinterfaces.IFinder;
import com.solvd.interfaces.functionalinterfaces.ITalker;
import com.solvd.utils.UniqueWorldCounter;

import java.util.function.*;

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
        Branch branch = new Branch("BR001", BranchNames.DOWNTOWN_BRANCH.getBranchName(), "456 Elm St", "New York");
        Employee bankManager = new Employee("John Smith", "789 Oak St", JobPositions.MANAGER.getJobPosition());

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
        businessAccount.deposit(1000.00, branch);
        System.out.println("Business Account after deposit: " + businessAccount);
        customer.pay();
        businessAccount.withdraw(2000.00, branch);
        System.out.println("Business Account after withdrawal: " + businessAccount);
        customer.receipt();

        // Deposit and withdraw on CheckingAccount
        checkingAccount.deposit(500.00, branch);
        System.out.println("Checking Account after deposit: " + checkingAccount);
        customer.pay();
        checkingAccount.withdraw(2500.00, branch);
        System.out.println("Checking Account after withdrawal: " + checkingAccount);
        customer.receipt();

        // Deposit and withdraw on CreditCardAccount
        creditCardAccount.deposit(500.00, branch);
        System.out.println("Credit Card Account after deposit: " + creditCardAccount);
        customer.pay();
        creditCardAccount.withdraw(1200.00, branch);
        System.out.println("Credit Card Account after withdrawal: " + creditCardAccount);
        customer.receipt();

        // Deposit and withdraw on LoanAccount
        loanAccount.deposit(300.00, branch);
        System.out.println("Loan Account after deposit: " + loanAccount);
        customer.pay();
        loanAccount.withdraw(1500.00, branch);
        System.out.println("Loan Account after withdrawal: " + loanAccount);
        customer.receipt();

        // Deposit and withdraw on SavingsAccount
        savingsAccount.deposit(200.00, branch);
        System.out.println("Savings Account after deposit: " + savingsAccount);
        customer.pay();
        savingsAccount.withdraw(500.00, branch);
        System.out.println("Savings Account after withdrawal: " + savingsAccount);
        customer.receipt();

        // Exceptions test
        System.out.println("Exceptions list:");
        creditCardAccount.withdraw(12, branch);
        creditCardAccount.withdraw(10000, branch);
        checkingAccount.withdraw(12, branch);
        checkingAccount.withdraw(10000, branch);

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
        branch.getTransactionDB().forEach(System.out::println);

        // Map
        System.out.println();
        System.out.println(Bank.getBranchesByCity("New York"));
        System.out.println(Bank.getBranchesByCity("Madrid"));
        Branch branch2 = new Branch("BR002", BranchNames.CENTRAL_BRANCH.getBranchName(), "532 calle Barcelona", "Madrid");
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
        WithdrawalMachine machine = new WithdrawalMachine(WithdrawalMachinesNumbers.SN001.getSerialNumber());
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

        // 5 Lambda using java.utils
        Predicate<WithdrawalMachine> hasMoney = (withdrawalMachine) -> !withdrawalMachine.listAllBills().isEmpty();
        System.out.println("\nThe withdrawal machine has money: " + hasMoney.test(machine));
        Supplier<String> printRandomCustomerName = () -> branch.getCustomerDB().stream()
                .findAny()
                .map(c -> c.name)
                .orElse("NO ONE!!!!   WUAHAHAHAHAH (evil laugh)");
        System.out.println("And the winner is: " + printRandomCustomerName.get());
        Consumer<String> printCustomerAddress = (customerName) -> branch.getCustomerDB().stream()
                .filter(c -> c.name.equals(customerName))
                .findFirst()
                .ifPresentOrElse(
                        c -> System.out.println(c.name + " address: " + c.address),  // Print address if customer is found
                        () -> System.out.println("Client not in Database")  // Print message if no customer is found
                );
        printCustomerAddress.accept("Alice Johnson");
        Function<String, Branch> getBranchByName = (branchName) -> Bank.branches.values().stream()
                .filter(b -> b.getBranchName().equals(branchName))
                .findFirst()
                .orElse(null);
        System.out.println("Branch: " + (getBranchByName.apply("Downtown Branch") != null ? getBranchByName.apply("Downtown Branch").getBranchName() : "Not found"));
        System.out.println("Branch: " + (getBranchByName.apply("No Branch") != null ? getBranchByName.apply("No Branch").getBranchName() : "Not found"));
        UnaryOperator<String> countAllTransactionsInBranch = branchId -> String.valueOf((Bank.branches.values().stream()
                .filter(b -> b.getBranchId().equals(branchId))
                .mapToInt(b -> b.getTransactionDB().size())
                .sum()));
        System.out.println("Number of transaction in branch BR001: " + countAllTransactionsInBranch.apply("BR001"));

        // 3 Lambda function using generics
        IConverter<Double, Float> convertCurrency = (Double amount, Float rate) -> amount * rate * 100;
        System.out.println("\nCurrency conversion: " + convertCurrency.convert(50.0, 0.25F));
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

        //ENUMS
        System.out.println();
        for (FestiveDays day : FestiveDays.values()) {
            System.out.println(day.getName() + " is on " + day.getMonth() + " " + day.getDay());
        }
        System.out.println(PromotionsNames.LOWCREDITRATE.percentPromo);
        System.out.println(PromotionsNames.SUPERSAVINGSRATE.percentPromo);
        WithdrawalMachine machine2 = new WithdrawalMachine(WithdrawalMachinesNumbers.SN001.getSerialNumber());
        System.out.println(machine2);
        Employee cashier = new Employee("Bill Gate", "79 windows gated St", JobPositions.CASHIER.getJobPosition());
        Employee securityGuard = new Employee("Jim Morrison", "2563 Doors St", JobPositions.SECURITY_GUARD.getJobPosition());
        System.out.println(cashier);
        System.out.println(securityGuard);
        Branch anotherBranch = new Branch("BR432432", BranchNames.SOMETHINGELSEBRANCH.getBranchName(), "2345 Under the sea", "Atlantis");
        System.out.println(anotherBranch);

    }
}
