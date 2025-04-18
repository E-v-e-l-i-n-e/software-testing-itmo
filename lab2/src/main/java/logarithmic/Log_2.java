package logarithmic;

import trigonometric.Sin;
import static logarithmic.Ln.ln;

public class Log_2 {
    public static double log_2(double x, double eps) {
        return ln(x, eps) / ln(2, eps);
    }

}
