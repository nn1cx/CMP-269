import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    void testPassingGrade() {
        LehmanGradeBook gb = new LehmanGradeBook();
        assertTrue(gb.isPassing(70), "A grade of 70 should pass.");
    }

    @Test
    void testGradeA() {
        LehmanGradeBook gb = new LehmanGradeBook();
        assertEquals('A', gb.getLetterGrade(95));
        assertEquals('A', gb.getLetterGrade(90));
    }

    @Test
    void testGradeB() {
        LehmanGradeBook gb = new LehmanGradeBook();
        assertEquals('B', gb.getLetterGrade(80));
    }

    @Test
    void testGradeC() {
        LehmanGradeBook gb = new LehmanGradeBook();
        assertEquals('C', gb.getLetterGrade(70));
    }

    @Test
    void testGradeF() {
        LehmanGradeBook gb = new LehmanGradeBook();
        assertEquals('F', gb.getLetterGrade(50));
    }

    @Test
    void testInvalidGradeThrowsException() {
        LehmanGradeBook gb = new LehmanGradeBook();
        assertThrows(IllegalArgumentException.class, () -> {
            gb.isPassing(150);
        });
    }
}
