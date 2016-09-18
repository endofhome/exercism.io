public class PhoneNumber {

    private String number;

    public PhoneNumber (String number) {
        this.number = number;
    }

    public String getNumber() {
        String result = cleanNumber(number);
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

    private String cleanNumber(String number) {
        String cleanedNumber = number.replaceAll("[()-/ .]", "");
        return cleanedNumber;
    }

    public String getAreaCode() {
        return getNumber().substring(0, 3);
    }

    private String getLocalNumber() {
        return getNumber().substring(3);
    }

    public String pretty() {
        String localNumber = getLocalNumber();
        String prettyLocalNumber = String.format("%s-%s", localNumber.substring(0, 3), localNumber.substring(3));
        return String.format("(%s) %s", getAreaCode(), prettyLocalNumber);
    }
}
