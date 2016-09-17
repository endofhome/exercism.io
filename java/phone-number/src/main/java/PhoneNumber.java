public class PhoneNumber {

    private String number;

    public PhoneNumber (String number) {
        this.number = number;
    }

    public String getNumber() {
        String result = number;
        result = result.replaceAll("[()-/ .]", "");
        if (result.length() == 11) {
            if (result.charAt(0) == '1') {
                return result.substring(1);
            }
        }
        if (result.length() != 10) {
            return "0000000000";
        } else {
            return result;
        }
    }

    public String getAreaCode() {
        return null;
    }

    public String pretty() {
        return null;
    }
}
