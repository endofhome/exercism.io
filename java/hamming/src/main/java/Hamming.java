public class Hamming {

    public static Integer compute(String baseStrand, String compareStrand) {
        validateStrandLengths(baseStrand, compareStrand);
        int hammingDistance = 0;
        for (int i=0; i < baseStrand.length(); i++) {
            if (baseStrand.charAt(i) != compareStrand.charAt(i)) {
                hammingDistance++;
            }
        }
        return hammingDistance;
    }

    private static void validateStrandLengths(String baseStrand, String compareStrand) {
        if (baseStrand.length() != compareStrand.length()) {
            throw new IllegalArgumentException("Strands are not the same length");
        }
    }
}
