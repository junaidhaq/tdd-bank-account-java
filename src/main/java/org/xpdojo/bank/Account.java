package org.xpdojo.bank;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Account {

    private int balance;

    public static Account emptyAccount() {
        return new Account(0);
    }

    public static Account accountWithAmount(int amount) {
        return new Account(amount);
    }

    private Account(int startingBalance) {
        this.balance = 0;
        this.deposit(startingBalance);
    }

    public void deposit(int amount) {

        if (amount < 0) {
            throw new IllegalArgumentException("Deposit of negative amount not permitted.");
        }

        balance += amount;
    }

    public void withdraw(int amount) {

        if (balance >= amount) {
            balance -= amount;
            return;
        }

        throw new UnsupportedOperationException("Account does not contain enough funds to complete withdrawal.");
    }

    public void transfer(int amount, Account destinationAccount) {

        if (this.getBalance() >= amount) {
            this.withdraw(amount);
            destinationAccount.deposit(amount);
            return;
        }

        throw new UnsupportedOperationException("Source account does not contain enough funds to complete transfer.");
    }
}
