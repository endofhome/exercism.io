public class Bob {

    public String hey(String input) {
        if (input.equals("")) {
            return "Fine. Be that way!";
        }
        if (input.equals(input.toUpperCase()) && !input.equals(input.toLowerCase())) {
            return "Whoa, chill out!";
        }
        if (input.endsWith("?")) {
            return "Sure.";
        }
        return "Whatever.";
    }

}
