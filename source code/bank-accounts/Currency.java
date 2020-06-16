public class Currency {
    protected String code;
    protected String centralBankName;
    protected int value;

    public Currency(String code, String centralBankName, int value) {
        this.code = code;
        this.centralBankName = centralBankName;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
