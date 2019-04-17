package bankAccount;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class BankAccountTest {

    private BankAccount bankAccount;

    @Before
    public void before() {
        this.bankAccount = new BankAccount("PESHO", new BigDecimal(100.0));
    }

    @Test
    public void getName() {
        Assert.assertEquals("PESHO", this.bankAccount.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNameShouldThrowWithLess() {
        new BankAccount("AB", new BigDecimal(100));
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNameShouldThrowWithMore() {
        new BankAccount("ABCDEABCDEABCDEABCDEABCDEABCDEK", new BigDecimal(100));
    }

    @Test(expected = IllegalArgumentException.class)
    public void setBalanceShouldThrowExceptionWithNegativeNumber() {
        new BankAccount("asss", new BigDecimal(-10));
    }

    @Test
    public void getBalanced() {
        Assert.assertEquals(new BigDecimal(100.0), this.bankAccount.getBalance());
    }

    @Test
    public void deposit() {
        this.bankAccount.deposit(new BigDecimal(100.0));
        Assert.assertEquals(new BigDecimal(200.0), this.bankAccount.getBalance());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void depositShouldThrow() {
        this.bankAccount.deposit(new BigDecimal(-100.0));
    }

    @Test
    public void withdrawShouldReturnCorrectly() {
        BigDecimal bigDecimal = this.bankAccount.withdraw(new BigDecimal(50));
        Assert.assertEquals(new BigDecimal(50), bigDecimal);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void withdrawShouldThrowIfNotEnoughMoney() {
        this.bankAccount.withdraw(new BigDecimal(200));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void withdrawShouldThrowIfNegativeMoney() {
        this.bankAccount.withdraw(new BigDecimal(-1));
    }

    @Test
    public void withdrawShouldSetCorrectly() {
        this.bankAccount.withdraw(new BigDecimal(50));
        Assert.assertEquals(new BigDecimal(50), this.bankAccount.getBalance());
    }
}