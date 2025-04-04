import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TangentTest {
    private final Tangent tg = new Tangent();

    @Test
    @DisplayName("tan(0)")
    public void testTanZero() {
        double result = tg.tangent(0, 7);
        assertEquals(0.0, result, 1e-9);
    }

    @Test
    @DisplayName("tan(2Pi)")
    public void testTan2Pi() {
        double result = tg.tangent(2 * Math.PI, 7);
        assertEquals(0, result, 1e-9);
    }

    @Test
    @DisplayName("tan(10Pi)")
    public void testTan10Pi() {
        double result = tg.tangent(10 * Math.PI, 7);
        assertEquals(0, result, 1e-9);
    }
    @Test
    @DisplayName("tan(-2Pi)")
    public void testTanMinus2Pi() {
        double result = tg.tangent(-2 * Math.PI, 7);
        assertEquals(0, result, 1e-9);
    }

    @Test
    @DisplayName("tan(-10Pi)")
    public void testTanMinus10Pi() {
        double result = tg.tangent(-10 * Math.PI, 7);
        assertEquals(0, result, 1e-9);
    }

    @Test
    @DisplayName("tan(pi/4)")
    public void testTanPiDiv4() {
        double result = tg.tangent(Math.PI / 4, 7);
        assertEquals(1.0, result, 1e-4);
    }

    @Test
    @DisplayName("tan(-pi/4)")
    public void testMinusTanPiDiv4() {
        double result = tg.tangent(-Math.PI/4, 7);
        assertEquals(-1.0, result, 1e-4);
    }

    @Test
    @DisplayName("tan(5pi/4)")
    public void testTan5PiDiv4() {
        double result = tg.tangent(5 * Math.PI / 4, 7);
        assertEquals(1.0, result, 1e-4);
    }

    @Test
    @DisplayName("tan(-5pi/4)")
    public void testTanMinus5PiDiv4() {
        double result = tg.tangent(-5 * Math.PI / 4, 7);
        assertEquals(-1.0, result, 1e-4);
    }

    @Test
    @DisplayName("tan(pi/6)")
    public void testTanPiDiv6() {
        double result = tg.tangent(Math.PI/6, 7);
        assertEquals(Math.tan(Math.PI / 6), result, 1e-6);
    }

    @Test
    @DisplayName("tan(-pi/6)")
    public void testTanMinusPiDiv6() {
        double result = tg.tangent(-Math.PI/6, 7);
        assertEquals(Math.tan(-Math.PI / 6), result, 1e-6);
    }

    @Test
    @DisplayName("tan(7pi/6)")
    public void testTan7PiDiv6() {
        double result = tg.tangent(7* Math.PI/6, 7);
        assertEquals(Math.tan(7 * Math.PI / 6), result, 1e-6);
    }

    @Test
    @DisplayName("tan(13pi/6)")
    public void testTan13PiDiv6() {
        double result = tg.tangent(13 * Math.PI/6, 7);
        assertEquals(Math.tan(13 * Math.PI / 6), result, 1e-6);
    }

    @Test
    @DisplayName("tan(pi/3)")
    public void testTanPiDiv3() {
        double result = tg.tangent(Math.PI / 3, 7);
        assertEquals(Math.tan(Math.PI / 3), result, 1e-2);
    }

    @Test
    @DisplayName("tan(-pi/3)")
    public void testTanMinusPiDiv3() {
        double result = tg.tangent(Math.PI / 3, 7);
        assertEquals(Math.tan(Math.PI / 3), result, 1e-2);
    }

    @Test
    @DisplayName("tan(pi/2)")
    public void testTanPiDiv2() {
        assertThrows(
                IllegalArgumentException.class,
                () -> tg.tangent(Math.PI / 2, 7),
                "Тангенс не сходится"
        );
    }

    @Test
    @DisplayName("tan(-pi/2)")
    public void testTanMinusPiDiv2() {
        assertThrows(
                IllegalArgumentException.class,
                () -> tg.tangent(-Math.PI / 2, 7),
                "Тангенс не сходится"
        );
    }

    @Test
    @DisplayName("tan(pi/2-eps)")
    public void testTanPiDiv2MunisEps() {
        double eps = 0.1;
        double result = tg.tangent((Math.PI / 2) - eps, 7);
        assertEquals(Math.tan((Math.PI / 2) - eps), result, 4);
    }

    @Test
    @DisplayName("tan(pi/2+eps)")
    public void testTanPiDiv2PlusEps() {
        double eps = 0.1;
        double result = tg.tangent((Math.PI / 2) + eps, 7);
        assertEquals(Math.tan((Math.PI / 2) + eps), result, 4);
    }

    @Test
    @DisplayName("tan(-pi/2+eps)")
    public void testTanMinusPiDiv2PlusEps() {
        double eps = 0.1;
        double result = tg.tangent((-Math.PI / 2) + eps, 7);
        assertEquals(Math.tan((-Math.PI / 2) + eps), result, 4);
    }

    @Test
    @DisplayName("tan(-pi/2-eps)")
    public void testTanMinusPiDiv2PMinusEps() {
        double eps = 0.1;
        double result = tg.tangent((-Math.PI / 2) - eps, 7);
        assertEquals(Math.tan((-Math.PI / 2) - eps), result, 4);
    }

    @Test
    @DisplayName("tan(infinity)")
    public void testTanInfinity() {
        assertThrows(
                IllegalArgumentException.class,
                () -> tg.tangent(Double.POSITIVE_INFINITY, 7),
                "x не может быть Infinity или NaN"
        );
    }

    @Test
    @DisplayName("tan(-infinity)")
    public void testTanMinusInfinity() {
        assertThrows(
                IllegalArgumentException.class,
                () -> tg.tangent(Double.NEGATIVE_INFINITY, 7),
                "x не может быть Infinity или NaN"
        );
    }

    @Test
    @DisplayName("tan(NaN)")
    public void testTanNaN() {
        assertThrows(
                IllegalArgumentException.class,
                () -> tg.tangent(Double.NaN, 7),
                "x не может быть Infinity или NaN"
        );
    }
}
