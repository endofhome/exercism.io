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
        String result = getNumber();
        return result.substring(0, 3);
    }

    private String getLocalNumber() {
        String result = getNumber();
        return result.substring(3);
    }

    public String pretty() {
        String localNumber = getLocalNumber();
        String prettyLocalNumber = String.format("%s-%s", localNumber.substring(0, 3), localNumber.substring(3));
        return String.format("(%s) %s", getAreaCode(), prettyLocalNumber);
    }
}
