package bankAccount;

import java.math.BigDecimal;

public class BankAccount {
    private String name;
    private BigDecimal balance;

    public BankAccount(String name, BigDecimal balance) {
        this.setName(name);
        this.setBalance(balance);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String value) {

        if (value.length() < 3 || value.length() > 25) {
            throw new IllegalArgumentException("Invalid name length");
        }

        this.name = value;

    }

    public BigDecimal getBalance() {
        return this.balance;

    }

    private void setBalance(BigDecimal value) {

        if (value.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Balance must be positive!");
        }

        this.balance = value;

    }

    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new UnsupportedOperationException("Amount must be positive");
        }

        this.setBalance(getBalance().add(amount));
    }

    public BigDecimal withdraw(BigDecimal amount) {
        if (this.getBalance().compareTo(amount) < 0 || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new UnsupportedOperationException("Amount must be more than 0 and less than your balance");
        }

        this.setBalance(this.getBalance().subtract(amount));
        return amount;
    }
}
