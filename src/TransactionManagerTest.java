import static org.junit.Assert.*;

public class TransactionManagerTest {
    long id1 = 1;
//
//    String firstName, String lastName, String dateOfBirth, long identificationNumber,
//    String address, String phoneNumber, String email, String password,
//    long checkingAccountNum, long savingAccountNum, long creditAccountNum, double checkingBalance,
//    double savingBalance, double creditBalance, double creditMax


    Customer customer1 = new Customer("Mickey", "Mouse", "March 16, 1940", 1,
            "1313 Disneyland Dr, Anaheim, CA 92802", "(714) 781-4636", "MickeyMouse@disney.com",
            "Mouse*Mickey!987", 1000, 2000, 3000,
            1932.84, 1644.96, -315.19, 1000);

    Customer customer2 = new Customer("Donald","Duck","August 29, 1950",2,
            "1313 Disneyland Dr, Anaheim, CA 92802","(714) 781-4636","DonaldDuck@disney.com",
            "Duck*Donald!987",1001,2001,3001,
            1141.35,21.17,-1812.21, 10000);
    Customer customer3 = new Customer("Minnie","Mouse","June 13, 1958",3,
            "1313 Disneyland Dr, Anaheim, CA 92802","(714) 781-4636","MinnieMouse@disney.com",
            "Mouse*Minnie!987",1002,2002,3002,
            1107.91,1934.53,-16.34, 10000);

    double amount1 = 1000000000;
    TransactionManager transactionManagerTest1 = new TransactionManager(customer1, customer2, "PAY",
            customer1.getCredit(), customer2.getChecking(), amount1);

    //Amount to be paid is a huge amount (1 trillion)
    //Since credit account is used to make payment, the assumption is that there is no limit
    @org.junit.Test
    public void testPayWithCreditAccount_checkTrue() {
        assertTrue(transactionManagerTest1.pay());
    }

    int amount2 = 500;
    TransactionManager transactionManagerTest2 = new TransactionManager(customer1, customer2, "PAY",
            customer1.getSavings(), customer2.getCredit(), amount2);

    //Trying to pay more than the credit account's balance
    //Cannot have positive balance with a credit account
    //Paying 500 to -215.12 credit account
    @org.junit.Test
    public void testPayToCreditAccount_checkFalse() {
        assertTrue(transactionManagerTest2.pay());
    }

    //Transfering 400 to from checking account with 344.68 to savings account
    int amount3 =50;
    TransactionManager transactionManagerTest3 = new TransactionManager(customer1, customer1, "TRANSFER",
            customer1.getChecking(), customer1.getSavings(), amount3);
    @org.junit.Test
    public void testTransferAmountHigherThanBalance_checkFalse() {
        assertTrue(transactionManagerTest3.pay());
    }

    //Tests to make sure amount being transferred is correct
    int amount4 = 200;
    TransactionManager transactionManagerTest4 = new TransactionManager(customer1, customer1, "TRANSFER",
            customer1.getChecking(), customer1.getSavings(), amount4);
    @org.junit.Test
    public void testTransferToAccount_checkAmount() {
        double expectedBalance = customer1.getSavings().getBalance() + amount4;
        transactionManagerTest4.pay();
        double actualBalance = customer1.getSavings().getBalance();
        assertEquals(expectedBalance, actualBalance, .01);
    }

    //Tests to make sure amount that the account is transferring from is updated appropriately
    TransactionManager transactionManagerTest5 = new TransactionManager(customer1, customer1, "TRANSFER",
            customer1.getChecking(), customer1.getSavings(), amount4);
    @org.junit.Test
    public void testTransferFromAccount_checkAmount() {
        double expectedBalance = customer1.getChecking().getBalance() - amount4;
        transactionManagerTest5.pay();
        double actualBalance = customer1.getChecking().getBalance();
        assertEquals(expectedBalance, actualBalance, .01);
    }

    //Withdraw more than what is in the account
    //2000 from account with 341.33
    @org.junit.Test
    public void testWithdrawGreaterThanBalance_checkFalse() {
        assertFalse(customer3.getChecking().withdraw(2000));
    }

    //Withdraw normal amount
    @org.junit.Test
    public void testWithdrawLessThanBalance_checkTrue() {
        assertTrue(customer3.getChecking().withdraw(300));
    }

}