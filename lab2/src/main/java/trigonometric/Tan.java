package trigonometric;

import static trigonometric.Cos.cos;
import static trigonometric.Sin.sin;

public class Tan {
    public static double tan(double x, double eps) {
//        if (x % (Math.PI / 2) == 0 ) throw new IllegalArgumentException("Невозможно определить тангенс");
        return sin(x, eps) / cos(x, eps);
    }
}
