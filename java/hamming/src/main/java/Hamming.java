public class Hamming {

    public static Integer compute(String baseStrand, String compareStrand) {
        int hammingDistance = 0;
        for (int i=0; i < baseStrand.length(); i++) {
            if (baseStrand.charAt(i) != compareStrand.charAt(i)) {
                hammingDistance++;
            }
        }
        return hammingDistance;
    }
}
