import org.junit.jupiter.api.Test;

import static trigonometric.Sin.sin;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SinTest {
    private static final double EPS = 1e-8;
    private static final double EPS2 = 1e-5;

    @Test
    void sinOfZero() {
        assertEquals(0.0, sin(0, EPS), EPS);
    }

    void sinPi() {
        assertEquals(0.0, sin(Math.PI, EPS), EPS);
    }
    void sinMinusPi() {
        assertEquals(0.0, sin(-Math.PI, EPS), EPS);
    }

    @Test
    void sinPiDiv2() {
        assertEquals(1.0, sin(Math.PI/2, EPS), EPS);
    }
    @Test
    void sinMinusPiDiv2() {
        assertEquals(-1.0, sin(-Math.PI/2, EPS), EPS);
    }
    @Test
    void sin5PiDiv2() {
        assertEquals(1.0, sin(5*Math.PI/2, EPS), EPS);
    }

    @Test
    void sinPiDiv3() {
        assertEquals(0.866025, sin(Math.PI/3, EPS), EPS2);
    }

    @Test
    void sinMinusPiDiv3() {
        assertEquals(-0.866025, sin(-Math.PI/3, EPS), EPS2);
    }

    @Test
    void sinPiDiv6() {
        assertEquals(0.5, sin(Math.PI/6, EPS), EPS);
    }

    @Test
    void sinPiDiv4() {
        assertEquals(0.707107, sin(Math.PI/4, EPS), EPS2);
    }

    @Test
    void sin3PiDiv4() {
        assertEquals(0.707107, sin(3*Math.PI/4, EPS), EPS2);
    }

}
