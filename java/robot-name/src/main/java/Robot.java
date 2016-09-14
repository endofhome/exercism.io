import java.util.Random;

public class Robot {

    private final Random random;
    private String name;

    public Robot() {
        this.name = "";
        this.random = new Random();
        generateName();
    }

    public String getName() {
        return name.toUpperCase();
    }

    public void generateName() {
        addLetters(2);
        addNumbers(3);
    }

    private String addLetters(int times) {
        for (int i=0; i < times; i++) {
            name += (char) (random.nextInt(26) + 'a');
        }
        return name;
    }

    private String addNumbers(int times) {
        for (int i=0; i < times; i++) {
            Integer randomNum = random.nextInt(9);
            name += randomNum.toString().charAt(0);
        }
        return name;
    }

    public void reset() {
        name = "";
        generateName();
    }

}
