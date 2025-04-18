import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static logarithmic.Ln.ln;
import static org.junit.jupiter.api.Assertions.*;


public class LnTest {
    private static final double EPS = 1e-3;
    private static final double EPS2 = 1e-8;

    @Test
    void lnOfOne() {
        assertEquals(0.0, ln(1.0, EPS2), EPS);
    }

    @Test
    void lnOfE() {
        assertEquals(1.0, ln(Math.E, EPS2), EPS);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.5, 2.0, 10.0, 100.0})
    void lnOfPositiveNumbers(double x) {
        double expected = Math.log(x);
        assertEquals(expected, ln(x, EPS2), EPS);
    }

    @Test
    void lnOfVerySmallNumber() {
        double x = 1e-2;
        double expected = Math.log(x);
        assertEquals(expected, ln(x, EPS2), EPS);
    }


    @ParameterizedTest
    @ValueSource(doubles = {0.0, -1.0, -100.0, Double.NEGATIVE_INFINITY})
    void lnOfInvalidValues(double x) {
        assertThrows(IllegalArgumentException.class, () -> ln(x, EPS2));
    }

}
