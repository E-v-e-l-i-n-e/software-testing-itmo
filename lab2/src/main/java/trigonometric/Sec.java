package trigonometric;

import static trigonometric.Cos.cos;

public class Sec {
    public static double sec(double x, double eps) {
        if (x == 1 || x == -1) throw new IllegalArgumentException("Невозможно определить sec");
        return 1 / cos(x, eps);
    }
}
