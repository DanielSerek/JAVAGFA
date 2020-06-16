public class BankAccount {
    private String name;
    private String PIN;
    private Currency currency;

    public BankAccount(String name, String PIN, Currency currency) {
        this.name = name;
        this.PIN = PIN;
        this.currency = currency;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void deposit(int input) {
        if(input > 0) {
            currency.setValue(currency.getValue() + input);
        }
    }

    public int withdraw(String PINinput, int amount) {
        if(PIN == PINinput && amount <= currency.getValue()){
            int deduct = currency.getValue() - amount;
            currency.setValue(deduct);
            return amount;
        }
        return 0;
    }
}
