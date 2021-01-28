package org.xpdojo.bank;

import lombok.Data;

@Data
public class Account {

    int balance = 0;

    public void deposit(int amount) {

        if (amount < 0) {
            throw new UnsupportedOperationException("Deposit of negative amount not permitted.");
        }

        balance += amount;
    }

    public void withdrawal(int amount) {

        if (balance >= amount) {
            balance -= amount;
            return;
        }

        throw new UnsupportedOperationException("Account does not contain enough funds to complete withdrawal.");
    }
}
