public class PhoneNumber {

    private String number;

    public PhoneNumber (String number) {
        this.number = number;
    }

    public String getNumber() {
        return number.replaceAll("[()-/ .]", "");
    }

    public String getAreaCode() {
        return null;
    }

    public String pretty() {
        return null;
    }
}
