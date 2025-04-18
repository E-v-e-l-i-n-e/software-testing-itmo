package func;

import static logarithmic.Ln.ln;
import static logarithmic.Log_2.log_2;
import static logarithmic.Log_3.log_3;
import static trigonometric.Cos.cos;
import static trigonometric.Sec.sec;
import static trigonometric.Sin.sin;
import static trigonometric.Tan.tan;

public class Func {
    public static double function(double x, double eps) {
        if (x <= 0) {
            if (x == 0 || (x % Math.PI) == 0) throw new IllegalArgumentException("Невозможно вычислить функцию в точке");
            return (((((cos(x, eps) * sec(x, eps)) + tan(x, eps)) + ((sin(x, eps) - tan(x, eps)) + sin(x, eps)))
                    / sin(x, eps))
                    / cos(x, eps));
        }
        return ((Math.pow(Math.pow(Math.pow(ln(x, eps), 2), 3), 3) - log_3(x, eps)) / log_2(x, eps));
    }
}
