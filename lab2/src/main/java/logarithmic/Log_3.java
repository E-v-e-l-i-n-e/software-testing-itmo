package logarithmic;

import static logarithmic.Ln.ln;

public class Log_3 {
    public static double log_3(double x, double eps) {
        return ln(x, eps) / ln(3, eps);
    }
}
