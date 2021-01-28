package org.xpdojo.bank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    @Test
    public void createNewAccount() {
        Account account = new Account();
        assertThat(account.getBalance()).isEqualTo(0);
    }

    @Test
    public void depositAnAmountToIncreaseTheBalance() {
        Account account = new Account();
        account.deposit(100);
        assertThat(account.getBalance()).isEqualTo(100);
    }

    @Test
    public void depositMultipleAmounts() {
        Account account = new Account();
        account.deposit(100);
        account.deposit(200);
        assertThat(account.getBalance()).isEqualTo(300);
    }

    @Test
    public void withdrawAnAmountToDecreaseTheBalance() {

//        Account account = new Account();
//        account.deposit(100);
//        account.with(100);
//
//        assertThat(account.getBalance()).isEqualTo(amountOf(4.0d));
    }
}
