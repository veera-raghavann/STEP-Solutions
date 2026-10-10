import java.util.HashMap;
import java.util.Map;

abstract class BankAccount {
    protected final String id;
    protected int balance;

    protected BankAccount(String id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    public abstract boolean canWithdraw(int amount);

    public String withdraw(int amount) {
        if (amount <= 0) {
            return id + " rejected: amount must be positive";
        }

        if (!canWithdraw(amount)) {
            return this instanceof SavingsAccount
                ? id + " rejected: minimum balance 1000"
                : id + " rejected: overdraft limit 5000";
        }

        balance -= amount;
        return id + " balance " + balance;
    }
}

class SavingsAccount extends BankAccount {
    public SavingsAccount(String id, int balance) {
        super(id, balance);
    }

    @Override
    public boolean canWithdraw(int amount) {
        return balance - amount >= 1000;
    }
}

class CurrentAccount extends BankAccount {
    public CurrentAccount(String id, int balance) {
        super(id, balance);
    }

    @Override
    public boolean canWithdraw(int amount) {
        return balance - amount >= -5000;
    }
}

public class BankAccountWithdrawalSystem {
    public static void main(String[] args) {
        Map<String, BankAccount> accounts = new HashMap<>();
        accounts.put("S1", new SavingsAccount("S1", 5000));
        System.out.println(accounts.get("S1").withdraw(4500));

        accounts.put("C1", new CurrentAccount("C1", 2000));
        System.out.println(accounts.get("C1").withdraw(6000));
        System.out.println(accounts.get("S1").withdraw(3000));
        System.out.println(accounts.get("C1").withdraw(2000));
    }
}

// Each withdrawal is O(1) average with a hash map lookup; storage is O(a).
