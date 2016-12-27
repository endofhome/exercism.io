import org.junit.Assert;
import org.junit.Ignore
import org.junit.Test;

class RnaTranscriptionTest {

    @Test
    fun emptyDnaIsEmptyRna() {
        Assert.assertEquals("", RnaTranscription.ofDna(""));
    }

    @Ignore
    @Test
    fun cytosineIsGuanine() {
        Assert.assertEquals("G", RnaTranscription.ofDna("C"));
    }

    @Ignore
    @Test
    fun guanineIsCytosine() {
        Assert.assertEquals("C", RnaTranscription.ofDna("G"));
    }

    @Ignore
    @Test
    fun thymineIsAdenine() {
        Assert.assertEquals("A", RnaTranscription.ofDna("T"));
    }

    @Ignore
    @Test
    fun adenineIsUracil() {
        Assert.assertEquals("U", RnaTranscription.ofDna("A"));
    }

    @Ignore
    @Test
    fun rnaTranscription() {
        Assert.assertEquals("UGCACCAGAAUU", RnaTranscription.ofDna("ACGTGGTCTTAA"));
    }
}