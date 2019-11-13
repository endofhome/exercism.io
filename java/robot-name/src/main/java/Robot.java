public class Robot {
    private String name = initialiseName();

    public Robot() {
    }

    public String getName() {
        return name;
    }

    public void reset() {
        name = initialiseName();
    }

    private String initialiseName() {
        return String.format("%c%c%d%d%d",
                upperCaseLetter(),
                upperCaseLetter(),
                digit(),
                digit(),
                digit()
        );
    }

    private Character upperCaseLetter() {
        int firstAsciiUpperCaseLetterCode = 65;
        int totalNumberOfLetters = 26;
        return (char) (firstAsciiUpperCaseLetterCode + (Math.random() * totalNumberOfLetters));
    }

    private Integer digit() {
        int maximumDigit = 9;
        int zeroBasedAdjustment = 1;
        return (int) (Math.random() * (maximumDigit + zeroBasedAdjustment));
    }
}
