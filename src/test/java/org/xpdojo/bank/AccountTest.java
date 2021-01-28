package org.xpdojo.bank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    public void depositNegativeAmount() {
        Account account = new Account();

        Exception exception = assertThrows(UnsupportedOperationException.class, () -> {
            account.deposit(-1);
        });

        String expectedMessage = "Deposit of negative amount not permitted.";
        String actualMessage = exception.getMessage();

        assertThat(actualMessage).isEqualTo(expectedMessage);
    }

    @Test
    public void withdrawAnAmountToDecreaseTheBalance() {

        Account account = new Account();
        account.deposit(100);
        account.withdrawal(60);

        assertThat(account.getBalance()).isEqualTo(40);
    }

    @Test
    public void withdrawFullAmountFromAccount() {

        Account account = new Account();
        account.deposit(100);
        account.withdrawal(100);

        assertThat(account.getBalance()).isEqualTo(0);
    }

    @Test
    public void withdrawAmountGreaterThanAvailableInAccount() {

        Account account = new Account();
        account.deposit(100);

        Exception exception = assertThrows(UnsupportedOperationException.class, () -> {
            account.withdrawal(101);
        });

        String expectedMessage = "Account does not contain enough funds to complete withdrawal.";
        String actualMessage = exception.getMessage();

        assertThat(actualMessage).isEqualTo(expectedMessage);
    }
}
