package org.xpdojo.bank;

import lombok.Data;

@Data
public class Account {

    int balance = 0;

    public void deposit(int amount) {
        balance += amount;
    }
}
