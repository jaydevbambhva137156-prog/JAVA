// Shared resource class
class BankAccount {
    private int balance = 1000;

    // Synchronized method ensures thread safety
    public synchronized void withdraw(String threadName, int amount) {
        if (balance >= amount) {
            System.out.println(threadName + " is about to withdraw $" + amount);
            try {
                Thread.sleep(500); // Simulating transaction processing delay
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            balance -= amount;
            System.out.println(threadName + " completed withdrawal. Remaining Balance: $" + balance);
        } else {
            System.out.println(threadName + " tried to withdraw $" + amount + " but INSUFFICIENT BALANCE! Balance: $" + balance);
        }
    }
}

// Runnable task for threads
class AccountUser implements Runnable {
    private BankAccount account;
    private int withdrawAmount;

    public AccountUser(BankAccount account, int withdrawAmount) {
        this.account = account;
        this.withdrawAmount = withdrawAmount;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        account.withdraw(name, withdrawAmount);
    }
}

public class ThreadSyncDemo {
    public static void main(String[] args) {
        // Shared bank account with $1000 balance
        BankAccount sharedAccount = new BankAccount();

        // Create task where each user tries to withdraw $700
        AccountUser task = new AccountUser(sharedAccount, 700);

        // Create two threads accessing the same account object
        Thread user1 = new Thread(task, "User-1 (Alice)");
        Thread user2 = new Thread(task, "User-2 (Bob)");

        // Start both threads
        user1.start();
        user2.start();
    }
}