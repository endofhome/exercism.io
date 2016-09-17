public class PhoneNumber {

    private String number;

    public PhoneNumber (String number) {
        this.number = number;
    }

    public String getNumber() {
        String result = number;
        if (result.length() == 11 && result.charAt(0) == '1') {
            result = result.substring(1);
        }
        return result.replaceAll("[()-/ .]", "");
    }

    public String getAreaCode() {
        return null;
    }

    public String pretty() {
        return null;
    }
}
