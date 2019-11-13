public class Robot {

    public Robot() {
    }

    public String getName() {
        return String.format("%c%c%d%d%d",
                upperCaseLetter(),
                upperCaseLetter(),
                digit(),
                digit(),
                digit()
        );
    }

    private Character upperCaseLetter() {
        return (char) ((65 + Math.random() * 26));
    }

    private Integer digit() {
        return (int) (Math.random() * 10);
    }

    public void reset() {
        throw new IllegalArgumentException("");
    }
}
