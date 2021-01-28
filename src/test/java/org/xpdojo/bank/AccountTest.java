package org.xpdojo.bank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {

    @Test
    public void createNewAccount() {
        Account account = Account.emptyAccount();
        assertThat(account.getBalance()).isEqualTo(0);
    }

    @Test
    public void depositAnAmountToIncreaseTheBalance() {
        Account account = Account.emptyAccount();
        account.deposit(100);
        assertThat(account.getBalance()).isEqualTo(100);
    }

    @Test
    public void depositMultipleAmounts() {
        Account account = Account.emptyAccount();
        account.deposit(100);
        account.deposit(200);
        assertThat(account.getBalance()).isEqualTo(300);
    }

    @Test
    public void depositNegativeAmount() {
        Account account = Account.emptyAccount();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-1);
        });

        String expectedMessage = "Deposit of negative amount not permitted.";
        String actualMessage = exception.getMessage();

        assertThat(actualMessage).isEqualTo(expectedMessage);
    }

    @Test
    public void withdrawAnAmountToDecreaseTheBalance() {

        Account account = Account.accountWithAmount(100);
        account.withdraw(60);

        assertThat(account.getBalance()).isEqualTo(40);
    }

    @Test
    public void withdrawFullAmountFromAccount() {

        Account account = Account.accountWithAmount(100);
        account.withdraw(100);

        assertThat(account.getBalance()).isEqualTo(0);
    }

    @Test
    public void withdrawAmountGreaterThanAvailableInAccount() {

        Account account = Account.accountWithAmount(100);

        Exception exception = assertThrows(UnsupportedOperationException.class, () -> {
            account.withdraw(101);
        });

        String expectedMessage = "Account does not contain enough funds to complete withdrawal.";
        String actualMessage = exception.getMessage();

        assertThat(actualMessage).isEqualTo(expectedMessage);
    }

    @Test
    public void transferMoneyFromOneAccountToAnotherShouldPass() {

        Account sourceAccount = Account.accountWithAmount(10);
        Account destinationAccount = Account.emptyAccount();

        sourceAccount.transfer(6, destinationAccount);

        assertThat(sourceAccount.getBalance()).isEqualTo(4);
        assertThat(destinationAccount.getBalance()).isEqualTo(6);
    }

    @Test
    public void transferMoneyFromOneAccountToAnotherShouldFail() {

        Account sourceAccount = Account.emptyAccount();
        Account destinationAccount = Account.emptyAccount();

        Exception exception = assertThrows(UnsupportedOperationException.class, () -> {
            sourceAccount.transfer(6, destinationAccount);
        });

        String expectedMessage = "Source account does not contain enough funds to complete transfer.";
        String actualMessage = exception.getMessage();

        assertThat(actualMessage).isEqualTo(expectedMessage);
    }
}
