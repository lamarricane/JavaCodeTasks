package task.module_3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentBank {
    private final List<BankAccount> accounts;
    private final Lock bankLock;

    public ConcurrentBank() {
        this.accounts = new ArrayList<>();
        this.bankLock = new ReentrantLock();
    }

    public BankAccount createAccount(double balance) {
        if (balance <= 0) {
            throw new IllegalArgumentException("Balance must be greater than 0!");
        }
        bankLock.lock();
        try {
            int accountNumber = accounts.size() + 1;
            BankAccount account = new BankAccount(accountNumber, balance);
            accounts.add(account);
            return account;
        } finally {
            bankLock.unlock();
        }
    }

    public void transfer(BankAccount from, BankAccount to, double amount) {
        if (from == to) {
            throw new IllegalArgumentException("Cannot transfer to the same account!");
        }

        Lock firstLock = from.getLock();
        Lock secondLock = to.getLock();

        if (from.getAccountId() < to.getAccountId()) {
            firstLock.lock();
            secondLock.lock();
        } else {
            secondLock.lock();
            firstLock.lock();
        }

        try {
            if (from.getBalance() >= amount) {
                from.withdraw(amount);
                to.deposit(amount);
            } else {
                throw new IllegalArgumentException("Insufficient balance for transfer");
            }
        } finally {
            firstLock.unlock();
            secondLock.unlock();
        }
    }

    public double getTotalBalance() {
        bankLock.lock();
        try {
            double total = 0;
            for (BankAccount account : accounts) {
                total += account.getBalance();
            }
            return total;
        } finally {
            bankLock.unlock();
        }
    }
}
