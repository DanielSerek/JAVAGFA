import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<BankAccount> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void createAccount(BankAccount account) {
        if(account != null) accounts.add(account);
    }

    public int getAllMoney() {
        int sum = 0;
        for (BankAccount account : accounts) {
            sum += account.getCurrency().getValue();
        }
        return sum;
    }
}
