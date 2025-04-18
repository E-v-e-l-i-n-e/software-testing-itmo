package trigonometric;

import static trigonometric.Sin.sin;

public class Cos {

    public static double cos(double x, double eps) {
        return sin( Math.PI/2 - x, eps);
    }
}
